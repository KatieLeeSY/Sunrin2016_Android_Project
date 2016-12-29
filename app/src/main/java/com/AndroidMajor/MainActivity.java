package com.AndroidMajor;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ListView listView;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<User> users = new ArrayList<>();
        users.add(new User("라이언", "010-1234-1234", 10));
        users.add(new User("모찌", "110-1234-1234", 34));
        users.add(new User("무지", "210-1234-1234", 13));
        users.add(new User("뽀로로", "310-1234-1234", 16));
        users.add(new User("셀리", "410-1234-1234", 35));
        users.add(new User("브라운", "510-1234-1234", 15));
        users.add(new User("코니", "610-1234-1234", 13));
        users.add(new User("프로도", "710-1234-1234", 41));
        users.add(new User("러버덕", "810-1234-1234", 20));


        listView = (ListView) findViewById(R.id.list_view);
        customAdapter = new CustomAdapter(users);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this, users.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this, String.valueOf(users.get(position).getAge()), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
}