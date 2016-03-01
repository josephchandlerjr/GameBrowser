import javax.swing.*;
import java.awt.*;


public class MineSweeperSquare extends JPanel{
	private int iconIndex;
	private boolean iconIndexFinal;
	private boolean bomb;
	private int neighborBombs;

	public MineSweeperSquare(){
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public void incrementNeighborBombCount(){
		neighborBombs++;
	}
	/**
	 * toggels between iconIndex 0, 1, and 2 
	 */
	public void incrementIconIndex(){
		if(!iconIndexFinal){
			iconIndex = (iconIndex + 1) % 3;
		}
	}
	/**
	 * sets iconIndex explicitly
	 */
	public void setIconIndex(int n){
		iconIndex = n;
	}
	public void makeIconIndexFinal(){
		iconIndexFinal = true;
	}
	/**
	 * sets bomb instance variable to true
	 */
	public void setBomb(){
		bomb = true;
	}
	/**
	 * @return true if square holds a bomb else false
	 */
	public boolean isBomb(){
		return bomb;
	}
	/**
	 * used for debugging purposes
	 * sets neighborBombs explicitly
	 */
	public void setNeighborBombs(int n){
		neighborBombs= n;
	}

	public void paintComponent(Graphics g){
		int w = this.getWidth();
		int h = this.getHeight();
		g.setColor(Color.gray);
		g.fillRect(0,0,w,h);
		g.setFont(new Font("ARIAL",Font.BOLD,h/2));
		switch(iconIndex){
			case(1) : g.setColor(Color.red); 
				  g.fillOval(w/4,h/4,w/2,h/2);
				  break;
		        case(2) : g.setColor(Color.black);
				  g.drawString("?",w/2,h/2);
				  break;
	                case(3) : g.setColor(Color.black);
				  g.drawString(Integer.toString(neighborBombs),w/2,h/2);
		}
	}

}

