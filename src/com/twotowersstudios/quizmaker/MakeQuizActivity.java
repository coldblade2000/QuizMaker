package com.twotowersstudios.quizmaker;

import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MakeQuizActivity extends Activity {
	/**String filename = "Question1.xml";
	String string = "";
	FileOutputStream outputStream;*/
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_make_quiz);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.make_quiz, menu);
		return true;
	}
	/**public void createXMLFile(View view){
		try {
			  outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
			  outputStream.write(string.getBytes());
			  outputStream.close();
			} catch (Exception e) {
			  e.printStackTrace();
			}
	}*/
	
	

}
