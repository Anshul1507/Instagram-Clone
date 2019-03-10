package utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import home.HomeActivity;
import likes.LikesActivity;
import profile.ProfileActivity;
import practice.module.com.instagram.R;
import search.SearchActivity;
import share.ShareActivity;

public class BottomNavigationHelper {

    public static void enableNaviagtion(final Context context, BottomNavigationView view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.ic_house:
                        Intent intent_house = new Intent(context, HomeActivity.class);
                        context.startActivity(intent_house);
                        break;
                    case R.id.ic_search:
                        Intent intent_search = new Intent(context, SearchActivity.class);
                        context.startActivity(intent_search);
                        break;
                    case R.id.ic_circle:
                        Intent intent_circle = new Intent(context, ShareActivity.class);
                        context.startActivity(intent_circle);
                        break;
                    case R.id.ic_alert:
                        Intent intent_alert = new Intent(context, LikesActivity.class);
                        context.startActivity(intent_alert);
                        break;
                    case R.id.ic_android:
                        Intent intent_android = new Intent(context, ProfileActivity.class);
                        context.startActivity(intent_android);
                        break;
                }
                return false;
            }
        });
    }
}
