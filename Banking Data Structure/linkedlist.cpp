#include "linkedlist.h"

LinkedList::LinkedList()
{
    head = NULL;
}


void LinkedList::insertNode(string name, string address, string gender, string mobile, string email,string pass, int accountNumberParameter, int balance)
{
    Node* newNode;
    Node* nodePtr;
    Node* postNode;
    newNode = new Node();
    transform(name.begin(), name.end(), name.begin(), ::toupper);
    newNode->fullName = name;
    newNode->address = address;
    newNode->gender = gender;
    newNode->mobileNumber = mobile;
    newNode->emailId = email;
    newNode->accountNumber = accountNumberParameter;
    newNode->password = pass;
    newNode->balance = balance;
    newNode->next = NULL;

    nodePtr=head;
    postNode=nodePtr;

    if(head==NULL)
    {
        head = newNode;
    }
    else
    {
        while(nodePtr!=NULL)
        {
            postNode=nodePtr->next;

            if(nodePtr->accountNumber>accountNumberParameter)
            {
                head=newNode;
                newNode->next=nodePtr;
                break;
            }
            else if(postNode==NULL)
            {
                nodePtr->next=newNode;
                break;
            }
            else if( (nodePtr->accountNumber<accountNumberParameter) && (postNode->accountNumber>accountNumberParameter) )
            {
                nodePtr->next = newNode;
                newNode->next = postNode;
                break;
            }

            nodePtr = nodePtr->next;
        }
    }
}

///****************************************************************************************************
///************************************ Staff Section *************************************************


///------------------------------------------------------------------------------------------------------------------------
///------------------------------------------------------------------------------------------------------------------------

void LinkedList::insertNodeByBalance(string name, string address, string gender, string mobile, string email,string pass, int accountNumberParameter, int balanceOut)
{
    Node* newNode;
    Node* nodePtr;
    Node* postNode;
    newNode = new Node();
    transform(name.begin(), name.end(), name.begin(), ::toupper);
    newNode->fullName = name;
    newNode->address = address;
    newNode->gender = gender;
    newNode->mobileNumber = mobile;
    newNode->emailId = email;
    newNode->accountNumber = accountNumberParameter;
    newNode->password = pass;
    newNode->balance = balanceOut;
    newNode->next = NULL;

    nodePtr=head;
    postNode=nodePtr;

    if(head==NULL)
    {
        head = newNode;
    }
    else
    {
        while(nodePtr!=NULL)
        {
            postNode=nodePtr->next;


            if(nodePtr->balance>balanceOut)
            {
                head=newNode;
                newNode->next=nodePtr;
                break;
            }
            else if(nodePtr->balance == balanceOut)
            {
                nodePtr->next = newNode;
                newNode->next = postNode;
                break;
            }
            else if(postNode==NULL)
            {
                nodePtr->next=newNode;
                break;
            }
            else if( (nodePtr->balance<balanceOut) && (postNode->balance>balanceOut) )
            {
                nodePtr->next = newNode;
                newNode->next = postNode;
                break;
            }

            nodePtr = nodePtr->next;
        }
    }
}

///------------------------------------------------------------------------------------------------------------------------
///------------------------------------------------------------------------------------------------------------------------


void LinkedList::deleteNode(int accountNumberParameter)
{
    Node* nodePtr;
    Node* prevNode;

    int found = 0;

    nodePtr=head;

    if(head!=NULL)
    {
        while(nodePtr!=NULL)
        {
            if(nodePtr->accountNumber==accountNumberParameter)
            {
                found++;
                break;
            }
            prevNode = nodePtr;
            nodePtr = nodePtr->next;
        }

        if(nodePtr!=NULL)
        {
            if(head->accountNumber == accountNumberParameter)
            {
                head = head->next;
            }
            else
            {
                nodePtr = nodePtr->next;
                prevNode->next = nodePtr;
            }
        }

        if(found == 0)
        {
            cout<< " " << accountNumberParameter<<" is not found!"<<endl;
        }
        else
        {
            ofstream bankFile("Bank File.txt");

            int accNum, balance;
            string name, address, gender, mobile, email, pass;

            Node* nodePtr;

            nodePtr = head;

            while(nodePtr!=NULL)
            {
                accNum = nodePtr->accountNumber;
                name = nodePtr->fullName;
                address = nodePtr->address;
                gender = nodePtr->gender;
                mobile = nodePtr->mobileNumber;
                email = nodePtr->emailId;
                pass = nodePtr->password;
                balance = nodePtr->balance;

                bankFile << accNum << ' ' << name << ' ' << address << ' ' << gender << ' ' << mobile << ' ' << email << ' ' << pass << ' ' << balance << endl;

                nodePtr = nodePtr->next;
            }

            bankFile.close();

            cout<< " " <<accountNumberParameter<<" is deleted!"<<endl;
        }
    }
    else
        cout<<" No account is present."<<endl;
}

