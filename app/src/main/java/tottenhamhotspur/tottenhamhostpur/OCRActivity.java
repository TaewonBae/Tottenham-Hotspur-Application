package tottenhamhotspur.tottenhamhostpur;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.googlecode.tesseract.android.TessBaseAPI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class OCRActivity extends AppCompatActivity {
    //region 이미지, API, 경로 객체생성
    Bitmap image; //사용되는 이미지
    private TessBaseAPI mTess; //Tess API reference
    String datapath = "" ; //언어데이터가 있는 경로
    //endregion

    //region activity_ocr.xml파일 연결 후 경로 체크
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocr);

        //region이미지 디코딩을 위한 초기화
        image = BitmapFactory.decodeResource(getResources(), R.drawable.epl_rank); //샘플이미지파일
        //언어파일 경로
        datapath = getFilesDir()+ "/tesseract/";

        //트레이닝데이터가 카피되어 있는지 체크
        checkFile(new File(datapath + "tessdata/"));

        //Tesseract API
        String lang = "eng";

        mTess = new TessBaseAPI();
        mTess.init(datapath, lang);
        //endregion
    }//endregion

    //region Process an Image : OCR로 인식된 이미지값들 string 처리후 값 넣어주는 작업!
    public void processImage(View view) {
        String OCRresult = null;
        mTess.setImage(image);
        OCRresult = mTess.getUTF8Text();
        TextView OCRTextView = (TextView) findViewById(R.id.OCRTextView);

        //region tottenham hotspur string처리
        String OCRresultSample = OCRresult;
        int tot = OCRresultSample.indexOf("Tottenham Hotspur");
        String a = OCRresultSample.substring(tot-2,tot-1);
        String b = OCRresultSample.substring(tot,tot+17);
        String c = OCRresultSample.substring(tot+18,tot+20);
        String d = OCRresultSample.substring(tot+21,tot+22);
        String e = OCRresultSample.substring(tot+23,tot+24);
        String f = OCRresultSample.substring(tot+25,tot+26);
        String g = OCRresultSample.substring(tot+27,tot+29);
        String h = OCRresultSample.substring(tot+30,tot+32);
        String i = OCRresultSample.substring(tot+33,tot+34);
        String j = OCRresultSample.substring(tot+35,tot+37);
        //endregion

        //region intent작업 및 setText로 OCRTextView에 값 넣어주기!
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        OCRTextView.setText("순위 : "+a+" 팀명 : "+b+" 경기 : "+c+" 승 : "+d+" 무 : "+e+" 패 : "+f+" 득점 : "+g+" 실점 : "+h+" 득실차 : "+i+" 승점 : "+j);
        intent.putExtra("Rank",a);
        intent.putExtra("Team_name",b);
        intent.putExtra("Match",c);
        intent.putExtra("Win",d);
        intent.putExtra("Draw",e);
        intent.putExtra("Lose",f);
        intent.putExtra("Score",g);
        intent.putExtra("Lost_Score",h);
        intent.putExtra("ScoreDifference",i);
        intent.putExtra("Point",j);
        //endregion

        setResult(RESULT_OK,intent);
        finish();
    }//endregion

    //region copy file to device
    private void copyFiles() {
        try{
            String filepath = datapath + "/tessdata/eng.traineddata";
            AssetManager assetManager = getAssets();
            InputStream instream = assetManager.open("tessdata/eng.traineddata");
            OutputStream outstream = new FileOutputStream(filepath);
            byte[] buffer = new byte[1024];
            int read;
            while ((read = instream.read(buffer)) != -1) {
                outstream.write(buffer, 0, read);
            }
            outstream.flush();
            outstream.close();
            instream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//endregion

    //region check file on the device
    private void checkFile(File dir) {
        //디렉토리가 없으면 디렉토리를 만들고 그후에 파일을 카피
        if(!dir.exists()&& dir.mkdirs()) {
            copyFiles();
        }
        //디렉토리가 있지만 파일이 없으면 파일카피 진행
        if(dir.exists()) {
            String datafilepath = datapath+ "/tessdata/eng.traineddata";
            File datafile = new File(datafilepath);
            if(!datafile.exists()) {
                copyFiles();
            }
        }
    }//endregion
}
