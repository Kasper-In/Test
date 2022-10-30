import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Category {

    protected String nameCategory;
    protected Set<String> values = new HashSet<>();
    //protected int sumСategory;
    protected List<Purchase> purchases;

    public Category(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public void addValue(String value){
        values.add(value);
    }

    @Override
    public int hashCode() {
        return nameCategory.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }
}

