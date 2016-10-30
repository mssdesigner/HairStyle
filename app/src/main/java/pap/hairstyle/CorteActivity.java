package pap.hairstyle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
<<<<<<< HEAD
import android.view.Menu;
import android.view.MenuItem;
=======
>>>>>>> master
import android.view.View;
import android.content.Intent;

import pap.hairstyle.entity.Funcionario;

/**
 * Created by Renan on 18/10/2016.
 */

public class CorteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cortes);
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

    public void escolherCorte(View view){
        Intent intencao = getIntent();
        Bundle info = intencao.getExtras();


        info.putString("corte","corteEscolhido");


        Intent intent = new Intent(this,AgendamentoActivity.class);
        intent.putExtras(info);

        startActivity(intent);
    }

    public void escolherCorte(View view){
        Intent intencao = getIntent();
        Bundle info = intencao.getExtras();


        info.putString("corte","corteEscolhido");


        Intent intent = new Intent(this,AgendamentoActivity.class);
        intent.putExtras(info);

        startActivity(intent);
    }
}
