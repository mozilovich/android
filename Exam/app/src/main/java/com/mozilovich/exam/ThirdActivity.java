package com.mozilovich.exam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.mozilovich.exam.R.id.result_text_view;

public class ThirdActivity extends AppCompatActivity {

    Button button;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent = getIntent();
        int result = intent.getIntExtra("key",0);
        resultTextView = (TextView) findViewById(result_text_view);
        resultTextView.setText("" + result+"/10");

        button = (Button) findViewById(R.id.again_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });



    }
}
