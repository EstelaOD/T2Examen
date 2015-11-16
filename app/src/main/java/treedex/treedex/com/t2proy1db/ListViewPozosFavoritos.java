package treedex.treedex.com.t2proy1db;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import treedex.treedex.com.t2proy1db.Entities.Pozo;

/**
 * Created by Evhanz on 15/11/2015.
 */
public class ListViewPozosFavoritos extends Activity {

    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_pozos);



        ListView lv = (ListView)findViewById(R.id.listView);

        /*Inicializaciond e Base de Datos*/

        ConexDB dbConex = new ConexDB(getBaseContext());

        SQLiteDatabase db = dbConex.getWritableDatabase();



        ArrayList<Pozo> pozos = obtenerItems();

        ItemPozoAdapter adapter = new ItemPozoAdapter(this,R.layout.list_item_pozos,obtenerItems());



    }

    private ArrayList<Pozo> obtenerItems(){
        ArrayList<Pozo> items = new ArrayList<Pozo>();

        ConexDB dbConex = new ConexDB(getBaseContext());

        SQLiteDatabase db = dbConex.getWritableDatabase();

        cursor = dbConex.getPozosFavoritos();


        startManagingCursor(cursor);


        Pozo pozo = new Pozo();
        int id=0;
        String nombre="",operador="",estrella="";

        if(cursor.moveToFirst()){
            do {
                id = cursor.getInt(0);
                nombre = cursor.getString(1);
                operador = cursor.getString(2);
                estrella = cursor.getString(3);
                items.add(new Pozo(id,nombre ,operador , estrella));

            }while (cursor.moveToNext());

        }

        return items;

    }
}
