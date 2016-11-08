package com.intrusoft.islibrarydemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.intrusoft.scatter.ChartData;
import com.intrusoft.scatter.PieChart;

import java.util.ArrayList;
import java.util.List;

public class PieChartActivity extends AppCompatActivity {

    PieChart pieChart;
    List<ChartData> data, data1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        pieChart = (PieChart) findViewById(R.id.pie_chart);
        data = new ArrayList<>();
        data.add(new ChartData("35%", 35));
        data.add(new ChartData("25%", 25));
        data.add(new ChartData("30%", 30));
        data.add(new ChartData("10%", 10));

        data1 = new ArrayList<>();
        data1.add(new ChartData("35%", 35, Color.WHITE, Color.parseColor("#0091EA")));
        data1.add(new ChartData("25%", 25, Color.WHITE, Color.parseColor("#33691E")));
        data1.add(new ChartData("30%", 30, Color.DKGRAY, Color.parseColor("#F57F17")));
        data1.add(new ChartData("10%", 10, Color.DKGRAY, Color.parseColor("#FFD600")));

        pieChart.setChartData(data);
    }

    public void withPartition(View view) {
        pieChart.partitionWithPercent(true);
    }

    public void withOutPartition(View view) {
        pieChart.partitionWithPercent(false);
    }

    public void singleColor(View view) {
        pieChart.setChartData(data);
    }

    public void multiColor(View view) {
        pieChart.setChartData(data1);
    }


}
