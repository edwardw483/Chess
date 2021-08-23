import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ChessView implements MouseListener, MouseMotionListener{
    //Properties
    JFrame ChessFrame = new JFrame("Chess");
    ChessBoardPanel BoardPanel = new ChessBoardPanel();
    JLabel ChessPiece;
    int diffX, diffY;
    public void mousePressed(MouseEvent e){
        //Find component at mouse press
        ChessPiece = null;
        Component comp = BoardPanel.chessBoard.findComponentAt(e.getX(), e.getY());
        //End method if JPanel and not JLabel
        if(comp instanceof JPanel){
            return;
        }
        //Get location of component and difference between component and mouse location
        Point pieceCoords = comp.getParent().getLocation();
        diffX = pieceCoords.x - e.getX();
        diffY = pieceCoords.y - e.getY();
        //Bring ChessPiece to Drag Layer
        ChessPiece = (JLabel)comp;
        ChessPiece.setLocation(pieceCoords.x, pieceCoords.y);
        ChessPiece.setSize(ChessPiece.getWidth(), ChessPiece.getHeight());
        BoardPanel.add(ChessPiece, JLayeredPane.DRAG_LAYER);
    }
    public void mouseEntered(MouseEvent e){

    }
    public void mouseReleased(MouseEvent e){
        //End method if no piece is selected
        if(ChessPiece == null){
            return;
        }
        //Remove old chess piece and place it at the new component
        ChessPiece.setVisible(false);
        Component comp =  BoardPanel.findComponentAt(e.getX(), e.getY());
        //If currently occupied by a piece
        if(comp instanceof JLabel){
            Container parent = comp.getParent();
            parent.remove(0);
            parent.add(ChessPiece);
        }
        //Else empty
        else{
            Container parent = (Container)comp;
            parent.add(ChessPiece);
        }
        ChessPiece.setVisible(true);
    }
    public void mouseDragged(MouseEvent me){
        //End method if no piece is selected
        if(ChessPiece == null){
            return;
        }
        //Redraw piece at mouse cursor
        ChessPiece.setLocation(me.getX() + diffX, me.getY() + diffY);
    }
    public void mouseClicked(MouseEvent e){

    }
    public void mouseMoved(MouseEvent e){

    }
    public void mouseExited(MouseEvent e){

    }
    //Constructor
    public ChessView(){
        ChessFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //ChessBoardPanel
        BoardPanel.setLayout(null);
        BoardPanel.setSize(new Dimension(600, 800));
        BoardPanel.addMouseListener(this);
        BoardPanel.addMouseMotionListener(this);

        //JFrame
        ChessFrame.setContentPane(BoardPanel);
        ChessFrame.pack();
        ChessFrame.setResizable(false);
        ChessFrame.setVisible(true);

    }
}