package pap.hairstyle;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.system.ErrnoException;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.net.ConnectException;

import pap.hairstyle.entity.Cliente;
import pap.hairstyle.service.ClienteService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);
    }

    private Cliente c = new Cliente();
    private ClienteService cs = new ClienteService();
    private String email = "";
    private String senha = "";

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
            dialog = new ProgressDialog(MainActivity.this);
            dialog.show();
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            dialog.dismiss();
            try {
                if (c != null) {
                    Intent intencao = new Intent(MainActivity.this,CabeleireiroActivity.class);
                    startActivity(intencao);
                } else {
                    Toast toast = Toast.makeText(MainActivity.this, "Falha ao efetuar Login", Toast.LENGTH_SHORT);
                    toast.show();
                }
            } catch(RuntimeException re) {
                re.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        @Override
        protected Void doInBackground(String... params) {
            try {
                c = cs.getClienteEmailESenha(email, senha);
                System.out.println("" + c.getNome());
            } catch(RuntimeException re) {
                System.out.printf("Teste de erro RunTimeException");

            }catch (Exception e){
                System.out.println("teste de erro Exception");
            }

            return null;
        }
    }



}
