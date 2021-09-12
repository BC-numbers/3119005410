package check;
import java.io.*;
import java.util.Scanner;
public class check {
	public static void main(String[] args){
			System.out.println("请输入原文件的地址");
	        System.out.println("请输入测试文件的地址");
	        System.out.println("请输入结果文件的地址");
	
	}
	//键盘输入文件地址
    public static String Input(){
        Scanner input=new Scanner(System.in);
        String address=input.next();
        return address;
    }
    //将文本转化为字符串
    public static String Conver() throws IOException {
        StringBuffer buffer = new StringBuffer();
        String s = null;
        String address = Input();
        BufferedReader bf = new BufferedReader(new FileReader(address));
        while ((s = bf.readLine()) != null) {
            buffer.append(s.trim());
        }
        String str = buffer.toString();//将论文转化为字符串
        String string = str.replaceAll("\\s*", "");//除去字符串中所有空白字符，包括空格、换行等。
        return string;
    }
}
