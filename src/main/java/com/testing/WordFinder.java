package com.testing;

public class WordFinder {

    public static void main(String[] args) {
        char[][] crossword = {{'g','a','u','t'},{'d','b','c','h'},{'d','e','f','a'},{'g','h','i','m'}};
        String word = "dd";
        boolean ifWordPresent = checkIfWordPresentInCrossWord(word,crossword);
        System.out.println("The word "+word+(ifWordPresent?" is ":" is not ")+"present in the crossword");
        System.out.println(crossword[0].length);
    }

    private static boolean checkIfWordPresentInCrossWord(String word, char[][] board) {
        int crossWordRowSize = board.length;
        int crossWordColumnSize = board[0].length;
        int lengthOfWord = word.length();
        for (int i = 0; i < crossWordRowSize; i++) {
            for (int j = 0; j < crossWordColumnSize; j++) {
                if (board[i][j] == word.charAt(0)){
                    boolean wordExist = doesWordExistInCrossWord(i,j,0,lengthOfWord,word,board);
                    if (wordExist){
                        return true;
                    }
                }

            }
        }
        return false;
    }

    private static boolean doesWordExistInCrossWord(int i, int j, int lengthCaptured, int lengthOfWord, String word, char[][] crossword) {
        if (lengthCaptured == lengthOfWord){
            return true;
        }

        int lenCap = lengthCaptured;

        if (i<0||i>=crossword.length||j<0||j>=crossword[0].length||crossword[i][j]!=word.charAt(lengthCaptured)){
            return false;
        }

        char tempStorage = crossword[i][j];
        crossword[i][j] = '_';

        boolean ifPresent = false;

        if (word.charAt(lengthCaptured) == tempStorage){
            lenCap++;
            ifPresent = doesWordExistInCrossWord(i+1,j,lenCap,lengthOfWord,word,crossword)||
                    doesWordExistInCrossWord(i-1,j,lenCap,lengthOfWord,word,crossword)||
                    doesWordExistInCrossWord(i,j+1,lenCap,lengthOfWord,word,crossword)||
                    doesWordExistInCrossWord(i,j-1,lenCap,lengthOfWord,word,crossword);

        }

        crossword[i][j] = tempStorage;

        return ifPresent;
    }
}
