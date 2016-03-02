import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.util.*;

public class MineSweeper implements MouseListener, Game{
	private int rows = 10; //by default, 10 rows and columns
	private int cols = 10;
	MineSweeperSquare[][] boardArray;
	JPanel boardPanel;

	public MineSweeper(int rows, int cols){
		this.rows = rows;
		this.cols = cols;
		boardArray = new MineSweeperSquare[rows][cols];
	}

	public MineSweeper(){
		boardArray = new MineSweeperSquare[rows][cols];
	}

	public JPanel getBoard(){
		boardPanel = new JPanel();
		boardPanel.setLayout(new GridLayout(rows,cols));

		//populate boardArray, add squares to boardPanel with MouseListeners attached
		for (int r = 0; r < rows; r++){
			for (int c = 0; c < cols; c++){
				MineSweeperSquare square = new MineSweeperSquare();
				square.addMouseListener(this);
				boardArray[r][c] = square;
				boardPanel.add(square);
				//some probability of there being a bomb on a give square
				if(Math.floor(Math.random() * 10) < 3){
					square.setBomb();
				}
			}//end inner for loop
		}//end for loop
		
		//each square 'knows' how many bombs it is adjacent to
		for (int r = 0; r < rows; r++){
			for (int c = 0; c < cols; c++){
				MineSweeperSquare s = boardArray[r][c];
				if(s.isBomb()){
					java.util.List<MineSweeperSquare> neighbors = getNeighbors(r,c);
					for(MineSweeperSquare n : neighbors){
						n.incrementNeighborBombCount();
					}
				}
			}//end inner for loop
		}//end for loop
		
		return boardPanel;

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
			for (int r = 0; r < rows; r++){
				for (int c = 0; c < cols; c++){
					MineSweeperSquare square = boardArray[r][c];
					if (square.isBomb()){
						square.setIconIndex(1);
					}
					else{
						square.setIconIndex(3);
					}
					square.repaint();
				}//end inner for loop
			}//end for loop
						boardPanel.setEnabled(false);


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
			return boardArray[row][col];
		}catch(IndexOutOfBoundsException e){}
		return null;
	}
	
}
