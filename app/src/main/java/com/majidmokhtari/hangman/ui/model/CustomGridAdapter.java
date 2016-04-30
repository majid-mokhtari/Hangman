package com.majidmokhtari.hangman.ui.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.majidmokhtari.hangman.R;
import com.majidmokhtari.hangman.ui.HangmanActivity;

/**
 * Created by majid on 4/24/2016.
 */
public class CustomGridAdapter extends BaseAdapter{

    private HangmanActivity context;
    final private String[] items;
    LayoutInflater inflater;

    public CustomGridAdapter(HangmanActivity context, String[] items) {
        this.context = context;
        this.items = items;
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.cell, null);
        }
        final Button button = (Button) convertView.findViewById(R.id.grid_item);
        button.setText(items[position]);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                context.itemClicked(position, button);
                button.setEnabled(false);
            }
        });

        return convertView;
    }

    @Override
    public boolean isEnabled(int position) {
        // Return true for clickable, false for not
        return false;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
