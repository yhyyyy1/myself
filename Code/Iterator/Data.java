package Iterator;

public class Data implements Aggregate {
    private Page[] pages;
    private int last = 0;

    public Data(int maxSize) {
        this.pages = new Page[maxSize];
    }

    public Page getPageAt(int index) {
        return pages[index];
    }

    public void appendPages(Page page) {
        this.pages[last] = page;
        last++;
    }

    public int getLength() {
        return pages.length;
    }

    public Iterator iterator() {
        return new DataIterator(this);
    }


}
