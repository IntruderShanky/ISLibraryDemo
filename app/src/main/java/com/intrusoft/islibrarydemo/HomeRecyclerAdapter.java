package com.intrusoft.islibrarydemo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by apple on 10/19/16.
 */

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder> {

    Context context;
    String[] titles;
    String[] about;
    String[] urls;

    public HomeRecyclerAdapter(Context context) {
        this.context = context;
        titles = context.getResources().getStringArray(R.array.titles);
        about = context.getResources().getStringArray(R.array.about);
        urls = context.getResources().getStringArray(R.array.urls);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.home_item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.title.setText(titles[position]);
        holder.about.setText(about[position]);
        holder.viewGitHub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(urls[position]));
                context.startActivity(i);
            }
        });
        if (position == 6)
            holder.viewDemo.setVisibility(View.GONE);
        else holder.viewDemo.setVisibility(View.VISIBLE);
        holder.viewDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                switch (position) {
                    case 0:
                        i = new Intent(context, SquintActivity.class);
                        break;
                    case 1:
                        i = new Intent(context, FlareActivity.class);
                        break;
                    case 2:
                        i = new Intent(context, FunkyHeaderActivity.class);
                        break;
                    case 3:
                        i = new Intent(context, SectionedRecyclerViewActivity.class);
                        break;
                    case 4:
                        i = new Intent(context, BlazeZoomActivity.class);
                        break;
                    case 5:
                        i = new Intent(context, ScatterPieChartActivity.class);
                        break;
                }
                if (i != null) {
                    context.startActivity(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView about;
        Button viewGitHub;
        Button viewDemo;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            about = (TextView) itemView.findViewById(R.id.about);
            viewGitHub = (Button) itemView.findViewById(R.id.view_git);
            viewDemo = (Button) itemView.findViewById(R.id.view_demo);
        }
    }
}
