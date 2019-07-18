package com.silent.shoplist.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Emerson on 08/10/2017.
 */

public class DadosOpenHelper extends SQLiteOpenHelper {
    public DadosOpenHelper(Context context) {

        super(context, "ShopList", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ScriptDLL.getCreateTableCliente() );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
