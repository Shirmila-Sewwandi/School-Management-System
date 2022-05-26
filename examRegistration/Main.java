package examRegistration;

import javax.swing.JFrame;

public class Main  {
	
	JFrame Frame = new JFrame();
	
	public static void main(String[] args) {		
		UserLogin frame = new UserLogin();
		
	}

	public JFrame getFrame() {
		return Frame;
	}

	public void setFrame(JFrame frame) {
		Frame = frame;
	}
	
	

}
