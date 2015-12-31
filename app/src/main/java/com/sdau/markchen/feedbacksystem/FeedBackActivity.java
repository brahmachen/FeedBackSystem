package com.sdau.markchen.feedbacksystem;

import android.content.Intent;
import android.database.Cursor;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.sdau.markchen.feedbacksystem.entity.Problem;

import java.util.Date;

/**
 * Created by mark chen on 2015/12/30.
 */
public class FeedBackActivity extends AppCompatActivity {
    private static int RESULT_LOAD_IMAGE = 1;
    private static String LOCATION_TAG = "location";
    private Problem problem = new Problem();
    private EditText editTextTitle;
    private EditText editTextTContent;
    private int type;
    private boolean isHaveGPSInfo = false;


    public LocationManager lm;
    private static final String TAG = "GPS Services";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);


        initView();
    }

    private void initView() {
        editTextTitle = (EditText) findViewById(R.id.id_edittext_title);
        editTextTContent = (EditText) findViewById(R.id.id_edittext_content);
        type = getIntent().getIntExtra("Type", 0);
        problem.setLx(type);
        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar_fb);

        switch (type) {
            case 1:
                toolbar.setTitle(R.string.type1);
                break;
            case 2:
                toolbar.setTitle(R.string.type2);
                break;
            case 3:
                toolbar.setTitle(R.string.type3);
                break;
            case 4:
                toolbar.setTitle(R.string.type4);
                break;
            case 5:
                toolbar.setTitle(R.string.type5);
                break;
        }
        setSupportActionBar(toolbar);
    }

    public void choosePic(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, RESULT_LOAD_IMAGE);
    }

    public void submit(View view) {
        if (editTextTitle.getText().length() == 0) {
            Toast.makeText(this, "标题不能为空！", Toast.LENGTH_SHORT).show();
            return;
        }
        if (editTextTContent.getText().length() == 0) {
            Toast.makeText(this, "内容不能为空！", Toast.LENGTH_SHORT).show();
            return;
        }
        problem.setBt(editTextTitle.getText().toString());
        problem.setNr(editTextTContent.getText().toString());
        problem.setSbsj(new Date());
        Log.i("data", problem.toString());

        Toast.makeText(this,"提交成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            problem.setTp(picturePath);
            Log.i("path",picturePath);
        }
    }
}
