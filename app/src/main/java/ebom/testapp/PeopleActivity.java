package ebom.testapp;



        import android.os.Bundle;
        import android.app.Activity;
        import android.content.Intent;
        import android.view.Menu;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ExpandableListView;
        import android.widget.ListView;
        import android.widget.TextView;

        import java.util.ArrayList;

        import people.AdminActivity;
        import people.FacultyActivity;

public class PeopleActivity extends Activity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            setContentView(R.layout.menu);

            ListView mlistView = (ListView) findViewById(R.id.people_menu);
            mlistView.setAdapter(new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,
                    new String[] {"Administration", "Faculty"}));

            mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // When clicked, show a toast with the TextView text Game, Help, Home

                    String sText = ((TextView) view).getText().toString();
                    Intent intent = null;
                    if(sText.equals("Administration"))
                        intent = new Intent(getBaseContext(),
                                AdminActivity.class);

                    if(sText.equals("Faculty"))
                        intent = new Intent(getBaseContext(),
                                FacultyActivity.class);

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