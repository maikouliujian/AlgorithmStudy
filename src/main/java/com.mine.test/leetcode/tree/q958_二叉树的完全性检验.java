package com.mine.test.leetcode.tree;

import com.mine.test.leetcode.PrintTool;

import java.util.*;

/**
 * TODO 二叉树的四种遍历 【必须熟练掌握！！！】
 * @author lj
 * @createDate 2019/8/2 19:14\
给定一个二叉树，确定它是否是一个完全二叉树。

百度百科中对完全二叉树的定义如下：

若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~ 2h 个节点。）



示例 1：

输入：[1,2,3,4,5,6]
输出：true
解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。

示例 2：

输入：[1,2,3,4,5,null,7]
输出：false
解释：值为 7 的结点没有尽可能靠向左侧。



提示：

树中将会有 1 到 100 个结点。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class q958_二叉树的完全性检验 {

    public static void main(String[] args) {


    }


    static class Solution {
        //todo 思路：层级遍历二叉树，然后进行判断
          //todo 1、不能出现左节点为空的元素
        public boolean isCompleteTree(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            boolean mustLeaf = false;
            while (!queue.isEmpty()){
                TreeNode tmp = queue.poll();
                if (mustLeaf && (tmp.left != null ||tmp.right != null)) return false;

                if (tmp.left!=null){
                    queue.add(tmp.left);
                }else if (tmp.right!=null){
                    //左节点为空，右节点不为空，false
                    return false;
                }

                if (tmp.right!=null){
                    queue.add(tmp.right);
                }else {
                    //右节点为空时；
                    //TODO 这一步判断很重要，如果左节点也为空，则从该节点开始，全是叶子节点
                    //TODO 如果左节点不为空，上面已经处理了
                    mustLeaf = true;
                }
            }

            return true;

        }
    }
}
