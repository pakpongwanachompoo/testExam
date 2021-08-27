import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  


class DrawLine extends JPanel {
    int l ;
    DrawLine(int n){
        l = n ;
    }
    public  void paintComponent(Graphics g) {
        for(int i=0; i<=l; i++){
            g.drawLine(((500/l)*i), 0, ((500/l)*i), 500);
            g.drawLine(0, ((500/l)*i), 500, ((500/l)*i));
        }
        //vertical line
       //g.drawLine(l, 0, l, 500);
    
        //horizontal line
       //g.drawLine(0, l, 500, l);
    
    }
}

public class q3 implements MouseListener{
    public String[][] board ;
    public int n;
    public String player ;
    public JFrame table;
    public int count = 0;
  
    public static void main(String[] arg){
        q3 j = new q3();
        j.setup();
        //setsize_board();
        //Switch_position();   
    }
    public void setup(){
        JFrame set = new JFrame("setsize_board");            
        JButton built = new JButton("Built");
        built.setBounds(210, 45, 75, 40);  
        JTextField inp=new JTextField();
        inp.setBounds(115, 50, 90,30);
        inp.setFont(new Font("Sample glyphs",Font.BOLD, 15));      
        JLabel Text = new JLabel("Enter size:");
        Text.setFont(new Font("Sample glyphs",Font.BOLD, 20));
        Text.setBounds(10, 40, 100, 50);
        set.add(Text);
        set.add(built);
        set.add(inp);    
        set.setSize(300,150);    
        set.setLayout(null);    
        set.setVisible(true);
        built.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){ 
                String size = inp.getText();  
                n = Integer.parseInt(size);
                set.setVisible(false);
                board = new String[n][n];
                for(int i=0; i<n; i++){
                    for(int j=0; j<n; j++){
                        board [i][j] = String.valueOf(i) + String.valueOf(j);
                    }
                } 
                boardbuilt();
            }  
        });
    }
    public void boardbuilt(){
        table = new JFrame("setsize_board");
        table.setVisible(true);
        table.setSize(500,530);
        JLabel[][] label = new JLabel[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){     
            label[i][j] = new JLabel();
            label[i][j].setText("  " + board[i][j]);
            label[i][j].setBounds(((500/n)*j), ((500/n)*i), 500/n, 500/n);
            label[i][j].setFont(new Font("Sample glyphs",Font.BOLD, 30));
            table.add(label[i][j]);
            }
        }
        DrawLine panel = new DrawLine(n);
        panel.addMouseListener(this);
        table.add(panel);   
        if(check_winner()==true){
            if(count%2 == 0){
                table.setVisible(false);
                JFrame winner = new JFrame("Sorting_Game");
                JLabel lwin = new JLabel("   O Win!");
                lwin.setBounds(400,250,100,100);
                lwin.setFont(new Font("Sample glyphs",Font.BOLD, 90));
                winner.setVisible(true);
                winner.add(lwin);
                winner.setSize(600,600);
                winner.setResizable(false);
                winner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }else if(count%2 == 1){
                table.setVisible(false);
                JFrame winner = new JFrame("Sorting_Game");
                JLabel lwin = new JLabel("   X Win!");
                lwin.setBounds(400,250,100,100);
                lwin.setFont(new Font("Sample glyphs",Font.BOLD, 90));
                winner.setVisible(true);
                winner.add(lwin);
                winner.setSize(600,600);
                winner.setResizable(false); 
                winner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        } 
        
    }

    public void mouseClicked(MouseEvent ev) {
        int mX = ev.getX() / (500/n);
        int mY = ev.getY() / (500/n);
        int endcount = n*n;
        System.out.print(mX);
        System.out.print(mY);
        if(count == endcount){
            table.setVisible(false);
            JFrame winner = new JFrame("Sorting_Game");
            JLabel lwin = new JLabel(" X Win!");
            lwin.setBounds(400,250,100,100);
            lwin.setFont(new Font("Sample glyphs",Font.BOLD, 90));
            winner.setVisible(true);
            winner.add(lwin);
            winner.setSize(500,500);
            winner.setResizable(false);
        }         
        try{
            String pre_addpo = String.valueOf(mY) + String.valueOf(mX);
            if(count%2 == 0 && board[mY][mX].equals(pre_addpo)){
                board[mY][mX] = "X" ;
                count++ ;
                table.setVisible(false);
                boardbuilt();
                
            }else if(count%2 == 1 && board[mY][mX].equals(pre_addpo)){
                board[mY][mX] = "O" ;
                count++ ;
                table.setVisible(false);
                boardbuilt();
            }
        }catch(Exception e){

        }
    
    }   
    
        
    
    public boolean check_winner(){
        String[] refX = new String[n];
        String[] refO = new String[n];
        String[] boardcheck = new String[n];
        for(int i=0; i<n; i++){
            refX[i] = "X" ;
            refO[i] = "O" ;
        }
        for(int i=0; i<n; i++){
            boardcheck = new String[n];
            for(int j=0; j<n; j++){
                boardcheck[j] = board[i][j];    
            }   
            if(Arrays.deepEquals(boardcheck,refX) || Arrays.deepEquals(boardcheck,refO)){
                return true;
            }    
        }
        for(int i=0; i<n; i++){
            boardcheck = new String[n];
            for(int j=0; j<n; j++){
                boardcheck[j] = board[j][i];    
            }   
            if(Arrays.deepEquals(boardcheck,refX) || Arrays.deepEquals(boardcheck,refO)){
                return true;
            }   
        }
        boardcheck = new String[n];
        for(int i=0; i<n; i++){
            boardcheck[i] = board[i][i];
            if(Arrays.deepEquals(boardcheck,refX) || Arrays.deepEquals(boardcheck,refO)){
                return true;
            }
        }
        boardcheck = new String[n];
        for(int i=0; i<n; i++){
            boardcheck[i] = board[i][(n-1-i)];
            if(Arrays.deepEquals(boardcheck,refX) || Arrays.deepEquals(boardcheck,refO)){
                return true;
            }
        }
        return false;  
    }
   
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}