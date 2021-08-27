import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class drawing extends Canvas{
    public void paint(Graphics g) {
        // 1st rows
        g.drawRect(10,10,120,160);
        g.drawRect(130,10,120,160);


        // 2nd rows
        g.drawRect(10,170,120,160);
        g.drawRect(130,170,120,160);
        g.drawRect(250,170,120,160);

        // 3rd rows
        g.drawRect(10,330,120,160);
        g.drawRect(130,330,120,160);
        g.drawRect(250,330,120,160);

    }
}
public class q3 implements MouseListener{
    public static String board [][] = {{"A","B","C"},{"D","E","F"},{"G","H","I"}} ;
    public JFrame f;
    public static void main(String[] arg){
        q3 j = new q3();
        j.setup();
    }

    public void setup(){
        f =new JFrame("XO_Game");
        drawing d = new drawing();
        // l_0
        JLabel l_0 = new JLabel();
        l_0.setBounds(70,40,110,120);
        l_0.setFont(new Font("Sample glyphs",Font.BOLD, 90));

        // l_1
        JLabel l_1 = new JLabel();
        l_1.setBounds(225,40,110,120);
        l_1.setFont(new Font("Sample glyphs",Font.BOLD, 90));

        // l_2
        JLabel l_2 = new JLabel();
        l_2.setBounds(365,40,110,120);
        l_2.setFont(new Font("Sample glyphs",Font.BOLD, 90));

        // l_3
        JLabel l_3 = new JLabel();
        l_3.setBounds(70,200,90,100);
        l_3.setFont(new Font("Sample glyphs",Font.BOLD, 90));

        // l_4
        JLabel l_4 = new JLabel();
        l_4.setBounds(225,200,90,100);
        l_4.setFont(new Font("Sample glyphs",Font.BOLD, 90));

        // l_5
        JLabel l_5 = new JLabel();
        l_5.setBounds(365,200,90,100);
        l_5.setFont(new Font("Sample glyphs",Font.BOLD, 90));

        // l_6
        JLabel l_6 = new JLabel();
        l_6.setBounds(70,360,90,100);
        l_6.setFont(new Font("Sample glyphs",Font.BOLD, 90));

        // l_7
        JLabel l_7 = new JLabel();
        l_7.setBounds(225,360,90,100);
        l_7.setFont(new Font("Sample glyphs",Font.BOLD, 90));

        // l_8
        JLabel l_8 = new JLabel();
        l_8.setBounds(365,360,90,100);
        l_8.setFont(new Font("Sample glyphs",Font.BOLD, 90));

        f.add(l_0);f.add(l_1);f.add(l_2);;
        f.add(l_3);f.add(l_4);f.add(l_5);
        f.add(l_6);f.add(l_7);f.add(l_8);;

        f.addMouseListener(this);

        f.add(d);
        f.setSize(500,500);
        f.setVisible(true);
        f.setLayout(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while(true){
            l_0.setText(board[0][0]);l_1.setText(board[0][1]);l_2.setText(board[0][2]);;
            l_3.setText(board[1][0]);l_4.setText(board[1][1]);l_5.setText(board[1][2]);
            l_6.setText(board[2][0]);l_7.setText(board[2][1]);l_8.setText(board[2][2]);
        }
    }

    public void mouseClicked(MouseEvent ev) {
        String temp = "X";
        String player = "X" ; 
        int mY = ev.getX() / 160;
        int mX = ev.getY() / 160;
        try{
            if(mX+1 <= 2 && board[mX+1][mY].equals(" ")){
                temp = board[mX][mY];
                board[mX][mY] = board[mX+1][mY];
                board[mX+1][mY] = temp;
            }
            else if(mX-1 >= 0 && board[mX-1][mY].equals(" ")){
                temp = board[mX][mY];
                board[mX][mY] = board[mX-1][mY];
                board[mX-1][mY] = temp;
            }

            else if(mY+1 <= 3 && board[mX][mY+1].equals(" ")){
                temp = board[mX][mY];
                board[mX][mY] = board[mX][mY+1];
                board[mX][mY+1] = temp;
            }

            else if(mY-1 >= 0 && board[mX][mY-1].equals(" ")){
                temp = board[mX][mY];
                board[mX][mY] = board[mX][mY-1];
                board[mX][mY-1] = temp;
            }
            if(check_winner() == true){
                f.setVisible(false);
                JFrame winner = new JFrame("Sorting_Game");
                JLabel lwin = new JLabel(" You Win!");
                lwin.setBounds(400,250,100,100);
                lwin.setFont(new Font("Sample glyphs",Font.BOLD, 90));
                winner.setVisible(true);
                winner.add(lwin);
                winner.setSize(500,500);
                winner.setResizable(false);
            }

        }

        catch(Exception e){

        }


    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent e) {}
    public static boolean check_winner(){
        if(board[0][0] == board [0][1] && board [0][1] == board [0][2] || board[1][0] == board [1][1] && board [1][1] == board [1][2] || board[2][0] == board [2][1] && board [2][1] == board [2][2] || board[0][0] == board [1][0] && board [1][0] == board [2][0] || board[0][1] == board [1][1] && board [1][1] == board [2][1] || board[0][2] == board [1][2] && board [1][2] == board [2][2] || board[0][0] == board [1][1] && board [1][1] == board [2][2] || board[0][2] == board [1][1] && board [1][1] == board [2][0]) {
            return true;
        }
        else{
            return false;
        }
    }
}