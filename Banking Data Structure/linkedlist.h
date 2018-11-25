#ifndef LINKEDLIST_H_INCLUDED
#define LINKEDLIST_H_INCLUDED
#include "node.h"

class LinkedList
{
private:
    Node *head;

public:
    LinkedList();
    void insertNode(string,string,string,string,string,string,int,int);

    ///********************* Staff Section ***********************
    void insertNodeByBalance(string,string,string,string,string,string,int,int);
    void deleteNode(int);
    void searchNodeByName(string);
    void searchNodeByAccountNumber(int);
    void searchNodeByHighestBalance(int);
    int highestBalance();
    void showList();
    void showAccountByBalance(LinkedList);

    ///********************* Customer Section *********************
    void searchCustomerLogin(int,string,string&, int&, int&);
    void showAccountInfo(int);
    void showBalance(int);
    void withdrawFromNode(int,int);
    void depositToNode(int,int);
    void trasferFromNode(int,int,int);
    friend class System;
};

#endif // LINKEDLIST_H_INCLUDED
