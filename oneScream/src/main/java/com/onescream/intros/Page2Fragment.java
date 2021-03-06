package com.onescream.intros;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.onescream.R;
import com.onescream.Utils.Utility;

/**
 * Fragment class for Page2 of First Screen
 * <p>
 * Created by Anwar Almojarkesh
 */
public final class Page2Fragment extends Fragment implements OnClickListener {
    Typeface facethin, facebold, faceRegular, EstiloRegular, faceMedium;
    Typeface sanfacebold, sanfaceRegular, sanfaceMedium, sanfacesemibold, proximasemi;
    ImageView Indicator6, Indicator5;
    boolean getValue = false;
    private Utility utility;
    private RelativeLayout rl_main;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        utility = new Utility(getActivity());
        utility.RegisterScreen(getActivity(), getActivity().getResources().getString(R.string.about_intro));

//
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.fragment_page2, container,
                false);
        initTypeFace();
        TextView swipe_txt = (TextView) v.findViewById(R.id.swp);
        swipe_txt.setTypeface(sanfacebold);
        Bundle bundle = getArguments();
        if (bundle != null) {
            getValue = getArguments().getBoolean("activity", false);
        }
        updateLCD(v);



        return v;
    }

    private void updateLCD(View v) {
        initTypeFace();
        TextView title = (TextView) v.findViewById(R.id.title);
        TextView intro_txt = (TextView) v.findViewById(R.id.intro);
        TextView main_txt = (TextView) v.findViewById(R.id.textmain1);
        TextView main_txt2 = (TextView) v.findViewById(R.id.textmain2);
//		TextView swipe_txt=(TextView)v.findViewById(R.id.swp);
//		TextView swipe_txt = (TextView ) v.findViewById(R.id.swp);
        intro_txt.setTypeface(sanfacesemibold);
        main_txt.setTypeface(proximasemi);
        main_txt2.setTypeface(proximasemi);

//		swipe_txt.setTypeface(sanfacebold);

        title.setTypeface(sanfaceRegular);
        Indicator6 = (ImageView) v.findViewById(R.id.iv_page6);
        Indicator5 = (ImageView) v.findViewById(R.id.iv_page5);

        if (getValue) {
            Indicator6.setVisibility(View.GONE);
            Indicator5.setVisibility(View.GONE);
        }
//		TextView labelTitle = (TextView) v.findViewById(R.id.labelll); 
//		 labelTitle.setTypeface(EstiloRegular);

        rl_main = (RelativeLayout) v.findViewById(R.id.rl_main);

        if (utility.getScreenSize()) {
            rl_main.getLayoutParams().height = getResources().getInteger(R.integer.rl_main_height);
            main_txt.setTextSize(getResources().getInteger(R.integer.text_size));
            main_txt2.setTextSize(getResources().getInteger(R.integer.text_size));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            default:
                break;
        }
    }

    private void initTypeFace() {
        facethin = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/Roboto-Thin.ttf");
        facebold = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/Roboto-Bold.ttf");
        faceRegular = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/Roboto-Regular.ttf");
        EstiloRegular = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/EstiloRegular.otf");
        faceMedium = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/Roboto-Medium.ttf");
        sanfacebold = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/SanFranciscoDisplay-Bold.otf");
        sanfaceRegular = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/SanFranciscoDisplay-Regular.otf");
        sanfaceMedium = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/SanFranciscoDisplay-Medium.otf");
        sanfacesemibold = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/SanFranciscoDisplay-Semibold.otf");
        proximasemi = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/Proxima Nova Semibold.otf");

    }


}
