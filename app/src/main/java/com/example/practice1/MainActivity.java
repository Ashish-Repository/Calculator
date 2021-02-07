package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextUserName, editTextNewPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUserName = findViewById(R.id.UserName);
        editTextNewPassword = findViewById(R.id.UserNewPassword);

    }

    public void proceed(View view) {
        String UserName = editTextUserName.getText().toString();
        String NewPassword = editTextNewPassword.getText().toString();
        if(!UserName.isEmpty() && !NewPassword.isEmpty()) {
            Toast.makeText(MainActivity.this, "password matched -- Welcome", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, FirstPage.class);
            startActivity(intent);
        }
        else
            Toast.makeText(MainActivity.this,"Wrong Credential",Toast.LENGTH_SHORT).show();
    }
}