import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        System.out.println(solutions(1, 0, -1));
        System.out.println(solutions(1, 0, 0));
        System.out.println("\n");
        System.out.println(findZip("all zip files are zipped"));
        System.out.println(findZip("all zip files are compressed"));
        System.out.println("\n");
        System.out.println(checkPerfect(6));
        System.out.println(checkPerfect(12));
        System.out.println("\n");
        System.out.println(flipEndChars("Cat, dog, and mouse."));
        System.out.println(flipEndChars("z"));
        System.out.println("\n");
        System.out.println(isValidHexCode("#CD5C5C"));
        System.out.println(isValidHexCode("#CD5C5Z"));
        System.out.println("\n");
        Integer[] arr1 = new Integer[] {1, 3, 4, 4, 4};
        Integer[] arr2 = new Integer[] {2, 5, 7};
        System.out.println(same(arr1, arr2));
        System.out.println("\n");
        System.out.println(isKaprekar(297));
        System.out.println(isKaprekar(3));
        System.out.println("\n");
        System.out.println(longestZero("01100001011000"));
        System.out.println(longestZero("111"));
        System.out.println("\n");
        System.out.println(nextPrime(12));
        System.out.println(nextPrime(11));
        System.out.println("\n");
        System.out.println(rightTriangle(3, 4, 5));
        System.out.println(rightTriangle(70, 130, 110));
    }
    public static int solutions(double a, double b, double c) {
        double disc = b * b - 4 * a * c;
        if (disc > 0) return 2;
        else if (disc == 0) return 1;
        else return 0;
    }
    public static int findZip(String str) { 
        int index = str.indexOf("zip");
        return str.indexOf("zip", index+1);
    }
    public static boolean checkPerfect(int value){
        ArrayList<Integer> divisors = new ArrayList<Integer>();
        for (int i = 1; i < value; i ++){
            if (value%i == 0) divisors.add(i);
        }
        int divSumm = 0;
        for (int i = 0; i < divisors.size(); i++)
            divSumm += divisors.get(i);
        return value == divSumm;
    }
    public static String flipEndChars(String arg){
        int argLen = arg.length();
        if (arg.length() < 2) return "Incompitable";
        if (arg.charAt(0) == arg.charAt(argLen-1)) return "Two's a pair.";
        return arg.charAt(argLen-1) + "" + arg.substring(1, argLen - 1) + arg.charAt(0);
    }
    public static boolean isValidHexCode(String hex){
        if (hex.charAt(0) != '#' || hex.length()!=7) return false;
        String validChars = "#0123456789ABCDEF";
        for (int i = 0; i < hex.length(); i++)
            if(validChars.indexOf(hex.charAt(i)) == -1) return false;
        return true;
    }
    public static boolean same(Integer[] first, Integer[] second){
        HashSet<Integer> arrSetFirst = new HashSet<Integer>(Arrays.asList(first));
        HashSet<Integer> arrSetSecond = new HashSet<Integer>(Arrays.asList(second));
        return arrSetFirst.size() == arrSetSecond.size();
    }
    public static boolean isKaprekar(int num){
        Integer sqr = num * num;
        String sqrAsString = sqr.toString();
        int left, right;
        if (sqrAsString.length() == 1) {left = 0; right = sqr;}
        else {
            left = Integer.parseInt(sqrAsString.substring(0, (sqrAsString.length()-sqrAsString.length()%2)/2));
            right = Integer.parseInt(sqrAsString.substring((sqrAsString.length()-sqrAsString.length()%2)/2, sqrAsString.length()));
        }
        return (left + right) == num;
    }
    public static String longestZero(String seq){
        int longest = 0;
        int curLen = 0;
        String result = "";
        for (int i = 0; i < seq.length(); i++){
            if (seq.charAt(i) == '0') curLen++; else curLen = 0;
            if (curLen > longest) longest = curLen;
        }
        for (int i = 0; i < longest; i++) result += "0";
        return result;
    }
    public static int nextPrime(int num){
        int curNum = num;
        while (true){
            int numDivisors = 2;
            for (int i = 2; i < Math.sqrt(curNum) + 1; i++){
                if (curNum%i == 0) numDivisors++;
            }
            if (numDivisors == 2) return curNum;
            curNum++;
        }
    }
    public static boolean rightTriangle(int x, int y, int z){
        return ((x*x) == (y*y) + (z*z)) || ((x*x) + (y*y) == (z*z)) || ((y*y) == (x*x) + (z*z));
    }
}