#ifndef NODE_H_INCLUDED
#define NODE_H_INCLUDED
#include <algorithm>
#include <iostream>
#include <istream>
#include <fstream>
#include <stdlib.h>
#include <string.h>
#include <typeinfo>

using namespace std;

class Node
{
public:
    string fullName;
    string address;
    string gender;
    string mobileNumber;
    string emailId;
    string password;
    int accountNumber;
    int balance;

    Node* next;
};


#endif // NODE_H_INCLUDED
