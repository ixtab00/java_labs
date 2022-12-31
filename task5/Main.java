import java.util.ArrayList;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class Main{
    static public void main(String argv[]){
        int[] enc = {72, 29, 7, 0, 3};
        System.out.println(decrypt(enc));
        System.out.println(canMove("пешка", "A8", "H8"));
        System.out.println(canComplete("butl", "beautiful"));
        System.out.println(sumDigProd(16, 28));
        String[] arr = {"toe", "ocelot", "maniac"};
        System.out.println(sameVowelGroup(arr));
        System.out.println(validateCard("1234567890123456"));
        System.out.println(numToEng(32));
        System.out.println(getSha256Hash("password123"));
        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));
        System.out.println(hexLattice(19));

    }

    static public int[] encrypt(String string){
        int[] encrypted = new int[string.length()];
        for (int i = 1;i<string.length();i++){
            encrypted[i] = string.charAt(i) - string.charAt(i-1);
        }
        return encrypted;
    }
    static public String decrypt(int[] encoded){
        StringBuilder decrypted = new StringBuilder(encoded.length);
        decrypted.append((char) encoded[0]);
        for (int i = 1; i < encoded.length; i++){
            decrypted.append((char)(encoded[i]+decrypted.charAt(i-1)));
        }
        return decrypted.toString();
    }
    static public boolean canMove(String figure, String start, String end){
        if (figure.toLowerCase() == "пешка"){
            if (end.charAt(1)- start.charAt(1) > 2){
                return false;
            }
            else{
                return true;
            }
        }
        else if (figure.toLowerCase() == "конь"){
            int horVel = Math.abs(end.charAt(0) - start.charAt(0));
            int verVel = Math.abs(end.charAt(1) - start.charAt(1));
            if (horVel + verVel == 3)
                return true;
            else
                return false;
        }
        else if (figure.toLowerCase() == "cлон"){
            int horVel = Math.abs(end.charAt(0) - start.charAt(0));
            int verVel = Math.abs(end.charAt(1) - start.charAt(1));
            if (horVel != 0 & verVel != 0){
                return false;
            }
            else
                return true;
        }
        else if (figure.toLowerCase() == "ладья"){
            int horVel = Math.abs(end.charAt(0) - start.charAt(0));
            int verVel = Math.abs(end.charAt(1) - start.charAt(1));
            if (horVel != verVel)
                return false;
            else
                return true; 
        }
        else if (figure.toLowerCase() == "ферзь"){
            if (canMove("слон", start, end) || canMove("ладья", start, end))
                return true;
            else
                return false;
        }
        else if (figure.toLowerCase() == "король"){
            int horVel = Math.abs(end.charAt(0) - start.charAt(0));
            int verVel = Math.abs(end.charAt(1) - start.charAt(1));
            if (horVel == 1 || verVel == 1)
                return true;
            else
                return false;
        }
        else
            return false;
    }
    static public boolean canComplete(String source, String toComplete){
        int[] matches = new int[source.length()];
        for (int i = 0;i < source.length(); i++)
            matches[i] = toComplete.indexOf(source.charAt(i));
        if (matches[0] == -1)
            return false; 
        for (int i = 1; i < source.length(); i++){
            if (matches[i] == -1)
                return false;
            if (matches[i] < matches[i-1])
                return false;
        }
        return true;
    }
    static public int sumDigProd(int a, int b){
        int sum = a + b;
        String stringSum = Integer.toString(sum);
        
        while (stringSum.length() > 1){
            sum = 1;
            for (int i = 0; i < stringSum.length(); i++){
                sum *= stringSum.charAt(i)-48;
            }
            stringSum = Integer.toString(sum);
        }
        return sum;
    }
    static public ArrayList<String> sameVowelGroup(String[] words){
        ArrayList<String> result = new ArrayList<String>();
        result.add(words[0]);
        String mainWord = words[0];
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
        StringBuilder mainWordMap = new StringBuilder(6);

        for (int i = 0; i < 6; i++){
            if (mainWord.indexOf(vowels[i]) != -1)
                mainWordMap.append('1');
            else
                mainWordMap.append('0');
        }
        String pattern = mainWordMap.toString();
        for (int i = 1; i < words.length; i++){
            StringBuilder wordMap = new StringBuilder(6);
            for (int j = 0; j < 6; j++){
                if (words[i].indexOf(vowels[j]) != -1)
                    wordMap.append('1');
                else
                    wordMap.append('0');
            }
            if (wordMap.toString().equals(pattern)){
                result.add(words[i]);
            }
        }
        return result;
    }
    static public boolean validateCard(String numStr){
        int control = numStr.charAt(numStr.length()-1) - 48;
        numStr = "" + numStr.subSequence(0, numStr.length()-1);
        StringBuilder reversed = new StringBuilder(numStr.length());
        for (int i = numStr.length()-1; i >= 0; i--)
            reversed.append(numStr.charAt(i));
        for (int i = 1; i < numStr.length(); i+=2){
            int val = reversed.charAt(i) - 48;
            val *= 2;
            if (val > 10)
                val = val - 9;
            reversed.setCharAt(i, (char)(val + 48));
        }
        int summ = 0;
        for (int i = 0; i < numStr.length(); i++){
            summ += numStr.charAt(i) - 48;
        }
        if (10 - summ%10 == control)
            return true;
        else
            return false;
    }
    public static String numToEng(int num){
        if (num == 0)
            return "zero";
        else if (num == 1)
            return "one";
        else if (num == 2)
            return "two";
        else if (num == 3)
            return "three";
        else if (num == 4)
            return "four";
        else if (num == 5)
            return "five";
        else if (num == 6)
            return "six";
        else if (num == 7)
            return "seven";
        else if (num == 8)
            return "eight";
        else if (num == 9)
            return "nine";
        else if (num == 10)
            return "ten";
        else if (num == 11)
            return "eleven";
        else if (num == 12)
            return "twelve";
        else if (num == 13)
            return "thirteen";

        if (num/100 < 1){
            int firstDigit = (num - num%10)/10;
            if (firstDigit == 1){
                return numToEng(num%10) + "teen";
            }
            else if (firstDigit == 2)
                return "twenty " + numToEng(num%10);
            else if (firstDigit == 3)
                return "thitry " + numToEng(num%10);
            else if (firstDigit == 4)
                return "fourty " + numToEng(num%10);
            else if (firstDigit == 5)
                return "fifty " + numToEng(num%10);
            else if (firstDigit == 6)
                return "sixty " + numToEng(num%10);
            else if (firstDigit == 7)
                return "seventy " + numToEng(num%10);
            else if (firstDigit == 8)
                return "eighty " + numToEng(num%10);
            else if (firstDigit == 9)
                return "ninety " + numToEng(num%10);
        }
        else{
            int firstDigit = (num - num%100)/100;
            return numToEng(firstDigit) + " hundred " + numToEng(num%100);
        }
        return "";
    }
    public static String getSha256Hash(String str){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = md.digest(str.getBytes(StandardCharsets.UTF_8));
            StringBuffer result = new StringBuffer();
            for (byte b : encodedhash) result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            return result.toString();
        }
        catch (NoSuchAlgorithmException e){return "";}
    }
    public static String correctTitle(String wrongTitle){
        String[] words = wrongTitle.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++){
            words[i] = words[i].toLowerCase();
            String[] subWords = words[i].split("-");
            for (int j = 0; j < subWords.length; j++){
                if (!(subWords[j].startsWith("of") || subWords[j].startsWith("and") || subWords[j].startsWith("in") || subWords[j].startsWith("the"))){
                result.append(subWords[j].subSequence(0, 1).toString().toUpperCase() + subWords[j].substring(1));}
                else
                result.append(subWords[j]);
                result.append('-');
            }
            result.deleteCharAt(result.length()-1);
            result.append(' ');
        }
        return result.toString();
    }
    public static String hexLattice(int num){
        double k = (Math.sqrt(num*12-3) + 3)/6;
        String dr1 = " 0";
        String dr2 = "0 ";
        String a = new String();
        if (k - (int)k == 0){
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < (int)k -1; i++){
                if (i%2 == 1){a = dr1;}
                else{a = dr2;}
                StringBuilder temp = new StringBuilder(2*(int)k - 1);
                for (int j = 0; j < (2*(int)k - 1 - (int)k - i)/2; j++)
                    temp.append("  ");
                for (int j = 0; j < (int)k + i; j++)
                    temp.append(a);
                for (int j = 0; j < (2*(int)k - 1 - (int)k - i)/2; j++)
                    temp.append("  ");
                res.append(temp.append('\n').toString());
            }
            if (a.equals(dr1)){a = dr2;}
            else {a = dr1;}
            for (int j = 0; j < (int)k*2 - 1; j++)
                res.append(a);
            res.append('\n');
                for (int i = (int) k - 2; i >= 0; i--){
                    if (i%2 == 1){a = dr1;}
                    else{a = dr2;}

                    StringBuilder temp = new StringBuilder(2*(int)k - 1);
                    for (int j = 0; j < (2*(int)k - 1 - (int)k - i)/2; j++)
                        temp.append("  ");
                    for (int j = 0; j < (int)k + i; j++)
                        temp.append(a);
                    for (int j = 0; j < (2*(int)k - 1 - (int)k - i)/2; j++)
                        temp.append( "  ");
                    res.append(temp.append('\n').toString());
            }
            return res.toString();          
        }
        else{
            return "incorrect";
        }
    }
}
