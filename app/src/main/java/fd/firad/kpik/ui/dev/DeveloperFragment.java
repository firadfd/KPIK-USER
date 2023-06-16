package fd.firad.kpik.ui.dev;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import fd.firad.kpik.R;


public class DeveloperFragment extends Fragment {
    private ImageView fb1, gmail1, github1, linkedin1, fb2, gmail2, github2, linkedin2, fb3, gmail3, github3, linkedin3;

    public DeveloperFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_developer, container, false);


        initialization(v);

        fb1.setOnClickListener(v1 -> {
            openFacebook("fb://profile/100015614383239", "https://www.facebook.com/Firad.Fd");
        });

        gmail1.setOnClickListener(v1 -> {
            sendMail("contact.firadfd@gmail.com");
        });
        github1.setOnClickListener(v1 -> {
            openGithub("https://github.com/FiradFd");
        });
        linkedin1.setOnClickListener(v1 -> {
            openLinkedin("https://www.linkedin.com/in/firad-fd");
        });



        fb2.setOnClickListener(v1 -> {
            openFacebook("fb://profile/100012223985301", "www.facebook.com/freelancerriead");
        });

        gmail2.setOnClickListener(v1 -> {
            sendMail("rieadyt@gmail.com");
        });
        github2.setOnClickListener(v1 -> {
            openGithub("https://github.com/rieadyt");
        });
        linkedin2.setOnClickListener(v1 -> {
            openLinkedin("https://www.linkedin.com/in/ReyadHasan");
        });


        fb3.setOnClickListener(v1 -> {
            openFacebook("fb://profile/100015779117184", "https://www.facebook.com/profile.php?id=100015779117184");
        });

        gmail3.setOnClickListener(v1 -> {
            sendMail("nir40885@gmail.com");
        });
        github3.setOnClickListener(v1 -> {
            openGithub("https://github.com/mdrony5134");
        });
        linkedin3.setOnClickListener(v1 -> {
            openLinkedin("https://www.linkedin.com/in/nazrul-islam-rony/");
        });







        return v;
    }

    private void openLinkedin(String linkedinLink) {
        String YourPageURL = linkedinLink;
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(YourPageURL));
        startActivity(browserIntent);
    }

    private void openGithub(String githubLink) {
        String YourPageURL = githubLink;
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(YourPageURL));
        startActivity(browserIntent);
    }

    private void sendMail(String mail) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", mail, null));
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }

    private void openFacebook(String fbId, String fbLink) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(fbId));
            startActivity(intent);
        } catch (Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(fbLink)));
        }
    }

    private void initialization(View v) {
        fb1 = v.findViewById(R.id.fb1);
        fb2 = v.findViewById(R.id.fb2);
        fb3 = v.findViewById(R.id.fb3);
        gmail1 = v.findViewById(R.id.sendMail1);
        gmail2 = v.findViewById(R.id.sendMail2);
        gmail3 = v.findViewById(R.id.sendMail3);
        github1 = v.findViewById(R.id.github1);
        github2 = v.findViewById(R.id.github2);
        github3 = v.findViewById(R.id.github3);
        linkedin1 = v.findViewById(R.id.linkedin1);
        linkedin2 = v.findViewById(R.id.linkedin2);
        linkedin3 = v.findViewById(R.id.linkedin3);
    }

}