 package com.example.my_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.my_app.database.DBHelper;

 public class RegisterActivity extends AppCompatActivity {

    EditText txt_name, txt_email, txt_mobieNumber, txt_password;
    Button btn_sigup;

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txt_name= (EditText)findViewById(R.id.reg_editTextName);
        txt_email = (EditText)findViewById(R.id.reg_editTextEmail);
        txt_mobieNumber = (EditText)findViewById(R.id.reg_editTextMobile);
        txt_password= (EditText)findViewById(R.id.reg_editTextPassword);
        btn_sigup = (Button)findViewById(R.id.reg_cirRegisterButton);

        DB = new DBHelper(this);

        btn_sigup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txt_email.getText().toString();
                String name = txt_name.getText().toString();
                String mobieNumber =txt_mobieNumber.getText().toString();
                String password = txt_password.getText().toString();
                if(email.equals("")|| name.equals("")||mobieNumber.equals("")||password.equals("")){
                    Toast.makeText(RegisterActivity.this,"Không được để trống",Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkEmail   =DB.checkEmail(email);
                    if(checkEmail==false){
                        Boolean insert=DB.insertData(email,name,mobieNumber,password);
                        if(insert==true){
                            Toast.makeText(RegisterActivity.this,"Đăng kí thành công",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(RegisterActivity.this,"Đăng kí thất bại",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RegisterActivity.this,"Email đã tồn tại! Quay lại để đăng nhập",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}