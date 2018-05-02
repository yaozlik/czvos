package mx.com.cocodrilozone.czvos.activity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import mx.com.cocodrilozone.czvos.R;


public class FotoActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_ASK_PERMISSIONS = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);
        findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    public void open2(final View view) {
         AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final CharSequence[] items = new CharSequence[5];

        items[0] = "Foto Ticket";
        items[1] = "Foto Concurso";
        items[2] = "Foto Cliente con premio";
        items[3] = "Acuse Firmado Por Cliente";
        items[4] = "INE";

        builder.setTitle("Tipo de Foto")

                .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                      /*  Toast.makeText(
                                FotoActivity.this,
                                "Seleccionaste: " + items[which],
                                Toast.LENGTH_SHORT)
                                .show();
                      **/

                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public void open(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Seleccionar Imagenes");
        alertDialogBuilder.setMessage("Elija como subir imagenes");
                alertDialogBuilder.setPositiveButton("Camara",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                //Toast.makeText(FotoActivity.this,"Abrir camara",Toast.LENGTH_LONG).show();
                                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {

                                    //Toast.makeText(FotoActivity.this, "This version is not Android 6 or later " + Build.VERSION.SDK_INT, Toast.LENGTH_LONG).show();

                                } else {

                                    int hasWriteContactsPermission = checkSelfPermission(Manifest.permission.CAMERA);

                                    if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {

                                        requestPermissions(new String[] {Manifest.permission.CAMERA},
                                                REQUEST_CODE_ASK_PERMISSIONS);

                                       // Toast.makeText(FotoActivity.this, "Solicitando permisos", Toast.LENGTH_LONG).show();

                                    }else if (hasWriteContactsPermission == PackageManager.PERMISSION_GRANTED){

                                        //Toast.makeText(FotoActivity.this, "The permissions are already granted ", Toast.LENGTH_LONG).show();
                                        openCamera();

                                    }

                                }

                                return;
                            }
                        });

        alertDialogBuilder.setNegativeButton("Galeria",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(FotoActivity.this,"Abrir galeria",Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if(REQUEST_CODE_ASK_PERMISSIONS == requestCode) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //Toast.makeText(this, "OK Permissions granted ! :-) " + Build.VERSION.SDK_INT, Toast.LENGTH_LONG).show();
                openCamera();
            } else {
              //  Toast.makeText(this, "Permissions are not granted ! :-( " + Build.VERSION.SDK_INT, Toast.LENGTH_LONG).show();
            }
        }else{
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }


    private void openCamera() {

        //textView.setText("Thanks !!!");

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);

    }
}
