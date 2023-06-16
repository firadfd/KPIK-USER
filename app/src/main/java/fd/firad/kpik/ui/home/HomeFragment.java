package fd.firad.kpik.ui.home;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;

import fd.firad.kpik.R;


public class HomeFragment extends Fragment {

    private ImageCarousel imageCarousel;


    public HomeFragment() {

    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        imageCarousel = view.findViewById(R.id.carousel);
        ImageView map = view.findViewById(R.id.map);
        RelativeLayout cmdDpt, ctDpt, etDpt, entDpt, mtDpt, cntDpt, aidtDpt;
        cmdDpt = view.findViewById(R.id.goCmt);
        ctDpt = view.findViewById(R.id.goCivil);
        etDpt = view.findViewById(R.id.goEct);
        entDpt = view.findViewById(R.id.goEnt);
        mtDpt = view.findViewById(R.id.goMt);
        cntDpt = view.findViewById(R.id.goCnt);
        aidtDpt = view.findViewById(R.id.goAidt);


        slideImage();

        map.setOnClickListener(v -> openMap());

//        cmdDpt.setOnClickListener(v -> goToDepartment(view));
//        ctDpt.setOnClickListener(v -> goToDepartment(view));
//        etDpt.setOnClickListener(v -> goToDepartment(view));
//        entDpt.setOnClickListener(v -> goToDepartment(view));
//        mtDpt.setOnClickListener(v -> goToDepartment(view));
//        cntDpt.setOnClickListener(v -> goToDepartment(view));
//        aidtDpt.setOnClickListener(v -> goToDepartment(view));


        return view;
    }


//    private void goToDepartment(View view) {
//        Navigation.findNavController(view)
//                .navigate(R.id.action_navigationHome_to_navigationDepartments);
//    }

    private void openMap() {
        Uri uri = Uri.parse("geo:25.802561,89.634954");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    private void slideImage() {
        ArrayList<CarouselItem> cList = new ArrayList<>();
        cList.add(new CarouselItem(R.drawable.kpik__first));
        cList.add(new CarouselItem(R.drawable.kpik__three));
        cList.add(new CarouselItem(R.drawable.kpik__two));
        cList.add(new CarouselItem(R.drawable.kpik__four));
        imageCarousel.setData(cList);
    }

}