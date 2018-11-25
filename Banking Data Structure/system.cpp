#include "system.h"

System::System()
{
    ifstream bankFile("Bank File.txt");
    ifstream accountFile("Account File.txt");

    int accNum, balance, x;
    string name, address, gender, mobile, email, pass;

    if( bankFile.is_open() )
    {
        while(bankFile >> accNum >> name >> address >> gender >> mobile >> email >> pass >> balance)
        {
            bankList.insertNode(name, address, gender, mobile, email, pass, accNum, balance);
        }

        bankFile.close();
    }

    if( accountFile.is_open() )
    {
        while(accountFile >> x)
        {
            accountNumberAssigning = x;
        }

        accountFile.close();
    }
}

void System::mainMenu()
{
    system("cls");

    char x;
    string y;
    fflush(stdin);

    cout<<" Welcome To EASY BANK"<<endl;
    cout<<" --------------------"<<endl<<endl;
    cout<<" 1. Staff Login"<<endl;
    cout<<" 2. Customer Login"<<endl;
    cout<<" 3. Open New Bank Accout"<<endl;

    cout<<" Enter Your Option: ";
    cin>>x;

    switch(x)
    {
    case '1':
        staffLoginMenu();
        break;
    case '2':
        customerLoginMenu();
        break;
    case '3':
        createNewAccountMenu();
        break;
    default:
        cout<<"Invalid Option!"<<endl;
        cout<<"Press any key and hit enter...";
        cin>>y;
        mainMenu();
    }
}

///**************************** New Account Section **********************************************
///***********************************************************************************************

void System::createNewAccountMenu()
{
    system("cls");
    fflush(stdin);

    string name, address, gender, mobile, email, pass;
    string y;
    int balance = 0;

    accountNumberAssigning++;

    int number = accountNumberAssigning;

    cout<<" Account Opening Window"<<endl;
    cout<<" ----------------------"<<endl<<endl;
    cout<<" Enter First Name: ";
    cin>>name;
    fflush(stdin);

    cout<<" Enter City: ";
    cin>>address;
    fflush(stdin);

    cout<<" Enter gender: ";
    cin>>gender;
    fflush(stdin);

    cout<<" Enter mobile Number: ";
    cin>>mobile;
    fflush(stdin);

    cout<<" Enter Email ID: ";
    cin>>email;
    fflush(stdin);

    cout<<" Enter Password: ";
    cin>>pass;
    fflush(stdin);

    bankList.insertNode(name,address,gender,mobile,email, pass, number, balance);

    ofstream bankFile;

    bankFile.open("Bank File.txt", std::ios_base::app);

    ofstream accountFile("Account File.txt");

    accountFile << number;

    accountFile.close();

    int i = 0;

    while(i<1)
    {
        bankFile << number << ' ' << name << ' ' << address << ' ' << gender << ' ' << mobile << ' ' << email << ' ' << pass << ' ' << balance << endl;

        i++;
    }


    bankFile.close();


    cout<<" Your account has been created."<<endl<<endl;

    cout<<"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"<<endl;
    cout<<" Your **Account Number** is: " << number << endl;
    cout<<"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"<<endl<<endl;


    cout<<" Please, remember your Account Number in order to login." << endl;

    cout<<" Press any key and hit enter...";
    cin>>y;

    mainMenu();
}


///***************************** Staff Section ***************************************************
///***********************************************************************************************

void System::staffLoginMenu()
{
    system("cls");

    string name, pass, x;
    fflush(stdin);

    cout<<" Staff Login Window"<<endl;
    cout<<" ------------------"<<endl<<endl;
    cout<<" Enter Username: ";
    cin>>name;
    transform(name.begin(), name.end(), name.begin(), ::toupper);
    cout<<" Enter Password: ";
    cin>>pass;

    string staffNames[3] = staffs;
    string staffpasses[3] = passwords;
    string staffname;
    string staffpass;

    int i = 0;
    int found = 0;


    while(i<3)
    {
        staffname = staffNames[i];
        staffpass = staffpasses[i];
        transform(staffname.begin(), staffname.end(), staffname.begin(), ::toupper);
        if(staffname == name && staffpass == pass)
        {
            found++;
            staffMainWindow();
        }

        i++;
    }

    if(found==0)
    {
        cout<<" Invalid Username or Password"<<endl;
        cout<<" Press any key and hit enter...";
        cin>>x;
        mainMenu();
    }

}

