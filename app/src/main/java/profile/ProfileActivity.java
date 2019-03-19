package profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.ArrayList;

import practice.module.com.instagram.R;
import utils.BottomNavigationHelper;
import utils.GridImageAdapter;
import utils.UniversalImageLoader;

public class ProfileActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private ImageView profilePhoto;
    private static final int ACTIVITY_NUM = 4;
    private Context mContext;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);



        setupToolBar();
        setupBottomNavigationView();
        setupActivityWidgets();
        setProfileImage();
        tempGridSetup();
    }

    private void tempGridSetup(){
        ArrayList<String> imgURLs = new ArrayList<>();
        imgURLs.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQjnJlwAJi3GwkcxnVxUo9myrjbEDbnUGAecNlbHpHQUz-_OHJKiA");
        imgURLs.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSZ6ZcAziLNp9PmnVF4zlISsObm6awN5DN88YEYrcIoiplxVRCITw");
        imgURLs.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZeBodvL2esU7fpb3WTRmw9mBD0G7kWbE5V9z7wDkkgGxBEtoITw");
        imgURLs.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQKR6k9wC9jXjWLH17mvdz4WDCT_BIOuzH5U8VJsmLUsjxZIVEG");
        imgURLs.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVOkAcVjo20njfM2R3QH0mmKrET-h1nDH1lCRYsUxYJYYcyzHDcg");
        imgURLs.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTDXBV0WrdhQuKZSg8jrlPvONoDX0mwMyb_Hkmz8kEwwVJDU_bl");
        imgURLs.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3ogBkt2qWvyOxI1Ak5omOo2nsA_DyAj17GsDIt3Esah5-xlrZ");
        imgURLs.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTmjrLvKk0QWyMWYdAd1uJVaPMfWyxSMXYsishJxPbKwiii-F4I");
        imgURLs.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR-CvkyEHg0g69t68vaGANWW8m17zkCSZw37VB3ce7Y4Jblfkc67w");

        setupImageGrid(imgURLs);
    }
    private void setupImageGrid(ArrayList<String> imgURLs){
        GridView gridView = findViewById(R.id.gridView);
        if(mContext != null ) {
            GridImageAdapter adapter = new GridImageAdapter(mContext, R.layout.layout_grid_imageview, "", imgURLs);
            gridView.setAdapter(adapter);
        }
    }
    private void setProfileImage(){
        String imgURL = "crackberry.com/sites/crackberry.com/files/topic_images/2013/ANDROID.png";
        UniversalImageLoader.setImage(imgURL,profilePhoto,mProgressBar,"https://");
    }

    private void setupActivityWidgets(){
        mProgressBar = findViewById(R.id.profileProgressBar);
        mProgressBar.setVisibility(View.GONE);
        profilePhoto = findViewById(R.id.profile_image);
    }
    private void setupToolBar(){
        Toolbar toolbar = findViewById(R.id.profileToolBar);
        setSupportActionBar(toolbar);

        ImageView profileMenu = findViewById(R.id.profileMenu);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AccountSettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    //BottomNavigationView setup
    private void setupBottomNavigationView(){
        BottomNavigationView view = findViewById(R.id.bottomNavViewBar);
        BottomNavigationHelper.enableNaviagtion(ProfileActivity.this,view);

        //for popping the active state of home icon
        Menu menu = view.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
