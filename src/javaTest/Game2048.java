package javaTest;

import java.util.*;

/**
 * Game2048
 * Created by buce on 2017/4/10.
 */
public class Game2048 {
    private static final int[] num = {2, 4};
    private static final Random random = new Random();
    private static final int UP = 4;
    private static final int DOWN = -4;
    private static final int LEFT = 1;
    private static final int RIGHT = -1;
    private static final Map<Integer, Set<Integer>> endMap = new HashMap<>();
    private static int CAPACITY;
    private static int[] container;

    /*
    * [0 ][1 ][2 ][3 ]
    * [4 ][5 ][6 ][7 ]
    * [8 ][9 ][10][11]
    * [12][13][14][15]
    */
    static {
        endMap.put(UP, new HashSet<>(Arrays.asList(12, 13, 14, 15)));
        endMap.put(DOWN, new HashSet<>(Arrays.asList(0, 1, 2, 3)));
        endMap.put(LEFT, new HashSet<>(Arrays.asList(3, 7, 11, 15)));
        endMap.put(RIGHT, new HashSet<>(Arrays.asList(0, 4, 8, 12)));
    }


    private static void init() {
        CAPACITY = 16;
        container = new int[CAPACITY];
        generateNum(2);
        System.out.println("" +
                "* w:上 s:下 a:左 d:右\n" +
                "* q:退出\n" +
                "* r:重新开始" +
                "");
        print("init");
    }

    /**
     * w:上 s:下 a:左 d:右
     * q:退出
     *
     * @param args
     */
    public static void main(String[] args) {
        init();
        while (true) {
            System.out.println("Input your operate:");
            Scanner scanner = new Scanner(System.in);
            String operate = scanner.next();
            try {
                switch (operate) {
                    case "w":
                        up();
                        break;
                    case "s":
                        down();
                        break;
                    case "a":
                        left();
                        break;
                    case "d":
                        right();
                        break;
                    case "r":
                        init();
                        break;
                    case "q":
                        System.exit(0);
                    default:
                        System.out.println("Enter the correct operate!");
                        print("");
                }
            } catch (Exception e) {
                if (!scanContainer()) {
                    System.out.println("You Lose!");
                } else {
                    print("");
                    continue;
                }
            }
        }
    }

    private static void print(String operate) {
        System.out.println("---------" + operate + "---------");
        for (int i = 0; i < container.length; ++i) {
            System.out.print(container[i] + "\t");
            if (((i + 1) % 4) == 0) {
                System.out.println();
            }
        }
    }


    /**
     * 生成数字并填入
     *
     * @param num
     */
    private static void generateNum(int num) {
        int[] numPosition = getPosition(num, Game2048.num.length, true);
        int[] containerPosition = getPosition(num, CAPACITY, false);
        for (int i = 0; i < num; ++i) {
            Game2048.container[getZeroPosition()[containerPosition[i]]] = Game2048.num[numPosition[i]];
            --CAPACITY;
        }

    }

    /**
     * 获取空位
     */
    private static int[] getZeroPosition() {
        int[] position = new int[CAPACITY];
        int j = 0;
        for (int i = 0; i < container.length; i++) {
            if (container[i] == 0) {
                position[j] = i;
                j++;
            }
        }
        return position;
    }


    /**
     * 获取生成数字的位置
     */
    private static int[] getPosition(int num, int length, boolean hasSame) {
        int[] position = new int[num];
        if (hasSame) {
            for (int i = 0; i < num; i++) {
                position[i] = random.nextInt(length);
            }
        } else {
            int tmp;
            for (int i = 0; ; ) {
                tmp = random.nextInt(length);
                if (i > 0) {
                    if (position[i - 1] != tmp) {
                        position[i] = tmp;
                        break;
                    }
                } else {
                    position[i] = tmp;
                    break;
                }
            }
        }
        return position;
    }

    private static boolean scanContainer() {
        boolean result = false;
        for (int i = 0; i < container.length; i++) {
            if (i - 1 > 0 && container[i] == container[i - 1]) {
                result = true;
            }
            if (i - 4 > 0 && container[i] == container[i - 4]) {
                result = true;
            }
            if (i + 1 < 16 && container[i] == container[i + 1]) {
                result = true;
            }
            if (i + 4 < 16 && container[i] == container[i + 4]) {
                result = true;
            }
        }
        return result;
    }

    /*
     * 从第一个元素开始，寻找到第一个不为0的数字，
     * 如果相同，求和，其他元素向操作方向移动，操作反方向第一个元素补0。
     * 递归()
     */
    private static void move(int start, int end, int operate) {
        if (endMap.get(operate).contains(start)) {
            return;
        } else {
            int count = 0;
            for (int j = start; operate > 0 ? j <= end : j >= end; j += operate) {
                if (container[j] == 0) {
                    count++;
                }
            }
            if (count == (Math.abs(end - start) / Math.abs(operate) + 1)) {
                return;
            }
            if (container[start] == 0) {
                for (int i = start; operate > 0 ? i < end : i > end; i += operate) {
                    container[i] = container[i + operate];
                }
                container[end] = 0;
                move(start, end, operate);
            } else {
                if (container[start] == container[start + operate]) {
                    container[start] = container[start] << 1;
                    ++CAPACITY;
                    for (int i = start + operate; operate > 0 ? i < end : i > end; i += operate) {
                        container[i] = container[i + operate];
                    }
                    container[end] = 0;
                }
                start += operate;
                move(start, end, operate);
            }
        }
    }

    private static void up() {
        move(0, 12, UP);
        move(1, 13, UP);
        move(2, 14, UP);
        move(3, 15, UP);
        generateNum(1);
        print("up");
    }

    private static void down() {
        move(12, 0, DOWN);
        move(13, 1, DOWN);
        move(14, 2, DOWN);
        move(15, 3, DOWN);
        generateNum(1);
        print("down");
    }

    private static void left() {
        move(0, 3, LEFT);
        move(4, 7, LEFT);
        move(8, 11, LEFT);
        move(12, 15, LEFT);
        generateNum(1);
        print("left");
    }

    private static void right() {
        move(3, 0, RIGHT);
        move(7, 4, RIGHT);
        move(11, 8, RIGHT);
        move(15, 12, RIGHT);
        generateNum(1);
        print("right");
    }
}
