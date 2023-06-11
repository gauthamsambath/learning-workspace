package Tracxn;

import java.util.*;

public class SpecialCharacterHashing {
    public static void main(String[] args) {
        String inputStr = "-+*++-*++-";
        int subStrLength = 3;
        Map<Character,Integer> characterPrecedenceMap = new HashMap<>();
        characterPrecedenceMap.put('*',0);
        characterPrecedenceMap.put('+',1);
        characterPrecedenceMap.put('-',2);
        List<String> listOfString = new ArrayList<>();
        for (int j = 0; j < inputStr.length(); j = j+subStrLength) {
            if (j+subStrLength>inputStr.length()-1){
                listOfString.add(inputStr.substring(j,inputStr.length()));
            }else {
                listOfString.add(inputStr.substring(j,j+subStrLength));
            }
        }
        Map<String,Integer> countMap = new HashMap<>();
        for (String element:listOfString){
            if(!countMap.containsKey(element)) {
                countMap.put(element,1);
            }else {
                countMap.put(element,countMap.get(element)+1);
            }
        }

        List<Map.Entry<String, Integer> > list =
                new LinkedList<>(countMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                if(o2.getValue().compareTo(o1.getValue()) == 0){
                    int size = o1.getKey().length();
                    int i =0;
                    char[] o1CharArray = o1.getKey().toCharArray();
                    char[] o2CharArray = o2.getKey().toCharArray();
                    while (i<size){
                        if (o1CharArray[i]!=o2CharArray[i]){
                            return characterPrecedenceMap.get(o1CharArray[i])<characterPrecedenceMap.get(o2CharArray[i])?-1:1;
                        }
                        i++;
                    }
                    return 0;
                }
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        String finalWord = new String();
        for (Map.Entry<String, Integer> aa : list) {
            finalWord = finalWord+aa.getKey();
        }

        System.out.println("finalword = "+finalWord);
    }
}
