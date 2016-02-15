/* The cannon can move any number of spaces vertically or horizontally. 
 * If not capturing a piece, all squares on its move must be empty. (like FMAB Sloth) 
 * If capturing a piece, must jump over exactly one piece (of either Side). 
 * */ 

import java.awt.Color; 
import javax.swing.Icon; 

public class CannonPiece extends ChessPiece { 
  
  //constructor 
  public CannonPiece(ChessBoard board, Color pieceColor, String label, Icon pieceIcon, 
                     ChessGame.Side pieceSide, int row, int column) { 
    super(board, pieceColor, label, pieceIcon, pieceSide, row, column); 
  }
  
  public boolean isLegalMove(int row, int column) { 
    if (getChessBoard().hasPiece(row, column) == true) { 
      return isLegalCaptureMove(row, column); 
    }
    else { 
      return isLegalNonCaptureMove(row, column); 
    }
  } 
  public boolean isLegalNonCaptureMove(int row, int column) { 
    //legal moves are horizontal or vertical 
    if (isEmptyHorizontalMove(row, column) || isEmptyVerticalMove(row, column)) { 
      return true; 
    }
    return false; 
  } 
  
  public boolean isLegalCaptureMove(int newRow, int newColumn) { 
    int piecesBetween = 0; 
    
    if (getRow() == newRow) {
      //default values to moving left
      int start = newColumn + 1;
      int end = getColumn();
      
      //moving right
      if (getColumn()  < newColumn ) {
        start = getColumn() + 1;
        end = newColumn;
      }
      
      //this piece cannot jump over any piece so if there is this is not allowed
      for (int i = start; i < end; i++) { 
        if (getChessBoard().hasPiece(newRow, i)) {
          piecesBetween++; 
        }
      }
    }
    else if (getColumn() == newColumn) { 
      //default values to moving down 
      int start = getRow() + 1;
      int end = newRow;
      
      //moving up 
      if (newRow  < getRow()) {
        start = newRow - 1;
        end = getRow();
      }
      
      //this piece cannot jump over any piece so if there is this is not allowed
      for (int i = start; i < end; i++) {
        if (getChessBoard().hasPiece(i, newColumn)) {
          piecesBetween++; 
        }
      }
    }
    
    if (piecesBetween == 1) { 
      return true; 
    } 
    else { 
      return false; 
    } 
    
  }
}