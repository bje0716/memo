package com.kit.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.kit.myapplication.databinding.ActivityWriteBinding;

import java.text.SimpleDateFormat;
import java.util.Locale;

import io.realm.Realm;

public class WriteActivity extends AppCompatActivity {

    private ActivityWriteBinding binding;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_write);
        binding.setActivity(this);

        realm = Realm.getDefaultInstance();
    }

    public void send(View view) {
        if (binding.content.getText().length() == 0) {
            Toast.makeText(this, "메모를 작성해주세요", Toast.LENGTH_SHORT).show();
        } else {
            realm.beginTransaction();
            MainItem item = realm.createObject(MainItem.class);
            item.setContent(binding.content.getText().toString());
            item.setDate(getDate(System.currentTimeMillis()));
            realm.commitTransaction();
        }
    }

    private String getDate(Long time) {
        return new SimpleDateFormat("yyyy년 MM월 dd일 a hh:ss", Locale.getDefault()).format(time);
    }
}
