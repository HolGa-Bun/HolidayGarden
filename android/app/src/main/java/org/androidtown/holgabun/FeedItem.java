package org.androidtown.holgabun;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.androidtown.holgabun.R;

public class FeedItem {

    String feedtime;
    String boldernum;
    String feedId;
    Bitmap feedImage;
    String feedText;

    public FeedItem(String feedId, Bitmap feedImage, String feedText, String boldernum, String feedtime) {

        this.feedId = feedId;
        this.feedImage = feedImage;
        this.feedText = feedText;
        this.feedtime=feedtime;
        this.boldernum=boldernum;
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