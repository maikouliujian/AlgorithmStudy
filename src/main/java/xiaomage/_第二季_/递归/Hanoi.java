package xiaomage._第二季_.递归;

public class Hanoi {

    public static void main(String[] args) {
        hanoi(3,"a","b","c");
    }

    /***
     * 方法的定义是将n个碟子从p1移动到p3,递归：先确定方法的意义
     * @param n
     * @param p1
     * @param p2
     * @param p3
     */
    public static void hanoi(int n,String p1,String p2,String p3){
        //递归基
        if (n == 1) {
            move(n, p1, p3);
            return;
        }
        hanoi(n-1,p1,p3,p2);
        move(n,p1,p3);
        hanoi(n-1,p2,p1,p3);


    }

    public static void move(int no,String from,String to){
        System.out.println("将" + no + "号盘子从" + from + "移动到" + to);
    }
}
