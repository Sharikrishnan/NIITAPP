package com.niitapp;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
 
/**
 * Pieced together from:
 * Android samples: com.example.android.apis.view.ExpandableList1
 * http://androidword.blogspot.com/2012/01/how-to-use-expandablelistview.html
 * http://stackoverflow.com/questions/6938560/android-fragments-setcontentview-alternative
 * http://stackoverflow.com/questions/6495898/findviewbyid-in-fragment-android
 */
@SuppressLint("NewApi")
public class Schedule extends Fragment {
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.schedule, container, false);
        ExpandableListView elv = (ExpandableListView) v.findViewById(R.id.list);
        elv.setAdapter(new SavedTabsListAdapter());
        return v;
    }
 
    public class SavedTabsListAdapter extends BaseExpandableListAdapter {
 
        private String[] groups = { "13 sep","14 Sep", "20 Sep", "21 Sep", "27 Sept","28 sep","04 oct","05 oct","11 oct","12oct","17oct" };
 
        private String[][] children = {
            { "4.00-5.00->chapter 2", "5.00-5.30->chapter 3", "5.30-6.00->chapter 4" },
            {  "4.00-5.00->chapter 2", "5.00-5.30->chapter 3", "5.30-6.00->chapter 4" },
            {  "4.00-5.00->chapter 2", "5.00-5.30->chapter 3", "5.30-6.00->chapter 4" },
            {  "4.00-5.00->chapter 2", "5.00-5.30->chapter 3", "5.30-6.00->chapter 4" },
            {  "4.00-5.00->chapter 2", "5.00-5.30->chapter 3", "5.30-6.00->chapter 4" },
            {  "4.00-5.00->chapter 2", "5.00-5.30->chapter 3", "5.30-6.00->chapter 4" },
            {  "4.00-5.00->chapter 2", "5.00-5.30->chapter 3", "5.30-6.00->chapter 4" },
            {  "4.00-5.00->chapter 2", "5.00-5.30->chapter 3", "5.30-6.00->chapter 4" },
            {  "4.00-5.00->chapter 2", "5.00-5.30->chapter 3", "5.30-6.00->chapter 4" },
            {  "4.00-5.00->chapter 2", "5.00-5.30->chapter 3", "5.30-6.00->chapter 4" },
            {  "4.00-5.00->chapter 2", "5.00-5.30->chapter 3", "5.30-6.00->chapter 4" }
        };
 
        @Override
        public int getGroupCount() {
            return groups.length;
        }
 
        @Override
        public int getChildrenCount(int i) {
            return children[i].length;
        }
 
        @Override
        public Object getGroup(int i) {
            return groups[i];
        }
 
        @Override
        public Object getChild(int i, int i1) {
            return children[i][i1];
        }
 
        @Override
        public long getGroupId(int i) {
            return i;
        }
 
        @Override
        public long getChildId(int i, int i1) {
            return i1;
        }
 
        @Override
        public boolean hasStableIds() {
            return true;
        }
 
        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(Schedule.this.getActivity());
            textView.setText(" "+getGroup(i).toString());
            textView.setTextSize(30);
            textView.setTextColor(Color.WHITE);
            return textView;
        }
 
        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(Schedule.this.getActivity());
            textView.setText("   "+getChild(i, i1).toString());
            textView.setTextSize(18);
            textView.setTextColor(Color.WHITE);
            return textView;
        }
 
        @Override
        public boolean isChildSelectable(int i, int i1) {
            return true;
        }
 
    }
 
}