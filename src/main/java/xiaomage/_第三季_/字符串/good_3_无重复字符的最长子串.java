package xiaomage._第三季_.字符串;

import com.sun.activation.registries.MailcapParseException;
import com.sun.deploy.security.CachedCertificatesHelper;

import java.util.HashMap;
import java.util.Map;


//TODO 这个题目多想几遍！！！！！！
public class good_3_无重复字符的最长子串 {


    /***
     *
     * 思路====>求以i位置元素结尾的最长无重复子串
     *          遍历每一个元素i，根据以i-1位置元素结尾的最长无重复子串来求以i位置元素结尾的最长无重复子串
     *          li===>以i-1位置字符结尾的最长不重复字符串的开始索引（最左索引）
     *          pi===>i位置元素上一次出现的位置
     *          画图对比：
     *          1、如果li > pi ===>以i位置元素结尾的最长无重复子串的最左索引为li
     *          2、如果pi >= li ===>以i位置元素结尾的最长无重复子串的最左索引  li =  pi + 1
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) return 0;
        if (1 == s.length()) return 1;
        char[] chars = s.toCharArray();
        int max = 0;
        //以i-1位置字符结尾的最长不重复字符串的开始索引（最左索引）
        int li = 0;
        //存储每个元素上一次出现的位置
        //int[] hashTable = new int[128];
        Map<Character,Integer> hashTable = new HashMap<>();
        //初始化
        //hashTable[chars[0]] = 0;
        hashTable.put(chars[0],0);
        for (int i = 1; i < chars.length; i++) {
            //i位置元素上一次出现的位置
            Integer pi = hashTable.get(chars[i]);
            if (pi!=null && pi >= li){
                li = pi +1;
            }
            //存储这个字符出现的位置
            hashTable.put(chars[i],i);
            int len = i - li+1;
            if (len > max)max = len;
        }

        return max;

    }


    /***
     * 优化1
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.equals("")) return 0;
        if (1 == s.length()) return 1;
        char[] chars = s.toCharArray();
        int max = 0;
        //以i-1位置字符结尾的最长不重复字符串的开始索引（最左索引）
        int li = 0;
        //存储每个元素上一次出现的位置
        int[] preIndexs = new int[128];
        //初始化
        for (int i = 0; i < preIndexs.length; i++) {
            preIndexs[i] = -1;
        }
        //初始化
        preIndexs[chars[0]] = 0;   //如果不减 'a',可以用  int[] preIndexs = new int[128] ,该题不仅仅只有小写字母，故要使用128;
        for (int i = 1; i < chars.length; i++) {
            //i位置元素上一次出现的位置
            Integer pi = preIndexs[chars[i]];
            if (pi >= li){
                li = pi +1;
            }
            //存储这个字符出现的位置
            preIndexs[chars[i]] = i;
            int len = i - li+1;
            if (len > max)max = len;
        }

        return max;

    }
}
