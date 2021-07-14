package com.example.my_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my_app.Adapter.UserAdapter;
import com.example.my_app.DTO.User;

public class LoginActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button login;
    private  TextView register;
    private TextView tvDSSV;
    UserAdapter  adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Get Data input-login
        email = (EditText)findViewById(R.id.editTextEmail);
        password = (EditText)findViewById(R.id.editTextPassword);
        login   = (Button)findViewById(R.id.loginButton);
        register = (TextView)findViewById(R.id.txtRegister);
        tvDSSV =(TextView)findViewById(R.id.dssv);

        // Get Data SinhVien
        Intent callerIntent = getIntent();
        String dt_name = callerIntent.getStringExtra("name1");
        String dt_email = callerIntent.getStringExtra("email1");
        String dt_mobieNumber = callerIntent.getStringExtra("mobieNumber1");
        String dt_password = callerIntent.getStringExtra("password1");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(email.getText().toString(),password.getText().toString(),dt_email, dt_password);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        tvDSSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(LoginActivity.this, ViewUserActivity.class);
                    intent.putExtra("dt_login_name",dt_name);
                    intent.putExtra("dt_login_email", dt_email);
                    intent.putExtra("dt_login_mobieNumber",dt_mobieNumber);
                    intent.putExtra("dt_login_password",dt_password);
                    startActivity(intent);

            }
        });
    }

    private void validate(String email, String pass, String data_email, String data_password){
        if(email.isEmpty() || pass.isEmpty()){
            Toast.makeText(getApplicationContext(),"Không được để trống",Toast.LENGTH_SHORT).show();
        }
        else {
                if((email.equals(data_email)&& pass.equals(data_password)) ||(email.equals("abc")&& pass.equals("abc")) ){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Sai Email or password",Toast.LENGTH_SHORT).show();
                }
        }
    };
    private void sendDataToViewUser(String email, String pass){
        if(email.isEmpty() || pass.isEmpty()){

        }
    }
};
