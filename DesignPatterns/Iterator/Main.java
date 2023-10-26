package Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("请输入数据集");
        String args0 = "a b c d e f g h j j k l m n 1";
        String args1 = "10";
        String[] dataSet = args0.split(" ");
        int maxSize = Integer.parseInt(args1);
        Data data = new Data(maxSize);

        int len = dataSet.length;
        while (len > 0) {
            Page page = new Page(dataSet[dataSet.length - len]);
            data.appendPages(page);
            len--;
            if ((dataSet.length - len) == maxSize)
                break;
        }

        Iterator it = data.iterator();
        int count = 1;
        while (it.hasNext()) {
            Page page = (Page) it.next();
            System.out.println("页面" + count + "：" + page.getPage());
            count++;
        }
    }
}
