package tddd36.grupp3;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class chooseUnit extends Activity implements OnItemSelectedListener {
	
	Spinner spinner;
	String[] units = {"MUSIC","DOWNLOADS","PICTURES"};
	File path = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, units);
		spinner = (Spinner) findViewById(R.id.spinner1);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
	}

	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		int position = spinner.getSelectedItemPosition();
		
		switch(position){
		case 0:
			path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
			break;
		case 1:
			path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
			break;
		case 2:
			path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
			break;
		}
	}

	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

}
