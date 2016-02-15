import javax.swing.JButton; 
import java.awt.Color; 

public class XiangqiDisplay implements ChessBoardDisplay { 
  
  public void displayEmptySquare(JButton emptySquare, int row, int column) { 
    emptySquare.setBackground(java.awt.Color.gray); 
    emptySquare.setText(""); 
  }
  public void displayFilledSquare(JButton filledSquare, int row, int column, ChessPiece piece1) { 
    filledSquare.setBackground(piece1.getColor()); 
    filledSquare.setText(piece1.getLabel()); 
  }
  public void highlightSquare(boolean highlight, JButton highlightedSquare, int row, int column, 
                              ChessPiece piece1) { 
    if (highlight = true) { 
      highlightedSquare.setBackground(java.awt.Color.YELLOW); 
    }
    else { 
      highlightedSquare.setBackground(piece1.getColor()); 
    }
  }
  
}