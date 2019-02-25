package co.idn.intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spIntent = findViewById(R.id.sp_intent);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.intents, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spIntent.setOnItemSelectedListener(this);
        spIntent.setAdapter(adapter);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = null;
        switch (i) {
            case 0:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.vogella.com"));
                break;
            case 1:
                intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:(+49)12345789"));
                break;
            case 2:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:50.123,7.1434?z=19"));
                break;
            case 3:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:0,0?q=query"));
                break;
            case 4:
                intent = new Intent("android.media.action.IMAGE_CAPTURE");
                break;
            case 5:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("content://contacts/people/"));
                break;
//            case 6:
//                intent = new Intent(Intent.ACTION_EDIT,
//                        Uri.parse("content://contacts/people/1"));
//                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
