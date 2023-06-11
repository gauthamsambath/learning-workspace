package DSAProblems;

import java.util.Arrays;

public class WordSearch {
    public static void main(String[] args) {
        char[][] crossWord = {{'g', 'a', 'i', 'l'},
                {'c', 'u', 't', 'i'},
                {'e', 'r', 'h', 'a'},
                {'x', 'l', 'e', 'm'}};

        String wordToSearch = "gaitam";
        Boolean ifWordPresent = checkIfWordPresentInCrossword(wordToSearch, crossWord);
        String verdict = ifWordPresent ? " is present " : " is not present ";
        System.out.println("The given word " + wordToSearch + verdict + " in the crossword \n" + Arrays.deepToString(crossWord));
    }

    private static Boolean checkIfWordPresentInCrossword(String wordToSearch, char[][] crossWord) {
        char[][] crosswordCopied = copyArrayAndReturn(crossWord);
        for (int i = 0 ;i < crosswordCopied.length;i++) {
            for (int j= 0; j < crosswordCopied[i].length;j++) {
                if (wordToSearch.charAt(0) == crosswordCopied[i][j] && (dfs(wordToSearch,crosswordCopied,i,j,0))){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(String wordToSearch, char[][] crosswordCopied, int i, int j, int count) {
        if ( count == wordToSearch.length()) {
            return true;
        }

        if (i < 0 || i >= crosswordCopied.length || j < 0 || j >=crosswordCopied[i].length || crosswordCopied[i][j] != wordToSearch.charAt(count)) {
            return false;
        }

        char temp = crosswordCopied[i][j];
        crosswordCopied[i][j] = ' ';

        boolean found = dfs(wordToSearch,crosswordCopied,i+1,j,count+1) ||
                dfs(wordToSearch,crosswordCopied,i-1,j,count+1) ||
                dfs(wordToSearch,crosswordCopied,i,j+1,count+1) ||
                dfs(wordToSearch,crosswordCopied,i,j-1,count+1);
        crosswordCopied[i][j] = temp;
        return found;
    }

    private static char[][] copyArrayAndReturn(char[][] crossWord) {
        char[][] copyOfArray = new char[crossWord.length][crossWord[0].length];
        int i =0;
        for (char[] arr:
                crossWord) {
            copyOfArray[i++] = Arrays.copyOf(arr,arr.length);
        }
        return copyOfArray;
    }


}
