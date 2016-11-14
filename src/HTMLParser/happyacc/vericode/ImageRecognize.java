package HTMLParser.happyacc.vericode;

import HTMLParser.happyacc.HappyaccLogin;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2016/11/14
 * \* Time: 8:52
 * \* Description:  识别验证码
 * \
 */
public class ImageRecognize {

    private static String path = "D:\\vercodet\\"; //读取路径
    private static String trainPath = "D:\\vercodet\\train\\";  //学习路径

    public static int isBlack(int colorInt) {
        Color color = new Color(colorInt);
        if (color.getRed() + color.getGreen() + color.getBlue() <= 100) {
            return 1;
        }
        return 0;
    }

    public static int isWhite(int colorInt) {
        Color color = new Color(colorInt);
        if (color.getRed() + color.getGreen() + color.getBlue() > 700) {
            return 1;
        }
        return 0;
    }

    public static int getColorSum(int colorInt) {
        Color color = new Color(colorInt);
        return color.getRed() + color.getGreen() + color.getBlue();
    }

    /**
     * 去除白边
     *
     * @param img
     * @return
     * @throws Exception
     */
    public static BufferedImage removeWhite(BufferedImage img) throws Exception {
        int width = img.getWidth();
        int height = img.getHeight();
        int start = 0;
        int end = 0;
        Label1:
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                if (getColorSum(img.getRGB(x, y)) < 700) {
                    start = y;
                    break Label1;
                }
            }
        }
        Label2:
        for (int y = height - 1; y >= 0; --y) {
            for (int x = 0; x < width; ++x) {
                if (getColorSum(img.getRGB(x, y)) < 700) {
                    end = y;
                    break Label2;
                }
            }
        }
        return img.getSubimage(0, start, width, end - start + 1);
    }

    /**
     * 分割图片
     *
     * @param img
     * @return
     * @throws Exception
     */
    public static List<BufferedImage> splitImage(BufferedImage img)
            throws Exception {
        List<BufferedImage> subImgs = new ArrayList<>();
        int width = img.getWidth();
        int height = img.getHeight();
        List<Integer> weightlist = new ArrayList<>();
        for (int x = 0; x < width; ++x) {
            int count = 0;
            for (int y = 0; y < height; ++y) {
                if (getColorSum(img.getRGB(x, y)) < 500) {
                    count++;
                }
            }
            weightlist.add(count);
        }
        for (int i = 0; i < weightlist.size(); i++) {
            int length = 0;
            while (i < weightlist.size() && weightlist.get(i) > 0) {
                i++;
                length++;
            }
            if (length > 18 && 40 > length) {
                subImgs.add(removeWhite(img.getSubimage(i - length, 0,
                        length, height)));
            }
        }

        return subImgs;
    }

    /**
     * 去除背景与干扰
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static BufferedImage removeGround(File file) throws IOException {

        BufferedImage img = ImageIO.read(file);
        int width = img.getWidth();
        int height = img.getHeight();

        for (int x = 1; x < width - 1; ++x) {
            for (int y = 1; y < height - 1; ++y) {
                if (isBackGround(img.getRGB(x, y))) {
                    img.setRGB(x, y, Color.WHITE.getRGB());
                }
            }
        }
        img = img.getSubimage(1, 1, width - 2, height - 2);
        return img;
    }

    public static boolean isBackGround(int colorInt) {
        Color color = new Color(colorInt);
        if (color.getRed() + color.getGreen() + color.getBlue() > 500) {
            return true;
        }
        return false;
    }


    /**
     * 保存分割图片
     */
    public static void saveSplitImg() throws Exception {
        List<File> listFile = findFiles("jpg", path);
        for (File file : listFile) {
            BufferedImage img = removeGround(file);
            List<BufferedImage> listImg = splitImage(img);
            for (BufferedImage i : listImg) {
                ImageIO.write(i, "jpg", new File(trainPath + Math.random() + ".jpg"));
            }
        }
    }


    /**
     * 查找文件
     *
     * @param filenameSuffix
     * @param currentDirUsed
     * @return
     */
    public static List<File> findFiles(String filenameSuffix, String currentDirUsed) {
        List<File> fileList = new ArrayList<File>();

        File dir = new File(currentDirUsed);
        if (!dir.exists() || !dir.isDirectory()) {
            return null;
        }

        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                /**
                 * 如果目录则递归继续遍历
                 */
                findFiles(filenameSuffix, file.getAbsolutePath());
            } else {
                /**
                 * 如果不是目录。
                 * 那么判断文件后缀名是否符合。
                 */
                if (file.getAbsolutePath().endsWith(filenameSuffix)) {
                    fileList.add(file);
                }
            }
        }

        return fileList;
    }

    public static void downImag(int n) throws IOException {
        for (int i = 0; i < n; i++) {
            HappyaccLogin.getPic("http://www.happyacc.com/md/vericode/securimage_show.php?sid=0.26672960309127003");
        }
    }

    public static void main(String[] args) throws Exception {
        //downImag(50); //下载验证码
        //saveSplitImg(); //保存图片用于学习
    }


}
