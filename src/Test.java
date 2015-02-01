import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import javax.swing.SwingUtilities;

public class Test {
//================================THIS IS A TEST! NOT OFFICIAL!==============================
	
	
	public static void main(String[] args) throws IOException {
	
//----------------------------- TEST INITIALISATION AND FILE USAGE -------------------------
		Deck myDeck = new Deck(6, "Images");		
		System.out.println("Initialisation & file test: ");
		for (CardV card : myDeck.getListOfAllCards()) {
			System.out.println( "B : " + card.getBack() + "F : " + card.getFront());
		}
		
		ArrayList<CardV> arr = myDeck.getListOfAllCards();

//-----------------------------------------REFERENCES---------------------------------------	
		System.out.println("References check: ");
		for (CardV key : myDeck.getHashMapCards().keySet()) {
			System.out.println("Key: " + key);
		}		
		for (CardV value : myDeck.getHashMapCards().values()) {
			System.out.println("Value: " + value);
		}		
		//
		for (int i = 0; i < arr.size(); i++) {
			for (int j = 1; j < arr.size(); j++) {
				System.out.println(arr.get(i) + " & " + arr.get(j) + ":\t" + 
			ifSameCard(myDeck, arr.get(i), arr.get(j)));
			}
			
		}
		startScreen();
		
		ArrayList testRands = randList(myDeck.getListOfAllCards());
		System.out.println("RANDOM TEST_01!!!");
		
		for (Object object : testRands) {
			System.out.println(object.toString());
		}
		
		System.out.println("RANDOM TEST_02!!!");
	}
	
//-----------------------------------------EQALITY-------------------------------------------
			
	public static boolean ifSameCard(Deck deck ,CardV f , CardV s){
		
		if (f == s) 
			return true;
		else
			return false;
	}
	
//-------------------------------------------------------------------------------------------
	
	public static void startScreen(){
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				// We instantiate a new game.
				new MainFrame();
			}
		});
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
	
}
