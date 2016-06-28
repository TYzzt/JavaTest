package c9;

/**
 * Created by ZhaoTao on 2016/6/28.
 */
public class DynStack implements IntStack {
    private int stck[];
    private int tos;

    DynStack(int size) {
        stck = new int[size];
        tos = -1;
    }

    public static void main(String[] args) {
        IntStack stack = new DynStack(10);
        stack.sayHello();
    }

    @Override
    public void push(int item) {
        if (tos == stck.length - 1) {
            int temp[] = new int[stck.length * 2];//double size
            for (int i = 0; i < stck.length; i++) {
                temp[i] = stck[i];
            }
            stck = temp;
            stck[++tos] = item;
        } else {
            stck[++tos] = item;
        }
    }

    @Override
    public int pop() {
        if (tos < 0) {
            System.out.println("Stack underflow.");
            return 0;
        } else {
            return stck[--tos];
        }
    }

    public void sayHello() {
        System.out.println("dyn-hello");
    }
}
