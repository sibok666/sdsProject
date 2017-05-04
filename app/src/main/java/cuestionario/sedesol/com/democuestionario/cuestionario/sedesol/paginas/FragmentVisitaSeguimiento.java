package cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cuestionario.entidades.EncuestaSeguimiento;
import cuestionario.sedesol.com.democuestionario.AddNewAnswer;
import cuestionario.sedesol.com.democuestionario.CaptureSignature;
import cuestionario.sedesol.com.democuestionario.CaptureSignatureActivity;
import cuestionario.sedesol.com.democuestionario.JSONParser;
import cuestionario.sedesol.com.democuestionario.R;
import cuestionario.utils.Util;

import static android.app.Activity.RESULT_OK;

/**
 * Created by asuarezr on 28/04/2017.
 */

public class FragmentVisitaSeguimiento extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public final static String KEY_TEXT = "key_text";
    static final int REQUEST_IMAGE_CAPTURE_D1 = 1;
    static final int REQUEST_IMAGE_CAPTURE_D2 = 1;
    static final int REQUEST_IMAGE_CAPTURE_D3 = 1;
    static final int REQUEST_IMAGE_CAPTURE_D4 = 1;
    static final int REQUEST_IMAGE_CAPTURE_D5 = 1;
    static final int REQUEST_IMAGE_CAPTURE_FIN = 1;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ImageButton botonDurante1;
    ImageButton botonDurante2;
    ImageButton botonDurante3;
    ImageButton botonDurante4;
    ImageButton botonDurante5;
    ImageButton botonFin;
    View inflatedView = null;
    EditText nombreBeneficiarioText;
    EditText apellidoPBeneficiarioText;
    EditText apellidoMBeneficiarioText;
    EditText edadBeneficiarioText;
    EditText sexoBeneficiarioText;
    EditText direccionBeneficiarioText;
    String mCurrentPhotoPath;
    Button guardarInformacion;

    EncuestaSeguimiento beneficiario=null;
    MapView mMapView;
    private GoogleMap googleMap;
    Util util=new Util();

    private FragmentVisitaSeguimiento.OnFragmentInteractionListener mListener;

    //campos para guardar informacion en el servidor
    private ProgressDialog pDialog;

    JSONParser jsonParser = new JSONParser();
    private int success;//to determine JSON signal insert success/fail
    // url to insert new idiom (change accordingly)
    private static String url_insert_new = "http://www.dox.com.mx/sdsProject/insertnewfollow.php";
    // JSON Node names
    private static final String TAG_SUCCESS = "success";


    public FragmentVisitaSeguimiento() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentBeneficiariosGrid.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentBeneficiariosGrid newInstance(String param1, String param2) {
        FragmentBeneficiariosGrid fragment = new FragmentBeneficiariosGrid();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        this.inflatedView = inflater.inflate(R.layout.visita_seguimiento_fragment, container, false);

        botonDurante1 = (ImageButton) inflatedView.findViewById(R.id.botonDurante1);
        botonDurante2=(ImageButton) inflatedView.findViewById(R.id.botonDurante2);
        botonDurante3=(ImageButton) inflatedView.findViewById(R.id.botonDurante3);
        botonDurante4=(ImageButton) inflatedView.findViewById(R.id.botonDurante4);
        botonDurante5 = (ImageButton) inflatedView.findViewById(R.id.botonDurante5);
        botonFin = (ImageButton) inflatedView.findViewById(R.id.botonFin);
        nombreBeneficiarioText=(EditText) inflatedView.findViewById(R.id.nombreBeneficiarioText);
        apellidoPBeneficiarioText=(EditText) inflatedView.findViewById(R.id.apellidopBeneficiarioText);
        apellidoMBeneficiarioText=(EditText) inflatedView.findViewById(R.id.apellidomBeneficiarioText);
        edadBeneficiarioText=(EditText) inflatedView.findViewById(R.id.edadBeneficiarioText);
        sexoBeneficiarioText=(EditText) inflatedView.findViewById(R.id.sexoBeneficiarioText);
        direccionBeneficiarioText=(EditText) inflatedView.findViewById(R.id.direccionBeneficiarioText);

        nombreBeneficiarioText.setText(beneficiario.nombre);
        apellidoPBeneficiarioText.setText(beneficiario.apellidoPaterno);
        apellidoMBeneficiarioText.setText(beneficiario.apellidoMaterno);
        edadBeneficiarioText.setText(""+beneficiario.edad);
        sexoBeneficiarioText.setText(beneficiario.sexo);
        direccionBeneficiarioText.setText(beneficiario.direccion);

        guardarInformacion=(Button) inflatedView.findViewById(R.id.botonActualizarDatosBeneficiario);
        guardarInformacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EncuestaSeguimiento.save(beneficiario);

                if (true/*v.getId()==R.id.btnsavenew*/){
                    //call the InsertNewIdiom thread
                    new FragmentVisitaSeguimiento.InsertNewRecord().execute();
                    if (success==1){
                        Toast.makeText(getActivity().getApplicationContext(), "New idiom saved...", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getActivity().getApplicationContext(), "New idiom FAILED to saved...", Toast.LENGTH_LONG).show();
                    }
                }

                // Create a new fragment and specify the option to show based on
                // position
                Fragment fragment=new FragmentGrid();
                Bundle args = new Bundle();
                args.putString(FragmentGrid.KEY_TEXT, "Actualizacion Beneficiarios");
                fragment.setArguments(args);

                // Insert the fragment by replacing any existing fragment
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.content_main_menu, fragment).commit();
                // Highlight the selected item, update the title, and close the drawer
                //navList.setItemChecked(position, true);
                //getActivity().getSupportFragmentManager().getSupportActionBar().setTitle("Actualización Beneficiarios");
            }
        });



        botonDurante1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE_D1);
                }
            }
        });

        botonDurante2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE_D2);
                }
            }
        });

        botonDurante3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE_D2);
                }
            }
        });
        botonDurante4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE_D3);
                }
            }
        });
        botonDurante5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE_D4);
                }
            }
        });
        botonFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE_FIN);
                }
            }
        });

        mMapView = (MapView) inflatedView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                // For showing a move to my location button
                try {
                    googleMap.setMyLocationEnabled(true);
                }catch(SecurityException e){
                    e.printStackTrace();
                }
                // For dropping a marker at a point on the Map
                LatLng sydney = new LatLng(-34, 151);
                googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker Title").snippet("Marker Description"));

                // For zooming automatically to the location of the marker
                CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });

        return inflatedView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            beneficiario=(EncuestaSeguimiento) getArguments().getSerializable("beneficiario");

        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
    ///sobreescribimos el metodo para obtener la imagen de la camara
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE_D1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            beneficiario.fotografiaDurante1=util.getImageBytes(imageBitmap);
            try{
                createImageFile();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        if (requestCode == REQUEST_IMAGE_CAPTURE_D2 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            beneficiario.fotografiaDurante2 =util.getImageBytes(imageBitmap);
            try{
                createImageFile();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        if (requestCode == REQUEST_IMAGE_CAPTURE_D3 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            beneficiario.fotografiaDurante3 =util.getImageBytes(imageBitmap);
            try{
                createImageFile();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        if (requestCode == REQUEST_IMAGE_CAPTURE_D4 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            beneficiario.fotografiaDurante4 =util.getImageBytes(imageBitmap);
            try{
                createImageFile();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        if (requestCode == REQUEST_IMAGE_CAPTURE_D5 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            beneficiario.fotografiaDurante5 =util.getImageBytes(imageBitmap);
            try{
                createImageFile();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        if (requestCode == REQUEST_IMAGE_CAPTURE_FIN && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            beneficiario.fotografiaFinal =util.getImageBytes(imageBitmap);
            try{
                createImageFile();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    @Override
    public void onStart() {
//        super.onStart();
//        try {
//            mListener = (FragmentVisitaSeguimiento.OnFragmentInteractionListener) getActivity();
//        } catch (ClassCastException e) {
//            throw new ClassCastException(getActivity().toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
        super.onStart();
        try {
            mListener = (OnFragmentInteractionListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    /**
     * Background Async Task to Create new Idioms
     * */
    class InsertNewRecord extends AsyncTask<String, String, String> {
        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(getActivity());
            pDialog.setMessage("Saving the new IDIOM ()...");
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
            params.add(new BasicNameValuePair("ageb", beneficiario.ageb));
            params.add(new BasicNameValuePair("apellidoMaterno", beneficiario.apellidoMaterno));
            params.add(new BasicNameValuePair("apellidoPaterno", beneficiario.apellidoPaterno));
            params.add(new BasicNameValuePair("curp", beneficiario.curp));
            params.add(new BasicNameValuePair("direccion", beneficiario.direccion));
            params.add(new BasicNameValuePair("folioUnico", beneficiario.folioUnico));
            params.add(new BasicNameValuePair("latitud", beneficiario.latitud));
            params.add(new BasicNameValuePair("localidad", beneficiario.localidad));
            params.add(new BasicNameValuePair("longitud", beneficiario.longitud));
            params.add(new BasicNameValuePair("noExterior", beneficiario.noExterior));
            params.add(new BasicNameValuePair("nombre", beneficiario.nombre));
            params.add(new BasicNameValuePair("sexo", beneficiario.sexo));
            params.add(new BasicNameValuePair("terminado", beneficiario.terminado));
            params.add(new BasicNameValuePair("vialidad", beneficiario.vialidad));
            params.add(new BasicNameValuePair("edad", ""+beneficiario.edad));
            params.add(new BasicNameValuePair("fechaRecepcion", util.dateAString(beneficiario.fecharecepcion)));
            params.add(new BasicNameValuePair("fotografiaBeneficiario", util.imagenBinariaAJson(beneficiario.fotografiaBeneficiario)));
            params.add(new BasicNameValuePair("imagenFirma", util.imagenBinariaAJson(beneficiario.imagenFirma)));
            params.add(new BasicNameValuePair("fotografiaIne", util.imagenBinariaAJson(beneficiario.fotografiaIne)));
            params.add(new BasicNameValuePair("fotografiaDurante1", util.imagenBinariaAJson(beneficiario.fotografiaDurante1)));
            params.add(new BasicNameValuePair("fotografiaDurante2", util.imagenBinariaAJson(beneficiario.fotografiaDurante2)));
            params.add(new BasicNameValuePair("fotografiaDurante3", util.imagenBinariaAJson(beneficiario.fotografiaDurante3)));
            params.add(new BasicNameValuePair("fotografiaDurante4", util.imagenBinariaAJson(beneficiario.fotografiaDurante4)));
            params.add(new BasicNameValuePair("fotografiaDurante5", util.imagenBinariaAJson(beneficiario.fotografiaDurante5)));
            params.add(new BasicNameValuePair("fotografiaFinal", util.imagenBinariaAJson(beneficiario.fotografiaFinal)));




            // getting JSON Object
            // Note that create product url accepts GET method
            JSONObject json = jsonParser.makeHttpRequest(url_insert_new,
                    "POST", params);

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
