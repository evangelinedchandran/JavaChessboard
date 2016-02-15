/* The guard can move one square diagonally. 
 * Cannot move outside of the three center columns of the board. 
 * Cannot move outside of the top/bottom three rows of the board. 
 * */ 

import java.awt.Color; 
import javax.swing.Icon; 

public class GuardPiece extends ChessPiece { 
  
  //constructor 
  public GuardPiece(ChessBoard board, Color pieceColor, String label, Icon pieceIcon, 
                    ChessGame.Side pieceSide, int row, int column) { 
    super(board, pieceColor, label, pieceIcon, pieceSide, row, column); 
  }
  
  public boolean isLegalMove(int row, int column) { 
    if (getSide() == ChessGame.Side.NORTH) {
      if (row > 2 || column < 3 || column > 5) { //can't move outside the middle three columns (North)
        return false;                            //can't move outside the first three rows 
      }
    }
    else { 
      if (row < 7 || column < 3 || column > 5) { //same for the South side 
        return false;
      }
    }
    if (isEmptyDiagonalMove(row, column)) { 
      if (getNumberDiagonalMove(row, column) == 1) { //can move EXACTLY one space diagonally 
        return true; 
      }
    }
    return false; 
  } 
  public boolean isLegalNonCaptureMove(int row, int column) { 
    return isLegalMove(row, column); 
  } 
  public boolean isLegalCaptureMove(int row, int column) { 
    return isLegalMove(row, column); 
  }
}