package myMoney;

import java.io.IOException;
import java.util.Date;
//import java.util.List;
import java.util.Scanner;
import java.util.Calendar;


public class Account {
	
	private static double balance=0.0;
	private Scanner scanner = new Scanner(System.in);
	private char choice = '\0';
	private String name ="";
	private int birth;
	private String gender ="";
	private int Rwon;
	private double ar;
	private double desum=0.0;//withdrawl sum
	private double amsum=0.0;//expense sum
	private int num=0;
	Repository repo = Repository.getinstance(); //instantiating Repository class with variable repo
	
//	================================================================
	
	public void nameInsert() {
	
		System.out.println("Please type your NAME! ");
		name  = scanner.next();
		System.out.println("Please type your BirthDay! (ex:001023) ");
		birth = scanner.nextInt();
		System.out.println("Please select your gender : (f/m) ");
		gender = scanner.next();
		
	}

	public void showMenu() {
		
		while (true) {
			printMenu();
			switch (choice) {
			case '0':
				Calendar cal = Calendar.getInstance();
				System.out.println(cal);
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH) + 1;
				int day = cal.get(Calendar.DAY_OF_MONTH);
				System.out.println();
				System.out.println("------------------------------------------------");
				System.out.println("Detailed Information about "+name+ "'s  Account");
				System.out.println("------------------------------------------------");
				System.out.println();
				System.out.println("Account Opening Date :"+year+"."+month+"."+day);
				System.out.println("Name : "+name);
				System.out.println("Gender : "+gender);
				System.out.println("Date of birth : "+birth);
				System.out.print("Goal Setting :");
			
				if(Rwon>0) {
					System.out.println("YES");
					
					System.out.println("Target Amount :"+Rwon);
					ar= balance/Rwon*100;
					System.out.println("Achievement rate : "+ar+"%" );
					if(ar>=100) {
						System.out.println("Great Job! You achieved the Target Savings!");
					}
				}
				else
					System.out.print("Please set target savings amount!");
				System.out.println();
				System.out.println("------------------------------------------------");
				pressAnyKeyToContinue();
				break;
				
				
			case 'A':
				System.out.println("----------");
				System.out.println("Please enter amount to deposit");
				System.out.println("----------");
				float addamount = scanner.nextFloat();
				balance = balance + addamount;
				pressAnyKeyToContinue();
				break;
				
			case 'B':
				System.out.println("----------");
				System.out.println("Please enter amount to withdraw");
				System.out.println("----------");
				float depoamount = scanner.nextFloat();
					
				if(depoamount>balance) {
					System.out.println("<<<NO You can't!>>>");
					System.out.println("<<<There is not enough money in your account to withdraw money.>>>");
					System.out.println("---------Withdrawal failed--------");
					pressAnyKeyToContinue();
					break;
				}
				else if(depoamount<=balance) 
					desum+=depoamount;
				balance = balance - depoamount;
				
				pressAnyKeyToContinue();
				break;
				
				
			case 'C':
				System.out.println("----------");
				addCategory();
				System.out.println("----------");
				System.out.println("\n");
				pressAnyKeyToContinue();
				break;

			case 'D':
				System.out.println("----------");
				categoryList();
				System.out.println("----------");
				System.out.println("\n");
				pressAnyKeyToContinue();
				break;

			case 'E':
				System.out.println("----------");
				expenseEntry();
				System.out.println("----------");
				System.out.println("\n");
				pressAnyKeyToContinue();
				break;

			case 'F':
				System.out.println("----------");
				expenseList();
				System.out.println("----------");
				System.out.println("\n");
				pressAnyKeyToContinue();
				break;
				
			case 'G':
				System.out.println("----------");
				System.out.println("the balance is: "+ balance);
				goalSetResult();
				System.out.println();
				System.out.println("----------");
				pressAnyKeyToContinue();
				break;

			case 'X':
				System.out.println("Bye!");
				System.exit(0);
				break;
				
			case 'H':
				System.out.println("------------------------------------------------");
				System.out.println("                  Goal Setting                  ");
				System.out.println("------------------------------------------------");
				if(num>0) {
					System.out.println("You have already set target saving.. ");
					pressAnyKeyToContinue();
					break;
				}
				goalSetting();
				System.out.println("------------------------------------------------");
				pressAnyKeyToContinue();
				break;
				

			default:
				System.out.println("Invalid Option!!. Please try again");
				System.out.println("\n");
				break;
			}
		}
	}
