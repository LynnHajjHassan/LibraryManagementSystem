package comp2120LabsPackage;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;
import java.time.LocalDate;
import java.util.*;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

//Class book made by Hanan
class Book{ //the start of the book class which is representing the book in the library

	private String title;//the filds of the class
	private String author;
	private String genre;
	private String isbn;
	private boolean isAvailable;
	private double price;  // Added price field
	private String imagePath;

	// Constructor of the class
  public Book(String title, String author, String genre, String isbn, double price, String imagePath) {
      this.title = title;
      this.author = author;
      this.genre = genre;
      this.isbn = isbn;
      this.isAvailable = true;
      this.price = price;  // Initialize price
      this.imagePath = imagePath;
}//the end of the constructor

    public String getBookDetails() {//the method to display the details of the book
   /*System.out.println("<----THE BOOK DETAILS---->");
   System.out.println("Title: " +title);
   System.out.println("Author: " +author);
   System.out.println("Genre: " + genre);
   System.out.println("ISBN: " + isbn);
   System.out.println("Available: " + isAvailable);*/
        return "<----THE BOOK DETAILS---->\n" +
                "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "Genre: " + genre + "\n" +
                "ISBN: " + isbn + "\n" +
                "Available: " + isAvailable +"\n"+
                "Price: " + price+ "$\n";  // Include price in details
//i did that becasue i will need it in KABIR class
//to implement in the general report SO I CAN USE IT IN MY SUBCLASS LIBRARIAN
    }//the end of the method

    public void checkout() {//here is the method of the check out that will make the avaliable of the book false

        this.isAvailable = false;
    }//the end of the method

    public void returnBook() {//here is the method of the return in that will make the avaliable of the book true

        this.isAvailable = true;
    }//the end of the method

    public String getTitle() {//the get for the title
        return title;
    }

    public void setTitle(String title) {//the set for the title
       this.title=title;
    }

    public String getAuthor() {//the get for the author
        return author;
    }

    public void setAuthor(String author) {//the set for the author
        this.author = author; 
     }

    public String getGenre() {//the get for the genre
        return genre;
    }

    public void setGenre(String genre) {//the set for the genre
               this.genre = genre; 
    }

    public String getIsbn() {//the get for the isbn
        return isbn;
    }

    public void setIsbn(String isbn) {//the set for the isbn
       this.isbn = isbn; 
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public double getPrice() {  // Getter for price
      return price;
    }
    public String getImagePath() {
      return imagePath;
    }

    public void setImagePath(String imagePath) {
      this.imagePath = imagePath;
    }

}//the end of the BOOK.JAVA class



//KABIR CLASS
class LibraryClass <T extends Book>{
    private LinkedList<T> books;
    public LibraryClass() {
        books = new LinkedList<>(); //assigned books as a linked list to store book objects
    }

    // Add a book to the library inventory called in case a
    public void addBook(T book) { //instance
        books.add(book); //method to add book tho the linked list
        //System.out.println("Book added: " + book.getTitle());
    }

    // Delete a book from the library inventory called in case b
    public void removeBook(String title) {
        boolean found = false; //initialize boolean found to false
        //looping through books
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) { //checks if title matches book list
                // and make it case insensitive
                books.remove(book);                      //if found .remove removes it
                System.out.println("The book "+ book.getTitle()+" is now not available anymore in the Library.");
                found = true; //variable found set to true to indicate the book was found
                break;
            }
        }
        if (!found) { //if the book is not found let the user know
            System.out.println("Book not found: " + title);
        }
    }

    // Search for a book by its title and return the book object if found in case c
    public Book searchBook(String title) {
        //looping through list of books
        for (Book book : books) {
            //checking if the title matches the title entered
            if (book.getTitle().equalsIgnoreCase(title)) { // and making it case insensitive
                return book; //if the book is found it'll return it
            }
        }
        return null;
    }



    // Display the details of all books in the library inventory called in case4
    public void displayInventory() {
        if (books.isEmpty()) { //checks if linked list is empty
            System.out.println("Library inventory is empty.");
        } else {
        	int i = 0 ;
            System.out.println("\nLibrary Books:");
            System.out.println("----------------");    
            for (Book book : books) {
            	i++ ;
                System.out.println(i+"."+book.getTitle()); //printing the toString override of entire book list
            }
        }
    }//the end of the method

    public LinkedList<T> getBooks() {//by hanan
        return books;
    }//the end

    //by hanan
    public void generateReport(LibraryClass<Book> library, String filePath) {
        library.generateReport(library, filePath);
    }//the end

}//the end of the KABIR class


//Coupon class created by Lynn 
class Coupon{
    // coupon class fields
    private String expDate ;
    private String couponCode ;
    private double amountToReduce ; // exp : SAVE30 OFF , amountToReduce is 30 
    
    public Coupon(String expDate,String couponCode , double amountToReduce ) {
    	this.expDate = expDate ;
    	this.couponCode = couponCode ;
    	this.amountToReduce = amountToReduce ;
    }

    // Getters methods
    public String getExpDate() {
        return expDate ;
    }
    public String getCouponCode() {
        return couponCode ;
    }
    public Double getAmountToReduce() {
        return amountToReduce ;
    }
    //Setters methods
    public void setExpDate( String expDate ) {
        this.expDate = expDate ;
    }
    public void setCouponCode( String couponCode ) {
        this.couponCode = couponCode ;
    }
    //Method to display Coupon info
    public void displayCouponInfo(JTextArea textArea) {
        textArea.append("<----COUPON DETAILS---->\n");
        textArea.append("Coupon Code: " + couponCode + "\n");
        textArea.append("Coupon expiry date: " + expDate + "\n");
        textArea.append("Amount to reduce: " + amountToReduce + "%\n\n");
    }
    //Method to calculate coupon reducing amount 
    public double calculateNewPrice(double price , double amountToReduce ) {
    	double priceToDeduce = (amountToReduce * price ) / 100 ; 
    	double newPrice = price - priceToDeduce ; 
    	return newPrice ; 
    	
    }
    

} // end of coupon class 

