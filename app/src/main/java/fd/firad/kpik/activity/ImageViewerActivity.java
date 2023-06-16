package fd.firad.kpik.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ortiz.touchview.TouchImageView;
import com.squareup.picasso.Picasso;

import fd.firad.kpik.R;

public class ImageViewerActivity extends AppCompatActivity {

    private TouchImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);


        imageView = findViewById(R.id.image);
        Intent intent = getIntent();
        String url = intent.getStringExtra("linkImage");

        try {
            Picasso.get().load(url).into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}