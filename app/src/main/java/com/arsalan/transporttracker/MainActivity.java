package com.arsalan.transporttracker;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 200;
    List<busListModel> list = new ArrayList<>();
    busListModel busListModel;
    RecyclerView recyclerView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        busListModel = new busListModel();

        for (int i = 0; i < 10; i++) {
            busListModel.PointName = ("Point Name");
            busListModel.DriverName = ("Driver Name");
            busListModel.Location = ("Location");
            busListModel.Date = ("Current Date");
            list.add(busListModel);
        }

        recyclerView = (RecyclerView) findViewById(R.id.busRecyclerView);


        busMainAdapter adapter = new busMainAdapter(list,context);

        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }

}
