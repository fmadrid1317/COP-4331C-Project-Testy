package com.example.ferna.mytesty;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

public class MultipleChoice_Activity extends AppCompatActivity {

    public Button nxtButton;
    public Button saveButton;
    public TextInputLayout qstTxt;
    public TextInputLayout corAns;
    public TextInputLayout incAns1;
    public TextInputLayout incAns2;
    public TextInputLayout incAns3;

    Gson gS = new Gson();
    String target = getIntent().getStringExtra("QuizString");
    Quiz currentQuiz = gS.fromJson(target, Quiz.class);

    private void init(){
        qstTxt = findViewById(R.id.qstTxt);
        corAns = findViewById(R.id.corAns);
        incAns1 = findViewById(R.id.incAns1);
        incAns2 = findViewById(R.id.incAns2);
        incAns3 = findViewById(R.id.incAns3);

        nxtButton = (Button)findViewById(R.id.nxtButton);
        nxtButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                target = gS.toJson(currentQuiz);
                Intent nextQuestion;
                nextQuestion = new Intent(MultipleChoice_Activity.this, MultipleChoice_Activity.class);
                nextQuestion.putExtra("QuizString", target);
                startActivity(nextQuestion);
            }
        });

        saveButton = (Button)findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                target = gS.toJson(currentQuiz);
                Intent saveQuiz;
                saveQuiz = new Intent(MultipleChoice_Activity.this, MainMenuActivity.class);
                saveQuiz.putExtra("QuizString", target);
                startActivity(saveQuiz);
            }
        });


    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choice_);
        init();
    }
}
