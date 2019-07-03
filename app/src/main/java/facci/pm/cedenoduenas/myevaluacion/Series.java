package facci.pm.cedenoduenas.myevaluacion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;

public class Series extends SQLiteOpenHelper {

    private static int version = 1;
    private static String name = "MyEvaluacion" ;
    private static CursorFactory factory = null;

    public Series(Context context) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Series(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Nombre VARCHAR," +
                "Categoria VARCHAR," +
                "Protagonistas VARCHAR," +
                "AñoDeTransmisionInicial VARCHAR, " +
                "NumeroDeTemporadas VARCHAR)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Series";
        db.execSQL(sql);
        onCreate(db);
    }
    public void Insertar(String Nombres, String Categoria, String Protagonista, String Anio, String Temporadas){

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("Nombre", Nombres);
        contentValues.put("Categoria", Categoria);
        contentValues.put("Protagonista", Protagonista);
        contentValues.put("AñoDeTransmisionInicial", Anio);
        contentValues.put("NumeroDeTemporadas", Temporadas);
        database.insert("Series",null,contentValues);
    }


    public void EliminarTodo(){
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete("Series", null, null);
    }

    public void Actualizar(String id, String Nombres, String Categoria, String Protagonista, String Anio, String Temporadas){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Nombre", Nombres);
        contentValues.put("Categoria", Categoria);
        contentValues.put("Protagonista", Protagonista);
        contentValues.put("AñoDeTransmisionInicial", Anio);
        contentValues.put("NumeroDeTemporadas", Temporadas);
        database.update("Series", contentValues, "id= " + id, null);
    }




    public String LeerTodos() {
        SQLiteDatabase database = this.getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String result = "";
        String[] sqlSelect = {"id","Nombre", "Categoria", "Protagonista", "AñoDeTransmisionInicial", "NumeroDeTemporadas"};
        String sqlTable = "Series";
        qb.setTables(sqlTable);
        Cursor c = qb.query(database, sqlSelect, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                result += "id " + c.getInt(c.getColumnIndex("id")) + "\n" +
                        "Nombre " + c.getString(c.getColumnIndex("Nombre")) + "\n" +
                        "Categoria " + c.getString(c.getColumnIndex("Categoria")) + "\n" +
                        "Protagonista " + c.getString(c.getColumnIndex("Protagonista")) + "\n" +
                        "AñoDeTransmisionInicial " + c.getString(c.getColumnIndex("AñoDeTransmisionInicial")) + "\n" +
                        "NumeroDeTemporadas " + c.getString(c.getColumnIndex("NumeroDeTemporadas")) + "\n\n\n";
            } while (c.moveToNext());
            c.close();
            database.close();
        }
        return result;

    }
}
