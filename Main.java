import java.awt.*;
import javax.swing.*;

public class Main{
	private JFrame frame;
	private int rows = 10;
	private int cols = 10;

	public static void main(String[] args){
		(new Main()).go();
	}
	public void go(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Game ms = new MineSweeper(rows,cols);
		JPanel gameBoard = ms.getBoard();

		Container contentPane = frame.getContentPane();
		contentPane.add(gameBoard,BorderLayout.CENTER);

		frame.setSize(300,300);
		frame.setVisible(true);
	}
}
