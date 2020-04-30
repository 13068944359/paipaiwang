package com.paipaiwang.utils;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

import com.paipaiwang.exception.AdminUnknowException;

/**
 * 储存文件工具类
 */
public class FileUtil {

	/**
	 * 把文件转存为指定目录下的指定文件
	 * @param videofile   源文件
	 * @param targetPath	目标文件夹
	 * @param newName		目标文件名
	 */
	public static void storeFile(MultipartFile videofile, String targetPath,
			String newName) throws Exception{
		File file = new File(targetPath, newName);
		if (!file.exists()) {
			file.mkdirs();
		}
		
		//保存  
    	videofile.transferTo(file);  
	}
	
	/**
	 * 删除指定路径所对应的文件
	 * @param filePath
	 */
	public static void deleteFile(String filePath)throws Exception{
		
		File file = new File(filePath);
		if(file.isFile() && file.exists()){
			file.delete();
		}
	}
	
	
}
