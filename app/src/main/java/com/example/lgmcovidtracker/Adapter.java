package com.example.lgmcovidtracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lgmcovidtracker.Test;

import java.util.List;

public class Adapter extends ArrayAdapter<Test> {

    private Context context;
    private List<Test> testList;

    public Adapter(Context context , List<Test> testList){
        super(context , R.layout.testing, testList);

        this.context = context;
        this.testList = testList;
    }
    @NonNull
    @Override
    public View getView(int position,@Nullable View convertView,@NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.testing,null,true);

        TextView state = view.findViewById(R.id.state);
        TextView confirmed = view.findViewById(R.id.conNo);
        TextView deaths = view.findViewById(R.id.DeaNo);
        TextView recovered = view.findViewById(R.id.RecNo);
        TextView Total = view.findViewById(R.id.total);


        state.setText(testList.get(position).getState());
        confirmed.setText(testList.get(position).getConfirmed());
        deaths.setText(testList.get(position).getDeaths());
        recovered.setText(testList.get(position).getRecovered());
        Total.setText(testList.get(position).getTotal());


        return view;


    }

}



