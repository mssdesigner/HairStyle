package pap.hairstyle;

import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import android.widget.TextView;
import android.view.View;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import pap.hairstyle.entity.Funcionario;

/**
 * Created by vinicius on 29/10/16.
 */

public class AgendamentoActivity extends AppCompatActivity {
    private Intent intencao;


    private CalendarView calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agendamento);

        intencao = getIntent();
        Bundle info = intencao.getExtras();
        Funcionario func = (Funcionario)info.getSerializable("funcionario");
        System.out.println("funcionario ----" + func.getNome());

        ((TextView) findViewById(R.id.txtCadastro)).setText(func.getNome());



        calendar = ((CalendarView) findViewById(R.id.calendarView));
        Date today = new Date();
        calendar.setMinDate(today.getTime());

    }


    public void pegarDataEscolhida(View view){
        Long data = calendar.getDate();
       // System.out.println("passou aqui");
      //  DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
      //  Date date = new Date(data);
      //  System.out.println("essa data escolhida : " + df.format(date));


        Bundle info = intencao.getExtras();
        info.putLong("dataEsc",data);

        Intent intent = new Intent(this,HorarioActivity.class);
        intent.putExtras(info);
        startActivity(intent);
    }

}
