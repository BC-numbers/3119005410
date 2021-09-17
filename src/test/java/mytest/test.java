package mytest;

import org.junit.Test;
import BC.PaperCheck;

public class test {
    PaperCheck d = new PaperCheck();
    @Test
   public void test(){
        d.getRepetiveRate("D:/JAVA/IntelliJ IDEA 2021.2.2/3119005410/src/main/file/orig.txt", "D:/JAVA/IntelliJ IDEA 2021.2.2/3119005410/src/main/file/orig.txt");
    }

    @Test
    public void test2(){
        d.getRepetiveRate("D:/JAVA/IntelliJ IDEA 2021.2.2/3119005410/src/main/file/orig.txt", "D:/JAVA/IntelliJ IDEA 2021.2.2/3119005410/src/main/file/orig_0.8_del.txt");
    }

    @Test
    public void test3(){
        d.getRepetiveRate("D:/JAVA/IntelliJ IDEA 2021.2.2/3119005410/src/main/file/orig_0.8_dis_1.txt", "D:/JAVA/IntelliJ IDEA 2021.2.2/3119005410/src/main/file/orig_0.8_add.txt");
    }
    @Test
    public void test4(){
        d.getRepetiveRate("D:/JAVA/IntelliJ IDEA 2021.2.2/3119005410/src/main/file/orig_0.8_dis_10.txt", "D:/JAVA/IntelliJ IDEA 2021.2.2/3119005410/src/main/file/orig_0.8_add.txt");
    }
    @Test
    public void test5(){
        d.getRepetiveRate("D:/JAVA/IntelliJ IDEA 2021.2.2/3119005410/src/main/file/orig_0.8_dis_15.txt", "D:/JAVA/IntelliJ IDEA 2021.2.2/3119005410/src/main/file/orig_0.8_add.txt");
    }
    @Test
    public void test6(){
        d.getRepetiveRate("D:/JAVA/IntelliJ IDEA 2021.2.2/3119005410/src/main/file/orig.txt", "D:/JAVA/IntelliJ IDEA 2021.2.2/3119005410/src/main/file/orig_0.8_dis_1.txt");
    }
    @Test
    public void test7(){
        d.getRepetiveRate("D:/JAVA/IntelliJ IDEA 2021.2.2/3119005410/src/main/file/orig.txt", "D:/JAVA/IntelliJ IDEA 2021.2.2/3119005410/src/main/file/orig_0.8_dis_10.txt");
    }
    @Test
    public void test8(){
        d.getRepetiveRate("D:/JAVA/IntelliJ IDEA 2021.2.2/3119005410/src/main/file/orig.txt", "D:/JAVA/IntelliJ IDEA 2021.2.2/3119005410/src/main/file/orig_0.8_dis_15.txt");
    }
    @Test
    public void test9(){
        d.getRepetiveRate("D:/JAVA/IntelliJ IDEA 2021.2.2/3119005410/src/main/file/orig_0.8_del.txt", "D:/JAVA/IntelliJ IDEA 2021.2.2/3119005410/src/main/file/orig_0.8_dis_10.txt");
    }
    @Test
    public void test10(){
        d.getRepetiveRate("D:/JAVA/IntelliJ IDEA 2021.2.2/3119005410/src/main/file/orig_0.8_add.txt", "D:/JAVA/IntelliJ IDEA 2021.2.2/3119005410/src/main/file/orig_0.8_dis_15.txt");
    }

}
