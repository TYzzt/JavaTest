import lambdaTest.Test;

public class Main {

    private int numPrivate = 0;
    public int numPublic = 0;

    public static void main(String[] args) {
        Main main = new Main();
        Test test = new Test();
        test.hah();
    }

    public void testArray(){
        DD dd = this.new DD();
        dd.loopDoWhile();
        String[][] strings ={
                {"Mr. ", "Mrs. ", "Ms. "},
                {"Smith", "Jones"}
        };
        java.util.Arrays.fill(strings[0],"1");
        System.out.println(strings[0][0]);
    }

    private class DD{
        void loopDoWhile(){
            int count = 1;
            do {
                System.out.println("Count is: " + count);
                count++;
            } while (count < 11);
        }
    }

    public void testNumber(){
        int aNumber = 13;
        if (aNumber >= 0)
            if (aNumber == 0)
                System.out.println("first string");
            else
                System.out.println("second string");
        System.out.println("third string");
    }

    public void polygonFrom(int... corners) {
        int numberOfSides = corners.length;
        for(int i:corners){
            System.out.println(i);
        }
        String name = "namestr";
        System.out.printf("%s: %d, %s%n", name,1,"Name2",1);
        System.out.println("%s");
        // more method body code follows that creates and returns a
        // polygon connecting the Points
    }

    public Bicycle returnBicycle(){
        Bicycle acmeBicycle = new ACMEBicycle();
        return acmeBicycle;
    }

    static class StaticNestedClass {
        public static void main(String[] args) {
            System.out.println("static");
        }
    }
    class InnerClass {
        public  void main(String[] args) {
            System.out.println(numPrivate);
        }
    }
}
