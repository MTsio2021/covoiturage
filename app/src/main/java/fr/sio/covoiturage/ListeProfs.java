package fr.sio.covoiturage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListeProfs extends AppCompatActivity implements AdapterView.OnItemClickListener{

    TextView tvSelection ;
    ListView lvProfs ;
    Modele mod = new Modele();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_profs);

        tvSelection = ( TextView ) findViewById( R.id.idTvSelection ) ;
        lvProfs = ( ListView ) findViewById( R.id.idLvProfs ) ;
        mod.peupler();

        tvSelection.setText("Aucune enseignant séléctionné.");


        ArrayAdapter<Utilisateur> adaptater = new ArrayAdapter<Utilisateur>(
                this ,
                android.R.layout.simple_list_item_1 , mod.getListeUtilisateurs()) ;
        lvProfs.setAdapter( adaptater ) ;


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Utilisateur utilSelect = mod.getListeUtilisateurs().get(position);
        tvSelection.setText( "Enseignant sélectionné : " + utilSelect.afficherProf());

    }
}