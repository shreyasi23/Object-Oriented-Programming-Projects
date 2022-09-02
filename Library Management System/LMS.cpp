// library management system
#include<iostream>
#include <string>
#include <fstream>
#include<ctime>
#include<conio.h>
using namespace std;
// class login module
class login_module
{
		private:
			string username ,pass; 
			int attempt; //f;
		
		public:
			login_module(); // default constructor
			void login();	
};

login_module::login_module()
{
	attempt = 0;
	//f = 0;
}

void login_module::login()
{
	while(attempt<=2)
	{
		cout<<"\n\n\n\n\t\t\t\t\t\t Enter username: ";
		cin>>username;
		
		cout<<"\n\t\t\t\t\t\t Enter password: ";
		cin>>pass;
		
		if(username == "Priya" && pass == "Priya@1") //admin
		{
			cout<<"\n\t\t\t\t\t\t Welcome to library Priya!";
			break;
		}
		else if(username == "Shreya" && pass == "Shreya@2") //user 1
		{
			cout<<"\n\t\t\t\t\t\t Welcome to library Shreya!";
			break;
		}
		else if(username == "Nikita" && pass == "Nikita@13")  //user 2
		{
			cout<<"\n\t\t\t\t\t\t Welcome to library Nikita!";
			break;
		}
		else if(username == "Aashank" && pass == "Aashank@10")  //user 3
		{
			cout<<"\n\t\t\t\t\t\t Welcome to library Aashank!";
			break;
		} 
		else
		{
			cout<<"\n\t\t\t\t\t\t Incorrect username or password, please try again";
			getch();
			system("cls");
		}
		attempt++;
	}
	if(attempt > 2)
	{
		system("cls");
		cout<<"\n\n\t\t\t\t\t\t Access denied";
		exit(0);
	}
}

//class books module
class Books
{
	private:
		int copies, bno;
		char Book_name[20], Author[22];
		
	public:
		void Add_books();
		int B_no();
		//char A_name();
		void display_book_details();
		void modify();
};

void Books::Add_books()
{
	cout<<"\n\n\t\t\t\t\t\t Enter book number: ";
	cin>>bno;	
	cout<<"\n\t\t\t\t\t\t Enter name of the book: ";
	cin.ignore(1);
	cin.getline(Book_name,20);
	
	cout<<"\n\t\t\t\t\t\t Enter name of the author: ";
	cin.ignore(0);
	cin.getline(Author,22);
	
	cout<<"\n\t\t\t\t\t\t Enter the number of copies: ";
	cin>>copies;
}

int Books::B_no()
{
	return bno;
}

void Books::modify()
{
	cout<<"\n\t\t\t\t\t\t Enter new details....";
	cout<<"\n\n\t\t\t\t\t\t Enter book number: "<<bno;
	cout<<"\n\t\t\t\t\t\t Enter name of the book: ";
	cin.ignore(1);
	cin.getline(Book_name,20);
	cout<<"\n\t\t\t\t\t\t Enter name of the author: ";
	cin.ignore(0);
	cin.getline(Author,22);
	cout<<"\n\t\t\t\t\t\t Enter the number of copies: ";
	cin>>copies;
}

void Books::display_book_details()
{
	cout<<"\n\n\t\t\t\t\t\t"<<bno<<" "" "<<Book_name<<" "" "<<Author<<" "" "<<copies<<endl; 
}


fstream file;  // global declaration of file handeling class, file is the object

//Will delete file when program is being executed
//because we are create file in append mode
void delete_existing_file()
{
    remove("Books.dat");
}

//function to append record into file
void append_To_File()
{
    Books b;
     
    //Read book record from user
    b.Add_books();
     
    file.open("Books.dat",ios::binary|ios::app);
    // check exeistence of file
    if(!file)
	{
        cout<<"\n\t\t\t\t\t\t File not found!";
        return;
    }
    
    //write into file
    file.write((char*)&b,sizeof(b));
    file.close();
    cout<<"\n\t\t\t\t\t\t Book details added sucessfully";
}

// function to display book details
void display_All_book()
{
    Books b;
     
    file.open("Books.dat",ios::binary|ios::in);
    if(!file)
	{
        cout<<"\n\t\t\t\t\t\t File not found!";
        return;
    }
    while(file)
	{
    	if(file.read((char*)&b,sizeof(b)))
            	b.display_book_details();
    }
  file.close();
}

