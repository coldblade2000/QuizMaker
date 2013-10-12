package com.twotowersstudios.quizmaker;
 
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xmlpull.v1.XmlSerializer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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
                EditText Q1A1 = (EditText)findViewById(R.id.Q1A1);
                EditText Q1A2 = (EditText)findViewById(R.id.Q1A2);
                EditText Q1A3 = (EditText)findViewById(R.id.Q1A3);
                EditText Q1A4 = (EditText)findViewById(R.id.Q1A4);
                String Q1Str = Q1.getText().toString();
                String Q1A1Str = Q1A1.getText().toString();
                String Q1A2Str = Q1A2.getText().toString();
                String Q1A3Str = Q1A3.getText().toString();
                String Q1A4Str = Q1A4.getText().toString();
               
                JRQ1A1 = (RadioButton) findViewById(R.id.RQ1A1);
                JRQ1A2 = (RadioButton) findViewById(R.id.RQ1A2);
                JRQ1A3 = (RadioButton) findViewById(R.id.RQ1A3);
                JRQ1A4 = (RadioButton) findViewById(R.id.RQ1A4);
                if (JRQ1A1.isSelected()){
                         rightAnswerValue = "A1";
                }else if (JRQ1A2.isSelected()){
                         rightAnswerValue = "A2";
                }else if (JRQ1A3.isSelected()){
                         rightAnswerValue = "A3";
                }else if (JRQ1A4.isSelected()){
                         rightAnswerValue = "A4";
                }
                
                String filename = "Questions.xml";

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
                		
                		serializer.startTag(null, "Q1A1");
                		serializer.text(Q1A1Str);
                		serializer.endTag(null, "Q1A1");
                		
                		serializer.startTag(null, "Q1A2");
            			serializer.text(Q1A2Str);
            			serializer.endTag(null, "Q1A2");
            		
            			serializer.startTag(null, "Q1A3");
            			serializer.text(Q1A3Str);
        				serializer.endTag(null, "Q1A3");
        		
        				serializer.startTag(null, "Q1A4");
        				serializer.text(Q1A4Str);
        				serializer.endTag(null, "Q1A4");
                		
                serializer.endTag(null, "Question1");

                /*for(int j = 0 ; j < 3 ; j++)
                {

                    serializer.startTag(null, "record");

                    serializer.text(data);

                    serializer.endTag(null, "record");
                }*/
                 serializer.endDocument();

                 serializer.flush();

                 fos.close();
                 Log.e("QuizMaker", "Location of file is in: " + fos.toString());
                /**DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

    			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

    			Document document = documentBuilder.newDocument();

    			// root element
    			Element root = document.createElement("Questions");
    			document.appendChild(root);

    			// employee element
    			Element Question1 = document.createElement("Question1");

    			root.appendChild(Question1);

    			// set an attribute to staff element
    			Attr attr = document.createAttribute("rightQuestion");
    			attr.setValue("10");
    			Question1.setAttributeNode(attr);

    			//you can also use staff.setAttribute("id", "1") for this

    			// firstname element
    			Element Question1Text = document.createElement("QuestionText");
    			Question1Text.appendChild(document.createTextNode(Q1Str));
    			Question1.appendChild(Question1Text);

    			// lastname element
    			Element Question1A1 = document.createElement("Q1A1");
    			Question1A1.appendChild(document.createTextNode(Q1A1Str));
    			Question1.appendChild(Question1A1);

    			Element Question1A2 = document.createElement("Q1A2");
    			Question1A2.appendChild(document.createTextNode(Q1A1Str));
    			Question1.appendChild(Question1A2);
    			
    			Element Question1A3 = document.createElement("Q1A3");
    			Question1A3.appendChild(document.createTextNode(Q1A1Str));
    			Question1.appendChild(Question1A3);
    			
    			Element Question1A4 = document.createElement("Q1A4");
    			Question1A4.appendChild(document.createTextNode(Q1A1Str));
    			Question1.appendChild(Question1A4);

    			// create the xml file
    			//transform the DOM Object to an XML File
    			TransformerFactory transformerFactory = TransformerFactory.newInstance();
    			Transformer transformer = transformerFactory.newTransformer();
    			DOMSource domSource = new DOMSource(document);
    			StreamResult streamResult = new StreamResult(new File(xmlFilePath));

    			// If you use
    			// StreamResult result = new StreamResult(System.out);
    			// the output will be pushed to the standard output ...
    			// You can use that for debugging 

    			transformer.transform(domSource, streamResult);*/
        	
        }
        

}