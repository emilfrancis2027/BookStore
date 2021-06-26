public class Author {
    String authorName;
    int numberOfBooksSold;

    public Author(){
        numberOfBooksSold=0;
    };

    public Author(String authorName, int numberOfBooksSold) {
        this.authorName = authorName;
        this.numberOfBooksSold = numberOfBooksSold;
    }

}
