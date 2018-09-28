package com.example.adria.ftapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class AllActivity extends AppCompatActivity {

    Button buttonRefresh;
    TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        textViewMessage = (TextView) findViewById(R.id.textViewAll);// We look for the Text for its id
        textViewMessage.setMovementMethod(new ScrollingMovementMethod());
        buttonRefresh = (Button) findViewById(R.id.buttonRefreshAll); //We look for the Button for its id
        buttonRefresh.setOnClickListener(new View.OnClickListener() { // Le ponemos un listener
            @Override
            public void onClick(View view) {
                RefreshButton(); // We send it to the method
            }
        });
    }

        private void RefreshButton () {
            String url = "http://192.168.1.120:40000/api/books"; //We put our ip from server Node
            RequestQueue RequestQueue;

            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                        @Override
                        public void onResponse(JSONArray response) {
                            textViewMessage.setText("Response: " + response.toString());
                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            textViewMessage.setText("Error" + error.toString());

                        }
                    });
            RequestQueue = Volley.newRequestQueue(this);
            RequestQueue.add(jsonArrayRequest);
        }
    }

