package tottenhamhotspur.tottenhamhostpur;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    //region BottomNavigationView, FrameLayout 객체생성
    private BottomNavigationView MainBottomNav;
    private FrameLayout MainFrame;
    //endregion
    //regionFragment 액티비티 객체생성
    private TottenhamFragment tottenhamFragment;
    private StadiumFragment stadiumFragment;
    private TeamFragment teamFragment;
    private MatchFragment matchFragment;
    private AnalysisFragment analysisFragment;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //region BottomNavigationBar만들기
        //region 메인 프레임레이아웃, 메인 바텀네비게이션 객체를 만들고 xml파일에서 main_frame이라는 id를 찾는다.
        FrameLayout MainFrame = (FrameLayout) findViewById(R.id.main_frame);//메인 프레임 찾아오기
        BottomNavigationView MainBottomNav = (BottomNavigationView) findViewById(R.id.main_bottom_nav);//메인바텀nav 찾아오기
        //endregion

        //region 프라그먼트 클래스 객체생성  클래스객체변수 = new 클래스();
        tottenhamFragment = new TottenhamFragment();
        stadiumFragment = new StadiumFragment();
        teamFragment = new TeamFragment();
        matchFragment = new MatchFragment();
        analysisFragment = new AnalysisFragment();
        //endregion

        //region 객체선택Listener
        MainBottomNav.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.nav_tottenham:
                        setFragment(tottenhamFragment);
                        return true;

                    case R.id.nav_stadium:
                        setFragment(stadiumFragment);
                        return true;

                    case R.id.nav_team:
                        setFragment(teamFragment);
                        return true;

                    case R.id.nav_match:
                        setFragment(matchFragment);
                        return true;

                    case R.id.nav_analysis:
                        setFragment(analysisFragment);
                        return true;

                    default:
                        return false;
                }
            }


        });
        //endregion
        //endregion


    }

    //region setFragment함수생성  >>MainActivity안에 넣어야됨
    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }
    //endregion
}
