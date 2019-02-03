package com.example.expandedlayout;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] parentNames = {"Naan","Curries","Biryanis"};

        ParentListAdapterClass adapterClass = new ParentListAdapterClass(this,parentNames);
        ListView list = findViewById(R.id.parent_list);
        list.setAdapter(adapterClass);
    }
}
