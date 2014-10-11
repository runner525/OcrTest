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

		//��ʼ��tess
		//android���棬tessdata�϶��÷ŵ�sd������
		//���tessdata���Ŀ¼����sd���ĸ�Ŀ¼
		//��ôpathֱ�Ӵ���sd����Ŀ¼
		//eng����Ӣ�ģ��������ԣ���ISO 639-3��׼�Ĵ�����У��������Ʋ�wiki
		File dirString=Environment.getExternalStorageDirectory();
		baseApi.init("dirString", "eng");

		//options��Ϊ������ͼƬ������������ţ�ͼƬС�Ļ����Բ�����
	//	BitmapFactory.Options options=new BitmapFactory.Options();
		//��СΪԭ����1/2
	//	options.inSampleSize=2;

		//bitmap������������������ʽ��ֻҪ���γ�Bitmap����
		Bitmap bitmap =BitmapFactory.decodeResource(getResources(), R.drawable.z);
				//BitmapFactory.decodeStream(instream,null,options); 
		    //    instream.close();    


		//���ͼƬ��Alphaֵ����ô�������һ��
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

		//����Ҫocr��ͼƬbitmap
		baseApi.setImage(bitmap);
		//����Init�����ԣ����ocr����ַ���
		String text= baseApi.getUTF8Text();
		
		tvTip.setText(text);
		
		//�ͷ�bitmap
		baseApi.clear();

		//�������ocr����ͼƬ�����end���Բ����ã���ÿ��ocr֮�󣬱������clear����bitmap�����ͷ�
		//�ͷ�native�ڴ�
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

		//��ʼ��tess
		//android���棬tessdata�϶��÷ŵ�sd������
		//���tessdata���Ŀ¼����sd���ĸ�Ŀ¼
		//��ôpathֱ�Ӵ���sd����Ŀ¼
		//eng����Ӣ�ģ��������ԣ���ISO 639-3��׼�Ĵ�����У��������Ʋ�wiki
		File dirString=Environment.getExternalStorageDirectory();
		baseApi.init("dirString", "eng");

		//options��Ϊ������ͼƬ������������ţ�ͼƬС�Ļ����Բ�����
	//	BitmapFactory.Options options=new BitmapFactory.Options();
		//��СΪԭ����1/2
	//	options.inSampleSize=2;

		//bitmap������������������ʽ��ֻҪ���γ�Bitmap����
		Bitmap bitmap =BitmapFactory.decodeResource(getResources(), R.drawable.z);
				//BitmapFactory.decodeStream(instream,null,options); 
		    //    instream.close();    


		//���ͼƬ��Alphaֵ����ô�������һ��
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

		//����Ҫocr��ͼƬbitmap
		baseApi.setImage(bitmap);
		//����Init�����ԣ����ocr����ַ���
		String text= baseApi.getUTF8Text();
		
		tvTip.setText(text);
		
		//�ͷ�bitmap
		baseApi.clear();

		//�������ocr����ͼƬ�����end���Բ����ã���ÿ��ocr֮�󣬱������clear����bitmap�����ͷ�
		//�ͷ�native�ڴ�
		baseApi.end();

		///////////////////////////��������//////////////////////////////////
		        

		        //��ȡ�ַ��߿�
		        
		    //    Pixa pixa= baseApi.getCharacters();
		        
		        //ͬ�ϣ�������������ֵı߿�
		     //   baseApi.getRegions();
		        
		        //ͬ�ϣ�ֻ��������������
		      //  baseApi.getTextlines();
		        
		        //ʣ�µ��Լ����԰ɡ�
		        
		        //תΪrect���� ��֮�󣬿��Ժܷ������ͼƬ�Ͽ������
		        //��ô������
		       // ArrayList<Rect> rects=pixa.getBoxRects();
	}
	
}
