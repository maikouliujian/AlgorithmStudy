package com.mine.test.wangzhen;


public class huishuo {


    public static void main(String[] args) {
        findQueue(0);

    }


    /***
     * 八皇后问题： https://www.jianshu.com/p/65c8c60b83b8
     */
    //8 * 8棋盘
    public static final int [][] qipan = new int[8][8];

    public static int map = 0; //统计总值


    public static void findQueue(int row){
        //递归结束条件 ，找到满足八皇后
        if (row > 7){
            //找到了条件
            map++;
            printQueue();
            System.out.println(map+"");
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (check(row,i)){
                qipan[row][i] = 1;
                //寻找下一行
                findQueue(row+1);
                qipan[row][i] = 0;

            }
        }

    }

    /***
     * 校验是否满足条件
     * @param row  行
     * @param i  列
     * @return
     */
    private static boolean check(int row, int cloumn) {
        //左上
        for (int i = row -1,j = cloumn-1; i >=0 && j>=0 ; i--,j--) {
             if (qipan[i][i] ==1){
                 return false;
             }
        }

        //正上
        for (int i = row -1; i >=0; i--) {
            if (qipan[i][cloumn] ==1){
                return false;
            }
        }

        //右上
        for (int i = row -1,j = cloumn+1; i >=0 && j<=7 ; i--,j++) {
            if (qipan[i][i] ==1){
                return false;
            }
        }
        return true;
    }

    private static void printQueue() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (qipan[i][j] == 1){
                    System.out.print("Q");
                }else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        System.out.println();

    }
}
