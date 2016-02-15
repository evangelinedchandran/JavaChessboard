import javax.swing.JOptionPane; 
import java.awt.Component; 

public class Xiangqi implements ChessGame { 
  
  private ChessBoard xiangqiBoard; 
  private XiangqiDisplay display = new XiangqiDisplay(); 
  private ChessGame.Side sideToPlay = ChessGame.Side.NORTH; 
  private KingPiece blackKing = null; 
  private KingPiece whiteKing = null; 
  
  public Xiangqi() { 
    xiangqiBoard = new ChessBoard(10, 9, display, this); 
    
    //black side (top) 
    blackKing = new KingPiece(xiangqiBoard, java.awt.Color.RED, "K", null, 
                              ChessGame.Side.NORTH, 0, 4); 
    GuardPiece blackGuard1 = new GuardPiece(xiangqiBoard, java.awt.Color.RED, "G", null, 
                                            ChessGame.Side.NORTH, 0, 3); 
    GuardPiece blackGuard2 = new GuardPiece(xiangqiBoard, java.awt.Color.RED, "G", null, 
                                            ChessGame.Side.NORTH, 0, 5); 
    ElephantPiece blackElephant1 = new ElephantPiece(xiangqiBoard, java.awt.Color.RED, "E", null, 
                                                     ChessGame.Side.NORTH, 0, 2); 
    ElephantPiece blackElephant2 = new ElephantPiece(xiangqiBoard, java.awt.Color.RED, "E", null, 
                                                     ChessGame.Side.NORTH, 0, 6); 
    KnightPiece blackKnight1 = new KnightPiece(xiangqiBoard, java.awt.Color.RED, "Kn", null, 
                                               ChessGame.Side.NORTH, 0, 1); 
    KnightPiece blackKnight2 = new KnightPiece(xiangqiBoard, java.awt.Color.RED, "Kn", null, 
                                               ChessGame.Side.NORTH, 0, 7); 
    RookPiece blackRook1 = new RookPiece(xiangqiBoard, java.awt.Color.RED, "R", null, 
                                         ChessGame.Side.NORTH, 0, 0); 
    RookPiece blackRook2 = new RookPiece(xiangqiBoard, java.awt.Color.RED, "R", null, 
                                         ChessGame.Side.NORTH, 0, 8); 
    CannonPiece blackCannon1 = new CannonPiece(xiangqiBoard, java.awt.Color.RED, "C", null, 
                                               ChessGame.Side.NORTH, 2, 1); 
    CannonPiece blackCannon2 = new CannonPiece(xiangqiBoard, java.awt.Color.RED, "C", null, 
                                               ChessGame.Side.NORTH, 2, 7); 
    PawnPiece blackPawn1 = new PawnPiece(xiangqiBoard, java.awt.Color.RED, "P", null, 
                                         ChessGame.Side.NORTH, 3, 0); 
    PawnPiece blackPawn2 = new PawnPiece(xiangqiBoard, java.awt.Color.RED, "P", null, 
                                         ChessGame.Side.NORTH, 3, 2); 
    PawnPiece blackPawn3 = new PawnPiece(xiangqiBoard, java.awt.Color.RED, "P", null, 
                                         ChessGame.Side.NORTH, 3, 4); 
    PawnPiece blackPawn4 = new PawnPiece(xiangqiBoard, java.awt.Color.RED, "P", null, 
                                         ChessGame.Side.NORTH, 3, 6); 
    PawnPiece blackPawn5 = new PawnPiece(xiangqiBoard, java.awt.Color.RED, "P", null, 
                                         ChessGame.Side.NORTH, 3, 8); 
    
    xiangqiBoard.addPiece(blackKing, 0, 4); 
    xiangqiBoard.addPiece(blackGuard1, 0, 3); 
    xiangqiBoard.addPiece(blackGuard2, 0, 5); 
    xiangqiBoard.addPiece(blackElephant1, 0, 2); 
    xiangqiBoard.addPiece(blackElephant2, 0, 6); 
    xiangqiBoard.addPiece(blackKnight1, 0, 1); 
    xiangqiBoard.addPiece(blackKnight1, 0, 7); 
    xiangqiBoard.addPiece(blackRook1, 0, 0); 
    xiangqiBoard.addPiece(blackRook2, 0, 8); 
    xiangqiBoard.addPiece(blackCannon1, 2, 1); 
    xiangqiBoard.addPiece(blackCannon2, 2, 7); 
    xiangqiBoard.addPiece(blackPawn1, 3, 0); 
    xiangqiBoard.addPiece(blackPawn2, 3, 2); 
    xiangqiBoard.addPiece(blackPawn3, 3, 4); 
    xiangqiBoard.addPiece(blackPawn4, 3, 6); 
    xiangqiBoard.addPiece(blackPawn5, 3, 8); 
    
    //white side (bottom) 
    whiteKing = new KingPiece(xiangqiBoard, java.awt.Color.WHITE, "K", null, 
                              ChessGame.Side.SOUTH, 9, 4); 
    GuardPiece whiteGuard1 = new GuardPiece(xiangqiBoard, java.awt.Color.WHITE, "G", null, 
                                            ChessGame.Side.SOUTH, 9, 3); 
    GuardPiece whiteGuard2 = new GuardPiece(xiangqiBoard, java.awt.Color.WHITE, "G", null, 
                                            ChessGame.Side.SOUTH, 9, 5); 
    ElephantPiece whiteElephant1 = new ElephantPiece(xiangqiBoard, java.awt.Color.WHITE, "E", null, 
                                                     ChessGame.Side.SOUTH, 9, 2); 
    ElephantPiece whiteElephant2 = new ElephantPiece(xiangqiBoard, java.awt.Color.WHITE, "E", null, 
                                                     ChessGame.Side.SOUTH, 9, 6); 
    KnightPiece whiteKnight1 = new KnightPiece(xiangqiBoard, java.awt.Color.WHITE, "Kn", null, 
                                               ChessGame.Side.SOUTH, 9, 1); 
    KnightPiece whiteKnight2 = new KnightPiece(xiangqiBoard, java.awt.Color.WHITE, "Kn", null, 
                                               ChessGame.Side.SOUTH, 9, 7); 
    RookPiece whiteRook1 = new RookPiece(xiangqiBoard, java.awt.Color.WHITE, "R", null, 
                                         ChessGame.Side.SOUTH, 9, 0); 
    RookPiece whiteRook2 = new RookPiece(xiangqiBoard, java.awt.Color.WHITE, "R", null, 
                                         ChessGame.Side.SOUTH, 9, 8); 
    CannonPiece whiteCannon1 = new CannonPiece(xiangqiBoard, java.awt.Color.WHITE, "C", null, 
                                               ChessGame.Side.SOUTH, 7, 1); 
    CannonPiece whiteCannon2 = new CannonPiece(xiangqiBoard, java.awt.Color.WHITE, "C", null, 
                                               ChessGame.Side.SOUTH, 7, 7); 
    PawnPiece whitePawn1 = new PawnPiece(xiangqiBoard, java.awt.Color.WHITE, "P", null, 
                                         ChessGame.Side.SOUTH, 6, 0); 
    PawnPiece whitePawn2 = new PawnPiece(xiangqiBoard, java.awt.Color.WHITE, "P", null, 
                                         ChessGame.Side.SOUTH, 6, 2); 
    PawnPiece whitePawn3 = new PawnPiece(xiangqiBoard, java.awt.Color.WHITE, "P", null, 
                                         ChessGame.Side.SOUTH, 6, 4); 
    PawnPiece whitePawn4 = new PawnPiece(xiangqiBoard, java.awt.Color.WHITE, "P", null, 
                                         ChessGame.Side.SOUTH, 6, 6); 
    PawnPiece whitePawn5 = new PawnPiece(xiangqiBoard, java.awt.Color.WHITE, "P", null, 
                                         ChessGame.Side.SOUTH, 6, 8); 
    
    xiangqiBoard.addPiece(whiteKing, 9, 4); 
    xiangqiBoard.addPiece(whiteGuard1, 9, 3); 
    xiangqiBoard.addPiece(whiteGuard2, 9, 5); 
    xiangqiBoard.addPiece(whiteElephant1, 9, 2); 
    xiangqiBoard.addPiece(whiteElephant2, 9, 6); 
    xiangqiBoard.addPiece(whiteKnight1, 9, 1); 
    xiangqiBoard.addPiece(whiteKnight1, 9, 7); 
    xiangqiBoard.addPiece(whiteRook1, 9, 0); 
    xiangqiBoard.addPiece(whiteRook2, 9, 8); 
    xiangqiBoard.addPiece(whiteCannon1, 7, 1); 
    xiangqiBoard.addPiece(whiteCannon2, 7, 7); 
    xiangqiBoard.addPiece(whitePawn1, 6, 0); 
    xiangqiBoard.addPiece(whitePawn2, 6, 2); 
    xiangqiBoard.addPiece(whitePawn3, 6, 4); 
    xiangqiBoard.addPiece(whitePawn4, 6, 6); 
    xiangqiBoard.addPiece(whitePawn5, 6, 8); 
  }
  
