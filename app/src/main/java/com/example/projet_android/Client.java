package com.example.projet_android;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

enum Sexe {
    M, // Male
    F  // Female
}
public class Client {
    private int id;
    private String nom;
    private Sexe sexe;
    private Date dateN;


    public Client() {
    }
    public Client(int id,String nom, Sexe sexe, Date dateN){
        this.id=id;
        this.nom=nom;
        this.sexe=sexe;
        this.dateN=dateN;
    }
    public Client(JSONObject json) {
        try {
            this.id = json.getInt("id");
            this.nom = json.getString("nom");
            this.sexe = Sexe.valueOf(json.getString("sexe"));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = dateFormat.parse(json.getString("dateN"));
            this.dateN = parsedDate;
        } catch (JSONException | ParseException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSexe() {
        switch (sexe){
            case F:
                return "femele";
            case M:
                return "male";
            default:
                return "erreur";
        }
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public Date getDateN() {
        return dateN;
    }

    public void setDateN(Date dateN) {
        this.dateN = dateN;
    }


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", sexe=" + sexe +
                ", dateN=" + dateN +
                '}';
    }
}