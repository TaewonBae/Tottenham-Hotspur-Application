package tottenhamhotspur.tottenhamhostpur;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class First_Team_Member_Activity extends Activity {
    //region intent로 tottenham_first_member.xml파일 불러오기
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tottenham_first_member);

        Intent intent = getIntent();
    }//endregion
}
