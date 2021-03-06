package cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import cuestionario.entidades.EncuestaSeguimiento;
import cuestionario.entidades.ImageStore;
import cuestionario.sedesol.com.democuestionario.CaptureSignature;
import cuestionario.sedesol.com.democuestionario.CaptureSignatureActivity;
import cuestionario.sedesol.com.democuestionario.GPSTracker;
import cuestionario.sedesol.com.democuestionario.MainActivity;
import cuestionario.sedesol.com.democuestionario.R;
import cuestionario.utils.Util;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentBeneficiariosGrid.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentBeneficiariosGrid#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentBeneficiariosGrid extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public final static String KEY_TEXT = "key_text";
    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_IMAGE_CAPTURE_INE = 1;
    static final int REQUEST_IMAGE_CAPTURE_INICIO = 1;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ImageButton fotoBeneficiarioButton;
    ImageButton scanIneBeneficiarioButton;
    ImageButton firmaBeneficiarioButton;
    ImageButton fotoInicioBeneficiarioButton;
    EditText nombreBeneficiarioText;
    EditText apellidoPBeneficiarioText;
    EditText apellidoMBeneficiarioText;
    EditText edadBeneficiarioText1;
    EditText sexoBeneficiarioText;
    EditText direccionBeneficiarioText;
    ImageView imageViewBeneficiario;
    ImageView imageViewIne;
    ImageView imageViewFirma;
    ImageView imageViewFotoInicio;
    ImageView imageViewFotoTest;
    Button botonObtenerUbicacion;
    Spinner spinnerSexo;

    Button botonGuardarInformacionBeneficiario;
    View inflatedView = null;
    Util util=new Util();
    String mCurrentPhotoPath;

    String direccionPhoto;

    MapView mMapView;
    private GoogleMap googleMap;

    private OnFragmentInteractionListener mListener;

    EncuestaSeguimiento beneficiario=null;
    static final int REQUEST_IMAGE_CAPTURE_D1 = 1;
    static final int REQUEST_TAKE_PHOTO=1;
    static final int REQUEST_TAKE_PHOTO2=2;
    static final int REQUEST_TAKE_PHOTO3=3;
    static final int REQUEST_TAKE_PHOTOFIRMA=4;
    static ImageStore imagenes=new ImageStore();
    public FragmentBeneficiariosGrid() {
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

        this.inflatedView = inflater.inflate(R.layout.fragment_fragment_beneficiarios_grid, container, false);
        fotoBeneficiarioButton = (ImageButton) inflatedView.findViewById(R.id.fotoBeneficiarioButton);
        scanIneBeneficiarioButton=(ImageButton) inflatedView.findViewById(R.id.scanIneBeneficiarioButton);
        firmaBeneficiarioButton=(ImageButton) inflatedView.findViewById(R.id.firmaBeneficiarioButton);
        fotoInicioBeneficiarioButton=(ImageButton) inflatedView.findViewById(R.id.fotoInicioBeneficiarioButton);
        botonGuardarInformacionBeneficiario=(Button)inflatedView.findViewById(R.id.botonActualizarDatosBeneficiario);
        nombreBeneficiarioText=(EditText) inflatedView.findViewById(R.id.nombreBeneficiarioText);
        apellidoPBeneficiarioText=(EditText) inflatedView.findViewById(R.id.apellidopBeneficiarioText);
        apellidoMBeneficiarioText=(EditText) inflatedView.findViewById(R.id.apellidomBeneficiarioText);
        edadBeneficiarioText1=(EditText) inflatedView.findViewById(R.id.edadBeneficiarioText);
        sexoBeneficiarioText=(EditText) inflatedView.findViewById(R.id.sexoBeneficiarioText);
        direccionBeneficiarioText=(EditText) inflatedView.findViewById(R.id.direccionBeneficiarioText);

        imageViewBeneficiario=(ImageView) inflatedView.findViewById(R.id.imageViewBeneficiario);
        imageViewIne=(ImageView) inflatedView.findViewById(R.id.imageViewIne);
        imageViewFirma=(ImageView) inflatedView.findViewById(R.id.imageViewFirma);
        imageViewFotoInicio=(ImageView) inflatedView.findViewById(R.id.imageViewFotoInicio);
        imageViewFotoTest=(ImageView) inflatedView.findViewById(R.id.imageViewFotoTest);
        spinnerSexo=(Spinner)inflatedView.findViewById(R.id.spinnerSexo);
        String [] arregloSexo={"Masculino","Femenino"};
        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,arregloSexo );
        spinnerSexo.setAdapter(adapter);

        nombreBeneficiarioText.setText(beneficiario.nombre);
        apellidoPBeneficiarioText.setText(beneficiario.apellidoPaterno);
        apellidoMBeneficiarioText.setText(beneficiario.apellidoMaterno);
        edadBeneficiarioText1.setText(""+beneficiario.edad);
        sexoBeneficiarioText.setText(beneficiario.sexo);
        direccionBeneficiarioText.setText(beneficiario.direccion);

        botonObtenerUbicacion=(Button)inflatedView.findViewById(R.id.botonFijarUbicacionActual);
        botonObtenerUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GPSTracker gps = new GPSTracker(getActivity());
                // check if GPS enabled
                if(gps.canGetLocation()){
                    beneficiario.latitud=""+gps.getLatitude();
                    beneficiario.longitud=""+gps.getLongitude();

                    LatLng sydney = new LatLng(gps.getLatitude(),gps.getLongitude());
                    //new LatLng(-34, 151);
                    googleMap.addMarker(new MarkerOptions().position(sydney).title("Ubicaciòn").snippet("Ubicacion actual"));

                    // For zooming automatically to the location of the marker
                    CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(17).build();
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                }else{
                    // can't get location
                    // GPS or Network is not enabled
                    // Ask user to enable GPS/network in settings
                    gps.showSettingsAlert();}
                }
        });
        botonGuardarInformacionBeneficiario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beneficiario.guardadoBdRemota=0;
                beneficiario.nombre=nombreBeneficiarioText.getText().toString();
                beneficiario.apellidoPaterno=apellidoPBeneficiarioText.getText().toString();
                beneficiario.apellidoMaterno=apellidoMBeneficiarioText.getText().toString();
                beneficiario.edad=Integer.parseInt(edadBeneficiarioText1.getText().toString());
                beneficiario.sexo=spinnerSexo.getSelectedItem().toString();
                beneficiario.direccion=direccionBeneficiarioText.getText().toString();
                EncuestaSeguimiento.save(beneficiario);

                Fragment fragment=new FragmentVisitaSeguimiento();
                Bundle args = new Bundle();
                args.putString(FragmentVisitaSeguimiento.KEY_TEXT, "Actualizacion Beneficiarios");
                args.putSerializable("beneficiario",beneficiario);
                //args.putSerializable("imagenes",imagenes);
                fragment.setArguments(args);

                // Insert the fragment by replacing any existing fragment
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.content_main_menu, fragment).commit();
            }
        });

        if(fotoBeneficiarioButton == null)
        {
            Log.d("debugCheck", "HeadFrag: sendButton is null");
            return inflatedView;
        }
        fotoBeneficiarioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    File photoFile = null;
                    try {
                        photoFile = createImageFile();
                    } catch (IOException ex) {
                        // Error occurred while creating the File
                        ex.printStackTrace();
                    }
                    // Continue only if the File was successfully created
                    if (photoFile != null) {
                        //  Uri photoURI = FileProvider.getUriForFile(getActivity(),
                        //           "cuestionario.sedesol.com.democuestionario",
                        //            photoFile);
                        Uri photoURI  = Uri.parse("file:///sdcard/photo1a.jpg");
                        //Uri photoURI  = Uri.fromFile(photoFile);

                        //takePictureIntent.setData(photoURI);
                        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                    }
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE_D1);
                }

            }
        });

        scanIneBeneficiarioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    File photoFile = null;
                    try {
                        photoFile = createImageFile();
                    } catch (IOException ex) {
                        // Error occurred while creating the File
                        ex.printStackTrace();
                    }
                    // Continue only if the File was successfully created
                    if (photoFile != null) {
                        //  Uri photoURI = FileProvider.getUriForFile(getActivity(),
                        //           "cuestionario.sedesol.com.democuestionario",
                        //            photoFile);
                        Uri photoURI  = Uri.parse("file:///sdcard/photo2a.jpg");
                        //takePictureIntent.setData(photoURI);
                        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                    }
                    startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO2);
                }
            }
        });

        firmaBeneficiarioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent capturarFirma = new Intent(getActivity(),CaptureSignature.class);
                startActivityForResult(capturarFirma,REQUEST_TAKE_PHOTOFIRMA);

            }
        });
        fotoInicioBeneficiarioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    File photoFile = null;
                    try {
                        photoFile = createImageFile();
                    } catch (IOException ex) {
                        // Error occurred while creating the File
                        ex.printStackTrace();
                    }
                    // Continue only if the File was successfully created
                    if (photoFile != null) {
                        //  Uri photoURI = FileProvider.getUriForFile(getActivity(),
                        //           "cuestionario.sedesol.com.democuestionario",
                        //            photoFile);
                        Uri photoURI  = Uri.parse("file:///sdcard/photo3a.jpg");
                        //takePictureIntent.setData(photoURI);
                        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                    }
                    startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO3);
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
                    googleMap.getUiSettings().setMyLocationButtonEnabled(true);
                    googleMap.getUiSettings().setZoomControlsEnabled(true);
                    googleMap.getUiSettings().setZoomGesturesEnabled(true);

                }catch(SecurityException e){
                    e.printStackTrace();
                }
                // For dropping a marker at a point on the Map
                LatLng sydney = new LatLng(util.stringADouble(beneficiario.latitud),util.stringADouble(beneficiario.longitud));
                        //new LatLng(-34, 151);
                googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker Title").snippet("Marker Description"));

                // For zooming automatically to the location of the marker
                CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(17).build();
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

