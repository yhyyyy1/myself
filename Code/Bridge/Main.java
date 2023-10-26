package Bridge;

public class Main {
    public static void main(String[] args) {
        Image jpgImage = new JPGImage(new CutoutFilter());
        jpgImage.apply();

        Image gifImage = new GIFImage(new BlurFilter());
        gifImage.apply();

        Image bmpImage = new BMPImage(new TextureFilter());
        bmpImage.apply();
    }
}
