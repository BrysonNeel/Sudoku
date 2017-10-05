import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import java.util.ArrayList;

public class Controller {

    @FXML ArrayList<GridPane> gridsList = new ArrayList();
    @FXML ArrayList<TextField> textFieldLists = new ArrayList();
    //0-8 = grid1; 9-17 = grid2; 18-26 = grid3; 27-35 = grid4; 36-44 = grid5; 45-53 = grid6; 54-62 = grid7; 62-71 = grid8; 72-80 = grid9;

    int[][] board = new int[9][9];  //A matrix to replicate the sudoku board and store a completed board

    public Controller () {
        //runs before initialize
    }

    @FXML public void initialize () {
        //runs after constructor
        generateCompletedBoard();
    }

    int randomWithRange(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    //generate a completed sudoku board
    private void generateCompletedBoard() {
        /*
        //each horizontal row is correct (no duplicate numbers in that row) at this point
        ArrayList<Integer> values = new ArrayList<>();
        for(int r = 0; r < board.length; r++) {

            for (int i = 1; i < 10; i++) {
                values.add(i);
            }

            for(int c = 0; c < board[r].length; c++) {
                int randomValue = randomWithRange(0, values.size() - 1);
                board[r][c] = values.get(randomValue);
                values.remove(randomValue);
            }

        }
        */

        //Fill every element with a temporary value of 1 to remove any possible 0s
        initializeMatrix();

        //Randomize each row while not containing any duplicates
        reassignRows();

        //Randomize each column while not containg any duplicates and while not interfering with the reassigned rows
        reassignColumns();

        //Print after row and column reassignment
        printMatrix();

        //Lastly, check each inner 3x3 grid while not interfering with the above reassigned rows and cols
        reassignInnerGrids();

        //print final matrix
        printMatrix();

    }

    private void initializeMatrix() {

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                board[r][c] = 1;
            }
        }
        System.out.println();
    }

    private void printMatrix() {

        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[r].length; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    private void reassignRows() {

        //Reassign any duplicate numbers in each row
        ArrayList<Integer> rowUsedNums = new ArrayList<>();
        for (int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[r].length; c++) {
                if (rowUsedNums.contains(board[r][c])) {
                    //replace this element with another random num that is not in the arraylist
                    while (rowUsedNums.contains(board[r][c])) {
                        int newRandomValue = randomWithRange(1, 9);
                        board[r][c] = newRandomValue;
                    }
                    rowUsedNums.add(board[r][c]);

                } else {
                    rowUsedNums.add(board[r][c]);
                }
                //System.out.println(rowUsedNums);
            }
            //System.out.println();
            rowUsedNums.clear();
        }

    }

    private void reassignColumns() {

        //Reassign any duplicate numbers in each column
        ArrayList<Integer> columnUsedNums = new ArrayList<>();
        for (int c = 0; c < board.length; c++) {
            for(int r = 0; r < board.length; r++) {
                if (columnUsedNums.contains(board[r][c])) {
                    //replace this element with another random num that is not in the arraylist
                    while (columnUsedNums.contains(board[r][c])) {
                        int newRandomValue = randomWithRange(1, 9);
                        board[r][c] = newRandomValue;
                    }
                    columnUsedNums.add(board[r][c]);

                } else {
                    columnUsedNums.add(board[r][c]);
                }
                //System.out.println(columnUsedNums);
            }
            //System.out.println();
            columnUsedNums.clear();
        }

    }

    private void reassignInnerGrids() {
        /*each individual grid is as follows:
            row: 0-2 = grid1, 3-5 = grid2, 6-8 = grid3
            col: 0-2 = grid1, 3-5 = grid2, 6-8 = grid3
         */

        //Reassign any duplicate numbers in each inner grid
        ArrayList<Integer> innerGridUsedNums = new ArrayList<>();
        for (int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[r].length; c++) {

                if (r >= 0 && r <= 2 &&
                    c >= 0 && c <= 2) {

                    //grid1,1

                } else if (r >= 0 && r <= 2 &&
                        c >= 3 && c <= 5) {
                    //grid1,2

                } else if (r >= 0 && r <= 2 &&
                        c >= 6 && c <= 8) {
                    //grid1,3

                }

                else if (r >= 3 && r <= 5 &&
                        c >= 0 && c <= 2) {
                    //grid2,1

                } else if (r >= 3 && r <= 5 &&
                        c >= 3 && c <= 5) {
                    //grid2,2

                } else if (r >= 3 && r <= 5 &&
                        c >= 6 && c <= 8) {
                    //grid2,3

                }

                else if (r >= 6 && r <= 8 &&
                        c >= 0 && c <= 2) {
                    //grid3,1

                } else if (r >= 6 && r <= 8 &&
                        c >= 3 && c <= 5) {
                    //grid3,2

                } else if (r >= 6 && r <= 8 &&
                        c >= 6 && c <= 8) {
                    //grid3,3

                }

            }
        }

    }

}

//TODO: Finish creating the check for each inner grid. That is the last part to the puzzle in creating a fully functional sudoku board