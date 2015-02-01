import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Deck{

	private HashMap<CardV, CardV> cards;
	
	public Deck(int countOfCards, String imgFolderPath) throws IOException {			
		CardStyle cs = new CardStyle(imgFolderPath);			
		cards = new HashMap<CardV, CardV>();
		for (int i = 0; i < countOfCards/2; i++) {
			CardV temp = new CardV(cs.getNextFrontImage(), cs.getBackImage());
			cards.put(temp, temp);
		}		
	}

	public ArrayList<CardV> getListOfAllCards(){
		ArrayList<CardV> result = new ArrayList<CardV>();
		result.addAll(cards.values());
		result.addAll(cards.keySet());
		return result;
	}
	
	public HashMap<CardV, CardV> getHashMapCards(){
		return this.cards;
	}
	
	// if we have same references 
	public boolean compareCards(CardV first, CardV second){
		if(first == second)
			return true;
		else
			return false;
	}
	
	// if we have to change the logic and have different references
//	public boolean compareCards(CardV first, CardV second){
//		if(first.getFront().toString().equals(second.getFront().toString()))
//			return true;
//		else
//			return false;
//	}
	
	
}
