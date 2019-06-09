package com.example.emergencyreferralrhodes;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView mHospitalListView;
    private List<Hospital> hospitalList;

    private HospitalRecyclerAdapter hospitalRecyclerAdapter;
    private FirebaseFirestore firestore;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mHospitalListView = view.findViewById(R.id.hospital_layout);


        hospitalList = new ArrayList<>();
        firestore = FirebaseFirestore.getInstance();


        hospitalList = new ArrayList<>();
        hospitalRecyclerAdapter = new HospitalRecyclerAdapter(hospitalList);

        mHospitalListView.setHasFixedSize(true);
        mHospitalListView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        mHospitalListView.setAdapter(hospitalRecyclerAdapter);


        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        hospitalList.clear();

        firestore.collection("hospitals").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                for (DocumentChange doc: queryDocumentSnapshots.getDocumentChanges()){
                    if (doc.getType() == DocumentChange.Type.ADDED){

                        Hospital hos = doc.getDocument().toObject(Hospital.class);
                        hospitalList.add(hos);

                        hospitalRecyclerAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }

}
