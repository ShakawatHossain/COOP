package com.gnt.COOP;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by Roger-1 on 5/17/2016.
 */
public class Pager extends FragmentStatePagerAdapter {

    int tabCount;

    public Pager(FragmentManager fm, int tabCount) {
        super(fm);

        this.tabCount = tabCount;
    }



    @Override
    public Fragment getItem(int position) {

        if (position == 0)
        {
            return new EventTab();
        }
        else if (position == 1)
        {
            return new NewsTab();
        }
        else if(position == 2)
        {
            return new PlaceHolderTab1();
        }
        else if(position == 3)
        {
            return new PlaceHolderTab2();
        }

        Log.e("Custom error shabab", "Getting an error at pager getItem" );

        return null;
    }

    @Override
    public int getCount() {

        return tabCount;
    }
}
