package com.jk.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //ArrayList of the person names
    ArrayList <String > personNames = new ArrayList<>(Arrays.asList
            ("Person1",
                    "Person2",
                    "Person3",
                    "Person4",
                    "Person5","Person6",
                    "Person7"));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the reference of recyclerView
        RecyclerView recyclerView= findViewById(R.id.recyclerView);
        //set the LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        //set a linearLayoutManager with a vertical orientation
        recyclerView.setLayoutManager(linearLayoutManager);
        //call the constructor of customAdapter to send the reference and data to adapter
        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, personNames);
        //set the adapter to recyclerView
        recyclerView.setAdapter(customAdapter);
        //to add divider to a recyclerView
       // RecyclerView.ItemDecoration divider= new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        //recyclerView.addItemDecoration(divider);
        //or this in case we have a custom divider
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.recyclerview_divider));
        recyclerView.addItemDecoration(dividerItemDecoration);
    }
}
