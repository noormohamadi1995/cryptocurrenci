package ir.abbas.cryptocurrency.marketFragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ir.abbas.cryptocurrency.MainActivity;
import ir.abbas.cryptocurrency.R;
import ir.abbas.cryptocurrency.databinding.FragmentMarketBinding;

public class MarketFragment extends Fragment {
    FragmentMarketBinding fragmentMarketBinding;
    MainActivity mainActivity;
    NavController navController;
    AppBarConfiguration appBarConfiguration;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpToolbar(view);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentMarketBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_market,container,false);
        return fragmentMarketBinding.getRoot();
    }

    private void setUpToolbar(View view){
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        navController = Navigation.findNavController(view);
        appBarConfiguration = new AppBarConfiguration.Builder(R.id.marketFragment)
                .setOpenableLayout(mainActivity.drawerLayout)
                .build();
        NavigationUI.setupWithNavController(toolbar,navController,appBarConfiguration);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.marketFragment){
                toolbar.setNavigationIcon(R.drawable.ic_baseline_sort_24);
                toolbar.setTitle("Market");
            }
        });
    }
}