void LinkedList::searchNodeByName(string name)
{
    cout<<" ********* Search By Name **********"<<endl;
    cout<<endl;

    Node* nodePtr;
    int counter = 0;
    string accountName;

    nodePtr = head;

    int found = 0;

    transform(name.begin(), name.end(), name.begin(), ::toupper);

    while(nodePtr!=NULL)
    {
        accountName = nodePtr->fullName;

        transform(accountName.begin(), accountName.end(), accountName.begin(), ::toupper);

        if(accountName == name)
        {
            counter++;
            cout<<" ******** Account- "<<counter<<" ***********"<<endl;
            cout<<" Account Number: "<<nodePtr->accountNumber<<endl;
            cout<<" Name: "<<nodePtr->fullName<<endl;
            cout<<" Address: "<<nodePtr->address<<endl;
            cout<<" Gender: "<<nodePtr->gender<<endl;
            cout<<" Mobile: "<<nodePtr->mobileNumber<<endl;
            cout<<" Email: "<<nodePtr->emailId<<endl;
            cout<<" Balance: Tk."<<nodePtr->balance<<endl;
            cout<<endl;
            found++;
        }

        nodePtr = nodePtr->next;
    }

    if(found == 0)
    {
        cout<<" No such account is found."<<endl;
    }
}


void LinkedList::searchNodeByAccountNumber(int number)
{
    cout<< "********* Search By Account Number **********"<<endl;

    Node* nodePtr;

    nodePtr = head;

    int found = 0;

    while(nodePtr!=NULL)
    {
        if(nodePtr->accountNumber == number)
        {
            cout<<" Account Number: "<<nodePtr->accountNumber<<endl;
            cout<<" Name: "<<nodePtr->fullName<<endl;
            cout<<" Address: "<<nodePtr->address<<endl;
            cout<<" Gender: "<<nodePtr->gender<<endl;
            cout<<" Mobile: "<<nodePtr->mobileNumber<<endl;
            cout<<" Email: "<<nodePtr->emailId<<endl;
            cout<<" Balance: Tk."<<nodePtr->balance<<endl;
            cout<<endl;
            found++;
        }

        nodePtr = nodePtr->next;
    }

    if(found == 0)
    {
        cout<<" No such account is found."<<endl;
    }
}

void LinkedList::searchNodeByHighestBalance(int balanceOut)
{
    cout<<" ********* Search By Highest Balance **********"<<endl;

    Node* nodePtr;
    int counter = 0;

    nodePtr = head;

    int found = 0;

    while(nodePtr!=NULL)
    {
        if(nodePtr->balance == balanceOut)
        {
            counter++;
            cout<<" ******** Account- "<<counter<<" ***********"<<endl;
            cout<<" Account Number: "<<nodePtr->accountNumber<<endl;
            cout<<" Name: "<<nodePtr->fullName<<endl;
            cout<<" Address: "<<nodePtr->address<<endl;
            cout<<" Gender: "<<nodePtr->gender<<endl;
            cout<<" Mobile: "<<nodePtr->mobileNumber<<endl;
            cout<<" Email: "<<nodePtr->emailId<<endl;
            cout<<" Balance: Tk."<<nodePtr->balance<<endl;
            cout<<endl;
            found++;
        }

        nodePtr = nodePtr->next;
    }

    if(found == 0)
    {
        cout<<" No such account is found."<<endl;
    }
}

int LinkedList::highestBalance()
{
    Node* nodePtr;
    int highest=0;

    nodePtr = head;

    while(nodePtr!=NULL)
    {
        if(highest<nodePtr->balance)
            highest = nodePtr->balance;
        nodePtr = nodePtr->next;
    }

    return highest;
}

