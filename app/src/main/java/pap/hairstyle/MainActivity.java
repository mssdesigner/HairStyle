package pap.hairstyle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irParaTelaInicial(View view){
        Intent intencao = new Intent(this,LoginActivity.class);
        startActivity(intencao);
    }

    public void abreLista(View view){
        Intent intencao = new Intent(this,CabeleireiroActivity.class);
        startActivity(intencao);
    }

}
