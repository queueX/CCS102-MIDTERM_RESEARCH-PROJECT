import java.util.Scanner;
public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean program_running = true;
        boolean is_logged_in = false;
        int account_number = 0;
        int pin = 0;
        String tier = "";
        int balance = 0;
        int withdrawal_limit = 0;
        int attempts1 = 0;
        int attempts2 = 0;
        int attempts3 = 0;

        while (program_running) {
            while (is_logged_in == false) {
                System.out.println("\n——————————————————————————————————————————————————————————————————————————————");
                System.out.println("---------------WELCOME TO THE MULTI-TIER BANKING SYSTEM!---------------");
                System.out.println("——————————————————————————————————————————————————————————————————————————————");
                System.out.print("Enter account number: ");
                account_number = sc.nextInt();
                System.out.print("Enter PIN: ");
                pin = sc.nextInt();

                switch (account_number) {
                    case 123:
                        if (attempts1 < 3) {
                            if (pin == 111) {
                                System.out.println("\n——————————————————————————————————————————————————————————————————————————————");
                                System.out.println("---------------------------LOGIN SUCCESSFUL!---------------------------");
                                System.out.println("——————————————————————————————————————————————————————————————————————————————");
                                tier = "Basic";
                                balance = 10000;
                                withdrawal_limit = 25000;
                                is_logged_in = true;
                            } else {
                                attempts1++;
                                if (attempts1 < 3) {
                                    System.out.println("[INCORRECT PIN]: Attempt " + attempts1 + "/3, (" + (3 - attempts1) + " more attempt(s) remaining)");
                                } else {
                                    System.out.println("[UNABLE TO LOG IN]: Attempt " + attempts1 + "/3, your account has been locked!");
                                }
                            }
                        } else {
                            System.out.println("TOO MANY LOGIN ATTEMPTS, YOUR ACCOUNT HAS BEEN LOCKED!");
                        }
                        break;

                    case 456:
                        if (attempts2 < 3) {
                            if (pin == 222) {
                                System.out.println("\n——————————————————————————————————————————————————————————————————————————————");
                                System.out.println("---------------------------LOGIN SUCCESSFUL!---------------------------");
                                System.out.println("——————————————————————————————————————————————————————————————————————————————");
                                tier = "Premium";
                                balance = 20000;
                                withdrawal_limit = 50000;
                                is_logged_in = true;
                            } else {
                                attempts2++;
                                if (attempts2 < 3) {
                                    System.out.println("[INCORRECT PIN]: Attempt " + attempts2 + "/3, (" + (3 - attempts2) + " more attempt(s) remaining)");
                                } else {
                                    System.out.println("[UNABLE TO LOG IN]: Attempt " + attempts2 + "/3, your account has been locked!");
                                }
                            }
                        } else {
                            System.out.println("TOO MANY LOGIN ATTEMPTS, YOUR ACCOUNT HAS BEEN LOCKED!");
                        }
                        break;

                    case 789:
                        if (attempts3 < 3) {
                            if (pin == 333) {
                                System.out.println("\n——————————————————————————————————————————————————————————————————————————————");
                                System.out.println("---------------------------LOGIN SUCCESSFUL!---------------------------");
                                System.out.println("——————————————————————————————————————————————————————————————————————————————");
                                tier = "VIP";
                                balance = 50000;
                                withdrawal_limit = -1; // INFINITE VALUE
                                is_logged_in = true;
                            } else {
                                attempts3++;
                                if (attempts3 < 3) {
                                    System.out.println("[INCORRECT PIN]: Attempt " + attempts3 + "/3, (" + (3 - attempts3) + " more attempt(s) remaining)");
                                } else {
                                    System.out.println("[UNABLE TO LOG IN]: Attempt " + attempts3 + "/3, your account has been locked!");
                                }
                            }
                        } else {
                            System.out.println("TOO MANY LOGIN ATTEMPTS, YOUR ACCOUNT HAS BEEN LOCKED!");
                        }
                        break;

                    default:
                        System.out.println("Account number " + account_number + " not found!");
                        System.out.println("Available account numbers: (123, 456, 789)");
                }
            }

            // IF ACCOUNT IS LOGGED IN
            if (is_logged_in) {
                System.out.println("Tier: " + tier);
                System.out.println("Account number: " + account_number);
                System.out.println("PIN: " + pin);
                System.out.println("Balance: ₱" + balance);
                if (account_number == 789) {
                    System.out.println("Withdrawal limit per day: (No withdrawal limit per day)");
                } else {
                    System.out.println("Withdrawal limit per day: ₱" + withdrawal_limit);
                }
                System.out.println();

                int transaction = 0;
                int total_withdrawn = 0;

                for (transaction = 0; transaction < 3; ) {
                    System.out.println("\n——————————————————————————————————————————————————————————————————————————————");
                    System.out.println("----------------------SELECT A TRANSACTION BELOW----------------------");
                    System.out.println("——————————————————————————————————————————————————————————————————————————————");
                    System.out.println("(Transaction limit: " + transaction + "/3 )");
                    System.out.println("(1) Deposit");
                    System.out.println("(2) Withdraw");
                    System.out.println("(3) Check Balance");
                    System.out.println("(4) Exit");
                    int transaction_option = sc.nextInt();

                    if (transaction_option == 1) {
                        System.out.println("\n-------------------------------------------");
                        System.out.println(" DEPOSIT ");
                        System.out.println("-------------------------------------------");
                        System.out.println("ACCOUNT TIER: " + tier);
                        System.out.println("BALANCE: ₱" + balance);
                        System.out.print("Enter amount to deposit: ");
                        int deposit_amount = sc.nextInt();
                        if (deposit_amount > 0) {
                            System.out.println("You have successfully deposited ₱" + deposit_amount);
                            balance += deposit_amount;
                            transaction++;
                            System.out.println("Your new balance is: ₱" + balance);
                        } else {
                            System.out.println("Invalid amount! Please enter an amount greater than ₱0");
                        }
                    } else if (transaction_option == 2) {
                        System.out.println("\n-------------------------------------------");
                        System.out.println(" WITHDRAW ");
                        System.out.println("-------------------------------------------");
                        System.out.println("ACCOUNT TIER: " + tier);
                        System.out.println("BALANCE: ₱" + balance);
                        if (account_number == 789) {
                            System.out.println("DAILY WITHDRAWAL LIMIT: (No withdrawal limit per day)");
                        } else {
                            System.out.println("DAILY WITHDRAWAL LIMIT: (₱" + total_withdrawn + "/" + withdrawal_limit + ")");
                        }
                        System.out.print("Enter amount to withdraw: ");
                        int withdraw_amount = sc.nextInt();

                        if (withdraw_amount <= 0) {
                            System.out.println("Invalid amount! Please enter an amount greater than ₱0");
                        } else if (withdraw_amount <= balance) {
                            if (account_number == 789) {
                                System.out.println("You have successfully withdrawn ₱" + withdraw_amount);
                                balance -= withdraw_amount;
                                total_withdrawn += withdraw_amount;
                                transaction++;
                                System.out.println("Your remaining balance is: ₱" + balance);
                                System.out.println("Total amount withdrawn this session: (₱" + total_withdrawn + ")");
                            } else {
                                if ((withdraw_amount + total_withdrawn) <= withdrawal_limit) {
                                    System.out.println("You have successfully withdrawn ₱" + withdraw_amount);
                                    balance -= withdraw_amount;
                                    total_withdrawn += withdraw_amount;
                                    transaction++;
                                    System.out.println("Your remaining balance is: ₱" + balance);
                                    System.out.println("Total amount withdrawn this session: (₱" + total_withdrawn + "/" + withdrawal_limit + ")");
                                } else if (withdraw_amount > withdrawal_limit) {
                                    System.out.println("Transaction failed! You cannot withdraw above the limit!");
                                    System.out.println("Please select option (2) if you wish to retry, else, select (4) to exit.");
                                } else {
                                    System.out.println("Transaction failed! Please enter an amount within the limit.");
                                    System.out.println("Your maximum withdrawal limit as " + tier + " user is ₱" + withdrawal_limit);
                                    System.out.println("You have withdrawn ₱" + total_withdrawn + ", only ₱" + (withdrawal_limit - total_withdrawn) + " remains in your withdrawal limit.");
                                    System.out.println("Please select option (2) if you wish to retry, else, select (4) to exit.");
                                }
                            }
                        } else {
                            System.out.println("Insufficient balance!");
                            System.out.println("You cannot withdraw an amount greater than your balance of ₱" + balance);
                            System.out.println("Please select option (2) if you wish to retry, else, select (4) to exit.");
                        }
                    } else if (transaction_option == 3) {
                        System.out.println("\n-------------------------------------------");
                        System.out.println(" CHECK BALANCE ");
                        System.out.println("-------------------------------------------");
                        System.out.println("ACCOUNT TIER: " + tier);
                        System.out.println("YOUR CURRENT BALANCE IS: ₱" + balance);
                        if (account_number == 789) {
                            System.out.println("DAILY WITHDRAWAL LIMIT: (No withdrawal limit per day)");
                        } else {
                            System.out.println("DAILY WITHDRAWAL LIMIT: (₱" + total_withdrawn + "/" + withdrawal_limit + ")");
                        }
                    } else if (transaction_option == 4) {
                        System.out.println("\n——————————————————————————————————————————————————————————————————————————————");
                        System.out.println("----------YOU HAVE CHOSEN TO EXIT THE TRANSACTION SESSION--------------");
                        System.out.println("——————————————————————————————————————————————————————————————————————————————");
                        System.out.println("\nEXITING THE PROGRAM....");
                        System.out.println("\n——————————————————————————————————————————————————————————————————————————————");
                        System.out.println("--TRANSACTION SESSION HAS ENDED. THANK YOU FOR BANKING WITH US TODAY!--");
                        System.out.println("——————————————————————————————————————————————————————————————————————————————");
                        is_logged_in = false;
                        program_running = false;
                        break;
                    } else {
                        System.out.println("\n——————————————————————————————————————————————————————————————————————————————");
                        System.out.println(" INVALID OPTION! ");
                        System.out.println("Please type: (1) Deposit, (2) Withdraw, (3) Check balance, (4) Exit");
                        System.out.println("——————————————————————————————————————————————————————————————————————————————");
                    }
                }

                if (transaction == 3) {
                    do {
                        System.out.println("\n——————————————————————————————————————————————————————————————————————————————");
                        System.out.println("---------------TRANSACTION LIMIT HAS BEEN REACHED (3/3)!---------------");
                        System.out.println("——————————————————————————————————————————————————————————————————————————————");
                        System.out.println("Would you like to log in as another user, or would you like to exit?");
                        System.out.println("(1) Log-in as another user");
                        System.out.println("(2) Exit");
                        int exit_option = sc.nextInt();

                        if (exit_option == 1) {
                            is_logged_in = false;
                        } else {
                            System.out.println("\n——————————————————————————————————————————————————————————————————————————————");
                            System.out.println("----------YOU HAVE CHOSEN TO EXIT THE TRANSACTION SESSION--------------");
                            System.out.println("——————————————————————————————————————————————————————————————————————————————");
                            System.out.println("\nEXITING THE PROGRAM....");
                            System.out.println("\n——————————————————————————————————————————————————————————————————————————————");
                            System.out.println("--TRANSACTION SESSION HAS ENDED. THANK YOU FOR BANKING WITH US TODAY!--");
                            System.out.println("——————————————————————————————————————————————————————————————————————————————");
                            program_running = false;
                        }
                        break;
                    } while (transaction == 3);
                }
            }
        }
        sc.close();
    }
}
