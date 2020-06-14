package tottenhamhotspur.tottenhamhostpur;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import androidx.fragment.app.Fragment;

public class TottenhamFragment extends Fragment {
    private WebView mwv;//mobile web view
    public TottenhamFragment(){
        // Required empty public constructor
    }


   //region onCreateView에 들어있는 inflater를 이용하여 우리가만든 fragment_tottenham.xml을 뷰로 연결합니다
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tottenham, container, false);
        mwv = (WebView) v.findViewById(R.id.activity_main_webview);

        WebSettings mws=mwv.getSettings();//Mobile Web Setting
        mws.setJavaScriptEnabled(true);//자바스크립트 허용
        mws.setLoadWithOverviewMode(true);//컨텐츠가 웹뷰보다 클 경우 스크린 크기에 맞게 조정

        mwv.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
//        mwv.loadUrl("https://www.tottenhamhotspur.com/");
        mwv.loadUrl("http://u-health.dobong.go.kr/hcal/fatness.asp");
        return v;
    }
    //endregion
}
