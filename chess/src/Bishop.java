package chess.src;
    
/**
 * Bishop Piece: Inherited from the abstract class Piece.
 * Includes string name "wB" if the bishop is a white piece.
 * Includes string name "bB" if the bishop is a black piece.
 * 
 * @author Juan Aracena
 * @author Brandon Valdberg
 */
    
public class Bishop extends Piece{

    /**
     * Bishop constructor: Initializes the Bishop referencing the Piece superclass.
     * @param row x coordinate of the designated position.
     * @param col y coordinate of the designated position.
     * @param isWhite
     * 
     * isWhite = true means that the piece is a white piece.
     * isWhite = false means that the piece is a black piece.
     */
    
    public Bishop (int row, int col, boolean isWhite){
        super(row, col, isWhite);
    }

    @Override
    public String toString(){
        if(isWhite){
            return "wB";
        }
        return "bB";
    }

    @Override
    public boolean canMove(Piece[][] board, int newRow, int newCol) {
        
        if(board[newRow][newCol] != null && board[newRow][newCol].isWhite == isWhite) {
            return false;
        }

        if(row == newRow || col == newCol) {
            return false;
        }

        if(isValidPos(newRow, newCol)) {
            int rowIncrement;
            int colIncrement;

            if(newRow + newCol == row + col) {

                if(row < newRow){
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
        return false;
    }
    
}
