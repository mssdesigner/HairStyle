package pap.hairstyle;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import pap.hairstyle.entity.Cliente;
import pap.hairstyle.service.ClienteService;

/**
 * Created by Renan on 18/10/2016.
 */

public class LoginActivity extends AppCompatActivity {

    private Cliente c = null;
    private ClienteService cs = new ClienteService();
    private String email = null;
    private String senha = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);
    }


    public void irParaTelaDeCadastro(View view) {
        Intent intencao = new Intent(this, CadastroActivity.class);
        startActivity(intencao);
    }


    public void fazerLogin(View view){
        email = ((EditText) findViewById(R.id.editTextLoginEmail)).getText().toString();
        senha = ((EditText) findViewById(R.id.editTextLoginSenha)).getText().toString();
        new FazerLoginTask().execute();

        System.out.println("Executa depois da thread");
    }

    private class FazerLoginTask extends AsyncTask<String, Void, Void> {
        private ProgressDialog dialog;
        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(LoginActivity.this);
            dialog.show();
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            dialog.dismiss();
            try {
                if (c != null) {
                    Intent intencao = new Intent(LoginActivity.this,CabeleireiroActivity.class);
                    startActivity(intencao);
                } else {
                    Toast toast = Toast.makeText(LoginActivity.this, "Erro Ao efetuar Login", Toast.LENGTH_SHORT);
                }
            }catch (Exception e){
                Toast toast = Toast.makeText(LoginActivity.this, "Erro Ao efetuar Login", Toast.LENGTH_SHORT);
            }

        }

        @Override
        protected Void doInBackground(String... params) {
            c = cs.getClienteEmailESenha(email,senha);
            System.out.println("" + c.getNome());


            return null;
        }
    }

}
