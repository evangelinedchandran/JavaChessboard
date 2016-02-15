/* The rook can move any number of spaces vertically or horizontally. 
 * Cannot jump over pieces. 
 * */ 

import java.awt.Color; 
import javax.swing.Icon; 

public class RookPiece extends ChessPiece { 
  
  //constructor 
  public RookPiece(ChessBoard board, Color pieceColor, String label, Icon pieceIcon, 
                    ChessGame.Side pieceSide, int row, int column) { 
    super(board, pieceColor, label, pieceIcon, pieceSide, row, column); 
  }
  
  public boolean isLegalMove(int row, int column) {  //move in a straight line horizontally or vertically
    if (isEmptyHorizontalMove(row, column) || isEmptyVerticalMove(row, column)) { 
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