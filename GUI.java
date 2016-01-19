package othelloWithGUI;

import java.awt.*;

import javax.swing.*;

import othelloWithGUI.Board.values;
import othelloWithGUI.Board.status;
import othelloWithGUI.InvalidMoveException;

import java.awt.event.*;
import java.util.Scanner;




public class GUI extends  JFrame implements ActionListener {
	
	 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		static Player player1;
		static Player player2;
	    static Board board = new Board();
	    JPanel[] row = new JPanel[9];
	    JButton[] button = new JButton[64];
	    
	    Dimension displayDimension = new Dimension(35,35);
	    Dimension scoreDimension = new Dimension(500,45);
	    JTextArea display = new JTextArea(1,20);
	    Font font = new Font("VERDANA",Font.ITALIC, 12);
	    
	    

		Player currentPlayer;
		values playerNumber;
	  
	    GUI() {
        super("OTHELLO");
        setDesign();
        setSize(500, 500); 
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout grid = new GridLayout(9,8);
        setLayout(grid);
        
        FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
        GridLayout f2 = new GridLayout();
        for(int i = 0; i < 9; i++)
            row[i] = new JPanel();
        row[0].setLayout(f1);
        for(int i = 1; i < 9; i++)
            row[i].setLayout(f2);
        
        for(int i = 0; i < 64; i++) {
            if(i==27 || i ==36){
            	
            	button[i] = new JButton();
                button[i].setBackground(Color.BLACK);
                button[i].setPreferredSize(displayDimension);
                button[i].addActionListener( this);
               
            }
            
            else if(i==28 || i ==35){
            	button[i] = new JButton();
                button[i].setBackground(Color.WHITE);
                button[i].setPreferredSize(displayDimension);
                button[i].addActionListener( this);
                           	
            }
            else{
        	button[i] = new JButton();
            button[i].setBackground(Color.darkGray);
            button[i].setPreferredSize(displayDimension);
            button[i].addActionListener( this);
            
            }
        }
        display.setBackground(Color.LIGHT_GRAY);
        display.setFont(font);
        display.setEditable(true);
        display.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        display.setPreferredSize(scoreDimension);
        
        row[0].add(display);
        add(row[0]);
        
        for(int i = 0; i < 8; i++)
            row[1].add(button[i]);
            add(row[1]);
            
        for(int i = 8; i < 16; i++)
            row[2].add(button[i]);
            add(row[2]);
            
        for(int i = 16; i < 24; i++)
            row[3].add(button[i]);
            add(row[3]);
                
        for(int i = 24; i < 32; i++)
            row[4].add(button[i]);
            add(row[4]);
            
        for(int i = 32; i < 40; i++)
            row[5].add(button[i]);
            add(row[5]);
                
        for(int i = 40; i < 48; i++)
            row[6].add(button[i]);
            add(row[6]);
                
        for(int i = 48; i < 56; i++)
            row[7].add(button[i]);
            add(row[7]);
                    
        for(int i = 56; i < 64; i++)
            row[8].add(button[i]);
            add(row[8]);    

    		Scanner console = new Scanner(System.in);
    		System.out.println("Please enter first player's name");
    		String first = console.next();
    		System.out.println("Please enter second player's name");
    		String second = console.next();
    		player1 = new Player(first);
    		player2 = new Player(second);
    		
    		board.countNum();
    		   
        setVisible(true);

		currentPlayer = player1;
		playerNumber = values.PLAYER1;
		
        display.setText("  "+player1.getName()+" (Black) : "+2 + "\t\t             "+player2.getName()+" (White) : "+2);
        display.append("\n  " + currentPlayer.getName()+"  :  Please start the game ");
        
    }
    
	   
	
