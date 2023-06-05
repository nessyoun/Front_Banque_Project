package com.example.projet_android;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Persistence {
    private static final String url  = "http://10.0.2.2:8000/api/";
    private RequestQueue queue;
    private Context context;

    public Persistence(Context con) {
        this.context=con;
        queue = Volley.newRequestQueue(context);
    }

    public void createUser(String nom, String dateN, String sexe)
    {
        String url = this.url + "creerClient?id=" + nom+"&dateN="+dateN+"&sexe"+sexe;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Toast.makeText(context, response.getString("status"), Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

        queue.add(jsonObjectRequest);
    }
    public void createCompte(int idClient,String username,String password,String type)
    {
        String url = this.url + "creerCompte?idClient=" + idClient+"&username="+username+"&password="+password+"&type="+type;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Toast.makeText(context, response.getString("status"), Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

        queue.add(jsonObjectRequest);
    }

    public void supprimerCompte(int id)
    {
        String url = this.url + "supprimerCompte?id="+id;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Toast.makeText(context, response.getString("status"), Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

        queue.add(jsonObjectRequest);
    }

    public interface VolleyOnEventListener<T> {
        public void onSuccess(T object);

        public void onFailure(Exception e);
    }
    public void consulterSold(int id,VolleyOnEventListener<Double> volleyOnEventListener)
    {
        String url = this.url + "consulterSolde?id=" +id;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                           Double solde = response.getDouble("solde");
                           volleyOnEventListener.onSuccess(solde);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        System.out.println(error.toString());

                    }
                });

        queue.add(jsonObjectRequest);
    }

    public void verser(int id1,int id2,Float montant)
    {
        String url = this.url + "verser?id1=" +id1+"&id2="+id2+"&montant="+montant;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String status = response.getString("status");
                            if(status.equals("success")){
                                Toast.makeText(context,status , Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(context, status+" "+response.getString("error"), Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        queue.add(jsonObjectRequest);
    }



    public void findClient(int id, VolleyOnEventListener<Client> volleyOnEventListener)
    {
        String url = this.url + "findClient?id=" +id;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String status = response.getString("status");
                            Client clt = new Client();
                            if(!status.equals("sucess")){
                                JSONObject client = response.getJSONObject("data");
                                clt = new Client(client);
                            }
                        volleyOnEventListener.onSuccess(clt);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        System.out.println(error.toString());

                    }
                });

        queue.add(jsonObjectRequest);
    }

    public void login(String user, String pwd,VolleyOnEventListener<Boolean> volleyOnEventListener)
    {
        String url = this.url + "login?username=" +user+"&password="+pwd;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String status = response.getString("status");
                            Boolean result = false;
                            if(!status.equals("success")){
                                 result = true;
                                JSONObject compte = response.getJSONObject("data");
                                Compte compt = new Compte(compte);
                                Session.compte=compt;
                            }
                            volleyOnEventListener.onSuccess(result);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        System.out.println(error.toString());
                        Toast.makeText(context, "verifier les données saisis", Toast.LENGTH_SHORT).show();
                    }
                });

        queue.add(jsonObjectRequest);
    }

}
