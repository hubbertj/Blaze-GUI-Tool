package ericsson.project1;

//import java.io.IOException;



public class ServerAccess {
	
	ServerLoginGUI GU;
	
	public ServerAccess(ServerLoginGUI GUI) {
		this.GU = GUI; // this assigns the class object to the local object ex. X = 5;
	}

	

	public ServerLoginGUI getGU() {
		return GU;
	}

	public void setGU(ServerLoginGUI gU) {
		GU = gU;
	}
	
// this code will be used to connect to the server using ServerSocket.
		
	
	public void Connect(GUI LoginIn){
		
		
		LoginIn.setMainOut("Login into " + 
				GU.getServerIPText() + " please wait. . . . .");
		
		
	}
	

	
	
	
	
	
	
	
}
