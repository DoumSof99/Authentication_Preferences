package com.example.sakattack85.authentication_preferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView signup;
EditText username;
EditText password;
Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signup=findViewById(R.id.signup);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login=findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean valid=authentication();
                if(valid)
                {
                    Intent intent=new Intent(MainActivity.this,ShowUserDataActivity.class);
                    startActivity(intent);
                }
                else Toast.makeText(getApplicationContext(),"Not valid info",Toast.LENGTH_LONG).show();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Signup_Activity.class);
                startActivity(intent);

            }
        });
    }

    boolean authentication()
    {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor=pref.edit();
        String name= pref.getString("username", ""); // getting String
        String pass=pref.getString("password", ""); // getting String

        if(username.getText().toString().equals(name) && password.getText().toString().equals(pass))
        return  true;
        else return false;
    }
}
