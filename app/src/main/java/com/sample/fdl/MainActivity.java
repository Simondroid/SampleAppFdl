package com.sample.fdl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(v -> createShortDynamicLink());
    }

    private void createShortDynamicLink() {
        FirebaseDynamicLinks.getInstance().createDynamicLink()
                .setLongLink(
                        Uri.parse(
                                new DynamicLinkBuilder("https://sampleappfdl.ovh")
                                        .addPackageName("com.sample")
                                        .addMinVersion(Integer.MAX_VALUE)
                                        .addFallbackUrl("https://sampleappfdl.ovh/instant/my_custom_params_I_want_to_get_in_my_instant_app")
                                        .addDesktopUrl("https://sampleappfdl.ovh")
                                        .addSocialMediaLogo("https://sports-map.com/logo.png")
                                        .addSocialMediaTitle("Custom Media Title")
                                        .addSocialMediaDescription("Custom Description")
                                        .build()
                        )
                )
                .buildShortDynamicLink()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Uri shortLink = task.getResult().getShortLink();
                        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("", shortLink.toString());
                        clipboard.setPrimaryClip(clip);

                        Toast toast = Toast.makeText(this, "The link has been pasted in the clipboard", Toast.LENGTH_LONG);
                        toast.show();
                    } else {
                        Log.e("", task.getException().getMessage());
                    }
                });
    }
}
