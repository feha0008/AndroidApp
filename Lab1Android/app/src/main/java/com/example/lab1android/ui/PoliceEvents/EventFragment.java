package com.example.lab1android.ui.PoliceEvents;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import com.example.lab1android.R;
import com.example.lab1android.ui.PoliceEvents.models.Event;
import com.example.lab1android.ui.PoliceEvents.models.EventList;

public class EventFragment extends Fragment {

    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private String url = "https://polisen.se/api/events?locationname=Malmö";
    private EventList eventList = new EventList();
    private int mColumnCount = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_list, container, false);
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                getData(recyclerView);
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyEventRecyclerViewAdapter(eventList.reports));
        }
        return view;
    }

    private void getData( RecyclerView recyclerView ) {
        mRequestQueue = Volley.newRequestQueue(getActivity());
        mStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                displayResult(response, recyclerView);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, "Error :" + error.toString());
            }});
        mRequestQueue.add(mStringRequest);
    }
    private void displayResult(String response, RecyclerView recyclerView){
        ObjectMapper mapper = new ObjectMapper(); //Jackson mapper to create objects
        try {
            //Note: this api gives an array of objects as response.
            //Often API return a single object having a list of objects.
            eventList.reports = mapper.readValue(response, new TypeReference<List<Event>>(){});
            recyclerView.setAdapter(new MyEventRecyclerViewAdapter(eventList.reports));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}