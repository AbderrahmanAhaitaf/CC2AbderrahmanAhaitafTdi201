import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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



}
