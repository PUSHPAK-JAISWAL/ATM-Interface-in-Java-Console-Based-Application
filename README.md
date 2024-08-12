# ATM Interface in Java (Console Based Application)

## Project Overview

This project is a console-based ATM interface built using Core Java. The application simulates basic ATM operations such as checking transaction history, withdrawing funds, depositing funds, transferring funds, and creating new accounts. The project is designed to be modular, testable, maintainable, and portable, adhering to good coding practices and software design principles.

## Features

- **Login:** Users can log in using their User ID and PIN.
- **Create Account:** New users can create an account by providing basic details and an initial deposit.
- **Show Transaction History:** Users can view a list of all transactions performed on their account.
- **Withdraw Funds:** Users can withdraw funds from their account, with validation for sufficient balance.
- **Deposit Funds:** Users can deposit funds into their account.
- **Transfer Funds:** Users can transfer funds to another account within the same bank.
- **Exit:** Users can exit the application.

## Project Structure

The project is organized into the following packages and classes:

- **com.ATM.application.ATM**
  - `ATM`: The main class that handles the user interface and manages user interaction.

- **com.ATM.application.Account**
  - `Account`: Manages account details and operations such as deposit, withdrawal, and transfer.

- **com.ATM.application.AccountHolder**
  - `AccountHolder`: Represents the account holder with their personal details and associated account.

- **com.ATM.application.Bank**
  - `Bank`: Manages the bank's operations, including user authentication and account management.

- **com.ATM.application.BankTransaction**
  - `BankTransaction`: Records and manages individual transactions made by the account holder.

## How to Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/PUSHPAK-JAISWAL/ATM-Interface-in-Java-Console-Based-Application.git
   cd ATM-Interface-in-Java-Console-Based-Application

### Compile the Java files:

```bash
javac -d bin src/com/ATM/application/**/*.java
### Run the application:

```bash
java -cp bin com.ATM.application.ATM.ATM

