package lab3.tests;



import static org.junit.Assert.*;



import org.junit.Test;



import lab3.Bank.Account;





public class AccountTest {



@Test

public void testGetCurrency() {

Account myBankAccount = new Account(100.0, "SEK");

assertEquals("SEK", myBankAccount.getCurrency());



myBankAccount = new Account(20.0, "USD");

assertEquals("USD", myBankAccount.getCurrency());



myBankAccount = new Account(20.0, "EUR");

assertEquals("EUR", myBankAccount.getCurrency());

}



@Test

public void testSetCurrency() {

Account myBankAccount = new Account();



myBankAccount.setCurrency("EUR");

assertEquals("EUR", myBankAccount.getCurrency());



myBankAccount.setCurrency("USD");

assertEquals("USD", myBankAccount.getCurrency());

}



@Test

public void testSetBallance() {



/*

* Since the balance and the currency are private methods, we cannot

* test get and set in isolation, therefore we just copy-paste the test

* cases. *

*/



Account myBankAccount = new Account();



myBankAccount.setBalance(27.0);

assertEquals("The value of the account shall be 27", 27.0, myBankAccount.getBalance(), 0);



myBankAccount.setBalance(100.57);

assertEquals("The value of the account shall be 100.57", 100.57, myBankAccount.getBalance(), 0);



myBankAccount.setBalance(-10.0);

assertEquals("When negative value for the balance has been provided" + "the balance shall be set to 0.", 0,

myBankAccount.getBalance(), 0);

}



@Test

public void testGetBallance() {



/*

* Since the balance and the currency are private methods, we cannot

* test get and set in isolation, therefore we just copy-paste the test

* cases. *

*/

Account myBankAccount = new Account();



myBankAccount.setBalance(27.0);

assertEquals("The value of the account shall be 27", 27.0, myBankAccount.getBalance(), 0);



myBankAccount.setBalance(100.57);

assertEquals("The value of the account shall be 100.57", 100.57, myBankAccount.getBalance(), 0);

}



@Test

//Short description : in this test case we are checking the default values of variables balance and currency

// Explanation : We checked if the default currency is SEK and if the balance equals to 0.0

public void testAccount() {

Account myBankAccount = new Account();

assertEquals("SEK", myBankAccount.getCurrency());

assertEquals(Double.valueOf(0.0), myBankAccount.getBalance());

System.out.println(" Balance: " + myBankAccount.getBalance());

/* in the case of the constructor, trivial test cases are enough! */



}



//Short description : in this test case we are checking new values of variables balance and currency

//Explanation : We checked if the new currency is USD and if the new balance equals to 67.0
public void testAccount2() {

Account myBankAccount = new Account(67.0,"USD");

assertEquals("USD", myBankAccount.getCurrency());

assertEquals(Double.valueOf(67.0), myBankAccount.getBalance());

System.out.println(" Balance: " + myBankAccount.getBalance());

/* in the case of the constructor, trivial test cases are enough! */

}



@Test

//Short description : in this test case we are checking the new balance after withdrawing
//Explanation : we checked if the balance is 200SEK

public void testWithdraw() { 

Account myBankAccount = new Account(300.0,"SEK");

myBankAccount.withdraw(100.0);

assertEquals("testWithdraw", myBankAccount.getBalance(), Double.valueOf(200.0));

System.out.println(" Balance after withdraw money: " + myBankAccount.getBalance());

}



@Test

//Short description : in this test case we are checking the new balance after withdrawing

//Explanation : we set the balance to 300.0 and requested amount to 400.0 and found a bug that the new balance is in minus

public void testWithdraw2() { 

Account myBankAccount = new Account(300.0,"SEK");

myBankAccount.withdraw(400.0);

assertEquals("testWithdraw", myBankAccount.getBalance(), Double.valueOf(300.0));

System.out.println(" Balance after withdraw money: " + myBankAccount.getBalance());

}


//Short description : in this test case we are checking the new balance after withdrawing

//Explanation : we set the balance to 300.0 and requested amount to -400.0 and found a bug that the new balance is in plus 
public void testWithdraw3() { 

Account myBankAccount = new Account(300.0,"SEK");

myBankAccount.withdraw(-400.0);

assertEquals("testWithdraw", myBankAccount.getBalance(), Double.valueOf(300.0));

System.out.println(" Balance after withdraw money: " + myBankAccount.getBalance());

}



@Test

//Short description : in this test case we are checking the new balance after deposit

//Explanation : We set the amount to 100.123456789 and found bug in a system when the amount has more then two decimals. It should be rounded to two decimals. 

public void testDeposit() {

Account myBankAccount = new Account();

double balance = 100.123456789;

myBankAccount.deposit(balance);

assertEquals("testDeposit", myBankAccount.getBalance(),Double.valueOf(balance));

System.out.println(" Balance after deposit money: " + myBankAccount.getBalance());

}



@Test

//Short description : in this test case we are checking the new balance after deposit

//Explanation : We set the balance to minus and found bug in a system 

public void testDeposit2() {

Account myBankAccount = new Account();

myBankAccount.deposit(-5432.0);

assertEquals("testDeposit", myBankAccount.getBalance(), Double.valueOf(0.0));

System.out.println(" Balance after deposit money: " + myBankAccount.getBalance());

}



@Test

//Short description : in this test case we are checking the new balance and currency after converting it

//Explanation : we set the balance and then called the method convertToCurrency. After that we checked if the new currency equals to that we sent as the attribute and then we checked the new balance. The bug will appear if the balance and rate are minus, in that way new balance will be plus.

public void testConvertToCurrency() {

Account myBankAccount=new Account(100.0,"SEK");

myBankAccount.convertToCurrency("USD",8.3);

assertEquals("Test currency","USD", myBankAccount.getCurrency());

assertEquals("Test new balance",myBankAccount.getBalance(),Double.valueOf(100*8.3));

System.out.println(" Balance and currency after converting: " + myBankAccount.getBalance()+myBankAccount.getCurrency());

}



@Test

//Short description : in this test case we are checking the new balance and currency after converting it.

//Explanation : we set the balance and then called the method convertToCurrency. After that we checked if the new currency equals to that we sent as the attribute and then we checked the new balance. The bug will appear if the new currency is the same as the previous one.

public void testConvertToCurrency2() {

Account myBankAccount=new Account(100.0,"SEK");

 myBankAccount.convertToCurrency("SEK",2.0);

 if (myBankAccount.getCurrency()=="SEK"){

 assertEquals("Test new balance",myBankAccount.getBalance(),Double.valueOf(100.0));

 System.out.println(" Balance and currency after converting: " + myBankAccount.getBalance()+myBankAccount.getCurrency());

}

}



@Test

//Short description : in this test case we are checking transfering money from one account to another

//Explanation : the balance and currency for sender's bank account is 1000.0SEK and for the receiver's bank account we put default values (O.0SEK). We checked sender's currency, his/her new balance and new balance of receiver's new balance

public void testTransferToAccount() {


Account senderBankAccount = new Account(1000.0,"SEK");

Account receiverBankAccount = new Account();

senderBankAccount.TransferToAccount(receiverBankAccount);

assertEquals("test transfer", senderBankAccount.getCurrency(),receiverBankAccount.getCurrency());

assertEquals("test transfer", senderBankAccount.getBalance(), Double.valueOf(0.0));

assertEquals("test transfer", receiverBankAccount.getBalance(), Double.valueOf(1000.0));

System.out.println(" Balance of SenderBankAccount after transfer money: " + senderBankAccount.getBalance());
System.out.println(" Balance of ReceiverBankAccount after transfer money: " + receiverBankAccount.getBalance());

}

@Test
//Short description : in this test case we are checking transfering money from one account to another

//Explanation : the balance and currency for sender's bank account is default (0.0SEK) and for the receiver's bank account 1000.0SEK. We checked sender's currency, his/her new balance and new balance of receiver's new balance
public void testTransferToAccount2() {
Account senderBankAccount = new Account(100.0, "SEK");

Account receiverBankAccount = new Account(500.0,"USD");

senderBankAccount.TransferToAccount(receiverBankAccount);

assertEquals("test transfer", senderBankAccount.getBalance(), Double.valueOf(100.0));

assertEquals("test transfer", receiverBankAccount.getBalance(), Double.valueOf(500.0));

System.out.println(" Balance of SenderBankAccount after transfer money: " + senderBankAccount.getBalance());
System.out.println(" Balance of ReceiverBankAccount after transfer money: " + receiverBankAccount.getBalance());

}


@Test

//Short description : in this test case we are checking the new balance after withdrawing all the money from account.

//Explanation : we wanted to find a bug in system if the balance is lower than 0.0 

public void testWithdrawAll() {

/*

* the withdrawALl is just a special case of withdraw money. Even when

* when you fix withdraw function, there is still a possibility for

* withdrawAll to fail. Think how you can put the Account object into a

* state where the withdrawAll fail. The correctness of this method

* depends on correctness of several other member functions.

*/

Account myBankAccount=new Account(200.0,"SEK");

myBankAccount.withdrawAll();

assertEquals("Test new balance",myBankAccount.getBalance(),Double.valueOf(0.0));

System.out.println("Balance after withdrawAll: " + myBankAccount.getBalance()+myBankAccount.getCurrency());



//fail("Not yet implemented");

}



}