package pap.hairstyle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
