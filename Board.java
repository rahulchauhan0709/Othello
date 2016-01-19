package othelloWithGUI;

import java.awt.Color;
import java.util.Stack;

import othelloWithGUI.InvalidMoveException;
//import TicTacToe.Board.status;
//import TicTacToe.Board.values;
//import BinaryTree.Node;
//import BinaryTree.Stack;
//import IntStackQueue.OthelloNode;

public class Board {
	
	public enum values {
		NONE, PLAYER1, PLAYER2
	}
	
	public enum status {
		NOTDONE, PLAYER1, PLAYER2, DRAW
	}
	
	
	private int count1=2,count2=2;
	private values[][] board=new values[8][8];
	
	//TODO
	public  void countNum(){
		int c1=0,c2=0;
		for(int i=0 ; i< 8 ; i++){
			for(int j =0 ; j<8 ; j++){
				if(board[i][j]==values.PLAYER1) c1++;
				else if(board[i][j]==values.PLAYER2) c2++;
				else continue;
			}
		}
	count1=c1;
	count2=c2;
	}
	
	
	public boolean checkValidMoves(values player){
		
		for(int i=0; i<8 ; i++){
			for(int j=0 ; j<8 ; j++){
				boolean output=true;
				if( board[i][j]!=player ) continue;
				else{
					    int row=i,column=j+1 , count=0;
						while(  column<8 && board[row][column]!=values.NONE){
							count=1;
							if(board[row][column] == (player==values.PLAYER1?values.PLAYER2:values.PLAYER1)){
								column++;
							}
							else {
								output=false;
								break;
							}
						}
						if(count==0 || column==8) output=false;
						if(output==true) return output;
						count=0;
						column=j-1;
						
						while(column>=0 && board[row][column]!=values.NONE ){
							count=1;
							if(board[row][column] == (player==values.PLAYER1?values.PLAYER2:values.PLAYER1)){
								column--;
							}
							else {
								output=false;
								break;
							}
						}
						if(count==0 || column==-1) output=false;
						if(output==true) return output;
						output=true;
						count=0;
						column=j;
						row=i-1;
						while(  row>=0 && board[row][column]!=values.NONE ){
							count=1;
							if(board[row][column] == (player==values.PLAYER1?values.PLAYER2:values.PLAYER1)){
								row--;
							}
							else {
								output=false;
								break;
							}
						}
						if(count==0 || row==-1) output=false;
						if(output==true) return output;
						
						output=true;
						count=0;
						column=j;
						row=i+1;
						
						while( row<8 && board[row][column]!=values.NONE ){
							count=1;
							if(board[row][column] == (player==values.PLAYER1?values.PLAYER2:values.PLAYER1)){
								row++;
							}
							else {
								output=false;
								break;
							}
						}
						if(count==0 || row==8) output=false;
						if(output==true) return output;
						
						output=true;
						count=0;
						column=j+1;
						row=i-1;
						while( (row>=0 && column <8) && board[row][column]!=values.NONE ){
							count=1;
							if(board[row][column] == (player==values.PLAYER1?values.PLAYER2:values.PLAYER1)){
								row--;
								column++;
							}
							else {
								output=false;
								break;
							}
						}
						if(count==0 || row==-1 || column==8) output=false;
						if(output==true) return output;
						
						output=true;
						count=0;
						column=j-1;
						row=i+1;
						while(  (row<8 && column >=0) && board[row][column]!=values.NONE ){
							count=1;
							if(board[row][column] == (player==values.PLAYER1?values.PLAYER2:values.PLAYER1)){
								row++;
								column--;
							}
							else {
								output=false;
								break;
							}
						}
						if(count==0 || row==8 || column==-1) output=false;
						if(output==true) return output;
						
						output=true;
						count=0;
						column=j-1;
						row=i-1;
						while((row>=0 && column >=0) && board[row][column]!=values.NONE ){
							count=1;
							if(board[row][column] == (player==values.PLAYER1?values.PLAYER2:values.PLAYER1)){
								row--;
								column--;
							}
							else {
								output=false;
								break;
							}
						}
						if(count==0 || row==-1 || column==-1) output=false;
						if(output==true) return output;
						
						output=true;
						count=0;
						column=j+1;
						row=i+1;
						
						while( (row<8 && column<8) && board[row][column]!=values.NONE ){
							count=1;
							if(board[row][column] == (player==values.PLAYER1?values.PLAYER2:values.PLAYER1)){
								row++;
								column++;
							}
							else {
								output=false;
								break;
							}
						}
						if(count==0 || row==8 || column==8) output=false;
						if(output==true) return output;
					}
				}
			}
		
		return false;
	}

