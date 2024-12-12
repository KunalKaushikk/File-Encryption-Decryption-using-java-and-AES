# File-Encryption-Decryption-using-java-and-AES

File Encryption and Decryption System in Java

Table of Contents

About the Project

Features

Technologies Used

Getting Started

Database Configuration

Usage

Screenshots

Future Enhancements

Contributing

License

About the Project

The File Encryption and Decryption System is a GUI-based Java application that ensures secure file storage and transmission. It uses the AES encryption algorithm for file security and integrates with MySQL for user authentication and activity logging.

Features

Secure Encryption: Files are encrypted using AES (Advanced Encryption Standard).

Decryption: Authorized users can decrypt files.

User Authentication: GUI-based login system connected to a MySQL database.

Intuitive Interface: Built using Java Swing for a user-friendly experience.

File Logging: Tracks and stores user actions in the database.

Technologies Used

Programming Language: Java

Encryption Algorithm: AES (Advanced Encryption Standard)

Database: MySQL

UI Framework: Java Swing

Getting Started

Prerequisites

Install Java Development Kit (JDK) 8 or later.

Install MySQL Community Server and Workbench.

Set up a MySQL JDBC driver.

Installation Steps

Clone the repository:

git clone https://github.com/yourusername/file-encryption-decryption.git
cd file-encryption-decryption

Open the project in your IDE (e.g., IntelliJ IDEA, Eclipse, or VS Code).

Configure the MySQL connection (see Database Configuration).

Run the Main.java file to start the application.

Database Configuration

Create a MySQL database:

CREATE DATABASE file_security;

Use the provided SQL script to create the required tables:

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);

CREATE TABLE file_logs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    action VARCHAR(50),
    file_name VARCHAR(255),
    timestamp DATETIME DEFAULT CURRENT_TIMESTAMP
);

Update the database connection details in the Java code:

String url = "jdbc:mysql://localhost:3306/file_security";
String username = "root";
String password = "yourpassword";

Usage

Launch the application.

Log in with valid credentials or register as a new user.

Choose a file to encrypt or decrypt.

View logs of actions in the database.
Future Enhancements

Multi-user support: Implement roles and permissions.

Cloud Integration: Store encrypted files on the cloud.

Logging Improvements: Add detailed reports.

Support for Additional Algorithms: RSA, SHA.

Contributing

Contributions are welcome! Please follow these steps:

Fork the repository.

Create your feature branch:

git checkout -b feature/AmazingFeature

Commit your changes:

git commit -m 'Add some AmazingFeature'

Push to the branch:

git push origin feature/AmazingFeature

Open a pull request.
