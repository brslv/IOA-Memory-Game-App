import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public  class CardV extends JButton{	//Initialized in the Deck's constructor
	// Nothing special here. Just getters and setters. Part of OOP. 
	//You aren't supposed to know this for your next exam :D
		private static int serialNum = 1;
		private int id = serialNum;
		private ImageIcon frontImg;
		private ImageIcon backImg;
		private ImageIcon currentImg;
		private boolean isAlive = true;

		private static int counter = 0;
		private static ArrayList<CardV> clickedCards = new ArrayList<CardV>();
		private static ArrayList<CardV> matchedCards = new ArrayList<CardV>();
		
		public CardV(ImageIcon frontImg, ImageIcon backImg) {
			super(backImg);
			this.frontImg = frontImg;
			this.backImg = backImg;
			this.currentImg = backImg;
			this.id = serialNum;
			serialNum++;
		}
		
		public void setCardFrontImg(ImageIcon frontImg){
			this.frontImg = frontImg;
		}
		
		public void setCardBackImg(ImageIcon backImg){
			this.backImg = backImg;
		}
		
		public ImageIcon getFront(){
			return frontImg;
		}

		public ImageIcon getBack() {
			return backImg;
		}
		
		@Override
			public String toString() {				
				return ("ID: " + id);
			}
		public ImageIcon getCurrentImg() {
			return currentImg;
		}

		public void setCurrentImg(ImageIcon currentImg) {
			this.currentImg = currentImg;
		}
		
		public boolean isAlive() {
			return isAlive;
		}

		public void setAlive(boolean isAlive) {
			this.isAlive = isAlive;
		}
		
	}

