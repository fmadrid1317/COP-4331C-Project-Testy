package com.example.ferna.mytesty;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class TakeFR extends AppCompatActivity {

    public Button nextButton;
    public Button prevButton;
    public TextInputLayout ansTxt;
    public TextView quesText;
    public Quiz newQuiz;


    private void init()
    {
        nextButton = findViewById(R.id.nxtQuest2);
        prevButton = findViewById(R.id.prvQuest2);
        ansTxt = findViewById(R.id.corAns);
        quesText = findViewById(R.id.frText);

        Intent i = getIntent();
        newQuiz = (Quiz)i.getSerializableExtra("Quiz");

        if(newQuiz.current.next == null)
            nextButton.setText("Finish");
        if(newQuiz.current.previous == null)
            prevButton.setText("");

        quesText.setText(newQuiz.current.getQuizQuestion());

        loadAnswer();

        //Go to next question or show score on button click
        findNext();

        //Go to previous question on button click
        findPrevious();

    }

    private void loadAnswer()
    {
        if(!newQuiz.current.getSavedAnswer().equals("zzzzqqqq1"))
            ansTxt.getEditText().setText(newQuiz.current.getSavedAnswer());
    }

    private void saveAnswer()
    {
        if(ansTxt.getEditText().getText().toString() != null)
            newQuiz.current.setSavedAnswer(ansTxt.getEditText().getText().toString());


    }

    private void checkAnswer()
    {
        if(ansTxt.getEditText().getText().toString().toLowerCase().equals(newQuiz.current.getCorrAns()))
            newQuiz.current.setAnsweredCorrect(true);
        else
            newQuiz.current.setAnsweredCorrect(false);
    }

    private void findNext()
    {
        nextButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                checkAnswer();
                saveAnswer();
                if(newQuiz.current.next != null) {
                    newQuiz.nextQuestion();
                    if (newQuiz.current.getQuesType() == 0) {
                        Intent takeMC = new Intent(TakeFR.this, TakeMC.class);
                        takeMC.putExtra("Quiz", newQuiz);
                        startActivity(takeMC);
                        finish();
                    } else if (newQuiz.current.getQuesType() == 1) {
                        Intent takeTF = new Intent(TakeFR.this, TakeTF.class);
                        takeTF.putExtra("Quiz", newQuiz);
                        startActivity(takeTF);
                        finish();
                    } else if (newQuiz.current.getQuesType() == 2) {
                        Intent takeFR = new Intent(TakeFR.this, TakeFR.class);
                        takeFR.putExtra("Quiz", newQuiz);
                        startActivity(takeFR);
                        finish();
                    }
                }
                else
                {
                    Intent finishQuiz = new Intent(TakeFR.this, GetScore.class);
                    finishQuiz.putExtra("Quiz", newQuiz);
                    startActivity(finishQuiz);
                    finish();
                }
            }
        });
    }

    private void findPrevious()
    {
        prevButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                checkAnswer();
                saveAnswer();
                if(newQuiz.current.previous != null)
                {
                    newQuiz.previousQuestion();
                    if (newQuiz.current.getQuesType() == 0) {
                        Intent takeMC = new Intent(TakeFR.this, TakeMC.class);
                        takeMC.putExtra("Quiz", newQuiz);
                        startActivity(takeMC);
                        finish();
                    } else if (newQuiz.current.getQuesType() == 1) {
                        Intent takeTF = new Intent(TakeFR.this, TakeTF.class);
                        takeTF.putExtra("Quiz", newQuiz);
                        startActivity(takeTF);
                        finish();
                    } else if (newQuiz.current.getQuesType() == 2) {
                        Intent takeFR = new Intent(TakeFR.this, TakeFR.class);
                        takeFR.putExtra("Quiz", newQuiz);
                        startActivity(takeFR);
                        finish();
                    }
                }
            }
        });
    }


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_fr);
        init();
    }
}
