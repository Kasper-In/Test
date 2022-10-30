import javax.xml.crypto.Data;

public class Purchase {

    protected String title;
    Data date;
    int sum;

    public Purchase(String title, Data date, int sum) {
        this.title = title;
        this.date = date;
        this.sum = sum;
    }
}

