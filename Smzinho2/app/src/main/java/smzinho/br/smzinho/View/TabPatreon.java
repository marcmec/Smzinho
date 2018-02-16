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
public class TabPatreon extends Fragment {

    public TabPatreon(){}

    private WebView patrao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_patreon, container,false);


        patrao=(WebView) view.findViewById(R.id.ac_patrao);
        WebSettings webSettings= patrao.getSettings();
        webSettings.setJavaScriptEnabled(true);
        patrao.loadUrl("https://apoia.se/smzinho");
        patrao.setWebViewClient(new WebViewClient());

        return view;
    }
}
