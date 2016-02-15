/* Evangeline Chandran 
 * EECS 132 Project #4 
 * */ 

import javax.swing.JButton; 

public interface ChessBoardDisplay { 
 
  public void displayEmptySquare(JButton emptySquare, int row, int column); 
  public void displayFilledSquare(JButton filledSquare, int row, int column, ChessPiece piece1); 
  public void highlightSquare(boolean highlight, JButton highlightedSquare, int row, int column, 
                              ChessPiece piece1); 
}