package com.yelinang.antro.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.nineoldandroids.view.ViewHelper;

/**
 * Created by Ye Lin Aung on 14/09/23.
 */

/**
 * Transformer from
 * http://developer.android.com/training/animation/screen-slide.html#pagetransformer
 * With modification with nineoldandroids
 */
public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
  private static final float MIN_SCALE = 0.85f;
  private static final float MIN_ALPHA = 0.5f;

  @Override public void transformPage(View view, float v) {

    int pageWidth = view.getWidth();
    int pageHeight = view.getHeight();

    if (v < -1) { // [-Infinity,-1)
      // This page is way off-screen to the left.
      ViewHelper.setAlpha(view, 0);
    } else if (v <= 1) { // [-1,1]
      // Modify the default slide transition to shrink the page as well
      float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(v));
      float vertMargin = pageHeight * (1 - scaleFactor) / 2;
      float horzMargin = pageWidth * (1 - scaleFactor) / 2;
      if (v < 0) {
        ViewHelper.setTranslationX(view, horzMargin - vertMargin / 2);
      } else {
        ViewHelper.setTranslationX(view, -horzMargin + vertMargin / 2);
      }

      // Scale the page down (between MIN_SCALE and 1)
      ViewHelper.setScaleX(view, scaleFactor);
      ViewHelper.setScaleY(view, scaleFactor);

      // Fade the page relative to its size.
      ViewHelper.setAlpha(view,
          MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA));
    } else { // (1,+Infinity]
      // This page is way off-screen to the right.
      ViewHelper.setAlpha(view, 0);
    }
  }
}
