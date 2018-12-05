package android.practices.findplaces.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.practices.findplaces.Adapter.MainActivityAdapter;
import android.practices.findplaces.R;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

/**
 * Created by Amit on 22-Nov-18.
 */
public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private String[] placeNames = {"Hospitals", "Hotel", "ATM", "Bars"};
    private int[] placeThumbnails = {
            R.drawable.ic_hospital, R.drawable.ic_hotel,
            R.drawable.ic_atm, R.drawable.ic_bars};
    private Class[] activities = {
            HospitalsActivity.class,   // position=0
            HotelsActivity.class,   // position=1
            ATMsActivity.class,   // position=2
            FindBarsActivity.class,   // position=3
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        gridView = findViewById(R.id.gridview);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
        }
        MainActivityAdapter adapterViewAndroid = new MainActivityAdapter(MainActivity.this, placeNames, placeThumbnails);
        gridView.setAdapter(adapterViewAndroid);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this, "GridView Item: " + placeNames[+position], Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), activities[position]));
            }
        });
    }


}
