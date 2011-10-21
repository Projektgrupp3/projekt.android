package tddd36.grupp3;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class androidActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d("Fel1","HŠr blev det fel");
    }
}