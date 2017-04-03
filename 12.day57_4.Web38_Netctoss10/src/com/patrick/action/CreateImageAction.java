package com.patrick.action;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Map;

import com.patrick.util.ImageUtil;

public class CreateImageAction extends BaseAction{

	// output
	private InputStream imageStream;
	
	public String execute(){
		// 1. generate image
		Map<String,BufferedImage> map = ImageUtil.createImage();
		
		// 2. read its key,(only one key in this map)
		String code = map.keySet().iterator().next();
		session.put("imageCode", code);
		
		// 3. read image
		BufferedImage image = map.get(code);
		imageStream = ImageUtil.getInputStream(image);
		
		return "success";
	}
	
	
	public InputStream getImageStream() {
		return imageStream;
	}
	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}
	
	
}
