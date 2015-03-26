package ebom.testapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Roto on 3/26/2015.
 */
public class JunkActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.junk_layout);
        ImageView image = (ImageView) findViewById(R.id.imageView2);
    }

}
