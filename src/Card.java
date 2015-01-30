import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Card extends JButton{

	/**
	 * Declaring the new JButton object.
	 * Basically, it is our card.
	 */
	private JButton cardButton;
	
	/**
	 * Constructor.
	 * Creates a new card and sets it name.
	 * @param title
	 */
	public Card(String title){
		// Sets the title of the new card.
		super(title);
	}
	
	/**
	 * This method generates a list of Card objects and returns it.
	 * @param cardsNumber
	 * @return ArrayList<Card>
	 */
	public static ArrayList<Card> generateCards(int cardsNumber){
		// A list, containing all the cards for a game.
		ArrayList<Card> cardsList = new ArrayList<>();
		
		// A list, containing all card titles.
		ArrayList<String> cardsTitles = new ArrayList<String>(){{
			add("Hi");
			add("Hi");
			add("Hello");
			add("Hello");
			add("Beer"); 
			add("Beer");
		}};
		
		// A list, containing all the used indexes (used card titles).
		// This list is used to prevent repeating card Titles.
		ArrayList<Integer> usedIndexes = new ArrayList<Integer>();
		
		// The randomIndex is used to take a random card title.
		Random randomIndex = new Random();
		
		
		for (int i = 0; i < cardsNumber; i++) {
			int randIndex = randomIndex.nextInt(cardsTitles.size());
			
			// Here we check if a card index is used.
			// If so => add it to the usedIndexes list.
			// If not, create a card with this title and add it to the list.
			if(i == 0){
				usedIndexes.add(randIndex);
			}else{
				if(usedIndexes.contains(randIndex)){
					i--;
					continue;
				}else{
					usedIndexes.add(randIndex);
				}
			}
			
			String cardText = cardsTitles.get(randIndex);
			
			// Add the new card to the list.
			cardsList.add(new Card(cardText));
		}
		
		// Return the list.
		return cardsList;
	}
	
}
