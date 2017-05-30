package com.example.hitesh_pc.volleyexample.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.hitesh_pc.volleyexample.R;
import com.example.hitesh_pc.volleyexample.adapter.RecyclerViewAdapter;
import com.example.hitesh_pc.volleyexample.application.VolleyApplication;
import com.example.hitesh_pc.volleyexample.model.Person;
import com.example.hitesh_pc.volleyexample.model.PersonList;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //static variables
    private static final String URL = "http://api.androidhive.info/volley/person_array.json";

    private RecyclerViewAdapter mAdapter;

    //Views
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        mProgressBar.setVisibility(View.VISIBLE);

        getDataFromNetwork();

        initRecyclerView();
    }

    private void getDataFromNetwork() {

        JsonArrayRequest jsObjRequest = new JsonArrayRequest
                (Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        List<Person> personList = new ArrayList<>();
                        Gson gson = new Gson();
                        for (int i = 0; i < response.length(); ++i) {
                            try {
                                Person person = gson.fromJson(response.getString(i), Person.class);
                                personList.add(person);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        mAdapter.updateData(personList);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        VolleyApplication.getInstance().addToRequestQueue(jsObjRequest);
    }

    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RecyclerViewAdapter(this, null);
        mRecyclerView.setAdapter(mAdapter);
    }
}
