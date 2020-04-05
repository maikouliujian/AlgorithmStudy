package xiaomage._第三季_.字符串;

public class _242_有效的字母异位词 {


    /***
     * 所谓异位词，就是两个串中各字符数量相等，顺序不限
     * 思路====>使用hash表解决，不过jdk的hashmap比较重
     * 题目说明:你可以假设字符串只包含小写字母。====>小写字母就26个，我们可以使用数组代替hash表
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (t == null || s == null) return false;
        if (t.length() != s.length()) return false;

        //创建hash表
        int[] hashTable = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int hash = s.charAt(i) - 'a';
            hashTable[hash]+=1;
        }

        for (int i = 0; i < t.length(); i++) {
            int hash = t.charAt(i) - 'a';
            hashTable[hash]-=1;
            //在这里判断小于0即可，大于0不行
            if (hashTable[hash] < 0 )return false;
        }

//        for (int i = 0; i < hashTable.length; i++) {
//            if (hashTable[i] != 0) return false;
//        }
        return true;




    }



    public boolean isAnagram1(String s, String t) {
        if (t == null || s == null) return false;
        if (t.length() != s.length()) return false;

        //创建hash表
        int[] hashTable = new int[26];
        char[] s_chars = s.toCharArray();
        char[] t_chars = t.toCharArray();
        for (char s_char : s_chars) {
            int hash = s_char - 'a';
            hashTable[hash] += 1;
        }

        for (char t_char : t_chars) {
            int hash = t_char - 'a';
            hashTable[hash] -= 1;
            //在这里判断小于0即可，大于0不行
            if (hashTable[hash] < 0) return false;
        }

//        for (int i = 0; i < hashTable.length; i++) {
//            if (hashTable[i] != 0) return false;
//        }
        return true;




    }
}
