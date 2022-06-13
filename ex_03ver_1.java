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
	
		
		//예약을 위한 객체 생성→ 3층위를 생성하기 위해 3개의 객체를 만듬
		Reserve1 r1=new Reserve1();
		r1.sSeat(); r1.aSeat(); r1.bSeat();
		//좌석 조회를 위한 객체 생성
		Check1 c1=new Check1();
		//취소를 위한 객체 생성
		Cancle1 cancle1=new Cancle1();
		//영화 목록불러오기
		FileRead1 f1=new FileRead1();
		
		
		
//		boolean flag = true;  
//				if(sc.nextInt()==num) {
//					flag=true;
//				}else if(sc.nextInt()!=num) {
//					flag=false;
//				}
//		
		System.out.println("영화 예약 프로그램입니다.");
		while(true) {
			System.out.println("1.예약 2.조회 3.취소 4.관리자 5.종료");
				num= sc.nextInt();
				
				switch(num) {
				
					case 1:
						//영화목록을 불러와 보여주기
						f1.read();
						System.out.println("좌석을 선택해주세요 \n1.S석 / 2.A석 / 3.B석");
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
						System.out.println("좌석을 선택해주세요 \n1.S석 / 2.A석 / 3.B석");
						num1=sc.nextInt();
							if(num1==1) {cancle1.sCancle();}
							else if(num1==2) {cancle1.aCancle();}
							else if(num1==3) {cancle1.bCancle();}
							else System.out.println("다시입력해 주세요");
						break;
					case 4:
						System.out.println("관리자메뉴 입니다");
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
	//클래스에서 스캐너 한번만 사용!
	
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
			
			System.out.print ("S석 \n");
			System.out.println("\t\t┌──────────────────┐");
			System.out.println("\t\t│      screen      │");
			System.out.println("\t\t└──────────────────┘");
				for(int j=0; j< S.length; j++) {
					System.out.print(j+1);
					System.out.print(S[j]);
			}//for j
		//}//for i
		System.out.println("\n예약할 좌석을 번호로 선택해 주세요");
		num=sc.nextInt();

		System.out.println("이름을 입력하세요");
		name= sc.next();
		S[num-1]=name;
		
	}
	
	
	void abooking(){
		String name;
		int num;
		
		System.out.print ("A석 \n");
		System.out.println("\t\t┌──────────────────┐");
		System.out.println("\t\t│      screen      │");
		System.out.println("\t\t└──────────────────┘");
				for(int j=0; j< A.length; j++) {
					System.out.print(j+1);
					System.out.print(A[j]);
			}//for j
		//}//for i
		System.out.println("\n예약할 좌석을 번호로 선택해 주세요");
		num=sc.nextInt();

		System.out.println("\n이름을 입력하세요");
		name= sc.next();
		A[num-1]=name;
	}
	
	void bbooking() {
		String name;
		int num;
		
		System.out.print ("B석 \n");
		System.out.println("\t\t┌──────────────────┐");
		System.out.println("\t\t│      screen      │");
		System.out.println("\t\t└──────────────────┘");
		//for (int i = 0 ; i <1 ; i++) {
                for(int j = 0; j < B.length; j++ ) {
                	System.out.print(j+1);
                    System.out.print(B[j]);
                	}//for j
					//}//for i
						System.out.println("\n이름>>");
				        name = sc.next();
				        System.out.println("번호>>");
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
			System.out.println(e+"오류입니다");
			
		}
	
	}
	   
}//C





//좌석 조회를 위한 클래스
class Check1 extends Reserve1{
		
		//int i, j;
	//	Check1(){}
		
	 void show() {
		 for(int i=0; i<1; i++){
			 System.out.print("S석");
			 for(int j=0; j<S.length; j++) {
				 System.out.print(S[j]);
			 }
		 }
		 System.out.println("");
		 
		 for(int i=0; i<1; i++){
			 System.out.print("A석");
			 for(int j=0; j<A.length; j++) {
				 System.out.print(A[j]);
			 }
		 }
		 System.out.println("");
		 
		 for(int i=0; i<1; i++){
			 System.out.print("B석");
			 for(int j=0; j<B.length; j++) {
				 System.out.print(B[j]);
			 }
		 }
		 System.out.println("");
		 System.out.println("전좌석 조회 완료\n");	 
	 }
	 
}//c

//좌석 취소를 위한 클래스 
class Cancle1 extends Reserve1{
	
	String name;
	
	Cancle1(){}
	
	void sCancle() {
		//for (int i = 0; i < 1; i++) {
			System.out.println("S석");
				for (int j = 0; j < S.length; j++) {
					System.out.print(S[j]);
					}
				//}
				
				System.out.println("\n예약한 이름을 입력해주세요");
				name =sc.next();
				for (int i = 0; i < S.length; i++) {
					if(S[i].equals(name)) {
						S[i]="---";
					}else {
						System.out.println("입력하신 이름과 일치하는 정보가 없습니다 \n 다시 입력해 주세요 ");
					}
					
				}//for
			}//method
	
	
	void aCancle() {
		System.out.println("A석");
		for (int j = 0; j < A.length; j++) {
			System.out.print(A[j]);
			}
		//}
		
		System.out.println("\n예약한 이름을 입력해주세요");
		name =sc.next();
		for (int i = 0; i < A.length; i++) {
			if(A[i].equals(name)) {
				A[i]="---";
			}//if
		}//for
	}//method

	
	void bCancle() {
		System.out.println("A석");
		for (int j = 0; j < B.length; j++) {
			System.out.print(B[j]);
			}
		
		System.out.println("\n예약한 이름을 입력해주세요");
		name =sc.next();
		for (int i = 0; i < B.length; i++) {
			if(B[i].equals(name)) {
				B[i]="---";
			}//if
		}//for
	}//method
	
}//c
