package com.example.arslan.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private List<City> cityList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CityAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new CityAdapter(cityList);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                City city = cityList.get(position);
//                Toast.makeText(getApplicationContext(), city.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            Intent in = new Intent(Main2Activity.this, MainActivity.class);
            in.putExtra("sehir", city.getTitle());
            startActivity(in);
            }
            @Override
            public void onLongClick(View view, int position) {
            }
        }));
        prepareCityData();
    }

    private void prepareCityData() {
        City city = new City("Aktau", "Mangystau Province");
        cityList.add(city);

        city = new City("Aktobe", "Aktobe Province");
        cityList.add(city);

        city = new City("Almaty", "Almaty Region");
        cityList.add(city);

        city = new City("Arkalyk", "Kostanay Province");
        cityList.add(city);

        city = new City("Astana", "Akmola Province");
        cityList.add(city);

        city = new City("Atyrau", "Atyrau Province");
        cityList.add(city);

        city = new City("Baikonur", ".");
        cityList.add(city);

        city = new City("Balqash", "Karagandy Province");
        cityList.add(city);

        city = new City("Zhezkazgan", "Karagandy Province");
        cityList.add(city);

        city = new City("Karagandy", "Karagandy Province");
        cityList.add(city);

        city = new City("Kentau", "South Kazakhstan Province");
        cityList.add(city);

        city = new City("Kyzylorda", "Kyzylorda Province");
        cityList.add(city);

        city = new City("Kokshetau", "Akmola Province");
        cityList.add(city);

        city = new City("Kostanay", "Kostanay Province");
        cityList.add(city);

        city = new City("Zhanaozen", "Mangystau Province");
        cityList.add(city);

        city = new City("Pavlodar", "Pavlodar Province");
        cityList.add(city);

        city = new City("Ridder", "East Kazakhstan Province");
        cityList.add(city);

        city = new City("Saran", "Karagandy Province");
        cityList.add(city);

        city = new City("Semey", "East Kazakhstan Province");
        cityList.add(city);

        city = new City("Stepnogorsk", "Akmola Province");
        cityList.add(city);

        city = new City("Taldykorgan", "Almaty Province");
        cityList.add(city);

        city = new City("Taraz", "Jambyl Province");
        cityList.add(city);

        city = new City("Temirtau", "Karagandy Province");
        cityList.add(city);

        city = new City("Oral", "West Kazakhstan Province");
        cityList.add(city);

        city = new City("Oskemen", "East Kazakhstan Province");
        cityList.add(city);

        city = new City("Shymkent", "South Kazakhstan Province");
        cityList.add(city);

        city = new City("Shakhtinsk", "Karagandy Province");
        cityList.add(city);

        city = new City("Ekibastuz", "Pavlodar Province");
        cityList.add(city);

        mAdapter.notifyDataSetChanged();
    }

}
