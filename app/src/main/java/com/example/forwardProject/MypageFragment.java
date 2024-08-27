package com.example.forwardProject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import java.io.IOException;

public class MypageFragment extends Fragment {

    private static final int PICK_IMAGE_REQUEST = 1;

    private ImageView imageViewProfile;
    private ImageView imageViewCamera;
    private ProfileViewModel profileViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mypage, container, false);

        // ViewModel 초기화
        profileViewModel = new ViewModelProvider(requireActivity()).get(ProfileViewModel.class);

        imageViewProfile = view.findViewById(R.id.imageViewProfile);
        imageViewCamera = view.findViewById(R.id.imageViewCamera);

        // ViewModel에서 프로필 이미지 관찰
        profileViewModel.getProfileImageBitmap().observe(getViewLifecycleOwner(), bitmap -> {
            if (bitmap != null) {
                imageViewProfile.setImageBitmap(bitmap);
            }
        });

        imageViewCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        // 결제내역 TextView를 초기화하고 클릭 리스너 설정
        TextView textViewPayment = view.findViewById(R.id.myPayment);
        textViewPayment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                PaymentFragment paymentFragment = new PaymentFragment();
                fragmentTransaction.replace(R.id.fragment_container, paymentFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        // My 포인트 TextView를 초기화하고 클릭 리스너 설정
        TextView textViewPoint = view.findViewById(R.id.myPoint);
        textViewPoint.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MypointFragment mypointFragment = new MypointFragment();
                fragmentTransaction.replace(R.id.fragment_container, mypointFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        // 나의 영상 TextView를 초기화하고 클릭 리스너 설정
        TextView textViewVideo = view.findViewById(R.id.myVideo);
        textViewVideo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MyvideoFragment myvideoFragment = new MyvideoFragment();
                fragmentTransaction.replace(R.id.fragment_container, myvideoFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        imageViewProfile = view.findViewById(R.id.imageViewProfile);
        imageViewCamera = view.findViewById(R.id.imageViewCamera);

        imageViewCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        return view;
    }
    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), imageUri);
                imageViewProfile.setImageBitmap(bitmap);
                profileViewModel.setProfileImageBitmap(bitmap); // ViewModel에 저장
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(getContext(), "이미지 로드 실패", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

