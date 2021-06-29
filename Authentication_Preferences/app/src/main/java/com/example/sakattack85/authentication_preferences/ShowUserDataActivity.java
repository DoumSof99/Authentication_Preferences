package com.example.sakattack85.authentication_preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowUserDataActivity extends AppCompatActivity {
    TextView username;
    TextView password;
    TextView description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_show_user_data);

        retrieveData(this);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        description = findViewById(R.id.description);

    }
    void retrieveData(Context context)
    {
        SharedPreferences pref = context.getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor=pref.edit();
        editor.putString("Name", "Iosif");
        editor.commit();
        String name= pref.getString("username", ""); // getting String
        String pass=pref.getString("password", ""); // getting String
        String des=pref.getString("description",""); // getting String
        username.setText(name);
        password.setText(pass);
        description.setText(des);

    }
}
