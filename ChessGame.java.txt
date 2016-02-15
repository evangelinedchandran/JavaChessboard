public interface ChessGame { 
  
  public boolean legalPieceToPlay(ChessPiece piece); 
  public boolean makeMove(ChessPiece piece, int row, int column); 
  
  public enum Side { NORTH, SOUTH }; 
}