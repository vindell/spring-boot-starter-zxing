package com.google.zxing.spring.boot;

import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

import com.google.zxing.spring.boot.utils.QRCodeUtils;

import junit.framework.TestCase;

public class QrCodeTest extends TestCase {
	
	public void testEncode() {

		StringBuilder bulder = new StringBuilder();
		
		bulder.append("{");
			bulder.append("jxb_id:01D644043343D9A2E050007F01002ECA,");
			bulder.append("kch_id:01D644043343D9A2E050007F01002ECA,");
			bulder.append("xn:2014,");
			bulder.append("xq:'春',");
			bulder.append("xslist[");
			for (int i = 0; i < 300; i++) {
				for (int j = 0; j < 20; j++) {
					bulder.append("{");
					bulder.append("xh_id:01D644043343D9A2E050007F01002ECA,");
					bulder.append("xm_id:01D644043343D9A2E050007F01002ECA,");
					bulder.append("zpcj:'不及格',");
					bulder.append("bfzcj:100");
					bulder.append("},");
				}				
				bulder.deleteCharAt(bulder.length() -1);
			}
			bulder.deleteCharAt(bulder.length() -1);
			bulder.append("]}");
		
		// /String str = "{xh:3333333,kcdm:333333,cj:33333}";//二维码内容。
		String imgPath = "d:/test.png"; // 保存文件名。

		try {
			QRCodeUtils.toQrcode(bulder.toString(), new FileOutputStream(imgPath));
			
		} catch (Exception e) {
			  System.out.println(e.toString()); 
		}
	}
	
	public void testEncodeWithLogo() {

		StringBuilder bulder = new StringBuilder();
		
		bulder.append("{");
			bulder.append("jxb_id:01D644043343D9A2E050007F01002ECA,");
			bulder.append("kch_id:01D644043343D9A2E050007F01002ECA,");
			bulder.append("xn:2014,");
			bulder.append("xq:'春',");
			bulder.append("xslist[");
			for (int i = 0; i < 300; i++) {
				for (int j = 0; j < 20; j++) {
					bulder.append("{");
					bulder.append("xh_id:01D644043343D9A2E050007F01002ECA,");
					bulder.append("xm_id:01D644043343D9A2E050007F01002ECA,");
					bulder.append("zpcj:'不及格',");
					bulder.append("bfzcj:100");
					bulder.append("},");
				}				
				bulder.deleteCharAt(bulder.length() -1);
			}
			bulder.deleteCharAt(bulder.length() -1);
			bulder.append("]}");
		
		// /String str = "{xh:3333333,kcdm:333333,cj:33333}";//二维码内容。
		String imgPath = "d:/test2.png"; // 保存文件名。
		String logoPath = "H:/2600.png"; // logo文件名。
		try {
			Image src = ImageIO.read(new File(logoPath));
			QRCodeUtils.toQrcode(bulder.toString(),src, new FileOutputStream(imgPath),true);

		} catch (Exception e) {
			  System.out.println(e.toString()); 
		}
	}
	

}
