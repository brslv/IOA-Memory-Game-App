import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
	
//----------------------------- TEST INITIALISATION AND FILE USAGE -------------------------
		Deck myDeck = new Deck(10, "C:\\Users\\Victoria\\Desktop\\Images");		
		
		for (CardV cardV : myDeck.getListOfAllCards()) {
			
			System.out.println("Front:" + cardV.getFront().toString()+ "\tBack:" 
			+ cardV.getBack().toString());	
		}	
//------------------------------------------------------------------------------------------
	}
}
