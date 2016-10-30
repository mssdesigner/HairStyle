package pap.hairstyle.service;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pap.hairstyle.CorteActivity;
import pap.hairstyle.R;
import pap.hairstyle.entity.Corte;


/**
 * Created by Renan on 30/10/2016.
 */

public class CorteArrayAdapter extends ArrayAdapter<Corte> {

        private Context context;
        private List<Corte> cortes;
        private CorteActivity ca;

        public CorteArrayAdapter(Context context, int resource, List<Corte> objects, CorteActivity ca) {
            super(context, resource, objects);
            this.context = context;
            this.cortes = objects;
            this.ca = ca;
        }
        @TargetApi(Build.VERSION_CODES.FROYO)
        @Override

        public View getView(final int position, View convertView, final ViewGroup parent){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View linha = inflater.inflate(R.layout.cortes, parent, false);
            TextView tempo =(TextView) linha.findViewById(R.id.tempoduracao);
            TextView preco =(TextView) linha.findViewById(R.id.precocorte);

            ImageView imagem =(ImageView) linha.findViewById(R.id.imageCabeleireiro);


            Corte c = cortes.get(position);
            tempo.setText(c.getDuracao());
            preco.setText(c.getPreco());


            int drawableId = getImageDrawableResId(c.getCortefoto());
            Drawable dr = ResourcesCompat.getDrawable(ca.getResources(),drawableId,null);
            imagem.setImageDrawable(dr);

            return linha;
        }

        public int getImageDrawableResId(String imageView) {
            Resources resources = ca.getResources();
            return resources.getIdentifier(imageView, "drawable", ca.getPackageName());
        }

    }

