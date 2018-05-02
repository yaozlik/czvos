package mx.com.cocodrilozone.czvos.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import mx.com.cocodrilozone.czvos.R;
import mx.com.cocodrilozone.czvos.api.LoginApi;
import mx.com.cocodrilozone.czvos.dto.LoginDTO;


public class MainActivity extends AppCompatActivity {

    private LoginApi loginApi;
    private LoginDTO login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginApi = new LoginApi();
        login = new LoginDTO();
        //TODO: obtener el usuario y password de los edittext :D
        login.setUser("user");
        login.setPassword("password");
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginApi.processLogin(login, MainActivity.this);
                Intent intent = new Intent(v.getContext(), CheckInActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    public void getResponse(String response){
        Log.d("reply", response);
    }

}