//coupon system management class ( by Lynn ) 
class CoupounsSystemManagement<T extends Coupon> {
    // declaring a list of coupons
    LinkedList<T> couponList ;
    //Default Constructor
    public CoupounsSystemManagement() {
        couponList = new LinkedList<>() ;
    }
    //Method to add a coupon
    public void addCoupon(T coupon) {
        couponList.add(coupon) ;
    }
    //Method to remove a coupon
    public void removeCoupon(T coupon) {
        boolean coupontIsFound = false ;
        for ( T coupon1 : couponList) {
            if ( coupon1.getCouponCode().equals(coupon.getCouponCode() ) ) {
                coupontIsFound = true ;
                break;
            }
        }
        if (coupontIsFound) {
            couponList.remove(coupon) ;  //removing
        }else {
            System.out.println("Coupon with the code"+coupon.getCouponCode()+"is not found.") ;
        }
    } // end of method
    //Method to display all codes in the list
    public void displayCoupons(JTextArea textArea) {
        textArea.setText("");
        for (T coupon : couponList) {
            coupon.displayCouponInfo(textArea);
        }
    }
}// end of CoupounSystemManagment class

class CouponDisplayPanel extends JPanel {
    private Consumer consumer;
    private JTextArea couponTextArea;

    public CouponDisplayPanel(Consumer consumer) {
        this.consumer = consumer;
        setLayout(new BorderLayout());

        couponTextArea = new JTextArea(20, 40);
        couponTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(couponTextArea);
        add(scrollPane, BorderLayout.CENTER);

        // Automatically display the coupons
        displayConsumerCoupons();
    }

    public void displayConsumerCoupons() {
        consumer.displayCoupons(couponTextArea);
    }

    public static void generateWelcomeCoupons(Consumer consumer) {
        Coupon coupon1 = new Coupon("2030-12-31","SAVE30", 30);  // creating a welcome coupon
        consumer.addCoupon(coupon1);
    }
}

//BY Hanan
class User{
    private String userName;
    private String userId;
    private String password;
    private double balance;
    private String email;
    private String adress;
    private String phoneNum;
    private double dollarsSpended ; // used to acquire the user some coupons

    public User( String userName,String userId ,String password,double balance,String email, String adress, String phoneNum ,double dollarsSpended ) {
        this.userName = userName ;
        this.userId = userId;
        this.password = password;
        this.balance = balance;
        this.email=email;
        this.adress = adress;
        this.phoneNum = phoneNum;
        this.dollarsSpended  =  dollarsSpended  ;

    }//the end of the constructor

    // Getters
    public String getUserName() {
        return userName;
    }
    public String getUserId() {
        return userId;
    }
    public String getPassword() {
        return password;
    }
    public double getBalance() {
        return balance;
    }
    public String getEmail() {
        return email;
    }
    public String getAdress() {
        return adress;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public double getDollarsSpended() {
        return dollarsSpended ;
    }

    public void setBalance( double balance ) {
        this.balance = balance ;
    }
    public void setName( String userName ) {
        this.userName = userName ;
    }
    public void setPhoneNumber(String phoneNum) {
        this.phoneNum = phoneNum ;
    }
    public void setPassword(String password) {
        this.password = password ;
    }
    public void setEmail(String email) {
        this.email = email ;
    }
    public void setAdress(String adress) {
        this.adress = adress ;
    }
    public void setdDollarsSpended(double dollarsSpended ) {
        this.dollarsSpended = dollarsSpended ;
    }


    public void displayInfo() {//the method to display the details of the user
        System.out.println("<----THE USER Informations---->");
        System.out.println("Name: " +userName);
        System.out.println("Password: " + password);
        System.out.println("Balance: " + balance);
        System.out.println("Adress: " + adress);
        System.out.println("Phone Number: " + phoneNum);

    }//the end of the method

    // Abstract method to get role
    public String getRole() {
        return null;
    }

	public void setDollarsSpended(int i) {
		// TODO Auto-generated method stub
		
	}

}//the end of the user class


//Done by Hanan
class Librarian <T extends Book> extends User{

    public Librarian( String userName,String userId, String password, double balance, String email, String address, String phoneNum ,double dollarsSpended) {
        super( userName ,userId, password, balance, email, address, phoneNum, dollarsSpended);
    }//the end of the constructor

    @Override
    public String getRole() {
        return "Librarian";
    }

    // Additional methods specific to Librarians

    public void addBook(LibraryClass<T> library, T book) {
        library.addBook(book);
        System.out.println("Book added successfully.");
    }

    public void removeBook(LibraryClass<T> library, String isbn) {
        library.removeBook(isbn);
        System.out.println("Book removed successfully.");
    }

    public void generateReport(LibraryClass<Book> library, String filePath) {
        library.generateReport(library, filePath);
    }

}//the end of the sub class

//Done by Hanan
class Consumer<T extends Book> extends User{

    private LinkedList<Book> borrowedBooks;
    //private LinkedList<Coupon> listOfCoupons ;
    private CoupounsSystemManagement<Coupon> couponSystem; // added by lynn 
    private int NumberOfPurchase ;

    public Consumer( String userName, String userId, String password, double balance, String email, String address, String phoneNum, double dollarsSpended) {
        super( userName ,userId, password, balance, email, address, phoneNum, dollarsSpended);
        borrowedBooks = new LinkedList<>();
        couponSystem = new CoupounsSystemManagement<>();//added by lynn 
        //listOfCoupons = new LinkedList<>() ;
        this.NumberOfPurchase = 0 ;
    }

