package com.example.funkopopdatabaseapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class FunkoPOPAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<FunkoPOPItem> popItems;

    public FunkoPOPAdapter(Context context, ArrayList<FunkoPOPItem> popItems) {
        this.context = context;
        this.popItems = popItems;
    }

    @Override
    public int getCount() {
        return popItems.size();
    }

    @Override
    public Object getItem(int position) {
        return popItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_layout, parent, false);
        }

        FunkoPOPItem popItem = (FunkoPOPItem) getItem(position);

        TextView nameTextView = convertView.findViewById(R.id.nameTextView);
        TextView numberTextView = convertView.findViewById(R.id.numberTextView);
        TextView typeTextView = convertView.findViewById(R.id.typeTextView);
        TextView fandomTextView = convertView.findViewById(R.id.fandomTextView);
        TextView onTextView = convertView.findViewById(R.id.onTextView);
        TextView ultimateTextView = convertView.findViewById(R.id.ultimateTextView);
        TextView priceTextView = convertView.findViewById(R.id.priceTextView);

        nameTextView.setText("Name: " + popItem.getPopName());
        numberTextView.setText("Number: " + String.valueOf(popItem.getPopNumber()));
        typeTextView.setText("Type: " + popItem.getPopType());
        fandomTextView.setText("Fandom: " + popItem.getFandom());
        onTextView.setText("On: " + String.valueOf(popItem.isOn()));
        ultimateTextView.setText("Ultimate: " + popItem.getUltimate());
        priceTextView.setText("Price: $" + String.valueOf(popItem.getPrice()));

        return convertView;
    }
}

