package smzinho.br.smzinho.View;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import br.smzinho.app_smzinho.R;


public class TabSalveFragments extends Fragment {


    public TabSalveFragments(){}

    private WebView mySalve;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_salve, container, false);
        mySalve=(WebView) view.findViewById(R.id.ac_salve);
        WebSettings webSettings= mySalve.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mySalve.loadUrl("https://goo.gl/lvw8V2");
        mySalve.setWebViewClient(new WebViewClient());
        return view;
    }
}
