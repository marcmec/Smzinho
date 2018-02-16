package smzinho.br.smzinho;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import br.smzinho.app_smzinho.adapter.ViewAdapter;

public class TabMain extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    private TabLayout tabLayout = null;
    private ViewPager viewPager = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_main);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        //setting the tabs title
        tabLayout.addTab(tabLayout.newTab().setText("Salve"));
        tabLayout.addTab(tabLayout.newTab().setText("Parabéns"));
        tabLayout.addTab(tabLayout.newTab().setText("Política"));
        tabLayout.addTab(tabLayout.newTab().setText("Patreon"));

        //ADS
        MobileAds.initialize(this,"id do seu/your adview admob-");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("id do seu/your adview admob");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
                                          @Override
                                          public void onAdLoaded() {
                                              // Code to be  when an ad finishes loading.
                                              mInterstitialAd.show();
                                          }
                                      });
        //setup the view pager
        final ViewAdapter adapter = new br.smzinho.app_smzinho.adapter.ViewAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
