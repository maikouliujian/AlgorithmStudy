package suanfa;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.HashMap;
        import java.util.List;

public class Shuxue {
    public static final long[] rewards = {1, 2, 5, 10};  //四种金额

    public static void main(String[] arg) {
        //+System.out.println("aaaaaaaaaaa");
        //get(10, new ArrayList<Long>());
        //recursion(8,new ArrayList<Long>());
        yihuo();
    }


    //q1_两数之和
    public static void get(long totalAmount, ArrayList<Long> result) {
        //利用递归处理
        if (totalAmount == 0) {
            System.out.println("每一次结果------>" + result);
            return;
        }
        if (totalAmount < 0) return;
        for (int i = 0; i < rewards.length; i++) {
            ArrayList<Long> newresult = (ArrayList<Long>) result.clone(); //这步代码是必须的。想想为何?
            long amount = rewards[i];
            newresult.add(amount);
            get(totalAmount - amount, newresult);
        }
    }


    public static void recursion(long total, ArrayList<Long> result) {

        if (total == 1) {
            if (!result.contains(1L)) result.add(1L);
            System.out.println(result);
            return;
        } else {
            for (long i = 1; i <= total; i++) {
                if ((i == 1) && result.contains(1L)) continue;
                ArrayList<Long> newList = (ArrayList<Long>) (result.clone());
                if (total % i != 0) {
                    continue;
                }
                newList.add(Long.valueOf(i));
                recursion(total / i, newList);
            }
        }
    }

    /**
     在1到n的数字中，有且只有唯一的一个数字m重复出现了，其它的数字都只出现一次。
     请把这个数字找出来。
     提示：可以充分利用异或的两个特性。
     */
    public static void yihuo() {
        int[] arr = { 6, 3, 9, 5, 4, 8, 2, 5, 7, 1 };
        int temp = arr[0];
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            temp ^= arr[i];
            max = max < arr[i] ? arr[i] : max;
        }
        System.out.println(max);
        System.out.println(temp);
        int t = 1;
        for (int i = 2; i <= max; i++) {
            t ^= i;
        }
        System.out.println(t ^ temp);
    }


    public static class Lesson8_1 {

        public static void main(String[] args){
            ArrayList<String> teams = new ArrayList<String>(Arrays.asList("t1","t2","t3"));
            //combine(teams, new ArrayList<String>(),2);
            permutate(teams, new ArrayList<String>(),2);
        }

        /**
         * @Description:	使用函数的递归（嵌套）调用，找出所有可能的队伍组合
         * @param teams- 目前还剩多少队伍没有参与组合，result- 保存当前已经组合的队伍
         * @return void
         */

        public static void combine(ArrayList<String> teams, ArrayList<String> result, int m) {

            // 挑选完了 m 个元素，输出结果
            if (result.size() == m) {
                System.out.println(result);
                return;
            }

            for (int i = 0; i < teams.size(); i++) {
                // 从剩下的队伍中，选择一队，加入结果
                ArrayList<String> newResult = (ArrayList<String>)(result.clone());
                newResult.add(teams.get(i));

                // 只考虑当前选择之后的所有队伍
                ArrayList<String> rest_teams = new ArrayList<String>(teams.subList(i + 1, teams.size()));

                // 递归调用，对于剩余的队伍继续生成组合
                combine(rest_teams, newResult, m);
            }

        }


        public static void permutate(ArrayList<String> teams, ArrayList<String> result, int m) {

            // 挑选完了 m 个元素，输出结果
            if (result.size() == m) {
                System.out.println(result);
                return;
            }

            for (int i = 0; i < teams.size(); i++) {
                // 从剩下的队伍中，选择一队，加入结果
                ArrayList<String> newResult = (ArrayList<String>)(result.clone());
                newResult.add(teams.get(i));
                // 只考虑当前选择之后的所有队伍
                //ArrayList<String> rest_teams = new ArrayList<String>(teams.subList(i + 1, teams.size()));
                // 递归调用，对于剩余的队伍继续生成组合
                permutate(teams, newResult, m);
            }
        }

    }








}



