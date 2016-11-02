package pap.hairstyle;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import pap.hairstyle.entity.Servico;
import pap.hairstyle.service.ServicoService;

/**
 * Created by Renan on 18/10/2016.
 */

public class CorteActivity extends AppCompatActivity {

    private ArrayAdapter<Servico> adapter = null;
    private ListView lista;

    private List<Servico> servs;
    private Intent intencao;
    private Bundle info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_cortes);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        intencao = getIntent();
        info = intencao.getExtras();



        lista = (ListView) findViewById(R.id.listviewcortes);
        carregarDados();

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){


                // bundle.putString("funcionario",nomeFunc);
                //bundle.putSerializable("funcionario", funcs.get(position));

                info.putSerializable("Servico",servs.get(position));
                Intent intent = new Intent(CorteActivity.this,AgendamentoActivity.class);
                intent.putExtras(info);
                startActivity(intent);

            }

        });


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
        new CarregarServTask().execute();
    }

    private class CarregarServTask extends AsyncTask<String, Void, List<Servico>> {
        private ProgressDialog dialog;
        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(CorteActivity.this);
            dialog.show();
        }


        @Override
        protected void onPostExecute(List<Servico> servicos) {
            try {
                if (servicos != null) {
                    servs = servicos;
                    adapter = new CorteArrayAdapter(getBaseContext(),0,servicos,CorteActivity.this);

                    lista.setAdapter(adapter);
                }


                dialog.dismiss();
            }catch(Exception e){
                e.printStackTrace();
                }

        }

        @Override
        protected List<Servico> doInBackground(String... params) {
            ServicoService ss = new ServicoService();
            List<Servico> asd = ss.getServicos();
            System.out.println(asd.get(0).getDescricao() + asd.get(0).getCamFoto() + asd.get(0).getId() + asd.get(0).getTempoDuracao() +
            asd.get(0).getValor());

            return ss.getServicos();
        }
    }


}
