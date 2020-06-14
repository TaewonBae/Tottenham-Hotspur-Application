package tottenhamhotspur.tottenhamhostpur;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;
    private String Number = "";
    private String Name = "";
    private String Match = "";
    private String Goal = "";
    private String Assist = "";
    private String MoM = "";

    //db 이미지뷰를 로드해보자
    private ImageView blobImg;
    //db 미디어를 로드해보자
    Context context;
    private MediaPlayer mediaPlayer = new MediaPlayer();

    //region private constructor so that object creation from outside the class is avoided
    private DatabaseAccess(Context context){
        this.openHelper = new DatabaseOpenHelper(context);

    }//endregion

    //region to return the single instance of database
    public static DatabaseAccess getInstance(Context context){
        if(instance==null){
            instance=new DatabaseAccess(context);
        }
        return instance;
    }//endregion

    //region to open the databas e
    public void open(){
        this.db=openHelper.getWritableDatabase();
    }
    //endregion

    //region closing the database connection
    public void close(){
        if(db!=null){
            this.db.close();
        }
    }//endregion

    //now lets create a method to query and return the result from database

    //region we will query for address by passing name
    public String getAddress(String name, int i) {
        c = db.rawQuery("select Number,Name,Match,Goal,Assist,MoM from player where Name = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        c.moveToNext();

        return c.getString(i);
    }//endregion

    public Bitmap getAddress(String name){
        c = db.rawQuery("select Image from player where Name = '" + name + "'", new String[]{});
        c.moveToNext();
        byte[] image = c.getBlob(0);
        Bitmap bm = BitmapFactory.decodeByteArray(image,0,image.length);
        return bm;
    }
    public MediaPlayer getAddress2(String name, Context context){

        c=db.rawQuery("select Mp3 from player where Name = '" + name + "'", new String[]{});
        c.moveToNext();
        byte[] mp3 = c.getBlob(0);
        playMp3(mp3, context);
        return null;
    }

    private void playMp3(byte[] mp3SoundByteArray, Context context) {
        try {
            // create temp file that will hold byte array
            File tempMp3 = File.createTempFile("fmtemp", ".mp3", context.getCacheDir());
            FileOutputStream fos = new FileOutputStream(tempMp3);
            fos.write(mp3SoundByteArray);
            fos.close();
            mediaPlayer.reset();
            FileInputStream fis = new FileInputStream(tempMp3);
            mediaPlayer.setDataSource(fis.getFD());
            mediaPlayer.prepare();
            mediaPlayer.start();
            tempMp3.deleteOnExit();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



}
