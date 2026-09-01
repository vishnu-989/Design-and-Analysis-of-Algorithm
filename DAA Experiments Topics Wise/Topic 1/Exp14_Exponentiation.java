public class Exp14_Exponentiation {
    static long powerIterative(int x, int n) {
        long result = 1;
        for (int i = 0; i < n; i++) result *= x;
        return result;
    }

    static long powerRecursiveFast(int x, int n) {
        if (n == 0) return 1;
        long half = powerRecursiveFast(x, n / 2);
        if (n % 2 == 0) return half * half;
        else return half * half * x;
    }

    public static void main(String[] args) {
        int x = 2, n = 10;
        System.out.println("Iterative: " + powerIterative(x, n));
        System.out.println("Recursive Fast Power: " + powerRecursiveFast(x, n));
    }
}
