package tddd36.grupp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class androidActivity extends Activity {
	private static final String COM_IP = "130.236.226.217";
	private static final int COM_PORT = 4444;
	private Socket client;
	private InputStreamReader isr;
	private PrintWriter pw;
	private BufferedReader br;
	private TextView display;
	private EditText user;
	private EditText pass;
	private String serverOutput;
	private Button login;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		pass = (EditText) findViewById(R.id.editText2);
		user = (EditText) findViewById(R.id.editText1);
		login = (Button) findViewById(R.id.button1);
		display = (TextView)findViewById(R.id.textView3);

		login.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				try {
					login();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			};
		});
	}

	public void login() throws UnknownHostException, IOException {
		//Connecting client with server
		client = new Socket(COM_IP,COM_PORT);
		//Setting up streams
		isr = new InputStreamReader(client.getInputStream());
		pw = new PrintWriter(client.getOutputStream(),true);
		br = new BufferedReader(isr);
		//Sending username and password to server
		pw.println(user.getText());
		pw.println(pass.getText());
		//Checking if username & password is authenticated to login
		if((serverOutput = br.readLine()) != ""){
			if(!serverOutput.equals("Authenticated")) {
				AlertDialog login = new AlertDialog.Builder(androidActivity.this).create();
				login.setMessage("Felaktigt anv�ndarnamn eller l�senord");
				login.setButton("OK", new DialogInterface.OnClickListener(){
					public void onClick(DialogInterface dialog, int which) { 	
					}
				});
				pass.setText("");
				login.show();
			}
			else{
				//If authenticated user travels to choosUnit
				Intent chooseUnit = new Intent("tddd36.grupp3.CHOOSEUNIT");
				startActivity(chooseUnit);
			}
		}
	}

	@Override
	protected void onPause() {
		//finish login activity when traveling to mainmenu
		super.onPause();
		finish();
	}
}
