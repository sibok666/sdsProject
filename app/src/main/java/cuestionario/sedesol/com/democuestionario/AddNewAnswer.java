package cuestionario.sedesol.com.democuestionario;

/**
 * Created by asuarezr on 04/04/2017.
 */

        import android.os.Bundle;
        import android.app.Activity;
        import android.view.Menu;
        import android.view.View.OnClickListener;

        import java.util.ArrayList;
        import java.util.List;

        import org.apache.http.NameValuePair;
        import org.apache.http.message.BasicNameValuePair;
        import org.json.JSONException;
        import org.json.JSONObject;

        import android.app.Activity;
        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class AddNewAnswer extends Activity implements OnClickListener {

    // Progress Dialog
    private ProgressDialog pDialog;

    JSONParser jsonParser = new JSONParser();
    private EditText txtnewidiom;
    private EditText txtmeaning;
    private Button btnsavenew;
    private int success;//to determine JSON signal insert success/fail

    // url to insert new idiom (change accordingly)
    private static String url_insert_new = "http://www.dox.com.mx/sdsProject/insertnew.php";

    // JSON Node names
    private static final String TAG_SUCCESS = "success";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_add_new_idiom);

        // Edit Text
        //txtnewidiom = (EditText) findViewById(R.id.txtnewidiom);
        //txtmeaning = (EditText) findViewById(R.id.txtmeaning);

        // Save button
        //btnsavenew = (Button) findViewById(R.id.btnsavenew);
        // button click event
        btnsavenew.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if (true/*v.getId()==R.id.btnsavenew*/){
            //call the InsertNewIdiom thread
            new InsertNewIdiom().execute();
            if (success==1){
                Toast.makeText(getApplicationContext(), "New idiom saved...", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(), "New idiom FAILED to saved...", Toast.LENGTH_LONG).show();
            }
        }

    }

    /**
     * Background Async Task to Create new Idioms
     * */
    class InsertNewIdiom extends AsyncTask<String, String, String> {
        //capture values from EditText
        String entry = txtnewidiom.getText().toString();
        String meaning = txtmeaning.getText().toString();

        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(AddNewAnswer.this);
            pDialog.setMessage("Saving the new IDIOM ("+entry+")...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        /**
         * Inserting the new idiom
         * */
        protected String doInBackground(String... args) {


            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("entry", entry));
            params.add(new BasicNameValuePair("meaning", meaning));

            // getting JSON Object
            // Note that create product url accepts GET method
            JSONObject json = jsonParser.makeHttpRequest(url_insert_new,
                    "GET", params);

            // check log cat from response
            Log.d("Inserting", json.toString());

            // check for success tag
            try {
                success = json.getInt(TAG_SUCCESS);

                if (success == 1) {
                    // successfully save new idiom
                } else {
                    // failed to add new idiom
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            //return null;
            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog once done
            pDialog.dismiss();
        }

    }
}