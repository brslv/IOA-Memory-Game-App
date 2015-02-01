import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class CardListener extends JButton implements ActionListener{

	private boolean isClicked;
	private static ArrayList<CardListener> cardListenersList;

	
	public CardListener(ImageIcon icon){
		super(icon);
			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
	}
	
	public boolean getIsClicked(){
		return this.isClicked;
	}
		
	
	public static void openCard(CardListener cardListener){
		
		if(cardListenersList == null){
			cardListenersList = new ArrayList<CardListener>();
		}
		
		 if (cardListener.getIsClicked() && cardListenersList.size()==2) {
		// setting back img for current img (foreach) before to remove elements	
			 cardListener.removeAll();
		
			cardListener.add(cardListener);
		// setting front img for curr img 
		}
		else if (cardListener.getIsClicked() && cardListenersList.size() < 2 ){
			cardListener.add(cardListener);
		}
		 
		 //----------...............-------------------..............
	}
	
}
