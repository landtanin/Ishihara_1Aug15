package appewtc.masterung.ishihara;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ShowScoreActivity extends AppCompatActivity {

    //Explicit
    TextView showTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);

        //Bind Widget
        bindWidget();

        //Show Score
        showScore();

    }   // Main Method

    public void play(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void exit(View view) {
        finish();
    }



    private void showScore() {

        int intMyScore = getIntent().getIntExtra("Score", 0);
        showTextView.setText(Integer.toString(intMyScore) + "/10"  );

    }   // showScore

    private void bindWidget() {
        showTextView = (TextView) findViewById(R.id.txtShowScore);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_score, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}   // Main Class
