package com.example.projet_android;

import org.json.JSONException;
import org.json.JSONObject;

enum TypeCompte{
    P,
    E,
    I
}

public class Compte {
    private int id;
    private int proprietaire;
    private String username;
    private String password;
    private Double solde;
    private TypeCompte type;

    public Compte() {
    }

    public Compte(int id, int proprietaire, String username, String password, Double solde, TypeCompte type) {
        this.id = id;
        this.proprietaire = proprietaire;
        this.username = username;
        this.password = password;
        this.solde = solde;
        this.type = type;
    }
    public Compte(JSONObject json) {
        try {
            this.id = json.getInt("id");
            this.proprietaire = json.getInt("idClient");
            this.username = json.getString("username");
            this.password = json.getString("password");
            this.solde = json.getDouble("solde");
            this.type = TypeCompte.valueOf(json.getString("type"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(int proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public String getType() {
        switch (this.type){
            case P:
                return "Compte personel";

            case E:
                return  "Compte entreprise";

            case I:
                return "Compte investissement";

            default:
                return "une erreur s'est produite";
        }
    }

    public void setType(TypeCompte type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", proprietaire=" + proprietaire +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", solde=" + solde +
                ", type=" + type +
                '}';
    }
}