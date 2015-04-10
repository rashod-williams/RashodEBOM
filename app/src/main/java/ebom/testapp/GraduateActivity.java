package ebom.testapp;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.TextView;



import graduate.gradAdvising;
import graduate.gradDescriptions;
import graduate.gradListings;
import graduate.gradOpenings;


public class GraduateActivity extends MainActivity {
    TextView textView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            setContentView(R.layout.menu);

            //Create ID Array
            String[] idArray = {"Advising Sheets", "Course Openings", "Course Listings", "Course Descriptions"};

            //Send to hash
            entFunct.create(idArray);

            TextView heading = (TextView) findViewById(R.id.header);
            heading.setText("Graduate");
            ListView mlistView = (ListView) findViewById(R.id.people_menu);
            mlistView.setAdapter(new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,
                    new String[] {"Advising Sheets", "Course Openings","Course Listings","Course Descriptions"}));

            mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // When clicked, show a toast with the TextView text Game, Help, Home

                    String sText = ((TextView) view).getText().toString();
                    Intent intent = null;
                    if(sText.equals("Advising Sheets")) {
                        entFunct.click("Advising Sheets");
                        intent = new Intent(getBaseContext(),
                                gradAdvising.class);
                    }
                    if(sText.equals("Course Openings")) {
                        entFunct.click("Course Openings");
                        intent = new Intent(getBaseContext(),
                                gradOpenings.class);
                    }
                    if(sText.equals("Course Listings")) {
                        entFunct.click("Course Listings");
                        intent = new Intent(getBaseContext(),
                                gradListings.class);
                    }
                    if(sText.equals("Course Descriptions")) {
                        entFunct.click("Course Description");
                        intent = new Intent(getBaseContext(),
                                gradDescriptions.class);
                    }
                    //else if(sText.equals("Help")) ..........

                    if(intent != null)
                        startActivity(intent);
                }
            });
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}