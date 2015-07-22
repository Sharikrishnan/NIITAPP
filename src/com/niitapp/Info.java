package com.niitapp;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("NewApi")
public class Info extends Fragment {

	@SuppressLint("NewApi")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		// List of rivers
		String[] menus = getResources().getStringArray(R.array.menus);

		// Creating view corresponding to the fragment
		View v = inflater.inflate(R.layout.info, container, false);
		

		final TextView tv1=(TextView)v.findViewById(R.id.card1);
		final TextView tv2=(TextView)v.findViewById(R.id.card2);
		final TextView tv3=(TextView)v.findViewById(R.id.card3);
		final TextView tv4=(TextView)v.findViewById(R.id.card4);
		final TextView tv5=(TextView)v.findViewById(R.id.card5);
		final TextView tv6=(TextView)v.findViewById(R.id.card6);
		final TextView tv7=(TextView)v.findViewById(R.id.card7);

		tv1.setText("Classes Postponed!!!!");
	
		tv1.setOnClickListener(new View.OnClickListener() {
			
			int count1=0;
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(count1%2==0)
					tv1.setText("Classes Postponed!!!\nDue to blah blah blah classes for this weekend have been postponed to tuesday.");
				else
					tv1.setText("Classes Postponed!!!");
				count1++;
				
			}
		});
		
		tv2.setText("Exams Scheduled!!!");
		
		tv2.setOnClickListener(new View.OnClickListener() {
			
			int count2=0;
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(count2%2==0)
					tv2.setText("Exams Scheduled!!!\nExams for all batch students have been scheduled.");
				else
					tv2.setText("Exams Scheduled!!!");
				count2++;
				
			}
		});
		
		tv3.setText("Exams Scheduled!!!");
		//tv3.setTextColor(color.black);
		
		tv3.setOnClickListener(new View.OnClickListener() {
			
			int count3=0;
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(count3%2==0)
					tv3.setText("Exams Scheduled!!!\nExams for all batch students have been scheduled.");
				else
					tv3.setText("Exams Scheduled!!!");
				count3++;
				
			}
		});
		tv4.setText("Exams Scheduled!!!");
		//tv3.setTextColor(color.black);
		
		tv4.setOnClickListener(new View.OnClickListener() {
			
			int count4=0;
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(count4%2==0)
					tv4.setText("Exams Scheduled!!!\nExams for all batch students have been scheduled.");
				else
					tv4.setText("Exams Scheduled!!!");
				count4++;
				
			}
		});
		tv5.setText("Exams Scheduled!!!");
		//tv3.setTextColor(color.black);
		
		tv5.setOnClickListener(new View.OnClickListener() {
			
			int count5=0;
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(count5%2==0)
					tv5.setText("Exams Scheduled!!!\nExams for all batch students have been scheduled.");
				else
					tv5.setText("Exams Scheduled!!!");
				count5++;
				
			}
		});
		tv6.setText("Exams Scheduled!!!");
		//tv3.setTextColor(color.black);
		
		tv6.setOnClickListener(new View.OnClickListener() {
			
			int count6=0;
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(count6%2==0)
					tv6.setText("Exams Scheduled!!!\nExams for all batch students have been scheduled.");
				else
					tv6.setText("Exams Scheduled!!!");
				count6++;
				
			}
		});
		tv7.setText("Exams Scheduled!!!");
		//tv3.setTextColor(color.black);
		
		tv7.setOnClickListener(new View.OnClickListener() {
			
			int count7=0;
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(count7%2==0)
					tv7.setText("Exams Scheduled!!!\nExams for all batch students have been scheduled.");
				else
					tv7.setText("Exams Scheduled!!!");
				count7++;
				
			}
		});
		return v;
	}
}