package com.example.habitapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HabitAdapter extends ArrayAdapter<Habit> {
    public HabitAdapter(Context context, ArrayList<Habit> list) {
        super(context,0,list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Habit habit = getItem(position);

        TextView habit_title = listItemView.findViewById(R.id.title);
        habit_title.setText(habit.getTitle());

        TextView habit_desc = listItemView.findViewById(R.id.desc);
        habit_desc.setText(habit.getDescription());

        TextView habit_date = listItemView.findViewById(R.id.date);
        habit_date.setText(habit.getDate());

        return listItemView;
    }
}
