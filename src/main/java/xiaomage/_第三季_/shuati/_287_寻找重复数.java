package xiaomage._第三季_.shuati;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lj
 * @createDate 2020/5/26 10:01
 *
 * https://leetcode-cn.com/problems/find-the-duplicate-number/solution/287xun-zhao-zhong-fu-shu-by-kirsche/
 *
 *
 * https://leetcode-cn.com/problems/find-the-duplicate-number/solution/287xun-zhao-zhong-fu-shu-by-kirsche/
 **/
public class _287_寻找重复数 {

    public int findDuplicate(int[] nums) {
        //先让快慢指针相遇
        int slow=nums[0];
        int fast=nums[0];
        while (true){
            slow=nums[slow];
            fast=nums[nums[fast]];
            if(slow==fast) break;  //退出时只是找到了相遇节点
        }
        //弗洛伊德算法找到循环起始点
        //之后再用两个指针，一个指针从起点出发，一个指针从相遇点出发，当他们再次相遇的时候就是入口点了。
        //TODO 入口节点就是我们要求的相遇节点！！！
        int p1=nums[0];
        int p2=slow;
        while (p1!=p2){
            p1=nums[p1];
            p2=nums[p2];
        }
        return p1;
    }
}
