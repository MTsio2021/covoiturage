package fr.sio.covoiturage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bInscrire = (Button) findViewById(R.id.idInscription);
        bInscrire.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                openInscription();
            }
        });
    }
    Button bInscrire;

    public void bConnexion(View vue){

        Intent i = new Intent(this, Connexion.class);
        startActivity(i);
        String message = new String("Se connecter");
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }

    public void bInscrire(View vue){
        String message = new String("S'inscrire'");
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }

    public void bPropos(View vue){
        String message = new String("Consulter à propos");
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }




    public void openInscription(){
        Intent i = new Intent(this,Inscription.class);
        startActivity(i);
    }
}