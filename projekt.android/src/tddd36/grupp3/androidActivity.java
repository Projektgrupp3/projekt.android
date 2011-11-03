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
	private static final String COM_IP = "130.236.226.95";
	private static final int COM_PORT = 4444;
	Socket client;
	InputStreamReader isr;
	PrintWriter pw;
	BufferedReader br;
	TextView display;
	EditText user;
	EditText pass;
	String serverOutput;
	Button login;

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
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
		});
	}

	public void login() throws UnknownHostException, IOException {

		client = new Socket(COM_IP,COM_PORT);
		isr = new InputStreamReader(client.getInputStream());
		pw = new PrintWriter(client.getOutputStream(),true);
		br = new BufferedReader(isr);

		pw.println(user.getText());
		pw.println(pass.getText());

		if((serverOutput = br.readLine()) != ""){
			if(!serverOutput.equals("Authenticated")) {
				AlertDialog login = new AlertDialog.Builder(androidActivity.this).create();
				login.setMessage("Felaktigt användarnamn eller lösenord");
				login.setButton("OK", new DialogInterface.OnClickListener(){
					public void onClick(DialogInterface dialog, int which) { 	
					}
				});
				pass.setText("");
				login.show();
			}
			else{

				Intent openMenu = new Intent("tddd36.grupp3.MENU");
				startActivity(openMenu);
			}
		}

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
