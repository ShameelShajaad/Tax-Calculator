import java.util.*;
class TaxCalculator{
	public static void clearConsole(){
		try{
			final String os=System.getProperty("os.name");
			if(os.contains("Windows")){
				new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
			}else{
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		}catch(final Exception e){
			e.printStackTrace();
			//Handle any exceptions.
		}
	}
	public static double RentTax(double a){
		a-=100000;
		a*=0.1;
		return a;
	}
	public static double BankInterest(double a){
		a*=0.05;
		return a;
	}
	public static double DividendTax(double a){
		a-=100000;
		a*=0.14;
		return a;
	}
	public static double PayableTax(double a){
		double tax=0.0;
		
		if(a<=141667){
			tax=(a-100000)*0.06;
		}else if(a<=183333){
			tax=(41667*0.06) + (a-141667) * 0.12;
		}else if(a<=225000){
			tax=(41667*0.06) + (41667*0.12) + (a-183333) * 0.18;
		}else if(a<=266667){
			tax=(41667*0.06) + (41667*0.12) + (41667*0.18) + (a-225000) * 0.24;
		}else if(a<=308333){
			tax=(41667*0.06) + (41667*0.12) + (41667*0.18) + (41667*0.24) + (a-266667) * 0.3;
		}else{
			tax=(41667*0.06) + (41667*0.12) + (41667*0.18) + (41667*0.24) + (41667*0.3) + (a-308333) * 0.36;
		}
		
		return tax;
	}
	public static double IncomeTax(double a){
		double tax=0.0;
		
		if(a<=1700000){
			tax=(a-1200000) * 0.06;
		}else if(a<=2200000){
			tax=(500000*0.06) + (a-1700000) * 0.12;
		}else if(a<=2700000){
			tax=(500000*0.06) + (500000*0.12) + (a-2200000) * 0.18;
		}else if(a<=3200000){
			tax=(500000*0.06) + (500000*0.12) + (500000*0.18) + (a-2700000) * 0.24;
		}else if(a<=3700000){
			tax=(500000*0.06) + (500000*0.12) + (500000*0.18) + (500000*0.24) + (a-3200000) * 0.3;
		}else{
			tax=(500000*0.06) + (500000*0.12) + (500000*0.18) + (500000*0.24) + (500000*0.3) + (a-3700000) * 0.36;
		}
		
		return tax;
	}
	public static double SSCLTax(double a){
		double stax=0.0;
		double vat=0.0;
		
		stax=a*0.025;
		a+=stax;
		
		vat=a*0.15;
		
		a=stax+vat;
		
		return a;
	}
	public static double LeasingPayment(double a, double b, double c){
		
		double i=(b/100)/12;
		double n=c*12;
		double monthins=a*i/(1-(1/Math.pow((1+i), n)));
		monthins=Math.round(monthins*1e2)/1e2;
		
		return monthins;
	}
	public static void LeasingCategory(double a, double b){
		for (int j = 3; j <= 5; j++){
			double i=(b/100)/12;
			double n=j*12;
			double monthins=a*i/(1-(1/Math.pow((1+i), n)));
			monthins=Math.round(monthins*1e2)/1e2;
			System.out.println("Your monthly installment for "+j+" year leasing plan  -  "+monthins);
		}
		
		return;
	}
	public static double FindLeasingPayment(double a, double b, double c){
		
		double lease=0.0;
		double n=b*12;
		double i=(c/100)/12;
		
		double x=(1-(1/Math.pow((1+i), n)));
		lease=Math.round(a*x/i);
		return lease;
	}
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		
		char yn;
		
		L1: do{
			System.out.println();
			System.out.println("                                                           __  _______  ________ ________");
			System.out.println("                                                          |  \\/       \\|        |        \\");
			System.out.println("                                                           \\$|  $$$$$$| $$$$$$$$\\$$$$$$$$");
			System.out.println("                                                          |  | $$   \\$| $$__      | $$");
			System.out.println("                                                          | $| $$     | $$  \\     | $$");
			System.out.println("                                                          | $| $$   __| $$$$$     | $$");
			System.out.println("                                                          | $| $$__/  | $$_____   | $$");
			System.out.println("                                                          | $$\\$$    $| $$     \\  | $$");
			System.out.println("                                                           \\$$ \\$$$$$$ \\$$$$$$$$   \\$$");
			System.out.println();
			System.out.println();
			System.out.println("    _______              _    _      ______              _         ______  _    _   _                  _______     ____    _____");
			System.out.println("   |__   __|     /\\     \\ \\ / /     /  ____|     /\\     | |       / ____| | |  | | | |          /\\    |__   __|   / __ \\  |  __ \\");
			System.out.println("      | |       /  \\     \\ V /      | |         /  \\    | |      | |      | |  | | | |         /  \\      | |     | |  | | | |__) |");
			System.out.println("      | |      / /\\ \\     > <       | |        / /\\ \\   | |      | |      | |  | | | |        / /\\ \\     | |     | |  | | |  _  /");
			System.out.println("      | |     / ____ \\   / . \\      | |____   / ____ \\  | |____  | |____  | |__| | | |____   / ____ \\    | |     | |__| | | | \\ \\");
			System.out.println("      |_|    /_/    \\_\\ /_/ \\_\\      \\_____| /_/    \\_\\ |______|  \\_____|  \\____/  |______| /_/    \\_\\   |_|      \\____/  |_|  \\_\\");
			System.out.println();
			System.out.println();
			System.out.println("====================================================================================================================================");
			System.out.println();
			System.out.println();
			System.out.println("	[1] Withholding Tax");
			System.out.println("	[2] Payable Tax");
			System.out.println("	[3] Income Tax");
			System.out.println("	[4] Social Security Contribution Levy (SSCL) Tax");
			System.out.println("	[5] Leasing Payment");
			System.out.println("	[6] Exit");
			System.out.println();
			System.out.print("Enter an option to continue ->  ");
			int option1=input.nextInt();
			clearConsole();
			
			L2: switch (option1){
				
				case 1 :
				
				System.out.println("+-------------------------------------+");
				System.out.println("|           WITHHOLDING TAX           |");
				System.out.println("+-------------------------------------+");
				System.out.println();
				System.out.println("	[1] Rent Tax");
				System.out.println("	[2] Bank Interest Tax");
				System.out.println("	[3] Dividend Tax");
				System.out.println("	[4] Exit");
				System.out.println();
				System.out.println();
				System.out.print("Enter an option to continue ->  ");
				int option2=input.nextInt();
				clearConsole();
				
				L3: switch (option2){
					
					case 1 :
					
					L4: do{ //rent tax
						System.out.println("+--------------------------------+");
						System.out.println("|           RENT TAX             |");
						System.out.println("+--------------------------------+");
						System.out.println();
						System.out.print("	Enter your rent       : ");
						double rent=input.nextDouble(); 
						
						if(rent<0){
							System.out.println("		Invalid Input....");
							System.out.println();
							System.out.println();
							System.out.print("Do you want to enter the correct value again (Y/N)  : ");
							yn=input.next().charAt(0);
							if(yn=='Y' || yn=='y'){
								clearConsole();
								continue L4;
							}else if(yn=='N' || yn=='n'){
								clearConsole();
								break L2;
							}else{
								System.out.println("Wrong option please try again");
								continue L4;
							}
						}
						
						if(rent>100000){
							double rent1=RentTax(rent);
							System.out.println();
							System.out.println("you have to pay Rent Tax  : "+rent1);
						}else{
							System.out.println("		You dont have to pay rent tax");
						}
						
						System.out.println();
						System.out.println();
						System.out.print("Do you want to calculate another rent tax (Y/N)  : ");
						yn=input.next().charAt(0);
						if(yn=='Y' || yn=='y'){
							clearConsole();
							continue L4;
						}else if(yn=='N' || yn=='n'){
							clearConsole();
							break L3;
						}else{
							System.out.println("Wrong option please try again");
							continue L4;
						}
					}while(true);
					
					
					case 2 : 
					
					L5 : do{ //bank interest tax
						System.out.println("+----------------------------------+");
						System.out.println("|        BANK INTEREST TAX         |");
						System.out.println("+----------------------------------+");
						System.out.println();
						System.out.print("Enter your bank interest per year  : ");
						double bankint=input.nextDouble();
						
						if(bankint<0){
							System.out.println("		Invalid Input....");
							System.out.println();
							System.out.println();
							System.out.print("Do you want to enter the correct value again (Y/N)  : ");
							yn=input.next().charAt(0);
							if(yn=='Y' || yn=='y'){
								clearConsole();
								continue L5;
							}else if(yn=='N' || yn=='n'){
								clearConsole();
								break L3;
							}else{
								System.out.println("Wrong option please try again");
								continue L5;
							}
						}
						
						if(bankint>0){
							double bankint1=BankInterest(bankint);
							System.out.println();
							System.out.println("you have to pay Bank Interest Tax per year  : "+bankint1);
						}
						
						System.out.println();
						System.out.println();
						System.out.print("Do you want to calculate another bank interest tax (Y/N)  : ");
						yn=input.next().charAt(0);
						if(yn=='Y' || yn=='y'){
							clearConsole();
							continue L5;
						}else if(yn=='N' || yn=='n'){
							clearConsole();
							break L3;
						}else{
							System.out.println("Wrong option please try again");
							continue L5;
						}
					}while(true);
					
					
					case 3 :
					
					L6: do{ //dividend tax
						System.out.println("+----------------------------------+");
						System.out.println("|           DIVIDEND TAX           |");
						System.out.println("+----------------------------------+");
						System.out.println();
						System.out.print("Enter your total dividend per year  : ");
						double dividend=input.nextDouble();
						
						if(dividend<0){
							System.out.println("		Invalid Input....");
							System.out.println();
							System.out.println();
							System.out.print("Do you want to enter the correct value again (Y/N)  : ");
							yn=input.next().charAt(0);
							if(yn=='Y' || yn=='y'){
								clearConsole();
								continue L6;
							}else if(yn=='N' || yn=='n'){
								clearConsole();
								break L2;
							}else{
								System.out.println("Wrong option please try again");
								continue L6;
							}
						}
						
						if(dividend>100000){
							double dividendtax=DividendTax(dividend);
							System.out.println();
							System.out.println("you have to pay Dividend Tax  : "+dividendtax);
						}else{
							System.out.println("		You dont have to pay dividend tax");
						}
						
						System.out.println();
						System.out.println();
						System.out.print("Do you want to calculate another dividend tax (Y/N)  : ");
						yn=input.next().charAt(0);
						if(yn=='Y' || yn=='y'){
							clearConsole();
							continue L6;
						}else if(yn=='N' || yn=='n'){
							clearConsole();
							break L3;
						}else{
							System.out.println("Wrong option please try again");
							continue L6;
						}
					}while(true);
					
					
					case 4 :
					
					clearConsole();
					break L2;
					
					
					default:
					
					E1: do{
						System.out.println("Wrong option please try again.....");
						System.out.println();
						System.out.println();
						System.out.print("Do you want to exit (Y/N)  : ");
						yn=input.next().charAt(0);
						if(yn=='Y' || yn=='y'){
							clearConsole();
							break L2;
						}else if(yn=='N' || yn=='n'){
							clearConsole();
							break L3;
						}else{
							System.out.println("Wrong option please try again");
							continue E1;
						}
					}while(true);
				}//option2
				
				break;
				
				case 2 :
				
				L7: do{ //payable tax
					System.out.println("+----------------------------------+");
					System.out.println("|           PAYABLE TAX            |");
					System.out.println("+----------------------------------+");
					System.out.println();
					System.out.print("Enter your employee payment per month  : ");
					double payabletax=input.nextDouble();
					
					if(payabletax<0){
						System.out.println("		Invalid Input....");
						System.out.println();
						System.out.println();
						System.out.print("Do you want to enter the correct value again (Y/N)  : ");
						yn=input.next().charAt(0);
						if(yn=='Y' || yn=='y'){
							clearConsole();
							continue L7;
						}else if(yn=='N' || yn=='n'){
							clearConsole();
							break L2;
						}else{
							System.out.println("Wrong option please try again");
							continue L7;
						}
					}
					
					if(payabletax>100000){
						double payabletax1=PayableTax(payabletax);
						System.out.println();
						System.out.println("you have to pay Payable Tax per month  : "+payabletax1);
					}else{
						System.out.println("		You dont have to pay payable tax.....");
					}
						
					System.out.println();
					System.out.println();
					System.out.print("Do you want to calculate another payable tax (Y/N)  : ");
					yn=input.next().charAt(0);
					if(yn=='Y' || yn=='y'){
						clearConsole();
						continue L7;
					}else if(yn=='N' || yn=='n'){
						clearConsole();
						break L2;
					}else{
						System.out.println("Wrong option please try again");
						continue L7;
					}
				}while(true);
				
				
				case 3 :
				
				L8: do{ //income tax
					System.out.println("+----------------------------------+");
					System.out.println("|            INCOME TAX            |");
					System.out.println("+----------------------------------+");
					System.out.println();
					System.out.print("Enter your total income per year  : ");
					double incometax=input.nextDouble();
					
					if(incometax<0){
						System.out.println("		Invalid Input....");
						System.out.println();
						System.out.println();
						System.out.print("Do you want to enter the correct value again (Y/N)  : ");
						yn=input.next().charAt(0);
						if(yn=='Y' || yn=='y'){
							clearConsole();
							continue L8;
						}else if(yn=='N' || yn=='n'){
							clearConsole();
							break L2;
						}else{
							System.out.println("Wrong option please try again");
							continue L8;
						}
					}
					
					if(incometax>1200000){
						double incometax1=IncomeTax(incometax);
						System.out.println();
						System.out.println("you have to pay Income Tax per year  : "+incometax1);
					}else{
						System.out.println("		You dont have to pay income tax.....");
					}
						
					System.out.println();
					System.out.println();
					System.out.print("Do you want to calculate another income tax (Y/N)  : ");
					yn=input.next().charAt(0);
					if(yn=='Y' || yn=='y'){
						clearConsole();
						continue L8;
					}else if(yn=='N' || yn=='n'){
						clearConsole();
						break L2;
					}else{
						System.out.println("Wrong option please try again");
						continue L8;
					}
				}while(true);
				
				
				case 4:
				
				L9: do{ //sscl tax
					System.out.println("+------------------------------------------------------------+");
					System.out.println("|       SOCIAL SECURITY CONTRIBUTION LEVY (SSCL) TAX         |");
					System.out.println("+------------------------------------------------------------+");
					System.out.println();
					System.out.print("Enter value of Good or Service  : ");
					double sscltax=input.nextDouble();
					
					if(sscltax<0){
						System.out.println("		Invalid Input....");
						System.out.println();
						System.out.println();
						System.out.print("Do you want to enter the correct value again (Y/N)  : ");
						yn=input.next().charAt(0);
						if(yn=='Y' || yn=='y'){
							clearConsole();
							continue L9;
						}else if(yn=='N' || yn=='n'){
							clearConsole();
							break L2;
						}else{
							System.out.println("Wrong option please try again");
							continue L9;
						}
					}
					
					double sscltax1=SSCLTax(sscltax);
					System.out.println();
					System.out.println("you have to pay SSCL Tax  : "+sscltax1);
						
					System.out.println();
					System.out.println();
					System.out.print("Do you want to calculate another SSCL tax (Y/N)  : ");
					yn=input.next().charAt(0);
					if(yn=='Y' || yn=='y'){
						clearConsole();
						continue L9;
					}else if(yn=='N' || yn=='n'){
						clearConsole();
						break L2;
					}else{
						System.out.println("Wrong option please try again");
						continue L9;
					}
				}while(true);
				
				
				case 5:
				
				do{
					System.out.println("+---------------------------------------+");
					System.out.println("|            LEASING PAYMENT            |");
					System.out.println("+---------------------------------------+");
					System.out.println();
					System.out.println("	[1] Calculate Monthly Installment");
					System.out.println("	[2] Search Leasing Category");
					System.out.println("	[3] Find Leasing Amount");
					System.out.println("	[4] Exit");
					System.out.println();
					System.out.print("Enter an option to continu ->  ");
					int option3=input.nextInt();
					clearConsole();
					
					switch(option3){
						
						case 1:
						
						L10: do{ //calculate leasing payment
							System.out.println("+------------------------------------------------+");
							System.out.println("|           CALCULATE LEASING PAYMENT            |");
							System.out.println("+------------------------------------------------+");
							System.out.println();
							System.out.print("Enter lease amount          : ");
							double A=input.nextDouble();
							while(A<0){
								System.out.println("	lease amount can't be negative");
								System.out.println();
								System.out.print("Enter lease amount          : ");
								A=input.nextInt();	
							}
							System.out.print("Enter annual interest rate  : ");
							double annuali=input.nextDouble();
							while(annuali<=0){
								System.out.println("	Annual interest rate can't be negative or zero");
								System.out.println();
								System.out.print("Enter annual interest rate  : ");
								annuali=input.nextDouble();
							}
							System.out.print("Enter number of year        : ");
							double year=input.nextDouble();
							while(year>5){
								System.out.println("	Invalid number of year... Enter the correct value again...");
								System.out.println();
								System.out.print("Enter number of year        : ");
								year=input.nextDouble();
							}
							
							double monthlyins=LeasingPayment(A,annuali,year);
							System.out.println("Your monthly Installemt     : "+monthlyins);
							
							System.out.println();
							System.out.println();
							System.out.print("Do you want to calculate another Monthly Installment (Y/N)  : ");
							yn=input.next().charAt(0);
							if(yn=='Y' || yn=='y'){
								clearConsole();
								continue L10;
							}else if(yn=='N' || yn=='n'){
								clearConsole();
								break L2;
							}else{
								System.out.println("Wrong option please try again");
								continue L10;
							}
						}while(true);
						
						
						case 2:
						
						
						L11: do{ //calculate leasing category
							System.out.println("+------------------------------------------------+");
							System.out.println("|            SEARCH LEASING CATEGORY             |");
							System.out.println("+------------------------------------------------+");
							System.out.println();
							System.out.print("Enter lease amount          : ");
							double A=input.nextDouble();
							while(A<0){
								System.out.println("	lease amount can't be negative");
								System.out.println();
								System.out.print("Enter lease amount          : ");
								A=input.nextInt();	
							}
							System.out.print("Enter annual interest rate  : ");
							double annuali=input.nextDouble();
							while(annuali<=0){
								System.out.println("	Annual interest rate can't be negative or zero");
								System.out.println();
								System.out.print("Enter annual interest rate  : ");
								annuali=input.nextDouble();
							}
							System.out.println();
							
							LeasingCategory(A,annuali);
							
							System.out.println();
							System.out.println();
							System.out.print("Do you want to calculate another Monthly Installment (Y/N)  : ");
							yn=input.next().charAt(0);
							if(yn=='Y' || yn=='y'){
								clearConsole();
								continue L11;
							}else if(yn=='N' || yn=='n'){
								clearConsole();
								break L2;
							}else{
								System.out.println("Wrong option please try again");
								continue L11;
							}
						}while(true);
						
						
						case 3:
						
						L12: do{ //find leasing amount
							System.out.println("+------------------------------------------------+");
							System.out.println("|              FIND LEASING AMOUNT               |");
							System.out.println("+------------------------------------------------+");
							System.out.println();
							System.out.print("Enter the monthly lease amount you can afford  : ");
							double monthlyins=input.nextDouble();
							
							while(monthlyins<0){
								System.out.println("	monthly lease amount can't be negative");
								System.out.println();
								System.out.print("Enter the monthly lease amount you can afford  : ");
								monthlyins=input.nextDouble();
							}
							
							System.out.print("Enter number of year                           : ");
							double year=input.nextDouble();
							
							while(year>5){
								System.out.println("	Invalid number of year... Enter the correct value again...");
								System.out.println();
								System.out.print("Enter number of year                           : ");
								year=input.nextDouble();
							}
							
							System.out.print("Enter annual interest rate                     : ");
							double annuali=input.nextDouble();
							
							while(annuali<=0){
								System.out.println("	Annual interest rate can't be negative or zero");
								System.out.println();
								System.out.print("Enter annual interest rate                     : ");
								annuali=input.nextDouble();
							}
							
							double lease=FindLeasingPayment(monthlyins,year,annuali);
							System.out.println();
							System.out.println("You can get lease amount                     : "+lease);
							
							System.out.println();
							System.out.println();
							System.out.print("Do you want to calculate another Monthly Installment (Y/N)  : ");
							yn=input.next().charAt(0);
							if(yn=='Y' || yn=='y'){
								clearConsole();
								continue L12;
							}else if(yn=='N' || yn=='n'){
								clearConsole();
								break L2;
							}else{
								System.out.println("Wrong option please try again");
								continue L12;
							}
						}while(true);
						
						
						case 4:
						
						clearConsole();
						break L2;
						
						
						default:
						
						E2: do{
							System.out.println("Wrong option please try again.....");
							System.out.println();
							System.out.println();
							System.out.print("Do you want to exit (Y/N)  : ");
							yn=input.next().charAt(0);
							if(yn=='Y' || yn=='y'){
								clearConsole();
								break L2;
							}else if(yn=='N' || yn=='n'){
								clearConsole();
								break L2;
							}else{
								System.out.println("Wrong option please try again");
								continue E2;
							}
						}while(true);
					}//option3
				}while(true);
				
				
				case 6:
				
				System.out.println("Exited.....");
				return;
				
				
				default:
				
				E3: do{
					System.out.println("Wrong option please try again.....");
					System.out.println();
					System.out.println();
					System.out.print("Do you want to exit (Y/N)  : ");
					yn=input.next().charAt(0);
					if(yn=='Y' || yn=='y'){
						System.out.println("Exited.....");
						return;
					}else if(yn=='N' || yn=='n'){
						clearConsole();
						break L2;
					}else{
						System.out.println("Wrong option please try again");
						continue E3;
					}
				}while(true);
			}//option1
		}while(true);
	}//public static
}//class

