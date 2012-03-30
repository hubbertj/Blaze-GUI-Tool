package ericsson.project1;

import javax.swing.JFrame;


public class MainRun {
	
	public static void main (String args[]){
		GUI Gu = new GUI("Blaze Server-Graphical User Interface(GUI)");
		
		Gu.Menu();
		Gu.setVisible(true);
		Gu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Opening a server connection.
		
	}

}
