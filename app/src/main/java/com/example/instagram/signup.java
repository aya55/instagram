package com.example.instagram;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.IOException;
import java.util.Calendar;

public class signup extends AppCompatActivity {
    private ImageView profilImage;
    private static final int PICK_IMAGE =1;
    Uri imageUri;
    private static final String TAG = "MainActivity";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TextInputLayout  email1;
    private TextInputLayout phonenum;
   Bitmap bitmap;
    EditText pass;
    EditText frist;
    EditText last;
    Button sign;
    EditText birth;
   Button button;
    CircleImageView imageView;
    ImageView cam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        pass=findViewById(R.id.pass);
        frist=findViewById(R.id.frist);
        last=findViewById(R.id.last);
        email1=findViewById(R.id.email1);
        phonenum=findViewById(R.id.phone);
        sign=findViewById(R.id.signn);
        imageView=findViewById(R.id.profile_image);
        cam=findViewById(R.id.cam);
        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent();
                gallery.setType("image/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(gallery, "Select a picture"), PICK_IMAGE);

            }
        });

sign.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if( (frist.getText().toString().isEmpty())|(last.getText().toString().isEmpty())
               |(pass.getText().toString().isEmpty())
                ){

            if(pass.getText().toString().isEmpty())
            {
                pass.setError("Password is empty");
                pass.requestFocus();
            }
            if((last.getText().toString().isEmpty()))
            {
                last.setError("Last Name is empty");
                last.requestFocus();
            }
            if((frist.getText().toString().isEmpty()))
            {
                frist.setError("First Name is empty");
                frist.requestFocus();
            }
        }
        else {
            Intent homeintent=new Intent(signup.this,home.class);
            startActivity(homeintent);
        }

    }
});

        mDisplayDate = (TextView) findViewById(R.id.birth);
        profilImage = findViewById(R.id.profile_image);
        profilImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gall = new Intent();
                gall.setType("image/*");
                gall.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(gall, "Select Picture"), PICK_IMAGE);
            }
        });
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(signup.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener,
                        year, month, day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet:  mm/dd/yyy:  " + month + "/" + day + "/" + year);
                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        profilImage.setImageBitmap(bitmap);


        if (requestCode == PICK_IMAGE  && resultCode == RESULT_OK){
            imageUri = data.getData();
            try {
                Bitmap bitmap1 = MediaStore.Images.Media.getBitmap(getContentResolver(),imageUri);
                profilImage.setImageBitmap(bitmap);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    private boolean vEmail() {
        String Email = email1.getEditText().getText().toString().trim();
        if (Email.isEmpty()) {
            email1.setError("Field can't be empty");
            return false;

        } else if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            email1.setError("Please enter a valid email adress ");
            return false;

        }
        else {
            email1.setError(null);
            return true;

        }


    }

    private boolean phonenumber() {
        String Phone = phonenum.getEditText().getText().toString().trim();

        if (Phone.isEmpty()) {
            phonenum.setError("Field can't be empty");
            return false;

        } else if (Phone.length() > 11) {
            phonenum.setError("Phone number too long");
            return false;

        } else {
            phonenum.setError(null);
            return true;
        }




    }

}
