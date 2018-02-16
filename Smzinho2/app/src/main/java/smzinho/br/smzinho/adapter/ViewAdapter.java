package smzinho.br.smzinho.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import smzinho.br.smzinho.View.BugsMain;
import smzinho.br.smzinho.View.Politica;
import smzinho.br.smzinho.View.TabAniversarioFrag;
import smzinho.br.smzinho.View.TabSalveFragments;

/**
 * Created by Marcos Vinícius on 11/01/2018.
 */

public class ViewAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public ViewAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabSalveFragments tab1 = new TabSalveFragments();
                return tab1;
            case 1:
                TabAniversarioFrag tab2 = new TabAniversarioFrag();
                return tab2;
            case 2:
                BugsMain tab3 = new BugsMain();
                return tab3;
            case 3:
                Politica tab4 = new Politica();
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
