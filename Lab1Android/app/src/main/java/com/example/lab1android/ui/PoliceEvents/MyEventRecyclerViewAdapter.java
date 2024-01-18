package com.example.lab1android.ui.PoliceEvents;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lab1android.ui.PoliceEvents.models.Event;
import com.example.lab1android.ui.PoliceEvents.models.EventList;
import com.example.lab1android.databinding.FragmentEventBinding;


import java.util.List;

public class MyEventRecyclerViewAdapter extends RecyclerView.Adapter<MyEventRecyclerViewAdapter.ViewHolder> {

    private final List<Event> mValues; //Model items from API
    public MyEventRecyclerViewAdapter(List<Event> event) {
        mValues = event;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentEventBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    //Here we copy model data to ViewHolder (row in list)
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mTitleView.setText(mValues.get(position).getName());
        holder.mDescriptionView.setText(mValues.get(position).getSummary());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    //Internal class ViewHolder describes an item view and metadata about its place within the RecyclerView, one row in the displayed list
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mTitleView; //View in fragment_book.xml
        public final TextView mDescriptionView; //View in fragment_book.xml

        public Event mItem;

        public ViewHolder(FragmentEventBinding binding) {
            super(binding.getRoot());
            //title and description are ids in fragment_book.xml
            mTitleView = binding.name;
            mDescriptionView = binding.summary;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTitleView.getText() + "'";
        }
    }
}