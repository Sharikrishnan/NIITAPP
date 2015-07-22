package com.niitapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.niitapp.library.UserFunctions;

public class MainActivity extends Activity {

	private int count=0;
	UserFunctions userFunctions;
	// Within which the entire activity is enclosed
	private DrawerLayout mDrawerLayout;

	// ListView represents Navigation Drawer
	private ListView mDrawerList;

	// ActionBarDrawerToggle indicates the presence of Navigation Drawer in the action bar
	private ActionBarDrawerToggle mDrawerToggle;

	// Title of the action bar
	private String mTitle = "";
	private boolean doubleBackToExitPressedOnce= false;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		
		
			setContentView(R.layout.main);
		
			// Getting an array of rivers
			final String[] menuItems = getResources().getStringArray(R.array.menus);		

			// Getting reference to the DrawerLayout
			mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

			mDrawerList = (ListView) findViewById(R.id.drawer_list);

			// Getting reference to the ActionBarDrawerToggle
			mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
					R.drawable.ic_drawer, R.string.drawer_open,
					R.string.drawer_close) {

				/** Called when drawer is closed */
				public void onDrawerClosed(View view) {
					getActionBar().setTitle(mTitle);
					invalidateOptionsMenu();

				}

				/** Called when a drawer is opened */
				public void onDrawerOpened(View drawerView) {
					getActionBar().setTitle("NIIT");
					invalidateOptionsMenu();
				}
			};

			int selected = getIntent().getIntExtra("selected", 0);
			selectItem(selected);
			
			mTitle = menuItems[selected];
			getActionBar().setTitle(mTitle);

			// Closing the drawer
			mDrawerLayout.closeDrawer(mDrawerList);
			// Setting DrawerToggle on DrawerLayout
			mDrawerLayout.setDrawerListener(mDrawerToggle);

			// Creating an ArrayAdapter to add items to the listview mDrawerList
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), 
			R.layout.drawer_list_item, getResources().getStringArray(R.array.menus));

			// Setting the adapter on mDrawerList
			mDrawerList.setAdapter(adapter);

			// Enabling Home button
			getActionBar().setHomeButtonEnabled(true);

			// Enabling Up navigation
			getActionBar().setDisplayHomeAsUpEnabled(true);

			// Setting item click listener for the listview mDrawerList
			mDrawerList.setOnItemClickListener(new OnItemClickListener() {
				
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				// Currently selected river
				mTitle = menuItems[position];

				selectItem(position);

				}
			});
		
	}

	@SuppressLint("NewApi")
	public void selectItem(int position)
	{
		// Getting reference to the FragmentManager
		FragmentManager fragmentManager = getFragmentManager();

		// Creating a fragment transaction
		FragmentTransaction ft = fragmentManager.beginTransaction();

					
		switch(position)
		{
		case 0:
			Schedule f1 = new Schedule();
			
			// Adding a fragment to the fragment transaction
			ft.replace(R.id.content_frame, f1);

			// Committing the transaction
			ft.commit();

			// Closing the drawer
			mDrawerLayout.closeDrawer(mDrawerList);
			break;
		case 1:
			Courses f2 = new Courses();
			
			// Adding a fragment to the fragment transaction
			ft.replace(R.id.content_frame, f2);

			// Committing the transaction
			ft.commit();

			// Closing the drawer
			mDrawerLayout.closeDrawer(mDrawerList);
			break;
		case 2:
			Info f3 = new Info();
			
			// Adding a fragment to the fragment transaction
			ft.replace(R.id.content_frame, f3);

			// Committing the transaction
			ft.commit();

			// Closing the drawer
			mDrawerLayout.closeDrawer(mDrawerList);
			break;
		case 3:
			OnlineAssessmentSelection f4 = new OnlineAssessmentSelection();
			
			// Adding a fragment to the fragment transaction
			ft.replace(R.id.content_frame, f4);

			// Committing the transaction
			ft.commit();

			// Closing the drawer
			mDrawerLayout.closeDrawer(mDrawerList);
			break;
		case 4:
			Download f5 = new Download();
			
			// Adding a fragment to the fragment transaction
			ft.replace(R.id.content_frame, f5);

			// Committing the transaction
			ft.commit();

			// Closing the drawer
			mDrawerLayout.closeDrawer(mDrawerList);
			break;
		}
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}

	@Override
	public void onBackPressed() {
	    if (doubleBackToExitPressedOnce) {
	    	Intent i= new Intent(getApplicationContext(),SelectionActivity.class);
	    	i.putExtra("exit", 0);
	    	startActivity(i);
	        super.onBackPressed();
	        return;
	    }

	    this.doubleBackToExitPressedOnce = true;
	    Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

	    new Handler().postDelayed(new Runnable() {

	        @Override
	        public void run() {
	            doubleBackToExitPressedOnce=false;                       
	        }
	    }, 2000);
	}

	/** Called whenever we call invalidateOptionsMenu() */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// If the drawer is open, hide action items related to the content view
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);

		menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.selection, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}	
	
}
