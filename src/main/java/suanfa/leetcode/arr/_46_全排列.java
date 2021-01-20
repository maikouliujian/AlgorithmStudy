package suanfa.leetcode.arr;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 刘剑
 * @date : 2020/12/22 2:03 下午
 * @description
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class _46_全排列 {

    class Solution {
        //全排列问题，用回溯
        //定义返回值
        List<List<Integer>> res  = new ArrayList<>();
        public List<List<Integer>> permute(int[] nums) {
            if (nums.length == 0 )return res;
            //新建一条路径，方便复用！！！
            List<Integer> track = new ArrayList<>();
            backtrack(nums,track);
            return res;
        }

        //回溯组装
        private void backtrack(int[] nums, List<Integer> track) {
            //装满元素===>添加路径
            if (track.size() == nums.length){
                //new 是为了复用路径
                res.add(new ArrayList<>(track));
                return;
            }
            //回溯
            for (int num : nums) {
               //条件判断，不存在才加入
               if (track.contains(num))continue;
               //做选择
               track.add(num);
               backtrack(nums,track);
               //撤销选择
                track.remove(track.size()-1);
            }

        }
    }


}
