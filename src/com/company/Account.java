package com.company;

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class Account {


    //instance variables
    int accountBalance;
    int previousTransanction;
    String customerName;
    String customerId;


    //constructor
    public Account(String name, String id){
        customerName = name;
        customerId = id;
    }

    //method used for depositing the money
    public void deposit(int depositAmount){
        if (depositAmount != 0){
            accountBalance += depositAmount;
            previousTransanction = depositAmount;
        }
    }

    //method to withdraw money
    public void withdraw(int withdrawAmount) {
        if (withdrawAmount != 0) {
            accountBalance -= withdrawAmount;
            previousTransanction = -withdrawAmount;//this will allow the values to be negative
        }
    }

    //method that show the previous transaction
    public void showPreviousTransaction(){

        if (previousTransanction > 0){
            System.out.println("Deposited amount: "+ previousTransanction);
        }else if (previousTransanction < 0){
            System.out.println("Withdrawn: " + Math.abs(previousTransanction));
        }else {
            System.out.println("No transaction made");
        }
    }

    public void calculateInterestRate(int yearsRate){
        double interestRate = 0.10;
        double newBalance = (accountBalance * interestRate * yearsRate) +accountBalance;
        //calculation to get the actual interest rate
        System.out.println("The current interest rate is " + (100 * interestRate) + "%");
        System.out.println("After "+ yearsRate + " years, your account balance will be: " + newBalance);
    }

    public void showMenu(){
         char options = '\0';
         Scanner input = new Scanner(System.in);

        System.out.println("Welcome, " + customerName + "your bank account!");
        System.out.println("Your ID is: "+ customerId);
        System.out.println("\nWhat would like to do?");
        System.out.println("\nA, Check your account balance");
        System.out.println("B, Make a deposit into your account");
        System.out.println("C, Make a withdrawal");
        System.out.println("D, View previous transaction");
        System.out.println("E,Calculate interest");
        System.out.println("F, Exit from your account");

        //the output decision in this do while is based on the user input
        do{
            System.out.println("\nEnter an option");
            char option1 = input.next().charAt(0);//given 0 so that it only gets the first index even if user input long words
            options = Character.toUpperCase(option1);
            System.out.println();
            switch (options){

                // A display user account balance
                case 'A':
                    System.out.println("----------------------------------------");
                    System.out.println("Balance:  $" + accountBalance);
                    System.out.println("----------------------------------------");
                    System.out.println();
                    break;

                //allows user to deposit
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amount = input.nextInt();
                    deposit(amount);//pass the amount to the deposit method
                    System.out.println();
                    break;

                //allows user to withdraw
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int withdraw = input.nextInt();
                    withdraw(withdraw);//pass the amount to the deposit method
                    System.out.println();
                    break;

                //allows user to view recent transactions
                case 'D':
                    System.out.println("----------------------------------------");
                    showPreviousTransaction();
                    System.out.println("----------------------------------------");
                    System.out.println();
                    break;
                //calculate the interest rate accumulated after numbers of years entered by the user
                case 'E':
                    System.out.println("Enter how many years of interest: ");
                    int years = input.nextInt();
                    calculateInterestRate(years);
                    break;

                //exits the user from their account
                case 'F':
                    System.out.println("----------------------------------------");
                    break;

                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D, or E to access the services or F to exit");
                    break;
            }
        }while(options != 'F');
        System.out.println("Thank you for banking with us" + customerName + "!");
    }
}
