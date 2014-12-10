package com.example.dgranadeabreu.saludopersonalizado;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;


public class SecondActivity extends Activity {
    Button btnHola;
    Button btnAdios;
    TextView mensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnHola=(Button)findViewById(R.id.button);
        btnAdios=(Button)findViewById(R.id.button2);
        mensaje=(TextView)findViewById(R.id.textView);

        mensaje.setText(getIntent().getStringExtra("idNombre"));
        btnHola.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent();
                i.putExtra("id1",((Button) findViewById(R.id.button)).getText());
                setResult(RESULT_OK, i);
                finish();
            }
        });
        btnAdios.setOnClickListener(new View.OnClickListener()
        {
                 public void onClick(View v)
                 {
                     Intent i=new Intent();
                     i.putExtra("id1",((Button) findViewById(R.id.button2)).getText());
                     setResult(RESULT_OK, i);
                     finish();
                 }
        }
        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
