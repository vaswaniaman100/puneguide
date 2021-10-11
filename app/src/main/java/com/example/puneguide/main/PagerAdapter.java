package com.example.puneguide.main;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    int numberoftab;
    public PagerAdapter(FragmentManager fm,int nft) {
        super(fm);
        this.numberoftab=nft;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
            tab1 t1 = new tab1();
            return t1;

            case 1:
                tab3 t3 = new tab3();
                return t3;
            case 2:
                tab4 t4 = new tab4();
                return t4;

            default :
                return null;
        }

    }

    @Override
    public int getCount() {
        return numberoftab;
    }
}
