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
    public static final Entropy entFunct = new Entropy();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //Expandable List Adapters


        try {
            setContentView(R.layout.activity_main);
            //Need to create an instance of Entropy


            Exp_list = (ExpandableListView) findViewById(R.id.favorites);
            Fav_category = FavoriteData.getInfo();
            Fav_list = new ArrayList<String>(Fav_category.keySet());
            adapter = new FavoriteAdapter(this, Fav_category, Fav_list);
            Exp_list.setAdapter(adapter);

            //For now need to identify the id array. This may be able to be called below?
            String[] idArray = {"People", "Undergraduate", "Graduate", "About Us"};

            //Creates the array
            entFunct.create(idArray);

            ListView mlistView = (ListView) findViewById(R.id.main_menu);
            mlistView.setAdapter(new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,
                    new String[] {"People", "Undergraduate","Graduate", "About Us"}));

            mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {


                    String sText = ((TextView) view).getText().toString();
                    Intent intent = null;
                    if(sText.equals("People")) {
                        //Each one of these has an add for when clicked
                        entFunct.click("People");
                        intent = new Intent(getBaseContext(),
                                PeopleActivity.class);
                    }
                    if(sText.equals("Undergraduate")) {
                        entFunct.click("Undergraduate");
                        intent = new Intent(getBaseContext(),
                                UndergradActivity.class);
                    }
                    if(sText.equals("Graduate")) {
                        entFunct.click("Graduate");
                        intent = new Intent(getBaseContext(),
                                GraduateActivity.class);
                    }
                    if(sText.equals("About Us")) {
                        entFunct.click("About Us");
                       intent = new Intent(getBaseContext(),
                                AboutActivity.class);
                    }


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