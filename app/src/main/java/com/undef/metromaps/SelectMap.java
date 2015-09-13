package com.undef.metromaps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectMap extends AppCompatActivity {

    ExpandableListView mapSelectorView;
    ExpandableListAdapter mapSelectorAdapter;
    List<String> continents;
    Map<String, List<String>> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_map);

        mapSelectorView = (ExpandableListView) findViewById(R.id.expandableListView);
        prepareData();
        mapSelectorAdapter = new MapSelectAdaptor(this, continents, countries);

        mapSelectorView.setAdapter(mapSelectorAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_select_map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void prepareData() {
        continents = new ArrayList<>();
        countries = new HashMap<>();

        continents.addAll(Arrays.asList(getResources().getStringArray(R.array.continents)));

        countries.put("Asia", new ArrayList<String>());
        countries.put("Africa", new ArrayList<String>());
        countries.put("Australia", new ArrayList<String>());
        countries.put("North America", new ArrayList<String>());
        countries.put("South America", new ArrayList<String>());
        countries.put("Europe", new ArrayList<String>());
    }
}
