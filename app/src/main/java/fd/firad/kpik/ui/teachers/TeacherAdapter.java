package fd.firad.kpik.ui.teachers;

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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import fd.firad.kpik.R;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherView> {
    private Context context;
    private ArrayList<TeacherModel> list;
    private DatabaseReference database;
    private String url, dpt;
    private String key;

    public TeacherAdapter(Context context, ArrayList<TeacherModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TeacherView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.teachers_simple_layout, parent, false);
        database = FirebaseDatabase.getInstance().getReference();
        return new TeacherView(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherView holder, int position) {
        TeacherModel data = list.get(position);
        holder.name.setText("Name : " + data.getName());
        holder.number.setText("Number : " + data.getNumber());
        holder.post.setText("Post : " + data.getPost());

        if (data.getDepartment().equals("PRINCIPAL")) {
            holder.dpt.setVisibility(View.GONE);
            holder.shift.setVisibility(View.GONE);
        } else if (data.getDepartment().equals("OTHERS")) {
            holder.dpt.setVisibility(View.GONE);
            holder.shift.setVisibility(View.GONE);

        } else {
            holder.shift.setText("Shift : " + data.getShift());
            holder.dpt.setText("Dpt : " + data.getDepartment());
        }
        key = data.getKey();
        dpt = data.getDepartment();
        url = data.getTecImgUrl();
        try {
            Picasso.get().load(data.tecImgUrl).into(holder.profileImg);
        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) holder.name.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
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

    public static class TeacherView extends RecyclerView.ViewHolder {
        CircleImageView profileImg;
        TextView name, number, post, dpt, shift;
        MaterialCardView cardView;
        ImageView copy;


        public TeacherView(@NonNull View itemView) {
            super(itemView);
            profileImg = itemView.findViewById(R.id.profile_image);
            name = itemView.findViewById(R.id.tName);
            number = itemView.findViewById(R.id.tNumber);
            post = itemView.findViewById(R.id.tPost);
            dpt = itemView.findViewById(R.id.tDpt);
            shift = itemView.findViewById(R.id.tShift);
            cardView = itemView.findViewById(R.id.tCard);
            copy = itemView.findViewById(R.id.copyNumber);

        }
    }
}

