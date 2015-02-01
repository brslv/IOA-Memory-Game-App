import javax.swing.ImageIcon;

public  class CardV{	//Initialized in the Deck's constructor
	// Nothing special here. Just getters and setters. Part of OOP. 
	//You aren't supposed to know this for your next exam :D
		private static int serialNum = 1;
		private int id = serialNum;
		private ImageIcon frontImg;
		private ImageIcon backImg;
		
		public CardV(ImageIcon frontImg, ImageIcon backImg) {
			this.frontImg = frontImg;
			this.backImg = backImg;
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
	}

