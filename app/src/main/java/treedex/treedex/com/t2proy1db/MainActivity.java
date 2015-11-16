package treedex.treedex.com.t2proy1db;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static treedex.treedex.com.t2proy1db.R.id.btnFavoritos;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public  void viewPozosAll(View view){
        Intent i = new Intent(view.getContext(), ListViewPozosActivity.class);
        startActivity(i);
    }

    public void viewPozoFavorito(View view){
        Intent intent = new Intent(this,ListViewPozosFavoritos.class);
        startActivity(intent);
    }
}
