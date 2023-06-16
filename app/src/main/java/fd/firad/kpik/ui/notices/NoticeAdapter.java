package fd.firad.kpik.ui.notices;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fd.firad.kpik.R;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeView> {
    private Context context;
    private ArrayList<noticeModel> list;

    public NoticeAdapter(Context context, ArrayList<noticeModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NoticeView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.notice_simple_layout, parent, false);
        return new NoticeView(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeView holder, int position) {
        noticeModel data = list.get(position);
        holder.time.setText(data.getTime());
        holder.date.setText(data.getDate());
        holder.title.setText(data.getTitle());


        List<String> cList = new ArrayList<>();
        for (String img : data.imgUrl) {
            cList.add(img);
        }

        ChildImageAdapter childImageAdapter;
        childImageAdapter = new ChildImageAdapter(cList, context);
        holder.child_img.setAdapter(childImageAdapter);
        holder.child_img.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.child_img.setHasFixedSize(true);
        childImageAdapter.notifyDataSetChanged();


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class NoticeView extends RecyclerView.ViewHolder {
        private CardView cardView;
        private TextView time, date, title;
        private RecyclerView child_img;


        public NoticeView(@NonNull View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.noticeTime);
            date = itemView.findViewById(R.id.noticeDate);
            title = itemView.findViewById(R.id.noticeTitle);
            child_img = itemView.findViewById(R.id.imageChild);
            cardView = itemView.findViewById(R.id.view_image);

        }
    }
}
