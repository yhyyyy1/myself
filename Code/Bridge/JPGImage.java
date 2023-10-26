package Bridge;

public class JPGImage extends Image {
    public JPGImage(Filter filter) {
        super(filter);
    }

    @Override
    public void apply() {
        System.out.println("Applying filter for JPG image");
        filter.applyFilter();
    }
}
