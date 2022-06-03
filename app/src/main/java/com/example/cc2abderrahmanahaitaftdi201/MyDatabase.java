package com.example.cc2abderrahmanahaitaftdi201;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {
    public static String db_name = "societes.db";
    public static String table_name="Societe";
    public static String col1="ID";
    public static String col2="raison_social";
    public static String col3="secteur_activtie";
    public static String col4="nb_employe";


    public MyDatabase(Context context){
        super(context, db_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql =String.format("create table %s (%s integer ,%s text ,%s text  ,%s integer)",table_name,col1,col2,col3,col4);
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = String.format("drop table %s",table_name);
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public long AddSociete(SQLiteDatabase db, Societe e){
        ContentValues cv = new ContentValues();
        cv.put(col1,e.getId());
        cv.put(col2,e.getNom());
        cv.put(col3,e.getSecteur());
        cv.put(col4,e.getNombreEmploye());
        return db.insert(table_name,null,cv);
    }

    public static long deleteSociete(SQLiteDatabase db,String number){

        return db.delete(table_name, "ID="  +col1,null);

    }


    public long UpdateSociete(SQLiteDatabase db, Societe e){
        ContentValues cv = new ContentValues();
        cv.put(col1,e.getId());
        cv.put(col2,e.getNom());
        cv.put(col3,e.getSecteur());
        cv.put(col4,e.getNombreEmploye());
        return db.update(table_name,cv,"ID="+ col1,null);
    }


    public static ArrayList<Societe> getAllSociete (SQLiteDatabase db) {
        Societe s = null;
        Cursor c = db.rawQuery(String.format("select * from %s where ID = %d", table_name, s.getId()), null);
        ArrayList<Societe> lstSo = new ArrayList<>();
        while (c.moveToNext()) {
            lstSo.add(new Societe(c.getInt(0), c.getString(1), c.getString(2), c.getInt(3)));
        }
        return lstSo;
    }

    public static Societe getOneSociete (SQLiteDatabase db){
        Societe s = null;
        Cursor c = db.rawQuery(String.format("select * from %s where ID = %d",table_name, s.getId()),null);
        if(c.moveToNext()){
            s = new Societe(c.getInt(0),c.getString(1),c.getString(2),c.getInt(3));
        }
        return  s;
    }









}