    @Override
    public String getRole() {
        return "Consumer";
    }
    // Added by lynn 
    public CoupounsSystemManagement<Coupon> getCouponList(){
    	return couponSystem ;
    }
    // Method to borrow a book
    public void borrowBook(LibraryClass<Book> library, String title) {
        Book book = library.searchBook(title);
        if (book != null && book.isAvailable()) {
            book.checkout();
            borrowedBooks.add(book);
            System.out.println("Book borrowed successfully: " + book.getBookDetails());
        } else {
            System.out.println("Book not available for borrowing: " + title);
        }
    }

    // Method to return a borrowed book
    public void returnBook (LibraryClass<Book> library, String title) {
        Book bookToReturn = null;
        for (Book book : borrowedBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                bookToReturn = book;
                break;
            }
        }

        if (bookToReturn != null) {
            bookToReturn.returnBook();
            borrowedBooks.remove(bookToReturn);
            System.out.println("Book returned successfully: " + bookToReturn.getBookDetails());
        } else {
            System.out.println("Book not found in borrowed list: " + title);
        }
    }

    // Method to display borrowed books
    public void displayBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books borrowed.");
        } else {
            System.out.println("Borrowed Books:");
            for (Book book : borrowedBooks) {
                System.out.println(book.getBookDetails());
            }
        }
    }
    //Method to buy a book and deduct the price from balance
    public void buyBook(LibraryClass<Book> library, String title) {
        Book book = library.searchBook(title);
        if (book != null) {
            double price = book.getPrice();
            if (getBalance() >= price) {
                setBalance(getBalance() - price);
                library.removeBook(title); // Remove book from library inventory
                System.out.println("Book bought successfully: " + book.getBookDetails());
                NumberOfPurchase++;
            } else {
                System.out.println("Insufficient funds to buy book: " + title);
            }
        } else {
            System.out.println("Book not found: " + title);

        }
    }
    // Method to add a coupon
    public void addCoupon(Coupon coupon) {
        couponSystem.addCoupon(coupon);
    }

    // Method to remove a coupon
    public void removeCoupon(Coupon coupon) {
        couponSystem.removeCoupon(coupon);
    }

    // Method to display all coupons
    public void displayCoupons(JTextArea textArea) {
        couponSystem.displayCoupons(textArea);
    }
}

//Lynn's Class 
class UserAccountsSystem<T extends User> {
    LinkedList<T> accountsList ; // Declaring the list of accounts

    // UserAccountsSystem constructor
    public UserAccountsSystem(){
        accountsList = new LinkedList<>() ;
    }

    // Method to add an account to the list
    //Note : We will make the account( creating a librarian or a customer object inside the main function
    // We will have to let the user decide weather they want to add money to their balance once the account is created .
    //If they don't want to add any money, We will create an account with 0 money balance
    //Also, Thinking of making an already existed accounts for librarians ,and store it in the librarian accounts list
    public void addAccount(T account) {
        accountsList.add(account) ;
    }

    // remove account by account ID
    // this method is only allowed for The Librarian
    public void removeAccount( T account) {
        char choice ; // variable to store user's choice
        Scanner scanner = new Scanner(System.in) ;
        boolean accountIsFound = false ;
        for ( T account1 : accountsList) { // loop to make sure that finding the account was successful
            if ( account1.getUserId().equals(account.getUserId()) ) {
                accountIsFound = true ;
            }
        }
        while (accountIsFound){
            System.out.println("Confirm deleting the accout: 1: yes, 0: No .");
            choice = scanner.nextLine().charAt(0) ;
            if ( choice =='0' ) {
                break; // exit the loop
            }else if( choice =='1' ) {
                accountsList.remove(account) ; //removing the account
                System.out.println("Account has been deleted.\n");
                break ;
            }else {
                System.out.println("Please enter a valid choice") ;
            }
        } // end of while
        // if The account is not found
        if ( !accountIsFound) {
            System.out.println("Account was not found.") ;
        }
    } // end of remove account method

    // method used to substract the money from the user account when the user buy/borrow a book
    // required amount is a double and positive
    public void withdrawMoney( T account , double amount ) {
        double newBalance = ( account.getBalance() ) - amount ; // withdrawing the amount from the user's balance
        account.setBalance(newBalance);  // setting the new balance
    } // end of withdrawing money from the account

    // method to let the user deposit some money in his account
    // required amount is a double and positive
    public void depositMoney( T account, double amount) {
        double newBalance = ( account.getBalance() ) + amount ; // withdrawing the amount from the user's balance
        account.setBalance(newBalance);  // setting the new balance
    }

    //Update account info methods, might put them in the main metho instead
    public void changeName( T account , String newName) {
        account.setName(newName);
    }
    public void changePhoneNumber (T account , String newPhoneNum ) {
        account.setPhoneNumber(newPhoneNum) ;
    }
    public void changePassword (T account , String newPassword ) {
        account.setPassword(newPassword) ;
    }
    public void changeEmail (T account , String newEmail ) {
        account.setEmail(newEmail) ;
    }
    public void changeAdress (T account , String newAdress ) {
        account.setAdress(newAdress) ;
    }

