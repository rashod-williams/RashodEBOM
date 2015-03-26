package ebom.testapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends Activity {

    //Expandable List Hash Map
    HashMap<String, List<String>> Fav_category;
    List<String> Fav_list;
    ExpandableListView Exp_list;
    FavoriteAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //Expandable List Adapters


        try {
            setContentView(R.layout.activity_main);

            Exp_list = (ExpandableListView) findViewById(R.id.favorites);
            Fav_category = FavoriteData.getInfo();
            Fav_list = new ArrayList<String>(Fav_category.keySet());
            adapter = new FavoriteAdapter(this, Fav_category, Fav_list);
            Exp_list.setAdapter(adapter);

            ListView mlistView = (ListView) findViewById(R.id.main_menu);
            mlistView.setAdapter(new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,
                    new String[] {"People", "Undergraduate","Graduate", "About Us","Junk"}));

            mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // When clicked, show a toast with the TextView text Game, Help, Home

                    String sText = ((TextView) view).getText().toString();
                    Intent intent = null;
                    if(sText.equals("People"))
                        intent = new Intent(getBaseContext(),
                                PeopleActivity.class);

                    if(sText.equals("Undergraduate"))
                        intent = new Intent(getBaseContext(),
                                PeopleActivity.class);

                    if(sText.equals("Graduate"))
                        intent = new Intent(getBaseContext(),
                                PeopleActivity.class);

                    if(sText.equals("About Us"))
                        intent = new Intent(getBaseContext(),
                                PeopleActivity.class);
                    if(sText.equals("Junk"))
                        intent = new Intent(getBaseContext(),
                                JunkActivity.class);
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
}