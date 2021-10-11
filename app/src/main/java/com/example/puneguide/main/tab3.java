package com.example.puneguide.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.puneguide.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link tab3.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link tab3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class tab3 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public tab3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment tab3.
     */
    // TODO: Rename and change types and number of parameters
    public static tab3 newInstance(String param1, String param2) {
        tab3 fragment = new tab3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab3,
                container, false);
        final TextView c1091 = (TextView)view.findViewById(R.id.c1091);

        c1091.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c1091.getText().toString().trim()));
                startActivity(callIntent);

            }
        });
        final TextView c181 = (TextView)view.findViewById(R.id.c181);

        c181.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c181.getText().toString().trim()));
                startActivity(callIntent);

            }
        });
        final TextView c108 = (TextView)view.findViewById(R.id.c108);

        c108.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c108.getText().toString().trim()));
                startActivity(callIntent);

            }
        });
        final TextView c102 = (TextView)view.findViewById(R.id.c102);

        c102.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c102.getText().toString().trim()));
                startActivity(callIntent);

            }
        });
        final TextView c101 = (TextView)view.findViewById(R.id.c101);

        c101.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c101.getText().toString().trim()));
                startActivity(callIntent);

            }
        });

        final TextView c100 = (TextView)view.findViewById(R.id.c100);

        c100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c100.getText().toString().trim()));
                startActivity(callIntent);

            }
        });

        final TextView c02026126296 = (TextView)view.findViewById(R.id.c02026126296);

        c02026126296.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c02026126296.getText().toString().trim()));
                startActivity(callIntent);

            }
        });

        final TextView c02026122880 = (TextView)view.findViewById(R.id.c02026122880);

        c02026122880.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c02026122880.getText().toString().trim()));
                startActivity(callIntent);

            }
        });

        final TextView c1910 = (TextView)view.findViewById(R.id.c1910);
        c1910.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c1910.getText().toString().trim()));
                startActivity(callIntent);

            }
        });
        final TextView c1077 = (TextView)view.findViewById(R.id.c1077);
        c1077.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c1077.getText().toString().trim()));
                startActivity(callIntent);

            }
        });
        final TextView c1512 = (TextView)view.findViewById(R.id.c1512);
        c1512.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c1512.getText().toString().trim()));
                startActivity(callIntent);

            }
        });
        final TextView c139 = (TextView)view.findViewById(R.id.c139);
        c139.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c139.getText().toString().trim()));
                startActivity(callIntent);

            }
        });
        final TextView c1097 = (TextView)view.findViewById(R.id.c1097);
        c1097.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c1097.getText().toString().trim()));
                startActivity(callIntent);

            }
        });
        final TextView c1066 = (TextView)view.findViewById(R.id.c1066);
        c1066.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c1066.getText().toString().trim()));
                startActivity(callIntent);

            }
        });
        final TextView c18001030222 = (TextView)view.findViewById(R.id.c18001030222);
        c18001030222.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c18001030222.getText().toString().trim()));
                startActivity(callIntent);

            }
        });
        // Inflate the layout for this fragment
        return view;
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
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
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
