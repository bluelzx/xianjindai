package com.brioal.bottomtablayout.fragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.brioal.bottomtablayout.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {

    private static final String TAG = AboutFragment.class.getSimpleName();
    @Bind(R.id.saveImage)
    ImageView saveImage;


    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        ButterKnife.bind(this, view);
        setListener();
        return view;
    }

    private void setListener() {

        saveImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = BitmapFactory.decodeResource(getActivity().getResources(), R.mipmap.erweima);
                saveImage(bitmap);
                bitmap.recycle();
            }
        });
    }

    private void saveImage(Bitmap bmp) {
        File appDir = new File(Environment.getExternalStorageDirectory(), "SchoolPicture");
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        Log.e(TAG, appDir.toString());

        String fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (fos != null) {
            Toast toast = Toast.makeText(getActivity(), "保存成功请到相册查看", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
        // 最后通知图库更新
        getActivity().sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(new File(file.getPath()))));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}