    //Method to Find the account of the user
    public User login(String email, String password) {
        for (User account : accountsList) {
            if (account.getEmail().equalsIgnoreCase(email) && account.getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    } // end of user login method
    public boolean accountIsAvailable(String email) {
        for ( User account : accountsList) {
            if ( account.getEmail().equalsIgnoreCase(email)) {
                return true ; //account was found
            }
        }
        return false ; // account is not found
    }

}// end of accounts system class


//done by all lynn and Hanan and Kabir
public class LibraryProject {
    public static void main(String[] args) {
    	UserAccountsSystem<User> userAccountSystem = new UserAccountsSystem<>(); // creating the account System list
    	 // Register case added by Lynn to handle accounts manners 
        //Creating Librarians accounts.
        Librarian hananAccount = new Librarian("HananSenah","12024","123",100,"senah@uwindsor.ca","Wyndotte Street","519102024", 0);
        Librarian lynnAccount = new Librarian("LynnHajjHassan","22024","LynnPassword",50,"hajjhas@uwindsor.ca","Tecumseh Street","519112024", 0);
        Librarian fahimAccount = new Librarian("FahimKabir","32024","FahimPassword",400,"kabir@uwindsor.ca","Erie Street","519122024", 0);
        Consumer jhonAccount = new Consumer("Jhon","42024","JhonPassword",500,"Jhon@gmail.com","Askin Street","519132024",0) ;
        //Adding the accounts to the System
        userAccountSystem.addAccount(fahimAccount);
        userAccountSystem.addAccount(hananAccount);
        userAccountSystem.addAccount(lynnAccount);
        userAccountSystem.addAccount(jhonAccount);
        //setting up the library
        LibraryClass<Book> library = setUpLibrary();
        String option, email, password;
        Scanner scanner = new Scanner(System.in);
        User loggedInAccount = null;
        boolean newUser = false;
        boolean accountisAvaiableAlready = false ;
        Consumer consumerAccount = null ; 

        do {
            do {
                System.out.println("\nWelcome to the Library System!");
                System.out.println("-----------------------------------");
                System.out.println("Options:");
                System.out.println("1. Create an Account And Save 30% OFF!!");
                System.out.println("2. Log in to your account.");
                System.out.println("3. Exit.");
                option = scanner.nextLine();

                if (!isNumeric(option)) {// if the user entered a non numeric value
                    System.out.println("Option is Invalid. Please enter a valid option, 1 , 2, or 3");
                    continue;
                }

                if (option.equals("1")) {
                	do {
                    System.out.print("Enter your email: ");
                    email = scanner.nextLine();
                    if (!isValidEmail(email)) {
                        System.out.println("Invalid email format. Please enter a valid email (e.g., @gmail.com, @uwindsor.ca).");
                        continue;
                    }
                    if (userAccountSystem.accountIsAvailable(email)) {
                        System.out.print("Account is already available!\n");
                        accountisAvaiableAlready = true ; 
                        continue;
                    }
                    accountisAvaiableAlready = false ; 
                }while(!isValidEmail(email) || accountisAvaiableAlready );
                    password = getPassword();
                    String userName = getUserName();
                    String address = getAddress();
                    String phoneNum = getPhoneNumber();
                    String userId = generateUserId();
                    consumerAccount = new Consumer(userName, userId, password, 0, email, address, phoneNum, 0);
                    userAccountSystem.addAccount(consumerAccount);
                    System.out.println("Account has been created successfully. You Gained 30% Off coupon!");
                    newUser = true;
                    CouponDisplayPanel.generateWelcomeCoupons(consumerAccount); // generating the welcome coupon
                    continue;

                } else if (option.equals("2")) {
                    do {
                        do{System.out.print("Enter your email: ");
                        email = scanner.nextLine();
                        if (!isValidEmail(email)) {// validate the email 
                            System.out.println("Invalid email format. Please enter a valid email (e.g., @gmail.com, @uwindsor.ca).");
                            continue;
                        }
                        }while(!isValidEmail(email));
                        System.out.print("Enter your password: ");
                        password = scanner.nextLine();
                        loggedInAccount = userAccountSystem.login(email, password);
                        if (loggedInAccount != null) {
                            System.out.println("\nLogin successful. Welcome " + loggedInAccount.getUserName());
                            break;
                        } else {
                            System.out.println("Invalid email or password. Please try again.");
                            continue;
                        }
                    } while (true);

                } else if (option.equals("3")) {
                    System.out.println("Thank you for visiting the library system! Bye.");
                    break;
                } else {
                    System.out.println("Option is Invalid. Please enter a valid option, 1 or 2.");
                    continue;
                }
                break;
            } while (true);

            if (option.equals("3")) {
                break;
            }

            if (loggedInAccount instanceof Consumer) {
				IamConsumer(loggedInAccount, userAccountSystem, consumerAccount.getCouponList() ,library);
            } else if (loggedInAccount instanceof Librarian) {
                IamLibrarian(library);
            }
        } while (!option.equals("3"));

    }// int main method ending

    // Here we have useful methods used in the code,please don't touch it
//_____________________________________________________________________________________________________________________
// Useful  validation method
//this method check if the string contains numbers or not,Return true i n case the string 
// contains numeric values, and false in case it is just charcters
    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }// end of isNumeric Method
    // Method to validate the email entered by the user. 
    private static boolean isValidEmail(String email) {
        String regex = "^[\\w-\\.]+@((gmail\\.com)|(uwindsor\\.ca))$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    private static boolean isValidPhoneNumber(String phoneNumber) {
        // Regex pattern to match Canadian phone number formats and exactly 10 digits
        String regex = "^(\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}|\\d{10}|\\d{3}\\.\\d{3}\\.\\d{4})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
    // User Id Generator, used in the Register case( Added by Lynn )
    public static String generateUserId() {
        Random random = new Random();
        int userIdNumber = random.nextInt(90000) + 10000; // Generates a number between 10000 and 99999
        return String.valueOf(userIdNumber);
    }//end of user id generator method

    //Useful Methods below added by Lynn to used it inside the program
    public static String getUserName() {
        do{
            System.out.print("Enter Your User Name:"); // getting the name
            Scanner scanner = new Scanner(System.in) ;
            String userName =  scanner.nextLine() ;
            if ( isNumeric(userName)) {
                System.out.println("Invalid Name!");
                continue;
            }else {return userName;}
        }while( true );
    }
    public static String getPhoneNumber() {
        do{
        	System.out.printf("\nPlease enter your phone number in one of the following formats:%n");
            System.out.printf("1. (123) 456-7890%n");
            System.out.printf("2. 123-456-7890%n");
            System.out.printf("3. 123.456.7890%n");
            System.out.printf("4. 1234567890%n");
            System.out.print("Phone number: ");
            Scanner scanner = new Scanner(System.in) ;
            String phoneNum =  scanner.nextLine() ;
            if ( !isValidPhoneNumber(phoneNum)) {
                System.out.println("Invalid Phone Number!Please enter numbers only.");
                continue;
            }else {return phoneNum;}
        }while( true );
    }
    public static String getPassword() {
        Scanner scanner = new Scanner(System.in) ;
        System.out.print("Enter Your password:"); // getting the password
        String password =  scanner.nextLine() ;
        return password ;
    }
    public static String getAddress() {
        Scanner scanner = new Scanner(System.in);
        String address;
        
        String addressPattern = "^\\d{1,5} [A-Za-z]+(?: [A-Za-z]+)*, [A-Za-z]+(?: [A-Za-z]+)*$";
        Pattern pattern = Pattern.compile(addressPattern);
        
        while (true) {
            System.out.print("Enter your address (e.g., 1406 StreetName, CityName): ");
            address = scanner.nextLine();
            
            Matcher matcher = pattern.matcher(address);
            if (matcher.matches()) {
                return address; // Address is valid
            } else {
                System.out.println("Invalid address format. Please use the format: 1406 StreetName, CityName.");
            }
        }
    }
    public static double getDepositAmount() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Please enter the amount of money to add to the balance: $");
            String amount = scanner.nextLine();
            try {
                // Convert the input to a double
                double amountToAdd = Double.parseDouble(amount);
                // Check if the amount is positive
                if (amountToAdd < 0) {
                    System.out.println("Invalid input! Enter a positive value.");
                    continue;
                }
                // Return the valid amount
                return amountToAdd;
            } catch (NumberFormatException e) {
                // Handle invalid number format
                System.out.println("Invalid input. Please enter a valid decimal number.");
            }
        }
    }
    //Method to give the user a new coupon in case he spended such amount of money
    public static void addNewCoupon(User loggedInAccount,CoupounsSystemManagement<Coupon> couponsSystem) {
    	// if the user spended more than 100 buying books
    	if ( loggedInAccount.getDollarsSpended() >= 250) {
    		Coupon newCoupon = new Coupon("2026-12-31","250SPEN",50) ; 
            couponsSystem.addCoupon(newCoupon);	
            loggedInAccount.setDollarsSpended(0);
            System.out.println("Congratualtion!Since you spend more than 250$ on our library\nyou Gained a new coupon!"); 
            System.out.println("Check your account for more details.");        
    	}	
    }
    // By hanan: method to set up library 
    public static LibraryClass setUpLibrary() {
        LibraryClass<Book> library = new LibraryClass<>();
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Classic", "1234567890", 127.6, "C:\\Users\\hanan\\OneDrive\\Desktop\\The Great Gatsby.jpg"));//Adding books to the library
        library.addBook(new Book("1984", "George Orwell", "Dystopian", "2345678901", 200.62,"C:\\Users\\hanan\\OneDrive\\Desktop\\George Orwell.jpg"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", "3456789012", 120.57,"C:\\Users\\hanan\\OneDrive\\Desktop\\to Kill.jpg"));
     	library.addBook(new Book("Intro to Java","J.Gosling","Programming","7536329345",300,"C:\\Users\\hanan\\OneDrive\\Desktop\\Intro to Java.jpg"));
        return library ;
    }

//-------------START----------------------------------
//THIS METHOD IS FOR THE LABRIAIN BY Hanan-------------

    public static void IamLibrarian(LibraryClass<Book> library) {//the start of the method

    Scanner scanner = new Scanner(System.in);
    UserAccountsSystem<User> userAccounts = new UserAccountsSystem<>();
    LibraryReportSystem reportSystem = new LibraryReportSystem(library);
    boolean keepRunning = true;

    while(keepRunning) {
        System.out.println("Librarian Menu:");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Generate Report");
        System.out.println("4. Logout!");
        System.out.print("Enter your choice: ");

        if(scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine(); //newline

            System.out.println();
            
            
         switch(choice) {
            case 1://add book
                System.out.println("Enter book details:");
                String title;
                while (true) {
                    System.out.print("Title: ");
                    title = scanner.nextLine();
                    if (isNumeric(title)) {
                        System.out.println("Invalid input. Title should not be a number. Please try again.");
                    } else {
                        break;
                    }
                }

                String author;
                while (true) {
                    System.out.print("Author: ");
                    author = scanner.nextLine();
                    if (isNumeric(author)) {
                        System.out.println("Invalid input. Author name should not be a number. Please try again.");
                    } else {
                        break;
                    }
                }

                String genre;
                while (true) {
                    System.out.print("Genre: ");
                    genre = scanner.nextLine();
                    if (isNumeric(genre)) {
                        System.out.println("Invalid input. Genre should not be a number. Please try again.");
                    } else {
                        break;
                    }
                }

                String isbn;
                while (true) {
                    System.out.print("ISBN: ");
                    isbn = scanner.nextLine();
                    if (isbn.isEmpty() || !isbn.matches("[0-9-]+")) {
                        System.out.println("Invalid input. ISBN should only contain digits and hyphens. Please try again.");
                    } else {
                        break;
                    }
                }

                double price = 0;
                while (true) {
                    System.out.print("Price: $");
                    if (scanner.hasNextDouble()) {
                        price = scanner.nextDouble();
                        scanner.nextLine(); // consume newline
                        break;
                    } else {
                        System.out.println("Invalid input. Price should be a numeric value. Please try again.");
                        scanner.next(); // consume invalid input
                    }
                }
                
                
                
                String imagePath = null;
                while (true) {
                    System.out.print("Image Path: ");
                    imagePath = scanner.nextLine();
                    Path path = Paths.get(imagePath);
                    if (Files.exists(path)) {
                        break; // The path exists, so it's valid
                    } else {
                        System.out.println("Invalid Image Path. Please enter a valid path.");
                    }
                }
                
                   
                Book newBook = new Book(title, author, genre, isbn, price, imagePath);
               library.addBook(newBook);
               System.out.println("Book added successfully.");
               break;

            case 2://remove book
                System.out.println("Enter the Title of the book to remove:");
                String TitleToRemove = scanner.nextLine();
                library.removeBook(TitleToRemove);

                break;
            case 3://generate report
                reportSystem.generateReport();//calling the obj of the class that i create and call the method inside it
                break;
      
            case 4://for logout
                System.out.println("Logging out...");
                keepRunning = false;// Exit the loop and end the method
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
            }//the end of switch

        }else{//what if it was a letter
            System.out.println("Invalid choice. Please try again.");//print the message of the default
            scanner.next();//consume the invalid input
            //choice=-1;//to rest the choice so it will not take the user out the loop
        }//end of the else if
    }//the end of the while

    }//the end of the method by Hanan----------
//--------END-----------

//-----------START OF THE CONSUMER METHOD ----------------------
// I am consumer is a method to handel when a customer log in and display hime the menu of all options
    // retunr a boolea value to indicate if the user deleted his account so the method where IamConsumer was called can handle the situation . 
    public static void IamConsumer(User loggedInAccount ,UserAccountsSystem<User> userAccountSystem ,CoupounsSystemManagement<Coupon> couponsSystem ,LibraryClass<Book> library ) {
        //Method implemented by Fahim and Lynn
        String tempOption ;
        int option = 0;
        boolean keepRuning = true ; // used to exit the whole menu if the user deleted his account
        do {System.out.println("\nHere's Your Menu:");
            System.out.println("-----------------");
            System.out.println("1_Buy a Book.");
            System.out.println("2_Borrow a Book.");
            System.out.println("3_Return a Borrowed Book.");
            System.out.println("4_Access User Account");
            System.out.println("5_Search for a Specific Book.");
            System.out.println("6_Display All Available Books");
            System.out.println("7_Exit.");
            System.out.print("Please enter your choice:");
            Scanner scanner = new Scanner(System.in) ;
            tempOption = scanner.nextLine();
            if ( !isNumeric(tempOption)) {   //Validating the input
            	System.out.println("Invalid option!Please pick from 1 to 7.");
            	continue ;
            }
            option = Integer.valueOf(tempOption); // convert it to an int after making sure it is not a character
            switch(option){
                case 1:
                    optionOne(loggedInAccount, library ,couponsSystem);
                    break;
                case 2:
                    optionTwo(loggedInAccount, library);
                    break ;
                case 3:
                   
                   optionThree(loggedInAccount, library);
                    break;
                case 4:
                	keepRuning = optionFour(loggedInAccount, userAccountSystem ,couponsSystem);  
                    // if keepRuning = false ;  // account then has been deleted  
                    break;
                case 5:
                    optionFive(library);
                    break;
                case 6:
                    optionSix(library);
                    break;
                case 7:
                    System.out.println("Exiting...\n");
                    keepRuning = false ; 
                    break;
                default:
                    System.out.println("Ivalid Input.");

            }
        }while(option != 7 && keepRuning== true) ;
    }// end of I am consumer method

    // Methods used to handle options
    // made by Fahim
    public static void optionOne(User loggedInAccount, LibraryClass<Book> library, CoupounsSystemManagement<Coupon> couponsSystem) {
        Scanner scanner = new Scanner(System.in);
        Coupon applicableCoupon = null;
        // Step 1: Enter the title of the book
        System.out.print("Enter the title of the book you want to buy: ");
        String title = scanner.nextLine();
        Book book = library.searchBook(title);
        if (book != null && book.isAvailable()) {
            double price = book.getPrice();
            //Ask if the user has a coupon
            System.out.print("Do you have a coupon? (yes/no): ");
            String hasCoupon = scanner.nextLine();
            if (hasCoupon.equalsIgnoreCase("yes")) {
                System.out.print("Enter the coupon code: ");
                String couponCode = scanner.nextLine();
                //Validate the coupon
                for (Coupon coupon : couponsSystem.couponList) {
                    if (coupon.getCouponCode().equals(couponCode)) {
                        applicableCoupon = coupon;
                        break;
                    }
                }
                if (applicableCoupon != null) {
                    // Validate expiration date (Assuming format "yyyy-MM-dd")
                    LocalDate expiryDate = LocalDate.parse(applicableCoupon.getExpDate());
                    if (expiryDate.isAfter(LocalDate.now())) {                       
                        price = applicableCoupon.calculateNewPrice(price,applicableCoupon.getAmountToReduce() ) ; 
                        System.out.println("Coupon applied! You got a "+applicableCoupon.getAmountToReduce()+"% discount.");
                    } else {
                        System.out.println("Coupon has expired.");
                    }
                } else {
                    System.out.println("Invalid coupon code.");
                }
            }
            // Check balance and process the purchase
            if (loggedInAccount.getBalance() >= price) {
                loggedInAccount.setBalance(loggedInAccount.getBalance() - price);
                book.checkout(); // Mark book as not available
                loggedInAccount.setdDollarsSpended(loggedInAccount.getDollarsSpended() + price); // Add price to dollars spent
                System.out.println("Book purchased: " + book.getTitle() + " for $" + price);
                if (applicableCoupon!=null) {couponsSystem.removeCoupon(applicableCoupon) ;} // removig the coupon after doing the purchase 
            } else {
                System.out.println("Insufficient balance. Please add funds to your account.");
            }
        } else {
            System.out.println("Book not available or does not exist.");
        }
        // calling Method that lynn did to check user's money spend, to give them new coupons if applicable
        addNewCoupon(loggedInAccount ,couponsSystem);
    }

    // fahim 
    public static void optionTwo(User loggedInAccount, LibraryClass<Book> library) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of the book you want to borrow: ");
        String title = scanner.nextLine();
        Book book = library.searchBook(title);
        if (book != null && book.isAvailable()) {
            book.checkout(); //mark it as unavailable
            //library.removeBook(book.getTitle());   //remove book 
            System.out.println("Book borrowed: " + book.getTitle());
        } else {
            System.out.println("Book not available or does not exist.");
        }
    }
    //fahim
    public static void optionThree(User loggedInAccount, LibraryClass<Book> library) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of the book you want to return: ");
        String title = scanner.nextLine();
        Book book = library.searchBook(title);
        if (book != null && !book.isAvailable()) {
            book.returnBook();
            System.out.println("Book returned: " + book.getTitle());
        } else {
            System.out.println("Book was not borrowed or does not exist.");
        }
    }

