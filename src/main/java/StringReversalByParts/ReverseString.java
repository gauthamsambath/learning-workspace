package StringReversalByParts;

public class ReverseString {
    public static void main(String[] args) {
        String stringToreverse = "four";
        String reversedString = reverseString(stringToreverse);
        System.out.println("reversed string = "+reversedString);
    }

    private static String reverseString(String stringToreverse) {
        char[] c =stringToreverse.toCharArray();
        int beg = 0;
        int last = c.length;
        int mid = (beg+last)/2;
        for (int i = 0,j=last-1; i <=mid&&j>=mid; i++,j--) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
        }

        String reversedString = new String(c);
        return reversedString;
    }
}
