package com.example.recyclerview_191169.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_191169.Model.Student;
import com.example.recyclerview_191169.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<Student> studentList;
    Context context;
    private  OnItemClickListener buttonListener;

    public interface  OnItemClickListener{
        void onDeleteClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        buttonListener = listener;

    }

    public RecyclerViewAdapter(List<Student> studentList, Context context) {
        this.studentList = studentList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view,buttonListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.txtName.setText(student.getName());
        holder.txtRollNo.setText(student.getRollNo());
        holder.txtSubject.setText(student.getSubject());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtName, txtRollNo, txtSubject;
        ImageView delete_icon;

        public ViewHolder(@NonNull  View itemView, OnItemClickListener listener) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtRollNo = itemView.findViewById(R.id.txtRollNo);
            txtSubject = itemView.findViewById(R.id.txtSubject);
            delete_icon = itemView.findViewById(R.id.delete_icon);

            delete_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }

        @Override
        public void onClick(View v) {

        }
    }
}
