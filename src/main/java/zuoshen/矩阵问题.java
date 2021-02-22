package zuoshen;

/**
 * @author : 刘剑
 * @date : 2021/2/22 1:51 下午
 * @description
 */
public class 矩阵问题 {

    /***
     * 1）zigzag【锯齿形的，之字形的， Z字形的】打印矩阵
     *
     * 2）转圈打印矩阵
     *
     * 3）原地旋转正方形矩阵
     */
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printMatrixZigZag(matrix);
        System.out.println("------");
        printMatrixZigZag_(matrix);
    }

    //====================================================
    /***
     * 1）zigzag【锯齿形的，之字形的， Z字形的】打印矩阵
     * @param matrix
     * //todo 思路：从源点开始，分别向右，向下移动两个点；
     */
    public static void printMatrixZigZag(int[][] matrix) {
        int rR = 0,rC = 0;
        int dR = 0,dC = 0;
        boolean fromUp = false;//打印方式：是否从上到下打印；
        int endR = matrix.length;
        int endC = matrix[0].length;
        while (rR < endR){
            printLevel(matrix, rR, rC, dR, dC, fromUp);
            rR = rC == (endC-1)?++rR:rR;
            rC = rC == (endC-1)?rC:++rC;
            dC = dR == (endR-1)?++dC:dC;
            dR = dR == (endR-1)?dR:++dR;
            fromUp = !fromUp;
        }

    }
    public static void printMatrixZigZag_(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;
        while (tR != endR + 1) {
            printLevel_(matrix, tR, tC, dR, dC, fromUp);
            tR = tC == endC ? tR + 1 : tR;
            tC = tC == endC ? tC : tC + 1;
            dC = dR == endR ? dC + 1 : dC;
            dR = dR == endR ? dR : dR + 1;
            fromUp = !fromUp;
        }
        System.out.println();
    }

    public static void printLevel_(int[][] m, int tR, int tC, int dR, int dC,
                                  boolean f) {
        if (f) {
            while (tR != dR + 1) {
                System.out.print(m[tR++][tC--] + " ");
            }
        } else {
            while (dR != tR - 1) {
                System.out.print(m[dR--][dC++] + " ");
            }
        }
    }

    private static void printLevel(int[][] matrix, int rR, int rC, int dR, int dC, boolean fromUp) {
        //从上向下打印
        if (fromUp){
           //以r为基准点
           while (rR<=dR){
               System.out.print(matrix[rR++][rC--] + " ");
           }
        }else {//从下向上打印
            //以d为基准点
            while (dR>=rR){
                System.out.print(matrix[dR--][dC++] + " ");
            }
        }

    }


}
