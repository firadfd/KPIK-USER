package fd.firad.kpik.ui.pdfnotice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import fd.firad.kpik.activity.PdfViewActivity;
import fd.firad.kpik.R;

public class PdfAdapter extends RecyclerView.Adapter<PdfAdapter.PdfView> {

    private Context context;
    private ArrayList<PdfModel> list;
    private DatabaseReference database;
    private String key;

    public PdfAdapter(Context context, ArrayList<PdfModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public PdfView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.pdf_simple_layout, parent, false);
        database = FirebaseDatabase.getInstance().getReference();
        return new PdfView(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PdfView holder, @SuppressLint("RecyclerView") int position) {
        PdfModel data = list.get(position);
        holder.title.setText(data.getPdfTitle());
        holder.time.setText(data.getTime());
        holder.date.setText(data.getDate());

        key = data.getUniqueKey();

        holder.pdfCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, PdfViewActivity.class);
                intent.putExtra("url", list.get(position).getDownLoadUrl().toString());
                context.startActivity(intent);
            }
        });

        holder.download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(list.get(position).getDownLoadUrl().toString()));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class PdfView extends RecyclerView.ViewHolder {
        CircleImageView download;
        TextView title, time, date;
        MaterialCardView pdfCard;

        public PdfView(@NonNull View itemView) {
            super(itemView);
            download = itemView.findViewById(R.id.downloadPdf);
            title = itemView.findViewById(R.id.pdfTitle);
            time = itemView.findViewById(R.id.pdfTime);
            date = itemView.findViewById(R.id.pdfDate);
            pdfCard = itemView.findViewById(R.id.pdfCard);
        }
    }
}
