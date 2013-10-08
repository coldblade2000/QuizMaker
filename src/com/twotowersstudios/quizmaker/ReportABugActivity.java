package com.twotowersstudios.quizmaker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class ReportABugActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_report_abug);
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.report_abug, menu);
		return true;
	}
	public void SendBugReport(View view){
		Intent i = new Intent(Intent.ACTION_SEND);
		i.setType("message/rfc822");
		i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"diegogranada7@gmail.com"});
		i.putExtra(Intent.EXTRA_SUBJECT, "Bug Report(Add your name here if possible)");
		i.putExtra(Intent.EXTRA_TEXT   , "Please describe your issue here: \n Date and time: \n Android Version: \n Device Model: \n What Happened?: ");
		try {
		    startActivity(Intent.createChooser(i, "Send mail..."));
		} catch (android.content.ActivityNotFoundException ex) {
		    Toast.makeText(ReportABugActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
		}
	}

}