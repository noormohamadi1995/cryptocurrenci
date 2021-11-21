package ir.abbas.cryptocurrency;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;

import ir.abbas.cryptocurrency.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    NavHostFragment navHostFragment;
    NavController navController;
    AppBarConfiguration appBarConfiguration;

    public DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        drawerLayout = activityMainBinding.activityMainDrawerLayout;

        setUpNavigationComponent();
    }

    private void setUpNavigationComponent(){
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();

        appBarConfiguration = new AppBarConfiguration.Builder(R.id.homeFragment,R.id.marketFragment,R.id.watchListFragment)
                .setOpenableLayout(activityMainBinding.activityMainDrawerLayout)
                .build();

        NavigationUI.setupWithNavController(activityMainBinding.activityMainNavigationView,navController);
        setUpBottomNavigationMenu();
    }

    private void setUpBottomNavigationMenu(){
        PopupMenu popupMenu = new PopupMenu(this,null);
        popupMenu.inflate(R.menu.bottom_navigation_menu);
        Menu menu = popupMenu.getMenu();
        activityMainBinding.bottomBar.setupWithNavController(menu,navController);
    }
}