package fd.firad.kpik.ui.teachers;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import fd.firad.kpik.R;


public class TeachersFragment extends Fragment {

    private ProgressBar progressBar;
    private TeacherAdapter adapter;
    private DatabaseReference dataBase, dbRef;
    private ArrayList<TeacherModel> principleList, cmtList, ctList, entList, entsList, mtList, contList, aidtList, nonTechList, othersList;
    private RecyclerView principle, cmt, ct, ent, ents, mt, cont, aidt, nonTech, others;

    public TeachersFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_teachers, container, false);

        intilizing(v);

        showPrinciple();
        cmtDepartment();
        ctDepartment();
        entDepartment();
        entsDepatment();
        mtDepartment();
        contDepartment();
        aidtDepartment();
        nonTechDepartment();
        othersDepartment();

        return v;
    }

    private void intilizing(View v) {

        dataBase = FirebaseDatabase.getInstance().getReference().child("Teachers");
        principle = v.findViewById(R.id.principleRecycle);
        cmt = v.findViewById(R.id.ComputerRecycle);
        ct = v.findViewById(R.id.civilRecycle);
        ent = v.findViewById(R.id.electricalRecycle);
        ents = v.findViewById(R.id.electronicsRecycle);
        mt = v.findViewById(R.id.MechanicalRecycle);
        cont = v.findViewById(R.id.constructionRecycle);
        aidt = v.findViewById(R.id.AIDTRecycle);
        nonTech = v.findViewById(R.id.NonTechRecycle);
        others = v.findViewById(R.id.OthersRecycle);

        progressBar = v.findViewById(R.id.progress_teacher);

    }

    private void showPrinciple() {

        dbRef = dataBase.child("PRINCIPAL");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                principleList = new ArrayList<>();
                if (!snapshot.exists()) {
                    progressBar.setVisibility(View.GONE);
                    principle.setVisibility(View.GONE);
                } else {
                    progressBar.setVisibility(View.GONE);
                    principle.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherModel model = dataSnapshot.getValue(TeacherModel.class);
                        principleList.add(model);
                    }
                    principle.setHasFixedSize(true);
                    principle.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(getContext(), principleList);
                    principle.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getDetails(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void cmtDepartment() {
        dbRef = dataBase.child("CMT");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                cmtList = new ArrayList<>();
                if (!snapshot.exists()) {
                    cmt.setVisibility(View.GONE);
                } else {
                    cmt.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherModel model = dataSnapshot.getValue(TeacherModel.class);
                        cmtList.add(model);
                    }
                    cmt.setHasFixedSize(true);
                    cmt.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(getContext(), cmtList);
                    cmt.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getDetails(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void ctDepartment() {
        dbRef = dataBase.child("CT");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ctList = new ArrayList<>();
                if (!snapshot.exists()) {
                    ct.setVisibility(View.GONE);
                } else {
                    ct.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherModel model = dataSnapshot.getValue(TeacherModel.class);
                        ctList.add(model);
                    }
                    ct.setHasFixedSize(true);
                    ct.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(getContext(), ctList);
                    ct.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getDetails(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void entDepartment() {
        dbRef = dataBase.child("ET");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                entList = new ArrayList<>();
                if (!snapshot.exists()) {
                    ent.setVisibility(View.GONE);
                } else {
                    ent.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherModel model = dataSnapshot.getValue(TeacherModel.class);
                        entList.add(model);
                    }
                    ent.setHasFixedSize(true);
                    ent.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(getContext(), entList);
                    ent.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getDetails(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void entsDepatment() {
        dbRef = dataBase.child("ENT");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                entsList = new ArrayList<>();
                if (!snapshot.exists()) {
                    ents.setVisibility(View.GONE);
                } else {
                    ents.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherModel model = dataSnapshot.getValue(TeacherModel.class);
                        entsList.add(model);
                    }
                    ents.setHasFixedSize(true);
                    ents.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(getContext(), entsList);
                    ents.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getDetails(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void mtDepartment() {

        dbRef = dataBase.child("MT");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mtList = new ArrayList<>();
                if (!snapshot.exists()) {
                    mt.setVisibility(View.GONE);
                } else {
                    mt.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherModel model = dataSnapshot.getValue(TeacherModel.class);
                        mtList.add(model);
                    }
                    mt.setHasFixedSize(true);
                    mt.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(getContext(), mtList);
                    mt.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getDetails(), Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void contDepartment() {
        dbRef = dataBase.child("CONT");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                contList = new ArrayList<>();
                if (!snapshot.exists()) {
                    cont.setVisibility(View.GONE);
                } else {
                    cont.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherModel model = dataSnapshot.getValue(TeacherModel.class);
                        contList.add(model);
                    }
                    cont.setHasFixedSize(true);
                    cont.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(getContext(), contList);
                    cont.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getDetails(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void aidtDepartment() {

        dbRef = dataBase.child("AIDT");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                aidtList = new ArrayList<>();
                if (!snapshot.exists()) {
                    aidt.setVisibility(View.GONE);
                } else {
                    aidt.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherModel model = dataSnapshot.getValue(TeacherModel.class);
                        aidtList.add(model);
                    }
                    aidt.setHasFixedSize(true);
                    aidt.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(getContext(), aidtList);
                    aidt.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getDetails(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void nonTechDepartment() {

        dbRef = dataBase.child("NON-TECH");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                nonTechList = new ArrayList<>();
                if (!snapshot.exists()) {
                    nonTech.setVisibility(View.GONE);
                } else {
                    nonTech.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherModel model = dataSnapshot.getValue(TeacherModel.class);
                        nonTechList.add(model);
                    }
                    nonTech.setHasFixedSize(true);
                    nonTech.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(getContext(), nonTechList);
                    nonTech.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getDetails(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void othersDepartment() {

        dbRef = dataBase.child("OTHERS");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                othersList = new ArrayList<>();
                if (!snapshot.exists()) {
                    others.setVisibility(View.GONE);
                } else {
                    others.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherModel model = dataSnapshot.getValue(TeacherModel.class);
                        othersList.add(model);
                    }
                    others.setHasFixedSize(true);
                    others.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(getContext(), othersList);
                    others.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getDetails(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}