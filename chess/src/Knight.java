package chess.src;
/**
 * Knight Piece. Inherited from the abstract class Piece.
 * Includes string name "wN" if the knight is a white piece.
 * Includes string name "bN" if the knight is a black piece.
 * 
 * @author Juan Aracena
 * @author Brandon Valdberg
 */
public class Knight extends Piece {

    /**
     * Knight constructor: Initializes Knight referencing superclass Piece.
     * 
     * @param row x coordinate of the designated position.
     * @param col y coordinate of the designated position.
     * @param isWhite
     * 
     * isWhite = true means that the piece is a white piece.
     * isWhite = false means that the piece is a black piece.
     */
    public Knight(int row, int col, boolean isWhite){
        super(row, col, isWhite);
    }

    @Override
    public String toString(){
        if(isWhite){
            return "wN";
        }
        return "bN";
    }

    @Override
    public boolean canMove(Piece[][] board, int newRow, int newCol) {
        
        if(board[newRow][newCol] != null && board[newRow][newCol].isWhite == isWhite) {
            return false;
        }

        if(isValidPos(newRow, newCol)) {
            if(Math.abs(newRow-row) == 1 && Math.abs(newCol-col) == 2) {
                return true;
            }

            if(Math.abs(newRow-row) == 2 && Math.abs(newCol-col) == 1) {
                return true;
            }
        }
        return false;
    }
    
}
