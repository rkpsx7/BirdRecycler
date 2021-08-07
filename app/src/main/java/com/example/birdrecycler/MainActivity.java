package com.example.birdrecycler;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements clickListener {

    private RecyclerView recyclerView;
    private ArrayList<BirdModel> dataList = new ArrayList<>();
    private Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildList();
        setRecycleView();
    }

    private void buildList() {
        BirdModel eagle = new BirdModel(R.drawable.eagle, "Eagle");
        BirdModel falcon = new BirdModel(R.drawable.falcon, "Falcon");
        BirdModel humming = new BirdModel(R.drawable.humming, "Humming Bird");
        BirdModel parrot = new BirdModel(R.drawable.parrot, "Parrot");
        for (int i = 1; i <= 100; i++) {
            if (i % 4 == 0) dataList.add(eagle);
            else if (i % 4 == 1) dataList.add(falcon);
            else if (i % 4 == 2) dataList.add(humming);
            else dataList.add(parrot);
        }
    }

    private void setRecycleView() {
        adapter = new Adapter(dataList, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

    }

    private void initViews() {
        recyclerView = findViewById(R.id.recycleView);
    }


    @Override
    public void onClick(BirdModel model, int position) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Name is: ")
                .setMessage(
                        model.getName()
                ).
                        setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).
                        setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).
                        show();
    }
}
