package treedex.treedex.com.t2proy1db;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import treedex.treedex.com.t2proy1db.Entities.Pozo;

/**
 * Created by Evhanz on 15/11/2015.
 */
public class ItemPozoAdapter extends ArrayAdapter<Pozo> {

    private int resource;

    public ItemPozoAdapter(Context context, int resource, List<Pozo> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null)
            convertView = inflater.inflate(resource,parent,false);
        Pozo pozo = getItem(position);

        String a = pozo.getId()+"";

        ((TextView)convertView.findViewById(R.id.txtIdPozo)).setText(a);
        ((TextView)convertView.findViewById(R.id.txtNombre)).setText(pozo.getNombre());
        ((TextView)convertView.findViewById(R.id.txtOperador)).setText(pozo.getOperador_pozo());
        if(pozo.getEstrella().equals("si")){
        ((ImageButton)convertView.findViewById(R.id.imageButton)).setBackgroundResource(R.mipmap.on_favorite);
        }else {
            ((ImageButton)convertView.findViewById(R.id.imageButton)).setBackgroundResource(R.mipmap.fovorite);
        }
        return convertView;

    }
}
