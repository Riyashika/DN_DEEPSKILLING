-- Exercise 3: Stored Procedures

-- Scenario 1: ProcessMonthlyInterest
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN
  UPDATE Accounts
  SET Balance = Balance + (Balance * 0.01),
      LastModified = SYSDATE
  WHERE AccountType = 'Savings';

  COMMIT;
END ProcessMonthlyInterest;
/

-- Call
EXEC ProcessMonthlyInterest;


-- Scenario 2: UpdateEmployeeBonus
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
  p_department  IN VARCHAR2,
  p_bonus_pct   IN NUMBER
)
AS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * p_bonus_pct / 100)
  WHERE Department = p_department;

  COMMIT;
END UpdateEmployeeBonus;
/

-- Call
EXEC UpdateEmployeeBonus('IT', 10);


-- Scenario 3: TransferFunds
CREATE SEQUENCE TransactionID_SEQ START WITH 3 INCREMENT BY 1;

CREATE OR REPLACE PROCEDURE TransferFunds(
  p_from_account IN NUMBER,
  p_to_account   IN NUMBER,
  p_amount       IN NUMBER
)
AS
  v_balance NUMBER;
BEGIN
  SELECT Balance INTO v_balance
  FROM Accounts
  WHERE AccountID = p_from_account
  FOR UPDATE;

  IF v_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account');
  END IF;

  UPDATE Accounts
  SET Balance = Balance - p_amount,
      LastModified = SYSDATE
  WHERE AccountID = p_from_account;

  UPDATE Accounts
  SET Balance = Balance + p_amount,
      LastModified = SYSDATE
  WHERE AccountID = p_to_account;

  INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
  VALUES (TransactionID_SEQ.NEXTVAL, p_from_account, SYSDATE, p_amount, 'Withdrawal');

  INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
  VALUES (TransactionID_SEQ.NEXTVAL, p_to_account, SYSDATE, p_amount, 'Deposit');

  COMMIT;

EXCEPTION
  WHEN NO_DATA_FOUND THEN
    RAISE_APPLICATION_ERROR(-20002, 'Source account not found');
  WHEN OTHERS THEN
    ROLLBACK;
    RAISE;
END TransferFunds;
/

-- Call
EXEC TransferFunds(1, 2, 200);
