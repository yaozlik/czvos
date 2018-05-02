package mx.com.cocodrilozone.czvos.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import mx.com.cocodrilozone.czvos.R;

public class ListaActivity  extends AppCompatActivity{
    private ListView list;
    private String[] sistemas = {"Oscar Fernández", "Arturo Flores", "David Romero", "Daniel Delgado", "Aarón Rodriguez",
            "Omar Onofre", "Hugo Tejada", "Elizabeth Garcia", "Manuel Pérez", "Martin Centeno"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        ListView list = findViewById(R.id.lstParticipante);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sistemas);
        list.setAdapter(adaptador);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
               /* Toast.makeText(getApplicationContext(), "Ha pulsado el item " + position, Toast.LENGTH_SHORT).show();*/
                Intent intent=new Intent(getApplicationContext(),MenuActivity.class);
                startActivityForResult(intent, 0);

            }

        });
    }

}
