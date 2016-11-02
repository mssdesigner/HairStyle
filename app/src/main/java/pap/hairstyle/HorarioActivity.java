package pap.hairstyle;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;

import android.widget.CheckBox;
import android.widget.Toast;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import pap.hairstyle.entity.Agendamento;
import pap.hairstyle.service.FacadeService;

/**
 * Created by vinicius on 30/10/16.
 */

public class HorarioActivity extends AppCompatActivity {
    List<CheckBox> cb;

    Bundle info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horario);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

        Intent inten = getIntent();
        info = inten.getExtras();

        carregarDados();






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


    public void carregarDados(){
        new CarregarHorarioTask().execute();
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


    private class CarregarHorarioTask extends AsyncTask<String, Void, List<Agendamento>> {
        private ProgressDialog dialog;
        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(HorarioActivity.this);
            dialog.show();
        }


        @Override
        protected void onPostExecute(List<Agendamento> agendamentos) {
            try {
                if (agendamentos != null) {
                    for(int i =0; i<agendamentos.size(); i++){
                        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
                        cb.get(i).setText(df.format(agendamentos.get(i).getDataHoraIni()));
                        cb.get(i).setVisibility(View.VISIBLE);

                    }
                }



                dialog.dismiss();


            }catch(Exception e){
                e.printStackTrace();
            }

        }

        @Override
        protected List<Agendamento> doInBackground(String... params) {
            FacadeService fs = new FacadeService();
            return fs.getAs().getAgendamentosPorData(info.getString("dataEsc"));
        }
    }


}
