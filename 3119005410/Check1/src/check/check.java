package check;
import java.io.*;
import java.util.Scanner;
public class check {
	public static void main(String[] args){
			System.out.println("������ԭ�ļ��ĵ�ַ");
	        System.out.println("����������ļ��ĵ�ַ");
	        System.out.println("���������ļ��ĵ�ַ");
	
	}
	//���������ļ���ַ
    public static String Input(){
        Scanner input=new Scanner(System.in);
        String address=input.next();
        return address;
    }
    //���ı�ת��Ϊ�ַ���
    public static String Conver() throws IOException {
        StringBuffer buffer = new StringBuffer();
        String s = null;
        String address = Input();
        BufferedReader bf = new BufferedReader(new FileReader(address));
        while ((s = bf.readLine()) != null) {
            buffer.append(s.trim());
        }
        String str = buffer.toString();//������ת��Ϊ�ַ���
        String string = str.replaceAll("\\s*", "");//��ȥ�ַ��������пհ��ַ��������ո񡢻��еȡ�
        return string;
    }
}
