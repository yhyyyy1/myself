package State;

// TCPConnection类，上下文类，维护TCP连接状态
class TCPConnection {
    private TCPState state;

    public TCPConnection() {
        state = new TCPListening(this);
    }

    public void setState(TCPState state) {
        this.state = state;
    }

    public void open() {
        state.open();
    }

    public void close() {
        state.close();
    }

    public void acknowledge() {
        state.acknowledge();
    }

    public void transmit() {
        state.transmit();
    }
}

// TCPState接口，代表TCP连接状态
interface TCPState {
    void open();

    void close();

    void acknowledge();

    void transmit();
}

// TCPEstablished类，表示已建立的TCP连接状态
class TCPEstablished implements TCPState {
    private TCPConnection connection;

    public TCPEstablished(TCPConnection connection) {
        this.connection = connection;
    }

    @Override
    public void open() {
        System.out.println("Connection is already open.");
    }

    @Override
    public void close() {
        System.out.println("Closing the connection.");
        connection.setState(new TCPClosed());
    }

    @Override
    public void acknowledge() {
        System.out.println("Acknowledging the connection.");
    }

    @Override
    public void transmit() {
        System.out.println("Transmitting data over the established connection.");
    }
}

// TCPListening类，表示监听中的TCP连接状态
class TCPListening implements TCPState {
    private TCPConnection connection;

    public TCPListening(TCPConnection connection) {
        this.connection = connection;
    }

    @Override
    public void open() {
        System.out.println("Opening a new connection.");
        connection.setState(new TCPEstablished(connection));
    }

    @Override
    public void close() {
        System.out.println("Connection is already closed.");
    }

    @Override
    public void acknowledge() {
        System.out.println("Cannot acknowledge in the listening state.");
    }

    @Override
    public void transmit() {
        System.out.println("Cannot transmit in the listening state.");
    }
}

// TCPClosed类，表示已关闭的TCP连接状态
class TCPClosed implements TCPState {
    @Override
    public void open() {
        System.out.println("Opening a new connection.");
    }

    @Override
    public void close() {
        System.out.println("Connection is already closed.");
    }

    @Override
    public void acknowledge() {
        System.out.println("Cannot acknowledge in the closed state.");
    }

    @Override
    public void transmit() {
        System.out.println("Cannot transmit in the closed state.");
    }
}

public class Main {
    public static void main(String[] args) {
        TCPConnection connection = new TCPConnection();

        connection.open();
        connection.transmit();
        connection.acknowledge();
        connection.close();
        connection.transmit();
    }
}
