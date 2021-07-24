package com.example.my_app.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.my_app.DTO.User;
import com.example.my_app.R;
import com.example.my_app.ViewUserActivity;

import java.sql.SQLException;
import java.util.List;

public class UserAdapter extends BaseAdapter {

    private ViewUserActivity context;
    private  int layout;
    private List<User> userList;

    public UserAdapter(ViewUserActivity context, int layout, List<User> userList) {
        this.context = context;
        this.layout = layout;
        this.userList = userList;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView= inflater.inflate(layout,null);

         // Get View
        TextView txtInfoName =(TextView) convertView.findViewById(R.id.info_name);
        TextView txtAvatar = (TextView) convertView.findViewById(R.id.tvAvatar);
        Button btnDelete = (Button) convertView.findViewById(R.id.btn_delete);
        Button btnEdit = (Button) convertView.findViewById(R.id.btn_edit);

        User user = userList.get(position);

        //Set Data
        txtInfoName.setText(user.getName());
        txtAvatar.setText(String.valueOf(position+1));

        // Bắt sự kiện xóa và cập nhật
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.DialogCapNhat(user.getEmail(),user.getName(),user.getMobieBumber(),user.getPassword());
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.DialogXoa(user.getName(),user.getEmail());
            }
        });

        txtInfoName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    context.DetailSinhVien(user.getEmail(),user.getName(),user.getMobieBumber(),user.getPassword());
            }
        });

        return convertView;
    }

}
