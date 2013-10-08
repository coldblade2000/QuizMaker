package com.twotowersstudios.quizmaker;

import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.widget.RadioButton;

public class MakeQuizActivity extends Activity {
	/**String filename = "Question1.xml";
	String string = "";
	FileOutputStream outputStream;
	 * @return */
	private RadioButton JRQ1A1;
	private RadioButton JRQ1A2;
	private RadioButton JRQ1A3;
	private RadioButton JRQ1A4;
	private String rightAnswerValue;
	
	
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
	EditText Q1 = (EditText)findViewById(R.id.Q1Actual);
	EditText Q1A1 = (EditText)findViewById(R.id.Q1A1);
	EditText Q1A2 = (EditText)findViewById(R.id.Q1A2);
	EditText Q1A3 = (EditText)findViewById(R.id.Q1A3);
	EditText Q1A4 = (EditText)findViewById(R.id.Q1A4);

	String Q1Str = Q1.getText().toString();
	String Q1A1Str = Q1A1.getText().toString();
	String Q1A2Str = Q1A2.getText().toString();
	String Q1A3Str = Q1A3.getText().toString();
	String Q1A4Str = Q1A4.getText().toString();

	
	/**public void rightAnswerSelection (View view){
		if (JRQ1A1.isChecked()){
			 rightAnswerValue = "@id/Q1A1";
		}else if (JRQ1A2.isChecked()){
			 rightAnswerValue = "@id/Q1A2";
		}else if (JRQ1A3.isChecked()){
			 rightAnswerValue = "@id/Q1A3";
		}else if (JRQ1A4.isChecked()){
			 rightAnswerValue = "@id/Q1A4";
		}
	}*/
	public void createXML() throws IOException {
		if (JRQ1A1.isChecked()){
			 rightAnswerValue = "@id/Q1A1";
		}else if (JRQ1A2.isChecked()){
			 rightAnswerValue = "@id/Q1A2";
		}else if (JRQ1A3.isChecked()){
			 rightAnswerValue = "@id/Q1A3";
		}else if (JRQ1A4.isChecked()){
			 rightAnswerValue = "@id/Q1A4";
		}
	    Document document = DocumentHelper.createDocument();
	    Element rootElement = document.addElement("Questions");
	    Element studentElement = rootElement.addElement("Question1").addAttribute("rightanswer", rightAnswerValue);
	    studentElement.addElement("Q1").addText(Q1Str);
	    studentElement.addElement("Q1A1").addText(Q1A1Str);
	    studentElement.addElement("Q1A2").addText(Q1A2Str);
	    studentElement.addElement("Q1A3").addText(Q1A3Str);
	    studentElement.addElement("Q1A4").addText(Q1A4Str);
	    studentElement.addElement("name").addText("Peter");
	    XMLWriter writer = new XMLWriter(new FileWriter("Students.xml"));
	    //Note that You can format this XML document
	    /*
	     * FileWriter output = new FileWriter(new File("Students.xml"));
	    OutputFormat format = OutputFormat.createPrettyPrint();
	    XMLWriter writer = new XMLWriter(output,format);<- will fomat the output
	     */

	    //You can print this to the console and see what it looks like
	    String xmlElement = document.asXML();
	    System.out.println(xmlElement);
	    writer.write(document);
	    writer.close();

	}
	
	

}
