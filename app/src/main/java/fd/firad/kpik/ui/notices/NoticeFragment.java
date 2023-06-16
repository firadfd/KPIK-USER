package fd.firad.kpik.ui.notices;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
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
import fd.firad.kpik.ui.captain.CaptainAdapter;
import fd.firad.kpik.ui.captain.CaptainModel;


public class NoticeFragment extends Fragment {
    public static final String TAG  = "TAG";
    private RecyclerView recyclerView;
    private DatabaseReference database;
    private SwipeRefreshLayout swipe;
    private ArrayList<noticeModel> list;
    NoticeAdapter adapter;
    private ProgressBar progressBar;
    private TextView noNotice;


    public NoticeFragment() {
    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_notice, container, false);


        progressBar = v.findViewById(R.id.progress_notice);
        noNotice = v.findViewById(R.id.noNotice);
        recyclerView = v.findViewById(R.id.rcl_notice);
        swipe = v.findViewById(R.id.swipeNotice);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onRefresh() {
                list.clear();
                database.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (!snapshot.exists()) {
                            progressBar.setVisibility(View.GONE);
                            noNotice.setVisibility(View.VISIBLE);

                        } else {
                            progressBar.setVisibility(View.GONE);
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                noticeModel model = dataSnapshot.getValue(noticeModel.class);
                                list.add(0,model);
                            }
                        }
                        adapter = new NoticeAdapter(getContext(), list);
                        recyclerView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.e(TAG, "onCancelled: "+error);

                    }
                });
                swipe.setRefreshing(false);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        database = FirebaseDatabase.getInstance().getReference().child("Notice");
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (!snapshot.exists()) {
                    progressBar.setVisibility(View.GONE);
                    noNotice.setVisibility(View.VISIBLE);

                } else {
                    progressBar.setVisibility(View.GONE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        noticeModel model = dataSnapshot.getValue(noticeModel.class);
                        list.add(0,model);
                    }
                }
                adapter = new NoticeAdapter(getContext(), list);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e(TAG, "onCancelled: "+error);

            }
        });


        return v;
    }
}