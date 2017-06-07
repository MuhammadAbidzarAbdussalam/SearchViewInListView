package com.slamgantdroid.searchviewinlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by WIN10 on 08/06/2017.
 */

public class Adapter extends BaseAdapter implements Filterable{

    Context context;
    ArrayList<Model> models;
    CostumFilter filter;
    ArrayList<Model> filterList;

    public Adapter(Context context, ArrayList<Model> models) {
        this.context = context;
        this.models = models;
        this.filterList = models;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int position) {
        return models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return models.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        TextView namaText = (TextView)convertView.findViewById(R.id.txt);
        ImageView gambar = (ImageView)convertView.findViewById(R.id.img);

        namaText.setText(models.get(position).getNama());
        gambar.setImageResource(models.get(position).getGambar());

        return convertView;
    }

    @Override
    public Filter getFilter() {

        if (filter == null) {
            filter = new CostumFilter();
        }

        return filter;
    }


    //Inner Class (class turunan)
    class CostumFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            FilterResults results=new FilterResults();
            if (charSequence != null && charSequence.length()> 0) {
                charSequence = charSequence.toString().toUpperCase();

                ArrayList<Model> filters = new ArrayList<>();

                for (int i = 0; i < filterList.size(); i++) {
                    if (filterList.get(i).getNama().toUpperCase().contains(charSequence)) {
                        Model model = new Model(filterList.get(i).getNama(), filterList.get(i).getGambar());

                        filters.add(model);
                    }
                }

                results.count = filters.size();
                results.values = filters;
            } else {
                results.count = filterList.size();
                results.values = filterList;
            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

            models = (ArrayList<Model>)filterResults.values;
            notifyDataSetChanged();

        }
    }
}
