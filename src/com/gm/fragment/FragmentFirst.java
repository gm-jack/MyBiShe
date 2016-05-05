package com.gm.fragment;

import com.gm.myshop.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class FragmentFirst extends Fragment {
	private static final String TAG="FragmentFirst";
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.frag1, null);
		TextView tv=new TextView(getActivity());
		LinearLayout.LayoutParams params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		getActivity().addContentView(tv, params);
		tv.setTextSize(15.0f);
		tv.setText(TAG);
		return view;
	}
}
