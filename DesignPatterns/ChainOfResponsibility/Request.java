package ChainOfResponsibility;

// Request 类表示请求数据
public class Request {
    private String data;

    public Request(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