	 public final void setDesign() {
	        try {
	            UIManager.setLookAndFeel(
	                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	        } catch(Exception e) {   
	        }
	    }
	
	 
	 
	public static status displayWinner(){
		if (board.getWinner() == status.DRAW) {
			return status.DRAW;
		} else if (board.getWinner() == status.PLAYER1) {
			return status.PLAYER1;
		} else {
			return status.PLAYER2;
		}
	}
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		int row = -1, col = -1;
      
		if(ae.getSource()==button[0]){
			
			row=0;
			col=0;
		}
        if(ae.getSource()==button[1]){
			
			row=0;
			col=1;
		}
        if(ae.getSource()==button[2]){
			
			row=0;
			col=2;
		}
        if(ae.getSource()==button[3]){
			
			row=0;
			col=3;
		}        
		if(ae.getSource()==button[4]){
			
			row=0;
			col=4;
		}
        if(ae.getSource()==button[5]){
			
			row=0;
			col=5;
		}
        if(ae.getSource()==button[6]){
			
			row=0;
			col=6;
		}
        if(ae.getSource()==button[7]){
			
			row=0;
			col=7;
		}
		if(ae.getSource()==button[8]){
			
			row=1;
			col=0;
		}
        if(ae.getSource()==button[9]){
			
			row=1;
			col=1;
		}
        if(ae.getSource()==button[10]){
			
			row=1;
			col=2;
		}
        if(ae.getSource()==button[11]){
			
			row=1;
			col=3;
		}
		if(ae.getSource()==button[12]){
			
			row=1;
			col=4;
		}
        if(ae.getSource()==button[13]){
			
			row=1;
			col=5;
		}
        if(ae.getSource()==button[14]){
			
			row=1;
			col=6;
		}
        if(ae.getSource()==button[15]){
			
			row=1;
			col=7;
		}        
		if(ae.getSource()==button[16]){
			
			row=2;
			col=0;
		}
        if(ae.getSource()==button[17]){
			
			row=2;
			col=1;
		}
        if(ae.getSource()==button[18]){
			
			row=2;
			col=2;
		}
        if(ae.getSource()==button[19]){
			
			row=2;
			col=3;
		}        
		if(ae.getSource()==button[20]){
			
			row=2;
			col=4;
		}
        if(ae.getSource()==button[21]){
			
			row=2;
			col=5;
		}
        if(ae.getSource()==button[22]){
			
			row=2;
			col=6;
		}
        if(ae.getSource()==button[23]){
			
			row=2;
			col=7;
		}
		if(ae.getSource()==button[24]){
			
			row=3;
			col=0;
		}
        if(ae.getSource()==button[25]){
			
			row=3;
			col=1;
		}
        if(ae.getSource()==button[26]){
			
			row=3;
			col=2;
		}
        if(ae.getSource()==button[27]){
			
			row=3;
			col=3;
		}
		if(ae.getSource()==button[28]){
			
			row=3;
			col=4;
		}
        if(ae.getSource()==button[29]){
			
			row=3;
			col=5;
		}
        if(ae.getSource()==button[30]){
			
			row=3;
			col=6;
		}
        if(ae.getSource()==button[31]){
			
			row=3;
			col=7;
		}
		if(ae.getSource()==button[32]){
			
			row=4;
			col=0;
		}
        if(ae.getSource()==button[33]){
			
			row=4;
			col=1;
		}
        if(ae.getSource()==button[34]){
			
			row=4;
			col=2;
		}
        if(ae.getSource()==button[35]){
			
			row=4;
			col=3;
		}        
		if(ae.getSource()==button[36]){
			
			row=4;
			col=4;
		}
        if(ae.getSource()==button[37]){
			
			row=4;
			col=5;
		}
        if(ae.getSource()==button[38]){
			
			row=4;
			col=6;
		}
        if(ae.getSource()==button[39]){
			
			row=4;
			col=7;
		}
		if(ae.getSource()==button[40]){
			
			row=5;
			col=0;
		}
        if(ae.getSource()==button[41]){
			
			row=5;
			col=1;
		}
        if(ae.getSource()==button[42]){
			
			row=5;
			col=2;
		}
        if(ae.getSource()==button[43]){
			
			row=5;
			col=3;
		}
		if(ae.getSource()==button[44]){
			
			row=5;
			col=4;
		}
        if(ae.getSource()==button[45]){
			
			row=5;
			col=5;
		}
        if(ae.getSource()==button[46]){
			
			row=5;
			col=6;
		}
        if(ae.getSource()==button[47]){
			
			row=5;
			col=7;
		}
		if(ae.getSource()==button[48]){
			
			row=6;
			col=0;
		}
        if(ae.getSource()==button[49]){
			
			row=6;
			col=1;
		}
        if(ae.getSource()==button[50]){
			
			row=6;
			col=2;
		}
        if(ae.getSource()==button[51]){
			
			row=6;
			col=3;
		}        
		if(ae.getSource()==button[52]){
			
			row=6;
			col=4;
		}
        if(ae.getSource()==button[53]){
			
			row=6;
			col=5;
		}
        if(ae.getSource()==button[54]){
			
			row=6;
			col=6;
		}
        if(ae.getSource()==button[55]){
			
			row=6;
			col=7;
		}
		if(ae.getSource()==button[56]){
			
			row=7;
			col=0;
		}
        if(ae.getSource()==button[57]){
			
			row=7;
			col=1;
		}
        if(ae.getSource()==button[58]){
			
			row=7;
			col=2;
		}
        if(ae.getSource()==button[59]){
			
			row=7;
			col=3;
		}
		if(ae.getSource()==button[60]){
			
			row=7;
			col=4;
		}
        if(ae.getSource()==button[61]){
			
			row=7;
			col=5;
		}
        if(ae.getSource()==button[62]){
			
			row=7;
			col=6;
		}
        if(ae.getSource()==button[63]){
			
			row=7;
			col=7;
		}
        
       
			try {
				board.updateBoard(playerNumber, row, col);
				board.changeBoard(this);
				currentPlayer = currentPlayer == player1?player2:player1;
				playerNumber = playerNumber == values.PLAYER1? values.PLAYER2:values.PLAYER1;
				board.countNum();
				
				if(board.checkValidMoves(playerNumber)){
					player1.setNoMove(true);
					player2.setNoMove(true);
					
					display.setText("  "+player1.getName()+" (Black) : "+board.getCount1() + "\t\t             "
				               +player2.getName()+" (White) : "+board.getCount2());
					display.append("\n  " + currentPlayer.getName()+"  :  Your Turn ");
				}
				
				else{
					
					display.setText("  "+player1.getName()+" (Black) : "+board.getCount1() + "\t\t             "
				               +player2.getName()+" (White) : "+board.getCount2());
					display.append("\n  " + currentPlayer.getName()+"  :  THERE ARE NO VALID MOVES FOR YOU  ");
					values temp=(playerNumber == values.PLAYER1)?values.PLAYER2:values.PLAYER1;
					
					
					if(!board.checkValidMoves(temp)){
						display.setText("  "+player1.getName()+" (Black) : "+board.getCount1() + "\t\t             "
					                   +player2.getName()+" (White) : "+board.getCount2());
				       
						String winner = displayWinner()==status.DRAW ? "DRAW" : (displayWinner()==status.PLAYER1 ? player1.getName() : player2.getName());
						font = new Font("sansserif",Font.BOLD, 14);
			            display.setFont(font);
						display.append("\n  No more moves available, WINNER is : "+ winner );
				    
						
					}
					
					else{
						
						currentPlayer.setNoMove(false);
						currentPlayer = currentPlayer == player1?player2:player1;
						playerNumber = playerNumber == values.PLAYER1? values.PLAYER2:values.PLAYER1;
						board.countNum();
						display.setText("  "+player1.getName()+" (Black) : "+board.getCount1() + "\t\t             "+
						player2.getName()+" (White) : "+board.getCount2());
				        display.append("\n  " + currentPlayer.getName()+"  :  Your Turn ");
						 
						
					}
			
				}
		        
		        
		   
			} catch (InvalidMoveException e) {
				display.setText("  "+player1.getName()+" (Black) : "+board.getCount1() + "\t\t             "+player2.getName()+" (White) : "+board.getCount2());
		        display.append("\n  " + currentPlayer.getName()+"  :  INVALID MOVE..PLEASE TRY AGAIN !! ");
				
								
			}
			
		
	
	        
	}
}
	