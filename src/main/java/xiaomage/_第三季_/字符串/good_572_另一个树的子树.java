package xiaomage._第三季_.字符串;

import com.mine.test.leetcode.tree.TreeNode;
import xiaomage.printer.BinaryTreeInfo;
import xiaomage.printer.BinaryTrees;

public class good_572_另一个树的子树 {

    /***
     * 思路1：将二叉树进行字符串序列化， 空节点用#代替，节点之间用！分隔
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
         if (s == null || t == null) return false;
         return postSerialization(s).contains(postSerialization(t));
    }

    /***
     * 为何要用后序遍历，前序遍历有个坑 ！！！ 比如节点12 和 2，互不包含，但是前序遍历就包含了，前序遍历,
     * TODO 所以====>后序遍历把！放后边；前序遍历把！放前边！！！
     * @param s
     * @return
     */
    private String postSerialization(TreeNode s) {
        StringBuilder sb = new StringBuilder();
        postSerialization(s,sb);
        return sb.toString();
    }


    private String preSerialization(TreeNode s) {
        StringBuilder sb = new StringBuilder();
        preSerialization(s,sb);
        return sb.toString();
    }

    private void postSerialization(TreeNode s, StringBuilder sb) {
        //后根序遍历
        if (s.left == null){
            sb.append("#").append("!");
        }else {
            postSerialization(s.left,sb);
        }

        if (s.right == null){
            sb.append("#").append("!");
        }else {
            postSerialization(s.right,sb);
        }
        //后序遍历把！放后边
        sb.append(s.val).append("!");
    }


    private void preSerialization(TreeNode s, StringBuilder sb) {
        //前序遍历把！放前边
        sb.append("!").append(s.val);
        //后根序遍历
        if (s.left == null){
            sb.append("!").append("#");
        }else {
            preSerialization(s.left,sb);
        }

        if (s.right == null){
            sb.append("!").append("#");
        }else {
            preSerialization(s.right,sb);
        }

    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        root.right = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(2);
//
//        BinaryTrees.print(new BinaryTreeInfo() {
//            @Override
//            public Object root() {
//                return root;
//            }
//
//            @Override
//            public Object left(Object node) {
//                return ((TreeNode)node).left;
//            }
//
//            @Override
//            public Object right(Object node) {
//                return ((TreeNode)node).right;
//            }
//
//            @Override
//            public Object string(Object node) {
//                return ((TreeNode)node).val;
//            }
//        });
        good_572_另一个树的子树 o = new good_572_另一个树的子树();
        TreeNode root = new TreeNode(12);
        System.out.println(o.preSerialization(root));  //12!#!#!
        TreeNode root1 = new TreeNode(2);
        System.out.println(o.preSerialization(root1));  //2!#!#!
    }
}
