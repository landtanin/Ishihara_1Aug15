package appewtc.masterung.ishihara;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Explicit ประกาศตัวแปร
    private TextView questionTextView;
    private ImageView ishiharaImageView;
    private RadioGroup choiceRadioGroup;
    private RadioButton choice1RadioButton, choice2RadioButton,
            choice3RadioButton, choice4RadioButton;
    private Button answerButton;
    private int radioAnInt, indexAnInt, scoreAnInt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initial Widget
        initialWidget();

        //Radio Controller
        radioController();

        //Button Controller
        buttonController();


    }   // Main Method

    private void buttonController() {

        answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Check Zero
                if (radioAnInt == 0) {

                    //Alert
                    Toast.makeText(MainActivity.this, "กรุณาตอบคำถาม ด้วย นะคะ", Toast.LENGTH_SHORT).show();

                } else {

                    //Check Times
                    if (indexAnInt == 9) {

                        //Intent to ShowScore
                        Intent objIntent = new Intent(MainActivity.this, ShowScoreActivity.class);

                        //Sent Value to ShowScore
                        objIntent.putExtra("Score", scoreAnInt);

                        startActivity(objIntent);
                        finish();

                    } else {

                        //Check Score
                        checkScore();

                        //Increase
                        indexAnInt += 1;

                        //Change View
                        changeView();

                    }   //if

                }   // if

            }   // event
        });

    }   // buttonController

    private void checkScore() {

        int[] intAnswer = {1, 2, 3, 2, 1, 3, 1, 2, 4, 4};
        if (radioAnInt == intAnswer[indexAnInt]) {
            scoreAnInt++;
        }

    }   // checkScore

    private void changeView() {

        //Change Question
        String[] strQuestion = new String[10];
        strQuestion[0] = "1. What is this?";
        strQuestion[1] = "2. นี่คืออะไร ?";
        strQuestion[2] = "3. What is this?";
        strQuestion[3] = "4. นี่คืออะไร ?";
        strQuestion[4] = "5. What is this?";
        strQuestion[5] = "6. นี่คืออะไร ?";
        strQuestion[6] = "7. What is this?";
        strQuestion[7] = "8. นี่คืออะไร ?";
        strQuestion[8] = "9. What is this?";
        strQuestion[9] = "10. นี่คืออะไร ?";

        questionTextView.setText(strQuestion[indexAnInt]);

        //Change Image
        int[] intDrawable = {R.drawable.ishihara_01, R.drawable.ishihara_02,
                R.drawable.ishihara_03, R.drawable.ishihara_04, R.drawable.ishihara_05,
                R.drawable.ishihara_06, R.drawable.ishihara_07, R.drawable.ishihara_08,
                R.drawable.ishihara_09, R.drawable.ishihara_10};

        ishiharaImageView.setImageResource(intDrawable[indexAnInt]);

        //Change Choice
        int[] intTimes = {R.array.times1, R.array.times2, R.array.times3, R.array.times4,
                R.array.times5, R.array.times6, R.array.times7, R.array.times8,
                R.array.times9, R.array.times10};

        String[] strChoice = getResources().getStringArray(intTimes[indexAnInt]);
        choice1RadioButton.setText(strChoice[0]);
        choice2RadioButton.setText(strChoice[1]);
        choice3RadioButton.setText(strChoice[2]);
        choice4RadioButton.setText(strChoice[3]);


    }   // changeView


    private void radioController() {

        choiceRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                //Setup radioAnInt
                switch (i) {
                    case R.id.radioButton:
                        radioAnInt = 1;
                        break;
                    case R.id.radioButton2:
                        radioAnInt = 2;
                        break;
                    case R.id.radioButton3:
                        radioAnInt = 3;
                        break;
                    case R.id.radioButton4:
                        radioAnInt = 4;
                        break;
                    default:
                        radioAnInt = 0;
                        break;
                }   // switch

                Log.d("tag", "radio ==> " + Integer.toString(radioAnInt));

            }   // event
        });

    }   // radioController

    private void initialWidget() {

        questionTextView = (TextView) findViewById(R.id.textView2);
        ishiharaImageView = (ImageView) findViewById(R.id.imageView);
        choiceRadioGroup = (RadioGroup) findViewById(R.id.ragChoice);
        choice1RadioButton = (RadioButton) findViewById(R.id.radioButton);
        choice2RadioButton = (RadioButton) findViewById(R.id.radioButton2);
        choice3RadioButton = (RadioButton) findViewById(R.id.radioButton3);
        choice4RadioButton = (RadioButton) findViewById(R.id.radioButton4);
        answerButton = (Button) findViewById(R.id.button);

    }   // initialWidget

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
