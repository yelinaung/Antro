package com.yelinang.antro;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Ye Lin Aung on 14/09/23.
 */
public class SlidingAdapter extends FragmentPagerAdapter {

  private Context mContext;
  private int mFragmentCount;
  private int indicatorCount;

  public SlidingAdapter(FragmentManager fm, Context context, int mFragmentCount) {
    super(fm);
    this.mContext = context;
    this.mFragmentCount = mFragmentCount;
  }

  @Override public Fragment getItem(int position) {
    Fragment f = null;
    for (int i = 0; i < mFragmentCount; i++) {
      f = SampleFragment.newInstance("" + position);
    }
    return f;
  }

  @Override public int getCount() {
    return mFragmentCount;
  }
}
