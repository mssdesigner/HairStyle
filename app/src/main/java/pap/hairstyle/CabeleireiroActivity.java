package pap.hairstyle;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_cabeleireiro);
        carregarDados();
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
                List<String> nomes = new ArrayList();
                for(int i =0; i< funcionarios.size();i++){
                    nomes.add(funcionarios.get(i).getNome());
                }
                adapter = new ArrayAdapter<String>(CabeleireiroActivity.this,android.R.layout.simple_list_item_1,nomes);
                ((ListView) findViewById(R.id.listviewcabeleireiros)).setAdapter(adapter);
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
