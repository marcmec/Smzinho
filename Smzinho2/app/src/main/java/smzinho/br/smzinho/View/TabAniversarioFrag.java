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


public class TabAniversarioFrag extends Fragment {


    public TabAniversarioFrag(){}

    private WebView myNiver;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_aniversarios, container,false);

        myNiver = (WebView) view.findViewById(R.id.ac_aniversario);
        WebSettings webSettings= myNiver.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myNiver.loadUrl("https://goo.gl/C41EqM");
        myNiver.setWebViewClient(new WebViewClient());

        return view;
    }
}
