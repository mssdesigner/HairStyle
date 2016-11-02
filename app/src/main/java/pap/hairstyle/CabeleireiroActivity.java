package pap.hairstyle;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import pap.hairstyle.entity.Funcionario;
import pap.hairstyle.service.CabelereiroService;
import pap.hairstyle.service.FacadeService;


/**
 * Created by Renan on 22/10/2016.
 */

public class CabeleireiroActivity extends AppCompatActivity {

    private ArrayAdapter<Funcionario> adapter;
    ListView lista;

    List<Funcionario> funcs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_cabeleireiro);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lista = (ListView) findViewById(R.id.listviewcabeleireiros);
        carregarDados();

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>parent, View view, int position,long id){

               Bundle bundle = new Bundle();
               // bundle.putString("funcionario",nomeFunc);
                bundle.putSerializable("funcionario", funcs.get(position));
                Intent intencao = new Intent(CabeleireiroActivity.this,CorteActivity.class);
                intencao.putExtras(bundle);
                startActivity(intencao);

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
        new CarregarFuncTask().execute();
    }

    private class CarregarFuncTask extends AsyncTask<String, Void, List<Funcionario>> {
        private ProgressDialog dialog;
        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(CabeleireiroActivity.this);
            dialog.show();
        }
  /*      @Override
        protected void onPostExecute(List<Funcionario> funcionarios) {
            if(funcionarios != null){
                nomes = new ArrayList();
                for(int i =0; i< funcionarios.size();i++){
                    nomes.add(funcionarios.get(i).getNome());
                }
                adapter = new ArrayAdapter<String>(CabeleireiroActivity.this,android.R.layout.simple_list_item_1,nomes);
                lista.setAdapter(adapter);
            }



            dialog.dismiss();


        }
        */

        @Override
        protected void onPostExecute(List<Funcionario> funcionarios) {
            if(funcionarios != null){
                funcs = funcionarios;
                adapter = new FuncionarioArrayAdapater(getBaseContext(),0,funcionarios,CabeleireiroActivity.this);
                lista.setAdapter(adapter);
            }



            dialog.dismiss();


        }

        @Override
        protected List<Funcionario> doInBackground(String... params) {
            FacadeService fs = new FacadeService();
            return fs.getCs().getCabelereiro();
        }
    }
}