void LinkedList::showList()
{
    Node* nodePtr;
    int counter = 0;

    nodePtr = head;

    while(nodePtr!=NULL)
    {
        counter++;
        cout<<" ******** Account- "<<counter<<" ***********"<<endl;
        cout<<" Account Number: "<<nodePtr->accountNumber<<endl;
        cout<<" Name: "<<nodePtr->fullName<<endl;
        cout<<" Address: "<<nodePtr->address<<endl;
        cout<<" Gender: "<<nodePtr->gender<<endl;
        cout<<" Mobile: "<<nodePtr->mobileNumber<<endl;
        cout<<" Email: "<<nodePtr->emailId<<endl;
        cout<<" Balance: Tk."<<nodePtr->balance<<endl;
        cout<<endl;

        nodePtr = nodePtr->next;
    }
}

void LinkedList::showAccountByBalance(LinkedList a)
{
    Node* nodePtr;

    nodePtr = head;

    a.head == NULL;

    while(nodePtr!=NULL)
    {
        a.insertNodeByBalance(nodePtr->fullName, nodePtr->address, nodePtr->gender, nodePtr->mobileNumber, nodePtr->emailId, nodePtr->password, nodePtr->accountNumber, nodePtr->balance);

        nodePtr = nodePtr->next;
    }

    a.showList();
}



///****************************************************************************************************
///************************************ Customer Section **********************************************

void LinkedList::searchCustomerLogin(int number, string pass, string& name, int& numberOut, int& found)
{
    Node* nodePtr;

    nodePtr = head;

    found = 0;

    while(nodePtr!=NULL)
    {
        if(nodePtr->accountNumber == number && nodePtr->password == pass)
        {
            name = nodePtr->fullName;
            numberOut = nodePtr->accountNumber;
            found++;
            break;
        }

        nodePtr = nodePtr->next;
    }

    if(found == 0)
    {
        name = "Null";
        numberOut = 0;
        cout<<" No such account is found."<<endl;
    }
}

void LinkedList::showAccountInfo(int number)
{
    Node* nodePtr;

    nodePtr = head;

    int found = 0;

    while(nodePtr!=NULL)
    {
        if(nodePtr->accountNumber == number)
        {
            cout<<" Account Number: "<<nodePtr->accountNumber<<endl;
            cout<<" Name: "<<nodePtr->fullName<<endl;
            cout<<" Address: "<<nodePtr->address<<endl;
            cout<<" Gender: "<<nodePtr->gender<<endl;
            cout<<" Mobile: "<<nodePtr->mobileNumber<<endl;
            cout<<" Email: "<<nodePtr->emailId<<endl;
            cout<<endl;
            found++;
        }

        nodePtr = nodePtr->next;
    }

    if(found == 0)
    {
        cout<<" No such account is found."<<endl;
    }
}

void LinkedList::showBalance(int number)
{
    Node* nodePtr;

    nodePtr = head;

    int found = 0;

    while(nodePtr!=NULL)
    {
        if(nodePtr->accountNumber == number)
        {
            cout<<" Account Number: "<<nodePtr->accountNumber<<endl;
            cout<<" Name: "<<nodePtr->fullName<<endl;
            cout<<" Balance: Tk."<<nodePtr->balance<<endl;
            cout<<endl;
            found++;
        }

        nodePtr = nodePtr->next;
    }

    if(found == 0)
    {
        cout<<" No such account is found."<<endl;
    }
}


