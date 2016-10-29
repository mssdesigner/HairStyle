package pap.hairstyle;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import pap.hairstyle.entity.Cliente;
import pap.hairstyle.entity.Telefone;
import pap.hairstyle.service.ClienteService;
import pap.hairstyle.service.TelefoneService;

/**
 * Created by Renan on 18/10/2016.
 */

public class CadastroActivity extends AppCompatActivity {

    private ClienteService cs = new ClienteService();
    private Cliente c;
    private TelefoneService ts = new TelefoneService();
    private Telefone t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);
    }

    public void fazerCadastro(View view){
        c = new Cliente();

        c.setNome(((EditText) findViewById(R.id.editTextNome)).getText().toString());
        c.setEmail (((EditText) findViewById(R.id.editTextEmail)).getText().toString());
        c.setSenha(((EditText) findViewById(R.id.editTextSenha)).getText().toString());
        c.setCpf(((EditText) findViewById(R.id.editTextCPF)).getText().toString());
        t = new Telefone();
        t.setNumero(((EditText) findViewById(R.id.editTextTelefone)).getText().toString());

        new CadastrarMeuClienteTask().execute();




    }


    private class CadastrarMeuClienteTask extends AsyncTask<String, Void, Void> {
        private ProgressDialog dialog;
        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(CadastroActivity.this);
            dialog.show();
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            ((EditText) findViewById(R.id.editTextNome)).setText("");
            ((EditText) findViewById(R.id.editTextCPF)).setText("");
            ((EditText) findViewById(R.id.editTextTelefone)).setText("");
            ((EditText) findViewById(R.id.editTextSenha)).setText("");
            ((EditText) findViewById(R.id.editTextEmail)).setText("");
            ((EditText) findViewById(R.id.editTextConfSenha)).setText("");

            dialog.dismiss();
        }
        @Override
        protected Void doInBackground(String... params) {

            c = cs.post(c);
            t.setCliente(c);
            t = ts.post(t);
            return null;
        }
    }

}
