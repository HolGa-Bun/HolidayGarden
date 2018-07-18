package org.androidtown.holgabun;

import android.graphics.Bitmap;

import org.androidtown.holgabun.R;

public class FeedItem {
    Bitmap feedIdImage;
    String feedtime;
    String boldernum;
    String feedId;
    Bitmap feedImage;
    String feedText;

    public FeedItem(Bitmap feedIdImage, String feedId, Bitmap feedImage, String feedText,String boldernum,String feedtime) {
        this.feedIdImage = feedIdImage;
        this.feedId = feedId;
        this.feedImage = feedImage;
        this.feedText = feedText;
        this.feedtime=feedtime;
        this.boldernum=boldernum;
    }

    public Bitmap getFeedIdImage() {
        return feedIdImage;
    }

    public String getFeedId() {
        return feedId;
    }

    public Bitmap getFeedImage() {
        return feedImage;
    }

    public String getFeedText() {
        return feedText;
    }

    public String getFeedTime(){return feedtime;};

    public String getBoldernum(){return boldernum;};

    public void setFeedIdImage(Bitmap feedIdImage) {
        this.feedIdImage = feedIdImage;
    }

    public void setFeedId(String feedId) {
        this.feedId = feedId;
    }

    public void setFeedImage(Bitmap feedImage) {
        this.feedImage = feedImage;
    }

    public void setFeedText(String feedText) {
        this.feedText = feedText;
    }
}