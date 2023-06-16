package fd.firad.kpik.ui.pdfnotice;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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

public class PdfNotice extends Fragment {
    private RecyclerView recyclerViewPdf;
    private PdfAdapter adapter;
    private ArrayList<PdfModel> list;
    private DatabaseReference dataBase;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeP;
    private TextView noPdf;


    public PdfNotice() {

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_pdfnotice, container, false);

        progressBar = v.findViewById(R.id.progress_pdf);
        noPdf = v.findViewById(R.id.noPdf);
        dataBase = FirebaseDatabase.getInstance().getReference().child("Pdf");
        list = new ArrayList<>();
        recyclerViewPdf = v.findViewById(R.id.rcl_pdf);
        recyclerViewPdf.setLayoutManager(new LinearLayoutManager(getContext()));

        swipeP = v.findViewById(R.id.swipePdf);


        dataBase.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                progressBar.setVisibility(View.GONE);
                if (!snapshot.exists()) {
                    progressBar.setVisibility(View.GONE);
                    noPdf.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.GONE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        PdfModel model = dataSnapshot.getValue(PdfModel.class);
                        list.add(0, model);
                    }
                    adapter = new PdfAdapter(getContext(), list);
                    recyclerViewPdf.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getDetails(), Toast.LENGTH_SHORT).show();

            }
        });

        swipeP.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                list.clear();
                dataBase.addValueEventListener(new ValueEventListener() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        progressBar.setVisibility(View.GONE);
                        if (!snapshot.exists()) {
                            progressBar.setVisibility(View.GONE);
                            noPdf.setVisibility(View.VISIBLE);
                        } else {
                            progressBar.setVisibility(View.GONE);
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                PdfModel model = dataSnapshot.getValue(PdfModel.class);
                                list.add(0, model);
                            }
                            adapter = new PdfAdapter(getContext(), list);
                            recyclerViewPdf.setAdapter(adapter);
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getContext(), error.getDetails(), Toast.LENGTH_SHORT).show();

                    }
                });
                swipeP.setRefreshing(false);
            }
        });

        return v;
    }
}