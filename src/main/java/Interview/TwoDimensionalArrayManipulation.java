package Interview;

import java.util.*;

//Input       1 -1 3
//            4 0 6
//           -5 -8 9
//
//output      0 0 0
//            0 0 6
//            0 0 0




//0,1

//                000
//                406
//               -509
//
//                000nn kn
//                006
//                000

public class TwoDimensionalArrayManipulation {


    public static void main(String[] args) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> columnSet = new HashSet<>();
        int[][] input = {{1,-1,3},{4,0,6},{-5,8,9}};
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] < 0) {
                    if (!rowSet.contains(i)) {
                        rowSet.add(i);
                        makeRowZero(input,i);
                    }
                    if (!columnSet.contains(j)) {
                        columnSet.add(j);
                        makeColumnZero(input,j);
                    }
                }
            }
        }


        System.out.println(Arrays.deepToString(input));
    }

    private static void makeRowZero(int[][] input, int i) {
        for (int k =0;k<input[i].length;k++){
            input[i][k] = 0;
        }
    }



    private static void makeColumnZero(int[][] input,int j) {
        for (int k = 0; k < input.length; k++) {
            input[k][j] = 0;
        }
    }

}
