package com.ayush.dietandhealth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ayush.dietandhealth.R;

public class LoginActivity  extends AppCompatActivity {
    private EditText username,password;
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginform);

        username=findViewById(R.id.et_username);
        password=findViewById(R.id.et_password);
        button=findViewById(R.id.btn_login);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String adminUsername=username.getText().toString();
                String adminPassword=password.getText().toString();
                if ("admin".equals(adminUsername) && "admin".equals(adminPassword)){
                    Intent intent=new Intent(LoginActivity.this,CreatePostActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
