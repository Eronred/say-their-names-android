package com.blm.saytheirnames.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.blm.saytheirnames.R;
import com.blm.saytheirnames.customTabs.CustomTabActivityHelper;
import com.blm.saytheirnames.customTabs.WebViewActivity;
import com.blm.saytheirnames.utils.CustomTabUtil;

public class AboutFragment extends Fragment {

    private View myFragment;

    String twitterLink = "https://twitter.com/SayTheirName_io";
    String slackLink = "https://app.slack.com/client/T014JL5B3SN/C014X92G997";
    String repoLink = "https://github.com/Say-Their-Name/";

    private Button btnTwitter,btnSlack,btnRepo;

    private Toolbar toolbar;


    public static AboutFragment newInstance() {
        return new AboutFragment();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myFragment = inflater.inflate(R.layout.fragment_about, container, false);

        toolbar = myFragment.findViewById(R.id.toolbar);
        toolbar.setTitle("");
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);

        btnRepo = myFragment.findViewById(R.id.btnViewRepo);
        btnTwitter = myFragment.findViewById(R.id.btnFollowUs);
        btnSlack = myFragment.findViewById(R.id.btnSlackChannel);

        btnRepo.setOnClickListener(v -> {
         visitPages(repoLink);
        });
        btnSlack.setOnClickListener(v -> {
        visitPages(slackLink);
        });
        btnTwitter.setOnClickListener(v -> visitPages(twitterLink));

        return myFragment;
    }

    private void visitPages(String link) {
        CustomTabUtil.openCustomTabForUrl(requireActivity(), link);
    }

}