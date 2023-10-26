package Bridge;

public class BMPImage extends Image {
    public BMPImage(Filter filter) {
        super(filter);
    }

    @Override
    public void apply() {
        System.out.println("Applying filter for BMP image");
        filter.applyFilter();
    }
}