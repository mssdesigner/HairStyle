package pap.hairstyle;

import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import pap.hairstyle.entity.Funcionario;

/**
 * Created by vinicius on 29/10/16.
 */

public class AgendamentoActivity extends AppCompatActivity {

    private CalendarView calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agendamento);

        Intent intencao = getIntent();
        Bundle info = intencao.getExtras();
        Funcionario func = (Funcionario)info.getSerializable("funcionario");
        System.out.println("funcionario ----" + func.getNome());

        ((TextView) findViewById(R.id.txtCadastro)).setText(func.getNome());



        calendar = ((CalendarView) findViewById(R.id.calendarView));
        Date today = new Date();
        calendar.setMinDate(today.getTime());

    }
}
