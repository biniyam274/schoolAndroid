package com.example.bim_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bim_1_1.model.DBUser;

public class MainActivity extends AppCompatActivity {

    Button tbRegister;
    CheckBox checkBoxRememberMe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init_components();


    }

    protected void init_components() {
        tbRegister =  findViewById(R.id.btnRegister);

        tbRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   Intent intent = new Intent(MainActivity.this, ActivityRegister.class);
                   startActivity(intent);
            }
        });
        checkBoxRememberMe = findViewById(R.id.checkBoxRememberMe);
        checkBoxRememberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPrefrance", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("rememberMe", "string value"); // Storing string
            }
        });
    }

    public void Login(View v)
    {
        EditText etUserName = (EditText) findViewById(R.id.etUserName);
        EditText etPassword = (EditText) findViewById(R.id.etPassword);
        TextView tvMessage =  (TextView) findViewById(R.id.tvMessage);


        String username = etUserName.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (username.equals("")){
            tvMessage.setText("Enter your User Name.");
            tvMessage.setVisibility(View.VISIBLE);
            tvMessage.setTextColor(Color.RED);
            etUserName.requestFocus();
            return;
        }

        if (password.equals("")){
            tvMessage.setText("Enter your Password.");
            tvMessage.setVisibility(View.VISIBLE);
            tvMessage.setTextColor(Color.RED);
            etPassword.requestFocus();
            return;
        }



        // database
        //if (username.equals("admin") && password.equals("12345"))
        if (DBUser.Login(username,password))
        {
//            tvMessage.setText("Welcome to Android..");
//            tvMessage.setVisibility(View.VISIBLE);
//            tvMessage.setTextColor(Color.GREEN);

            // Intent

            Intent intent = new Intent(this,HomeActivity.class);
            intent.putExtra("data",username);
            startActivity(intent);
        }
        else{
            tvMessage.setText("Incorrect username or password");
            tvMessage.setVisibility(View.VISIBLE);
            tvMessage.setTextColor(Color.RED);
        }


    }
}