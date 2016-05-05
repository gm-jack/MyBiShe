package com.gm.myshop;

import com.gm.fragment.FragmentFirst;
import com.gm.fragment.FragmentFour;
import com.gm.fragment.FragmentSecond;
import com.gm.fragment.FragmentThree;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract.Colors;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends FragmentActivity {
	private static final String TAG = "MainActivity";
	private FragmentTabHost tabhost;
	private TabSpec tabspec;
	private Class[] fragment = { FragmentFirst.class, FragmentSecond.class,
			FragmentThree.class, FragmentFour.class, };
	private LayoutInflater inflate;
	private RadioGroup radio;
	private RadioButton rbtn1,rbtn2,rbtn3,rbtn4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initview();
		inittab();
		initlistener();
	}

	private void initlistener() {
		radio.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.radio_btn1:
					tabhost.setCurrentTab(0);
					rbtn1.setTextColor(Color.GREEN);
					rbtn2.setTextColor(Color.WHITE);
					rbtn3.setTextColor(Color.WHITE);
					rbtn4.setTextColor(Color.WHITE);
					break;
				case R.id.radio_btn2:
					tabhost.setCurrentTab(1);
					rbtn1.setTextColor(Color.WHITE);
					rbtn2.setTextColor(Color.GREEN);
					rbtn3.setTextColor(Color.WHITE);
					rbtn4.setTextColor(Color.WHITE);
					break;
				case R.id.radio_btn3:
					tabhost.setCurrentTab(2);
					rbtn1.setTextColor(Color.WHITE);
					rbtn2.setTextColor(Color.WHITE);
					rbtn3.setTextColor(Color.GREEN);
					rbtn4.setTextColor(Color.WHITE);
					
					break;
				case R.id.radio_btn4:
					tabhost.setCurrentTab(3);
					rbtn1.setTextColor(Color.WHITE);
					rbtn2.setTextColor(Color.WHITE);
					rbtn3.setTextColor(Color.WHITE);
					rbtn4.setTextColor(Color.GREEN);
					break;
				}
			}
		});
	}

	private void inittab() {
		inflate = LayoutInflater.from(this);
		tabhost.setup(MainActivity.this, getSupportFragmentManager(),
				R.id.realcontent);
		/**
		 * fragment使用tabhost循环添加会出现标签不会响应
		 */
		// for (int i = 0; i < fragment.length; i++) {
		// tabspec=tabhost.newTabSpec(""+(i+1));
		// tabhost.addTab(tabspec.setIndicator(inflate.inflate(R.layout.empty,
		// null)), fragment[0], null);
		// }
		tabspec = tabhost.newTabSpec("1");
		tabhost.addTab(
				tabspec.setIndicator(inflate.inflate(R.layout.empty, null)),
				fragment[0], null);
		tabspec = tabhost.newTabSpec("2");
		tabhost.addTab(
				tabspec.setIndicator(inflate.inflate(R.layout.empty, null)),
				fragment[1], null);
		tabspec = tabhost.newTabSpec("3");
		tabhost.addTab(
				tabspec.setIndicator(inflate.inflate(R.layout.empty, null)),
				fragment[2], null);
		tabspec = tabhost.newTabSpec("4");
		tabhost.addTab(
				tabspec.setIndicator(inflate.inflate(R.layout.empty, null)),
				fragment[3], null);

	}

	private void initview() {
		tabhost = (FragmentTabHost) findViewById(R.id.tabhost);
		radio = (RadioGroup) findViewById(R.id.radio_group);
		rbtn1=(RadioButton) findViewById(R.id.radio_btn1);
		rbtn2=(RadioButton) findViewById(R.id.radio_btn2);
		rbtn3=(RadioButton) findViewById(R.id.radio_btn3);
		rbtn4=(RadioButton) findViewById(R.id.radio_btn4);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
