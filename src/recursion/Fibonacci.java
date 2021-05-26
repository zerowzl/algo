package recursion;

/**
 * 斐波那契数列
 *
 * @author Dave Wang
 */
public class Fibonacci {


    public static int fibonacci(int n) {
        // 终止条件
        if (n == 1 || n == 2) {
            return 1;
        }

        // 递推公式
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));
        System.out.println(fibonacci(7));
        System.out.println(fibonacci(8));
        System.out.println(fibonacci(9));
        System.out.println(fibonacci(10));
    }

}
