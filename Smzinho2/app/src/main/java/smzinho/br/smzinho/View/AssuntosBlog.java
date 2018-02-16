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
public class AssuntosBlog extends Fragment {
    public AssuntosBlog(){}
    private WebView assV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_assuntos, container,false);

        assV = (WebView) view.findViewById(R.id.ac_assv);
        WebSettings webSettings = assV.getSettings();
        webSettings.setJavaScriptEnabled(true);
        assV.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLScMmN6ErAIL26pB65yf9-Py8KAfkN1_BVAL03Og_quIloq_tA/viewform");
        assV.setWebViewClient(new WebViewClient());
        return view;
    }
}
