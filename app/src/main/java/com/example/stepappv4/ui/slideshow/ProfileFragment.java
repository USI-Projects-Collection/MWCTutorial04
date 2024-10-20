package com.example.stepappv4.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import com.example.stepappv4.R;

public class ProfileFragment extends Fragment {

    private Switch darkModeSwitch;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        // Find the switch in the fragment's layout
        darkModeSwitch = root.findViewById(R.id.switch1);

        // Set the switch text based on the current theme
        updateSwitchText();

        // Set up the listener for the switch
        darkModeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Enable dark mode and update the text
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                darkModeSwitch.setText("Dark Mode");
            } else {
                // Enable light mode and update the text
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                darkModeSwitch.setText("Light Mode");
            }
        });

        return root;
    }

    // Method to set the initial text of the switch based on the current mode
    private void updateSwitchText() {
        int currentNightMode = getResources().getConfiguration().uiMode & android.content.res.Configuration.UI_MODE_NIGHT_MASK;
        if (currentNightMode == android.content.res.Configuration.UI_MODE_NIGHT_YES) {
            // Dark mode is active
            darkModeSwitch.setChecked(true);
            darkModeSwitch.setText("Dark Mode");
        } else {
            // Light mode is active
            darkModeSwitch.setChecked(false);
            darkModeSwitch.setText("Light Mode");
        }
    }
}
