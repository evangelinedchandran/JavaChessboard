/* The knight can move exactly two squares on each move. 
 * The first square must be a horizontal or vertical move. 
 * The second square is a diagonal move, resulting in an "L" shaped move. 
 * Cannot jump over pieces. 
 * */ 

import java.awt.Color; 
import javax.swing.Icon; 

public class KnightPiece extends ChessPiece { 
  
  //constructor 
  public KnightPiece(ChessBoard board, Color pieceColor, String label, Icon pieceIcon, 
                     ChessGame.Side pieceSide, int row, int column) { 
    super(board, pieceColor, label, pieceIcon, pieceSide, row, column); 
  }
  
  public boolean isLegalMove(int row, int column) {
    
    int colDifferenceAbsolute = column - getColumn();
    int rowDifferenceAbsolute = row - getRow();
    
    //possible legal knight move will move it into one of 8 positions. They will be two rows up or down
    //and one column left or right. Or it could move two columns left or right and one row up or down
    if (Math.abs(rowDifferenceAbsolute) == 2 && Math.abs(colDifferenceAbsolute) == 1) {
      if (rowDifferenceAbsolute > 0) {//moved down, so vertically there should be no piece
        if (getChessBoard().hasPiece(getRow() + 1, getColumn())) {
          return false;
        }
      }
      else { //moved row up
        if (getChessBoard().hasPiece(getRow() - 1, getColumn())) {
          return false;
        }
      }
      return true;
    }
    else if (Math.abs(colDifferenceAbsolute) == 2 && Math.abs(rowDifferenceAbsolute) == 1) {
      if (colDifferenceAbsolute > 0) { //moved left, so horizontally there should be no piece
        if (getChessBoard().hasPiece(getRow(), getColumn() + 1)) {
          return false;
        }
      }
      else { //moved right
        if (getChessBoard().hasPiece(getRow(), getColumn() - 1)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
}