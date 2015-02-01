import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	
	private Deck deck = new Deck(6, "Images");
	private JPanel gameField;
	
	public final int APP_WIDTH = 500;
	public final int APP_HEIGHT = 500;
	public int gridLayoutRows = 2;
	public int gridLayoutCols = 3;
	public int numberOfCards = gridLayoutRows * gridLayoutCols;
	
	ArrayList<CardV> allCards = deck.getListOfAllCards();
	
	public MainFrame(){
		super("The IOA Memory Game App, version 'too-alpha-to-be-cool'.");
		this.setSize(APP_WIDTH, APP_HEIGHT);
		this.setLayout(new BorderLayout());
		this.setVisible(true); 
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		MainMenu();
		addGamefield();
	} // End of MainFrame()
	
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
	
	public void addGamefield(){
		gameField = new JPanel();
		gameField.setSize(500, 500);
		add(gameField, BorderLayout.CENTER);
		gameField.setLayout(new GridLayout(2,3));
		gameField.setBackground(Color.DARK_GRAY);
		
		add(gameField);
	}
	
	public void removeCardsFromGamefield(){
		gameField.removeAll();
	}
	
	public void addCardsToGamefield(){
		for (int i = 0; i < allCards.size(); i++) {
			ImageIcon icon = allCards.get(i).getFront();
			CardListener card = new CardListener(icon);
			gameField.add(card);
		}
	}
	
	public void startNewGame(){
		allCards = deck.getListOfAllCards();
    	removeCardsFromGamefield();
    	addCardsToGamefield();
    	gameField.revalidate(); 
	}
	
} // End of MainFrame

