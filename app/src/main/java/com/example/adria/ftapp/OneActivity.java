package com.example.adria.ftapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class OneActivity extends AppCompatActivity {

    Button buttonOneRefresh;
    TextView textViewOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        textViewOne = (TextView) findViewById(R.id.textViewOne);// We look for the Text for its id
        buttonOneRefresh = (Button) findViewById(R.id.buttonOneRefresh); //We look for the Button for its id
        buttonOneRefresh.setOnClickListener(new View.OnClickListener() { // Le ponemos un listener
            @Override
            public void onClick(View view) {
                RefreshOneButton(); // We send it to the method
            }
        });
    }

    private void RefreshOneButton () {
        String url = "http://192.168.1.120:40000/api/one-book"; //We put our ip from server Node
        RequestQueue RequestQueue;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        textViewOne.setText("Response: " + response.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textViewOne.setText("Error" + error.toString());

                    }
                });
        RequestQueue = Volley.newRequestQueue(this);
        RequestQueue.add(jsonObjectRequest);
    }

}
