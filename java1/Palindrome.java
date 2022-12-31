public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++)
        {
            System.out.print(args[i] + " - ");
            if (isPalindrome(args[i])) {
                System.out.println("palindrome");
            }
            else {
                System.out.println("not palindrome");
            }
        }
    }
    public static String reverseString(String string) {
        String reversed = "";
        for (int i = string.length() - 1; i >= 0; i--) {
            reversed += string.charAt(i);
        }
        return reversed;
    }
    public static boolean isPalindrome(String string) {
        String reversed = reverseString(string);
        return reversed.equals(string);
    }
}
