package org.androidtown.holgabun;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import org.androidtown.holgabun.Tab_fragment2_Search_Account;

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    // Count number of tabs
    private int tabCount;

    public TabPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        // Returning the current tabs
        switch (position) {
            case 0:
                Tab_fragment1_Search_Account tab_fragment1_search_account = new Tab_fragment1_Search_Account();
                return tab_fragment1_search_account;
            case 1:
                Tab_fragment2_Search_Account tab_fragment2_search_account = new Tab_fragment2_Search_Account();
                return tab_fragment2_search_account;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0:
                return "아이디 찾기";
            case 1:
                return "비밀번호 찾기";
            default:
                return null;
        }
    }
}

