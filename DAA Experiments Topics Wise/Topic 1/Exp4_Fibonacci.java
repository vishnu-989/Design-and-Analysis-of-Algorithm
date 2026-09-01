import java.util.HashMap;
import java.util.Map;

public class Exp4_Fibonacci {

    static int[] fibonacciIterative(int n) {
        int[] fib = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) fib[i] = 0;
            else if (i == 1) fib[i] = 1;
            else fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

    static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    static Map<Integer, Integer> memo = new HashMap<>();

    static int fibonacciMemo(int n) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);
        int result = fibonacciMemo(n - 1) + fibonacciMemo(n - 2);
        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        int n = 6;

        int[] iterative = fibonacciIterative(n);
        System.out.print("Iterative: [");
        for (int i = 0; i < iterative.length; i++) {
            System.out.print(iterative[i]);
            if (i != iterative.length - 1) System.out.print(", ");
        }
        System.out.println("]");

        System.out.print("Recursive: [");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciRecursive(i));
            if (i != n - 1) System.out.print(", ");
        }
        System.out.println("]");

        System.out.print("Memoized: [");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciMemo(i));
            if (i != n - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
