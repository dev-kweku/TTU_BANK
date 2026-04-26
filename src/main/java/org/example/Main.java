package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AccountDAO dao=new AccountDAO();
        Scanner input=new Scanner(System.in);

        System.out.println("====TTU BANKING SYSTEM===");
        System.out.print("Enter Account Id: ");
        int id=input.nextInt();

        Account userAccount=dao.getAccount(id);

        if(userAccount != null){
            System.out.println("Welcome, " + userAccount.getOwner());

            System.out.println("Current Balance: GHS" + userAccount.getBalance());

            System.out.print("Amount to withdraw: ");
            double amount=input.nextDouble();

            if(amount <=userAccount.getBalance()){
                double newBal=userAccount.getBalance()-amount;
                boolean sucess=dao.updateBalance(id,newBal);

                if(sucess){
                    System.out.println("Success! New Balance: GHS " + newBal);
                }else {
                    System.out.println("Transaction Failed, Database not updated");
                }
                System.out.println("New balance: GHS" +newBal);
            }

        }else{
            System.out.println("Account not found.");
        }

    input.close();
    }
}