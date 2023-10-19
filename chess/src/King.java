package chess.src;

/**
 * King Piece: Inherited from the abstract class Piece.
 * Includes string name "wK" if the king is a white piece.
 * Includes string name "bK" if the king is a black piece.
 * 
 * @author Juan Aracena
 * @author Brandon Valdberg
 */
public class King extends Piece{

    /**
     * King constructor: Initializes King referencing the Piece superclass.
     * 
     * @param row x coordinate of the designated position.
     * @param col y coordinate of the designated position.
     * @param isWhite
     * 
     * isWhite = true means that the piece is a white piece.
     * isWhite = false means that the piece is a black piece.
     */
    public King(int row, int col, boolean isWhite){
        super(row, col, isWhite);
    }

    @Override
    public String toString(){
        if(isWhite){
            return "wK";
        }
        return "bK";
    }

    @Override
    public boolean canMove(Piece[][] board, int newRow, int newCol) {
       
        if(board[newRow][newCol] != null && board[newRow][newCol].isWhite == isWhite) {
            return false;
        }

        if(!isValidPos(newRow, newCol)) {
            return false;
        }

        if(Math.abs(newRow - row) == 1 && Math.abs(newCol - col) == 1 || Math.abs(newRow - row) == 1 && newCol == col || Math.abs(newCol - col) == 1 && newRow == row) {
            return true;
        }
        return false;
    }
    
}
