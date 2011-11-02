package tddd36.grupp3;

import tddd36.grupp3.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class androidActivity extends Activity {
	

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		Button login;
		final TextView display;
		final EditText user;
		final EditText pass;
		pass = (EditText) findViewById(R.id.editText2);
		user = (EditText) findViewById(R.id.editText1);
		login = (Button) findViewById(R.id.button1);
		display = (TextView)findViewById(R.id.textView3);

		login.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
			
				// TODO Auto-generated method stub
				if (user.getText().length() == 0||pass.getText().length() == 0) {
					AlertDialog login = new AlertDialog.Builder(androidActivity.this).create();
					
					login.setMessage("Felaktigt användarnamn eller lösenord");
					login.setButton("OK", new DialogInterface.OnClickListener(){
						public void onClick(DialogInterface dialog, int which) { 	
						}
					});
					login.show();
					
				}
				else{
					display.setText("Loggar in...");
						
					/*Intent myIntent = new Intent(v.getContext(), activity2.class);
		                startActivityForResult(myIntent, 0); */ //Hoppar till provisorisk sida
				}
				
				
			};
		});
	}
}