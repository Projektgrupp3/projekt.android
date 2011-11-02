package tddd36.grupp3;

import tddd36.grupp3.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
				display.setText("Loggar in...");
				if (user.getText().length() == 0||pass.getText().length() == 0) {
					display.setText("Du måste fylla i uppgifterna");
				}
				else{
					display.setText("Loggar in...");
					Intent openMenu = new Intent("tddd36.grupp3.MENU");
					startActivity(openMenu);



				}



			};
			
		});
		




	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
		
	}
}