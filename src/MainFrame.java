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
import javax.swing.JMenu;
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
	
	private static int clickCounter = 1;
	public int gridLayoutRows = 3;
	public int gridLayoutCols = 4;
	public final int APP_WIDTH = gridLayoutRows * 180;
	public final int APP_HEIGHT = gridLayoutCols * 150;	
	public int numberOfCards = gridLayoutRows * gridLayoutCols;
	private Deck deck = new Deck(numberOfCards, "Images");
	
	
	
	ArrayList<CardV> allCards;
	
	
	
	public MainFrame(){
		super("The IOA Memory Game App, version 'too-alpha-to-be-cool'.");
		this.setSize(APP_WIDTH, APP_HEIGHT);
		this.setLayout(new BorderLayout());
		this.setVisible(true); 
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		setLocationRelativeTo(null);
		
		Toolbar();
		addGamefield();
		startNewGame();
	} // End of MainFrame()
	
	
	
	private void Toolbar() {
		JMenuBar menubar = new JMenuBar();
		menubar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menubar.setBackground(Color.WHITE);
		
		// Start a new game button
		JMenuItem eStart = new JMenuItem("New Game");
		eStart.setBackground(Color.WHITE);
		eStart.setMnemonic(KeyEvent.VK_N);			
		eStart.setToolTipText("Start new game.");
		eStart.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent event) {
	        	startNewGame();
	        }
	    });
		
		// Set difficulty button
		JMenu eDifficulty = new JMenu("Difficulty");
		eDifficulty.add("Easy").addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				startNewGame();
			}
			
		});
		eDifficulty.add("Medium").addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				startNewGame();
			}
			
		});;
		eDifficulty.add("Hard").addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				startNewGame();
			}
			
		});;
		eDifficulty.setBackground(Color.WHITE);
		eDifficulty.setToolTipText("Pick difficulty");
		eDifficulty.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("Clicked diff.");
			}
		});
		
		// Exit button
		JMenuItem eExit = new JMenuItem("Exit");
		eExit.setBackground(Color.WHITE);
		eExit.setMnemonic(KeyEvent.VK_E);
		eExit.setToolTipText("Exit application");
		eExit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        System.exit(0);
		    }
		});
		
		// Adding all the buttons to the menubar
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
		
		statsField = new JPanel();
		statsField.add(statsLabel);
		
		add(statsField,BorderLayout.SOUTH);	
		add(gameField);
	}
	
	
	
	public void removeCardsFromGamefield(){
		gameField.removeAll();
	}
	
	
	
	public void addCardsToGamefield(){
		for (int i = 0; i < allCards.size(); i++) {
			CardV card = new CardV(allCards.get(i).getFront(), allCards.get(i).getBack());
			
			card.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					if(clickCounter <= 2){
						// Setting the currentImage on the card to be it's front image.
						card.setCurrentImg(card.getFront());
						card.setIcon(card.getCurrentImg());
						
						// Adding the card to the clickedCards static list.
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
						
						// Reset the counter.
						clickCounter = 2;
							
						// Flip the mismatched cards
						for (int j = 0; j < Deck.clickedCards.size(); j++) {
							ImageIcon backOfTheCard = card.getBack();
							Deck.clickedCards.get(j).setCurrentImg(backOfTheCard);
							Deck.clickedCards.get(j).setIcon(card.getCurrentImg());
							
						}
						
						// Set the newly clicked card it's front image.
						card.setIcon(card.getFront());
						
						// Clear the clickedCards list, because we don't need the previously
						// clicked cards anymore.
						Deck.clickedCards.clear();
						
						// Add the newly clicked card to the array list and wait for the next click.
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
		// Reseting all the information on the previous game, if any.
		Deck.clickedCards.clear();
		Deck.disabledCardsCounter = 0;
		clickCounter = 1;
		score = 0;
		statsLabel.setText(score +"");
		
		// Generating a new deck and putting it on it's place.
		allCards = deck.getListOfAllCards();
    	removeCardsFromGamefield();
    	addCardsToGamefield();
    	gameField.revalidate(); 
	}
	
	
	
} // End of MainFrame

