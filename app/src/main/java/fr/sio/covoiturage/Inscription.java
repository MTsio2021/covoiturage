package fr.sio.covoiturage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Inscription extends AppCompatActivity{


    Button bValider;
    EditText etPrenom;
    EditText etNom;
    EditText etMail;
    EditText etNumber;
    EditText etVille;
    Modele mod = new Modele();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription);



        etNom = (EditText) findViewById(R.id.et_nom);
        etPrenom = (EditText) findViewById(R.id.et_prenom);
        etMail = (EditText) findViewById((R.id.et_mail));
        etNumber = (EditText) findViewById(R.id.et_number);
        etVille = (EditText) findViewById(R.id.et_ville);
        bValider = (Button) findViewById((R.id.idValider));


    }



    public void bValider(View vue) {

        String nom = etNom.getText().toString() ;
        String prenom = etPrenom.getText().toString() ;
        String mail = etMail.getText().toString();
        String tel = etNumber.getText().toString();
        String pseudo = nom.substring(0,1) + prenom;
        String ville = etVille.getText().toString();
        String mdp = mod.genMdp();
        String message = new String ("Inscription réussie "+ " "+ pseudo);

        Utilisateur prof1 = new Utilisateur(nom,prenom,mail,tel,mdp,ville,pseudo,false);

        mod.ajouterUnProf(nom,prenom,mail,tel,mdp,ville,pseudo);

        Intent i = new Intent(this, InscriValid.class);
        i.putExtra("profinscri", mod.passageGson(prof1));
        startActivity(i);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }



}