void search()		// search books
{
	int bkn;
	char ib;
	int flag = 0;
	Books b;
	cout<<"\n\n\t\t\t\t\t\t Enter book number: ";
	cin>>bkn;
	
	file.open("Books.dat",ios::binary|ios::in);
    if(!file)
	{
    	cout<<"\n\t\t\t\t\t\t File not found!";
    	return;
    }
    while(file)
	{
    	if(file.read((char*)&b,sizeof(b)))
		{
    		if(b.B_no() == bkn)
			{
				flag = 1;
				if(flag == 1)
				{
					cout<<"\n\t\t\t\t\t\t Book found!";
    				b.display_book_details();
    				break;
			    }
			    else 
				{	
					cout<<"\n\t\t\t\t\t\t Book not found!";
				}
			}
 	    }
	}
	file.close();
}
//function to modify book record
void modify_brecord()
{
	Books b;
	int booknumber, found = 0, pos;
	cout<<"\n\n\t\t\t\t\t\t Enter book number: ";
	cin>>booknumber;
	
	file.open("Books.dat", ios::in|ios::binary|ios::out);
	if(!file)
	{
        cout<<"\n\t\t\t\t\t\t File not found!";
        return;
    }
	while(file)
	{
		pos = file.tellg();  //storing the position of current file pointer i.e. at the end of 
		//previously read file
		file.read((char*)&b, sizeof(b));
		if(file)
		{
			if(b.B_no() == booknumber)
			{
				found = 1;
				b.display_book_details();
				//setting new data of new record
				b.modify();
				//place the writing pointer at the starting of the record
				file.seekp(pos);
				//write the new record in the file
				file.write((char*)&b, sizeof(b));
				break;
			}
		}
	}
	file.close();
	if(found == 1)
	{
		cout<<"\n\n\t\t\t\t\t\t Record successfully modified";
	}
	else
	{
		cout<<"\n\n\t\t\t\t\t\t Record not found";
	}
	getch();
}
//main function
int main()
{
	//delete_existing_file(); 			//function to delete existing files
	int choice, ch1;
	char k = 'y', g = 'y', u_choice;
	login_module L1;
	while(1)
	{
		cout<<"\n\t\t\t\t\t ====== Library Management System ======";
    	cout<<"\n\n\t\t\t\t\t\t Login: \n\t\t\t\t\t\t 1. Admin \n\t\t\t\t\t\t 2. User";
    	cout<<"\n\t\t\t\t\t Enter 1 for Admin login and 2 for User login: ";
    	cin>> choice;
    
    	switch(choice)
    	{
    		case 1:
    			{
    				system("cls");
    				L1.login();
    				getch();
    				system("cls");
    				while(k == 'y')
    				{
    					cout<<"\n\n\n\n\t\t\t\t\t\t Options:";
    					cout<<"\n\n\t\t\t\t\t\t 1. Add Book \n\t\t\t\t\t\t 2. Show All Books \n\t\t\t\t\t\t 3. Modify Book Record \n\t\t\t\t\t\t 4. Search Book";
    					cout<<"\n\t\t\t\t\t\t Enter choice: ";
    					cin>>ch1;
    			
    					switch(ch1)
    					{
    						case 1:
    							{
    								system("cls");
    								cout<<"\n\t\t\t\t\t\t ==== Add Book ====";
    								append_To_File();
    								break;
								}
					
							case 2:
								{
									system("cls");
									cout<<"\n\t\t\t\t\t\t ==== Books in Library ====";
									display_All_book();
									break;
								}
					
							case 3:
								{
									system("cls");
									cout<<"\n\t\t\t\t\t\t ==== Modify Book Record ====";
									modify_brecord();
									break;
								}
							
							case 4:
								{
									system("cls");
									cout<<"\n\t\t\t\t\t\t ==== Search Book ====";
									search();
									break;
								}
						
							default:
								{
									cout<<"\n\t\t\t\t\t\t Invalid Input!";
									getch();
									system("cls");
									break;
								}
						}
						cout<<"\n\t\t\t\t\t\t Do you want to continue? (y/n): ";
			    		cin>>k;
			    		if(k != 'y')
			    		{
			    			cout<<"\n\n\t\t\t\t\t\t You have logged out \n\t\t\t\t\t\tThank you!";
			    			return 0;
						}	
			    	}	
				    break;
	    		}
	    	
			case 2:
				{
					system("cls");
					L1.login();
					getch();
					system("cls");
					cout<<"\n\t\t\t\t\t\t ==== Search book ====";
					search();
					cout<<"\n\t\t\t\t\t\t Do you want to issue this book?(y/n): ";
					cin>>u_choice;
					if(u_choice == 'y')
					{
						time_t now = time(0);
						struct tm *ltm = localtime(&now);
						cout<<"\n\t\t\t\t\t\t Book issued on "<<ltm->tm_mday<<"/"<<1 + ltm->tm_mon<<"/"<<1900 + ltm->tm_year;
						cout<<"\n\n\t\t\t** Please return it after 15 days, otherwise fine of Rs.5 per day will be charged";
					}
					break;
				}
		
			default:
				{
					cout<<"\n\t\t\t\t\t\t Invalid Input!";
					getch();
					system("cls");
					break;	
				}	
		}
		cout<<"\n\t\t\t\t\t\t Do you want to continue? (y/n): ";
		cin>>g;
		if(g != 'y')
		{
			cout<<"\n\n\t\t\t\t\t\t You have logged out \n\t\t\t\t\t\tThank you!";
			return 0;
		}				
	}
}
