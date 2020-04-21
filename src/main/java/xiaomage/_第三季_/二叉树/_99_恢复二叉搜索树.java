package xiaomage._第三季_.二叉树;

import com.mine.test.leetcode.tree.TreeNode;

public class _99_恢复二叉搜索树 {



    //思路：中序遍历二插搜索树，找到错误交换的两个节点，交换值
    //TODO  遍历过程中找出 逆序对
    //TODO 第一个错误节点：第一个逆序对中较大的节点
    //TODO 第二个错误节点：第二个逆序对中较小的节点
    public void recoverTree(TreeNode root) {
        inorder(root);
        //交换值
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    TreeNode pre,first,second;

    //时间复杂度o(n)
    //空间复杂度o(h)  h树的高度  最差o(n)
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        //处理逻辑===>找逆序
        if (pre!=null && pre.val > root.val){
            //第二个逆序对，可以覆盖第一个逆序对
            second = root;
            //保证first不能被覆盖
            if (first != null){
                return;
            }
            first = pre;
        }
        pre = root;

        inorder(root.right);
    }
}
