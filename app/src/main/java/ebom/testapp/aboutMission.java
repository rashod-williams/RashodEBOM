package ebom.testapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import ebom.testapp.R;

public class aboutMission extends MainActivity {


    TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_activity);
        textView = (TextView) findViewById(R.id.textView);


        textView.setText("Under Construction!");

        Button testButton = (Button)findViewById(R.id.testButton);
        testButton.setOnClickListener(
            new Button.OnClickListener(){
                public void onClick(View v){
                    entFunct.count();
                    entFunct.calcEntropy();
                    TextView test = (TextView)findViewById(R.id.testText);
                    test.setText(Double.toString(entFunct.displayOne("People")));
                    adapter.notifyDataSetChanged();
                }
            }

        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}