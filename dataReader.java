package dataReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class dataReader {

	public static void main(String[] args) throws IOException {
		
		
//		BufferedReader obj=new BufferedReader(new FileReader(doc));
//		
//		String str;
//		while((str=obj.readLine()) !=null) 
//			System.out.println(str);
		
		System.out.println("��ȭ�� �̸� �Է�");
		Scanner sc=new Scanner(System.in);
		String input= sc.next();
		
		File doc =new File("src/data/text.txt");
		//���ϻ��� ����� Ȯ���� 
		
		try {
			FileOutputStream fous=new FileOutputStream(doc);
			String str1= input;
			byte b[]=str1.getBytes();
			byte b1[]=str1.getBytes();
			
			fous.write(b);
			fous.write(b1);
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
		
		
		
	}//m
}//c
