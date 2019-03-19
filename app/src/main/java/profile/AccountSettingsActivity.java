package profile;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import home.HomeActivity;
import practice.module.com.instagram.R;
import utils.BottomNavigationHelper;
import utils.SectionsStatePagerAdapter;

public class AccountSettingsActivity extends AppCompatActivity {

    private Context context;

    private static final int ACTIVITY_NUM = 4;
    private SectionsStatePagerAdapter pagerAdapter;
    private ViewPager mViewPager;
    private RelativeLayout mRelativeLayout;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_account_settings);
        context = AccountSettingsActivity.this;
        mRelativeLayout = findViewById(R.id.relLayout1);
        mViewPager = findViewById(R.id.container);

//        setupBottomNavigationView();
        setupSettingsList();

        setupFragment();

        //setup back  arrow for navigating to profile activity
        ImageView backArrow = findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setupFragment(){
        pagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new EditProfileFragment(),getString(R.string.edit_profile));
        pagerAdapter.addFragment(new SignOutFragment(),getString(R.string.sign_out));

    }

    private void setViewPager(int fragmentNumber){
        mRelativeLayout.setVisibility(View.GONE);
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setCurrentItem(fragmentNumber);
    }
    private void setupSettingsList(){
        ListView listView = findViewById(R.id.listViewAccountSettings);

        ArrayList<String> options = new ArrayList<>();
        options.add(getString(R.string.edit_profile));
        options.add(getString(R.string.sign_out));

        ArrayAdapter adapter = new ArrayAdapter(context,android.R.layout.simple_list_item_1,options);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                setViewPager(i);
            }
        });
    }

    //BottomNavigationView setup
//    private void setupBottomNavigationView(){
//        BottomNavigationView view = findViewById(R.id.bottomNavViewBar);
//        BottomNavigationHelper.enableNaviagtion(AccountSettingsActivity.this,view);
//
//        //for popping the active state of home icon
//        Menu menu = view.getMenu();
//        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
//        menuItem.setChecked(true);
//    }
}
