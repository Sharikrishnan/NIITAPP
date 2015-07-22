package com.niitapp;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.niitapp.library.UserFunctions;

public class SelectionActivity extends Activity {

	UserFunctions userFunctions;
	private Button b[]=new Button[5];
	private int i;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		userFunctions= new UserFunctions();
		if(userFunctions.isUserLoggedIn(getApplicationContext()))
		{
			setContentView(R.layout.selection);
			
			getActionBar().setTitle("NIIT");
			
			int exit= getIntent().getIntExtra("exit", -1);
			if(exit==0)
			{
				finishAffinity();
				System.exit(0);
			}
			
		OnClickListener listener =new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int a=(Integer) v.getTag();
				Intent i=new Intent(getApplicationContext(),MainActivity.class);
				i.putExtra("selected", a);
				startActivity(i);
			}
		};
		
		b[0]=(Button)findViewById(R.id.button1);
		b[1]=(Button)findViewById(R.id.button2);
		b[2]=(Button)findViewById(R.id.button3);
		b[3]=(Button)findViewById(R.id.button4);
		b[4]=(Button)findViewById(R.id.button5);
		
		//int i=0;
		for(i=0;i<5;i++)
		{
			b[i].setOnClickListener(listener);
			b[i].setTag(i);
		}
		}
		else
		{
			// user is not logged in show login screen
        	Intent login = new Intent(getApplicationContext(), Login.class);
        	login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        	startActivity(login);
        	// Closing dashboard screen
        	finish();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.selection, menu);
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
		if(id == R.id.logout)
		{
			userFunctions.logoutUser(getApplicationContext());
			Intent login = new Intent(getApplicationContext(), Login.class);
        	login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        	startActivity(login);
        	// Closing dashboard screen
        	finish();
		}
		return super.onOptionsItemSelected(item);
	}

}
