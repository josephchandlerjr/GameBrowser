import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * frame and main panel to browse games
 * games must implement the Game interface
 * Game objects are mapped to via there class names
 * and can be accessed via the frames menu 
 * Right now there is only one game in our menu, a simple 
 * MineSweeper game I built to serve as an example 
 */
public class GameBrowser implements ActionListener{
	private JFrame frame;
	private JPanel mainPanel = new JPanel(new GridLayout(0,1)); //gridlayout so expands to fill parent
	private Map<String,Game> gameMap = new HashMap<String,Game>();

	public static void main(String[] args){
		GameBrowser gameBrowser = new GameBrowser();
		gameBrowser.add(new MineSweeper());
                gameBrowser.buildGui();
	}

	/**
	 * adds a game to HashMap
	 * must be called prior to buildGui
	 */
	public void add(Game g){
		gameMap.put(g.getClass().getName(), g);
	}

	/**
	 * builds frame and puts mainPanel inside
	 * populates menu with games in instance variable gameMap
	 */
	public void buildGui(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Games");
		menuBar.add(menu);
		for (String gameName : gameMap.keySet() ){
			JMenuItem item = new JMenuItem(gameName);
			item.addActionListener(this);
			menu.add(item);
		}
	
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

		frame.setSize(300,300);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		String gameName = e.getActionCommand();
		Game game = gameMap.get(gameName);
		
		JPanel gameBoard = game.getBoard();

		mainPanel.removeAll();
		mainPanel.add(gameBoard,BorderLayout.CENTER);
		mainPanel.validate();
	        mainPanel.repaint();	
	}

}
