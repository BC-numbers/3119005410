package sizeyunsuan;

import java.util.Scanner;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan=new Scanner(System.in);
        String command=null;
        FileOperation fo=new FileOperation();
        CheckGrade judgegrade=new CheckGrade();

        /**
        规定输入格式
         */
        String nr="^\\-n\\s+\\d+\\s+\\-r\\s+\\d+$||^\\-r\\s+\\d+\\s+\\-n\\s+\\d+$";
        String ea="check+$";
        int n = 0;
        int r = 0;
        String exercisesfile=null;
        String answersfile=null;
        System.out.println("-------------------------------------------------");
        System.out.println("-r 控制题目中数值（自然数、真分数和真分数分母）的范围");
        System.out.println("-n 控制生成题目的个数）");
        System.out.println("check 批改并生成成绩文档");
        System.out.println("请按照下面的格式输入命令");
        System.out.println("例：-n 10 -r 10 或 -r 10 -n 10 (-r和-n命令需要一起使用)");
        System.out.println("Tips:完成答题后记得要保存答案，否则无法批改");
        System.out.println("-------------------------------------------------");
        while(scan.hasNextLine()) {
            if (scan.hasNextLine()) {
                command = scan.nextLine();
            }

            /**
            检查命令是否正确
             */
            Pattern pa = Pattern.compile(nr);
            Matcher ma = pa.matcher(command);
            Pattern p = Pattern.compile(ea);
            Matcher m = p.matcher(command);
            if(!(ma.matches()||m.matches())) {
                System.out.println("命令格式错误，请重新输入");
                continue;
            }
            /**
            分割命令
             */
            String[] c=command.split("\\s+");
            if(c[0].equals("-n")&&c[2].equals("-r")) {
                n=Integer.parseInt(c[1]);
                r=Integer.parseInt(c[3]);
                fo.build(n,r);
                System.out.println("练习题目文件Exercises.txt、答案文件Answers.txt以及答题文件,已生成放置在本程序的当前目录下");
                System.out.println("请在开始在答题文件中按格式作答");
                System.out.println("输入 check 检查答案");
            }
            else if(c[0].equals("-r")&&c[2].equals("-n")){
                r=Integer.parseInt(c[1]);
                n=Integer.parseInt(c[3]);
                fo.build(n,r);
                System.out.println("已生成练习题目文档Exercises.txt和答案文件Answers.txt放置在本程序的当前目录下");
                System.out.println("请在开始在答题文件中按格式作答");
                System.out.println("输入 check 检查答案");
            }
            if(c[0].equals("check")) {
                exercisesfile=".\\StuAnswers.txt";
                answersfile=".\\Answers.txt";
                judgegrade.check(exercisesfile,answersfile);
                System.out.println("已为您批改答案，批改文件Grade.txt已生成，放置在本程序的当前目录下，请及时校对答案。");
                System.out.println("请及时保存文件，源文件将清零");
                System.exit(0);
            }

            //归零
            n=0;
            r=0;
        }

    }
}