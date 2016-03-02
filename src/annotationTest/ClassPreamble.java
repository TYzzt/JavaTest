package annotationTest;

import java.lang.annotation.Documented;

/**
 * Created by ZhaoTao on 2016/1/8.
 */
@Documented
@interface ClassPreamble {
    String author();
    String date();
    int currentRevision() default 1;
    String lastModified() default "N/A";
    String lastModifiedBy() default "N/A";
    // Note use of array
    String[] reviewers();
}
