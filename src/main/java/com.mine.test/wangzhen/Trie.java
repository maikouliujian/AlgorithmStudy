package com.mine.test.wangzhen;

/**
 * @author lj
 * @createDate 2019/6/13 12:05
 **/
public class Trie {

    //根节点
    public TreeNode root = new TreeNode('/');

    public static class TreeNode{
        //每个节点储存的值
        public char  data;
        //为每个节点分配26个引用占位符号
        public TreeNode[] children = new TreeNode[26];
        //判断是否为结束符
        public boolean isEndChar = false;


        public TreeNode(char data) {
            this.data = data;
        }
    }


    /***
     * 插入一个字符
     */

    public void insert(char[] str){
        TreeNode p = root;
        //遍历索引位，为str找位置
        for (char c : str) {
            //判断数据是否已存在
            int index = toIndex(c) - toIndex('a');
            if (p.children[index] == null) {
                //为空则新建
                TreeNode treeNew = new TreeNode(c);

                //指向新节点
                p.children[index] = treeNew;
            }
            //轮询
            p = p.children[index];
        }
        p.isEndChar = true;
    }


    public boolean  find(char[] str){
        TreeNode p = root;
        //遍历索引位，为str找位置
        for (char c : str) {
            //判断数据是否已存在
            int index = toIndex(c) - toIndex('a');
            if (p.children[index] == null) {
                //为空则不存在
                return false;
            }
            //轮询
            p = p.children[index];
        }

        //判断是前缀还是真实存在
        return p.isEndChar;
    }

    public static byte toIndex(char str){
        return (byte)str;
    }


    public static void main(String[] args) {
        String[] strs = {"how", "hi", "her", "hello", "so", "see"};
        Trie trie = new Trie();
        for (String str : strs) {
            trie.insert(str.toCharArray());
        }

        for (String str : strs) {

            System.out.println(trie.find(str.toCharArray()));
        }

        System.out.println(trie.find("ho".toCharArray()));

    }
}
