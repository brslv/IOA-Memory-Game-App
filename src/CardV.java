import javax.swing.ImageIcon;
import javax.swing.JButton;


@SuppressWarnings("serial")
public  class CardV extends JButton{
	
		private JButton cardButton;
		private ImageIcon frontImg;
		private ImageIcon backImg;
		
		public CardV(ImageIcon frontImg, ImageIcon backImg) {
			this.frontImg = frontImg;
			this.backImg = backImg;
		}
		
		public void setCardFrontImg(ImageIcon frontImg){
			this.frontImg = frontImg;
		}
		
		public void setCardBackImg(ImageIcon backImg){
			this.backImg = backImg;
		}
	}

