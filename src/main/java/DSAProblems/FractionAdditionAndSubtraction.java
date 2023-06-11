package DSAProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FractionAdditionAndSubtraction {
    public String fractionAddition(String expression) {
        String[] operatorsArray = Arrays.stream(expression.split("\\d|\\/"))
                .filter(a->!a.equals(""))
                .collect(Collectors.toList())
                .toArray(new String[0]);
        String[] fractionsArray = Arrays.stream(expression.split("\\+|\\-"))
                .filter(a->!a.equals(""))
                .collect(Collectors.toList())
                .toArray(new String[0]);

        List<Integer> numeratorsList = new ArrayList<>();
        List<Integer> denominatorsList = new ArrayList<>();

        setNumeratorsAndDenominatorsWithSign(numeratorsList,denominatorsList,operatorsArray,fractionsArray);

        String finalFraction = getFinalFraction(numeratorsList,denominatorsList);
        // System.out.println(Arrays.toString(operatorsArray));
        // System.out.println(Arrays.toString(fractionsArray));
        return finalFraction;
    }

    private void setNumeratorsAndDenominatorsWithSign(List<Integer> numeratorsList,List<Integer> denominatorsList,String[] operatorsArray,String[] fractionsArray) {
        for (int i = 0;i<fractionsArray.length;i++){
            String[] numAndDenArray = fractionsArray[i].split("\\/");
            String num = numAndDenArray[0];
            String den = numAndDenArray[1];
            if(operatorsArray.length<fractionsArray.length){
                if (i ==0) {
                    numeratorsList.add(Integer.valueOf("+"+num));
                    denominatorsList.add(Integer.valueOf(den));
                }else {
                    numeratorsList.add(Integer.valueOf(operatorsArray[i-1]+num));
                    denominatorsList.add(Integer.valueOf(den));
                }
            }else {
                numeratorsList.add(Integer.valueOf(operatorsArray[i]+num));
                denominatorsList.add(Integer.valueOf(den));
            }
        }

    }

    private String getFinalFraction(List<Integer> numeratorsList,List<Integer> denominatorsList){
        // System.out.println("numeratorsList = "+numeratorsList);
        // System.out.println("denominatorsList = "+denominatorsList);
        Integer finalDenominator = denominatorsList.stream().reduce(1, Math::multiplyExact);
        // System.out.println("finalDenominator = "+finalDenominator);
        Integer finalNumerator = 0;
        for(int i = 0 ;i < numeratorsList.size();i++) {
            finalNumerator+= (numeratorsList.get(i)*finalDenominator)/denominatorsList.get(i);
        }
        // System.out.println("finalNumerator = "+finalNumerator);
        int gcd = findGcd(Math.abs(finalNumerator),finalDenominator);
        return String.valueOf(finalNumerator/gcd)+"/"+String.valueOf(finalDenominator/gcd);
    }

    private int findGcd(Integer numerator,Integer denominator) {
        int min = Math.min(numerator,denominator);
        int max = Math.max(numerator,denominator);
        int divisor = min;
        int dividend = max;
        if (divisor == 0) {
            divisor = dividend;
        }else {
            while(dividend%divisor!=0) {
                int tempDividend = dividend;
                dividend = divisor;
                divisor = tempDividend%divisor;
            }
        }
        return divisor;
    }

    public static void main(String[] args) {
        String fractionExpression = "-41/59-39/53-23/19";
        FractionAdditionAndSubtraction fractionAdditionAndSubtraction = new FractionAdditionAndSubtraction();
        System.out.println("Answer in Fraction converted to lowest form ="+fractionAdditionAndSubtraction.fractionAddition(fractionExpression));
    }

}
