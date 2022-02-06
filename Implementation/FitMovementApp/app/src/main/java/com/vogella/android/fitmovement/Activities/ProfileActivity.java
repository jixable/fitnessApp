package com.vogella.android.fitmovement.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.vogella.android.fitmovement.R;

import java.io.FileDescriptor;
import java.io.IOException;

import MiddlewareLogic.ConverterB64;
import de.hdodenhof.circleimageview.CircleImageView;

import static MiddlewareLogic.MiddlewareConnection.getPic;
import static MiddlewareLogic.MiddlewareConnection.savePic;
import static com.vogella.android.fitmovement.Activities.LoginInActivity.USERNAME;

public class ProfileActivity extends AppCompatActivity {

    private static final int RESULT_LOAD_IMAGE = 123;
    private static final int IMAGE_CAPTURE_CODE = 654;
    private ConverterB64 dbPic = new ConverterB64();
    private  Button workoutSchedule;
    private Button gymMap;
    private Button camera;
    private CircleImageView profilepic;
    private Uri image_uri;

    @Override
    public void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.profilepage);
        profilepic = findViewById(R.id.profilepic);
        profilepic.setImageBitmap(dbPic.convertToBitM(getPic(USERNAME)));

        workoutSchedule = findViewById(R.id.buttonWorkSchedule);
        gymMap = findViewById(R.id.buttonGymMap);
        camera = findViewById(R.id.buttonCamera);

        workoutSchedule.setOnClickListener(v -> {
            Intent goWorkoutSchedule = new Intent(getApplicationContext(), WorkoutScheduleActivity.class);
            startActivity(goWorkoutSchedule);
        });

        gymMap.setOnClickListener(v -> {
            Intent goGymMap = new Intent(getApplicationContext(), MapsActivity.class);
            startActivity(goGymMap);
        });

        camera.setOnClickListener(v -> {
            Intent goCamera = new Intent(getApplicationContext(), CameraActivity.class);
            startActivity(goCamera);
        });

        //TODO chose image from gallery
        profilepic.setOnClickListener(view -> {
            Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == IMAGE_CAPTURE_CODE && resultCode == RESULT_OK) {
            //imageView.setImageURI(image_uri);
            Bitmap bitmap = uriToBitmap(image_uri);

            savePic(dbPic.convertToStr(bitmap), USERNAME);
            profilepic.setImageBitmap(bitmap);
        }


        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null) {
            image_uri = data.getData();
            //imageView.setImageURI(image_uri);
            Bitmap bitmap = uriToBitmap(image_uri);
            savePic(dbPic.convertToStr(bitmap),USERNAME);
            profilepic.setImageBitmap(bitmap);
        }
    }

    //TODO takes URI of the image and returns bitmap
    private Bitmap uriToBitmap(Uri selectedFileUri) {
        try {
            ParcelFileDescriptor parcelFileDescriptor =
                    getContentResolver().openFileDescriptor(selectedFileUri, "r");
            FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
            Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);

            parcelFileDescriptor.close();
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
