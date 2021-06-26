import java.util.HashMap;
import java.util.Scanner;

public class BookShop {
    Scanner sc=new Scanner(System.in);
    HashMap<String,Book> books = new HashMap<>();
    HashMap<Integer,BookSales> sales=new HashMap<>();
    HashMap<String,Author> authors=new HashMap<>();
    public void addBook(){
        Book bookObj=new Book();
        System.out.println("Enter title");
        bookObj.title=sc.nextLine();
        System.out.println("Enter author name");
        bookObj.author=sc.nextLine();
        System.out.println("Enter genre");
        bookObj.genre=sc.nextLine();
        System.out.println("Enter price");
        bookObj.price=Double.parseDouble(sc.nextLine());
        books.put(bookObj.title, bookObj);
        if(!checkAuthorExists(bookObj.author)){
            Author authorObj=new Author();
            authors.put(bookObj.author, authorObj);
        }
        System.out.println("Book Added");
    }
    public boolean checkAuthorExists(String name){
        if(authors.containsKey(name)){
            System.out.println("Author Exists");
            return true;
        }
        else
            return false;
    }
    public boolean checkBookExists(String title,String author){
        if(books.containsKey(title)){
            System.out.println("Title Found");
            Book tempBook=new Book();
            tempBook=books.get(title);
            if (tempBook.author.equals(author)){
                System.out.println("Title and Author verified. Book Available");
                return true;
            }
            else {
                System.out.println("Book and Author Mismatch");
                return false;
            }
        }
        else{
            System.out.println("Title Not Found");
            return false;
        }
    }
    public void orderBook(){
        BookSales bookSales=new BookSales();
        Book b=new Book();
        Author a=new Author();
        String bookTitle;
        String authorName;
        System.out.println("Enter Title");
        bookTitle=sc.nextLine();
        System.out.println("Enter Author Name");
        authorName=sc.nextLine();
        if(checkBookExists(bookTitle,authorName)){
            b=books.get(bookTitle);
            System.out.println("Enter a sale id");
            bookSales.salesId=Integer.parseInt(sc.nextLine());
            bookSales.bookTitle=bookTitle;
            bookSales.authorName=authorName;
            System.out.println("Enter Customer Name");
            bookSales.customerName=sc.nextLine();
            System.out.println("Enter quantity needed");
            bookSales.qty=Integer.parseInt(sc.nextLine());
            bookSales.totalPayment=b.price*bookSales.qty;
            System.out.println("Total Payment is "+bookSales.totalPayment);
            sales.put(bookSales.salesId,bookSales);
            a=authors.get(authorName);
            a.numberOfBooksSold=a.numberOfBooksSold+bookSales.qty;
        }
        else{
            System.out.println("No such Book Found");
            return;
        }
    }
    public void getAuthorRoyalty(){
        String authorName;
        Author author=new Author();
        System.out.println("Enter The author name");
        authorName=sc.nextLine();
        if(checkAuthorExists(authorName)){
            author=authors.get(authorName);
            System.out.println(author.numberOfBooksSold);
            getRoyalty(author.numberOfBooksSold);
        }

    }
    public void getRoyalty(int numberOfBooksSold){
        if(numberOfBooksSold>=0 && numberOfBooksSold<=10){
            System.out.println("Author Royalty: Silver");
        }
        else if(numberOfBooksSold>10 && numberOfBooksSold<=50){
            System.out.println("Author Royalty: Gold");
        }
        else if(numberOfBooksSold>50){
            System.out.println("Author Royalty: Platinum");
        }
    }
    public static void main(String[] args) {
        BookShop bookShop=new BookShop();
        Scanner sc=new Scanner(System.in);
        int choice=999;
        while(choice!=0){
            System.out.println("1. Add Book 2. Order Book 3. Author Royalty");
            choice=sc.nextInt();
            switch(choice){
                case 1:
                    bookShop.addBook();
                    break;
                case 2:
                    bookShop.orderBook();
                    break;
                case 3:
                    bookShop.getAuthorRoyalty();
                    break;
            }
        }

    }
}