	public void updateBoard(values player,int i , int j) throws InvalidMoveException {
		
		if(board[i][j]!=values.NONE) throw new InvalidMoveException();
		boolean mainCount=false;
		OthelloNode element=new OthelloNode();
		Stack<OthelloNode> stack = new Stack<OthelloNode>();
			boolean output=true;
			element.i=i;
			element.j=j;
			stack.push(element);
			int row=i,column=j+1 , count=0;
			element.i=i;
			element.j=j;
			stack.push(element);
							while(column<8 && board[row][column]!=player){
								count=1;
								if(board[row][column] == (player==values.PLAYER1?values.PLAYER2:values.PLAYER1)){
									OthelloNode elements=new OthelloNode();
									elements.i=row;
									elements.j=column;
									stack.push(elements);
									column++;
								}
								else {
									output=false;
									break;
								}
							}
							
							if(count==0 || column==8) {
								output=false;
								}
							
							
							if(output==false){
								while(!stack.empty()){
									stack.pop();
								}
							} 
							
							if(output==true) {
								mainCount=true;
								
								while(!stack.empty()){
									OthelloNode temp=stack.pop();
									board[temp.i][temp.j]= (player);
								}
							} 
							element.i=i;
							element.j=j;
							stack.push(element);
							count=0;
							column=j-1;
							row=i;
							output=true;
							
							while( column>=0 && board[row][column]!=player){
								count=1;
								if(board[row][column] == (player==values.PLAYER1?values.PLAYER2:values.PLAYER1)){
									OthelloNode elements=new OthelloNode();
									elements.i=row;
									elements.j=column;
									stack.push(elements);
									column--;
								}
								else {
									output=false;
									break;
								}
							}
							
							if(count==0 || column==-1) {
								output=false;
								
							}
							
							if(output==false){
								while(!stack.empty()){
									stack.pop();
								}
							}
							
							if(output==true) {
								mainCount=true;
								
								while(!stack.empty()){
									OthelloNode temp=stack.pop();
									board[temp.i][temp.j]= (player);
								}
							} 
							
							element.i=i;
							element.j=j;
							stack.push(element);
							count=0;
							column=j;
							row=i-1;
							output=true;
							
							
							while(row>=0 && board[row][column]!=player ){
								count=1;
								if(board[row][column] == (player==values.PLAYER1?values.PLAYER2:values.PLAYER1)){
									OthelloNode elements=new OthelloNode();
									elements.i=row;
									elements.j=column;
									stack.push(elements);
									row--;
								}
								else {
									output=false;
									break;
								}
							}
							
							if(count==0 || row==-1) {
								output=false;
							}
							if(output==false){
								while(!stack.empty()){
									stack.pop();
								 }
							}
							
							if(output==true) {
								mainCount=true;
								if(row!=-1)
								while(!stack.empty()){
									OthelloNode temp=stack.pop();
									board[temp.i][temp.j]= (player);
								}
							} 
							count=0;
							column=j;
							row=i+1;
							output=true;
							element.i=i;
							element.j=j;
							stack.push(element);
							
							while(row<8 && board[row][column]!=player){
								count=1;
								if(board[row][column] == (player==values.PLAYER1?values.PLAYER2:values.PLAYER1)){
									OthelloNode elements=new OthelloNode();
									elements.i=row;
									elements.j=column;
									stack.push(elements);
									row++;
								}
								else {
									output=false;
									break;
								}
							}
							
							if(count==0 || row==8) {
								output=false;
							}
							if(output==false){
								while(!stack.empty()){
									stack.pop();
								}
							}
							
							if(output==true) {
								mainCount=true;
								
								while(!stack.empty()){
									OthelloNode temp=stack.pop();
									board[temp.i][temp.j]= (player);
								}
							} 
							element.i=i;
							element.j=j;
							stack.push(element);
							count=0;
							column=j+1;
							row=i-1;
							output=true;
							
							while((row>=0 && column<8) && board[row][column]!=player ){
								count=1;
								if(board[row][column] == (player==values.PLAYER1?values.PLAYER2:values.PLAYER1)){
									OthelloNode elements=new OthelloNode();
									elements.i=row;
									elements.j=column;
									stack.push(elements);
									row--;
									column++;
								}
								else {
									output=false;
									break;
								}
							}
							
							if(count==0 || column==8 || row==-1) {
								output=false;
							}
							if(output==false){
								while(!stack.empty()){
									stack.pop();
								}
							}
							
							if(output==true) {
								mainCount=true;
								
								while(!stack.empty()){
									OthelloNode temp=stack.pop();
									board[temp.i][temp.j]= (player);
								}
							} 
							element.i=i;
							element.j=j;
							stack.push(element);
							count=0;
							column=j-1;
							row=i+1;
							output=true;
							
							while( (row<8 && column>=0) && board[row][column]!=player ){
								count=1;
								if(board[row][column] == (player==values.PLAYER1?values.PLAYER2:values.PLAYER1)){
									OthelloNode elements=new OthelloNode();
									elements.i=row;
									elements.j=column;
									stack.push(elements);
									row++;
									column--;
								}
								else {
									output=false;
									break;
								}
							}
							
							if(count==0 || column==-1 || row==8) {
								output=false;
							}
							
							if(output==false){
								while(!stack.empty()){
									stack.pop();
								}
							}
							
							if(output==true) {
								mainCount=true;
								while(!stack.empty()){
									OthelloNode temp=stack.pop();
									board[temp.i][temp.j]= (player);
								}
							} 
							element.i=i;
							element.j=j;
							stack.push(element);
							count=0;
							column=j-1;
							row=i-1;
							output=true;
							while( (row>=0 && column>=0) && board[row][column]!=player){
								count=1;
								if(board[row][column] == (player==values.PLAYER1?values.PLAYER2:values.PLAYER1)){
									OthelloNode elements=new OthelloNode();
									elements.i=row;
									elements.j=column;
									stack.push(elements);
									row--;
									column--;
								}
								else {
									output=false;
									break;
								}
							}
							
							if(count==0 || column==-1 || row==-1) {
								output=false;
							}
							if(output==false){
								while(!stack.empty()){
									stack.pop();
								}
							}
							
							if(output==true) {
								mainCount=true;
								while(!stack.empty()){
									OthelloNode temp=stack.pop();
									board[temp.i][temp.j]= (player);
								}
							} 
							element.i=i;
							element.j=j;
							stack.push(element);
							count=0;
							column=j+1;
							row=i+1;
							output=true;
							while( (row<8 && column<8) && board[row][column]!=player ){
								count=1;
								if(board[row][column] == (player==values.PLAYER1?values.PLAYER2:values.PLAYER1)){
									OthelloNode elements=new OthelloNode();
									elements.i=row;
									elements.j=column;
									stack.push(elements);
									row++;
									column++;
								}
								else {
									output=false;
									break;
								}
							}
							
							if(count==0 || column==8 || row==8) {
								output=false;
							}
							if(output==false){
								while(!stack.empty()){
									stack.pop();
								}
							}
							
							if(output==true) {
								mainCount=true;
								while(!stack.empty()){
									OthelloNode temp=stack.pop();
									board[temp.i][temp.j]= player;
								}
							} 
							
					if(!mainCount) throw new InvalidMoveException();
		}
	
	
	public int getCount1(){
		return count1;
	}
	public int getCount2(){
		return count2;
	}
	
	public status getWinner(){
		if(count1>count2) return status.PLAYER1;
		else if(count1<count2) return status.PLAYER2;
		else return status.DRAW;
	} 

	
	public void changeBoard(GUI gui) {
		
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j] == values.PLAYER1)
					gui.button[i*8+j].setBackground(Color.BLACK);
				else if (board[i][j] == values.PLAYER2)
					gui.button[i*8+j].setBackground(Color.white);
				else
					continue;
			}
			
		}
	}
	
	public boolean isBoardFull(){
	 
		boolean output=true;
		for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 8; j++) {
			if (board[i][j] == values.NONE){
				
				output=false;
				return output;
				}
			}
			
	}
	
	return output;
	
}
	
	public Board() {
		
		    for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j] = values.NONE;
			}
		}
		board[3][3]=values.PLAYER1;
		board[4][4]=values.PLAYER1;
		board[3][4]=values.PLAYER2;
		board[4][3]=values.PLAYER2;
		
	}

}