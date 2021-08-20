import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ChessBoardPanel extends JLayeredPane{
    //Properties
    Dimension boardSize = new Dimension(800,800);
    JPanel chessBoard = new JPanel();
    
    //Methods
    
    //Constructor
    public ChessBoardPanel(){
        //Chessboard JPanel Setup and Board Drawing
        chessBoard.setLayout(new GridLayout(8,8));
        chessBoard.setPreferredSize(boardSize);
        chessBoard.setBounds(0,0, boardSize.width, boardSize.height);
        for(int tile = 0; tile < 64; tile++){
            JPanel square = new JPanel( new BorderLayout() );
            chessBoard.add(square);
            int row = (tile / 8) % 2;
            if (row == 0){
                if(tile % 2== 0){
                    square.setBackground(Color.darkGray);
                }else{
                    square.setBackground(Color.white);
                }
            }else{
                if(tile % 2== 0){
                    square.setBackground(Color.white);
                }else{
                    square.setBackground(Color.darkGray);
                }
            }
        }
        JLabel piece = new JLabel(new ImageIcon(ChessBoardPanel.class.getResource("/assets/bk.png")));
        JPanel panel = (JPanel)chessBoard.getComponent(0);
        panel.add(piece);
        //LayeredPane Setup
        this.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        this.setPreferredSize(boardSize);
        this.setBounds(0,0, boardSize.width, boardSize.height);

    }
}
