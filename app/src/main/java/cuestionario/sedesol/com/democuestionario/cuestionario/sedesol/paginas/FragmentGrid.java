package cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import cuestionario.entidades.EncuestaSeguimiento;
import cuestionario.sedesol.com.democuestionario.CaptureSignature;
import cuestionario.sedesol.com.democuestionario.CaptureSignatureActivity;
import cuestionario.sedesol.com.democuestionario.R;
import cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas.hogar.DatosIntegrantes;

/**
 * Created by asuarezr on 02/05/2017.
 */

public class FragmentGrid extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public final static String KEY_TEXT = "key_text";
    static final int REQUEST_IMAGE_CAPTURE = 1;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ImageButton fotoBeneficiarioButton;
    ImageButton scanIneBeneficiarioButton;
    ImageButton firmaBeneficiarioButton;
    ImageButton fotoInicioBeneficiarioButton;
    View inflatedView = null;
    TableLayout tabla;

    MapView mMapView;
    private GoogleMap googleMap;

    private FragmentBeneficiariosGrid.OnFragmentInteractionListener mListener;

    public FragmentGrid() {
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

        this.inflatedView = inflater.inflate(R.layout.fragment_grid, container, false);
        List<EncuestaSeguimiento> listadoBeneficiarios=EncuestaSeguimiento.listAll(EncuestaSeguimiento.class);
        tabla= (TableLayout) inflatedView.findViewById(R.id.tablaBeneficiarios);

        for(EncuestaSeguimiento en:listadoBeneficiarios) {
            TableRow tableRow = new TableRow(getActivity());
            TextView nombre = new TextView(getActivity());
            nombre.setText(en.apellidoPaterno + " " + en.apellidoMaterno + " " + en.nombre);
            final Button botonContestar = new Button(getActivity());
            // botonContestar.setId(renglon);
            botonContestar.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
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
                    //getActivity().getSupportActionBar().setTitle("Actualización Beneficiarios");

                }
            });
            botonContestar.setText("Detalle");
            tableRow.addView(nombre);
            //tableRow.addView(botonContestar);
            tabla.addView(tableRow);

        }


        return inflatedView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
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


    @Override
    public void onStart() {
        super.onStart();
        try {
            mListener = (FragmentBeneficiariosGrid.OnFragmentInteractionListener) getActivity();
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


}
