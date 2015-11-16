package treedex.treedex.com.t2proy1db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Evhanz on 15/11/2015.
 */
public class ConexDB extends SQLiteOpenHelper {


    public static final String TABLE_ID = "_idPozo";
    public static final String TITLE = "title";
    public static final String CONTENT = "content";


    public static final String OPERADOR_POZO ="operador_pozo";
    public static final String NOMBRE ="nombre";
    public static final String ESTRELLA ="estrella";


    public static final String DATABASE = "T2";
    public static final String TABLE = "pozos";




    public ConexDB(Context context) {
        super(context,DATABASE,null,2);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE + " (" +
                TABLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NOMBRE + " TEXT, " +
                OPERADOR_POZO + " TEXT, " +
                ESTRELLA + " TEXT)");

        Log.i(this.getClass().toString(), "Tabla Pozos creada");

   /*
    * Insertamos datos iniciales
    */


        db.execSQL("INSERT INTO pozos(nombre,operador_pozo,estrella) VALUES('Kirinthor','Evhanz','si')");
        db.execSQL("INSERT INTO pozos(nombre,operador_pozo,estrella) VALUES('Maldario','Evhanz','no')");
        db.execSQL("INSERT INTO pozos(nombre,operador_pozo,estrella) VALUES('Suma','Evhanz','si')");
        db.execSQL("INSERT INTO pozos(nombre,operador_pozo,estrella) VALUES('Noxus','Evhanz','no')");
        db.execSQL("INSERT INTO pozos(nombre,operador_pozo,estrella) VALUES('Tenario','Evhanz','si')");
        db.execSQL("INSERT INTO pozos(nombre,operador_pozo,estrella) VALUES('Yushuma','Evhanz','si')");

        Log.i(this.getClass().toString(), "Datos iniciales HIPOTECA insertados");

        Log.i(this.getClass().toString(), "Base de datos creada");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXIST " + TABLE);
        onCreate(db);

    }

    public Cursor getPozos(){
        Cursor c = this.getWritableDatabase().rawQuery("SELECT _idPozo,nombre,operador_pozo,estrella FROM pozos ",null);
        return c;
    }
    public Cursor getPozosFavoritos(){
        Cursor c = this.getWritableDatabase().rawQuery("SELECT _idPozo,nombre,operador_pozo,estrella FROM pozos WHERE estrella like 'si'",null);
        return c;
    }

    public void update(String id){

        Cursor c = this.getWritableDatabase().rawQuery("SELECT _idPozo,nombre,operador_pozo,estrella FROM pozos WHERE _idPozo = "+id,null);

        String estrella = c.getString(3);
        String valor="";

        if (estrella.equals("si"))
            valor ="no";
        else
            valor = "si";


        ContentValues cv = new ContentValues();
        cv.put("estrella",valor);
        this.getWritableDatabase().update(TABLE, cv, TABLE_ID + "=" + id, null);
    }






}
