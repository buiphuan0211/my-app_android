package com.example.my_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my_app.Adapter.UserAdapter;
import com.example.my_app.DTO.User;
import com.example.my_app.database.DBHelper;

import java.util.ArrayList;

public class ViewUserActivity extends AppCompatActivity {

    Button btnCreate;
    ListView lv;
    ArrayList<User> arrayUser;
    UserAdapter adapter;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user);

        DB = new DBHelper(this);

        btnCreate = (Button)findViewById(R.id.btn_create);

        lv = (ListView) findViewById(R.id.listViewUser);
        arrayUser= new ArrayList<>();

        adapter = new UserAdapter(this,R.layout.info_user,arrayUser);
        lv.setAdapter(adapter);

        getDataSinhVien();

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogThem();
            }
        });
    }

    public void getDataSinhVien(){
        //Select Data
        Cursor dataSinhVien = DB.getSinhVien();
        arrayUser.clear();
        while (dataSinhVien.moveToNext()){
            String email = dataSinhVien.getString(0);
            String name = dataSinhVien.getString(1);
            String numberMobie = dataSinhVien.getString(2);
            String password =dataSinhVien.getString(3);
            arrayUser.add(new User(email,name,numberMobie,password));
        }
        adapter.notifyDataSetChanged();
    }

    private void DialogThem(){
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // bỏ khoản trống title phía trên
        dialog.setContentView(R.layout.dialog_them_sinh_vien);

        EditText txtEmail = (EditText)dialog.findViewById(R.id.create_txt_email);
        EditText txtName = (EditText)dialog.findViewById(R.id.create_txt_name);
        EditText txtMobieNumber = (EditText)dialog.findViewById(R.id.create_txt_mobieNumber);
        EditText txtPassword = (EditText)dialog.findViewById(R.id.create_txt_password);
        Button btnThem = (Button)dialog.findViewById(R.id.create_btn_them);
        Button btnHuy = (Button)dialog.findViewById(R.id.create_btn_huy);
        TextView txtError =(TextView)dialog.findViewById(R.id.create_error);


        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String email = txtEmail.getText().toString();
                    String name = txtName.getText().toString();
                    String mobieNumber = txtMobieNumber.getText().toString();
                    String password = txtPassword.getText().toString();

                    if(email.equals("")|| name.equals("")||mobieNumber.equals("")||password.equals("")){
                        txtError.setText("Không được để trống, vui lòng nhập lại...!");
                    }
                    else {
                        Boolean themSV = DB.insertData(email,name,mobieNumber,password);
                        if(themSV==true){
                            Toast.makeText(getApplicationContext(),"Thêm thành công rùi nè..!!!",Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                        getDataSinhVien();
                    }
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void DialogCapNhat(String email, String name, String mobieNumber, String password){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_cap_nhat_sinh_vien);

        EditText txtName = (EditText)dialog.findViewById(R.id.edit_txt_name);
        EditText txtMobieNumber = (EditText)dialog.findViewById(R.id.edit_txt_mobieNumber);
        EditText txtPassword = (EditText)dialog.findViewById(R.id.edit_txt_password);
        Button btnTCapNhat = (Button)dialog.findViewById(R.id.edit_btn_capnhat);
        Button btnHuy = (Button)dialog.findViewById(R.id.edit_btn_huy);
        TextView txtError =(TextView)dialog.findViewById(R.id.create_error);

        txtName.setText(name);
        txtMobieNumber.setText(mobieNumber);
        txtPassword.setText(password);

        btnTCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String new_name = txtName.getText().toString();
                String new_mobieNumber = txtMobieNumber.getText().toString();
                String new_password = txtPassword.getText().toString();

                DB.updateData(email,new_name,new_mobieNumber,new_password);
                dialog.dismiss();
                getDataSinhVien();
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void DialogXoa(String name,String email){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_message_xoa_sinh_vien);

        TextView txtXoa = (TextView)dialog.findViewById(R.id.textXoa);
        Button btnHuy = (Button)dialog.findViewById(R.id.delete_btn_huy);
        Button btnXoa = (Button)dialog.findViewById(R.id.delete_btn_xoa);

        txtXoa.setText("Bạn có muốn xóa sinh viên "+ name + " không...?");

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            DB.delete(email);
                dialog.dismiss();
                getDataSinhVien();
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void DetailSinhVien(String email, String name, String mobieNumber, String password){
        Bundle bundle = new Bundle();

        bundle.putString("name",name);
        bundle.putString("email", email);
        bundle.putString("mobieNumber",mobieNumber);
        bundle.putString("password",password);

        Intent intent= new Intent( this, DetailUserActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }


}