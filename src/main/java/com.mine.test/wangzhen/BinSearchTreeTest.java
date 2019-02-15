package com.mine.test.wangzhen;

import org.omg.CORBA.DATA_CONVERSION;

public class BinSearchTreeTest {

    private TreeNode root; //根节点

    //树节点
    public static class TreeNode{
        public int data;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

    }


    //查找
    public TreeNode find(int data){
        TreeNode node= root;
        while (node!=null){
            if (node.data < data){
                node = node.right; //值大向右
            }else if (node.data > data){
                node = node.left;//值小向左
            }else {
                return node;
            }

        }
        return null;  //未找见
    }
    //插入：插入都是插入到叶子节点
    public void  insert(int data){
        if (root == null){
            root = new TreeNode(data);
            return;
        }

        TreeNode node = root;
        while (node!=null){
            if (data < node.data){
                if (node.left == null){
                    node.left = new TreeNode(data);
                    return;
                }
                node = node.left;
            }else if (data > node.data){
                if (node.right == null){
                    node.right= new TreeNode(data);
                    return;
                }
                node = node.right;
            }
        }
    }

    //删除：删除有三种情况




}
