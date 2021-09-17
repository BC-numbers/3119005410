package BC;

import BC.utils.GetSimiarityUtil;
import BC.utils.IOUtil;

import java.io.File;

import static BC.utils.IOUtil.textToString;

public class PaperCheck {


    public static void main(String[] args) {


        System.out.println("hello World");
        PaperCheck d = new PaperCheck();
        d.getRepetiveRate("D:/JAVA/IntelliJ IDEA 2021.2.2/3119005410/src/main/file/orig.txt", "D:/JAVA/IntelliJ IDEA 2021.2.2/3119005410src/main/orig_0.8_add.txt");
        //用命令行输入

    }


    /**
     * @param originalPath   原文件路径
     * @param plagiarizePath 抄袭文件路径
     */
    public void getRepetiveRate(String originalPath, String plagiarizePath) {
        File originalFile = new File(originalPath);
        File plagiarizeFile = new File(plagiarizePath);
        String oriStr = textToString(originalPath); //文本转为字符串
        String plagStr = textToString(plagiarizePath);
        if (!originalFile.exists() || !plagiarizeFile.exists()) {  //文件不存在
            return;
        }
        //余弦相似度计算
        GetSimiarityUtil getSimiarityUtil = new GetSimiarityUtil(oriStr, plagStr);
        System.out.println("相似度："+getSimiarityUtil.sim());
        double result = getSimiarityUtil.sim();
        IOUtil.StringToFile("D:/JAVA/IntelliJ IDEA 2021.2.2/3119005410/src/main/file/result.txt", originalPath + "\n" + plagiarizePath + "\n"
                + "相似度 ：" + result);
    }


}
