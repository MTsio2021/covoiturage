package fr.sio.covoiturage;

import android.widget.TextView;

import java.util.ArrayList;

public class Utilisateur {

    private String nom;
    private String prenom;
    private String mail;
    private String tel;
    private String mdp;
    private String ville;
    private String pseudo;
    private boolean isDirecteur;



    public Utilisateur(String pseudo, String mdp){
        this.pseudo = pseudo;
        this.mdp = mdp;
    }
    public Utilisateur(String nom, String prenom, String mail,String tel, String mdp, String ville, String pseudo, boolean isDirecteur) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.tel = tel;
        this.mdp = mdp;
        this.ville = ville;
        this.pseudo = pseudo;
        this.isDirecteur = isDirecteur;
    }
    public String afficherProf(){
        return nom+" "+prenom;
    }

    public String villeClient() { return ville; }

    public String getMdp() {
        return mdp;
    }

    public String getPseudo() { return pseudo;}
    public boolean isDirecteur() {
        return isDirecteur;
    }


}
