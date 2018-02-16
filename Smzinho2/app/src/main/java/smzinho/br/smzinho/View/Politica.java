package smzinho.br.smzinho.View;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import smzinho.br.smzinho.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Politica extends Fragment {


    public Politica(){}

    private WebView pv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_politica, container,false);

        pv=(WebView) view.findViewById(R.id.politica);
        WebSettings webSettings= pv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        pv.loadUrl("https://blogsmzinhoapp.wordpress.com/politica-de-privacidade/");
        pv.setWebViewClient(new WebViewClient());
        return view;

    }

}