  public boolean legalPieceToPlay(ChessPiece piece) { 
    if (piece.getSide() == sideToPlay) { 
      return true; 
    }
    return false; 
  }
  public boolean makeMove(ChessPiece piece, int row, int column) { 
    ChessPiece destinationSquare = xiangqiBoard.getPiece(row, column); 
    if (destinationSquare != null) { 
      if (destinationSquare.getSide() == piece.getSide()) { 
        return false;           //can't move a North piece on top of another North Piece 
      }
    }
    
    if (piece.isLegalMove(row, column)) {
      ChessPiece removedPiece = xiangqiBoard.removePiece(row, column); 
      xiangqiBoard.removePiece(piece.getRow(), piece.getColumn()); 
      xiangqiBoard.addPiece(piece, row, column); 
      int oldRow = piece.getRow(); 
      int oldColumn = piece.getColumn(); 
      piece.setRow(row); 
      piece.setColumn(column); 
      
      if (facingGenerals() || currentPlayerInCheckMate()) { 
        piece.setRow(oldRow); 
        piece.setColumn(oldColumn); 
        xiangqiBoard.addPiece(piece, oldRow, oldColumn); 
        xiangqiBoard.removePiece(row, column); 
        if (removedPiece != null) { 
          xiangqiBoard.addPiece(removedPiece, row, column); 
        }
        return false; 
      }
      
      if (removedPiece != null && removedPiece.getClass().getName().equals("KingPiece")) { 
        String message = "NORTH wins"; 
        if (removedPiece.getSide() == Side.NORTH) {
          message = "SOUTH wins";
        }
        JOptionPane.showMessageDialog((Component) null, message,
                                      "Game Over", JOptionPane.OK_OPTION);
        xiangqiBoard.closeBoard(); 
      }
      
      if (piece.getSide() == ChessGame.Side.NORTH) { 
        sideToPlay = ChessGame.Side.SOUTH; 
      } 
      else if (piece.getSide() == ChessGame.Side.SOUTH) { 
        sideToPlay = ChessGame.Side.NORTH; 
      } 
      return true; 
    }
    return false; 
  }
  
  private boolean facingGenerals() { 
    if (whiteKing.getColumn() == blackKing.getColumn()) { //kings are in the same column 
      for (int i = blackKing.getRow(); i < whiteKing.getRow(); i++) {
        if (i != whiteKing.getRow() && i != blackKing.getRow()) 
        {
          if (xiangqiBoard.hasPiece(i, whiteKing.getColumn())) 
          {
            return false; //yes has another piece
          }
        }
      }
      return true; // yes facing generals
    }
    return false;
  }
  
  private boolean currentPlayerInCheckMate() { 
    return false; 
  } 
  
  public static void main(String[] args) { 
    Xiangqi game = new Xiangqi(); 
  }
}