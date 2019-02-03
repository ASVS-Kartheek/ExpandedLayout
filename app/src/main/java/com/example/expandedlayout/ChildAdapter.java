package com.example.expandedlayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildViewHolder> {

    String[] childItems = {"a","b","c","d","e"};
    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_item_layout,parent,false);
        ChildViewHolder viewHolder = new ChildViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder holder, int position) {
        holder.child.setText(String.valueOf(position));
    }

    @Override
    public int getItemCount() {
        return 40;
    }

    public class ChildViewHolder extends RecyclerView.ViewHolder {
        TextView child;
        TextView itemCount;
        ImageButton add;
        ImageButton remove;
        public ChildViewHolder(@NonNull View itemView) {
            super(itemView);
            child = itemView.findViewById(R.id.child);
            add = itemView.findViewById(R.id.add_btn);
            itemCount = itemView.findViewById(R.id.itemCountTv);
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int increased_value = Integer.parseInt(itemCount.getText().toString());
                    increased_value++;
                    Log.d("INCREASED VALUE:", String.valueOf(increased_value));
                    itemCount.setText(String.valueOf(increased_value));
                }
            });
            remove = itemView.findViewById(R.id.minus_btn);
            remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int decreased_value = Integer.parseInt(itemCount.getText().toString());
                    decreased_value--;
                    Log.d("DECREASED VALUE:", String.valueOf(decreased_value));
                    itemCount.setText(String.valueOf(decreased_value));
                }
            });
        }
    }
}