///sobreescribimos el metodo para obtener la imagen de la camara
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
//            Bundle extras = data.getExtras();
//            Bitmap imageBitmap = (Bitmap) extras.get("data");
//            beneficiario.fotografiaBeneficiario=util.getImageBytes(imageBitmap);
//           try{
//                createImageFile();
//           }catch(Exception e){
//               e.printStackTrace();
//           }
//            //mImageView.setImageBitmap(imageBitmap);
//        }
//        if (requestCode == REQUEST_IMAGE_CAPTURE_INE && resultCode == RESULT_OK) {
//            Bundle extras = data.getExtras();
//            Bitmap imageBitmap = (Bitmap) extras.get("data");
//            beneficiario.fotografiaIne =util.getImageBytes(imageBitmap);
//            try{
//                createImageFile();
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//            //mImageView.setImageBitmap(imageBitmap);
//        }
//        if (requestCode == REQUEST_IMAGE_CAPTURE_INICIO && resultCode == RESULT_OK) {
//            Bundle extras = data.getExtras();
//            Bitmap imageBitmap = (Bitmap) extras.get("data");
//            beneficiario.fotografiaInicio =util.getImageBytes(imageBitmap);
//            try{
//                createImageFile();
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//            //mImageView.setImageBitmap(imageBitmap);
//        }
        if (requestCode == REQUEST_TAKE_PHOTOFIRMA) {
            Bundle extras = data.getExtras();
                if(extras!=null){
                    File imagenFirma=(File)extras.getSerializable("archivoFirma");
                    Bitmap bitmapFirma;
                    Uri uri = Uri.fromFile(imagenFirma);
                    try {
                        bitmapFirma = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
                        bitmapFirma = crupAndScale(bitmapFirma, 150); // if you mind scali;

                        //imageViewFirma.setImageBitmap(bitmapFirma);
                        //bitmapFirma=((BitmapDrawable)(imageViewFirma.getDrawable())).getBitmap();
                        beneficiario.imagenFirma=util.getImageBytes(bitmapFirma);
                        firmaBeneficiarioButton.setBackgroundColor(Color.BLUE);
                        //imagenes.setFirma(bitmapFirma);
                    } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
        }
        if (requestCode == REQUEST_TAKE_PHOTO) {
            if (resultCode == getActivity().RESULT_OK) {
                try {
                File file = new File(Environment.getExternalStorageDirectory().getPath(), "photo1a.jpg");
                Uri uri = Uri.fromFile(file);
                Bitmap bitmap;
                    bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
                    bitmap = crupAndScale(bitmap, 150); // if you mind scali;
                    //imageViewBeneficiario.setImageBitmap(bitmap);
                    //bitmap=((BitmapDrawable)(imageViewBeneficiario.getDrawable())).getBitmap();
                    beneficiario.fotografiaBeneficiario=util.getImageBytes(bitmap);
                    fotoBeneficiarioButton.setBackgroundColor(Color.BLUE);
                    //imageViewFotoTest.setImageBitmap(bitmap);
                    //imagenes.setBeneficiario(bitmap);
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }
        if (requestCode == REQUEST_TAKE_PHOTO2) {
            if (resultCode == getActivity().RESULT_OK) {
                File file = new File(Environment.getExternalStorageDirectory().getPath(), "photo2a.jpg");
                Uri uri = Uri.fromFile(file);
                Bitmap bitmap;
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
                    bitmap = crupAndScale(bitmap, 150); // if you mind scali;
                    //imageViewIne.setImageBitmap(bitmap);
                   // bitmap=((BitmapDrawable)(imageViewIne.getDrawable())).getBitmap();
                    beneficiario.fotografiaIne=util.getImageBytes(bitmap);
                    scanIneBeneficiarioButton.setBackgroundColor(Color.BLUE);
                    //imagenes.setIne(bitmap);
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }
        if (requestCode == REQUEST_TAKE_PHOTO3) {
            if (resultCode == getActivity().RESULT_OK) {
                File file = new File(Environment.getExternalStorageDirectory().getPath(), "photo3a.jpg");
                Uri uri = Uri.fromFile(file);
                Bitmap bitmap;
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
                    bitmap = crupAndScale(bitmap, 150); // if you mind scali;
                    //imageViewFotoInicio.setImageBitmap(bitmap);
                    //bitmap=((BitmapDrawable)(imageViewFotoInicio.getDrawable())).getBitmap();
                    beneficiario.fotografiaInicio=util.getImageBytes(bitmap);
                    fotoInicioBeneficiarioButton.setBackgroundColor(Color.BLUE);
                   // imagenes.setInicio(bitmap);
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }
    }
    public static  Bitmap crupAndScale (Bitmap source,int scale){
        int factor = source.getHeight() <= source.getWidth() ? source.getHeight(): source.getWidth();
        int longer = source.getHeight() >= source.getWidth() ? source.getHeight(): source.getWidth();
        int x = source.getHeight() >= source.getWidth() ?0:(longer-factor)/2;
        int y = source.getHeight() <= source.getWidth() ?0:(longer-factor)/2;
        source = Bitmap.createBitmap(source, x, y, factor, factor);
        source = Bitmap.createScaledBitmap(source, scale, scale, false);
        return source;
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


    @Override
    public void onStart() {
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


}
