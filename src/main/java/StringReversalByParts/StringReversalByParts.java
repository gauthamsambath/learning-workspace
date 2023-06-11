package StringReversalByParts;

//"one two three"
//        output: three two one
//        String str = "one two three"

//char[] c = str.toCharArray();
//        reverseWords(c);
//        String output = new String(c);
//        three two one

import java.util.Arrays;

//one two three
//
//ene owt eerht
//three two one
public class StringReversalByParts {
    public static void main(String[] args) {
        String str = "three three five";
        System.out.println();
        char[] c = str.toCharArray();
        System.out.println(Arrays.toString(c));
        reverseWords(c);
    }

    private static void reverseWords(char[] c) {
        int beg = 0;
        int last ;
        for (int i = 0; i < c.length; i++) {
//            System.out.println("i = "+i);
            if (c[i] == ' ' || i == c.length - 1) {
                System.out.println("i =" + i);
                last = i - 1;
                if (i == c.length - 1) {
                    last = i;
                }
                System.out.println("beg = " + beg + "last = " + last);
                for (int k = last, j = beg; (j <=(beg + last) / 2) && (k >= (beg + last) / 2); j++, k--) {
                    System.out.println(" k = " + k + " j = " + j);
                    char temp = c[j];
                    c[j] = c[k];
                    c[k] = temp;
                }
                beg = i + 1;
            }
        }

        for (int i = c.length-1; i >= 0; i--) {
            System.out.print(c[i]);
        }
    }
}
