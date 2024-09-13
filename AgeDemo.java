import java.util.*;

class Age{
	String bdate;
	String cdate;

	public Age(){
		bdate="";
		cdate="";
	}

	public void getDate(){
		Scanner conin= new Scanner(System.in);
		System.out.print("\nEnter birth date (dd/mm/yyyy format) : ");
		bdate=conin.nextLine();

		System.out.print("Enter current date (dd/mm/yyyy format) : ");
		cdate=conin.nextLine();
	}

	private int getDay(String sdt){
		String s=sdt.substring(0,2);
		int a=Integer.parseInt(s);
		return a;
	}

	private int getMonth(String sdt){
		String s=sdt.substring(3,5);
		int a=Integer.parseInt(s);
		return a;
	}
		
	private int getYear(String sdt){
		String s=sdt.substring(6);
		int a=Integer.parseInt(s);
		return a;
	}

	private int days(int m, int y){
		if(m==2){
			if(y%400==0)
				return 29;
			if(y%100!=0 && y%4==0)
				return 29;
			return 28;
		}
		if(m==4 || m==6 || m==9 || m==11)
			return 30;
		return 31;
	}
	
	private int totdays(String sdt){
		int d=getDay(sdt);
		int m=getMonth(sdt);
		int y=getYear(sdt);

		int tot=(y-1)*365 + (y-1)/4 - (y-1)/100 +(y-1)/400;
		
		int i=0;

		for(i=1;i<m;i++)
			tot=tot+days(i,y);
		tot=tot+d;

		return tot;				
	}

	public void display(){
		getDate();

		int t1=totdays(bdate);
		int t2=totdays(cdate);

		int t=t2-t1;

		System.out.println("\nAge in days : "+t);

		int tw=t/7;
		System.out.println("\nAge in weeks : "+tw);

		int tm=tw*12;
		System.out.println("\nAge in weeks : "+tm);

		double ty=tw/52;
		System.out.println("\nAge in Years : "+ty);


	}

}

class  AgeDemo{
	public static void main(String arg[]){
		Age ob= new Age();
		ob.display();
	}
}