package deleteImage;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2019/11/4
 * \* Time: 17:07
 * \* Description: 过滤删除项目中不再受用的图片文件
 * \
 */
public class Application {

    private static String projectPath = "D:\\InteLiJIDEAspaceComp\\trunk\\cstraining";
    private static String imageProjectPath = projectPath + "\\WebRoot\\static\\common";
    private static String imagePath = "images"; //图片父级文件夹
    private static String copyPath = "D:\\文件\\云学院图片删除备份\\delete"; //备份

    private static String[] searchFilePath = {"common-src", "config-src", "src", "WebRoot"};

    public static void main(String[] args) throws IOException {

        System.out.println("项目地址：" + projectPath);
        System.out.println("图片地址：" + imageProjectPath + "/" + imagePath);

        FindImageFiles findImageFiles = new FindImageFiles(imageProjectPath);
        findImageFiles.find(imagePath);
        List<String> images = findImageFiles.getFilelist();
        System.out.println("寻找到原始图片数量:" + images.size());

        System.out.println("文件地址:" + Arrays.toString(searchFilePath));
        SearchFileInnerImages searchFileInnerImages = new SearchFileInnerImages(projectPath, imagePath);
        for (String s : searchFilePath) {
            searchFileInnerImages.find(s);
        }
        List<String> searchImages = searchFileInnerImages.getFilelist();
        System.out.println("共寻到文件内图片数量:" + searchImages.size());

        int i = 0;
        for (String searchImage : searchImages) {
            if (images.contains(searchImage)) {
                i++;
            } else {
//                System.out.println("无对应："+(searchImage.length()>100?searchImage.substring(0,99):searchImage));
            }
        }
        System.out.println("对应原始图片地址图片数量：" + i);
        i = 0;
        int copy = 0;
        System.out.println("可删除图片地址：START--------------------------");
        for (String image : images) {
            if (searchImages.contains(image)) {
                i++;
            } else {
                File file = new File(imageProjectPath + "/" + image);
                String dir = image;
                String pathArr[] = dir.split("/");
                String dirPath = copyPath;
                for (int i1 = 0; i1 < pathArr.length - 1; i1++) {
                    dirPath += "/" + pathArr[i1];
                    File dirPathFile = new File(dirPath);
                    if (!dirPathFile.exists()) {
                        if (dirPathFile.mkdir()) {
                            System.out.println("创建路径:" + dirPath);
                        }
                    }
                }
                File copyFile = new File(copyPath + "/" + image);
                copyFileUsingFileChannels(file, copyFile);
                copy += 1;
                if (file.delete()) {
                    System.out.println("删除文件：" + image);
                } else {
                    System.out.println("删除文件失败：" + image);
                }
            }
        }
        System.out.println("可删除图片地址：END--------------------------");
        System.out.println("原始图片用到的图片数量：" + i);
        System.out.println("删除数量：" + (images.size() - i));
        System.out.println("备份图片数量：" + copy);


    }

    private static void copyFileUsingFileChannels(File source, File dest) throws IOException {
        if (dest.exists()) {
            return;
        }
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            inputChannel = new FileInputStream(source).getChannel();
            outputChannel = new FileOutputStream(dest).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } finally {
            inputChannel.close();
            outputChannel.close();
        }
    }


}
