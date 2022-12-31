public class Primes {
    public static void main(String[] args) {
        for (int i = 2; (i <= 100); i++) {
            if (isPrime(i)) {
                System.out.print(i);
                System.out.println(" - prime");
            }
            else {
                System.out.print(i);
                System.out.println(" - not prime");
            }
        }
    }
    public static boolean isPrime(int n) {
        //проверка аргумента на простоту
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }   
        }
        return true;
    }
}