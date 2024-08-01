package com.habi.vsga_2024;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MainAdapter extends ArrayAdapter<Kontak> {

    public MainAdapter(@NonNull Context context) {
        super(context,0 , new ArrayList<>());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemview = convertView;
        if (itemview == null) {
            itemview = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
        }

        Kontak kontak = getItem(position);

        TextView textView1 = itemview.findViewById(android.R.id.text1);
        TextView textView2 = itemview.findViewById(android.R.id.text2);

        textView1.setText(kontak.getNama());
        textView2.setText(kontak.getAlamat());
        return itemview;
    }
}