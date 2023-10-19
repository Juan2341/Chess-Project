package chess.src;
/**
 * Queen Piece: Inherited from the abstract class Piece.
 * Includes string name "wQ" if the queen is a white piece.
 * Includes string name "bQ" if the queen is a black piece.
 * 
 * @author Juan Aracena
 * @author Brandon Valdberg
 */
public class Queen extends Piece{
    
    /**
     * Queen constructor: Initializes Queen referencing the Piece superclass.
     * 
     * @param row x coordinate of the designated position.
     * @param col y coordinate of the designated position.
     * @param isWhite
     * 
     * isWhite = true means that the piece is a white piece.
     * isWhite = false means that the piece is a black piece.
     */
    public Queen(int row, int col, boolean isWhite){
        super(row, col, isWhite);
    }

    @Override
    public String toString(){
        if(isWhite){
            return "wQ";
        }
        return "bQ";
    }

    @Override
    public boolean canMove(Piece[][] board, int newRow, int newCol) {
        if(board[newRow][newCol] != null && board[newRow][newCol].isWhite == isWhite) {
            return false;
        }      
        
        if(!isValidPos(newRow, newCol)) {
            return false;
        }

        if(newCol == col && newRow != row) {
            int increment;

            if(row < newRow) {
                increment = 1;
            }
            else {
                increment = -1;
            }

            for(int i = row+increment; i != newRow; i += increment) {

                if(board[i][newCol] != null) {
                    return false;
                }
            }
            return true;
        }

        if(newRow == row && newCol != col) {
            int increment;

            if(col < newCol) {
                increment = 1;
            }
            else {
                increment = -1;
            }

            for(int j = col + increment; j != newCol; j += increment) {
                
                if(board[newRow][j] != null){
                    return false;
               }
            }
            return true;
        }

        if(row == newRow || col == newCol) {
            return false;
        }

        int rowIncrement;
        int colIncrement;

        if(newRow + newCol == row + col) {
            if(row < newRow) {
                rowIncrement = 1;
                colIncrement = -1;
            }
            else {
                rowIncrement = -1;
                colIncrement = 1;
            }
        }
        else if (newRow - newCol == row - col) {
            if (row < newRow) {
                rowIncrement = 1;
                colIncrement = 1;
            }
            else {
                rowIncrement = -1;
                colIncrement = -1;
            }
        }
        else {
            return false;
        }

        for(int i = row + rowIncrement, j = col + colIncrement; i != newRow && j != newCol; i += rowIncrement, j += colIncrement) {
            if(board[i][j] != null) {
                return false;
            }
        }
        return true;
    }
}
