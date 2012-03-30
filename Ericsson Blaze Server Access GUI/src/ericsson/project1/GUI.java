package ericsson.project1;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;




@SuppressWarnings("serial")

public class GUI extends JFrame implements ActionListener, KeyListener {
	
	private	JButton HC 					= 				new JButton("Host Check");
	private JButton MC 					= 				new JButton("Motorola Check");
	private JButton SC 					= 				new JButton("Samsung Check");
	private JMenuItem saveOutputVar 	= 				new JMenuItem("Save Output");
	private JMenuItem serverLoginVar 	= 				new JMenuItem("Server Login");
	private JMenuItem exitVar 			= 				new JMenuItem("Close");
	private JMenuItem aboutVar 			= 				new JMenuItem("About");
	private JPanel masterOne 			= 				new JPanel();
	private JTextArea mainOut 			= 				new JTextArea(20,50);
	private JTextField inputSite 		= 				new JTextField(20);
	private JTextField siteNameField	= 				new JTextField(20);
	
//setters and getter	
	
	public String getMainOut() {
		return mainOut.getText();
	}
	public void setMainOut(String newText) {
		mainOut.setText(newText);
	}	
	
//Constructor	
	
	public  GUI(String TitleName){ 
		
			masterOne.add(HC);
			masterOne.add(MC);
			masterOne.add(SC);
			masterOne.setBackground(Color.DARK_GRAY);
		
		add(masterOne,BorderLayout.SOUTH);
		
		//adding action listeners
		
		exitVar.addActionListener(this);
		aboutVar.addActionListener(this);
		serverLoginVar.addActionListener(this);
		saveOutputVar.addActionListener(this);
		HC.addActionListener(this);
		MC.addActionListener(this);
		SC.addActionListener(this);
		
		
		siteNameField.addKeyListener(this);
		
		//Setting windows defaults
		
		setTitle(TitleName);
		setResizable(false);
		setSize (new Dimension(800,700));
		setBackground(Color.WHITE);
		
		 
		JPanel PanelLables = new JPanel();
		
		JLabel LabelSiteStatus = new JLabel("Site Status:");
		JLabel LabelTwo = new JLabel("Site Name:");
		
		mainOut.setBackground(Color.lightGray);
		mainOut.setText("<This is the output panel, please login to the server>");
		
		
		
		
		PanelLables.add(LabelSiteStatus);
		PanelLables.add(inputSite);
		PanelLables.add(LabelTwo);
		PanelLables.add(siteNameField);
		PanelLables.add(mainOut, BorderLayout.SOUTH);
		
		
		

		add(PanelLables,BorderLayout.CENTER);
	
		
		
		inputSite.setEnabled(false);
		
	}
	public void Menu(){ 
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuFile = 	new JMenu("File");
		JMenu menuHelp = 	new JMenu("Help");
	
		
		
		
		
		//Adding the menu items to the "File" menu file
		menuFile.add(serverLoginVar);
		menuFile.add(saveOutputVar);
		menuFile.add(exitVar);
		
		//Adding the menu items to the "Help" menu file
		
		menuHelp.add(aboutVar);
		
		
		
		menuBar.add(menuFile);
		menuBar.add(menuHelp);
		
		menuBar.setBackground(Color.lightGray);
		menuBar.setVisible(true);
		
		
		add(menuBar, BorderLayout.NORTH);
		}
	@SuppressWarnings("static-access")
	
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == exitVar){
			System.exit(0);
		}
		
		else if (e.getSource() == serverLoginVar) {
			
			 new ServerLoginGUI(this);	
		
		} 
		
		else if (e.getSource() == aboutVar){
			
			JOptionPane Aboutme = new JOptionPane();
			Aboutme.showMessageDialog(null, "Program version 1.0  Created " + 
					"by: Mr.Jerum Hubbert for Clearwire / Ericsson", "About Menu", JOptionPane.PLAIN_MESSAGE);
		}
		
		else if (e.getSource() == MC){
			
			if(siteNameField.getText().isEmpty()){mainOut.setText("Error: please provide a vaild site in site field.\n"); }
				else {mainOut.setText("This is where the Output for: " + siteNameField.getText() + " Current Stats of \"Moto Check\" would go here.");}
			
		}
		
		else if (e.getSource() == SC){
			
			if(siteNameField.getText().isEmpty()){mainOut.setText("Error: please provide a vaild site in site field.\n"); }
				else{mainOut.setText("This is where the Output for: " + siteNameField.getText() + " Current Stats of \"Samsung Check\" would go here.");}
		}
		
		else if (e.getSource() == HC){
			
			if(siteNameField.getText().isEmpty()){mainOut.setText("Error: please provide a vaild site in site field.\n"); }
				else {mainOut.setText("This is where the Output for: " + siteNameField.getText() + " Current Stats of \"Host Check\" would go here.");}
		}
					
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void keyPressed(KeyEvent e) {
		
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_ENTER){
			
							if(siteNameField.getText().isEmpty()){mainOut.setText("Error: please provide a vaild site in site field.\n"); }
								else {JOptionPane errorOut = new JOptionPane();
											errorOut.showMessageDialog(null, "Error: please provide select a button!", "Error 1", JOptionPane.PLAIN_MESSAGE);}
			}
	}
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
}
