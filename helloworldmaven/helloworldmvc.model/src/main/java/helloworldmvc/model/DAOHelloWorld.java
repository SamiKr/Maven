package helloworldmvc.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;



	class DAOHelloWorld {
	private String FileName = "HelloWorld.txt";
	private String helloWorldMessage = null;
	private static DAOHelloWorld instance= null;
	

private DAOHelloWorld() {
	this.readFile();
}

public static synchronized DAOHelloWorld getInstance() {
	if(instance == null) {
		setInstance(new DAOHelloWorld());
		
	}
	return instance ;
}
private static void setInstance (final DAOHelloWorld instance) {
	DAOHelloWorld.instance = instance;
	
}

private void readFile() {
	BufferedReader buffer;
	try {
		buffer = new BufferedReader(new InputStreamReader(new FileInputStream(FileName)));
		this.setHelloWorldMessage(buffer.readLine());
		buffer.close();
	}catch (final FileNotFoundException exception) {
		exception.printStackTrace();
	}catch(final IOException exception) {
		exception.printStackTrace();
	}
	}

public String getHelloWorldMessage() {
	return this.helloWorldMessage;
}

public void setHelloWorldMessage(final String helloWorldMessage) {
	this.helloWorldMessage = helloWorldMessage;
}

}




