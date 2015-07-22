package com.niitapp;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Pieced together from:
 * Android samples: com.example.android.apis.view.ExpandableList1
 * http://androidword.blogspot.com/2012/01/how-to-use-expandablelistview.html
 * http://stackoverflow.com/questions/6938560/android-fragments-setcontentview-alternative
 * http://stackoverflow.com/questions/6495898/findviewbyid-in-fragment-android
 */
@SuppressLint("NewApi")
public class Courses extends Fragment {
 
    private OnClickListener listener;

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.courses, null);
        
        TextView tv1=(TextView)v.findViewById(R.id.card1);
		TextView tv2=(TextView)v.findViewById(R.id.card2);
		TextView tv3=(TextView)v.findViewById(R.id.card3);
		TextView tv4=(TextView)v.findViewById(R.id.card4);
		TextView tv5=(TextView)v.findViewById(R.id.card5);
		TextView tv6=(TextView)v.findViewById(R.id.card6);
		TextView tv7=(TextView)v.findViewById(R.id.card7);
		
		tv1.setText("Java");
		tv2.setText("PYTHON");
		tv3.setText("DOT NET");
		tv4.setText("HTML");
		tv5.setText("c#");
		tv6.setText("xml");
		tv7.setText("Android app");
		final AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
        builder1.setMessage("Do you wanna download this file?");
        builder1.setCancelable(true);
        builder1.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            	Toast.makeText(getActivity(), "Download Begins!!!", Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        });
        builder1.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            	Toast.makeText(getActivity(), "Download Cancelled!!!", Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        });
		
        listener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert11 = builder1.create();
	            alert11.show();
			}
		};
		tv1.setOnClickListener(listener);
		tv2.setOnClickListener(listener);
		tv3.setOnClickListener(listener);
		tv4.setOnClickListener(listener);
		tv5.setOnClickListener(listener);
		tv6.setOnClickListener(listener);
		tv7.setOnClickListener(listener);
        return v;
    }
}