void System::staffMainWindow()
{
    system("cls");

    //cout<<"Staff site"<<endl;

    char x;
    string y;
    fflush(stdin);

    cout<<" Staff Window"<<endl;
    cout<<" ------------"<<endl<<endl;

    cout<<" 1. Show all accounts"<<endl;
    cout<<" 2. Show accounts according to balance"<<endl;
    cout<<" 3. Search account by customer name"<<endl;
    cout<<" 4. Search account by customer account number"<<endl;
    cout<<" 5. Show account with highest balance"<<endl;
    cout<<" 6. Delete account"<<endl;
    cout<<" 7. Log Out"<<endl;
    cout<<" Choose Your Option: ";
    cin>>x;


    switch(x)
    {
    case '1':
        showAllAccountsWindow();
        break;
    case '2':
        showAccountsByBalanceWindow();
        break;
    case '3':
        searchByNameWindow();
        break;
    case '4':
        searchByAccountNumberWindow();
        break;
    case '5':
        showHighestAmountAccountWindow();
        break;
    case '6':
        deleteAccoutWindow();
        break;
    case '7':
        mainMenu();
        break;
    default:
        fflush(stdin);
        cout<<" Invalid Option!"<<endl;
        cout<<" Press any key and hit enter...";
        cin>>y;
        staffMainWindow();
        break;
    }

}

void System::showAllAccountsWindow()
{
    system("cls");
    bankList.showList();
    fflush(stdin);

    string y;

    cout<<"--------------End of List----------------"<<endl;
    cout<<"Press any key and hit enter...";
    cin>>y;
    staffMainWindow();
}

void System::searchByNameWindow()
{
    system("cls");
    fflush(stdin);

    string name, y;

    cout<<" Enter the customer name: ";
    cin>>name;

    bankList.searchNodeByName(name);


    cout<<" --------------End of List----------------"<<endl;
    cout<<" Press any key and hit enter...";
    cin>>y;
    staffMainWindow();
}

void System::searchByAccountNumberWindow()
{
    system("cls");
    fflush(stdin);

    string y;
    int number;

    cout<<" Enter the customer account number: ";
    cin>>number;

    bankList.searchNodeByAccountNumber(number);


    cout<<" --------------End of List----------------"<<endl;
    cout<<" Press any key and hit enter...";
    cin>>y;
    staffMainWindow();
}

void System::showAccountsByBalanceWindow()
{
    system("cls");
    fflush(stdin);

    string y;

    bankList.showAccountByBalance(bankListByBalance);

    cout<<" --------------End of List----------------"<<endl;
    cout<<" Press any key and hit enter...";
    cin>>y;
    staffMainWindow();
}

void System::deleteAccoutWindow()
{
    system("cls");
    fflush(stdin);

    int num;
    string y;

    cout<<" Enter customer account number: ";
    cin>>num;

    bankList.deleteNode(num);

    cout<<" --------------End of Task----------------"<<endl;
    cout<<" Press any key and hit enter...";
    cin>>y;
    staffMainWindow();
}

void System::showHighestAmountAccountWindow()
{
    system("cls");
    fflush(stdin);

    string y;
    int highest = bankList.highestBalance();

    bankList.searchNodeByHighestBalance(highest);


    cout<<" --------------End of Task----------------"<<endl;
    cout<<" Press any key and hit enter...";
    cin>>y;
    staffMainWindow();
}


///***************************** Customer Section ***************************************************
///***********************************************************************************************

