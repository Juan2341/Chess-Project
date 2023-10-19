package chess.src;
/**
 * Abstract class that represents the general characteristics of all the chess pieces.
 * Each piece is either a white or a black piece.
 * Each piece takes up a specific position of the board (row and column).
 * 
 * @author Juan Aracena
 * @author Brandon Valdberg
 */
public abstract class Piece {
    
    int row; 
    int col;
    boolean isWhite;

    /**
     * Piece constructor
     * 
     * @param row x coordinate of the designated spot.
     * @param col y coordinate of the designated spot.
     * 
     * @param isWhite
     * isWhite = true means that the piece is a white piece.
     * isWhite = false means that the piece is a black piece.
     */
    public Piece(int row, int col, boolean isWhite){
        this.row = row;
        this.col = col;
        this.isWhite = isWhite;
    }

    /**
     * Boolean method that checks if the desired location is within the board parameters.
     * 
     * @param newRow New row.
     * @param newCol New column.
     * 
     * @return Returns true value if the new location for the piece is within the board parameters. Otherwise, it returns a false value.
     */
    public boolean isValidPos(int newRow, int newCol){
        return (newRow >= 0 && newRow <= 7 && newCol >= 0 && newCol <= 7);

    }

    /**
     * To string method for each piece type.
     * 
     * @return the String of the piece displayed on the board.
     */
    public abstract String toString();

    /**
     * Boolean abstract method that checks whether the piece type can move to the location the user specifies.
     * 
     * @param board Chess board.
     * @param newRow Desired row.
     * @param newCol Desired column.
     * 
     * @return true or false.
     */
    public abstract boolean canMove(Piece[][] board, int newRow, int newCol);
}
