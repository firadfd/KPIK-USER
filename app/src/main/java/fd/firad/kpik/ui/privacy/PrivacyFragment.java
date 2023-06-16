package fd.firad.kpik.ui.privacy;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import fd.firad.kpik.R;


public class PrivacyFragment extends Fragment {


    private WebView privacyView;
    private ProgressBar progressBarPrivacy;

    public PrivacyFragment() {
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_privacy, container, false);
        privacyView = v.findViewById(R.id.privacyView);
        progressBarPrivacy = v.findViewById(R.id.progressbarPrivacy);
        privacyView.getSettings().setJavaScriptEnabled(true);
        privacyView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressBarPrivacy.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }
        });
        privacyView.loadUrl(getResources().getString(R.string.privacy_policy));






        return v;
    }
}