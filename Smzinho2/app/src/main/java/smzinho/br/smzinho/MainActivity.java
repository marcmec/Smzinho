package smzinho.br.smzinho;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.github.clans.fab.FloatingActionMenu;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout = null;
    private ViewPager viewPager = null;
    private AdView mAdView;
    private FloatingActionMenu mFAB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        //setting the tabs title
        tabLayout.addTab(tabLayout.newTab().setText("Vlog"));
        tabLayout.addTab(tabLayout.newTab().setText("Smzinho"));
        tabLayout.addTab(tabLayout.newTab().setText("Playlist"));
        tabLayout.addTab(tabLayout.newTab().setText("Apoie"));

        //admob
        MobileAds.initialize(this, "id do seu/your adview admob-");


        mAdView = findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder()
                .build();

        mAdView.loadAd(adRequest);

        //setup the view pager
        final PagerAdapter adapter = new smzinho.br.smzinho.adapter.PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
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

        mFAB = (FloatingActionMenu) findViewById(R.id.menufab);
        mFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickIg(view);
                ClickDisc(view);
                ClickFace(view);
                ClickTwitter(view);
                ClickTwitch(view);
            }
        });

}
    public void ClickIg(View v) {

        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/_u/smzinho")));
    }

    public void ClickDisc(View v) {

        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("-")));
    }

    public void ClickFace(View v) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Smzinho/")));
    }

    public void ClickTwitter(View v) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/smzinho")));
    }

    public void ClickTwitch(View v) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.twitch.tv/Smzinho")));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.content_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();


        if(id== R.id.salve_id){
            Intent intent = new Intent(this, TabMain.class);
            startActivity(intent);

            return true;
        }
        if (id == R.id.politicamenu) {

            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://blogsmzinhoapp.wordpress.com/politica-de-privacidade/")));

        }
        return super.onOptionsItemSelected(item);
    }

    //admob listener
    /** Called when leaving the activity */
    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    /** Called when returning to the activity */
    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    /** Called before the activity is destroyed */
    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }

}
