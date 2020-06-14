

package com.mydogapplication;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;
public class MainActivity extends AppCompatActivity {
ViewPager viewPager;
PagerTabStrip pagerTabStrip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(adapter);
        pagerTabStrip=(PagerTabStrip)findViewById(R.id.titleTab);
        pagerTabStrip.setTabIndicatorColor(Color.BLUE);
    }


}