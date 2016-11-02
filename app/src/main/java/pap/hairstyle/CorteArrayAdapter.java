package pap.hairstyle;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pap.hairstyle.entity.Servico;


/**
 * Created by Renan on 30/10/2016.
 */

public class CorteArrayAdapter extends ArrayAdapter<Servico> {

        private Context context;
        private List<Servico> servicos;
        private CorteActivity ca;

    public CorteArrayAdapter(Context context, int resource, List<Servico> objects, CorteActivity ca) {
        super(context, resource, objects);
        this.context = context;
        this.servicos = objects;
        this.ca = ca;
    }
        @TargetApi(Build.VERSION_CODES.FROYO)
        @Override

        public View getView(final int position, View convertView, final ViewGroup parent){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View linha = inflater.inflate(R.layout.cortes, parent, false);
            TextView tempo =(TextView) linha.findViewById(R.id.tempoduracao);
            TextView preco =(TextView) linha.findViewById(R.id.precocorte);

            ImageView imagem =(ImageView) linha.findViewById(R.id.imageCortes);


            Servico s = servicos.get(position);
            System.out.println("dentro do array" + s.getDescricao());
            tempo.setText(String.valueOf(s.getTempoDuracao() + " min"));
            preco.setText(String.valueOf("R$ "+ s.getValor() + "0"));
            System.out.println("asdasd " + s.getCamFoto());

            int drawableId = getImageDrawableResId(s.getCamFoto());
            Drawable dr = ResourcesCompat.getDrawable(ca.getResources(),drawableId,null);
            imagem.setImageDrawable(dr);

            return linha;
        }

        public int getImageDrawableResId(String imageView) {
            Resources resources = ca.getResources();
            return resources.getIdentifier(imageView, "drawable", ca.getPackageName());
        }

    }

