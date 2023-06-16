package fd.firad.kpik.ui.captain;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import fd.firad.kpik.R;


public class CaptainFragment extends Fragment {
    private RecyclerView recyclerView;
    DatabaseReference database;
    ArrayList<CaptainModel> list;
    CaptainAdapter adapter;
    private SwipeRefreshLayout swipeCaptain;
    private ProgressBar progressBar;
    private TextView noCaptain;


    public CaptainFragment() {

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_captain, container, false);

        swipeCaptain = v.findViewById(R.id.swipeCaptain);
        recyclerView = v.findViewById(R.id.rcl_captain);
        noCaptain = v.findViewById(R.id.noCaptain);
        progressBar = v.findViewById(R.id.progress_captain);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        database = FirebaseDatabase.getInstance().getReference().child("Captains");
        list = new ArrayList<>();

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (!snapshot.exists()) {
                    progressBar.setVisibility(View.GONE);
                    noCaptain.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.GONE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        CaptainModel model = dataSnapshot.getValue(CaptainModel.class);
                        list.add(model);
                    }
                }
                adapter = new CaptainAdapter(getContext(), list);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        swipeCaptain.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                list.clear();
                database.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (!snapshot.exists()) {
                            progressBar.setVisibility(View.GONE);
                            noCaptain.setVisibility(View.VISIBLE);
                        } else {
                            progressBar.setVisibility(View.GONE);
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                CaptainModel model = dataSnapshot.getValue(CaptainModel.class);
                                list.add(model);
                            }
                        }
                        adapter = new CaptainAdapter(getContext(), list);
                        recyclerView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                swipeCaptain.setRefreshing(false);

            }
        });

        return v;
    }
}