void LinkedList::withdrawFromNode(int number, int amount)
{
    Node* nodePtr;

    nodePtr = head;

    while(nodePtr!=NULL)
    {
        if(nodePtr->accountNumber == number)
        {
            if(amount>=0)
            {
                if(nodePtr->balance >= amount)
                {
                    nodePtr->balance = nodePtr->balance - amount;
                    cout<<" Amount Withdrawn!"<<endl;

                    ofstream bankFile("Bank File.txt");

                    int accNum, balance;
                    string name, address, gender, mobile, email, pass;

                    Node* nodePtr;

                    nodePtr = head;

                    while(nodePtr!=NULL)
                    {
                        accNum = nodePtr->accountNumber;
                        name = nodePtr->fullName;
                        address = nodePtr->address;
                        gender = nodePtr->gender;
                        mobile = nodePtr->mobileNumber;
                        email = nodePtr->emailId;
                        pass = nodePtr->password;
                        balance = nodePtr->balance;

                        bankFile << accNum << ' ' << name << ' ' << address << ' ' << gender << ' ' << mobile << ' ' << email << ' ' << pass << ' ' << balance << endl;

                        nodePtr = nodePtr->next;
                    }

                    bankFile.close();

                }
                else
                {
                    cout<<" Sufficient amount not available!"<<endl;
                }
            }
            else
            {
                cout<<" Wrong Input!"<<endl;
            }
        }

        nodePtr = nodePtr->next;
    }
}

void LinkedList::depositToNode(int number, int amount)
{
    Node* nodePtr;

    nodePtr = head;

    while(nodePtr!=NULL)
    {
        if(nodePtr->accountNumber == number)
        {
            if(amount>=0)
            {
                nodePtr->balance = nodePtr->balance + amount;
                cout<<" Amount Deposited!"<<endl;

                ofstream bankFile("Bank File.txt");

                int accNum, balance;
                string name, address, gender, mobile, email, pass;

                Node* nodePtr;

                nodePtr = head;

                while(nodePtr!=NULL)
                {
                    accNum = nodePtr->accountNumber;
                    name = nodePtr->fullName;
                    address = nodePtr->address;
                    gender = nodePtr->gender;
                    mobile = nodePtr->mobileNumber;
                    email = nodePtr->emailId;
                    pass = nodePtr->password;
                    balance = nodePtr->balance;

                    bankFile << accNum << ' ' << name << ' ' << address << ' ' << gender << ' ' << mobile << ' ' << email << ' ' << pass << ' ' << balance << endl;

                    nodePtr = nodePtr->next;
                }

                bankFile.close();

            }
            else
            {
                cout<<" Wrong Input!"<<endl;
            }
        }

        nodePtr = nodePtr->next;
    }
}

void LinkedList::trasferFromNode(int numberFrom, int numberTo, int amount)
{
    Node* nodePtr;

    int found = 0;
    int notSufficient = 1;

    nodePtr = head;

    while(nodePtr!=NULL)
    {
        if(nodePtr->accountNumber == numberTo)
        {
            found++;
        }

        nodePtr = nodePtr->next;
    }

    if(found == 0)
    {
        cout<<" Invalid Account Number."<<endl;
    }
    else
    {
        nodePtr = head;

        while(nodePtr!=NULL)
        {
            if(nodePtr->accountNumber == numberFrom)
            {
                if(amount>=0){
                    if(nodePtr->balance>=amount)
                    {
                        nodePtr->balance = nodePtr->balance - amount;
                    }
                    else
                    {
                        notSufficient = 0;
                        cout<<" Sufficient amount not available!"<<endl;
                    }
                }
                else
                {
                    notSufficient = 0;
                    cout<<" Wrong Input"<<endl;
                }
            }

            nodePtr = nodePtr->next;
        }

        if(notSufficient==1)
        {
            nodePtr = head;

            while(nodePtr!=NULL)
            {
                if(nodePtr->accountNumber == numberTo)
                {
                    nodePtr->balance = nodePtr->balance + amount;
                    cout<<" Amount transferred!"<<endl;

                    ofstream bankFile("Bank File.txt");

                    int accNum, balance;
                    string name, address, gender, mobile, email, pass;

                    Node* nodePtr;

                    nodePtr = head;

                    while(nodePtr!=NULL)
                    {
                        accNum = nodePtr->accountNumber;
                        name = nodePtr->fullName;
                        address = nodePtr->address;
                        gender = nodePtr->gender;
                        mobile = nodePtr->mobileNumber;
                        email = nodePtr->emailId;
                        pass = nodePtr->password;
                        balance = nodePtr->balance;

                        bankFile << accNum << ' ' << name << ' ' << address << ' ' << gender << ' ' << mobile << ' ' << email << ' ' << pass << ' ' << balance << endl;

                        nodePtr = nodePtr->next;
                    }

                    bankFile.close();

                }

                nodePtr = nodePtr->next;
            }
        }
    }
}

