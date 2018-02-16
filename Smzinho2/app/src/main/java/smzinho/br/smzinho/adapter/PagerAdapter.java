package smzinho.br.smzinho.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import smzinho.br.smzinho.View.TabPatreon;
import smzinho.br.smzinho.fragments.ChannelFragment;
import smzinho.br.smzinho.fragments.VlogFragment;
import smzinho.br.smzinho.fragments.PlayListFragment;

/**
 * Created by Marcos Vinícius on 11/01/2018.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                ChannelFragment tab1 = new ChannelFragment();
                return tab1;
            case 1:
                VlogFragment tab2 = new VlogFragment();
                return tab2;
            case 2:
                PlayListFragment tab3 = new PlayListFragment();
                return tab3;
            case 3:
                TabPatreon tab4 = new TabPatreon();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
