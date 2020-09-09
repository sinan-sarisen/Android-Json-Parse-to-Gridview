package com.example.hizligeliyo_pocjsonparse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Product> products;
    private static  String JSON_URL = "https://fakestoreapi.com/products";
    Adapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= findViewById(R.id.productList);
        products=new ArrayList<>();

        extractProduct();



    }



    private void extractProduct() {
        RequestQueue queue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest =new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {

                    try {
                        JSONObject productObjects = response.getJSONObject(i);

                        Product product = new Product();
                        product.setTitle(productObjects.getString("title").toString());
                        product.setPrice(productObjects.getString("price").toString());
                        product.setImage(productObjects.getString("image").toString());

                        products.add(product);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                //change for grid view
                recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2,GridLayoutManager.VERTICAL,false));
                adapter =new Adapter(getApplicationContext(),products);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("TAG", "onErrorResponse: "+ error.getMessage());
            }
        });

        queue.add(jsonArrayRequest);
    }
}