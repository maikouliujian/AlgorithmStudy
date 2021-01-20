package xiaomage._第三季_.栈_队列;

import suanfa.leetcode.tree.TreeNode;

import java.util.Arrays;
import java.util.Stack;

public class good_654_最大二叉树_用栈求左右第一个比当前元素大的值 {

    /***
     * 思路：递归
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return findRoot(nums,0,nums.length);
    }

    /***
     * 寻找[l,r) 区间内的树的根节点
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private TreeNode findRoot(int[] nums, int l, int r) {
        //3、递归终止条件
        if (l == r)return null;
        //1、寻找最大值
        int max_index = l;
        for (int i = l+1; i < r; i++) {
            if (nums[i] > nums[max_index]) max_index = i;
        }
        //2、创建根节点
        TreeNode root = new TreeNode(nums[max_index]);
        root.left = findRoot(nums,l,max_index);
        root.right = findRoot(nums,max_index+1,r);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,6,0,5};
        new good_654_最大二叉树_用栈求左右第一个比当前元素大的值().parentIndexs(nums);
    }


    /***
     * 题目变种：返回二叉树各节点对应父节点的索引
     * todo : 方案：分别找到一个元素左边和右边第一个比它大的元素，二者中的最小的就是其父节点！！！
     * todo : 维护一个单调递减的栈，
     * TODO:  1、压入一个元素时，栈顶元素是该元素左边第一个最大值；2、要弹出一个元素时，将要压入的元素是其右边的第一个最大值；
     * @param nums
     * @return
     */
    public int[] parentIndexs(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        //维护两个索引，分别存放i对应的左、右边第一个比它大的值的索引
        int lindexs[] = new int[nums.length];
        int rindexs[] = new int[nums.length];
        int result[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            //让两个数组默认值都为-1；
            lindexs[i] = rindexs[i] = -1;

            while (stack.size() > 0 && !(nums[i] < nums[stack.peek()])){
                //此时nums[i]是nums[pop]右边第一个比它大的值
                Integer pop = stack.pop();
                rindexs[pop] = i;
            }
            if (!stack.isEmpty()){
                int peek = stack.peek();
                //此时nums[peek]是nums[i]左边第一个比它大的值
                lindexs[i] = peek;
            }
//            else {
//                lindexs[i] = -1;
//            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(lindexs));
        System.out.println(Arrays.toString(rindexs));

        for (int i = 0; i < nums.length; i++) {
            int lv = lindexs[i];
            int rv = rindexs[i];
            if (lv == -1&& rv==-1){
                result[i] = -1;
            }else if (lv == -1&& rv!=-1){
                result[i] = rv;
            }else if (lv != -1&& rv==-1){
                result[i] = lv;
            }else {
                //取小的
                result[i] = nums[lv] > nums[rv]?rv:lv;
            }
        }
        System.out.println(Arrays.toString(result));

        return result;
    }
}
