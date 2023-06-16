package fd.firad.kpik.ui.departments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import fd.firad.kpik.R;

public class DepartmentsAdapter extends RecyclerView.Adapter<DepartmentsAdapter.DepartmentsView> {
    private Context context;
    private ArrayList<DepartmentModel> list;
    private DatabaseReference database;
    private String key;

    public DepartmentsAdapter(Context context, ArrayList<DepartmentModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DepartmentsView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.department_simple_layout, parent, false);
        database = FirebaseDatabase.getInstance().getReference().child("Departments");
        return new DepartmentsView(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentsView holder, int position) {
        DepartmentModel data = list.get(position);
        holder.dName.setText("Department : " + data.getDptName());
        holder.dTeachers.setText("Total Teachers : " + data.getDptTeachers());
        holder.dSeat.setText("Total Seats : " + data.getDptSeats());
        holder.dLabs.setText("Total Labs : " + data.getDptLabs());
        key = data.getKey();


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class DepartmentsView extends RecyclerView.ViewHolder {
        private TextView dName, dTeachers, dSeat, dLabs;

        public DepartmentsView(@NonNull View itemView) {
            super(itemView);
            dName = itemView.findViewById(R.id.dName);
            dTeachers = itemView.findViewById(R.id.dTeacher);
            dSeat = itemView.findViewById(R.id.dtSeat);
            dLabs = itemView.findViewById(R.id.dLabs);
        }
    }
}