    //Made by Lynn
    public static boolean optionFour(User loggedInAccount, UserAccountsSystem<User> userAccountSystem, CoupounsSystemManagement<Coupon> couponsSystem) {
        int option = 0;
        do {
            System.out.println("\nAccount Information Section. Here you can manage your Account.");
            System.out.println("---------------------------------------------------------------");
            System.out.println("1. Change Account's Name.");
            System.out.println("2. Change Account's Address.");
            System.out.println("3. Change Account's Password.");
            System.out.println("4. Change Account's Phone Number.");
            System.out.println("5. Add Balance.");
            System.out.println("6. Display Account's Information.");
            System.out.println("7. View Current Coupons.");
            System.out.println("8. Exit.");
            System.out.println("9. Delete Account.");
            Scanner scanner = new Scanner(System.in);
            String optionTemp = scanner.nextLine();
            if (!isNumeric(optionTemp)) {
                System.out.println("Please enter a valid option! Pick from 1 to 9.");
                continue;
            }
            option = Integer.valueOf(optionTemp);
            switch (option) {
                case 1:
                    String newUserName = getUserName(); // getting the new userName
                    loggedInAccount.setName(newUserName);
                    System.out.println("User Name Has been changed to " + newUserName + ".");
                    break;
                case 2:
                    String newAddress = getAddress();
                    loggedInAccount.setAdress(newAddress);
                    System.out.println("Address Has been changed to " + newAddress + ".");
                    break;
                case 3:
                    String newPassword = getPassword();
                    loggedInAccount.setPassword(newPassword);
                    System.out.println("Password Has been changed to " + newPassword + ".");
                    break;
                case 4:
                    String newPhoneNumber = getPhoneNumber();
                    loggedInAccount.setPhoneNumber(newPhoneNumber);
                    System.out.println("Phone Number Has been changed to " + newPhoneNumber + ".");
                    break;
                case 5:
                    double amount = getDepositAmount();
                    double newBalance = loggedInAccount.getBalance() + amount;
                    loggedInAccount.setBalance(newBalance);
                    System.out.println("You have Now " + newBalance + " in your account.");
                    break;
                case 6:
                    loggedInAccount.displayInfo();
                    break;
                case 7:
                	if (loggedInAccount instanceof Consumer) {
                	    Consumer consumer = (Consumer) loggedInAccount;
                	    JFrame frame = new JFrame("Coupons Display");
                	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                	    frame.add(new CouponDisplayPanel(consumer));
                	    frame.pack();
                	    frame.setLocationRelativeTo(null);
                	    frame.setVisible(true);
                	}
                case 8:
                    System.out.println("Exiting...\n");
                    break;
                case 9:
                    userAccountSystem.removeAccount(loggedInAccount);
                    return false; // Account has been deleted
                default:
                    System.out.println("Invalid Input. Please try again.");
            }
        } while (option != 8 && option != 9);
        return true; // if account was not deleted, return true to continue the program
    }


