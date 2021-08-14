package com.lockedme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockedMeDotCom 
{
    static final String folderpath = "D:\\Phase1FinalProject\\LockedMeProjectFiles";
	public static void main(String[] args) 
	{   
		int proceed = 1;
		do
		{
				   
		        	 
			// Variable declaration
			int ch;
				
			// Menu
			ch = displayMenu();
			
				
			switch(ch)
			{
			case 1 : getAllFiles();
				       break;
			case 2 : addFiles();
			           break;
			case 3 : deleteFiles();
				       break;
			case 4 : searchFiles();
			           break;
			case 5 : System.exit(0); 
				       break;
			default : System.out.println("Invalid Option");
			           break;
	          
			}          
				        
		}while(proceed>0);
	
		
	}
		
	
	public static int displayMenu()
	{
		Scanner obj = new Scanner(System.in);
		int ch;
		
		System.out.println("**************************************************");
		System.out.println("\t  Company Lockers Pvt. Ltd.");
		System.out.println("**************************************************");
		System.out.println("1. Display all files");
		System.out.println("2. Add a new file");
		System.out.println("3. Delete a file");
		System.out.println("4. Search a file");
		System.out.println("5. Exit");
		System.out.println("**************************************************");
		System.out.println("Enter your choice:");
		ch = Integer.parseInt(obj.nextLine());
		
		return ch;
	}
	
	public static void getAllFiles()
	{
		// code for getting file names

        List<String> fileNames = FileManager.getAllFiles(folderpath);
        
        if(fileNames.size()==0)
        	System.out.println("No files in the directory");
        else
        {
        	System.out.println("File list is below:");
        
	        for(String f : fileNames)
        	System.out.println(f);
        }   
	}
	
	public static void addFiles()
	{

		// code for add files

		// Variable Declaration
		Scanner obj = new Scanner(System.in);
		String fileName;
		int linesCount;
		List<String> content = new ArrayList<String>();
			
		// Read File Name from user
		System.out.println("Enter File Name:");
		fileName = obj.nextLine();
				
		// Read number of lines from user
		System.out.println("Enter number of lines in the file:");
		linesCount = Integer.parseInt(obj.nextLine());
				
		// Read lines from user
		for(int i = 1; i<=linesCount; i++) 
		{
			System.out.println("Enter line "+i+":");
			content.add(obj.nextLine());
		}
				
		// Save the content into the file
		boolean isSaved = FileManager.addFiles(folderpath, fileName, content);
				
		if(isSaved)
			System.out.println("File and data saved sucessfully");
		else
			System.out.println("Some error occured. Please contact admin@abc.com");
				
	
	}
	
	public static void deleteFiles()
	{
		// Code for deleting a file

		String fileName;
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter file name to be deleted:");
		fileName = obj.nextLine();
				
		boolean isDeleted = FileManager.deleteFiles(folderpath,  fileName);
		if(isDeleted)
			System.out.println("File deleted successfully");
		else
			System.out.println("Either file doesnot exist or some access issue");

	}
	
	public static void searchFiles()
	{
		// Code for searching a file
		String fileName;
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter file name to be searched:");
		fileName = obj.nextLine();
				
		boolean isFound = FileManager.searchFiles(folderpath,  fileName);
		if(isFound)
			System.out.println("File is present in the folder");
		else
			System.out.println("File is not present in the folder");
	}

}
