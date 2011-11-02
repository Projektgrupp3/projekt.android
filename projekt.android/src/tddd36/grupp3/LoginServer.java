package tddd36.grupp3;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
	public static void main(String[] args){
		System.out.println("<Server>: Session loaded");
		try{
			ServerSocket s = new ServerSocket(4443);
			while(true){
				Socket client = s.accept();
				System.out.println("<Server>: Connection with client estabished");
				PrintWriter out = new PrintWriter(client.getOutputStream(),true);
				out.println(new java.util.Date().toString());
				client.close();
			}
		
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

}

