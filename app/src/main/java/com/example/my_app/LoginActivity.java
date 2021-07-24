package com.example.my_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my_app.database.DBHelper;

public class LoginActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button login;
    private  TextView register;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Get Data input-login
        email = (EditText)findViewById(R.id.editTextEmail);
        password = (EditText)findViewById(R.id.editTextPassword);
        login   = (Button)findViewById(R.id.loginButton);
        register = (TextView)findViewById(R.id.txtRegister);

        DB = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().equals("") ||password.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this,"Không được để trống",Toast.LENGTH_SHORT).show();
                }
                else{
                        Boolean checkEmailPass =DB.checkEmailPassword(email.getText().toString(),password.getText().toString());
                        if(checkEmailPass ==true){
                            Toast.makeText(LoginActivity.this,"Đăng nhập thành công rùi nè..!!!",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(LoginActivity.this,"Thất bại..!!!",Toast.LENGTH_SHORT).show();
                        }
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
};
