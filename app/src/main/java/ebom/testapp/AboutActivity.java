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


import aboutus.aboutAnnouncements;
import aboutus.aboutContact;
import aboutus.aboutNews;


public class AboutActivity extends MainActivity {
    TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            setContentView(R.layout.menu);


            //Id Array Creation
            String[] idArray = {"Mission", "Announcements", "News", "Contact Us"};

            //Send to hash
            entFunct.create(idArray);

            TextView heading = (TextView) findViewById(R.id.header);
            heading.setText("About");
            ListView mlistView = (ListView) findViewById(R.id.people_menu);
            mlistView.setAdapter(new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,
                    new String[]{"Mission", "Announcements", "News", "Contact Us"}));

            mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // When clicked, show a toast with the TextView text Game, Help, Home

                    String sText = ((TextView) view).getText().toString();
                    Intent intent = null;
                    if (sText.equals("Mission")) {
                        entFunct.click("Mission");
                        intent = new Intent(getBaseContext(),
                                aboutMission.class);
                    }
                    if (sText.equals("Announcements")) {
                        entFunct.click("Announcements");
                        intent = new Intent(getBaseContext(),
                                aboutAnnouncements.class);
                    }
                    if (sText.equals("News")) {
                        entFunct.click("News");
                        intent = new Intent(getBaseContext(),
                                aboutNews.class);
                    }
                    if (sText.equals("Contact Us")) {
                        entFunct.click("Contact Us");
                        intent = new Intent(getBaseContext(),
                                aboutContact.class);
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