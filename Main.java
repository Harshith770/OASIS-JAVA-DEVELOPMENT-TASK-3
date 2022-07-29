import java.util.*;

class Main {
  String UserId;
  String userid;
  String PIN;
  String pin;
  String Name;
  float AccountBalance = 0;
  int transactions;
  String Transactionhistory = "";

  public void register() {
    Scanner in = new Scanner(System.in);
    System.out.println("\nEnter your name");
    Name = in.nextLine();
    int flag = 0;
    while (flag == 0) {
      System.out.println("Enter your userid with 12 digits");
      UserId = in.nextLine();
      if (UserId.length() != 12)
        System.out.println("Enter valid userid!!");
      else if (UserId.length() == 12)
        flag = 1;
    }
    flag = 0;
    while (flag == 0) {
      System.out.println("Enter the 4 Digit PIN:");
      PIN = in.nextLine();
      if (PIN.length() == 4)
        flag = 1;
      else
        System.out.println("Enter valid PIN!!");
    }
  }

  public void LoginBankAccount() {
    int t = 0;
    Scanner in = new Scanner(System.in);
    while (t == 0) {
      System.out.println("Enter your userid");
      userid = in.nextLine();
      if (UserId.equals(UserId)) {
        System.out.println("Enter PIN");
        pin = in.nextLine();
        if (pin.equals(PIN)) {
          System.out.println("You have successfully logined");
          t = 1;
        } else
          System.out.println("Something went wrong please enter your userid and pin correctly");
      } else
        System.out.println("Something went wrong please enter your userid and pin correctly");
    }
  }

  public void TransactionHistory() {
    System.out.println(Transactionhistory);
  }

  public void withdrawal() {
    Scanner in = new Scanner(System.in);
    System.out.println("\nEnter Amount to be withdrawn");
    float Amount = in.nextFloat();
    if (AccountBalance >= Amount) {
      AccountBalance = AccountBalance - Amount;
      System.out.println("Withdrawal Successful");
      transactions++;
      Transactionhistory = Transactionhistory + Amount + " has been debited from your account previously\n";
    } else {
      System.out.println("Insufficient Balance in your account");
      System.out.println("Account Balance is " + AccountBalance);
    }
  }

  public void deposit() {
    Scanner in = new Scanner(System.in);
    System.out.println("\nEnter the amount to be deposited");
    float Amount = in.nextFloat();
    if (Amount > 0) {
      AccountBalance = AccountBalance + Amount;
      System.out.println("Amount deposited sucessfully");
      transactions++;
      Transactionhistory = Transactionhistory + Amount + " has been credited to your account\n";
    } else
      System.out.println("Enter valid amount");
  }

  public void transfer() {
    Scanner in = new Scanner(System.in);
    System.out.println("\nEnter Receiver userid");
    String reid = in.nextLine();
    System.out.println("enter Amount to be transferred:");
    float Amount = in.nextFloat();
    if (Amount <= AccountBalance) {
      AccountBalance = AccountBalance - Amount;
      System.out.println("Amount Sucessfully transferred to userid" + reid);
      transactions++;
      Transactionhistory = Transactionhistory + Amount + " has been transferred to " + reid + "\n";
    } else
      System.out.println("Insufficient Account Balance");
  }

  public void checkbalance() {
    System.out.println("\nYour Acoount Balance is" + AccountBalance);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("*****WELCOME TO ATM******\n");
    System.out.println("enter1.Register  2.exit\n");
    int t = in.nextInt();
    if (t == 1) {
      Main bankacc = new Main();
      bankacc.register();
      System.out.println("\nEnter your details to login:");
      bankacc.LoginBankAccount();
      boolean e = false;
      while (!e) {
        System.out.println(
            "\n1.Check your balance\n2.Amount Withdrawal\n3.Amount deposit\n4.Amount Transfer\n5.Check  Transactions history\n6.Exit");
        System.out.println("Enter your choice");
        int num = in.nextInt();
        switch (num) {
          case 1:
            bankacc.checkbalance();
            break;
          case 2:
            bankacc.withdrawal();
            break;
          case 3:
            bankacc.deposit();
            break;
          case 4:
            bankacc.transfer();
            break;
          case 5:
            bankacc.TransactionHistory();
            break;
          case 6:
            e = true;
            break;
          default:
            System.out.println("\nEnter valid choice!!");
            break;
        }
      }
    }

  }
}