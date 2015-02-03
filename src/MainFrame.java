import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	int score;
	private Timer timer;
	
	private JPanel gameField;
	private JPanel statsField;
	private JLabel statsLabel = new JLabel(score + "");
	
	public int gridLayoutRows = 3;
	public int gridLayoutCols = 4;
	public final int APP_WIDTH = gridLayoutRows * 180;
	public final int APP_HEIGHT = gridLayoutCols * 150;	
	public int numberOfCards = gridLayoutRows * gridLayoutCols;
	private Deck deck = new Deck(numberOfCards, "Images");
	
	ArrayList<CardV> allCards = deck.getListOfAllCards();
	
	private static int clickCounter = 1;
	
	
	
	public MainFrame(){
		super("The IOA Memory Game App, version 'too-alpha-to-be-cool'.");
		this.setSize(APP_WIDTH, APP_HEIGHT);
		this.setLayout(new BorderLayout());
		this.setVisible(true); 
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		Toolbar();
		addGamefield();
		startNewGame();
		
		
		statsField = new JPanel();
		statsField.add(statsLabel);
		add(statsField,BorderLayout.SOUTH);
	} // End of MainFrame()
	
	
	
	private void Toolbar() {
		JMenuBar menubar = new JMenuBar();
		menubar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menubar.setBackground(Color.WHITE);
		
		JMenuItem eStart = new JMenuItem("New Game");
		eStart.setBackground(Color.WHITE);
		eStart.setMnemonic(KeyEvent.VK_N);			
		eStart.setToolTipText("Start new game.");
		eStart.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent event) {
	        	startNewGame();
	        	timer = new Timer(0, null);
	        	timer.start();
	        }
	    });
		
		JMenuItem eDifficulty = new JMenuItem("Difficulty");
		eDifficulty.setBackground(Color.WHITE);
		eDifficulty.setToolTipText("Pick difficulty");
		eDifficulty.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
			}
		});
		
		JMenuItem eExit = new JMenuItem("Exit");
		eExit.setBackground(Color.WHITE);
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
		gameField.setSize(APP_WIDTH, APP_HEIGHT);
		add(gameField, BorderLayout.CENTER);
		gameField.setLayout(new GridLayout(gridLayoutRows,gridLayoutCols));
		gameField.setBackground(Color.DARK_GRAY);		
		add(gameField);
	}
	
	
	
	public void removeCardsFromGamefield(){
		gameField.removeAll();
	}
	
	// pure magic!
	
	public void addCardsToGamefield(){
		for (int i = 0; i < allCards.size(); i++) {
			CardV card = new CardV(allCards.get(i).getFront(), allCards.get(i).getBack());
			
			card.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					if(clickCounter <= 2){
						card.setCurrentImg(card.getFront());
						card.setIcon(card.getCurrentImg());
						Deck.clickedCards.add(card);
						
						if(clickCounter == 2){
							if(card.getFront() == Deck.clickedCards.get(0).getFront()){
								if(card != Deck.clickedCards.get(0)){
									card.setEnabled(false);
									Deck.clickedCards.get(0).setEnabled(false);
									Deck.disabledCardsCounter += 2;
									card.setIcon(card.getBack());
									Deck.clickedCards.get(0).setIcon(Deck.clickedCards.get(0).getBack());
									score++;
								}
							}
						}
						clickCounter++;
					}else{
						clickCounter = 2;
							
						// Flips the mismatched cards
						for (int j = 0; j < Deck.clickedCards.size(); j++) {
							ImageIcon backOfTheCard = card.getBack();
							Deck.clickedCards.get(j).setCurrentImg(backOfTheCard);
							Deck.clickedCards.get(j).setIcon(card.getCurrentImg());
							
						}
						
						card.setIcon(card.getFront());
						Deck.clickedCards.clear();
						Deck.clickedCards.add(card);
						score--;
					}
					statsLabel.setText(score+"");
				}
			});
			
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

