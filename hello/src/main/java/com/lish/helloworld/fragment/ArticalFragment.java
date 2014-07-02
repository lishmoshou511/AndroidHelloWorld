package com.lish.helloworld.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.lish.helloworld.app.R;

import org.w3c.dom.Text;

public class ArticalFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String TAG = "ArticalFragment";

    private Button visitBtn;

    private TextView infoTextView;

    private String mParam1;
    private String mParam2;

    public static ArticalFragment newInstance(String param1, String param2) {
        ArticalFragment fragment = new ArticalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public ArticalFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



        Log.i(TAG,"Fragment创建");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG,"Fragment创建视图");
        View rootView = inflater.inflate(R.layout.fragment_artical, container);
        if(rootView!=null){
            visitBtn=(Button)rootView.findViewById(R.id.visitBtn);
            infoTextView=(TextView)rootView.findViewById(R.id.infoTextView);
            visitBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    infoTextView.setText("准备去访问网页了...");

                }
            });
        }



        return rootView;


    }


    @Override
    public void onAttach(Activity activity) {

        Log.i(TAG,"Fragment附着");
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {

        Log.i(TAG,"Fragment解除附着");
        super.onDetach();
    }
}
