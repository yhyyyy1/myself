package Iterator;

public class DataIterator implements Iterator {
    private Data data;
    private int index;

    public DataIterator(Data data) {
        this.data = data;
        this.index = 0;
    }

    public boolean hasNext() {
        if (index < data.getLength()) {
            return true;
        } else {
            return false;
        }
    }

    public Object next() {
        Page page = data.getPageAt(index);
        index++;
        return page;
    }

}
