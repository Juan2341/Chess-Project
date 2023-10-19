package chess.src;

/**
 * Rook Piece: Inherited from the abstract class Piece.
 * Includes string name "wR" if the rook is a white piece.
 * Includes string nme "bR" if the rook is a black piece.
 * 
 * @author Juan Aracena
 * @author Brandon Valdberg
 */
public class Rook extends Piece{
    
    /**
     * Rook constructor: Initializes Rook referencing superclass Piece.
     * 
     * @param row x coordinate of the designated position.
     * @param col y coordinate of the designated position.
     * 
     * @param isWhite
     * 
     * isWhite = true means that the piece is a white piece.
     * isWhite - false means that the piece is a black piece.
     */
    public Rook(int row, int col, boolean isWhite){
        super(row,col,isWhite);
    }

    @Override
    public String toString(){
        if (isWhite){
            return "wR";
        }
        return "bR";
    }

    @Override
    public boolean canMove(Piece[][] board, int newRow, int newCol) {
        
        if(board[newRow][newCol] != null && board[newRow][newCol].isWhite == isWhite) {
            return false;
        }

        if(isValidPos(newRow, newCol)) {

            if(newCol == col && newRow != row) {
                
                int increment;
                if(row < newRow) {
                    increment = 1;
                }
                else {
                    increment = -1;
                }

                for(int i = row + increment; i != newRow; i += increment) {
                    if(board[i][newCol] != null) {

                        return false;
                    }
                }
                return true;
            }

            if(newRow == row && newCol != col) {
                
                int increment;
                if (col < newCol) {
                    increment = 1;
                }
                else {
                    increment = -1;
                }

                for(int j = col + increment; j != newCol; j += increment) {
                    
                    if(board[newRow][j] != null) {
                        return false;
                    }
                }
                return true;

            }
        }
        return false;
    }    
}
