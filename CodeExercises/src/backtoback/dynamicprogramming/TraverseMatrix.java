package backtoback.dynamicprogramming;

public class TraverseMatrix {

    public int solution(int rows, int cols){
        int[][] matrix = new int[rows][cols];

        for(int idx = 0; idx < rows; idx++){
            matrix[idx][0] = 1;
        }

        for(int idy = 0; idy < cols; idy++){
            matrix[0][idy] = 1;
        }

        for(int idx = 1; idx < rows; idx++){
            for(int idy = 1; idy < cols; idy++){
                int prevRow = matrix[idx - 1][idy];
                int prevCol = matrix[idx][idy - 1];
                matrix[idx][idy] = prevRow + prevCol;
            }
        }
        return matrix[rows - 1][cols - 1];
    }

    public static void main(String args[]){
        TraverseMatrix tm = new TraverseMatrix();
        int result = tm.solution(3, 3);
        tm.evaluateResult(6, result);
    }

    public void evaluateResult(int expected, int actual){
        if(expected == actual){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL, expected: " + expected + ", actual: " + actual);
        }
        
    }
}