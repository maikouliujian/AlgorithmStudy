package zuoshen.study.meta;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author : 刘剑
 * @date : 2021/2/23 2:45 下午
 * @description
 */
public class GetSessionRnUDF {

    public int evaluate(int rn, ArrayList<Integer> rn_set) throws Exception{
        int ret=1;
        if(rn_set==null || rn_set.isEmpty()){
            ret=1;
        } else {
            Collections.sort(rn_set);
            for(int i=rn_set.size();i>=1;i--){
                if(rn >= rn_set.get(i - 1)){
                    ret = i+1;
                    break;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) throws Exception{
        ArrayList list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(7);

        System.out.println(new GetSessionRnUDF().evaluate(1,list));
        System.out.println(new GetSessionRnUDF().evaluate(2,list));
        System.out.println(new GetSessionRnUDF().evaluate(3,list));
        System.out.println(new GetSessionRnUDF().evaluate(4,list));
        System.out.println(new GetSessionRnUDF().evaluate(5,list));
        System.out.println(new GetSessionRnUDF().evaluate(6,list));
        System.out.println(new GetSessionRnUDF().evaluate(7,list));

    }
}
