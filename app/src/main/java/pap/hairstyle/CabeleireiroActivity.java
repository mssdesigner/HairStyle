package pap.hairstyle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import pap.hairstyle.entity.Cabelereiro;
import pap.hairstyle.service.CabelereiroService;


/**
 * Created by Renan on 22/10/2016.
 */

public class CabeleireiroActivity extends AppCompatActivity {

    private String nomeCabelereiro = null;
   /* private Cabelereiro cabelereiro = null;
    private CabelereiroService cs = null; */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cabeleireiro);
    }
    /*
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cabelereiro);

        List<Cabelereiro> cabelereiros = new ArrayList<Cabelereiro>();
        ArrayAdapter<CabelereiroActivity> adapter = new ArrayAdapter<CabelereiroActivity>(this, android.R.layout.simple_list_item_1, cabelereiros);

        ListView listaCabelereiro = (ListView) findViewById(R.id.listviewCabelereiro);
        cabelereiros.add(cabelereiro.getNomeCabelereiro());
    }

    @Override
    protected Void doInBackground(String... params) {
        cabelereiro = cs.getCabelereiro();
        cabelereiro.setNomeCabelereiro(cs.getCabelereiro().getNomeCabelereiro());

        return null;
     } */
}

