package com.twotowersstudios.quizmaker;
 
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xmlpull.v1.XmlSerializer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Xml;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
 
public class MakeQuizActivity extends Activity {
        /**String filename = "Question1.xml";
        String string = "";
        FileOutputStream outputStream;
         * @return */
	public static final String xmlFilePath = "/storage/sdcard0/Quizmakerassets";

    private RadioButton JRQ1A1;
    private RadioButton JRQ1A2;
    private RadioButton JRQ1A3;
    private RadioButton JRQ1A4;
    public String rightAnswerValue;
       
       
       
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
       
        public void rightAnswerSelection (View view){
                if (JRQ1A1.isChecked()){
                         rightAnswerValue = "@id/Q1A1";
                }else if (JRQ1A2.isChecked()){
                         rightAnswerValue = "@id/Q1A2";
                }else if (JRQ1A3.isChecked()){
                         rightAnswerValue = "@id/Q1A3";
                }else if (JRQ1A4.isChecked()){
                         rightAnswerValue = "@id/Q1A4";
                }
        }
        public void createXML(View view) throws IOException, ParserConfigurationException, TransformerException {
                EditText Q1 = (EditText)findViewById(R.id.Q1Actual);
                EditText Q1RA = (EditText)findViewById(R.id.Q1RA);
                EditText Q1WA1 = (EditText)findViewById(R.id.Q1WA1);
                EditText Q1WA2 = (EditText)findViewById(R.id.Q1WA2);
                EditText Q1WA3 = (EditText)findViewById(R.id.Q1WA3);
                EditText FileNameRaw = (EditText)findViewById(R.id.TQ1);
                String Q1Str = Q1.getText().toString();
                String Q1RAStr = Q1RA.getText().toString();
                String Q1WA1Str = Q1WA1.getText().toString();
                String Q1WA2Str = Q1WA2.getText().toString();
                String Q1WA3Str = Q1WA3.getText().toString();
                String FileNameStr = FileNameRaw.getText().toString();
       
                
                String filename = FileNameStr + ".xml";

                FileOutputStream fos;       

                fos = openFileOutput(filename,Context.MODE_APPEND);


                XmlSerializer serializer = Xml.newSerializer();
                serializer.setOutput(fos, "UTF-8");
                serializer.startDocument(null, Boolean.valueOf(true));
                serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);

                serializer.startTag(null, "Questions");
                	serializer.startTag(null, "Question1"); 
                	serializer.attribute(null, "rightAnswer", "A2");
                		serializer.startTag(null, "Q1Text");
                		serializer.text(Q1Str);
                		serializer.endTag(null,  "Q1Text");
                		
                		serializer.startTag(null, "Q1RA");
                		serializer.text(Q1RAStr);
                		serializer.endTag(null, "Q1RA");
                		
                		serializer.startTag(null, "Q1A2");
            			serializer.text(Q1WA1Str);
            			serializer.endTag(null, "Q1A2");
            		
            			serializer.startTag(null, "Q1A3");
            			serializer.text(Q1WA2Str);
        				serializer.endTag(null, "Q1A3");
        		
        				serializer.startTag(null, "Q1A4");
        				serializer.text(Q1WA3Str);
        				serializer.endTag(null, "Q1A4");
                		
                serializer.endTag(null, "Question1");

                
                 serializer.endDocument();

                 serializer.flush();

                 fos.close();
                
        }
        

}