import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class Deck{

	private HashMap<CardV, CardV> cards;
	
	public Deck(int countOfCards, String imgFolderPath){			
		CardStyle cs = null;
		try {
			cs = new CardStyle(imgFolderPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		cards = new HashMap<CardV, CardV>();
		for (int i = 0; i < countOfCards/2; i++) {
			CardV temp = new CardV(cs.getNextFrontImage(), cs.getBackImage());
			cards.put(temp, temp);
		}		
	}

	public static <E> ArrayList<E> randList(ArrayList<E> arrList){
		HashSet<Integer> index = new HashSet<Integer>(); 
		ArrayList<E> result = new ArrayList<E>();
		for (int i = 0; i < arrList.size(); i++) {
			index.add(i);
		}
		while(true){
			int rand = (int)(Math.random()*100);
			
			if (index.remove(rand)){
				result.add(arrList.get(rand));
			}
			else if(index.size() == 0){
				break;
			}
			else {
				continue;
			}
		}
		return result;
	}
	
	public ArrayList<CardV> getListOfAllCards(){
		ArrayList<CardV> result = new ArrayList<CardV>();
		result.addAll(cards.values());
		result.addAll(cards.keySet());
		return randList(result);
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
