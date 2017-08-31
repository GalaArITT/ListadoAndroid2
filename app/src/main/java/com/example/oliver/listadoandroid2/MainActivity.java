package com.example.oliver.listadoandroid2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado);

        ArrayList<Lista_entrada> datos = new ArrayList<Lista_entrada>();

        //Lista_entrada (int idImagen, String textoEncima, String textoDebajo)
        datos.add(new Lista_entrada(R.drawable.itt,"ABREGO DELGADO ALEXIA ARIANA", "No Control: 13400378 Carrera: ISC"));
        datos.add(new Lista_entrada(R.drawable.itt,"CARO LOPEZ LUIS RICARDO", "No Control: 13400395 Carrera: ISC"));
        datos.add(new Lista_entrada(R.drawable.itt,"CARVAJAL GUTIERREZ RAUL RAFAEL", "No Control: 13400396 Carrera: ISC"));
        datos.add(new Lista_entrada(R.drawable.itt,"CASILLAS UREÑA FERMIN MICHET", "No Control: 13400256 Carrera: ISC"));
        datos.add(new Lista_entrada(R.drawable.itt,"CRESPO DURAN PABLO ARTURO", "No Control: 13400397 Carrera: ISC"));
        datos.add(new Lista_entrada(R.drawable.itt,"ESPINO SERRANO CESAR RAMSES", "No Control: 13400402 Carrera: ISC"));
        datos.add(new Lista_entrada(R.drawable.itt,"ESPINOZA ORONIA CARLOS EDUARDO", "No Control: 12401119 Carrera: ISC"));
        datos.add(new Lista_entrada(R.drawable.itt,"FREGOSO CORONA JESUS EDUARDO", "No Control: 13400405 Carrera: ISC"));
        datos.add(new Lista_entrada(R.drawable.itt,"GALAVIZ ARROYO OLIVER JASIEL", "No Control: 13400406 Carrera: ISC"));
        datos.add(new Lista_entrada(R.drawable.itt,"GALINDO DELGADO DONADONY DONAJI", "No Control: 13400408 Carrera: ISC"));
        datos.add(new Lista_entrada(R.drawable.itt,"GONZALEZ CASTELLANOS EDGAR FABRIZIA", "No Control: 13400419 Carrera: ISC"));
        datos.add(new Lista_entrada(R.drawable.itt,"HERNANDEZ SANDOVAL ABRIL YARELI", "No Control: 13400430 Carrera: ISC"));
        datos.add(new Lista_entrada(R.drawable.itt,"JIMENEZ ORTIZ JUAN DANIEL", "No Control: 13400436 Carrera: ISC"));
        datos.add(new Lista_entrada(R.drawable.itt,"LIZOLA CHAVARÍN LUIS FERNANDO", "No Control: 13400441 Carrera: ISC"));
        datos.add(new Lista_entrada(R.drawable.itt,"MEDRANO BARAJAS JUAN DANIEL", "No Control: 13400457 Carrera: ISC"));
        datos.add(new Lista_entrada(R.drawable.itt,"RAMIREZ GARCIA JUAN RAMON", "No Control: 13400478 Carrera: ISC"));
        datos.add(new Lista_entrada(R.drawable.itt,"RODRIGUEZ ADAME OLIVER GIOVANNY", "No Control: 13400507 Carrera: ISC"));
        datos.add(new Lista_entrada(R.drawable.itt,"SANCHEZ JIMENEZ ANA PATRICIA", "No Control: 13400491 Carrera: ISC"));
        datos.add(new Lista_entrada(R.drawable.itt,"VALDEZ CORREA CARLOS GERMAN", "No Control: 13400322 Carrera: ITIC"));
        datos.add(new Lista_entrada(R.drawable.itt,"CARRILLO GONZÁLEZ CARLOS ARTURO", "No Control: 13401087 Carrera: ITIC"));
        datos.add(new Lista_entrada(R.drawable.itt,"HERNANDEZ BAEZA JAVIER", "No Control: 13401367 Carrera: ITIC"));
        datos.add(new Lista_entrada(R.drawable.itt,"MARIN BAUTISTA IRVING ALDAHYR", "No Control: 13400663 Carrera: ITIC"));
        datos.add(new Lista_entrada(R.drawable.itt,"OCAMPO AGUILAR JESÚS ANDRÉS", "No Control: 13401100 Carrera: ITIC"));
        datos.add(new Lista_entrada(R.drawable.itt,"SALAZAR NAVARRO IRAN JAIR", "No Control: 13400309 Carrera: ITIC"));
        datos.add(new Lista_entrada(R.drawable.itt,"TEJEDA MORA CESAR", "No Control: 13401105 Carrera: ITIC"));
        lista = (ListView) findViewById(R.id.ListView_listado);
        lista.setAdapter(new Lista_adaptador(this, R.layout.entrada, datos) {
            @Override
            public void onEntrada(Object entrada, View view) {
                if (entrada!=null){

                    TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior);
                    if (texto_superior_entrada != null)
                        texto_superior_entrada.setText(((Lista_entrada) entrada).get_textoEncima());

                    TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior);
                    if (texto_inferior_entrada != null)
                        texto_inferior_entrada.setText(((Lista_entrada) entrada).get_textoDebajo());

                    ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen);
                    if (imagen_entrada != null)
                        imagen_entrada.setImageResource(((Lista_entrada) entrada).get_idImagen());
                }

            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                Lista_entrada elegido = (Lista_entrada) pariente.getItemAtPosition(posicion);

                CharSequence texto = "Seleccionado: " + elegido.get_textoDebajo();
                Toast toast = Toast.makeText(MainActivity.this, texto, Toast.LENGTH_LONG);
                toast.show();

            }
        });
    }
}
