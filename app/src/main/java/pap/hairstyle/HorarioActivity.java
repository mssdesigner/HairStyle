package pap.hairstyle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
<<<<<<< HEAD
<<<<<<< HEAD
import android.view.Menu;
import android.view.MenuItem;
=======
>>>>>>> master
=======
import android.widget.CheckBox;
import android.widget.Toast;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
>>>>>>> 7c151e87d9f57af94e9f333570f01eec5f1c0a27

/**
 * Created by vinicius on 30/10/16.
 */

public class HorarioActivity extends AppCompatActivity {
    List<CheckBox> cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horario);
<<<<<<< HEAD
<<<<<<< HEAD
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //metodo para voltar para tela anterior
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

=======
    }
>>>>>>> master
=======
        cb = new ArrayList<CheckBox>();


        cb.add(((CheckBox)findViewById(R.id.check1)));
        cb.add(((CheckBox)findViewById(R.id.check2)));
        cb.add(((CheckBox)findViewById(R.id.check3)));
        cb.add(((CheckBox)findViewById(R.id.check4)));
        cb.add(((CheckBox)findViewById(R.id.check5)));
        cb.add(((CheckBox)findViewById(R.id.check6)));
        cb.add(((CheckBox)findViewById(R.id.check7)));
        cb.add(((CheckBox)findViewById(R.id.check8)));
        cb.add(((CheckBox)findViewById(R.id.check9)));
        cb.add(((CheckBox)findViewById(R.id.check10)));
        cb.add(((CheckBox)findViewById(R.id.check11)));
        cb.add(((CheckBox)findViewById(R.id.check12)));
        cb.add(((CheckBox)findViewById(R.id.check13)));
        cb.add(((CheckBox)findViewById(R.id.check14)));
        cb.add(((CheckBox)findViewById(R.id.check15)));
        cb.add(((CheckBox)findViewById(R.id.check16)));
        cb.add(((CheckBox)findViewById(R.id.check17)));
        cb.add(((CheckBox)findViewById(R.id.check18)));
        cb.add(((CheckBox)findViewById(R.id.check19)));
        cb.add(((CheckBox)findViewById(R.id.check20)));
        cb.add(((CheckBox)findViewById(R.id.check21)));
        cb.add(((CheckBox)findViewById(R.id.check22)));
        cb.add(((CheckBox)findViewById(R.id.check23)));
        cb.add(((CheckBox)findViewById(R.id.check24)));


    }

    public void onCheckboxClicked(View view) {
        CheckBox aux = null;
        int auxS;


        for (int i=0; i< cb.size(); i++){
            if(view.getId() == cb.get(i).getId()){
                aux = cb.get(i);
            }
            cb.get(i).setChecked(false);
        }
        if (aux != null){
            aux.setChecked(true);

        }
    }
    public void pegarHorarioEscolhido(View view){
        for(int i =0; i< cb.size(); i++){
            if(cb.get(i).isChecked()){
                System.out.println(cb.get(i).getText().toString());
            }
        }

    }


>>>>>>> 7c151e87d9f57af94e9f333570f01eec5f1c0a27
}
