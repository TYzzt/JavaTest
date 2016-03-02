package annotationTest;

/**
 * Created by ZhaoTao on 2016/1/8.
 */

public class Generation3List {

// class code goes here


    public static void main(String[] args) {
        Generation3List generation3List = new Generation3List();
        generation3List.out();
    }

    @ClassPreamble (
            author = "John Doe",
            date = "3/17/2002",
            currentRevision = 6,
            lastModified = "4/12/2004",
            lastModifiedBy = "Jane Doe",
            // Note array notation
            reviewers = {"Alice", "Bob", "Cindy"}
    )
    public void out(){
        System.out.println("123");
    }



}
