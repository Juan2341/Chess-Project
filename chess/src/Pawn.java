package chess.src;

/**
 * Pawn Piece: Inherited from the abstract class Piece.
 * Includes string name "wP" if the pawn is a white piece.
 * Include string name "bP" if the pawn is a black piece.
 * 
 * @author Juan Aracena
 * @author Brandon Valdberg
 */
public class Pawn extends Piece{
    
    /**
     * Pawn constructor: Initializes Pawns referencing the superclass Piece.
     * 
     * @param row x coordinate of the designated position.
     * @param col y coordinate of the designated position.
     * @param isWhite
     * 
     * isWhite = true means that the piece is a white piece.
     * isWhite = false means that the piece is a black piece.
     */
    public Pawn(int row, int col, boolean isWhite){
        super(row, col, isWhite);
    }

    @Override
    public String toString(){
        if(isWhite){
            return "wP";
        }
        return "bP";
    }

    @Override
    public boolean canMove(Piece[][] board, int newRow, int newCol) {
        
        
        if(board[newRow][newCol] != null && board[newRow][newCol].isWhite == isWhite){
            
            return false;
        }

        
        if(!isValidPos(newRow, newCol)){
            
            return false;
        }

        
        if(isWhite) {

            if(newRow == row - 1 && newCol == col && board[newRow][newCol] == null) {
                
                return true;
            }

            if(row == 6 && board[newRow][newCol] == null && newRow < 7 && board[newRow + 1][newCol] == null) {
                
                if(newRow == row - 2 && newCol == col){
                    
                    return true;
                }
                
            }

            if(newRow == row - 1 && Math.abs(newCol  - col) == 1 && board[newRow][newCol] != null) {
                return true;
            }

        }
        else {
            

            if(newRow == row + 1 && newCol == col && board[newRow][newCol] == null) {
                
                return true;
            }

            if(row == 1 && board[newRow][newCol] == null && newRow > 0 && board[newRow - 1][newCol] == null) {
                
                if(newRow == row + 2 && newCol == col){
                    
                    return true;
                }
                
            }

            if(newRow == row + 1 && Math.abs(newCol  - col) == 1 && board[newRow][newCol] != null) {
                return true;
            }
        }

        return false;

    }
}
