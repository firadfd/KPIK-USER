package fd.firad.kpik.ui.notices;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import fd.firad.kpik.R;
import fd.firad.kpik.activity.ImageViewerActivity;

public class ChildImageAdapter extends RecyclerView.Adapter<ChildImageAdapter.ChildImageViewHolder> {
    private List<String> list;
    private Context context;


    public ChildImageAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ChildImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.image_child_item, parent, false);
        return new ChildImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildImageViewHolder holder, int position) {

        String data = list.get(position);
        Picasso.get().load(data).into(holder.imageView);

        if (list.size() > 1) {
            holder.next.setVisibility(View.VISIBLE);
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, ImageViewerActivity.class);
                intent.putExtra("linkImage", data);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ChildImageViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView, next;

        public ChildImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageItems);
            next = itemView.findViewById(R.id.nextImage);
        }
    }

}

