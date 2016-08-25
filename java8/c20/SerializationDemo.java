package c20;

import java.io.*;

/**
 * Created by ZhaoTao on 2016/8/25.
 */
public class SerializationDemo {
    public static void main(String[] args) {
        try (ObjectOutputStream objOStrm = new ObjectOutputStream(
                new FileOutputStream("serial")
        )) {
            MyClass object1 = new MyClass("Hello", -7, 2.7e10);
            System.out.println("object1:" + object1);
            objOStrm.writeObject(object1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream objIStrm = new ObjectInputStream(
                new FileInputStream("serial1")
        )) {
            MyClass object2 = (MyClass) objIStrm.readObject();
            System.out.println("object2:" + object2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static class MyClass implements Serializable {
        String s;
        int i;
        double d;

        public MyClass(String s, int i, double d) {
            this.s = s;
            this.i = i;
            this.d = d;
        }

        @Override
        public String toString() {
            return "MyClass{" +
                    "s='" + s + '\'' +
                    ", i=" + i +
                    ", d=" + d +
                    '}';
        }
    }


}
