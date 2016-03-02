import javax.swing.JPanel;

/**
 * classes which implement the Game interface have only one 
 * method - getBoard - which returns a JPanel housing the game
 */
public interface Game{
	public JPanel getBoard();
}
