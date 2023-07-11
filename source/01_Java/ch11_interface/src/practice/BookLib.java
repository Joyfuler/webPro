package practice;

public class BookLib extends BookInfo implements ILendable {

    private String borrower;
    private String checkoutDate;
    private byte state; // 0,1

    public BookLib(String bookNo, String bookTitle, String writer) {
        super(bookNo, bookTitle, writer);
    }

    public BookLib(String bookNo, String bookTitle, String writer, String borrower, String checkoutDate, byte state) {
        super(bookNo, bookTitle, writer);
        this.state = state;
    }

    @Override
    public void checkOut(String borrower, String checkoutDate) {
        this.borrower = borrower;
        this.checkoutDate = checkoutDate;

        System.out.println();
        if (state == STATE_BORROWED) {
            System.out.println("?μ²???  " + getBookTitle() + "??? ??μΆμ€???€.");
            return;
        } else {
            state = STATE_BORROWED;
            System.out.println("?μ²???  " + getBookTitle() + " ??? ??μΆμ΄ ?λ£λ??΅??€.");
            System.out.println("??μΆμΈ : " + borrower + "\t ??μΆμΌ : " + checkoutDate);
        }
    }


    @Override
    public void checkIn() {
        if (state == STATE_NORMAL) {
            System.out.println("?μ²???  " + getBookTitle() + " ??? ?΄λ―? λ°λ©???΅??€.");
            return;
        } else {
            state = STATE_NORMAL;
            System.out.println("?μ²???  " + getBookTitle() + " ??? λ°λ©?΄ ?λ£λ??΅??€.");
        }
    }

    @Override
    public void printState() {
        if (state == STATE_NORMAL) {
            System.out.println(getBookNo() + "\t" + getBookTitle() + "\t (" + getWriter() + ") μ§?? (??μΆκ??₯)");
        } else {
            System.out.println(getBookNo() + "\t" + getBookTitle() + "\t(" + getWriter() + ") μ§?? (??μΆμ€)\t (??μΆμΌ) : " + getCheckoutDate());
        }
    }


    @Override
    public String getBorrower() {
        return borrower;
    }

    @Override
    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }
}