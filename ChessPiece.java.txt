import java.awt.Color; 
import javax.swing.Icon; 

public class ChessPiece { 
  
  public enum DiagonalDirection { DOWN_LEFT, DOWN_RIGHT, UP_LEFT, UP_RIGHT };
  
  private ChessBoard board; 
  private Color pieceColor; 
  private String label; 
  private Icon pieceIcon; 
  private ChessGame.Side pieceSide; 
  private int row; 
  private int column; 
  
  //constructor 
  public ChessPiece(ChessBoard board, Color pieceColor, String label, Icon pieceIcon, 
                    ChessGame.Side pieceSide, int row, int column) { 
    this.board = board; 
    this.pieceColor = pieceColor; 
    this.label = label; 
    this.pieceIcon = pieceIcon; 
    this.pieceSide = pieceSide; 
    this.row = row; 
    this.column = column; 
  }
  
  public void setRow(int row) { 
    this.row = row; 
  }
  
  public void setColumn(int column) { 
    this.column = column; 
  }
  
  public ChessBoard getChessBoard() { 
    return board; 
  } 
  public Color getColor() { 
    return pieceColor; 
  }
  public String getLabel() { 
    return label; 
  }
  public Icon getIcon() { 
    return pieceIcon; 
  } 
  public ChessGame.Side getSide() { 
    return pieceSide; 
  } 
  public int getRow() { 
    return row; 
  }
  public int getColumn() { 
    return column; 
  } 
  public boolean isLegalMove(int row, int column) { 
    return true; //RETURN
  } 
  public boolean isLegalNonCaptureMove(int row, int column) { 
    return true; //RETURN 
  } 
  public boolean isLegalCaptureMove(int row, int column) { 
    return true; //RETURN 
  } 
  public void moveDone() { 
  }
  
  protected boolean isEmptyHorizontalMove(int newRow, int newColumn) { //for rook piece 
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
      for (int i = start; i < end; i++) 
      {
        if (board.hasPiece(newRow, i) ) 
        {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  protected boolean isEmptyVerticalMove(int newRow, int newColumn) { 
    if (getColumn() == newColumn) { 
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
        if (board.hasPiece(i, newColumn)) {
          return false;
        }
      }
      return true;
    }
    return false; 
  }
  
  protected boolean isOneStepAhead(int newRow, int newColumn) {
    if (getSide() == ChessGame.Side.NORTH) {
      //col should be same and row increased by one
      if (getColumn() == newColumn && (getRow() + 1) == newRow ) {
        return true;
      }
    }
    else { //south side 
      //col should be same and row decreased by one
      if (getColumn() == newColumn && getRow() - 1 == newRow ) {
        return true;
      }
    }
    return false;
  }
  
  protected boolean isOneStepBehind(int newRow, int newColumn) {
    if (getSide() == ChessGame.Side.NORTH) {
      //col should be same and row increased by one
      if (getColumn() == newColumn && (getRow() - 1) == newRow ) 
      {
        return true;
      }
    }
    else { //south side
      //col should be same and row decreased by one
      if (getColumn() == newColumn && getRow() + 1 == newRow) {
        return true;
      }
    }
    return false;
  }
  
  protected boolean isOneStepLeft(int newRow, int newColumn)
  {
    if (getSide() == ChessGame.Side.NORTH) {
      //row should be same and col increased by one
      if (( getColumn() + 1) == newColumn && getRow() == newRow) {
        return true;
      }
    }
    else { //south side 
      //row should be same and col increased by one
      if (( getColumn() - 1) == newColumn && getRow() == newRow) {
        return true;
      }
    }
    return false;
  }
  
  protected boolean isOneStepRight(int newRow, int newColumn) {
    if (getSide() == ChessGame.Side.NORTH) {
      //row should be same and col increased by one
      if (( getColumn() - 1) == newColumn && getRow() == newRow) {
        return true;
      }
    }
    else { //south side
      //row should be same and col increased by one
      if (( getColumn() + 1) == newColumn && getRow() == newRow) {
        return true;
      }
    }
    return false;
  }
  
  protected boolean isEmptyDiagonalMove(int newRow, int newColumn) {
    if ( !(getColumn() == newColumn || getRow() == newRow)) {
      //yes diagonal move
      int colDifferenceAbsolute = getColumn() - newColumn;
      int rowDifferenceAbsolute = getRow() - newRow;
      if (  Math.abs(colDifferenceAbsolute) ==  Math.abs(rowDifferenceAbsolute)) {
        DiagonalDirection diagonalDirection = getDiagonalDirection(newRow, newColumn);
        int startCol = getColumn();
        int startRow = getRow();
        if (diagonalDirection == DiagonalDirection.UP_LEFT || diagonalDirection == DiagonalDirection.UP_RIGHT) {
          startCol = newColumn;
          startRow = newRow;
        }
        
        System.out.println("Start:" + startCol + "," + startRow);
        if (diagonalDirection == DiagonalDirection.UP_LEFT || diagonalDirection == DiagonalDirection.DOWN_RIGHT) {
          for (int i = startRow + 1, j = startCol + 1; i < startRow + rowDifferenceAbsolute; i++,j++ ) {
            System.out.println(i + "," + j);
            if (board.hasPiece(i, j)) {
              return false;
            }
          }
        }
        else {
          for (int i = startRow + 1, j = startCol - 1; i < startRow + rowDifferenceAbsolute; i++, j--) {
            System.out.println(i + "," + j);
            if (board.hasPiece(i, j)) {
              return false;
            }
          }
        }
        return true;
      }
    }
    return false;
  }
  
  protected int getNumberDiagonalMove(int newRow, int newColumn) {
    if (!(getColumn() == newColumn || getRow() == newRow)) {
      //yes diagonal move
      int colDifferenceAbsolute = Math.abs(( getColumn() - newColumn));
      int rowDifferenceAbsolute = Math.abs(( getRow() - newRow));
      if ( colDifferenceAbsolute == rowDifferenceAbsolute) {
        //number of diagonal spaces moved
        return colDifferenceAbsolute;
      }
    }
    return 0;
  }
  
  protected DiagonalDirection getDiagonalDirection(int newRow, int newColumn) {
    
    DiagonalDirection diagonalDirection;
    
    int colDifferenceAbsolute = newColumn - getColumn();
    int rowDifferenceAbsolute = newRow - getRow();
    
    if (colDifferenceAbsolute > 0 && rowDifferenceAbsolute > 0) {
      diagonalDirection = DiagonalDirection.DOWN_RIGHT;
    }
    else if (colDifferenceAbsolute < 0 && rowDifferenceAbsolute < 0) {
      diagonalDirection = DiagonalDirection.UP_LEFT;
    }
    else if (colDifferenceAbsolute < 0 && rowDifferenceAbsolute > 0) {
      diagonalDirection = DiagonalDirection.DOWN_LEFT;
    }
    else {
      diagonalDirection = DiagonalDirection.UP_RIGHT;
    }
    System.out.println(diagonalDirection);
    return diagonalDirection;
  }
}