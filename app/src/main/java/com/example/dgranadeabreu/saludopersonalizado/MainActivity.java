package com.example.dgranadeabreu.saludopersonalizado;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.CompoundButton;


public class MainActivity extends Activity {
    EditText texto;
    TextView n2;
    Button botonSaludo;
    RadioButton sr,sra;
    RadioGroup grupo;
    CheckBox box;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //instanciar elementos
        texto =(EditText) findViewById(R.id.entrada);
        n2 =(TextView) findViewById(R.id.saludo);
        botonSaludo=(Button) findViewById(R.id.b_saludo);
        sr=(RadioButton)findViewById(R.id.radiosr);
        sra=(RadioButton)findViewById(R.id.radiosra);
        grupo=(RadioGroup)findViewById(R.id.radioGrupo);
        box=(CheckBox)findViewById(R.id.checkBox);

        //intento necesario para llamar a la segunda clase,pasarle cosas...
        //el intent sirve para cambiar de activity de una a otra
        String salutation="adios";
        final Intent intento=new Intent(MainActivity.this,SecondActivity.class);
        intento.putExtra("saludo",salutation);

        //Mandar datos a otra clase,el bundle es una especie de array,un CONTENEDOR
        Bundle recipiente=new Bundle();
        recipiente.putInt("edad",35);
        recipiente.putString("nombre","damian");
        intento.putExtras(recipiente);
        //otro modo de enviar,creando un objeto de una clase que cree yo mismo
        Miclase persona1=new Miclase("Jose",15);
        intento.putExtra("id1",persona1);


        //al Hacer click en el boton...
        botonSaludo.setOnClickListener(new View.OnClickListener()
             {
                @Override
                public void onClick(View v)
                {

                    if ("".equals(texto.getText().toString().trim()))
                    {
                        //mostrar toast
                        showToast();
                        return;
                    }
                    String salutation = null;
                    String enteredName = texto.getText().toString();
                    // referencia al radioButton
                    if (R.id.radiosr == grupo.getCheckedRadioButtonId())
                    {
                        salutation = getResources().getString(R.string.radiosr).toLowerCase();
                    } else
                    {
                        salutation = getResources().getString(R.string.radiosra).toLowerCase();
                    }
                    salutation = getResources().getString(R.string.b_saludo) + " " + salutation + " " + enteredName;
                    // obtención de la hora y fecha
                    if (box.isChecked())
                    {
                        DatePicker date = (DatePicker) findViewById(R.id.datePicker);
                        String dateToShow = date.getDayOfMonth() + "/" + (date.getMonth() + 1) + "/" + date.getYear();
                        TimePicker time = (TimePicker) findViewById(R.id.timePicker);
                        dateToShow += " " + time.getCurrentHour() + ":" + time.getCurrentMinute();
                       //salutation += " " + dateToShow;
                    }
                    startActivityForResult(intento,1);

                }
            });


        // Mostrar o no las fechas
        box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int visibility = isChecked ? View.VISIBLE : View.GONE;
                View view = findViewById(R.id.timePicker);
                view.setVisibility(visibility);
                view = findViewById(R.id.datePicker);
                view.setVisibility(visibility);
            }
        });

    }
    public void showToast(String mensaje)
    {
        Context contexto=getApplicationContext();
        int duracion= Toast.LENGTH_SHORT;
        Toast tostada=Toast.makeText(contexto,mensaje,duracion);
        tostada.show();

    }
    public void showToast()
    {
        Context contexto=getApplicationContext();
        int duracion= Toast.LENGTH_SHORT;
        Toast tostada=Toast.makeText(contexto,"Error en el Toast",duracion);
        tostada.show();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void onActivityResult(int reqC,int resC,Intent data)
    {
        if (reqC==1)//reqc es el valor que le pasamos al starActivytyForresult
        {

        }
        if (resC==RESULT_OK)//es la constante que le pasamos
        {

        }

        String MiRespuesta=data.getExtras().getString("id1");
        showToast(MiRespuesta);

    }
}
