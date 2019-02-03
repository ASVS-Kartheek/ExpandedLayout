package com.example.expandedlayout;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ParentListAdapterClass extends ArrayAdapter {
    //to reference the Activity
    private final Activity context;

    //to store the list of names of items
    private final String[] itemsArray;

    public ParentListAdapterClass(Activity context, String[] itemsArray){
        super(context,R.layout.parent_item_layout,itemsArray);

        this.context = context;
        this.itemsArray = itemsArray;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.parent_item_layout, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView itemNameTv = rowView.findViewById(R.id.parent_item_name);
        LinearLayout itemLayout = rowView.findViewById(R.id.parent_item_layout);
        final RecyclerView childItemList = rowView.findViewById(R.id.child_list_view);
        childItemList.setLayoutManager(new LinearLayoutManager(context));
        ChildAdapter childAdapter = new ChildAdapter();
        childItemList.setAdapter(childAdapter);
        //this code sets the values of the objects to values from the arrays
        itemNameTv.setText(itemsArray[position]);
        itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(childItemList.getVisibility()==View.GONE){
                    childItemList.setVisibility(View.VISIBLE);
                }else {
                    childItemList.setVisibility(View.GONE);
                }

        }
        });
        return rowView;

    };
}
