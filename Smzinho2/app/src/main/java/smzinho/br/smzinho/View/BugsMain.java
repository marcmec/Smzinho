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

/**
 * A simple {@link Fragment} subclass.
 */
public class BugsMain extends Fragment {


    public BugsMain(){}

    private WebView bugs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tab_bugs, container,false);


        bugs=(WebView) view.findViewById(R.id.ac_bugs);
        WebSettings webSettings= bugs.getSettings();
        webSettings.setJavaScriptEnabled(true);
        bugs.loadUrl("https://goo.gl/forms/mAWfmpe4knkRONUW2");
        bugs.setWebViewClient(new WebViewClient());
        return view;
    }

}
