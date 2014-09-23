package com.yelinang.antro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class SampleFragment extends Fragment {
  private static final String ARG_PARAM1 = "param1";

  private String mParam1;

  @InjectView(R.id.blank_fragment) TextView blankFragment;

  public static SampleFragment newInstance(String param1) {
    SampleFragment fragment = new SampleFragment();
    Bundle args = new Bundle();
    args.putString(ARG_PARAM1, param1);
    fragment.setArguments(args);
    return fragment;
  }

  public SampleFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      mParam1 = getArguments().getString(ARG_PARAM1);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View rootView = inflater.inflate(R.layout.fragment_sample, container, false);
    ButterKnife.inject(this, rootView);
    int count = Integer.valueOf(mParam1) + 1;
    blankFragment.setText("Hello Fragment " + count);
    return rootView;
  }
}
