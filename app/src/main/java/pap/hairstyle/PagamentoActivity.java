package pap.hairstyle;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import pap.hairstyle.entity.Agendamento;
import pap.hairstyle.entity.Cliente;
import pap.hairstyle.entity.Funcionario;
import pap.hairstyle.entity.Pagamento;
import pap.hairstyle.entity.Servico;
import pap.hairstyle.service.FacadeService;

/**
 * Created by vinicius on 02/11/16.
 */

public class PagamentoActivity extends AppCompatActivity {
        private Bundle info;
        private RadioButton pagLocal;
        private RadioButton pagCartao;
        private FacadeService fs = new FacadeService();
        private Cliente c = new Cliente();
        private Agendamento a = new Agendamento();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.pagamento);

            Intent intencao = getIntent();
            info = intencao.getExtras();
            pagLocal = ((RadioButton) findViewById(R.id.dinheiro));
            pagCartao = ((RadioButton) findViewById(R.id.cartao));



        }

    public void pagamentoLocal(){

    }

    public void escolherPagamento(View view){
        if(pagCartao.isChecked()){
            Intent in = new Intent(this,PagamentoCartaoActivity.class);
            in.putExtras(info);
            startActivity(in);
        }else if (pagLocal.isChecked()){
            new CadastrarMeuAgendamentoTask().execute();
        }
    }


    private class CadastrarMeuAgendamentoTask extends AsyncTask<String, Void, Void> {
        private ProgressDialog dialog;
        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(PagamentoActivity.this);
            dialog.show();
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            //Toast toast = Toast.makeText(PagamentoActivity.this,"Agendamento reservado com sucesso",Toast.LENGTH_SHORT);
            //toast.show();

            dialog.dismiss();
        }
        @Override
        protected Void doInBackground(String... params) {


            a = (Agendamento) info.getSerializable("agendamento");
            a.setCliente((Cliente) info.getSerializable("Cliente"));
            a.setHoraMarcada('y');
            a.setFunc((Funcionario) info.getSerializable("funcionario"));

            a.setValorTotal(((Servico) info.getSerializable("Servico")).getValor());
            System.out.println("" + a.getId());
            a = fs.getAs().post(a);



            return null;
        }
    }

}
