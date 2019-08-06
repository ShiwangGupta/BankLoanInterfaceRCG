import java.awt.List;
import java.util.ArrayList;
import java.util.*;
import java.util.HashMap;
import java.util.Scanner;
import javafx.util.Pair;

/**
 * 
 */

/**
 * @author shiwagupta
 *
 */

interface Bank{
	void getName();
	void getNumber();
	void getAddress();
}

abstract class Loan{	
	abstract void getEmpId();
	abstract void getHousingLoan();
	abstract void getEducationLoan();
	abstract void getPersonalLoan();
	abstract void getTravelLoan();
}

class Mybank implements Bank{
	
	protected String firstName,lastName;
	protected String phoneNumber;
	ArrayList<Character>[] address = new ArrayList[4];
	
	public void getName(){
		Scanner sc=new Scanner(System.in);
		firstName=sc.nextLine();
		lastName=sc.nextLine();
	}
	
	public void getNumber(){
		Scanner sc=new Scanner(System.in);
		phoneNumber=sc.nextLine();
	}
	
	public void getAddress(){
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<4;i++){
			String str=sc.nextLine();
			address[i]=new ArrayList<Character>();
			for (char c : str.toCharArray()){
				address[i].add(c);
			}
		}
	}
}

class AccountDetail{
	Boolean isParentAccountPresent;
	int balance;
	AccountDetail(Boolean isParentAccountPresent,int balance){
		isParentAccountPresent=isParentAccountPresent;
		balance=balance;
	}
	
}

class MybankLoan extends Mybank{

	private HashMap<Pair<String,String>, AccountDetail > hm=new HashMap<Pair<String,String>, AccountDetail>();
	hm.put(new Pair<String,String>("vikram bhatt","1234512345"),new AccountDetail(true,1000000));
	private AccountDetail getAccountDetails(){
		String name=firstName+ lastName;
		return hm.get(Pair<String,String>(name, phoneNumber));
	}
	
	private int empId;
	public void getEmpId(){
		Scanner sc=new Scanner(System.in);
		empId=sc.nextInt();
	}
	public String getHousingLoan(int option, int loan){
		AccountDetail ad= getAccountDetails();
		if(ad.balance>100000 && loan<10000000){
			return "Yes";
		}else{
			return "No";
		}
	}
	public String getEducationLoan(int loan){
		AccountDetail ad= getAccountDetails();
		if(ad.balance>500000 && ad.IsParentAccountPresent && loan<10000000){
			return "Yes";
		}else{
			return "No";
		}
	}
	public String getPersonalLoan(int loan){
		AccountDetail ad= getAccountDetails();
		if(loan<10000000){
			return "Yes";
		}else{
			return "No";
		}
	}
	public String getTravelLoan(int loan){
		AccountDetail ad= getAccountDetails();
		if(ad.balance>5000000 && loan<10000000){
			return "Yes";
		}else{
			return "No";
		}
	}
}

public class Interfaceforloan {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MybankLoan mbl= new MybankLoan();
		mbl.getName();
		mbl.getNumber();
		mbl.getAddress();
		mbl.getEmpId();
		Scanner sc=new Scanner(System.in);
		int amount=sc.nextInt();
		int option= sc.nextInt();
		mbl.getHousingLoan(option,amount);
		amount=sc.nextInt();
		mbl.getEducationLoan(amount);
		amount=sc.nextInt();
		mbl.getTravelLoan(amount);
		amount=sc.nextInt();
		mbl.getPersonalLoan(amount);
	}

}
