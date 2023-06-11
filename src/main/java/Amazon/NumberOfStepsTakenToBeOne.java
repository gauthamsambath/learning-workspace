package Amazon;


//0101  -->


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberOfStepsTakenToBeOne {

    public static void main(String[] args) {
        String binaryNumber = "1001";
        int numberOfStepsToBeOne = finddNumberOfStepsToBecomeOne(binaryNumber);
        System.out.println("Number of steps required for the number = "+Integer.parseInt(binaryNumber,2)+
                "\nwhose binary representation is = "+binaryNumber+
                "\nto become one is = "+numberOfStepsToBeOne);
    }

    private static int finddNumberOfStepsToBecomeOne(String binaryNumber) {
        StringBuilder stringBuilder = new StringBuilder(binaryNumber);
        char[] binaryNumberArray = binaryNumber.toCharArray();
        int steps = 0;
        int flag = 0;
        while (flag==0){
            if (stringBuilder.charAt(stringBuilder.length()-1)=='0'){
                steps++;
                stringBuilder = new StringBuilder(stringBuilder.substring(0, stringBuilder.length() - 1));
            } else {
                addOneToBinary(stringBuilder);
                steps++;
            }
            binaryNumberArray = new String(stringBuilder).toCharArray();
            Map<Character,Integer> countOfZeroesAndOnes = new HashMap<>();
            countOfZeroesAndOnes.put('0',0);
            countOfZeroesAndOnes.put('1',0);
            for (Character a : binaryNumberArray){
                countOfZeroesAndOnes.put(a,countOfZeroesAndOnes.get(a)+1);
            }
            if (countOfZeroesAndOnes.get('1') == 1 && binaryNumberArray[binaryNumberArray.length-1]=='1'){
                flag =1;
            }
        }
        return steps;
    }

    private static void addOneToBinary(StringBuilder stringBuilder) {
        int i = stringBuilder.length()-1;
        while (stringBuilder.charAt(i)!='0' && i>=0){
            stringBuilder.replace(i,i+1,"0");
            i--;
        }
        stringBuilder.replace(i,i+1, "1");
    }
}
