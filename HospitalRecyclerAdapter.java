package com.example.emergencyreferralrhodes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class HospitalRecyclerAdapter extends RecyclerView.Adapter<HospitalRecyclerAdapter.ViewHolder> {

    private List<Hospital> hospitalList;

    public HospitalRecyclerAdapter(List<Hospital> hospitalList){

        this.hospitalList = hospitalList;

    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hospital_list_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {

        holder.hospitalView.setText(hospitalList.get(i).gethName());
        holder.townView.setText(hospitalList.get(i).gethTown());
        holder.districtView.setText(hospitalList.get(i).gethDistrict());

    }

    @Override
    public int getItemCount() {
        return hospitalList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private View mHos;
        private TextView hospitalView;
        private TextView townView;
        private TextView districtView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mHos = itemView;

            hospitalView = mHos.findViewById(R.id.hospitalName);
            townView = mHos.findViewById(R.id.townView);
            districtView = mHos.findViewById(R.id.districtView);
        }
    }
}
