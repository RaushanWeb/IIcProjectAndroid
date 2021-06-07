package com.example.mlkit;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class MainActivity extends AppCompatActivity
{
	private String[] classNames;
	private Integer[] image;
	private static final Class<?>[] CLASSES = new Class<?>[]
			{
			TextActivity.class,
			BarcodeActivity.class,
			FaceActivity.class,
			ImageActivity.class,
			CustomActivity.class,
			LanguageActivity.class,
			SmartReplyActivity.class,
			TranslateActivity.class,
		};
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		classNames = getResources().getStringArray(R.array.class_name);

		image = new Integer[]{R.drawable.text_recognition, R.drawable.barcode_scanning, R.drawable.face_detection_with_contour,
				R.drawable.image_classification, R.drawable.object_detection, R.drawable
				.language_detection, R.drawable.smart_reply, R.drawable.on_device_translate};

		ArrayList<String> l = new ArrayList<String>(Arrays.asList(classNames));
		ArrayList<Integer> l2 = new ArrayList<>(Arrays.asList(image));

		RecyclerView recyclerView = (RecyclerView)findViewById(R.id.list_view);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		recyclerView.setAdapter(new ProgrammingAdapter(this,l,l2,CLASSES));
	}
}
