package chess.src;

import java.util.Scanner;

/**
 * Chess class: The main method runs the entire program.
 * Two players can provide input for the black and white pieces.
 * The board will update depending on the input received.
 * The main method will call previous classes and methods.
 * 
 * @author Juan Aracena
 * @author Brandon Valdberg
 */
public class Chess {

    public static void main(String[] args){

        int whiteEPR = -1;
        int whiteEPC = -1;
        int blackEPR = -1;
        int blackEPC = -1;
        boolean isWhite = true;
        boolean resign = false;
        boolean draw = false;

        Board board = new Board();
        Scanner input = new Scanner(System.in);

        while(true) {
            
            if(isWhite) {
                whiteEPR = -1;
                whiteEPC = -1;
            } else {
                blackEPR = -1;
                blackEPC = -1;
            }

            if(board.isInCheckmate(isWhite)) {
                System.out.println("Checkmate");

                if(isWhite) {
                    
                    System.out.println("Black wins"); 
                } else {

                    System.out.println("White wins");
                }
                break;
            }

            if(board.isInCheck(isWhite)) {
                System.out.println("Check");
            }

            board.printBoard();

            while(true) {
                if(!isWhite) {
                    System.out.println("Black's move: ");
                }


                if (isWhite){
                    System.out.println("White's move: ");

                }

                String line = input.nextLine();

                String[] temp = line.split(" ");

                if(temp.length == 3) {
                    
                    if(temp[2].equalsIgnoreCase("draw?")) {
                    
                        System.out.println("draw");
                        draw = true;
                        break;
    
                    }
                }

                if(temp[0].equalsIgnoreCase("resign")) {
                    if(isWhite) {
                        System.out.println("Black wins");
                    }
                    else {
                        System.out.println("White wins");
                    }
                    resign = true;
                    break;
                }

                

                String filerank1 = temp[0];
                String filerank2 = temp[1];
                int row = 8 - (filerank2.charAt(1) - '0');
                int col = filerank2.charAt(0) - 'a';
                int row1 = 8 - (filerank1.charAt(1) - '0');
                int col1 = filerank1.charAt(0) - 'a';

                if(isWhite && board.board[row1][col1] instanceof Pawn && Math.abs(col1 - blackEPC) == 1 && row1 == blackEPR && row == row - 1 && col == blackEPC) {
                    
                    board.board[row][col] = board.board[row1][col1];
                    board.board[row][col].col = col;
                    board.board[row][col].row = row;
                    board.board[row1][col1] = null;
                    board.board[blackEPR][blackEPC] = null;
                    break;
                }

                if(!isWhite && board.board[row1][col1] instanceof Pawn && Math.abs(col1 - whiteEPC) == 1 && row1 == whiteEPR && row == row1 + 1 && col == whiteEPC) {
                    
                    board.board[row][col] = board.board[row1][col1];
                    board.board[row][col].col = col;
                    board.board[row][col].row = row;
                    board.board[row1][col1] = null;
                    board.board[whiteEPR][whiteEPC] = null;
                    break;
                }

                if(board.makeMove(filerank1, filerank2, isWhite)) {
                    
                    if(isWhite && filerank2.charAt(1) == '8' && board.board[row][col] instanceof Pawn) {
                        if(temp.length > 2) {
                            
                            if (temp[2].equalsIgnoreCase("Q")) {
                                board.board[row][col] = new Queen(row, col, true);
                            }

                            if (temp[2].equalsIgnoreCase("N")) {
                                board.board[row][col] = new Knight(row, col, true);
                            }

                            if (temp[2].equalsIgnoreCase("R")) {
                                board.board[row][col] = new Rook(row, col, true);
                            }

                            if (temp[2].equalsIgnoreCase("B")) {
                                board.board[row][col] = new Bishop(row, col, true);
                            }
                        }
                        else {
                            board.board[row][col] = new Queen(row, col, true);
                        }
                    }

                    if(!isWhite && filerank2.charAt(1)=='1' && board.board[row][col] instanceof Pawn) {
                        
                        if(temp.length > 2) {

                            if (temp[2].equalsIgnoreCase("Q")) {
                                board.board[row][col] = new Queen(row, col, false);
                            }
    
                            if (temp[2].equalsIgnoreCase("N")) {
                                board.board[row][col] = new Knight(row, col, false);
                            }
    
                            if (temp[2].equalsIgnoreCase("R")) {
                                board.board[row][col] = new Rook(row, col, false);
                            }
    
                            if (temp[2].equalsIgnoreCase("B")) {
                                board.board[row][col] = new Bishop(row, col, false);
                            }
                        }
                        else {
                            board.board[row][col] = new Queen(row, col, false);
                        }
                        
                    }

                    if(isWhite && board.board[row][col] instanceof Pawn && Math.abs(row - row1) == 2) {
                        whiteEPR = row;
                        whiteEPC = col;
                    }

                    if (!isWhite && board.board[row][col] instanceof Pawn && Math.abs(row-row1)==2) {
                        blackEPR = row;
                        blackEPC = col;
                    }
                    break;
                }
                else {
                    System.out.println("Illegal move, try again\n");

                }
            }
            if (resign) {
                break;
            }

            if(draw) {
                break;
            }

            isWhite = !isWhite;


        }

        input.close();

    }
}
