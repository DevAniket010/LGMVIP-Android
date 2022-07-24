package com.example.lgmcovidtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    public static List<Test> testList = new ArrayList<>();
    Test test;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);
        fetchData();
    }

    private void fetchData() {
        String url = "https://api.rootnet.in/covid19-in/stats/latest";
        StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject object=new JSONObject(response);
                    JSONObject object1 = object.getJSONObject("data");
                    JSONArray jsonArray = object1.getJSONArray("regional");

                    for(int i=0;i<jsonArray.length();i++) {


                        JSONObject object2=jsonArray.getJSONObject(i);
                        String state = object2.getString("loc");
                        String confirmed = object2.getString("confirmedCasesIndian");
                        String deaths = object2.getString("deaths");
                        String recovered = object2.getString("discharged");
                        String Total = object2.getString("totalConfirmed");




                        testList.add(new Test( state,confirmed, deaths, recovered, Total));
                    }
                }   catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
        adapter=new Adapter(this,testList);
        listView=(ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
    }
}



