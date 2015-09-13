package com.undef.metromaps;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by john on 9/13/15.
 */
public class MapSelectAdaptor extends BaseExpandableListAdapter {

    private Context context;
    private List<String> continents;
    private Map<String, List<String>> countries;

    public MapSelectAdaptor(Context context, List<String> continents, Map<String, List<String>> countries) {
        this.context = context;
        this.continents = continents;
        this.countries = countries;
    }

    @Override
    public Object getChild(int continentId, int countryId) {
        return this.countries.get(this.continents.get(continentId)).get(countryId);
    }

    @Override
    public long getChildId(int continentId, int countryId) {
        return countryId;
    }

    @Override
    public View getChildView(int continentId, int countryId, boolean isLast, View convertView, ViewGroup parent) {
        final String countryName = (String) getChild(continentId, countryId);

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.menu_item, null);
        }

        TextView txtListChild = (TextView) convertView.findViewById(R.id.country_item);
        txtListChild.setText(countryName);

        return convertView;
    }

    @Override
    public int getChildrenCount(int continentId) {
        return this.countries.get(this.continents.get(continentId)).size();
    }

    @Override
    public Object getGroup(int continentId) {
        return this.continents.get(continentId);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public int getGroupCount() {
        return this.continents.size();
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String continent = (String) getGroup(groupPosition);
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_group, null);
        }

        TextView continentHeader = (TextView) convertView.findViewById(R.id.continent_names);
        continentHeader.setTypeface(null, Typeface.BOLD);
        continentHeader.setText(continent);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
