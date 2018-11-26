package com.example.lenovo.mynote;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class AddActivity extends AppCompatActivity {
    private String NoteTitle;
    private String NoteContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        EditText Notetitle= findViewById(R.id.title);
        EditText Notecontent= findViewById(R.id.content);
        NoteTitle=Notetitle.getText().toString();
        NoteContent=Notecontent.getText().toString();
        FloatingActionButton finishbutton= findViewById(R.id.finishbutton);
        finishbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backintent=new Intent();
                backintent.putExtra("NoteTitle","data1");
                backintent.putExtra("NoteContent","data2");
                setResult(RESULT_OK,backintent);
                finish();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        save(NoteTitle);
        save(NoteContent);
    }
    public void save(String inputText){
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try{
            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer=new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputText);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(writer!=null){
                    writer.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
