package com.example.my_app.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my_app.DTO.User;
import com.example.my_app.R;

import java.sql.SQLException;
import java.util.List;

public class UserAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private List<User> userList;

    public UserAdapter(Context context, int layout, List<User> userList) {
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
        User user = userList.get(position);

        //Set Data
        txtInfoName.setText(user.getName());
        txtAvatar.setText(String.valueOf(position+1));

        return convertView;
    }

}
