package c21;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by ZhaoTao on 2016/8/30.
 */
public class MyFileVisitor extends SimpleFileVisitor<Path> {

    public FileVisitResult visitFile(Path path, BasicFileAttributes attributes) {
        System.out.println(path);
        return FileVisitResult.CONTINUE;
    }

}