//	================================================================

	public void printMenu() {
		System.out.println(" *---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*");//YY
		System.out.println("                        "+ name+"'S   ACCOUNT                          ");//이름입력하는 class만들기
		System.out.println(" *---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*");//YY
		
		System.out.println("0. MY ACCOUNT "); //본인계좌 등록 YY
		//본인 계좌 등록에 따라서 뱅크 이름 바뀌게 끔 
		//본인 아이디랑 비밀번호 추가 
		
		
		System.out.println("A. Deposit Cash");
		System.out.println("B. Withdraw Cash");//뺄때 현재 있는 돈보다 많은 돈 빼려하면 에러메시지를 띄움
		System.out.println("C. Add Expence Category");
		System.out.println("D. Show Expence Category List");
		System.out.println("E. Make an Expense Entry");
		System.out.println("F. Show Expense List");
		System.out.println("G. Show Balance");
		System.out.println("H. Goal Setting ");
		System.out.println("X. Exit");
		System.out.println("-----------------------");
		System.out.println("Enter Your Choice: ");
		
		choice = Character.toUpperCase(scanner.next().charAt(0)); 
		// this will change LowerCase inputs to UpperCase
	}
//	================================================================

	public void addCategory() {
		
		scanner.nextLine();
		System.out.println("Enter category Name: ");
		String catName = scanner.nextLine();
		Category cat = new Category(catName); 
		// Create an instance of the Category class using the user input.
		repo.catList.add(cat);
		// Adds the user value into the ArrayList catList
		System.out.println("Category Added. ");
	}
//	================================================================
	
	public void categoryList() {
		System.out.println("category list");
		for (int i = 0; i < repo.catList.size(); i++) {
			Category c = repo.catList.get(i);
			System.out.println((i + 1) + ". " + c.getcatName());
		}// this is to retrieve the values in the ArrayList catList and displaying it. 
	}
//	================================================================
	
	public void expenseEntry() {
		System.out.println("expense entry");
		categoryList();
		System.out.println("choose a category: ");
		
		int catChoice = scanner.nextInt();
		Category selectedCat = repo.catList.get(catChoice - 1); 
		// this is to retrieve the value in the ArrayList catList from the position (catChoice - 1).

		System.out.println("Enter amount ");
		float amount = scanner.nextFloat();
		amsum+=amount;
		//지출누적금액이 인출 누적금액보다 클경우 오류라 출력하고 다시 입력하게끔한다
		String answer="";
		while(amsum>desum) {
			amsum-=amount;
			System.out.println("***Error Occurred***(You must enter an amount to spend less than the withdrawal amount)\n"
					+ "Failure : exp not added ");
			System.out.println("Do you want to re-enter?");
			answer=scanner.next();
			
			if(answer.equals("N")||answer.equals("n")) {
				pressAnyKeyToContinue();
				break;
			}
			else {
			System.out.println("Enter amount ");
			amount = scanner.nextFloat();
			amsum+=amount;
			}
		}
		balance = balance - amount;
		System.out.println("Enter date(automatic input)");
		Date date = new Date();

		Expense exp = new Expense(); // Create an instance of the Expense class.
		exp.setcatName(selectedCat.getcatName()); 
		exp.setAmount(amount);
		exp.setDate(date);
		// this is to set the values in the fields in the Expense class.
		repo.expList.add(exp); // this is to set the values from the Expense class into the ArrayList expList
		System.out.println("success : exp added");
		
	}
//	================================================================
	
	public void expenseList() {
		System.out.println("expense list");
		for (int i = 0; i < repo.expList.size(); i++) {
			Expense exp = repo.expList.get(i);
			System.out.println((i + 1) + ". " + exp.getcatName() + ". " + exp.getAmount() + ". " + exp.getDate() + ". ");
		}// this is to retrieve the values in the ArrayList expList and displaying it. 
	}
//	================================================================
	
	public void pressAnyKeyToContinue() {
		System.out.println("press any key to go back to Main Menue: ");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	================================================================

	public void goalSetting() {
		System.out.print("Your Target Savings : ");
		Rwon = scanner.nextInt();
		System.out.println();
		num++;
		System.out.println("Thank you for your goal setting! \n"
				+ "Let's save until you get the target money together!");
		
	}
//  ====================================================================
	public void goalSetResult() {
		double RM= balance-Rwon;
		System.out.print(RM+"won left until the goal savings amount is achieved!\n"+"Cheear Up!");
	}
	
//  ====================================================================	
}
