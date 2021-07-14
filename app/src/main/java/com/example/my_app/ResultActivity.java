package com.example.my_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {

    TextView txtResultCongHaiSo ;
    TextView txtResultTruHaiSo;
    TextView txtResultNhanHaiSo ;
    TextView txtResultChiaHaiSo;

    Button btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btn_back = (Button)findViewById(R.id.button_back);
        txtResultCongHaiSo = (TextView)findViewById(R.id.resultCongHaiSo);
        txtResultTruHaiSo = (TextView)findViewById(R.id.resultTruHaiSo);
        txtResultNhanHaiSo = (TextView)findViewById(R.id.resultNhanHaiSo);
        txtResultChiaHaiSo = (TextView)findViewById(R.id.resultChiaHaiSo);

        Intent callerIntent = getIntent();
        Bundle packageFromCaller = callerIntent.getExtras();
        int a = packageFromCaller.getInt("so1");
        int b = packageFromCaller.getInt("so2");

        Cong(a, b);
        Tru(a, b);
        Nhan(a, b);
        Chia(a, b);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void Cong(int a, int b ) {
        String kq = "";
        DecimalFormat dcf = new DecimalFormat("0.##");
        kq = dcf.format(a + b);
        txtResultCongHaiSo.setText("Kết quả cộng là: " + kq);
    }

    // Hàm trừ
    public void Tru(int a, int b ) {
        String kq = "";
        DecimalFormat dcf = new DecimalFormat("0.##");
        kq = dcf.format(a - b);
        txtResultTruHaiSo.setText("Kết quả trừ là: " + kq);
    }

    // Hàm nhân
    public void Nhan(int a, int b ) {
        String kq = "";
        DecimalFormat dcf = new DecimalFormat("0.##");
        kq = dcf.format(a * b);
        txtResultNhanHaiSo.setText("Kết quả nhân là: " + kq);
    }

    // Hàm chia
    public void Chia(int a, int b ) {
        String kq = "";
        DecimalFormat dcf = new DecimalFormat("0.##");
        kq = dcf.format(a / b);
        txtResultChiaHaiSo.setText("Kết quả chia là: " + kq);
    }
}