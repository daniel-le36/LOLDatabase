package com.example.daniel.loldatabase;
import android.content.Context;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Daniel on 5/31/2016.
 */
public class DatabaseOpenHelper extends SQLiteAssetHelper{
    private static final String DATABASE_NAME = "champos_danie.db";
    private static final int DATABASE_VERSION = 4;

    public DatabaseOpenHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        setForcedUpgrade();
    }
}
