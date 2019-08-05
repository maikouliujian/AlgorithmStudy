package com.mine.test.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lj
 * @createDate 2019/8/2 19:14\
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
1
\
2
/
3

输出: [1,3,2]

进阶: 递归算法很简单，你可以通过迭代算法完成吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class q94 {

    public static void main(String[] args) {




    }

    public static List<Integer> inorderTraversal(TreeNode root){

        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (true){
            if (root!=null){
                stack.add(root);
                root = root.left;
            }else {
                if (stack.empty()){
                    return result;
                }
                //从栈取数据
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }


    }
}
