/* The pawn can move exactly one space vertically towards the opposite side of the board. 
 * Once it has crossed the middle of the board, it can also move one space horizontally. 
 * */ 

import java.awt.Color; 
import javax.swing.Icon; 

public class PawnPiece extends ChessPiece { 
  
  //constructor 
  public PawnPiece(ChessBoard board, Color pieceColor, String label, Icon pieceIcon, 
                    ChessGame.Side pieceSide, int row, int column) { 
    super(board, pieceColor, label, pieceIcon, pieceSide, row, column); 
  }
  
  public boolean isLegalMove(int row, int column) { 
    if (isOneStepAhead(row, column)) { //move forward one space 
      return true; 
    } 
    if (getSide() == ChessGame.Side.NORTH) {
      if (row > 4) { //after crossing center, can also move one space horizontally 
        if (isOneStepLeft(row, column) || isOneStepRight(row, column)) { 
          return true; 
        }
      }
    }
    else { 
      if (row < 4) {
        if (isOneStepLeft(row, column) || isOneStepRight(row, column)) { 
          return true; 
        }
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