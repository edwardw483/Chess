import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ChessBoardPanel extends JLayeredPane{
    //Properties
    Dimension boardSize = new Dimension(800,800);
    JPanel chessBoard = new JPanel();
    
    //Methods
    public void drawPiece(String assetPath, int component){
        JLabel piece = new JLabel(new ImageIcon(ChessBoardPanel.class.getResource(assetPath)));
        JPanel panel = (JPanel)chessBoard.getComponent(component);
        panel.add(piece);
    }
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
        //Draw the Pieces on the ChessBoard Panel
        this.drawPiece("/assets/dr.png", 0);
        this.drawPiece("/assets/dn.png", 1);
        this.drawPiece("/assets/db.png", 2);
        this.drawPiece("/assets/dq.png", 3);
        this.drawPiece("/assets/dk.png", 4);
        this.drawPiece("/assets/db.png", 5);
        this.drawPiece("/assets/dn.png", 6);
        this.drawPiece("/assets/dr.png", 7);
        for(int i = 8; i < 16; i++){
            this.drawPiece("/assets/dp.png", i);
        }
        this.drawPiece("/assets/lr.png", 56);
        this.drawPiece("/assets/ln.png", 57);
        this.drawPiece("/assets/lb.png", 58);
        this.drawPiece("/assets/lq.png", 59);
        this.drawPiece("/assets/lk.png", 60);
        this.drawPiece("/assets/lb.png", 61);
        this.drawPiece("/assets/ln.png", 62);
        this.drawPiece("/assets/lr.png", 63);
        for(int i = 48; i < 56; i++){
            this.drawPiece("/assets/lp.png", i);
        }
        //LayeredPane Setup
        this.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        this.setPreferredSize(boardSize);
        this.setBounds(0,0, boardSize.width, boardSize.height);

    }
}
