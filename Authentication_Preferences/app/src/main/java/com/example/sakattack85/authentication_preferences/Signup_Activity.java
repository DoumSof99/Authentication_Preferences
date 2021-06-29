package com.example.sakattack85.authentication_preferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup_Activity extends AppCompatActivity {
    EditText username;
    EditText password;
    EditText description;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signup=findViewById(R.id.signup);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        description = findViewById(R.id.description);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            storeData();
                Intent intent=new Intent(Signup_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

  public  void storeData()
    {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("username",username.getText().toString());
        editor.putString("password", password.getText().toString());
        editor.putString("description", description.getText().toString());
        editor.commit();
    }

}