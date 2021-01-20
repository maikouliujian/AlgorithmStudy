package suanfa.wangzhen;

import java.util.*;

public class BinTreeTest {

    public static void main(String[] args) {

//        /***
//         *        7
//         *      3   6
//         *    5 10 11 9


        TreeNode seven= new TreeNode(7);
        TreeNode three= new TreeNode(3);
        TreeNode six= new TreeNode(6);
        TreeNode five= new TreeNode(5);
        TreeNode ten= new TreeNode(10);
        TreeNode eleven= new TreeNode(11);
        TreeNode nine = new TreeNode(9);

        seven.left = three;
        seven.right = six;

        three.left = five;
        three.right = ten;

        six.left = eleven;
        six.right = nine;

        levelOrder(seven);


    }

    //前根排序
    public static void preOrder(TreeNode root){
        if (root == null) return;
        System.out.print(root.data + "--->");
        preOrder(root.left);
        preOrder(root.right);

    }

    //前根遍历（非递归）
    public static void preOrder1(TreeNode root){
        if (root == null) return;
        //借用栈来实现
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node.right!=null) stack.push(node.right);
            if (node.left!=null) stack.push(node.left);

            System.out.print(node.data + "--->");

        }
    }


    //前根遍历（非递归）
    public static void preOrder2(TreeNode root){
        if (root == null) return;
        //借用栈来实现
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node!=null || !stack.isEmpty()){
            if (node!=null){
                //node = stack.pop();
                System.out.print(node.data + "--->");
                stack.push(node);
                node = node.left;

            }else {
                TreeNode temp  = stack.pop();
                node = temp.right;
            }

        }
    }



    //中根遍历（非递归）
    public static void midOrder1(TreeNode root){
        if (root == null) return;
        //借用栈来实现
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node!=null || !stack.isEmpty()){
            if (node!=null){
                stack.push(node);
                node = node.left;
            }else {
                TreeNode temp = stack.pop();
                System.out.print(temp.data + "--->");
                node = temp.right;

            }

        }
    }


    //后根遍历（非递归）
    private static void postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> output = new Stack<TreeNode>();//构造一个中间栈来存储逆后续遍历的结果
        TreeNode node = root;
        while(node != null || stack.size()>0){
            if(node != null){
                output.push(node);
                stack.push(node);
                node = node.right;
            }else{
                TreeNode temp = stack.pop();
                node = temp.left;
            }
        }
        while(output.size()>0){
            System.out.print(output.pop().data+"--->");
        }
    }

    public static void levelOrder(TreeNode root){
        if (root == null) return;
        //层级遍历属于广度优先遍历，使用队列
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> mlist = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left!=null){
                    queue.offer(temp.left);
                }
                if (temp.right!=null){
                    queue.offer(temp.right);
                }
                mlist.add(temp.data);
            }
            result.add(mlist);
        }
        System.out.println(result);
    }


    public static void levelOrder1(TreeNode root){
        if (root == null) return;
        //借用栈来实现
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node!=null || !stack.isEmpty()){
            if (node!=null){
                stack.push(node);
                node = node.left;
            }else {
                TreeNode temp = stack.pop();
                System.out.print(temp.data + "--->");
                node = temp.right;

            }

        }
    }





    //树节点
    public static class TreeNode{
        public int data;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }













}
