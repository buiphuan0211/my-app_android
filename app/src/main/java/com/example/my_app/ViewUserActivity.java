package com.example.my_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.my_app.Adapter.UserAdapter;
import com.example.my_app.DTO.User;

import java.util.ArrayList;

public class ViewUserActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<User> arrayUser;
    UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user);

        lv = (ListView) findViewById(R.id.listViewUser);
        setDataUserListView();

        Intent callerIntent = getIntent();
        String dt_login_name = callerIntent.getStringExtra("dt_login_name");
        String dt_login_email = callerIntent.getStringExtra("dt_login_email");
        String dt_login_mobieNumber = callerIntent.getStringExtra("dt_login_mobieNumber");
        String dt_login_password = callerIntent.getStringExtra("dt_login_password");
        arrayUser.add( new User(dt_login_name,dt_login_email,dt_login_mobieNumber,dt_login_password));

        adapter = new UserAdapter(this,R.layout.info_user,arrayUser);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(),DetailUserActivity.class);

                getItemByPos(position);
            }
        });
    }

    private  void setDataUserListView(){
        arrayUser= new ArrayList<>();
        arrayUser.add(new User("Bùi Phú Ân","an@gmail.com","0911111111","abc"));
        arrayUser.add(new User("Tạ Đình Hân","dinhhan@gmail.com","0922222222","abc"));
        arrayUser.add(new User("Huỳnh Ngọc Viễn","ngocvien.it@gmail.com","0933333333","superman"));
        arrayUser.add(new User("Mai Văn Hiền","vanhien_123@gmail.com","0944444444","okebaney"));
        arrayUser.add(new User("Phan Hòa Thạch","hoathach_phan@gmail.com","0955555555","ahihidongoc"));
        arrayUser.add(new User("Phan Nhật Hoàng","phannhathoang@gmail.com","0966666666","mlemlem"));

    }

    private void getItemByPos(int pos){
//        User user= arrayUser.get(pos);
//        Intent intent = new Intent( this, DetailUserActivity.class);
//        intent.putExtra("name",user.getName());
//        intent.putExtra("email",user.getEmail());
//        intent.putExtra("phone",user.getMobieBumber());
//        startActivity(intent);

        User user= arrayUser.get(pos);
        Bundle bundle = new Bundle();

        bundle.putString("name",user.getName());
        bundle.putString("email", user.getEmail());
        bundle.putString("mobieNumber",user.getMobieBumber());
        bundle.putString("password",user.getPassword());

        Intent intent= new Intent( this, DetailUserActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}