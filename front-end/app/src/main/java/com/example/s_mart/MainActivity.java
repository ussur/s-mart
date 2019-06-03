package com.example.s_mart;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //private TextView mTextMessage;

   /* private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    loadFragment(HomeFragment.newInstance());
                    return true;
                case R.id.navigation_filters:
                    mTextMessage.setText(R.string.title_filters);
                    return true;
                case R.id.navigation_favorites:
                    mTextMessage.setText(R.string.title_favorites);
                    return true;
                case R.id.navigation_profile:
                    mTextMessage.setText(R.string.title_profile);
                    return true;
            }
            return false;
        }
    };
    */
   private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
           = new BottomNavigationView.OnNavigationItemSelectedListener() {

       @Override
       public boolean onNavigationItemSelected(@NonNull MenuItem item) {
           switch (item.getItemId()) {
               case R.id.navigation_home:
                   loadFragment(HomeFragment.newInstance());
                   return true;
               case R.id.navigation_filters:
                   loadFragment(FiltersAddFragment.newInstance());
                   return true;
               case R.id.navigation_favorites:
                   loadFragment(FavoritesAddFragment.newInstance());
                   return true;
               case R.id.navigation_profile:
                   loadFragment(ProfileFragment.newInstance());
                   return true;
           }
           return false;
       }
   };

    public void loadFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl_content, fragment);
        ft.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Fragment fragment = new HomeFragment();
        loadFragment(fragment);
    }

}
