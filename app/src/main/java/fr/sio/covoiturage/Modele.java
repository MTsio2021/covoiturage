package fr.sio.covoiturage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Modele {


    protected ArrayList<Utilisateur> listeUtilisateurs = new java.util.ArrayList<>();

    public ArrayList<Utilisateur> getListeUtilisateurs() {
        return listeUtilisateurs;
    }

    public Modele(){

    }

    public Utilisateur connexion(String login, String mdp) {

        for (Utilisateur unUtil : listeUtilisateurs) {

            if (unUtil.getPseudo().equals(login) && unUtil.getMdp().equals(mdp)){
                return unUtil;
            }
        }
        return null;
    }
    public void ajouterUnProf(Utilisateur unUtilisateur){
        listeUtilisateurs.add(unUtilisateur);
    }
    public String passageGson(Utilisateur unUtilisateur){
        Gson gson = new GsonBuilder().create();
        String jsonProf = gson.toJson(unUtilisateur);
        return  jsonProf;
    }
    public String genMdp(){

        String caract ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!?$€%";
        String mdp = "";
        for(int i = 0; i<3; i++){
            int x = (int)Math.floor(Math.random()*67);
            mdp += caract.charAt(x);
        }
        return mdp;
    }

    public void peupler(){
        Utilisateur test1 = new Utilisateur("jean", "test","test@gmail.com","0605040302","testmdp","Villejuif","tjean",false);
        listeUtilisateurs.add(test1);
        Utilisateur directeur = new Utilisateur("Dupont","Bernard","dupont.bernard@gmail.com","0605040302","direct1","Cachan","DBernard",true);
        listeUtilisateurs.add(directeur);
    }
    public String isAdmin(Utilisateur unUtilisateur){
        if(unUtilisateur.isDirecteur() == true){
            return ", vous êtes le directeur.";
        }
        else{
            return ".";
        }
    }

    public String toString(){
        String unUtili = "";
        for(Utilisateur unUtil : listeUtilisateurs){
            unUtili = unUtil.afficherProf();
        }
        return unUtili;
    }

}
