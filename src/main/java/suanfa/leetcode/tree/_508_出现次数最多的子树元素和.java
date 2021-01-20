package suanfa.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : 刘剑
 * @date : 2020/9/20 9:54 下午
 * @description
 *
 * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 *
 * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-frequent-subtree-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class _508_出现次数最多的子树元素和 {


    /**
     * 思路：找出以各节点为跟节点的所有节点之和，判断出现的次数，需要一个hashmap  《sum，count》;记录出现的最多次数
     */
    class Solution {
        int max= 0;
        Map<Integer,Integer> map = new HashMap<>();
        public int[] findFrequentTreeSum(TreeNode root) {
            if (root == null) return new int[0];
            getsum(root);
            //处理逻辑 数组无法控制大小，用arrlist
            List<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer,Integer> it: map.entrySet()) {
                if (max == it.getValue()) list.add(it.getKey());
            }

            int[] result = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;

        }

        private int getsum(TreeNode root) {
            if (root == null) return 0;
            int leftsum = getsum(root.left);
            int rightsum = getsum(root.right);
            int sum = leftsum + rightsum + root.val;
            //1、为了统计每个sum出现的次数，放入map
            map.put(sum,map.getOrDefault(sum,0)+1);
            //2、记录最大次数，方便找sum
            max = Math.max(max,map.get(sum));

            return sum;

        }
    }
}