	//fahim
    public static void optionFive(LibraryClass<Book> library) {
        Scanner scanner = new Scanner(System.in);
       do { System.out.println("Search by:");
        System.out.println("1. Title");
        System.out.println("2. Author");
        System.out.println("3. Genre");
        System.out.println("4. ISBN");
        System.out.print("Enter your choice: ");
        String searchOptionTemp = scanner.nextLine(); // temporary string option to handle erros
        if (!isNumeric(searchOptionTemp) ) {
            System.out.print("Invalid option!Please pick from 1 to 4\n");
            continue ; 
        }
        int searchOption = Integer.valueOf(searchOptionTemp);
        String searchQuery;
        Book foundBook = null;

        switch (searchOption) {
            case 1:
                System.out.print("Enter the title of the book: ");
                searchQuery = scanner.nextLine();
                foundBook = searchBookByTitle(library, searchQuery);
                break;
            case 2:
                System.out.print("Enter the author of the book: ");
                searchQuery = scanner.nextLine();
                foundBook = searchBookByAuthor(library, searchQuery);
                break;
            case 3:
                System.out.print("Enter the genre of the book: ");
                searchQuery = scanner.nextLine();
                foundBook = searchBookByGenre(library, searchQuery);
                break;
            case 4:
                System.out.print("Enter the ISBN of the book: ");
                searchQuery = scanner.nextLine();
                foundBook = searchBookByIsbn(library, searchQuery);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                return;
        }

        if (foundBook != null) {
            System.out.println(foundBook.getBookDetails());
        } else {
            System.out.println("No book found with the given criteria.");
        }
        break ;
       } while(true)  ;
    }
    
