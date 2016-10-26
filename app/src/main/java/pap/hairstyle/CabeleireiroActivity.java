package pap.hairstyle;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import pap.hairstyle.entity.Funcionario;
import pap.hairstyle.service.CabelereiroService;


/**
 * Created by Renan on 22/10/2016.
 */

public class CabeleireiroActivity extends AppCompatActivity {

    private ArrayAdapter<String> adapter;
    ListView lista;
    String nomeFunc = "";
    List<String> nomes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_cabeleireiro);

        lista = (ListView) findViewById(R.id.listviewcabeleireiros);
        carregarDados();

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>parent, View view, int position,long id){
                String nomeFunc = nomes.get(position);
                Bundle bundle = new Bundle();
                bundle.putString("funcionario",nomeFunc);

                Intent intencao = new Intent(CabeleireiroActivity.this,CorteActivity.class);
                intencao.putExtras(bundle);
                startActivity(intencao);

            }

        });



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
        @Override
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

        @Override
        protected List<Funcionario> doInBackground(String... params) {
            CabelereiroService cs = new CabelereiroService();
            return cs.getCabelereiro();
        }
    }
}

