package fd.firad.kpik.ui.captain;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import fd.firad.kpik.R;

public class CaptainAdapter extends RecyclerView.Adapter<CaptainAdapter.CaptainView> {
    private Context context;
    private ArrayList<CaptainModel> list;
    private DatabaseReference database;
    private String number;

    public CaptainAdapter(Context context, ArrayList<CaptainModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CaptainView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.captain_simple_layout, parent, false);
        database = FirebaseDatabase.getInstance().getReference();
        return new CaptainView(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CaptainView holder, int position) {
        CaptainModel data = list.get(position);

        holder.cName.setText("Name : " + data.getName());
        holder.cNumber.setText("Number : " + data.getNumber());
        holder.cDpt.setText("Department : " + data.getDepartment());
        holder.cSem.setText("Semester : " + data.getSemester());
        holder.cGroup.setText("Group : " + data.getGroup());
        holder.cShift.setText("Shift : " + data.getShift());
        number = data.getNumber();

        holder.copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) holder.cName.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", data.getNumber());
                clipboard.setPrimaryClip(clip);
                Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class CaptainView extends RecyclerView.ViewHolder {
        MaterialCardView cardView;
        TextView cName, cNumber, cDpt, cSem, cGroup, cShift;
        ImageView copy;

        public CaptainView(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cCard);
            cName = itemView.findViewById(R.id.cName);
            cNumber = itemView.findViewById(R.id.cNumber);
            cDpt = itemView.findViewById(R.id.cDpt);
            cSem = itemView.findViewById(R.id.cSemester);
            cGroup = itemView.findViewById(R.id.cGroup);
            cShift = itemView.findViewById(R.id.cShift);
            copy = itemView.findViewById(R.id.copy);
        }
    }
}
