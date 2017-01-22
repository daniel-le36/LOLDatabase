package com.example.daniel.loldatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Daniel on 6/1/2016.
 */
public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;
    private Cursor cursor;

    private DatabaseAccess(Context context){

        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context){
        if(instance == null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open(){
        this.database = openHelper.getReadableDatabase();
    }

    public void close(){
        if(database != null){
            this.database.close();
        }
    }

    public String get_info(String position, String column){
        String info;
        String query = "SELECT " + column + " FROM champ_data WHERE Id ="+position;
        cursor = database.rawQuery(query,null);
        cursor.moveToFirst();
        info = cursor.getString(cursor.getColumnIndex(column));
        cursor.close();
        return info;
    }

}