void System::customerLoginMenu()
{
    system("cls");
    fflush(stdin);

    int number;
    string pass;
    string name;
    int found, numberOut;
    string x,y;

    cout<<" Customer Login Window"<<endl;
    cout<<" ---------------------"<<endl<<endl;
    cout<<" Enter account number: ";
    cin>>number;
    fflush(stdin);

    cout<<" Enter password: ";
    cin>>pass;

    bankList.searchCustomerLogin(number, pass, name, numberOut, found);

    if(found==1)
    {
        customerMainWindow(name,numberOut);
    }
    else
    {
        cout<<" Press any key and hit enter...";
        cin>>y;
        mainMenu();
    }
}

void System::customerMainWindow(string name, int accNum)
{
    system("cls");
    fflush(stdin);

    char x;
    string y;

    cout<<" Welcome, "<<name<<" to Easy Bank"<<endl;

    cout<<" 1. Show account information"<<endl;
    cout<<" 2. Show balance"<<endl;
    cout<<" 3. Deposit money"<<endl;
    cout<<" 4. Withdraw money"<<endl;
    cout<<" 5. Transfer money"<<endl;
    cout<<" 6. Log Out"<<endl;
    cout<<" Choose Your Option: ";
    cin>>x;

    switch(x)
    {
    case '1':
        informationWindow(accNum, name);
        break;
    case '2':
        balanceCheckWindow(accNum, name);
        break;
    case '3':
        depositWindow(accNum, name);
        break;
    case '4':
        withdrawWindow(accNum, name);
        break;
    case '5':
        transferWindow(accNum, name);
        break;
    case '6':
        mainMenu();
        break;
    default:
        fflush(stdin);
        cout<< "Invalid Option!"<<endl;
        cout<< "Press any key and hit enter...";
        cin>>y;
        customerMainWindow(name, accNum);
        break;
    }
}

void System::informationWindow(int number, string name)
{
    system("cls");
    fflush(stdin);

    string y;

    bankList.showAccountInfo(number);

    cout<<" --------------End of Task----------------"<<endl;
    cout<<" Press any key and hit enter...";
    cin>>y;
    customerMainWindow(name, number);
}

void System::balanceCheckWindow(int number, string name)
{
    system("cls");
    fflush(stdin);

    string y;

    bankList.showBalance(number);

    cout<<" --------------End of Task----------------"<<endl;
    cout<<" Press any key and hit enter...";
    cin>>y;
    customerMainWindow(name, number);
}

void System::depositWindow(int number, string name)
{
    system("cls");
    fflush(stdin);

    int amount;
    string y;

    cout<<" Deposit Window"<<endl;
    cout<<" --------------"<<endl<<endl;
    cout<<" Enter amount: ";
    cin>>amount;

    bankList.depositToNode(number,amount);

    fflush(stdin);


    cout<<" --------------End of Task----------------"<<endl;
    cout<<" Press any key and hit enter...";
    cin>>y;
    customerMainWindow(name, number);
}

void System::withdrawWindow(int number, string name)
{
    system("cls");
    fflush(stdin);

    int amount;
    string y;

    cout<<" Withdraw Window"<<endl;
    cout<<" ---------------"<<endl<<endl;
    cout<<" Enter amount: ";
    cin>>amount;

    bankList.withdrawFromNode(number,amount);

    fflush(stdin);

    cout<<" --------------End of Task----------------"<<endl;
    cout<<" Press any key and hit enter...";
    cin>>y;
    customerMainWindow(name, number);
}

void System::transferWindow(int number, string name)
{
    system("cls");
    fflush(stdin);

    int amount;
    int accTo;
    string y;

    cout<<" Transfer Window"<<endl;
    cout<<" --------------------"<<endl<<endl;
    cout<<" Enter account number to transfer: ";
    cin>>accTo;
    fflush(stdin);
    cout<<" Enter amount: ";
    cin>>amount;

    bankList.trasferFromNode(number,accTo,amount);

    fflush(stdin);

    cout<<" --------------End of Task----------------"<<endl;
    cout<<" Press any key and hit enter...";
    cin>>y;
    customerMainWindow(name, number);
}


