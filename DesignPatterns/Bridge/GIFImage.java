package Bridge;

public class GIFImage extends Image {
    public GIFImage(Filter filter) {
        super(filter);
    }

    @Override
    public void apply() {
        System.out.println("Applying filter for GIF image");
        filter.applyFilter();
    }
}
