package pap.hairstyle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import pap.hairstyle.entity.Agendamento;
import pap.hairstyle.entity.Funcionario;
import pap.hairstyle.entity.Servico;

/**
 * Created by vinicius on 02/11/16.
 */

public class ReservaActivity extends AppCompatActivity {
    private Bundle info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reserva);

        Intent intencao = getIntent();
        info = intencao.getExtras();

        Funcionario f = (Funcionario) info.getSerializable("funcionario");
        ((TextView) findViewById(R.id.nomeCabeleireiro)).setText(f.getNome());

        Servico s = (Servico) info.getSerializable("Servico");
        ((TextView) findViewById(R.id.precocorte)).setText("R$ " + String.valueOf(s.getValor() + "0"));

        Agendamento a = (Agendamento) info.getSerializable("agendamento");
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String data = df.format(a.getDataHoraIni());
        ((TextView) findViewById(R.id.data)).setText(data);

        df = new SimpleDateFormat("HH:mm");

        String hora = df.format(a.getDataHoraIni());
        ((TextView) findViewById(R.id.horario)).setText(hora);


    }


    public void confirmadoReserva(View view){
        Intent intencao = new Intent(this,PagamentoActivity.class);
        intencao.putExtras(info);
        startActivity(intencao);
    }

}
