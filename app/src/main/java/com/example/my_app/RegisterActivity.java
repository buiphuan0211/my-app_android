package com.example.my_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my_app.DTO.User;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {
    TextView txt_name, txt_email, txt_mobieNumber, txt_password;
    Button btn_sigup;
    ArrayList<User> arrayUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txt_name= (TextView)findViewById(R.id.reg_editTextName);
        txt_email = (TextView)findViewById(R.id.reg_editTextEmail);
        txt_mobieNumber = (TextView)findViewById(R.id.reg_editTextMobile);
        txt_password= (TextView)findViewById(R.id.reg_editTextPassword);
        btn_sigup = (Button)findViewById(R.id.reg_cirRegisterButton);
        arrayUser = new ArrayList<>();

        btn_sigup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = txt_name.getText().toString();
                String email = txt_email.getText().toString();
                String mobieNumber = txt_mobieNumber.getText().toString();
                String password = txt_password.getText().toString();
                User user = new User(name,email,mobieNumber,password);
                arrayUser.add(user);
                Toast.makeText(getApplicationContext(),"Đăng ký thành công",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent( RegisterActivity.this,LoginActivity.class);

                intent.putExtra("name1",arrayUser.get(arrayUser.size()-1).getName());
                intent.putExtra("email1", arrayUser.get(arrayUser.size()-1).getEmail());
                intent.putExtra("mobieNumber1",arrayUser.get(arrayUser.size()-1).getMobieBumber());
                intent.putExtra("password1",arrayUser.get(arrayUser.size()-1).getPassword());
                startActivity(intent);

            }
        });

    }
}