package com.gm.myshop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {
	private static final String TAG = "LoginActivity";
	private AutoCompleteTextView user;
	private TextView password;
	private CheckBox autologin, remember;
	private Button login;
	private TextView register, getpsw;

	private String name, psw;
	private boolean isFist = false;
	private SharedPreferences share;

	private String[] attr = { "111", "2222", "3333", "5555", "4444" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		share = getSharedPreferences(TAG, 1);
		user = (AutoCompleteTextView) findViewById(R.id.login_username);
		password = (EditText) findViewById(R.id.login_password);
		autologin = (CheckBox) findViewById(R.id.login_autologin);
		remember = (CheckBox) findViewById(R.id.login_remember);
		login = (Button) findViewById(R.id.login_loginbtn);
		register = (TextView) findViewById(R.id.login_register);
		getpsw = (TextView) findViewById(R.id.login_getpassword);

		login.setOnClickListener(new MyOnClickListener(0));
		register.setOnClickListener(new MyOnClickListener(1));
		getpsw.setOnClickListener(new MyOnClickListener(2));

		ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(LoginActivity.this,
				android.R.layout.simple_dropdown_item_1line, attr);
		user.setAdapter(mAdapter);
		// user.setOnItemClickListener(new OnItemClickListener() {
		//
		// @Override
		// public void onItemClick(AdapterView<?> parent, View view,
		// int position, long id) {
		// }
		// });
		autologin.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked) {

				} else {

				}
			}
		});
		remember.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked) {

				} else {

				}
			}
		});

	}

	class MyOnClickListener implements OnClickListener {
		private int index;
		private Intent intent;

		public MyOnClickListener(int i) {
			this.index = i;
		}

		@Override
		public void onClick(View v) {
			name = user.getText().toString().trim();
			psw = password.getText().toString().trim();
			Log.i(TAG, "账号" + name + "," + "密码" + psw);
			switch (index) {
			case 0:
				if ((!"".equals(name)) && (!"".equals(psw))) {
					Editor editor = share.edit();
					// if (share.getBoolean("isFirst", true)) {
					// editor.putString("name", name);
					// editor.putString("psw", psw);
					// editor.putBoolean("isFirst", isFist);
					// editor.commit();
					// }else{
					// name=share.getString("name", "");
					// psw=share.getString("psw", "");
					// }
					Log.i(TAG, "账号" + name + "," + "密码" + psw);
					// FileWriter file=new FileWriter(new File());
					intent = new Intent(LoginActivity.this, MainActivity.class);
					startActivity(intent);
				}
				break;
			case 1:
				intent = new Intent(LoginActivity.this, RegisterActivity.class);
				startActivity(intent);
				break;
			case 2:
				intent = new Intent(LoginActivity.this, LoseActivity.class);
				startActivity(intent);
				break;
			}

		}

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
