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

import pap.hairstyle.entity.Funcionario;

/**
 * Created by Renan on 28/10/2016.
 */

public class FuncionarioArrayAdapater extends ArrayAdapter<Funcionario> {
        private Context context;
        private List<Funcionario> funcionarios;
        private CabeleireiroActivity ca;

        public FuncionarioArrayAdapater(Context context, int resource, List<Funcionario> objects, CabeleireiroActivity ca) {
                super(context, resource, objects);
                this.context = context;
                this.funcionarios = objects;
                this.ca = ca;
        }
        @TargetApi(Build.VERSION_CODES.FROYO)
        @Override

        public View getView(final int position, View convertView, final ViewGroup parent){
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                View linha = inflater.inflate(R.layout.cabeleireiro, parent, false);
                TextView nome =(TextView) linha.findViewById(R.id.nomeCabeleireiro);

                ImageView imagem =(ImageView) linha.findViewById(R.id.imageCabeleireiro);


                Funcionario f = funcionarios.get(position);
                nome.setText(f.getNome());


                int drawableId = getImageDrawableResId(f.getCamFoto());
                Drawable dr = ResourcesCompat.getDrawable(ca.getResources(),drawableId,null);
                imagem.setImageDrawable(dr);

                return linha;
        }

        public int getImageDrawableResId(String imageView) {
                Resources resources = ca.getResources();
                return resources.getIdentifier(imageView, "drawable", ca.getPackageName());
        }

}
