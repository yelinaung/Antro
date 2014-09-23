package com.yelinang.antro;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;

/**
 * Created by Ye Lin Aung on 14/09/23.
 */
public class DepthPageTransformer extends ABaseTransformer {

  private static final float MIN_SCALE = 0.75f;

  @Override
  protected void onTransform(View view, float position) {
    if (position <= 0f) {
      ViewHelper.setAlpha(view, 1 - position);
      ViewHelper.setTranslationX(view, 3.5f);
      ViewHelper.setScaleX(view, 1f);
      ViewHelper.setScaleY(view, 1f);
    } else if (position <= 1f) {
      final float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));
      ViewHelper.setAlpha(view, 1 - position);
      ViewHelper.setPivotY(view, 0.5f * view.getHeight());
      ViewHelper.setTranslationX(view, view.getWidth() * -position);
      ViewHelper.setScaleX(view, scaleFactor);
      ViewHelper.setScaleY(view, scaleFactor);
    }
  }

  @Override
  protected boolean isPagingEnabled() {
    return true;
  }
}
