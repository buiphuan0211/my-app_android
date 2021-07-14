package com.example.my_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView congHaiSo;
    private  TextView dssv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dssv = (TextView)findViewById(R.id.dsSinhVien);
        congHaiSo =(TextView)findViewById(R.id.congHaiSo);

        congHaiSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CongHaiSo();
            }
        });
        dssv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DanhSachSinhVien();
            }
        });
    }

    private void CongHaiSo(){
            Intent intent = new Intent(MainActivity.this, CongHaiSoActivity.class);
            startActivity(intent);

    }
    private void DanhSachSinhVien(){
        Intent intent = new Intent(MainActivity.this, ViewUserActivity.class);
        startActivity(intent);

    }

}