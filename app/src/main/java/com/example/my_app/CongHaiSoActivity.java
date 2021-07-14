package com.example.my_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CongHaiSoActivity extends AppCompatActivity {
private EditText So1,So2;
private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cong_hai_so);

        So1 =(EditText)findViewById(R.id.edt_so1);
        So2 = (EditText)findViewById(R.id.edt_so2);
        btn = (Button)findViewById(R.id.button) ;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CongHaiSoActivity.this,ResultActivity.class);
                Bundle bundle = new Bundle();
                int a = Integer.parseInt(So1.getText().toString());
                int b = Integer.parseInt(So2.getText().toString());
                bundle.putInt("so1",a);
                bundle.putInt("so2",b);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

}