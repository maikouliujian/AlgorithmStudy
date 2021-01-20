package suanfa.leetcode.tree;

/**
 * @author : 刘剑
 * @date : 2020/11/28 4:42 下午
 * @description
 *
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _222_完全二叉树的节点个数 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3= new TreeNode(3);
        TreeNode n4= new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.left=n6;


        int i = new Solution().countNodes(n1);
        int h= new Solution().getHeight(n1);
        System.out.println(h);
    }

    static class Solution {
        //https://leetcode-cn.com/problems/count-complete-tree-nodes/solution/wan-quan-er-cha-shu-de-jie-dian-ge-shu-by-leetco-2/

        /***
         * 现在这个树中的值都是节点的编号，最底下的一层的编号是[2^h ，2^h - 1]，现在h = 2，也就是4, 5, 6, 7。
         * 4, 5, 6, 7对应二进制分别为 100 101 110 111 不看最左边的1，从第二位开始，0表示向左，1表示向右，正好可以表示这个节点相对于根节点的位置。
         * 比如4的 00 就表示从根节点 向左 再向左。6的 10 就表示从根节点 向右 再向左
         *
         * 那么想访问最后一层的节点就可以从节点的编号的二进制入手。从第二位开始的二进制位表示了最后一层的节点相对于根节点的位置。
         * 那么就需要一个bits = 2^(h - 1) 这里就是2，对应二进制为010。这样就可以从第二位开始判断。
         * 比如看5这个节点存不存在，先通过位运算找到编号为5的节点相对于根节点的位置。010 & 101 发现第二位是0，说明从根节点开始，第一步向左走。
         * 之后将bit右移一位，变成001。001 & 101 发现第三位是1，那么第二步向右走。
         * 最后bit为0，说明已经找到编号为5的这个节点相对于根节点的位置，看这个节点是不是空，不是说明存在，exist返回真
         * 编号为5的节点存在，说明总节点数量一定大于等于5。所以二分那里low = mid
         *
         * 再比如看7存不存在，010 & 111 第二位为1，第一部从根节点向右；001 & 111 第三位也为1，第二步继续向右。
         * 然后判断当前节点是不是null，发现是null，exist返回假。
         * 编号为7的节点不存在，说明总节点数量一定小于7。所以high = mid - 1
         * @param root
         * @return
         */
//        public int countNodes(TreeNode root) {
//
//        }

        //todo 利用满二叉树的性质，根据数的高度，判断左右子树是否为满二叉树
        public int countNodes(TreeNode root) {
            if (root == null)return 0;
            if (root.left == null && root.right == null)return 1;
            int rightHeight = getHeight(root.right);
            int leftHeight = getHeight(root.left);
            //左右高度相等
            if (rightHeight == leftHeight){
                return (1 << leftHeight) + countNodes(root.right);
            }else {
                return (1 << rightHeight) + countNodes(root.left);
            }

        }

        private int getHeight(TreeNode root) {
//            if (root == null) return 0;
//            TreeNode cur = root;
//            int height = 0;
//            while (cur.left!=null){
//                height++;
//                cur = cur.left;
//            }
//            return height;

            int level = 0;
            while(root != null){
                level++;
                root = root.left;
            }
            return level;
        }


    }



}
