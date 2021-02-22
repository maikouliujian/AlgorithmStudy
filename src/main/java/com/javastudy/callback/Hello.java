package com.javastudy.callback;

/**
 * @author lj
 * @createDate 2020/3/2 19:09
 **/
public class Hello {
    public interface CallBack {
        void test(String id);
    }
    public void run(CallBack callBack){
        //相当于调用了haha方法！！！
        callBack.test("id");
    }


    public void haha(String idx){
        System.out.println("call back" +idx);
    }
//    public void Hhhh(int idx){
//        System.out.println("call back" +idx);
//    }

    public void aa(){
        //定义一个lamda表达式，回调
        run(this::haha);
    }
}

