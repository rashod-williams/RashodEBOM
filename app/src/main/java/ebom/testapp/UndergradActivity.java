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




import undergrad.undergradAdvising;
import undergrad.undergradDescriptions;
import undergrad.undergradListings;
import undergrad.undergradOpenings;


public class UndergradActivity extends MainActivity {
    TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            setContentView(R.layout.menu);


            //Create Id Array
            String[] idArray = {"UG Advising Sheets", "UG Course Openings", "UG Course Listings", "UG Course Descriptions"};

            //Send to Hash
            entFunct.create(idArray);

            TextView heading = (TextView) findViewById(R.id.header);
            heading.setText("Undergraduate");
            ListView mlistView = (ListView) findViewById(R.id.people_menu);
            mlistView.setAdapter(new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,
                    new String[]{"UG Advising Sheets", "UG Course Openings", "UG Course Listings", "UG Course Descriptions"}));

            mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // When clicked, show a toast with the TextView text Game, Help, Home

                    String sText = ((TextView) view).getText().toString();
                    Intent intent = null;
                    if (sText.equals("UG Advising Sheets")) {
                        entFunct.click("UG Advising Sheets");
                        intent = new Intent(getBaseContext(),
                                undergradAdvising.class);
                    }
                    if (sText.equals("UG Course Openings")) {
                        entFunct.click("UG Course Openings");
                        intent = new Intent(getBaseContext(),
                                undergradOpenings.class);
                    }
                    if (sText.equals("UG Course Listings")) {
                        entFunct.click("UG Course Listings");
                        intent = new Intent(getBaseContext(),
                                undergradListings.class);
                    }
                    if (sText.equals("UG Course Descriptions")) {
                        entFunct.click("UG Course Descriptions");
                        intent = new Intent(getBaseContext(),
                                undergradDescriptions.class);
                    }
                    //else if(sText.equals("Help")) ..........

                    if (intent != null)
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