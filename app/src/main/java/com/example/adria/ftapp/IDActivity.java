package com.example.adria.ftapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class IDActivity extends AppCompatActivity {
    TextView textviewname;
    TextView textviewautor;
    TextView textvieweditorial;
    TextView textviewprice;
    EditText textnumber;
    Button buttonid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id);

        textviewname = (TextView) findViewById(R.id.textViewName);//We look for the Text for its id
        textviewautor = (TextView) findViewById(R.id.textViewAutor);
        textvieweditorial = (TextView) findViewById(R.id.textViewEditorial);
        textviewprice = (TextView) findViewById(R.id.textViewPrice);
        textnumber = (EditText) findViewById(R.id.TextNumber);


        buttonid = (Button) findViewById(R.id.buttonID); //We look for the Button for its id
        buttonid.setOnClickListener(new View.OnClickListener() { // We put a listener
            @Override
            public void onClick(View view) {
                SendID(); // We send it to the method
            }
        });


    }

    private void SendID() {
        String ID = textnumber.getText().toString();
        textnumber.setError(null);
        if(TextUtils.isEmpty(ID)){
            textnumber.setError(getString(R.string.error_required_field));
            textnumber.requestFocus();
            return;
        }

        String url = "http://192.168.1.120:40000/api/book/"+ID; //We put our ip from server Node
        RequestQueue RequestQueue;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            textviewname.setText(response.getString("name"));
                            textviewautor.setText(response.getString("autor"));
                            textvieweditorial.setText(response.getString("editorial"));
                            textviewprice.setText(response.getString("price"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textviewname.setText("Error" + error.toString());

                    }
                });
        RequestQueue = Volley.newRequestQueue(this);
        RequestQueue.add(jsonObjectRequest);
    }


}
