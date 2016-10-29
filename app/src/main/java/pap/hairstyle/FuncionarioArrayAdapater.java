package pap.hairstyle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pap.hairstyle.entity.Funcionario;

/**
 * Created by Renan on 28/10/2016.
 */

public class FuncionarioArrayAdapater extends ArrayAdapter<Funcionario> {
        private Context context;
        private List<Funcionario> funcionarios;

        public FuncionarioArrayAdapater(Context context, int resource, List<Funcionario> objects) {
                super(context, resource, objects);
                this.context = context;
                this.funcionarios = objects;
        }

        @Override
        public View getView(final int position, View convertView, final ViewGroup parent) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                View linha = inflater.inflate(R.layout.listview_cabeleireiro, parent , false);
                TextView nome = (TextView) linha .findViewById(R.id.textView);
                ImageView imagem = (ImageView) linha.findViewById(R.id.imageView);

                int drawableId = getImageDrawableResId("julio");
                Drawable dr = ResourcesCompat.getDrawable(getResources(),drawableId,null);


                Funcionario func = funcionarios.get(position);
                nome.setText(func.getNome());
                imagem.setImageDrawable(dr);

                return linha;
        }

        public int getImageDrawableResId(String imageView) {
                Resources resources = getResources();
                return resources.getIdentifier(imageView, "drawable", getPackageName());
        }

}
