package tottenhamhotspur.tottenhamhostpur;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class TeamFragment extends Fragment {


    public TeamFragment() {
        // Required empty public constructor
    }

    //region FRAGMENT_TEAM.xml을 view로 연결한 후 리턴해줌
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_team, container, false);
        ImageView tottenham_first_team = (ImageView) v.findViewById(R.id.first_team_member_image_id);//프라그먼트에서는 findViewById가 먹히지않으니 View v v.을 해준다
        ImageView tottenham_coaching_staff = (ImageView) v.findViewById(R.id.coaching_staff_image_id);

        //region tottenham_first_team 이미지를 클릭하면
        tottenham_first_team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Main >> First_Team_Member_Activity로 이동
                Intent intent = new Intent(getActivity(), First_Team_Member_Activity.class);//fragment에서는 this를못쓰니 getActivity로해준다
                //화면전환 시작
                startActivity(intent);
                //화면전환후 이 페이지로 오기를 원치않으면
                //finish();
            }
        });
        //endregion

        //region tottenham_coaching_staff 이미지를 클릭하면
        tottenham_coaching_staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Main >> Coaching_Staff_Member_Activity로 이동
                Intent intent = new Intent(getActivity(), Coaching_Staff_Member_Activity.class);
                //화면전환 시작
                startActivity(intent);
                //화면전환후 이 페이지로 오기를 원치않으면
                //finish();
            }
        });//endregion
        return v;

    }
    //endregion
}
