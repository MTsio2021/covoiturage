package fr.sio.covoiturage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.w3c.dom.Text;

public class InscriValid extends AppCompatActivity {

    TextView dataProf;
    TextView villeProf;
    TextView mdpProf;
    Button bAccueil;
    Modele mod = new Modele();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscri_valid);


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonProf = this.getIntent().getStringExtra("profinscri");
        Utilisateur pf1 = gson.fromJson(jsonProf, Utilisateur.class);

        dataProf = (TextView) findViewById(R.id.dataProf);
        villeProf = (TextView) findViewById(R.id.villeProf);
        bAccueil = (Button) findViewById((R.id.idAccueil));
        mdpProf = (TextView) findViewById(R.id.mdpProf);

        dataProf.setText("Vous êtes : " + pf1.afficherProf());
        villeProf.setText("Vous résidé à : " + pf1.villeClient());
        mdpProf.setText("Votre mot de passe est : " + pf1.getMdp());

        }

        public void bAccueil(View vue){
            Intent accueil = new Intent(this, MainActivity.class);
            startActivity(accueil);
            Toast.makeText(this,"Retour à l'accueil.", Toast.LENGTH_LONG).show();

        }


    }
