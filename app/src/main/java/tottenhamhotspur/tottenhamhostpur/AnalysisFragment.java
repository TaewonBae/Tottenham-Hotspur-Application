package tottenhamhotspur.tottenhamhostpur;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class AnalysisFragment extends Fragment {
    //region OCR버튼 객체 생성 및 이름, 스탯버튼, 결과1~6 : 객체생성
    Button OCR_Button;

    // 이름, 스탯버튼, 결과1~6 : 객체생성
    public EditText name;
    public Button stats_button;
    public TextView result_players1;
    public TextView result_players2;
    public TextView result_players3;
    public TextView result_players4;
    public TextView result_players5;
    public TextView result_players6;
    //db에서 이미지뷰 로드해보자
    public ImageView result_players7;

    //db에서 미디어를 로드해보자
    public Button result_players8;
    View v;
    //endregion

    public AnalysisFragment() {
        // Required empty public constructor
    }

    //region onCreateView에 있는 inflater로 fragment_analysis.xml파일을 View로 연결
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_analysis, container, false);
        //region findViewById 해준다.
        name=v.findViewById(R.id.name);
        stats_button=v.findViewById(R.id.stats_button);
        result_players1=v.findViewById(R.id.result1);
        result_players2=v.findViewById(R.id.result2);
        result_players3=v.findViewById(R.id.result3);
        result_players4=v.findViewById(R.id.result4);
        result_players5=v.findViewById(R.id.result5);
        result_players6=v.findViewById(R.id.result6);

        //db에서 이미지뷰를 로드해보자
        result_players7=v.findViewById(R.id.result7);
        //db에서 미디어를 로드해보자
        result_players8=v.findViewById(R.id.result8);


        //endregion

        //region query button에 onClickListener 설정
        stats_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //create the instance of database access class and open database connection
                DatabaseAccess databaseAccess=DatabaseAccess.getInstance(getActivity().getApplicationContext());
                databaseAccess.open();

                //getting string value from edittext
                String n = name.getText().toString();

                //setting text to result field
                result_players1.setText(databaseAccess.getAddress(n,0));
                result_players2.setText(databaseAccess.getAddress(n,1));
                result_players3.setText(databaseAccess.getAddress(n,2));
                result_players4.setText(databaseAccess.getAddress(n,3));
                result_players5.setText(databaseAccess.getAddress(n,4));
                result_players6.setText(databaseAccess.getAddress(n,5));
                result_players7.setImageBitmap(databaseAccess.getAddress(n));

                databaseAccess.getAddress2(n,getActivity().getApplicationContext());
                databaseAccess.close();

                //database connection closed
                //DONE!!
                //lets run the app
            }
        });
        //endregion

        //region OCR_Button만들기
        OCR_Button = (Button)v.findViewById(R.id.OCR_searching);
        OCR_Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() .getApplicationContext(), OCRActivity.class);
                startActivityForResult(intent,1);//보내고 난후의 인텐트에서 끝난 이벤트를 받는것
            }
        });
        //endregion


        return v; //inflater해준 v값 리턴
    }
    //endregion

    //region OCR Result 값 가져오기
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView OCR_Text;
        //Intent intent2 = getIntent();
        String Rank = data.getExtras().getString("Rank");
        String Team_name = data.getExtras().getString("Team_name");
        String Match =  data.getExtras().getString("Match");
        String Win =  data.getExtras().getString("Win");
        String Draw =  data.getExtras().getString("Draw");
        String Lose =  data.getExtras().getString("Lose");
        String Score =  data.getExtras().getString("Score");
        String Lost_Score =  data.getExtras().getString("Lost_Score");
        String ScoreDifference =  data.getExtras().getString("ScoreDifference");
        String Point =  data.getExtras().getString("Point");

        OCR_Text = (TextView) v.findViewById(R.id.OCR_ResultText);
        OCR_Text.setText("순위 : " + Rank + "   팀명 : "+Team_name +"   경기 : "+Match + "   승 : "+Win + "   무 : "+Draw + "   패 : "+Lose +
                "   득점 : "+Score + "   실점 : "+Lost_Score + "   득실차 : "+ScoreDifference + "   승점 : "+Point);
    }
    //endregion
}
