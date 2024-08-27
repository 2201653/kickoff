package com.example.forwardProject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MatchFragment extends Fragment {

    private Spinner spinnerCity, spinnerTest, spinnerLevel, spinnerGender;
    private Button buttonApply, buttonApply2, buttonApply3, buttonApply4, buttonApply5,
            buttonApply6, buttonApply7, buttonApply8;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_match, container, false);

        // Initialize the Spinners
        spinnerCity = view.findViewById(R.id.spinner_city);
        spinnerTest = view.findViewById(R.id.spinner_test);
        spinnerLevel = view.findViewById(R.id.spinner_level);
        spinnerGender = view.findViewById(R.id.spinner_gender);

        // Set up the Adapters
        ArrayAdapter<CharSequence> adapterCity = ArrayAdapter.createFromResource(getContext(),
                R.array.cities, android.R.layout.simple_spinner_item);
        adapterCity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCity.setAdapter(adapterCity);

        ArrayAdapter<CharSequence> adapterTest = ArrayAdapter.createFromResource(getContext(),
                R.array.tests, android.R.layout.simple_spinner_item);
        adapterTest.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTest.setAdapter(adapterTest);

        ArrayAdapter<CharSequence> adapterLevel = ArrayAdapter.createFromResource(getContext(),
                R.array.level, android.R.layout.simple_spinner_item);
        adapterLevel.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLevel.setAdapter(adapterLevel);

        ArrayAdapter<CharSequence> adapterGender = ArrayAdapter.createFromResource(getContext(),
                R.array.genders, android.R.layout.simple_spinner_item);
        adapterGender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(adapterGender);

        // Initialize the Buttons
        buttonApply = view.findViewById(R.id.button_apply);
        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MatchpayFragment matchpayFragment = new MatchpayFragment();
                fragmentTransaction.replace(R.id.fragment_container, matchpayFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                // Handle the button click
                Toast.makeText(getContext(), "신청 완료!", Toast.LENGTH_SHORT).show();
            }
        });

        buttonApply2 = view.findViewById(R.id.button_apply2);
        buttonApply2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the button click
                Toast.makeText(getContext(), "신청 완료!", Toast.LENGTH_SHORT).show();
            }
        });

        buttonApply3 = view.findViewById(R.id.button_apply3);
        buttonApply3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the button click
                Toast.makeText(getContext(), "신청 완료!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}