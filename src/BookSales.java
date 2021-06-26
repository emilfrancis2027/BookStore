public class BookSales {
    int salesId;
    String bookTitle;
    String authorName;
    String customerName;
    int qty;
    double totalPayment;

    public BookSales(){}

    public BookSales(int salesId, String bookTitle, String authorName,String customerName, int qty, double totalPayment) {
        this.salesId = salesId;
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.customerName=customerName;
        this.qty = qty;
        this.totalPayment = totalPayment;
    }
}
