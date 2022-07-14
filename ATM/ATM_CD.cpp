// C++ program for ATM using constructors

#include<iostream>
using namespace std;

class ATM{
		// member functions
		public:
			// data members
			int balance, pinCode, cardNo, wAtm, dAmt, acNo;
			
			// function to deposit amount 
			void deposit(int dAmt, int pinCode){
				if(pinCode == pinCode){
					balance = balance + dAmt;
					cout<<"\n "<<dAmt<<" is deposited in your account.";
				}
				else{
					cout<<"\n Wrong PIN";
				}
			}
		
			// function to withdraw amount
			void withdrawl(int wAmt, int pinCode){
				if(pinCode == pinCode){
					if(wAmt > balance){
						cout<<"\n Withdrawl amount exceeds balance";
					}
					else{
						balance = balance - wAmt;
						cout<<"\n "<<wAmt<<" is withdrawn from your account. Please collect the cash.";
					}
				}
				else{
					cout<<"\n Wrong PIN";
				}
			}
		
			// fucntion to check account balance
			void acBal(int pinCode){
				if(pinCode == pinCode){
					cout<<"\n Account number: "<<acNo;
					cout<<"\n Balance: "<<balance;
				}
				else{
					cout<<"\n Wrong PIN";
				}
			}
		
			// function to change pincode
			void changePin(int pinCode){
				if(pinCode == pinCode){
					cout<<"\n Enter new PIN: ";
					cin>> pinCode;
					cout<<"\n Your PIN is updated successfully";
				}
				else{
					cout<<"\n Wrong PIN";
				}		
			}
		
			// default constructor for default customer info
			ATM(){
				balance = 1000;
				pinCode = 0;
				cardNo = 0;
				acNo = 0;
			}
		
			// parameterized constructor
			ATM(int bal, int pin, int cNo, int aNo){
				balance = bal;
				pinCode = pin;
				cardNo = cNo;
				acNo = aNo;
			}
		
			// destructor
			~ATM(){
				cout<<"\n Transaction closed";
			}
	};

// main function
int main(){
	
	int bal, pin, cardNo, withAmt, depAmt, accountNo, tc;
	char con = 'y';
	
	// Object of ATM class
	ATM defcust;
	
	// Object of ATM class for two customers
	ATM Vinata(40000, 1234, 123011, 1022345);
	ATM Geeta(50000, 3456, 123022, 1188443);
	
	cout<<"Enter your card number: ";
	cin>>cardNo;
	
	if(cardNo == 123011){
		cout<<"\n Hello Vinata, welcome to CD ATM";
	}
	else if(cardNo == 123022){
		cout<<"\n Hello Geeta, welcome to CD ATM";
	}
	
	while(con == 'y'){
		cout<<"\n Options:\n 1. Deposit\n 2. Withdrwal\n 3. Balance Enquiry\n 4. Change PIN\n 5. Exit";
		cout<<"\n Enter your choice: ";
		cin>>tc;
		switch(tc){
			case 1:{
				system("cls");
				cout<<"\n Enter deposit amount: ";
				cin>>depAmt;
				cout<<"\n Enter your PIN: ";
				cin>>pin;
				if(cardNo == 123011){
					Vinata.deposit(depAmt, pin);
				}
				else{
					Geeta.deposit(depAmt, pin);
				}
				break;	
			}
			
			case 2:{
				system("cls");
				cout<<"\n Enter withdrwal amount: ";
				cin>>withAmt;
				cout<<"\n Enter your PIN: ";
				cin>>pin;
				if(cardNo == 123011){
					Vinata.withdrawl(withAmt, pin);
				}
				else{
					Geeta.withdrawl(withAmt, pin);
				}
				break;			
			}
			
			case 3:{
				system("cls");
				cout<<"\n Enter your PIN: ";
				cin>>pin;
				if(cardNo == 123011){
					Vinata.acBal(pin);
				}
				else{
					Geeta.acBal(pin);
				}
				break;				
			}
			
			case 4:{
				system("cls");
				cout<<"\n Enter your PIN: ";
				cin>>pin;
				if(cardNo == 123011){
					Vinata.changePin(pin);
				}
				else{
					Geeta.changePin(pin);
				}
				break;
			}
			
			case 5:{
				cout<<"\n Thank you for visiting";
				return 0;
				break;
			}
			
			default:{
				cout<<"\n Invalid input";
				break;
			}	
		}
		cout<<"\n Do you want to continue? (y/n): ";
		cin>>con;
		if(con == 'n'){
			cout<<"\n Thank you for visiting";
			return 0;
		}
		else if(con == 'y'){
			system("cls");
		}
	}
}
