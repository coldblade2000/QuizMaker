package com.twotowersstudios.quizmaker;

import ua.com.vassiliev.androidfilebrowser.FileBrowserActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainTitleScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_title_screen);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_title_screen, menu);
        return true;
    }
    public void OpenReportBug(View view) {
    	Intent OpenReportBug = new Intent(this, ReportABugActivity.class);
    	startActivity(OpenReportBug);
    }
    public void OpenMakeQuiz(View view) {
    	Intent OpenMakeQuizIntent = new Intent(this, MakeQuizActivity.class);
    	startActivity(OpenMakeQuizIntent);
    }
    public void OpenFileBrowser(View view) {
    	Intent OpenFileBrowserIntent = new Intent(this, FileBrowserActivity.class);
    	startActivity(OpenFileBrowserIntent);
    }
    
    
}
