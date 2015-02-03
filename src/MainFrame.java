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
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	int score;
	private Timer timer;
	
	private JPanel gameField;
	private JPanel statsField;
	private JLabel statsLabel = new JLabel("");
	
	private static int clickCounter = 1;
	public int gridLayoutRows;
	public int gridLayoutCols;
	public int appWidth;
	public int appHeight;	
	public int numberOfCards;
	private Deck deck;
	private String imgFolderPath;
	
	
	
	ArrayList<CardV> allCards;
	
	
	
	public MainFrame(int rows, int cols, Deck deckArg){
		super("The IOA Memory Game App, v.1056107");
		
		//Game specifics
		this.gridLayoutRows = rows;
		this.gridLayoutCols = cols;
		this.appWidth = gridLayoutRows * 180;
		this.appHeight = gridLayoutCols * 150;	
		this.numberOfCards = gridLayoutRows * gridLayoutCols;
		this.deck = deckArg;
		
		this.imgFolderPath = deck.getImgFolder();
		
		this.setSize(appWidth, appHeight);
		this.setLayout(new BorderLayout());
		this.setVisible(true); 
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		setLocationRelativeTo(null);
		
		Toolbar();
		addGamefield();
	} // End of MainFrame()
	
	
	
	private void Toolbar() {
		JMenuBar menubar = new JMenuBar();
		menubar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menubar.setBackground(Color.WHITE);
		
		addToolbarButtons(menubar);
		
		setJMenuBar(menubar);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	private void addToolbarButtons(JMenuBar menubar){
		// Start a new game button
		JMenu gameBtn = new JMenu("Game");
		gameBtn.add("New Game").addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
	        	startNewGame();
	        }
		});
		gameBtn.add("Choose theme").addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
		        String[] tempArray = {"", ""};
		    	App.main(tempArray);
		    	dispose();
		    }
		});
		gameBtn.setBackground(Color.WHITE);
		gameBtn.setMnemonic(KeyEvent.VK_N);		
		
		// Set difficulty button
		JMenu diffBtn = new JMenu("Difficulty");
		diffBtn.add("Easy").addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				CardStyle.index = -1;
				dispose();
				new MainFrame(2,3,new Deck(2 * 3, imgFolderPath)).startNewGame();
			}		
		});
		diffBtn.add("Medium").addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				CardStyle.index = -1;
				dispose();
				new MainFrame(3, 4, new Deck(3 * 4, imgFolderPath)).startNewGame();
			}	
		});
		diffBtn.add("Hard").addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				CardStyle.index = -1;
				dispose();
				new MainFrame(4, 5, new Deck(4 * 5, imgFolderPath)).startNewGame();
			}		
		});
		diffBtn.setBackground(Color.WHITE);
		diffBtn.setToolTipText("Pick difficulty");
		diffBtn.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("Clicked diff.");
			}
		});
		
		// Exit button
		JMenuItem exitBtn = new JMenuItem("Exit");
		exitBtn.setBackground(Color.WHITE);
		exitBtn.setMnemonic(KeyEvent.VK_E);
		exitBtn.setToolTipText("Exit application");
		exitBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        System.exit(0);
		    }
		});
		
		// Adding all the buttons to the menubar
		menubar.add(gameBtn);
		menubar.add(diffBtn);
		menubar.add(exitBtn);
	}
	
	
	
	private void addGamefield(){
		gameField = new JPanel();
		gameField.setBorder(new EmptyBorder(5, 5, 5, 5) );
		gameField.setSize(appWidth, appHeight);
		add(gameField, BorderLayout.CENTER);
		gameField.setLayout(new GridLayout(gridLayoutRows,gridLayoutCols, 5, 5));
		gameField.setBackground(Color.LIGHT_GRAY);	
		
		statsField = new JPanel();
		statsField.add(statsLabel);
		
		add(statsField,BorderLayout.SOUTH);	
		add(gameField);
	}
	
	
	
	private void removeCardsFromGamefield(){
		gameField.removeAll();
	}
	
	
	
	// Magic, don't touch!
	private void addCardsToGamefield(){
		for (int i = 0; i < allCards.size(); i++) {
			CardV card = new CardV(allCards.get(i).getFront(), allCards.get(i).getBack());
			card.setBackground(Color.WHITE);
			
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
								}
							}else{
								if(clickCounter == 2) score++;
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
					}
					statsLabel.setText("Mismatched: " + score+"");
				}
			});
			
			gameField.add(card);
		}
	}
	
	
	
	protected void startNewGame(){
		// Reseting all the information on the previous game, if any.
		Deck.clickedCards.clear();
		Deck.disabledCardsCounter = 0;
		clickCounter = 1;
		score = 0;
		statsLabel.setText("Mismatched: " + score +"");
		
		// Generating a new deck and putting it on it's place.
		allCards = deck.getListOfAllCards();
    	removeCardsFromGamefield();
    	addCardsToGamefield();
    	gameField.revalidate(); 
	}
	
	
	
} // End of MainFrame

