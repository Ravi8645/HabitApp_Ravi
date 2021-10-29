package com.example.habitapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.habitapp.Habit;
import com.example.habitapp.HabitAdapter;
import com.example.habitapp.params.Params;

import java.util.ArrayList;

public class MyDbHandler extends SQLiteOpenHelper {
    public MyDbHandler(Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE " + Params.TABLE_NAME + "("
                + Params.KEY_ID + " INTEGER PRIMARY KEY," + Params.KEY_NAME
                + " TEXT, " + Params.KEY_DESC + " TEXT, " + Params.KEY_DATE + " TEXT)";
        Log.d("dbharry",create);
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addHabit(Habit habit){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Params.KEY_NAME, habit.getTitle());
        values.put(Params.KEY_DESC, habit.getDescription());
        values.put(Params.KEY_DATE, habit.getDate());

        Log.d("Values", habit.getTitle()+" "+habit.getDescription()+" "+habit.getDate());

        db.insert(Params.TABLE_NAME, null, values);
        Log.d("ravi", "Successfully inserted");

        db.close();
    }

    public ArrayList<Habit> getAllHabits(){
        ArrayList<Habit> list = new ArrayList<>();
        SQLiteDatabase db =  this.getReadableDatabase();

        // Generate the query from the database
        String select = "Select * from " + Params.TABLE_NAME;
        Cursor cursor = db.rawQuery(select, null);

        int i;
        if(cursor.moveToFirst()){
            do{
                Habit h = new Habit();
                h.setTitle(cursor.getString(1));
                h.setDescription(cursor.getString(2));
                h.setDate(cursor.getString(3));
                i=cursor.getInt(0);

                list.add(h);
                Log.d("ravi",i+" "+h.getTitle()+" "+h.getDescription()+" "+h.getDate());
            }while(cursor.moveToNext());
        }

        /*while(cursor.moveToNext()){
            Habit h = new Habit();
            h.setTitle(cursor.getString(cursor.getColumnIndex("name")));
        }*/

        return list;
    }

}
