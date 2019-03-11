package profile;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import practice.module.com.instagram.R;
import utils.BottomNavigationHelper;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        setupToolBar();
        setupBottomNavigationView();
    }

    private void setupToolBar(){
        Toolbar toolbar = findViewById(R.id.profileToolBar);
        setSupportActionBar(toolbar);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){

                }
                return false;
            }
        });
    }
    //BottomNavigationView setup
    private void setupBottomNavigationView(){
        BottomNavigationView view = findViewById(R.id.bottomNavViewBar);
        BottomNavigationHelper.enableNaviagtion(ProfileActivity.this,view);
    }
}
