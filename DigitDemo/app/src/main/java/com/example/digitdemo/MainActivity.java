package com.example.digitdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView nameText = null;
    private TextView genderText = null;
    private TextView ageText = null;
    private TextView emailText = null;

    private  String name;
    private  String gender;
    private  String age;
    private  String email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = (TextView)findViewById(R.id.nameText);
        nameText.setText("Ivan Djikovski");

        genderText = (TextView)findViewById(R.id.genderText);
        genderText.setText("Male");

        ageText = (TextView)findViewById(R.id.ageText);
        ageText.setText("33");

        emailText = (TextView)findViewById(R.id.emailText);
        emailText.setText("idj@mca.dev");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==10 && resultCode==RESULT_OK){
            nameText.setText(data.getStringExtra("Name"));
            genderText.setText(data.getStringExtra("Gender"));
            ageText.setText(data.getStringExtra("Age"));
            emailText.setText(data.getStringExtra("Email"));
        }
    }

    public  void OnDeleteClicked(View view){
        name = (String)nameText.getText();
        gender = (String)genderText.getText();
        age = (String)ageText.getText();
        email = (String)emailText.getText();

        nameText.setText("");
        genderText.setText("");
        ageText.setText("");
        emailText.setText("");
    }

    public  void  OnUndoClicked(View view){
        nameText.setText(name);
        genderText.setText(gender);
        ageText.setText(age);
        emailText.setText(email);
    }

    public  void OnEditClicked(View view){
        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra("Name", (String)nameText.getText());
        intent.putExtra("Gender", (String)genderText.getText());
        intent.putExtra("Age", (String)ageText.getText());
        intent.putExtra("Email", (String)emailText.getText());

        startActivityForResult(intent, 10);
    }
}