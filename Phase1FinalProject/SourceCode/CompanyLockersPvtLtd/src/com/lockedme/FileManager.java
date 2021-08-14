package com.lockedme;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileManager
{
	/**
	 * This method will return the files names from the folder
	 * @param folderpath
	 * @return List<String>
	 */
	public static List<String> getAllFiles(String folderpath)
	{
		// Creating File object
		File folder = new File(folderpath);
		
		// Getting all the Files into FileArray
		File[] listOfFiles = folder.listFiles();
		
		// Declaring a List to store file names
		List<String> fileNames = new ArrayList<String>();
		
		for(File f:listOfFiles)
			fileNames.add(f.getName());
			
		// return the List
		return fileNames;
	 }
	
	
	/**
	 * This method will create or append content to the specified file
	 * @param folderpath
	 * @param fileName
	 * @param content
	 * @return boolean
	 */
	public static boolean addFiles(String folderpath, String fileName, List<String> content) 
	{
	     try 
	     {
	        File folder = new File(folderpath, fileName);
	        FileWriter fw = new FileWriter(folder);
	       
	        for(String s : content) 
	        {
	    	    fw.write(s+"\n");
	        }
	        fw.close();
	        return true;
	     }
	     catch(Exception Ex)
	     {
	    	return false; 
	     }
		
	 } 
	
	/**
	 * This method will delete the file name if it exists
	 * @param folderpath
	 * @param fileName
	 * @return boolean
	 */
	public static  boolean deleteFiles(String folderpath, String fileName)
	{
		
		// Adding folder path with file name and creating file object
		File file = new File(folderpath+"\\"+fileName);
		
		try
		{
			if(file.delete())
				return true;
			else
				return false;
		}
		catch(Exception Ex)
		{
			return false;
		}
	}
	
	/**
	 * This method will search the file name if it exists
	 * @param folderpath
	 * @param fileName
	 * @return boolean
	 */
	public static  boolean searchFiles(String folderpath, String fileName)
	{
		// Adding folder path with file name and creating file object
		File file = new File(folderpath+"\\"+fileName);
		
		if(file.exists())
			return true;
		else 
			return false;
		
	}
}	


