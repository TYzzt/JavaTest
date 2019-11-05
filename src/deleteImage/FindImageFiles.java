package deleteImage;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2019/11/4
 * \* Time: 16:43
 * \* Description: 寻找图片路径
 * \
 */
public class FindImageFiles {

    public static List<String> suffixs = Arrays.asList("jpg", "jpeg", "gif", "png", "PNG", "JPEG", "GIF", "JGP", "ico"); //后缀
    private String projectPath; //项目路径
    private List<String> filelist; //图片文件路径，不包括项目路径

    public FindImageFiles(String projectPath) {
        this.projectPath = projectPath;
        this.filelist = new ArrayList<>();
    }

    public static void main(String[] args) {
        FindImageFiles findImageFiles = new FindImageFiles("D:\\InteLiJIDEAspaceComp\\trunk\\cstraining\\WebRoot");
        findImageFiles.find("static/common/images");
        System.out.println(Arrays.toString(findImageFiles.getFilelist().toArray()));
    }

    public void find(String path) {
        File f1 = new File(projectPath + "/" + path);
        if (f1.isDirectory()) {
            String s[] = f1.list();
            for (String s1 : s) {
                find(path + "/" + s1);
            }
        } else if (isImage(f1)) {
            filelist.add(path);
        }
    }

    //判断是否是图片
    private boolean isImage(File file) {
        String fileName = file.getName();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        return suffixs.contains(suffix);
    }

    public List<String> getFilelist() {
        return filelist;
    }
}
