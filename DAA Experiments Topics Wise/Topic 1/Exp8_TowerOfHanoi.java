public class Exp8_TowerOfHanoi {
    static void hanoi(int n, char from, char aux, char to) {
        if (n == 0) return;
        hanoi(n - 1, from, to, aux);
        System.out.println("Move disk " + n + " from " + from + " to " + to);
        hanoi(n - 1, aux, from, to);
    }

    public static void main(String[] args) {
        int n = 3;
        hanoi(n, 'A', 'B', 'C');
    }
}
