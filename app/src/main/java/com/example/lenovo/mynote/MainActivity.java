package com.example.lenovo.mynote;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Note> mData;
    private String ListTitle;
    private String ListContent;
    private Note data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        RecyclerView recyclerView = findViewById(R.id.noteslist);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        NoteAdapter adapter = new NoteAdapter(mData);
        recyclerView.setAdapter(adapter);
        FloatingActionButton addbutton = findViewById(R.id.addbutton);
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 1:
                if (requestCode == RESULT_OK) {
                    ListTitle = data.getStringExtra("data1");
                    ListContent=data.getStringExtra("data2");
                }
                break;
            default:
        }
    }

    private void initData() {
        data = new Note();
        data.setTitle(ListTitle);
        data.setContent(ListContent);
        mData.add(data);
    }

}
