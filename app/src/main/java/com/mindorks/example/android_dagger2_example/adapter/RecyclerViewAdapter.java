package com.mindorks.example.android_dagger2_example.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.constraint.ConstraintLayout;

import com.mindorks.example.android_dagger2_example.R;
import com.mindorks.example.android_dagger2_example.pojo.StarWars;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by HashWaney on 2019/3/10.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ClickListener clickListener;

    private List<StarWars.People> data;

    @Inject
    public RecyclerViewAdapter(ClickListener clickListener) {
        this.clickListener = clickListener;
        data = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_list_row, parent, false)
        );

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtName.setText(data.get(position).name);
        holder.txtBirthYear.setText(data.get(position).birthYear);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface ClickListener {
        void launchIntent(String film);
    }

    public void setData(List<StarWars.People> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;
        private TextView txtBirthYear;
        private ConstraintLayout constraintLayoutContainer;

        ViewHolder(View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtBirthYear = itemView.findViewById(R.id.txtBirthYear);
            constraintLayoutContainer = itemView.findViewById(R.id.constraintLayout);

            constraintLayoutContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("RecycleViewAdapter","data:"+data.toString());
                    clickListener.launchIntent(data.get(getAdapterPosition()).films.get(0));
                }
            });
        }
    }

}
