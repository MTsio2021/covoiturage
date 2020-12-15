package fr.sio.covoiturage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ProfilProf extends AppCompatActivity {


    TextView mesAccueilProf;
    Modele mod = new Modele();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_prof);


        mesAccueilProf = (TextView) findViewById(R.id.mesAccueilProf);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonProf = this.getIntent().getStringExtra("prof");
        Utilisateur pf1 = gson.fromJson(jsonProf, Utilisateur.class);

        mesAccueilProf.setText("Connecté en tant que "+pf1.afficherProf()+ mod.isAdmin(pf1));


    }
}