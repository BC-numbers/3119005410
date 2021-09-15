import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimhashTest {

    //词出现最大次数
    private int maxCount = 5;

    //哈希值位数
    private int hashBits = 64;

    //词的出现次数集合
    private Map<String, Integer> wordCount;

    //不参与加权运算的词性
    private List<String> blackNature;

    //参与加权运算词性的权值
    private Map<String, Integer> natureWeight;


    //自定义不同词性的权值，以及是否参与加权运算
    private void setWeight() {
        //w为标点，表示标点不参与运算
        blackNature.add("w");
        //n为名词，表示名词的权值为3
        natureWeight.put("n", 3);
    }

    //构造方法，初始化
    public SimhashTest() {
        wordCount = new HashMap<String, Integer>();
        blackNature = new ArrayList<String>();
        natureWeight = new HashMap<String, Integer>();
    }

    //内容预处理，过滤无关内容
    public String cleanWords(String content) {
        //过滤HTML标签
        content = Jsoup.clean(content, Whitelist.none());
        content = StringUtils.lowerCase(content);
        //过滤符
        String[] tokens = {" ", "\n", "\\r", "\\n", "\\t", "&nbsp;", "\r", "\t"};
        content = content.replaceAll("[^(\\u4e00-\\u9fa5)]", "");
        for (String token : tokens) {
            content = content.replace(token, "");

        }
        return content;
    }



    //计算simhash值
    public BigInteger simHash(String content) {
        content = cleanWords(content);
        setWeight();

        //content内各关键字权值数组，用于合并运算
        int[] array = new int[hashBits];

        //把内容进行分词操作
        List<Term> terms = StandardTokenizer.segment(content);

        for (Term term : terms) {

            //判断该分词是否该被过滤
            boolean flag = wordFilter(term);
            if (flag == true) {
                continue;
            }

            //计算关键词的哈希值
            BigInteger hash = hash(term.word);
            //关键词的权值
            Integer weight = natureWeight.get(term.nature.toString());
            if (null == weight) {
                weight = 1;
            }

            //加权与合并操作
            addWeight(hash, weight, array);

        }

        //降维操作后返回simHash值
        return subDimension(array);
    }





}
