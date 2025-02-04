# Smart Study Timer  

This is a university project done by Branka Stoyeva and me.

Smart Study Timer is an application that provides intelligent tools for effective study time management. The system is designed to help students and learners optimize their study sessions by leveraging technology to enhance organization and concentration. It is aimed at students who seek to improve their academic performance.  

## Summary  

The **Smart Study Timer** system offers essential functionalities such as a **study timer** and **built-in support for playing relaxing sounds**, including **white noise** and **brown noise**, to create a focused study environment. The system is designed with a **flexible architecture** to adapt to individual user needs and support easy scalability under increasing workload.  

It consists of multiple modules that interact based on **multi-layered architecture principles** and **REST API interfaces**:  

### **Timer Management Module**  
- Implements the core functionality of the application – study timer management.  
- Provides a **REST API** for creating, starting, stopping, and analyzing study sessions.  
- Supports data logging and retrieval for past study sessions.  

### **User Management Module**  
- Manages user authentication (registration and login).  
- Integrated with **Spring Security** for secure access.  
- Handles user profile creation and management.  
- Includes validation logic for user input data.  

### **UI Module**  
- Represents the **frontend** built with **HTML, CSS, and JavaScript**.  
- Communicates with the backend via **HTTP requests**.  
- Provides features for **login, registration, study session creation, statistics visualization, and profile management**.  

### **Database Layer**  
- Uses **MySQL** for data storage.  
- Structured with multiple tables (**users, daily study timers, weekly study timers**).  
- Integrated with **Hibernate** for automated database management.  

## **Technologies Used**  

- **IntelliJ IDEA** – IDE for development.  
- **Java 23** – Primary language for implementing business logic.  
- **Spring Boot** – Framework for web application development and dependency management.  
- **MySQL** – Relational database used for storing user data and session records.  
- **HTML, CSS, JavaScript** – Technologies for building the graphical user interface.  

## **System Deployment**  

### **1. Installing Required Dependencies via Maven**  
1.1. Open the project in an IDE (e.g., IntelliJ IDEA or Eclipse).  
1.2. Ensure that the **pom.xml** file contains all necessary dependencies, including **Spring Boot, Spring Data JPA, database connectors, and other required libraries**.  
1.3. Run the following command in the terminal to download and install all necessary libraries:  
```sh
mvn clean install
```  

### **2. Configuring the Database in application.properties**  
2.1. Navigate to **src/main/resources** and open **application.properties**.  
2.2. Add **MySQL** database connection settings.  
2.3. Enter database credentials (username, password, and URL), along with **JPA settings** to enable automatic table creation.  
2.4. Save changes to **application.properties**.  

### **3. Running the Application via NewProjectApplication.java**  
3.1. Navigate to **src/main/java/com/example/UserManager** and open **UserManagerApplication.java**.  
3.2. Similarly, open **TimerManagerApplication.java** in **src/main/java/com/example/TimerManager**.  
3.3. Ensure that the file contains the main application entry point with the annotation:  
```java
@SpringBootApplication
```  
3.4. Start the application via the IDE (**Run** button).  
3.5. If everything is set up correctly, the application will be available at:  
   - **http://localhost:8081** for **UserManagerApplication.java**  
   - **http://localhost:8082** for **TimerManagerApplication.java**  

### **4. Running the UI Views**  
- **Python must be installed** to run the frontend views.  
- Open **Command Prompt**, navigate to the directory containing the UI views
- Start the Python server:  
```sh
python -m http.server 3000
```  
- Once started, the views will be accessible at **http://127.0.0.1:3000**.  

## **User Interface Implementation**  

### **1. Home Page**  
- When launching the application, the **home page** appears first.  
- The user has two main options:  
  - **Register**: If the user does not have an account, they need to register first. This can be done by clicking **REGISTER** in the top-right corner or the **Register** button at the bottom of the page.  
  - **Login**: If the user already has an account, they can click **"You already have a profile?"** to navigate to the login page.  

### **2. Study Session Start Page**  
- Once logged in, the **study session page** opens.  

### **3. Starting a Study Session**  
- To **begin studying**, the user clicks the **"Study"** button.  
- A message **"Study Time"** appears, and the **timer starts counting** the study duration.  

### **4. Taking a Break**  
- To **take a break**, the user clicks the **"Break"** button.  
- The timer switches to **break mode**, changing color from white to light gray, and displays **"Break Time"**.  

### **5. Ending a Study Session**  
- To **end the study session**, the user clicks **"End Study Session"**.  
- The timer updates and displays the **total study duration**, including study and break times.  

### **6. Audio & Video Features**  
- The application offers built-in **audio options** (white noise, brown noise, or custom selections).  
- Users can choose an audio track from the **dropdown menu** under **"Choose your study audio"**.  

### **7. Customizing the Interface**  
- Users can **change the background image** by clicking **"Set Background"** and selecting an image from their device.  

### **8. User Profile**  
- Clicking **"PROFILE"** in the top-right corner opens the **user profile page**.  
- The profile stores personal information (**name, username, email**) and **study session history** (daily/weekly time spent studying).  

---  
