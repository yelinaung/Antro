package com.yelinang.antro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Ye Lin Aung on 14/09/23.
 */
public class HomeActivity extends ActionBarActivity {
  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.home_activity);
    ButterKnife.inject(this);
  }

  @OnClick(R.id.pager_intro) void goToIntroWithVP() {
    Intent intent = new Intent(this, IntroWithViewPagerActivity.class);
    startActivity(intent);
  }
}
