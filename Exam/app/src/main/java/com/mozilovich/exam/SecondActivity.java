package com.mozilovich.exam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.mozilovich.exam.R.array.questions;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    int id = 0;
    int result = 0;
    int[] otvety = {3,4,2,3,4,1,2,1,2,1};
    int resultCounter = 0;
    RadioGroup radioGroup;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    TextView questsCounter;
    TextView questionTextView;
    Button nextButton;
    String[] questions;
    String[] answers1;
    String[] answers2;
    String[] answers3;
    String[] answers4;
    int count = 0;
    int questionsCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        questions = getResources().getStringArray(R.array.questions);
        answers1 = getResources().getStringArray(R.array.answer1);
        answers2 = getResources().getStringArray(R.array.answer2);
        answers3 = getResources().getStringArray(R.array.answer3);
        answers4 = getResources().getStringArray(R.array.answer4);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        radioButton1 = (RadioButton) findViewById(R.id.first_radio_button);
        radioButton2 = (RadioButton) findViewById(R.id.second_radio_button);
        radioButton3 = (RadioButton) findViewById(R.id.third_radio_button);
        radioButton4 = (RadioButton) findViewById(R.id.fourth_radio_button);
        radioButton1.setText(answers1[count]);
        radioButton2.setText(answers2[count]);
        radioButton3.setText(answers3[count]);
        radioButton4.setText(answers4[count]);

        radioButton1.setOnClickListener(this);
        radioButton2.setOnClickListener(this);
        radioButton3.setOnClickListener(this);
        radioButton4.setOnClickListener(this);

        questsCounter = (TextView) findViewById(R.id.quests_counter);
        nextButton = (Button) findViewById(R.id.next_button);
        nextButton.setEnabled(false);
        questionTextView = (TextView) findViewById(R.id.question_text_view);
        questionTextView.setText(questions[count]);
        questsCounter.setText(getResources().getString(R.string.question_one_of_ten) + " " + questionsCount + "/10");
        questionsCount++;
        count++;
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(otvety[resultCounter]==id){
                    result++;
                    id = 0;
                }
                resultCounter++;
                radioGroup.clearCheck();

                if (count < questions.length) {
                    questionTextView.setText(questions[count]);
                    radioButton1.setText(answers1[count]);
                    radioButton2.setText(answers2[count]);
                    radioButton3.setText(answers3[count]);
                    radioButton4.setText(answers4[count]);

                    questsCounter.setText(getResources().getString(R.string.question_one_of_ten) + " " + questionsCount + "/10");
                    count++;
                    questionsCount++;
                }
                else{
                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    intent.putExtra("key",result);
                    startActivity(intent);
                }

                nextButton.setEnabled(false);
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.first_radio_button:
                nextButton.setEnabled(true);
                id = 1;
                break;
            case R.id.second_radio_button:
                nextButton.setEnabled(true);
                id = 2;
                break;
            case R.id.third_radio_button:
                nextButton.setEnabled(true);
                id = 3;
                break;
            case R.id.fourth_radio_button:
                nextButton.setEnabled(true);
                id = 4;
                break;
            case -1:
                nextButton.setEnabled(false);
                break;
        }
    }

}