    // Helper method to search by title
    private static Book searchBookByTitle(LibraryClass<Book> library, String title) {
        return library.searchBook(title);
    }
    // Helper method to search by author
    private static Book searchBookByAuthor(LibraryClass<Book> library, String author) {
        for (Book book : library.getBooks()) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                return book;
            }
        }
        return null;
    }
    // Helper method to search by genre
    private static Book searchBookByGenre(LibraryClass<Book> library, String genre) {
        for (Book book : library.getBooks()) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                return book;
            }
        }
        return null;
    }
    // Helper method to search by ISBN
    private static Book searchBookByIsbn(LibraryClass<Book> library, String isbn) {
        for (Book book : library.getBooks()) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            }
        }
        return null;
   }
    public static void optionSix(LibraryClass<Book> library) {
        library.displayInventory();
    }


} // end of LibraryProject Class

//------------------------------------------------------------------------------------------------------------------------------------------
//this class is by Hanan
class LibraryReportSystem{//the class that will handle the report of the librarain 
    private LibraryClass<Book> library;
    private Scanner scanner;

    public LibraryReportSystem(LibraryClass<Book> library) {//the constuctor
        this.library = library;
        this.scanner = new Scanner(System.in);
    }//the end of the constructor

    public void generateReport() {
        System.out.println("\nDear Librarian, in our library, we have two styles to generate reports.");
        System.out.println("Generate report as:");
        System.out.println("1. File <General Book Informations>");
        System.out.println("2. GUI <General Book Inoframtions with PICTURE>");
        System.out.print("Enter your choice: ");
        //int reportChoice = scanner.nextInt();
        //scanner.nextLine(); // consume newline

        
        
        if(scanner.hasNextInt()) {
            int reportChoice = scanner.nextInt();
            scanner.nextLine(); //newline
            
            
        switch (reportChoice) {
            
        
        
        case 1:
            System.out.println("Enter the file path where the report should be saved:");
            String filePath = scanner.nextLine();
            
            if (!FilePathValidator.isValidFilePath(filePath)) {
                System.out.println("Invalid file path format. Please enter a valid path like C:\\\\path\\\\to\\\\your\\\\existing\\\\report.txt");
                break;
            }

            FileReportGenerator fileReportGenerator = new FileReportGenerator(library, filePath);
            Thread fileReportThread = new Thread(fileReportGenerator);
            fileReportThread.start();
            try {
                fileReportThread.join(); // Wait for the report generation to complete
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted: " + e.getMessage());
            }
            
            if (fileReportGenerator.isReportGenerated()) {
                System.out.println("Report generated successfully.");
            } else {
                System.out.println("Report generation failed.");
            }
            break;



            case 2:
                Thread guiReportThread = new Thread(new GUIReportGenerator(library));
                guiReportThread.start();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }//the end of the switch
        
        }else {
        	System.out.println("Invalid choice. Please try again by typing ONLY <1> or <2>.");//print the message of the default
            scanner.next();
        }
    }//the end of the report method
}//the end of the class   

