package com.example.trainandroid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class CatItemAdapter extends BaseAdapter {
    private final Context context;
    private final List<String> data;
    public CatItemAdapter(Context context, List<String> data) {
        super();
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        // inflate the layout for each item of listView
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.cats_item, parent, false);


        // get the reference of textView and button
        TextView name = (TextView) view.findViewById(R.id.cats_item_name);
        Button delete = (Button) view.findViewById(R.id.cats_item_delete);

        // Set the title and button name
        name.setText(data.get(position));

        // Click listener of button
        delete.setOnClickListener((View.OnClickListener) view1 -> ((CatsAct)context).getNameForDeleting(name.getText().toString()));

        return view;
    }
}
