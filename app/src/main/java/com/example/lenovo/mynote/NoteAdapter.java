package com.example.lenovo.mynote;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    public List<Note> mNoteList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView Title;
        TextView Content;
        public ViewHolder(View view){
            super(view);
            Title= view.findViewById(R.id.Title_item);
            Content= view.findViewById(R.id.Content_item);
        }
    }
    public NoteAdapter(List<Note> notelist){
        mNoteList=notelist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note note = mNoteList.get(position);
        holder.Title.setText(note.getTitle());
        holder.Content.setText(note.getContent());
    }

    @Override
    public int getItemCount() {
        return mNoteList.size();
    }
}
