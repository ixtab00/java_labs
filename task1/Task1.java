public class Task1 {
    public static void main(String[] args) {
        System.out.println(remainder(1, 3));
        System.out.println(triArea(3, 2));
        System.out.println(animals(2, 3, 5));
        System.out.println(profitableGamble(0.2, 50, 9));
        System.out.println(operation(24, 15, 9));
        System.out.println(ctoa('A'));
        System.out.println(addUpTo(3));
        System.out.println(nextEdge(8, 10));
        int[] arr = new int[] {1, 5, 9};
        System.out.println(sumOfCubes(arr));
        System.out.println(abcmath(42, 5, 10));
    }
    public static int remainder(int p, int q) {
        return p % q;
    }
    public static double triArea(double a, double h) {
        return 0.5 * a * h;
    }
    public static int animals(int ch, int co, int pi) {
        return ch * 2 + co * 4 + pi * 4;
    }
    public static boolean profitableGamble(double prob, double prize, double pay) {
        if (prob * prize > pay) {
            return true;
        }
        else {
            return false;
        }
    }
    public static String operation(double N, double a, double b) {
        if (a + b == N) {
            return "added";
        }
        else if (a - b == N) {
            return "substracted";
        }
        else if (a * b == N) {
            return "multiplied";
        }
        else if (a / b == N) {
            return "divided";
        }
        else {
            return "none";
        }
    }
    public static int ctoa(char sym) {
        int a = sym;
        return a;
    }
    public static int addUpTo(int limit) {
        return ((1 + limit) * limit)/2;
    }
    public static int nextEdge(int a, int b) {
        return a + b - 1;
    }
    public static int sumOfCubes(int[] array) {
        int summ = 0;
        for (int i = 0; i < array.length; i++) {
            summ += array[i] * array[i] * array[i];
        }
        return summ;
    }
    public static boolean abcmath(int a, int b, int c) {
        for (int i = 0; i < b; i++) {
            a*=2;
        }
        if (a % c == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}