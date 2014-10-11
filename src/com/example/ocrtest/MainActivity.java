package com.example.ocrtest;

import java.io.File;
import java.util.ArrayList;

import com.googlecode.leptonica.android.Pixa;
import com.googlecode.tesseract.android.TessBaseAPI;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
   private TextView tvTip;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TessBaseAPI baseApi=new TessBaseAPI();

		//初始化tess
		//android下面，tessdata肯定得放到sd卡里了
		//如果tessdata这个目录放在sd卡的根目录
		//那么path直接传入sd卡的目录
		//eng就是英文，关于语言，按ISO 639-3标准的代码就行，具体请移步wiki
		File dirString=Environment.getExternalStorageDirectory();
		baseApi.init("dirString", "eng");

		//options是为了缩放图片，这个酌情缩放，图片小的话可以不缩放
	//	BitmapFactory.Options options=new BitmapFactory.Options();
		//缩小为原来的1/2
	//	options.inSampleSize=2;

		//bitmap，我这里是以流的形式，只要能形成Bitmap就行
		Bitmap bitmap =BitmapFactory.decodeResource(getResources(), R.drawable.z);
				//BitmapFactory.decodeStream(instream,null,options); 
		    //    instream.close();    


		//如果图片有Alpha值，那么最好设置一下
		/*ExifInterface exif = new ExifInterface(filename)
		    int exifOrientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL); 


		    int rotate = 0;
		    switch (exifOrientation) {
		        case ExifInterface.ORIENTATION_ROTATE_90:
		            rotate = 90;
		            break;
		        case ExifInterface.ORIENTATION_ROTATE_180:
		            rotate = 180;
		            break;
		        case ExifInterface.ORIENTATION_ROTATE_270:
		            rotate = 270;
		            break;
		    } 


		    if (rotate != 0) { 

		        // Getting width & height of the given image.
		        int w = bitmap.getWidth();
		        int h = bitmap.getHeight(); 

		        // Setting pre rotate
		        Matrix mtx = new Matrix();
		        mtx.preRotate(rotate); 

		        // Rotating Bitmap
		        bitmap = Bitmap.createBitmap(bitmap, 0, 0, w, h, mtx, false);
		        // tesseract req. ARGB_8888
		        bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
		    } */

		//设置要ocr的图片bitmap
		baseApi.setImage(bitmap);
		//根据Init的语言，获得ocr后的字符串
		String text= baseApi.getUTF8Text();
		
		tvTip.setText(text);
		
		//释放bitmap
		baseApi.clear();

		//如果连续ocr多张图片，这个end可以不调用，但每次ocr之后，必须调用clear来对bitmap进行释放
		//释放native内存
		baseApi.end();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		tvTip=(TextView) findViewById(R.id.test);
		
		return true;
	}

	protected void fun()
	{
		TessBaseAPI baseApi=new TessBaseAPI();

		//初始化tess
		//android下面，tessdata肯定得放到sd卡里了
		//如果tessdata这个目录放在sd卡的根目录
		//那么path直接传入sd卡的目录
		//eng就是英文，关于语言，按ISO 639-3标准的代码就行，具体请移步wiki
		File dirString=Environment.getExternalStorageDirectory();
		baseApi.init("dirString", "eng");

		//options是为了缩放图片，这个酌情缩放，图片小的话可以不缩放
	//	BitmapFactory.Options options=new BitmapFactory.Options();
		//缩小为原来的1/2
	//	options.inSampleSize=2;

		//bitmap，我这里是以流的形式，只要能形成Bitmap就行
		Bitmap bitmap =BitmapFactory.decodeResource(getResources(), R.drawable.z);
				//BitmapFactory.decodeStream(instream,null,options); 
		    //    instream.close();    


		//如果图片有Alpha值，那么最好设置一下
		/*ExifInterface exif = new ExifInterface(filename)
		    int exifOrientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL); 


		    int rotate = 0;
		    switch (exifOrientation) {
		        case ExifInterface.ORIENTATION_ROTATE_90:
		            rotate = 90;
		            break;
		        case ExifInterface.ORIENTATION_ROTATE_180:
		            rotate = 180;
		            break;
		        case ExifInterface.ORIENTATION_ROTATE_270:
		            rotate = 270;
		            break;
		    } 


		    if (rotate != 0) { 

		        // Getting width & height of the given image.
		        int w = bitmap.getWidth();
		        int h = bitmap.getHeight(); 

		        // Setting pre rotate
		        Matrix mtx = new Matrix();
		        mtx.preRotate(rotate); 

		        // Rotating Bitmap
		        bitmap = Bitmap.createBitmap(bitmap, 0, 0, w, h, mtx, false);
		        // tesseract req. ARGB_8888
		        bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
		    } */

		//设置要ocr的图片bitmap
		baseApi.setImage(bitmap);
		//根据Init的语言，获得ocr后的字符串
		String text= baseApi.getUTF8Text();
		
		tvTip.setText(text);
		
		//释放bitmap
		baseApi.clear();

		//如果连续ocr多张图片，这个end可以不调用，但每次ocr之后，必须调用clear来对bitmap进行释放
		//释放native内存
		baseApi.end();

		///////////////////////////其它方法//////////////////////////////////
		        

		        //获取字符边框
		        
		    //    Pixa pixa= baseApi.getCharacters();
		        
		        //同上，这个是整段文字的边框
		     //   baseApi.getRegions();
		        
		        //同上，只不过这里是条线
		      //  baseApi.getTextlines();
		        
		        //剩下的自己测试吧。
		        
		        //转为rect数组 ，之后，可以很方便的在图片上框出方框
		        //怎么框由你
		       // ArrayList<Rect> rects=pixa.getBoxRects();
	}
	
}
