package ericsson.project1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class ServerLoginGUI extends JFrame implements ActionListener, KeyListener {
	
	private JTextField serverIP 				= new JTextField(15);
	private JPasswordField serverPassword 		= new JPasswordField(15);
	private JPanel serverLoginPanel				= new JPanel();
	private JButton loginButton					= new JButton("Login");
	private JLabel serverIPLabel 				= new JLabel("Server Address:");
	private JLabel serverPasswordLabel			= new JLabel("Password      :");
			JTextArea Area;
			GUI GUi;
	
	
	public ServerLoginGUI(GUI GU){
		
		this.GUi = GU; // this assigns the class object to the local object ex. X = 5;
		
		serverLoginPanel.add(serverIPLabel,BorderLayout.CENTER);
		serverLoginPanel.add(serverIP,BorderLayout.CENTER);
		serverLoginPanel.add(serverPasswordLabel,BorderLayout.SOUTH);
		serverLoginPanel.add(serverPassword,BorderLayout.SOUTH);
		
		add(serverLoginPanel, BorderLayout.CENTER);
		add(loginButton, BorderLayout.SOUTH);
		
		loginButton.addActionListener(this);
		
		serverIP.addKeyListener(this);
		serverPassword .addKeyListener(this);
		
		
		setTitle("Server Login");
		setSize (new Dimension(370,130));
		setBackground(Color.lightGray);
		setResizable(false);
		setVisible(true);
		
	}
	
	
	// setters and getters
	public JTextArea getArea() {
		return Area;
	}
	public String getServerIPText() {
		return serverIP.getText();
	}
	public void setServerIPText(String serverIPText) {
		this.serverIP.setText(serverIPText);
	}
	public void setArea(JTextArea area) {
		Area = area;
	}
	
	
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == loginButton){
			if (serverIP.getText().isEmpty() ||  serverPassword.getText().isEmpty()){
				} //do nothing
			
			else {
				ServerAccess SA = new ServerAccess(this);
					SA.Connect(GUi);
					dispose();}
		}
	}
	@SuppressWarnings("deprecation")
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_ENTER){
			if (serverIP.getText().isEmpty() ||  serverPassword.getText().isEmpty()){
			} //do nothing if there are no entries in the Username or Password fields.
		
		else {
			ServerAccess SA = new ServerAccess(this);
				SA.Connect(GUi);
				dispose();}
		}
		
		
	}
	public void keyReleased(KeyEvent e) {}

	public void keyTyped(KeyEvent e) {}
}
