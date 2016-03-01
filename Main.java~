import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Main implements MouseListener{
	private JFrame frame;
	private int rows = 10;
	private int cols = 10;
	MineSweeperSquare[][] board;

	public static void main(String[] args){
		(new Main()).go();
	}
	public void go(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel gameBoard = (new MineSweeperBoard(rows,cols)).getBoard();
		Container contentPane = frame.getContentPane();
		contentPane.add(gameBoard,BorderLayout.CENTER);
		/**
		contentPane.setLayout(new GridLayout(rows,cols));

		

		board = new MineSweeperSquare[rows][cols];

		for (int r = 0; r < rows; r++){
			for (int c = 0; c < cols; c++){
				MineSweeperSquare square = new MineSweeperSquare();
				square.addMouseListener(this);
				board[r][c] = square;
				contentPane.add(square);
				if(Math.floor(Math.random()* 10) < 3){
					square.setBomb();
				}
			}
		}
		for (int r = 0; r < rows; r++){
			for (int c = 0; c < cols; c++){
				MineSweeperSquare s = board[r][c];
				if(s.isBomb()){
					java.util.List<MineSweeperSquare> neighbors = getNeighbors(r,c);
					for(MineSweeperSquare n : neighbors){
						n.incrementNeighborBombCount();
					}
				}
			}
		}
		*/
		frame.setSize(300,300);
		frame.setVisible(true);

	}
	// next 5 methods implement MouseListener interface
	public void mouseClicked(MouseEvent e){
		MineSweeperSquare sqr = (MineSweeperSquare)(e.getSource());
		if(SwingUtilities.isRightMouseButton(e)){
			sqr.incrementIconIndex();
		}else if(!sqr.isBomb()){
			sqr.setIconIndex(3);
			sqr.makeIconIndexFinal();
		}else{
			System.out.println("game over");
		}
		sqr.repaint();
	}
	public void mouseEntered(MouseEvent e){
	}
	public void mouseExited(MouseEvent e){
	}
	public void mousePressed(MouseEvent e){
	}
	public void mouseReleased(MouseEvent e){
	}


	/**
	 * @param row row of square who's neighbors we are looking for
	 * @param col column of square who's neighbors we are looking for
	 * @return List containing squares which touch square who's neighbors we are looking for
	 */
	private java.util.List<MineSweeperSquare> getNeighbors(int row, int col){
		java.util.List<MineSweeperSquare> result = new ArrayList<MineSweeperSquare>(); 
		result.add(getSquare(row,col-1));  //west
		result.add(getSquare(row-1,col-1));//nw
		result.add(getSquare(row-1,col)); //north
		result.add(getSquare(row-1,col+1));//ne
		result.add(getSquare(row,col+1)); //east
		result.add(getSquare(row+1,col+1));//se
		result.add(getSquare(row+1,col));// south
		result.add(getSquare(row+1,col-1)); //sw
		for (int i=0; i < result.size();){
			if(result.get(i) == null){
				result.remove(i);
			}
			else{
				i++;
			}
		}
		return result;
	}	

	/**
	 * @param row
	 * @param col
	 * @return null if square does not exist else desired square
	 */
	private MineSweeperSquare getSquare(int row, int col){
		try{
			return board[row][col];
		}catch(IndexOutOfBoundsException e){}
		return null;
	}
	
}
