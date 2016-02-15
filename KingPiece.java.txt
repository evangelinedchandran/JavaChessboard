/* The king can move one square vertically or horizontally. 
 * Cannot move outside of the three center columns of the board. 
 * Cannot move outside of the top/bottom three rows of the board. 
 * */ 

import java.awt.Color; 
import javax.swing.Icon; 

public class KingPiece extends ChessPiece { 
  
  //constructor 
  public KingPiece(ChessBoard board, Color pieceColor, String label, Icon pieceIcon, 
                    ChessGame.Side pieceSide, int row, int column) { 
    super(board, pieceColor, label, pieceIcon, pieceSide, row, column); 
  }
  
  public boolean isLegalMove(int row, int column) { 
    if (getSide() == ChessGame.Side.NORTH) {
      if (row > 2 || column < 3 || column > 5) {
        return false;
      }
    }
    else { 
      if (row < 7 || column < 3 || column > 5) {
        return false;
      }
    }
    if (isOneStepAhead(row, column) || isOneStepBehind(row, column)    //can move EXACTLY one space 
       || isOneStepLeft(row, column) || isOneStepRight(row, column)) { //horizontally or vertically 
      return true; 
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