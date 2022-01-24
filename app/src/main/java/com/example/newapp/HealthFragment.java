package com.example.newapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class HealthFragment extends Fragment {

    ArrayList<ModelClass> modelClassArrayList=new ArrayList<ModelClass>();
    private MyAdapter adap;
    private RecyclerView recyclerView;
    ImageView imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_health,container,false);
        search();
        imageView=v.findViewById(R.id.imageView);
        recyclerView= (RecyclerView) v.findViewById(R.id.RecyclerViewHealth);
        adap=new MyAdapter(getContext(),modelClassArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adap);

        return v;
    }


    public void search() {
        String url = "https://newsdata.io/api/1/news?apikey=pub_379917531ca0f1f05882da2ac943385d6d39&country=in&category=health";
        HttpsTrustManager.allowAllSSL();
        RequestQueue queue = Volley.newRequestQueue(this.getContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray=response.getJSONArray("results");

                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        ModelClass m=new ModelClass( jsonObject.getString("source_id"), jsonObject.getString("link"), jsonObject.getString("image_url"),jsonObject.getString("description"), jsonObject.getString("title"), jsonObject.getString("source_id"), jsonObject.getString("pubDate"));
                        modelClassArrayList.add(m);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getContext(),"error",Toast.LENGTH_SHORT).show();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // error handling.

            }
        });


        queue.add(jsonObjectRequest);
    }
}