package com.driver;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
	private double balance;
    private Lock lock;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        lock = new ReentrantLock();
    }

    public void deposit(double amount) {
       // your code goes here
    }

    public void withdraw(double amount) {
        // your code goes here
    }

    public double getBalance() {
    	// your code goes here
        return balance;
    }

    public static void main(String[] args) {
        final BankAccount account = new BankAccount(1000);

        Thread depositThread = new Thread(() -> {
            account.deposit(500);
            account.deposit(200);
        });

        Thread withdrawThread = new Thread(() -> {
            account.withdraw(300);
            account.withdraw(600);
        });

        depositThread.start();
        withdrawThread.start();

        try {
            depositThread.join();
            withdrawThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance: " + account.getBalance());
    }
}
