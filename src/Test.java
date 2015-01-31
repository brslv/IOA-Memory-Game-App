import java.io.IOException;
import java.util.ArrayList;

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
	}
	
//-----------------------------------------EQALITY-------------------------------------------
			
	public static boolean ifSameCard(Deck deck ,CardV f , CardV s){
		
		if (f == s) 
			return true;
		else
			return false;
	}
}
