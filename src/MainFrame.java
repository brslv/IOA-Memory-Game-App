import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	
	/**
	 * Panels declarations & instantiations.
	 */
	private JPanel toolbar;
	private JPanel gameField;
	private Card cardButton;
	
	/**
	 * Buttons declarations & instantiations.
	 */
	
	/**
	 * The width and height of the app's main window;
	 */
	public final int APP_WIDTH = 500;
	public final int APP_HEIGHT = 500;
	public int gridLayoutRows = 2;
	public int gridLayoutCols = 3;
	public int numberOfCards = gridLayoutRows * gridLayoutCols;
	
	/**
	 * All the cards, generated for a particular game.
	 */
	ArrayList<Card> allCards = Card.generateCards(numberOfCards);
	
	/**
	 * Constructor of the MainFrame class.
	 * 
	 * - Sets the title of the app;
	 * - Instantiates the window, where the app runs;
	 * - Sets some basic frame settings like size, default close behavior, etc.;
	 * - Sets the layout of the main frame;
	 * - Instantiates some custom panels;
	 * - Places some components in the panels.
	 */
	public MainFrame(){
		
		/**
		 * Basic frame settings.
		 */
		// Setting the title of the app.
		// For now, some gibberish.
		super("The IOA Memory Game App, version 'too-alpha-to-be-cool'.");

		// This line sets the size of the app's window.
		this.setSize(APP_WIDTH, APP_HEIGHT);
		
		// In Swing we have layouts (the way the app positions elements on the screen).
		// Here we set the layout of the main frame (JFrame, the main window) of the app.
		// Read more here: http://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
		this.setLayout(new BorderLayout());
		
		// The default state of the main frame is hidden.
		// This line sets it to visible, which means the app will be visible
		// when the user starts it.
		this.setVisible(true); 
		
		// The default close operation doesn't terminate the app.
		// This line does the trick.
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// This doesn't allow the user to resize the frame.
		this.setResizable(false);
		
		MainMenu();
		addGamefield();
		
	} // End of MainFrame()
	
	/**
	 * This method adds a toolbar to the top of the main frame.
	 * Let's keep it simple for now.
	 * Let's just have only one button - the "Start new game" button.
	 */

		public void MainMenu() {
			Toolbar();
		}
		private void Toolbar() {
			JMenuBar menubar = new JMenuBar();
			
			JMenu start = new JMenu("New Game");
			JMenuItem eStart = new JMenuItem("New Game");
			eStart.setMnemonic(KeyEvent.VK_N);			
			eStart.setToolTipText("Start new game.");
			eStart.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent event) {
	            	startNewGame();
	            }
	        });
			JMenu difficulty = new JMenu("Difficulty");
			JMenuItem eDifficulty = new JMenuItem("Difficulty");
			eDifficulty.setToolTipText("Pick difficulty");
			eDifficulty.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					
				}
			});
			
			JMenu exit = new JMenu("Exit");
			 JMenuItem eExit = new JMenuItem("Exit");
		        eExit.setMnemonic(KeyEvent.VK_E);
		        eExit.setToolTipText("Exit application");
		        eExit.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent event) {
		                System.exit(0);
		            }
		        });

		        menubar.add(eStart);
		        menubar.add(eDifficulty);
		        menubar.add(eExit);
		        setJMenuBar(menubar);

		        setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	
	/**
	 * This method adds a new game field to the main frame.
	 * It's a square under the toolbar, where the magic should happen.
	 */
	public void addGamefield(){
		
		// Instantiating the gameField object.
		gameField = new JPanel();
		gameField.setSize(500, 500);
		
		// Adding the gameField to the frame.
		add(gameField, BorderLayout.CENTER);
		
		// Setting the layout of the gameField
		gameField.setLayout(new GridLayout(2,3));
	    
		// Setting the background color of the panel to dark-gray.
		gameField.setBackground(Color.DARK_GRAY);
		
		// Adding the gameField to the frame.
		add(gameField);
	}
	
	public void removeCardsFromGamefield(){
		gameField.removeAll();
	}
	
	public void addCardsToGamefield(){
		for (int i = 0; i < allCards.size(); i++) {
			gameField.add(allCards.get(i));
		}
	}
	
	public void startNewGame(){
		allCards = Card.generateCards(numberOfCards);
    	removeCardsFromGamefield();
    	addCardsToGamefield();
    	gameField.revalidate();
	}
	
} // End of MainFrame

