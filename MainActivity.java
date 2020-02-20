package com.example.emptyactivity1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mtruebutton;
    private Button mfalsebutton;
    private Button mNextButton;
    private TextView mQuestion;
    private Button mpreviousbutton;
    private Question[] mQuestionBank= new Question[]{
            new Question(R.string.question_1,false),
            new Question(R.string.question_2,false),
            new Question(R.string.question_3,false),
            new Question(R.string.question_4,true),
            new Question(R.string.question_5,true),
            new Question(R.string.question_6,true),
            new Question(R.string.question_7,true),


    };
    private int mcurrentindex=0;
    private void updatequestion(){
        int Qno=mQuestionBank[mcurrentindex].getTextResId(); //Returns the string no
        mQuestion.setText(Qno);//sets the question on layout

    }
    private void chkAnswer(boolean userinput){
        boolean actualanswer=mQuestionBank[mcurrentindex].isAnswerTrue();
        int messageResId=0;
        if(userinput==actualanswer){
            messageResId=R.string.correct_toast;
        }
        else{
            messageResId=R.string.incorrect_toast;
        }
        Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show();

    }
    @Override  //Required for interaction
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //To be make the given class the parent class
        setContentView(R.layout.activity_main);//R-resource file
        mQuestion=(TextView)findViewById(R.id.question_textview); //Links the layout textview to mQuestion
        mtruebutton=(Button)findViewById(R.id.true_button);
        mfalsebutton=(Button)findViewById(R.id.false_button);
        mtruebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chkAnswer(true);

            }
        });
        mfalsebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               chkAnswer(false);

            }
        });
        mNextButton=(Button)findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mcurrentindex=(mcurrentindex+1)%mQuestionBank.length;
               updatequestion();
            }
        });
        mpreviousbutton=(Button)findViewById(R.id.previous_button);
        mpreviousbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mcurrentindex=mcurrentindex-1;
                updatequestion();
            }
        });
        updatequestion();
        mQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mcurrentindex=(mcurrentindex+1)%mQuestionBank.length;
                updatequestion();
            }
        });


    }

}

