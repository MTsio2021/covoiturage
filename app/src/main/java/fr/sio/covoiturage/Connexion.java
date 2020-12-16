package fr.sio.covoiturage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaTimestamp;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Connexion extends AppCompatActivity {

    EditText etMdp;
    EditText etLogin;
    Button bConnexion;
    TextView refusCo;
    Modele mod = new Modele();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        etMdp = (EditText) findViewById(R.id.etMdp);
        etLogin = (EditText) findViewById(R.id.etLogin);
        bConnexion = (Button) findViewById(R.id.idConnexion);
        refusCo = (TextView) findViewById(R.id.refusConnexion);


        refusCo.setText(mod.getListeUtilisateurs().toString());


    }

    public void bConnexion(View vue){
        String pseudo = etLogin.getText().toString();
        String mdp = etMdp.getText().toString();
        String message = new String ("Connexion réussie "+ " "+ pseudo);


        mod.peupler();



        if (mod.connexion(pseudo,mdp) != null){

            Utilisateur pf1 = mod.connexion(pseudo,mdp);

            if(pf1.isDirecteur() == true) {

                Intent i = new Intent(this, ProfilDirecteur.class);
                i.putExtra("prof", mod.passageGson(pf1));
                startActivity(i);
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
            else{
                Intent i = new Intent(this, ProfilProf.class);
                i.putExtra("prof", mod.passageGson(pf1));
                startActivity(i);
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }

        }
        else{
            refusCo.setText("Connexion refusée, réessayer.");
        }

    }
}