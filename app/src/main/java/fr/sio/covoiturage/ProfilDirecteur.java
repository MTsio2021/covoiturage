package fr.sio.covoiturage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ProfilDirecteur extends AppCompatActivity {

    TextView mesAccueilDir;
    Button bConsulter;
    Modele mod = new Modele();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_directeur);


        mesAccueilDir = (TextView) findViewById(R.id.mesAccueilDir);
        bConsulter = (Button) findViewById(R.id.idConsulteProf);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonProf = this.getIntent().getStringExtra("prof");
        Utilisateur directeur = gson.fromJson(jsonProf, Utilisateur.class);

        mesAccueilDir.setText("Connecté en tant que "+directeur.afficherProf()+ mod.isAdmin(directeur));

    }

    public void bConsulter(View vue){

        Intent i = new Intent(this, ListeProfs.class);
        startActivity(i);
        String message = new String("Accès à la liste.");
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();

    }
}