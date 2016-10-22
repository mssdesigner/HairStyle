package pap.hairstyle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by Renan on 22/10/2016.
 */

public class CabelereiroActivity extends AppCompatActivity {

    private String nomeCabelereiro = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cabelereiro);

        List<CabelereiroActivity> cabelereiros = ();
        ArrayAdapter<CabelereiroActivity> adapter = new ArrayAdapter<CabelereiroActivity>(this, android.R.layout.simple_list_item_1, cabelereiros);

        ListView listaCabelereiro = (ListView) findViewById(R.id.listviewCabelereiro);
    }


}
