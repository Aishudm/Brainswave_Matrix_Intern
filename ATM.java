public class ATM {

    private int balance;
    private int pin;

    public ATM(int balance, int pin) {
        this.balance = balance;
        this.pin = pin;
    }

    public void displayMenu() {
        System.out.println("1.Check the balance");
        System.out.println("2.Deposit");
        System.out.println("3.Withdraw");
        System.out.println("4.Change pin");
        System.out.println("5.Exit");
    }

    public void Deposit(int amount) {
        balance += amount;
    }

    public void Withdraw(int amount) {
        if (balance < amount) {
            System.out.println("Insufficient balance");
            return;
        }
        balance -= amount;
    }

    public int getbalance() {
        return balance;
    }

    public Boolean validatepin(int pin) {
        return this.pin == pin;
    }

    public void Changepin(int newpin) {
        pin = newpin;
        System.out.println("pin changed!");
    }

    public static void main(String[] args) {
        ATM atm = new ATM(10000, 1234);
        atm.displayMenu();
        System.out.println("Enter the pin:");
        int pin = Integer.parseInt(System.console().readLine());

        if (atm.validatepin(pin)) {
            int option = 0;
            while (option != 5) {
                atm.displayMenu();
                option = Integer.parseInt(System.console().readLine());
                switch (option) {
                    case 1:
                        System.out.println("balance: " + atm.getbalance());
                        break;

                    case 2:
                        System.out.println("Enter Amount:");
                        int amount = Integer.parseInt(System.console().readLine());
                        atm.Deposit(amount);

                        break;

                    case 3:
                        System.out.println("Enter Amount:");
                        amount = Integer.parseInt(System.console().readLine());
                        atm.Withdraw(amount);
                        break;

                    case 4:
                        System.out.println("Enter Amount:");
                        int newpin = Integer.parseInt(System.console().readLine());
                        atm.Changepin(newpin);
                        break;

                    case 5:
                        System.out.println("Thank you for visiting ATMt:");

                        break;

                    default:
                        break;
                }

            }
        } else {

            System.out.println("you entered  Invalid pin!");
        }

    }
}
