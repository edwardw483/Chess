import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ChessView implements MouseListener, MouseMotionListener{
    JFrame ChessFrame = new JFrame("Chess");
    ChessBoardPanel BoardPanel = new ChessBoardPanel();
    public void mousePressed(MouseEvent e){

    }
    public void mouseEntered(MouseEvent e){

    }
    public void mouseReleased(MouseEvent e){

    }
    public void mouseDragged(MouseEvent e){

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
        
        ChessFrame.setContentPane(BoardPanel);
        ChessFrame.pack();
        ChessFrame.setResizable(false);
        ChessFrame.setVisible(true);

    }
}