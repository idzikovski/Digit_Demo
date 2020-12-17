package com.example.digitdemo;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    private EditText nameText = null;
    private RadioButton maleRadio = null;
    private RadioButton femaleRadio = null;
    private EditText ageText = null;
    private EditText emailText = null;

    private String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent intent = getIntent();

        nameText = (EditText) findViewById(R.id.nameEditText);
        nameText.setText(intent.getStringExtra("Name"));

        ageText = (EditText) findViewById(R.id.ageEditText);
        ageText.setText(intent.getStringExtra("Age"));

        emailText = (EditText) findViewById(R.id.emailEditText);
        emailText.setText(intent.getStringExtra("Email"));

        maleRadio = (RadioButton) findViewById(R.id.maleRadio);
        femaleRadio = (RadioButton) findViewById(R.id.femaleRadio);

        String gen = intent.getStringExtra("Gender");

        gender = intent.getStringExtra("Gender");
        if (gender.equals("Male")){
            maleRadio.setChecked(true);
        }
        else {
            femaleRadio.setChecked(true);
        }
    }

    public  void  OnRadioButtonClicked(View view){
        gender = (String) ((RadioButton)view).getText();
    }

    public void OnSaveClicked(View view){
        Intent intent = new Intent();


        intent.putExtra("Name", nameText.getText().toString());
        intent.putExtra("Gender", gender);
        intent.putExtra("Age", ageText.getText().toString());
        intent.putExtra("Email", emailText.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}