//----------------------------------------------------------
//----------------------------------------------------------
//this class is by Hanan------------------

class FileReportGenerator implements Runnable {
    private LibraryClass<Book> library;
    private String filePath;
    private volatile boolean reportGenerated = false;

    public FileReportGenerator(LibraryClass<Book> library, String filePath) {
        this.library = library;
        this.filePath = filePath;
    }

    @Override
    public void run() {
        if (!FilePathValidator.isValidFilePath(filePath)) {
            System.err.println("Invalid file path format. Please enter a valid path like C:\\\\path\\\\to\\\\your\\\\existing\\\\report.txt");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Library Report\n");
            writer.write("====================\n");
            for (Book book : library.getBooks()) {
                writer.write(book.getBookDetails() + "\n");
            }
            reportGenerated = true; // Indicate that the report has been generated
        } catch (IOException e) {
            System.err.println("Error writing report to file: " + e.getMessage());
        }
    }

    public boolean isReportGenerated() {
        return reportGenerated;
    }
}

//mehod done by hanan

 class FilePathValidator {
    // Regular expression to match a file path pattern (Windows style)
    private static final String FILE_PATH_PATTERN = "^[a-zA-Z]:\\\\(\\w+\\\\)*\\w+\\.\\w+$";
    private static final Pattern pattern = Pattern.compile(FILE_PATH_PATTERN);

    public static boolean isValidFilePath(String filePath) {
        return pattern.matcher(filePath).matches();
    }
}



//this class is by Hanan---------------------
//this class is by Hanan---------------------
class GUIReportGenerator implements Runnable {
private LibraryClass<Book> library;

public GUIReportGenerator(LibraryClass<Book> library) {
    this.library = library;
}

@Override
public void run() {
    SwingUtilities.invokeLater(() -> {
        JFrame frame = new JFrame("Library Report");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        for (Book book : library.getBooks()) {
            JPanel bookPanel = new JPanel(new BorderLayout());
            JLabel textLabel = new JLabel("<html>" + book.getBookDetails().replace("\n", "<br>") + "</html>");
            
            // Display the book image if available
            if (book.getImagePath() != null && !book.getImagePath().isEmpty()) {
                ImageIcon imageIcon = new ImageIcon(book.getImagePath());
                Image image = imageIcon.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH); // Scale the image
                JLabel imageLabel = new JLabel(new ImageIcon(image));
                bookPanel.add(imageLabel, BorderLayout.WEST);
            }

            bookPanel.add(textLabel, BorderLayout.CENTER);
            mainPanel.add(bookPanel);
            mainPanel.add(Box.createVerticalStrut(10)); // Add space between book entries
        }

        JScrollPane scrollPane = new JScrollPane(mainPanel);

        // Create a close button
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> frame.dispose());

        // Layout
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(closeButton, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setSize(500, 600); // Adjust the size as needed
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    });
}
}//the end of the class
