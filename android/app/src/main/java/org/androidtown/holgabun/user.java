package org.androidtown.holgabun;

public class user {
    String nickname;
    String follow;
    String recently_time;


    public user (String name,String follow , String recently_time){
        this.nickname=name;
        this.follow = follow;
        this.recently_time = recently_time;
    }

    public String getName(){
        return nickname;
    }

    public void setName(String name){
        this.nickname = name;
    }

    public String getfollow(){ return follow;
    }

    public void setfollow(String follow){
        this.follow = follow;
    }

    public String getRecently_time(){
        return recently_time;
    }

    public void setAddress(String recently_time){
        this.recently_time = recently_time;
    }
}
