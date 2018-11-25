#ifndef SYSTEM_H_INCLUDED
#define SYSTEM_H_INCLUDED
#include "linkedlist.cpp"

class System
{
private:
    LinkedList bankList;
    LinkedList bankListByBalance;
    string staffs[3] = {"afif","jahin","juthi"};
    string passwords[3] = {"001","002","003"};
    int accountNumberAssigning = 10000;
public:
    System();
    //~System();

    /****************************
    Following are the menu functions
    ****************************/
        void mainMenu();
        void customerLoginMenu();
        void createNewAccountMenu();
        void staffLoginMenu();

        ///These are the customer side menus
        void customerMainWindow(string, int);
        void informationWindow(int, string);
        void balanceCheckWindow(int, string);
        void depositWindow(int, string);
        void withdrawWindow(int, string);
        void transferWindow(int, string);

        ///These are the staff side menus
        void staffMainWindow();
        void deleteAccoutWindow();
        void searchByNameWindow();
        void searchByAccountNumberWindow();
        void showAllAccountsWindow();
        void showHighestAmountAccountWindow();
        void showAccountsByBalanceWindow();
};

#endif // SYSTEM_H_INCLUDED

