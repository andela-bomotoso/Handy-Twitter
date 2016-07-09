package com.example.bukola_omotoso.handytwitter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.net.PortUnreachableException;
import java.util.List;

/**
 * Created by bukola_omotoso on 09/07/16.
 */
public class SearchesAdapter extends RecyclerView.Adapter<SearchesAdapter.ViewHolder>{
    private final View.OnClickListener clickListener;
    private final View.OnLongClickListener longClickListener;
    private final List<String> tags;

    public SearchesAdapter(List<String>tags, View.OnClickListener clickListener, View.OnLongClickListener longClickListener)    {
        this.tags = tags;
        this.clickListener = clickListener;
        this.longClickListener = longClickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public final TextView textView;
        public ViewHolder(View itemView, View.OnClickListener clickListener, View.OnLongClickListener longClickListener)    {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(clickListener);
            itemView.setOnLongClickListener(longClickListener);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)   {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return (new ViewHolder(view,clickListener,longClickListener));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)   {
        holder.textView.setText(tags.get(position));
    }

    @Override
    public int getItemCount()   {
        return tags.size();
    }


}
