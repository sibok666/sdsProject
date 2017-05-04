package cuestionario.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by asuarezr on 02/05/2017.
 */

public class Util {

public Date stringADate(String fecha){
     SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yy");
     String dateInString = fecha;
     Date date=null;
     try {

         date = formatter.parse(dateInString);
         //System.out.println(date);
         //System.out.println(formatter.format(date));

     } catch (ParseException e) {
         e.printStackTrace();
     }
     return date;
 }
    public String dateAString(Date fecha){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dateInString = fecha;
        String date="";
            date = formatter.format(dateInString);
        return date;
    }

    public byte[] getImageBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    public Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

    public byte[] getBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];

        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }
        return byteBuffer.toByteArray();
    }

    public Double stringADouble(String numero){
        return Double.parseDouble(numero);
    }

    public String imagenBinariaAJson(byte [] byteArrayImage){
        String encodedImage = Base64.encodeToString(byteArrayImage, Base64.DEFAULT);
        return encodedImage;
    }

}
