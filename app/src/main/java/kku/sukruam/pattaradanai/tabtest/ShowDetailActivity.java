package kku.sukruam.pattaradanai.tabtest;



import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;



public class ShowDetailActivity extends AppCompatActivity {
    private int resId;
    private String bakegrill;
    private String description;
    private ImageView imageView;
    //private TextView tvDescription;
    private TextView tvbakegrill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        initInstances();
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
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


    private void initInstances() {

        resId = getIntent().getIntExtra("resId",0);
        bakegrill = getIntent().getStringExtra("bakegrill");
        //description = getIntent().getStringExtra("desc");

        //tvDescription = (TextView) findViewById(R.id.desc);
        tvbakegrill = (TextView) findViewById(R.id.title);
        imageView = (ImageView) findViewById(R.id.image);

        //tvDescription.setText(description);
        tvbakegrill.setText(bakegrill);
        imageView.setImageResource(resId);
    }

}

