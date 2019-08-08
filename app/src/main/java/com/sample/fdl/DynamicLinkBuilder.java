package com.sample.fdl;

import android.net.Uri;

public class DynamicLinkBuilder {

    private String dynamicLink = "https://sampleappfdl.ovh/instant";

    public DynamicLinkBuilder(String link) {
        this.dynamicLink += "?link=" + link;
    }

    public DynamicLinkBuilder addMinVersion(int minVersion){
        dynamicLink += "&amv=" + minVersion;
        return this;
    }

    public DynamicLinkBuilder addIosUrl(String iosUrl){
        dynamicLink += "&ifl=" + iosUrl;
        return this;
    }

    public DynamicLinkBuilder addDesktopUrl(String desktopUrl){
        dynamicLink += "&ofl=" + desktopUrl;
        return this;
    }

    public DynamicLinkBuilder addFallbackUrl(String fallbackUrl){
        dynamicLink += "&afl=" + fallbackUrl;
        return this;
    }

    public DynamicLinkBuilder addPackageName(String packageName){
        dynamicLink += "&apn=" + packageName;
        return this;
    }

    public DynamicLinkBuilder addSocialMediaLogo(String logoUrl){
        dynamicLink += "&si=" + logoUrl;
        return this;
    }

    public DynamicLinkBuilder addSocialMediaTitle(String title){
        dynamicLink += "&st=" + Uri.encode(title);
        return this;
    }

    public DynamicLinkBuilder addSocialMediaDescription(String description){
        dynamicLink += "&sd=" + Uri.encode(description);
        return this;
    }

    public String build(){
        return dynamicLink;
    }


}