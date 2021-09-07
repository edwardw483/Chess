import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//Data for Chess Game
public class ChessModel{
    //Properties
    private pieces board[][];
    private boolean whiteMove;
    //Methods
    public void createBoard(){
        board = new pieces[8][8];
        int row = 0;
        //Create an array of the board
        for(int i = 0; i < 64; i++){
           //Count Rows
            if(i % 8 == 0 && i != 0){
                System.out.println("");
                row++;
            }
            //Create new object per array cell
            board[row][i % 8] = new pieces();

            //Dark Rooks
            if(i == 0 ||i == 7){
                board[row][i % 8].name = "dr";
                board[row][i % 8].colour = "dark";
                board[row][i % 8].movedFromInitial = false;
                System.out.print("dr");
            }
            //Dark Knigts
            else if(i == 1 ||i == 6){
                board[row][i % 8].name = "dn";
                board[row][i % 8].colour = "dark";
                board[row][i % 8].movedFromInitial = false;
                System.out.print("dn");
            }
            //Dark Bishops
            else if(i == 2 ||i == 5){
                board[row][i % 8].name = "db";
                board[row][i % 8].colour = "dark";
                board[row][i % 8].movedFromInitial = false;
                System.out.print("db");
            }
            //Dark Queen
            else if(i == 3){
                board[row][i % 8].name = "dq";
                board[row][i % 8].colour = "dark";
                board[row][i % 8].movedFromInitial = false;
                System.out.print("dq");
            }
            //Dark King
            else if(i == 4){
                board[row][i % 8].name = "dk";
                board[row][i % 8].colour = "dark";
                board[row][i % 8].movedFromInitial = false;
                System.out.print("dk");
            }
            //Dark Pawns
            else if(i >= 8 && i < 16){
                board[row][i % 8].name = "dp";
                board[row][i % 8].colour = "dark";
                board[row][i % 8].movedFromInitial = false;
                System.out.print("dp");
            }
            //Light Rooks
            else if(i == 56 ||i == 63){
                board[row][i % 8].name = "lr";
                board[row][i % 8].colour = "light";
                board[row][i % 8].movedFromInitial = false;
                System.out.print("lr");
            }
            //Light Knigts
            else if(i == 57 ||i == 62){
                board[row][i % 8].name = "ln";
                board[row][i % 8].colour = "light";
                board[row][i % 8].movedFromInitial = false;
                System.out.print("ln");
            }
            //Light Bishops
            else if(i == 58 ||i == 61){
                board[row][i % 8].name = "lb";
                board[row][i % 8].colour = "light";
                board[row][i % 8].movedFromInitial = false;
                System.out.print("lb");
            }
            //Light Queen
            else if(i == 59){
                board[row][i % 8].name = "lq";
                board[row][i % 8].colour = "light";
                board[row][i % 8].movedFromInitial = false;
                System.out.print("lq");
            }
            //Light King
            else if(i == 60){
                board[row][i % 8].name = "lk";
                board[row][i % 8].colour = "light";
                board[row][i % 8].movedFromInitial = false;
                System.out.print("lk");
            }
            //Light Pawns
            else if(i >= 48 && i < 56){
                board[row][i % 8].name = "lp";
                board[row][i % 8].colour = "light";
                board[row][i % 8].movedFromInitial = false;
                System.out.print("lp");
            }
            //Otherwise Empty
            else{
                board[row][i % 8].name = "NA";
                board[row][i % 8].colour = "NA";
                board[row][i % 8].movedFromInitial = false;
                System.out.print("NA");
            }
            //Set Position of each Piece
            board[row][i % 8].position = i;
        }
    }
    public boolean checkMove(Point currentPos, Point desiredPos){
        boolean validMove = false;
        int currentRow = currentPos.y / 100;
        int currentColumn = currentPos.x / 100;
        int desiredRow = desiredPos.y / 100;
        int desiredColumn = desiredPos.x / 100;
        //Invalid if out of bounds
        if(desiredPos.y > 800 || desiredPos.y < 0|| desiredPos.x > 800 || desiredPos.x < 0){
            validMove = false;
            return validMove;

        }
        //Check Pieces if Valid
        else{
            //Dark Turn
            if(board[currentRow][currentColumn].name.substring(0,1).equals("d") && whiteMove == false){
                System.out.println("dark");
                //Pawn
                if(board[currentRow][currentColumn].name.substring(1,2).equals("p")){
                    //Moving pawn from inital position
                    if(board[currentRow][currentColumn].movedFromInitial == false){
                        //If desired location is in correct rows and the path is clear
                        if(desiredRow == 3 && board[2][currentColumn].name.equals("NA")){
                            //If empty location and same column 
                            if(board[desiredRow][currentColumn].name.equalsIgnoreCase("NA") && currentColumn == desiredColumn){
                                validMove = true;
                                whiteMove = true;
                                board[currentRow][currentColumn].movedFromInitial = true;
                                board[desiredRow][currentColumn].name = board[currentRow][currentColumn].name;
                                board = resetCellProperties(board, currentColumn, currentRow);
                            }
                        }
                    }
                }
            }
            //Light Turn
            else if(board[currentRow][currentColumn].name.substring(0,1).equals("l") && whiteMove == true){
                System.out.println("light");
                //Pawn
                if(board[currentRow][currentColumn].name.substring(1,2).equals("p")){
                    //Moving pawn from inital position
                    if(board[currentRow][currentColumn].movedFromInitial == false){
                        //If desired location is in correct rows and the path is clear
                        if(desiredRow == 4 && board[5][currentColumn].name.equals("NA")){
                            //If empty location and same column 
                            if(board[desiredRow][currentColumn].name.equalsIgnoreCase("NA") && currentColumn == desiredColumn){
                                validMove = true;
                                whiteMove = false;
                                board[currentRow][currentColumn].movedFromInitial = true;
                                board[desiredRow][currentColumn].name = board[currentRow][currentColumn].name;
                                board = resetCellProperties(board, currentColumn, currentRow);
                            }
                        }
                    }
                }
            }
        }
        
        return validMove;
    }
    public pieces[][] resetCellProperties(pieces[][] board, int col, int row){
        board[row][col].name = "NA";
        board[row][col].colour = "NA";
        board[row][col].movedFromInitial = false;
        board[row][col].position = row * 8 + col;

        return board;
    }
    public ChessModel(){
        this.createBoard();
        whiteMove = true;
    }
}