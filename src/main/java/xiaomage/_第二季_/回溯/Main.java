package xiaomage._第二季_.回溯;

public class Main {
    public static void main(String[] args) {
        new Main().placeQueue(8);

    }

    /***
     * 数组索引是行号，数组元素是列号；
     */
    int [] cols;

    int ways;

    void placeQueue(int n){
        if (n < 1)  return;
        cols = new int[n];
        place(0);
        System.out.println(n+"皇后有多少种摆法" + ways);

    }

    /***
     * 从第 row行开始摆放皇后
     * @param row
     */
    void place(int row){
        if (row == cols.length) {
            ways++;
            show();
            return;
        }
        //回溯的地方
        for (int col = 0; col < cols.length ; col++) {
            if (isVaild(row,col)){
                //在第row行第col列摆放皇后
                cols[row] = col;
                place(row + 1);
            }
        }

    }

    /***
     * 判断第row行和第col列是否可以摆放皇后
     * @param row
     * @param col
     * @return
     */
    private boolean isVaild(int row, int col) {
        for (int i = 0; i < row; i++) {
            //排除同一列
            if (col == cols[i]) return false;
            //排除对角线 计算斜率相等
            if (row - i == Math.abs(col - cols[i])) return false;
        }
        return true;
    }


    void show () {
        for (int row = 0; row < cols.length; row++) {
            for (int col = 0; col < cols.length; col++) {
                if (cols[row] == col) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }
}
