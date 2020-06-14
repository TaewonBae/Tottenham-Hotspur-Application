package tottenhamhotspur.tottenhamhostpur;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class MatchFragment extends Fragment {

    //region MatchFragment()객체 생성
    public MatchFragment() {
        // Required empty public constructor
    }//endregion

    //region onCreateView에 있는 inflater로 fragment_match.xml파일을 View로 연결합니다!
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_match, container, false);
    }//endregion
}
