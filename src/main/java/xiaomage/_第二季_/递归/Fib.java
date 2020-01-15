package xiaomage._第二季_.递归;

public class Fib {

    public static void main(String[] args) {
//        System.out.println(fib1(10));
//        System.out.println(fib2(10));
        System.out.println(fib3(10));
        System.out.println(fib6(10));

    }

    /***
     * 1 1 2 3 5
     * @param n
     * @return
     */
    public static int fib1(int n){
        if (n <= 2) return 1;
        return fib1(n-1) + fib1(n-2);

    }

    /***
     * 优化1 ： 记忆化
     * @param n
     * @return
     *
     *
     */
    public static int fib2(int n){
        if (n <= 2) return 1;
        int memory[] = new int[n+1];
        memory[1] = memory[2] = 1;
        return helper(n,memory);

    }

    private static int helper(int n, int[] memory) {
        if (memory[n] == 0){
            memory[n] = helper(n-1,memory) + helper(n-2,memory);
        }
        return memory[n];
    }



    /***
     * 优化2： 递推  递归：自顶向下    递推：自底向上
     * @param n
     * @return
     *
     * 1 1 2 3 5
     */
    public static int fib3(int n){
        if (n <= 2) return 1;
//        int a = 1;
//        int b = 1;
//        int c = 0;
        int a  =1,b =1,c = 0;
        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
            System.out.println("a" + a + "b" + b);
        }
        return b;

    }

    /***
     * dp
     * @param n
     * @return
     */
    public static int fib4(int n){
        if (n <= 2) return 1;
        int[] arr = new int[n +1];
        arr[1] = arr[2] = 1;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i -2];
        }
        return arr[n];

    }


    /***
     * 滚动数组
     * @param
     * @return
     */
    public static int fib5(int n){
        if (n <= 2) return 1;
        int[] arr = new int[2];
        arr[0] = arr[1] = 1;
        for (int i = 3; i <= n; i++) {
            arr[i%2] = arr[(i-1)%2] + arr[(i -2)%2];
        }
        return arr[n%2];

    }

    /***
     * dp TODO %2 等价于 &１
     * @param
     * @return
     */
    public static int fib6(int n){
        if (n <= 2) return 1;
        int[] arr = new int[2];
        arr[0] = arr[1] = 1;
        for (int i = 3; i <= n; i++) {
            arr[i&1] = arr[(i-1)&1] + arr[(i -2)&1];
        }
        return arr[n&1];

    }
}
