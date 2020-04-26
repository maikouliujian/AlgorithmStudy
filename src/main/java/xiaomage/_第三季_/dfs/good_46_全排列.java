package xiaomage._第三季_.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class good_46_全排列 {

    public static void main(String[] args) {
        List<List<Integer>> lists = new good_46_全排列().permute2(new int[]{1, 1, 2});
        System.out.println(lists);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        //存放每一个临时结果
        //List<Integer> tmp = new ArrayList<>();

        int tmp[] = new int[nums.length];
        //存放元素是否使用过
        boolean[] used = new boolean[nums.length];
        dfs(0, nums, result, tmp, used);


        return result;


    }

    private void dfs(int idx, int[] nums, List<List<Integer>> result, int tmp[], boolean[] used) {
        if (idx == nums.length) {
            List<Integer> t = new ArrayList<>();
            for (int i : tmp) {
                t.add(i);
            }
            result.add(t);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            //tmp需要一直被覆盖
            //tmp.add(idx,nums[i]);
            tmp[idx] = nums[i];
            used[i] = true;
            dfs(idx + 1, nums, result, tmp, used);

            //回溯后需要还原现场！！！
            used[i] = false;


        }

    }


    //=====================================1===================================

    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        //存放每一个临时结果
        List<Integer> tmp = new ArrayList<>();

        //int tmp[] = new int[nums.length];
        //存放元素是否使用过
        //boolean[] used = new boolean[nums.length];
        dfs1(0, nums, result, tmp);


        return result;


    }

    private void dfs1(int idx, int[] nums, List<List<Integer>> result, List<Integer> tmp) {
        if (idx == nums.length) {
//            List<Integer> t = new ArrayList<>();
//            for (int i : tmp) {
//                t.add(i);
//            }
//            result.add(t);
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //if (used[i]) continue;
            //tmp需要一直被覆盖
            //tmp.add(idx,nums[i]);
            if (tmp.contains(nums[i])) continue;
            dfs1(idx + 1, nums, result, tmp);

            //回溯后需要还原现场！！！
            tmp.remove(tmp.size() - 1);


        }

    }


    //=====================================2====================


    //思路：依靠原数组进行交换
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        dfs2(0, nums, result);
        return result;


    }

    private void dfs2(int idx, int[] nums, List<List<Integer>> result) {
        if (idx == nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int num : nums) {
                tmp.add(num);
            }
            result.add(tmp);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(idx, i, nums);
            dfs2(idx+1,nums,result);
            //还原现场！！！
            swap(idx,i,nums);
        }

    }

    private void swap(int idx, int i, int[] nums) {
        int tmp = nums[idx];
        nums[idx] = nums[i];
        nums[i] = tmp;
    }

}
