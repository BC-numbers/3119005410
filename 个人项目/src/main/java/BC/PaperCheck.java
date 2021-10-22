package BC;

import BC.utils.GetSimiarityUtil;
import BC.utils.IOUtil;
import java.io.IOException;


import java.io.File;


import static BC.utils.IOUtil.textToString;

public class PaperCheck {


    public static void main(String[] args) throws IOException {

        String originalPath = textToString(args[0]);
        String plagiarizePath = textToString(args[1]);
        String resultPath = textToString(args[2]);
        PaperCheck d = new PaperCheck();
        d.getRepetiveRate(originalPath,plagiarizePath,resultPath);

    }

    /**
     * @param originalPath   原文件路径
     * @param plagiarizePath 抄袭文件路径
     */
    public void getRepetiveRate(String originalPath, String plagiarizePath , String resultPath) {

        File originalFile = new File(originalPath);
        File plagiarizeFile = new File(plagiarizePath);
        String oriStr = IOUtil.textToString(originalPath); //文本转为字符串
        String plagStr = IOUtil.textToString(plagiarizePath);
        String resStr = IOUtil.textToString(resultPath);
        if (!originalFile.exists() || !plagiarizeFile.exists()) {  //文件不存在
            return;
        }
        //余弦相似度计算
        GetSimiarityUtil getSimiarityUtil = new GetSimiarityUtil(originalPath, plagiarizePath);
        System.out.println("相似度："+getSimiarityUtil.sim());
        double result;
        result = getSimiarityUtil.sim();
        IOUtil.StringToFile("resStr", oriStr + "\n" + plagStr + "\n"
                + "相似度 ：" + result);
    }


}
