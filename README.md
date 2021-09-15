# Bank_Management_System
The application is developed by me for maintaining a person's account in a Bank. I have developed this application using JAVA (Swings, JDBC, Oracle database). The project cover JAVA advanced concepts.
Project Requirement: -
1) IDE use NetBeans
2) Oracle 18c database
3) JDK 8

<h1>About The Project</h1>

<h3>Login Portal</h3>
It has a login portal where users have to give a username and password to log in. If the user has a bank account and has entered the username and password it will successfully log in. If the user entered the correct username but the wrong password 3 times user account will be freeze and will be unable to access. If the user enters both details wrong the application will exit. It also consists of a database button where the admin can show all the bank user details by entering a password. It also has forgot password button from where the user can reset the password by verifying the username, account number, Aadhar number, and OTP if he has forgotten. It also has a new user button from where users can create a new account by providing all details.
<h3>User Portal</h3>
This portal appears after user successfully logged in. From this portal user can perform many operations. User can credit money, debit money, check balance and do fund transfer only if only the account exists in the database from user’s account. User can also change password but it required to generate OTP and verify both OTP and Aadhar Details to successfully change the password. User can also change the phone number easily by verifying OTP sent to users registered number only.
