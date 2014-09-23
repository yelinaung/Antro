package com.yelinang.antro;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.viewpagerindicator.LinePageIndicator;

public class IntroWithViewPagerActivity extends ActionBarActivity {

  @InjectView(R.id.my_pager) ViewPager mPager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my);
    ButterKnife.inject(this);

    ActionBar mActionBar = getSupportActionBar();

    if (mActionBar != null) {
      mActionBar.hide();
    }

    FragmentManager fm = getSupportFragmentManager();

    mPager.setAdapter(new SlidingAdapter(fm, IntroWithViewPagerActivity.this, 5));
    mPager.setPageTransformer(true, new DepthPageTransformer());

    LinePageIndicator titleIndicator = (LinePageIndicator) findViewById(R.id.indicator);
    titleIndicator.setViewPager(mPager);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.my, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
