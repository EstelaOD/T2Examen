package treedex.treedex.com.t2proy1db;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import treedex.treedex.com.t2proy1db.Entities.Pozo;

/**
 * Created by Evhanz on 15/11/2015.
 */
public class ListViewPozosActivity extends Activity {

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


        lv.setAdapter(adapter);


        lv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idPozo = ((EditText) findViewById(R.id.txtIdPozo)).getText().toString();
                ConexDB dbConex = new ConexDB(getBaseContext());

                SQLiteDatabase db = dbConex.getWritableDatabase();

                dbConex.update(idPozo);
            }
        });





    }

    private ArrayList<Pozo> obtenerItems(){
        ArrayList<Pozo> items = new ArrayList<Pozo>();

        ConexDB dbConex = new ConexDB(getBaseContext());

        SQLiteDatabase db = dbConex.getWritableDatabase();

        cursor = dbConex.getPozos();


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
