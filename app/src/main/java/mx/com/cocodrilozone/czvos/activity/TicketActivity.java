package mx.com.cocodrilozone.czvos.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import mx.com.cocodrilozone.czvos.R;


public class TicketActivity extends AppCompatActivity {
    private ListView list;
    private String[] ticket = {"Ticket 1    $748    26/04/2018", "Ticket 2    $748    30/04/2018", "Ticket 3    $748    01/05/2018"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        ListView list = findViewById(R.id.lstTicket);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ticket);
        list.setAdapter(adaptador);
        findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

