import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public  class CardV extends JButton implements ActionListener{	//Initialized in the Deck's constructor
	// Nothing special here. Just getters and setters. Part of OOP. 
	//You aren't supposed to know this for your next exam :D
		private static int serialNum = 1;
		private int id = serialNum;
		private ImageIcon frontImg;
		private ImageIcon backImg;
		private ImageIcon currentImg;

		public CardV(ImageIcon frontImg, ImageIcon backImg) {
			super(backImg);
			this.frontImg = frontImg;
			this.backImg = backImg;
			this.currentImg = backImg;
			this.id = serialNum;
			this.addActionListener(this);
			serialNum++;
		}
		
		public void changeImage(){
			this.setCurrentImg(this.getFront());
		}
		
		public void actionPerformed(ActionEvent e){
			this.setIcon(frontImg);
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
	}

