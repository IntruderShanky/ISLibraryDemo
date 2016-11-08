package com.intrusoft.islibrarydemo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.intrusoft.scatter.ChartData;
import com.intrusoft.scatter.PieChart;

import java.util.ArrayList;
import java.util.List;


public class ScatterPieChartActivity extends AppCompatActivity {

    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scatter_pie_chart);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        pieChart = (PieChart) findViewById(R.id.pie_chart);
        List<ChartData> data = new ArrayList<>();
        data.add(new ChartData("Simple Chart", 35, Color.WHITE, Color.parseColor("#0091EA")));
        data.add(new ChartData("Pie Chart", 65, Color.DKGRAY, Color.parseColor("#F57F17")));
        pieChart.setChartData(data);
    }

    public void simple(View view) {
        startActivity(new Intent(this, SimpleChartActivity.class));
    }

    public void piechart(View view) {
        startActivity(new Intent(this, PieChartActivity.class));
    }
}
