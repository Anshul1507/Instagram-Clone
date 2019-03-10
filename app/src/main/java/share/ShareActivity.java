package share;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;

import practice.module.com.instagram.R;
import utils.BottomNavigationHelper;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupBottomNavigationView();
    }

    //BottomNavigationView setup
    private void setupBottomNavigationView(){
        BottomNavigationView view = findViewById(R.id.bottomNavViewBar);
        BottomNavigationHelper.enableNaviagtion(ShareActivity.this,view);
    }
}
