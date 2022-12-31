class Main{
    public static void main(String[] args) {
        System.out.println(repeat("awu", 3));
        int[] arr = new int[] {10, 4, 1, 4, -10, -50, 32, 21};
        System.out.println(differenceMaxMin(arr));
        int[] arr1 = new int[] {1, 3};      
        System.out.println(isAvgWhole(arr1));
        int[] arr2 = new int[] {1, 2, 3};
        int[] res = cumulativeSum(arr2);
        for (int i = 0; i< res.length; i++)
        {
            System.out.print(Integer.toString(res[i]) + " ");
        }
        System.out.print("\n");
        System.out.println(getDecimalPlaces("43.20"));
        System.out.println(Fibonacci(2));
        System.out.println(isValid("59001"));
        System.out.println(isStrangePair("ratio", "orator"));
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(boxSeq(2));
    }
    public static String repeat(String arg, int amount) {
        String result = "";
        result += arg.charAt(0);
        int index = 0;
        for (int i = 0; i< arg.length()*amount; i++) {
            if ((i+1)%amount == 0) {
                index += 1;
            }
            if (index < arg.length()){
                result += arg.charAt(index);
            }
        }
        return result;
    }
    public static int differenceMaxMin(int[] array){
        int max = 0;
        int min = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] < min){
                min = array[i];
            }
            if (array[i] > max){
                max = array[i];
            }
        }
        return max - min;
    }
    public static boolean isAvgWhole(int[] array){
        int summ  = 0;
        for (int i = 0; i < array.length; i++){
            summ += array[i];
        }
        if (summ % array.length == 0){
            return true;
        }
        return false;
    }
    public static int[] cumulativeSum(int[] argArray){
        int[] result = new int[argArray.length];
        for (int i = 0; i < argArray.length; i++){
            int curSumm = 0;
            for (int j = 0; j < i + 1; j++){
                curSumm += argArray[j];
            }
            result[i] = curSumm;
        }
        return result;
    }
    public static int getDecimalPlaces(String decimal) {
        int pos = 0;
        for (int i = 0; i < decimal.length(); i++){
            if (decimal.charAt(i) == '.'){
                pos = i;
            }
        }
        if (pos!=0) {
            return decimal.length() - pos - 1;
        }
        return pos;
    }
    public static int Fibonacci(int num){
        int cur = 1;
        int prev = 1;
        int temp = 0;
        if (num == 0){
            return cur;
        }
        else if (num == 1){
            return cur;
        }
        else {
            for (int i = 0; i < num; i++){
                temp = cur;
                cur = prev + cur;
                prev = temp;
            }
        }
        return cur;
    }
    public static boolean isValid(String arg){
        String digits = "0123456789";
        if (arg.length() != 5){
            return false;
        }
        for (int i = 0; i < 5; i++){
            if (!digits.contains(arg.charAt(i) + "")){
                return false;
            }
        }
        return true;
    }
    public static boolean isStrangePair(String first, String second){
        char ff = first.charAt(0);
        char lf = first.charAt(first.length() - 1);
        char fs = second.charAt(0);
        char ls = second.charAt(second.length() - 1);
        if ((ff == ls) & (fs == lf)){
            return true;
        }
        return false;
    }
    public static boolean isPrefix(String word, String prefix){
        prefix = prefix.substring(0, prefix.length() - 1);
        return word.startsWith(prefix);
    }
    public static boolean isSuffix(String word, String prefix){
        prefix = prefix.substring(1, prefix.length());
        return word.endsWith(prefix);
    }
    public static int boxSeq(int steps){
        int summ = 0;
        if (steps == 0){
            return summ;
        }
        for (int i = 1; i <= steps; i++){
            if (i%2 == 1){
                summ += 3;
            }
            else {
                summ -= 1;
            }
        }
        return summ;
    }
}