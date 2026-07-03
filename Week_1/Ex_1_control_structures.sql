-- Exercise 1: Control Structures

-- Scenario 1: Apply 1% discount to loan interest rate for customers above 60
BEGIN
  FOR rec IN (
    SELECT l.LoanID, c.CustomerID, c.DOB
    FROM Loans l
    JOIN Customers c ON c.CustomerID = l.CustomerID
  )
  LOOP
    IF TRUNC(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12) > 60 THEN
      UPDATE Loans
      SET InterestRate = InterestRate - 1
      WHERE LoanID = rec.LoanID;
    END IF;
  END LOOP;
  COMMIT;
END;
/

-- Scenario 2: Set IsVIP flag for customers with balance over $10,000
ALTER TABLE Customers ADD IsVIP VARCHAR2(5) DEFAULT 'FALSE';

BEGIN
  FOR cust IN (SELECT CustomerID, Balance FROM Customers)
  LOOP
    IF cust.Balance > 10000 THEN
      UPDATE Customers
      SET IsVIP = 'TRUE'
      WHERE CustomerID = cust.CustomerID;
    ELSE
      UPDATE Customers
      SET IsVIP = 'FALSE'
      WHERE CustomerID = cust.CustomerID;
    END IF;
  END LOOP;
  COMMIT;
END;
/

-- Scenario 3: Print reminders for loans due within next 30 days
BEGIN
  FOR rec IN (
    SELECT l.LoanID, l.EndDate, c.CustomerID, c.Name
    FROM Loans l
    JOIN Customers c ON c.CustomerID = l.CustomerID
    WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
  )
  LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || rec.Name ||
                         ' (ID: ' || rec.CustomerID ||
                         ') has Loan ' || rec.LoanID ||
                         ' due on ' || TO_CHAR(rec.EndDate, 'DD-MON-YYYY'));
  END LOOP;
END;
/
