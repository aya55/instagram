package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class home extends AppCompatActivity {
    ListView listView;
   public static ArrayList<user> values = new  ArrayList<>();
   public static user_adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        listView = findViewById(R.id.listt_View);

        values.add(new user("Aya ",R.drawable.marc ,
                R.drawable.marc , false , false , true ));
        values.add(new user("Aya",R.drawable.unnnnn,
                R.drawable.unnnnn , false , false , true ));
        values.add(new user("Aya", R.drawable.dodge,
                R.drawable.dodge, false , false , true ));
        values.add(new user("Aya",R.drawable.marc,
                R.drawable.marc , false , false , true ));
        values.add(new user("Aya", R.drawable.unnnnn,
                R.drawable.ic_launcher_background , false , false , true ));
        values.add(new user("Aya", R.drawable.dodge,
                R.drawable.ic_launcher_background , false , false , true ));
        adapter = new user_adapter(this,R.layout.activity,values);
        listView.setAdapter(adapter);
    }
}
