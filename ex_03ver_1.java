package dataReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ex_03ver_1 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int num, num1;
	
		
		//������ ���� ��ü ������ 3������ �����ϱ� ���� 3���� ��ü�� ����
		Reserve1 r1=new Reserve1();
		r1.sSeat(); r1.aSeat(); r1.bSeat();
		//�¼� ��ȸ�� ���� ��ü ����
		Check1 c1=new Check1();
		//��Ҹ� ���� ��ü ����
		Cancle1 cancle1=new Cancle1();
		//��ȭ ��Ϻҷ�����
		FileRead1 f1=new FileRead1();
		
		
		
//		boolean flag = true;  
//				if(sc.nextInt()==num) {
//					flag=true;
//				}else if(sc.nextInt()!=num) {
//					flag=false;
//				}
//		
		System.out.println("��ȭ ���� ���α׷��Դϴ�.");
		while(true) {
			System.out.println("1.���� 2.��ȸ 3.��� 4.������ 5.����");
				num= sc.nextInt();
				
				switch(num) {
				
					case 1:
						//��ȭ����� �ҷ��� �����ֱ�
						f1.read();
						System.out.println("�¼��� �������ּ��� \n1.S�� / 2.A�� / 3.B��");
							num1=sc.nextInt();
						if(num1==1) {
							r1.sbooking();
						}else if(num1==2) {
							r1.abooking();
						}else if(num1==3) {
							r1.bbooking();
						}
						break;
					case 2:
						c1.show();
						break;
					case 3:
						System.out.println("�¼��� �������ּ��� \n1.S�� / 2.A�� / 3.B��");
						num1=sc.nextInt();
							if(num1==1) {cancle1.sCancle();}
							else if(num1==2) {cancle1.aCancle();}
							else if(num1==3) {cancle1.bCancle();}
							else System.out.println("�ٽ��Է��� �ּ���");
						break;
					case 4:
						System.out.println("�����ڸ޴� �Դϴ�");
						break;
					case 5:
						while(num!=5);
						break;	
				}//switch			
		}//while
	}//m
}//c

class Reserve1{

	static String[] S= new String[10];
	static String[] A= new String[10];
	static String[] B= new String[10];

	Scanner sc=new Scanner(System.in);
	//Ŭ�������� ��ĳ�� �ѹ��� ���!
	
	Reserve1(){}
	
	void sSeat() {
		for(int i=0; i<S.length; i++) {
			S[i]="--- ";
		}
	}
	
	void aSeat() {
		for(int i=0; i<A.length; i++) {
			A[i]="--- ";
		}
	}
	
	void bSeat() {
		for(int i=0; i<B.length; i++) {
			B[i]="--- ";
		}
	}
	
	void sbooking() {
			String name;
			int num;
			
			System.out.print ("S�� \n");
			System.out.println("\t\t����������������������������������������");
			System.out.println("\t\t��      screen      ��");
			System.out.println("\t\t����������������������������������������");
				for(int j=0; j< S.length; j++) {
					System.out.print(j+1);
					System.out.print(S[j]);
			}//for j
		//}//for i
		System.out.println("\n������ �¼��� ��ȣ�� ������ �ּ���");
		num=sc.nextInt();

		System.out.println("�̸��� �Է��ϼ���");
		name= sc.next();
		S[num-1]=name;
		
	}
	
	
	void abooking(){
		String name;
		int num;
		
		System.out.print ("A�� \n");
		System.out.println("\t\t����������������������������������������");
		System.out.println("\t\t��      screen      ��");
		System.out.println("\t\t����������������������������������������");
				for(int j=0; j< A.length; j++) {
					System.out.print(j+1);
					System.out.print(A[j]);
			}//for j
		//}//for i
		System.out.println("\n������ �¼��� ��ȣ�� ������ �ּ���");
		num=sc.nextInt();

		System.out.println("\n�̸��� �Է��ϼ���");
		name= sc.next();
		A[num-1]=name;
	}
	
	void bbooking() {
		String name;
		int num;
		
		System.out.print ("B�� \n");
		System.out.println("\t\t����������������������������������������");
		System.out.println("\t\t��      screen      ��");
		System.out.println("\t\t����������������������������������������");
		//for (int i = 0 ; i <1 ; i++) {
                for(int j = 0; j < B.length; j++ ) {
                	System.out.print(j+1);
                    System.out.print(B[j]);
                	}//for j
					//}//for i
						System.out.println("\n�̸�>>");
				        name = sc.next();
				        System.out.println("��ȣ>>");
				        num = sc.nextInt();
				        B[num]= name;
		
				}
	
}//c

class FileRead1 extends Reserve1{
	File file =new File("src/text/movie.txt");
	
	
	void read(){
	try {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line="";
			while((line=br.readLine()) !=null) {
			System.out.println(line);
			}
			System.out.println("==============================");
		br.close();
	}catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}
		
}//met
}//c

class FileWriter1 extends Reserve1{
	File file =new File("src/text/movieReservation.txt");
	
	
	void writer() {
		try {
			FileWriter fw = new FileWriter("src/text/movieReservation.txt", true);
			
		}catch(IOException  e){
			System.out.println(e+"�����Դϴ�");
			
		}
	
	}
	   
}//C





//�¼� ��ȸ�� ���� Ŭ����
class Check1 extends Reserve1{
		
		//int i, j;
	//	Check1(){}
		
	 void show() {
		 for(int i=0; i<1; i++){
			 System.out.print("S��");
			 for(int j=0; j<S.length; j++) {
				 System.out.print(S[j]);
			 }
		 }
		 System.out.println("");
		 
		 for(int i=0; i<1; i++){
			 System.out.print("A��");
			 for(int j=0; j<A.length; j++) {
				 System.out.print(A[j]);
			 }
		 }
		 System.out.println("");
		 
		 for(int i=0; i<1; i++){
			 System.out.print("B��");
			 for(int j=0; j<B.length; j++) {
				 System.out.print(B[j]);
			 }
		 }
		 System.out.println("");
		 System.out.println("���¼� ��ȸ �Ϸ�\n");	 
	 }
	 
}//c

//�¼� ��Ҹ� ���� Ŭ���� 
class Cancle1 extends Reserve1{
	
	String name;
	
	Cancle1(){}
	
	void sCancle() {
		//for (int i = 0; i < 1; i++) {
			System.out.println("S��");
				for (int j = 0; j < S.length; j++) {
					System.out.print(S[j]);
					}
				//}
				
				System.out.println("\n������ �̸��� �Է����ּ���");
				name =sc.next();
				for (int i = 0; i < S.length; i++) {
					if(S[i].equals(name)) {
						S[i]="---";
					}else {
						System.out.println("�Է��Ͻ� �̸��� ��ġ�ϴ� ������ �����ϴ� \n �ٽ� �Է��� �ּ��� ");
					}
					
				}//for
			}//method
	
	
	void aCancle() {
		System.out.println("A��");
		for (int j = 0; j < A.length; j++) {
			System.out.print(A[j]);
			}
		//}
		
		System.out.println("\n������ �̸��� �Է����ּ���");
		name =sc.next();
		for (int i = 0; i < A.length; i++) {
			if(A[i].equals(name)) {
				A[i]="---";
			}//if
		}//for
	}//method

	
	void bCancle() {
		System.out.println("A��");
		for (int j = 0; j < B.length; j++) {
			System.out.print(B[j]);
			}
		
		System.out.println("\n������ �̸��� �Է����ּ���");
		name =sc.next();
		for (int i = 0; i < B.length; i++) {
			if(B[i].equals(name)) {
				B[i]="---";
			}//if
		}//for
	}//method
	
}//c
