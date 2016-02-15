import javax.swing.JFrame; 
import javax.swing.JButton; 
import javax.swing.JPanel; 
import java.awt.GridLayout; 
import javax.swing.UIManager; 
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent; 
import java.awt.Color; 

public class ChessBoard implements ActionListener { 
  
  private int rows; 
  private int columns; 
  private ChessBoardDisplay chessDisplay; 
  private ChessGame chessVersion; 
  private JFrame chessFrame; 
  private JButton[][] chessButtons = null; 
  private ChessPiece[][] pieces = null; 
  private int rowClicked = -1; 
  private int columnClicked = -1; 
  
  //constructor 
  public ChessBoard(int rows, int columns, ChessBoardDisplay chessDisplay, 
                    ChessGame chessVersion) { 
    this.rows = rows; 
    this.columns = columns; 
    this.chessDisplay = chessDisplay; 
    this.chessVersion = chessVersion; 
    
    displayDefaultBoard(); 
  } 
  
  private void displayDefaultBoard() { 
    chessFrame = new JFrame(); 
    JPanel board = new JPanel(new GridLayout(rows, columns));
    chessFrame.getContentPane().add(board, "Center"); 
    
    chessButtons = new JButton[rows][columns]; 
    pieces = new ChessPiece[rows][columns]; 
    
    for (int i = 0; i < rows; i++) { 
      for (int j = 0; j < columns; j++) { 
        chessButtons[i][j] = new JButton(Integer.toString(i) + "," + Integer.toString(j)); 
        chessDisplay.displayEmptySquare(chessButtons[i][j], i, j); 
        board.add(chessButtons[i][j]); 
        chessButtons[i][j].addActionListener(this); 
      }
    }
    
    try {
      UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    }
    catch (Exception e) {
    }
    
    chessFrame.setSize(500, 500); 
    chessFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    chessFrame.setVisible(true); 
  } 
  
  public void addPiece(ChessPiece piece, int row, int column) { 
    pieces[row][column] = piece; 
    chessDisplay.displayFilledSquare(chessButtons[row][column], row, column, piece); 
  } 
  
  public ChessPiece removePiece(int row, int column) { 
    ChessPiece piece = null; 
    if (hasPiece(row, column)) { 
      piece = getPiece(row, column); 
      pieces[row][column] = null; 
      chessDisplay.displayEmptySquare(chessButtons[row][column], row, column); 
    }
    return piece; 
  } 
  
  public boolean hasPiece(int row, int column) { 
    if (pieces[row][column] != null) { 
      return true; 
    }
    return false; 
  }
  
  public ChessPiece getPiece(int row, int column) { 
    return pieces[row][column]; 
  }
  
  public void actionPerformed(ActionEvent arg0) { 
    JButton buttonClicked = (JButton)arg0.getSource(); 
    for (int i = 0; i < rows; i++) { 
      for (int j = 0; j < columns; j++) { 
        if (chessButtons[i][j] == arg0.getSource()) { 
          processClick(i, j); 
        }
      }
    }
  }
  
  private void processClick (int row, int column) { 
    System.out.println("row: " + rowClicked + " col: " + columnClicked); 
    if (rowClicked < 0) {   //first click 
      if (hasPiece(row, column) && (chessVersion.legalPieceToPlay(getPiece(row, column)))) { 
        chessDisplay.highlightSquare(true, chessButtons[row][column], row, column, 
                                       getPiece(row, column)); 
        rowClicked = row; 
        columnClicked = column; 
      }
    }
    else { //second click 
      if (!(rowClicked == row && columnClicked == column)) { 
        chessDisplay.highlightSquare(false, chessButtons[rowClicked][columnClicked], 
                                     rowClicked, columnClicked, getPiece(rowClicked, columnClicked)); 
        chessVersion.makeMove(getPiece(rowClicked, columnClicked), row, column); 
        rowClicked = -1; 
        columnClicked = -1; 
        System.out.println("row: " + rowClicked + " col: " + columnClicked); 
      }
    } 
  }
  public void closeBoard() { 
    chessFrame.dispose(); 
  }
}
  
  