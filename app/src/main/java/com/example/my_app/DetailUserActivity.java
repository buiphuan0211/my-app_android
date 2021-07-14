package com.example.my_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.my_app.Adapter.UserAdapter;
import com.example.my_app.DTO.User;

public class DetailUserActivity extends AppCompatActivity {
int pos;
UserAdapter adapter;

    TextView txtDetailName, txtDetailEmail, txtDetailMobieNumber, txtDetailPassword;
    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);

        txtDetailName = (TextView)findViewById(R.id.detail_txt_name);
        txtDetailEmail= (TextView)findViewById(R.id.detail_txt_email);
        txtDetailMobieNumber= (TextView)findViewById(R.id.detail_txt_mobieNumber);
        txtDetailPassword= (TextView)findViewById(R.id.detail_txt_password);

        // Get passed data
        Intent callerIntent = getIntent();
        Bundle packageFromCaller = callerIntent.getExtras();
        String name = packageFromCaller.getString("name");
        String email = packageFromCaller.getString("email");
        String mobieNumber = packageFromCaller.getString("mobieNumber");
        String password = packageFromCaller.getString("password");

        txtDetailName.setText(name);
        txtDetailEmail.setText(email);
        txtDetailMobieNumber.setText(mobieNumber);
        txtDetailPassword.setText(password);


    }
}