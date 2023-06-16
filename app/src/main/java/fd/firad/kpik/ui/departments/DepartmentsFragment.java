package fd.firad.kpik.ui.departments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import fd.firad.kpik.R;


public class DepartmentsFragment extends Fragment {
    private RecyclerView recyclerView;
    private DatabaseReference database;
    private ArrayList<DepartmentModel> list;
    DepartmentsAdapter adapter;
    private SwipeRefreshLayout swipeDpt;
    private ProgressBar progressBar;
    private TextView noDepartment;


    public DepartmentsFragment() {

    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_departments, container, false);


        recyclerView = v.findViewById(R.id.rcl_department);
        noDepartment = v.findViewById(R.id.noDepartment);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        progressBar = v.findViewById(R.id.progress_department);
        list = new ArrayList<>();
        swipeDpt = v.findViewById(R.id.swipeDpt);

        database = FirebaseDatabase.getInstance().getReference().child("Departments");

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (!snapshot.exists()) {
                    progressBar.setVisibility(View.GONE);
                    noDepartment.setVisibility(View.VISIBLE);

                } else {
                    progressBar.setVisibility(View.GONE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        DepartmentModel model = dataSnapshot.getValue(DepartmentModel.class);
                        list.add(model);
                    }
                }
                adapter = new DepartmentsAdapter(getContext(), list);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        swipeDpt.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                list.clear();
                database.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (!snapshot.exists()) {
                            progressBar.setVisibility(View.GONE);
                            noDepartment.setVisibility(View.VISIBLE);

                        } else {
                            progressBar.setVisibility(View.GONE);
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                DepartmentModel model = dataSnapshot.getValue(DepartmentModel.class);
                                list.add(model);
                            }
                        }
                        adapter = new DepartmentsAdapter(getContext(), list);
                        recyclerView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                swipeDpt.setRefreshing(false);
            }
        });
        return v;
    }
}