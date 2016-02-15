/* The elephant can move exactly two squares diagonally on each move. 
 * Cannot jump over a piece. 
 * Cannot cross the center of the board (restricted to top or bottom half of the rows). 
 * */ 

import java.awt.Color; 
import javax.swing.Icon; 

public class ElephantPiece extends ChessPiece { 
  
  //constructor 
  public ElephantPiece(ChessBoard board, Color pieceColor, String label, Icon pieceIcon, 
                    ChessGame.Side pieceSide, int row, int column) { 
    super(board, pieceColor, label, pieceIcon, pieceSide, row, column); 
  }
  
  public boolean isLegalMove(int row, int column) { 
    if (getSide() == ChessGame.Side.NORTH) {
      if (row > 4) { //can't cross the center of the board (North side) 
        return false;
      }
    }
    else { 
      if (row < 4) { //can't cross the center of the board (South side) 
        return false;
      }
    }
    if (isEmptyDiagonalMove(row, column)) { 
      if (getNumberDiagonalMove(row, column) == 2) { //MUST move two spaces diagonally 
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