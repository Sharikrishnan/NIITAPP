package com.niitapp;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

@SuppressLint("NewApi")
public class OnlineAssessmentSelection extends Fragment {

	private RadioButton rb;
	private RadioGroup r;
	private Button b;
	
	@SuppressLint("NewApi")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		String[] menus = getResources().getStringArray(R.array.menus);

		// Creating view corresponding to the fragment
		final View v = inflater.inflate(R.layout.onlineassessmentselection, null);

		// Getting reference to the FragmentManager
		FragmentManager fragmentManager = getFragmentManager();

		// Creating a fragment transaction
		final FragmentTransaction ft = fragmentManager.beginTransaction();
		
		r = (RadioGroup)v.findViewById(R.id.select);
		b= (Button) v.findViewById(R.id.button1);
			
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				int selected = r.getCheckedRadioButtonId();
				if(!r.isSelected())
				{
					Toast.makeText(getActivity(), "Choose an option!!!", Toast.LENGTH_SHORT).show();
				}
				rb=(RadioButton)v.findViewById(selected);

				/*OnlineAssessment f1 = new OnlineAssessment();
				
				// Adding a fragment to the fragment transaction
				ft.replace(R.id.content_frame, f1);

				// Committing the transaction
				ft.commit();*/
				if(rb.getText()==null)
				{
					Toast.makeText(getActivity(), "Choose an option!!!", Toast.LENGTH_SHORT).show();
				}
				Intent i = new Intent(getActivity(),OnlineAssessment.class);
				i.putExtra("selectedrbtn", rb.getText());
				OnlineAssessmentSelection.this.startActivity(i);
				
				Toast.makeText(getActivity(), rb.getText(), Toast.LENGTH_SHORT).show();
			}
		});
 		return v;
	}
}