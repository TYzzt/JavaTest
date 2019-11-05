package deleteImage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2019/11/4
 * \* Time: 17:08
 * \* Description:
 * \
 */
public class SearchFileInnerImages {

    private String projectPath; //项目路径
    private List suffixs = Arrays.asList("java", "jsp", "css", "js", "html"); //后缀
    private Pattern c;
    private List<String> filelist; //文件中用到的图片文件路径

    public SearchFileInnerImages(String projectPath, String imagePath) {
        this.projectPath = projectPath;
        this.filelist = new ArrayList<>();
        String regex = imagePath + "/\\S*?(";
        //图片后缀
        List<String> imagesSuffixs = FindImageFiles.suffixs;
        for (String suf : imagesSuffixs) {
            regex += "\\." + suf + "|";
        }
        regex = regex.substring(0, regex.length() - 1);
        regex += ")";
        c = Pattern.compile(regex);
        System.out.println("Regex:" + regex);
    }

    public static void main(String[] args) throws FileNotFoundException {
        SearchFileInnerImages searchFileInnerImages = new SearchFileInnerImages("D:\\InteLiJIDEAspaceComp\\trunk\\cstraining", "images");
        searchFileInnerImages.find("WebRoot/WEB-INF/jsp/FifthSpecial/cwjlSpecial.jsp");

        System.out.println(Arrays.toString(searchFileInnerImages.getFilelist().toArray()));


    }

    public void find(String path) throws FileNotFoundException {

        File f1 = new File(projectPath + "/" + path);
        if (f1.isDirectory()) {
            String s[] = f1.list();
            for (String s1 : s) {
                find(path + "/" + s1);
            }
        } else {
            String fileName = f1.getName();
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (suffixs.contains(suffix)) {
                containImages(f1);
            }
        }
    }

    private void containImages(File file) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        try (FileInputStream f = new FileInputStream(file); InputStreamReader reader = new InputStreamReader(f, StandardCharsets.UTF_8)) {
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Matcher matcher = c.matcher(sb);
        while (matcher.find()) {
            String image = matcher.group();
            if (image.equals("static/common/images/favico")) {
                System.out.println(file.getName());
            }
            filelist.add(image);
        }
    }

    public List<String> getFilelist() {
        return filelist;
    }


}
