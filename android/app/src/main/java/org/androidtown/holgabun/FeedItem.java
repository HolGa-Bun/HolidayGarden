package org.androidtown.holgabun;

import android.graphics.Bitmap;
<<<<<<< HEAD
=======
import android.graphics.BitmapFactory;
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a

import org.androidtown.holgabun.R;

public class FeedItem {
<<<<<<< HEAD
    Bitmap feedIdImage;
=======

>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
    String feedtime;
    String boldernum;
    String feedId;
    Bitmap feedImage;
    String feedText;

<<<<<<< HEAD
    public FeedItem(Bitmap feedIdImage, String feedId, Bitmap feedImage, String feedText,String boldernum,String feedtime) {
        this.feedIdImage = feedIdImage;
=======
    public FeedItem(String feedId, Bitmap feedImage, String feedText, String boldernum, String feedtime) {

>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
        this.feedId = feedId;
        this.feedImage = feedImage;
        this.feedText = feedText;
        this.feedtime=feedtime;
        this.boldernum=boldernum;
    }

<<<<<<< HEAD
    public Bitmap getFeedIdImage() {
        return feedIdImage;
    }
=======

>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a

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

<<<<<<< HEAD
    public void setFeedIdImage(Bitmap feedIdImage) {
        this.feedIdImage = feedIdImage;
    }
=======

>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a

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