package AbstractFactory;

// Abstract Factory interface
interface AbstractFactory {
    AbstractConnection createConnection();

    AbstractStatement createStatement();
}

// Abstract Connection interface
interface AbstractConnection {
    void connect();
}

// Abstract Statement interface
interface AbstractStatement {
    void execute(String query);
}

// ConcreteFactory for Oracle
class OracleFactory implements AbstractFactory {
    @Override
    public AbstractConnection createConnection() {
        return new OracleConnection();
    }

    @Override
    public AbstractStatement createStatement() {
        return new OracleStatement();
    }
}

// ConcreteFactory for MySQL
class MySQLFactory implements AbstractFactory {
    @Override
    public AbstractConnection createConnection() {
        return new MySQLConnection();
    }

    @Override
    public AbstractStatement createStatement() {
        return new MySQLStatement();
    }
}

// ConcreteConnection for Oracle
class OracleConnection implements AbstractConnection {
    @Override
    public void connect() {
        System.out.println("Connecting to Oracle Database");
    }
}

// ConcreteConnection for MySQL
class MySQLConnection implements AbstractConnection {
    @Override
    public void connect() {
        System.out.println("Connecting to MySQL Database");
    }
}

// ConcreteStatement for Oracle
class OracleStatement implements AbstractStatement {
    @Override
    public void execute(String query) {
        System.out.println("Executing Oracle query: " + query);
    }
}

// ConcreteStatement for MySQL
class MySQLStatement implements AbstractStatement {
    @Override
    public void execute(String query) {
        System.out.println("Executing MySQL query: " + query);
    }
}

public class Main {
    public static void main(String[] args) {
        // Configure the database type (Oracle or MySQL)
        AbstractFactory factory;
        // Change this variable to switch between Oracle and MySQL
        String databaseType = "Oracle";

        if (databaseType.equals("Oracle")) {
            factory = new OracleFactory();
        } else if (databaseType.equals("MySQL")) {
            factory = new MySQLFactory();
        } else {
            throw new IllegalArgumentException("Unsupported database type");
        }

        AbstractConnection connection = factory.createConnection();
        AbstractStatement statement = factory.createStatement();

        connection.connect();
        statement.execute("SELECT * FROM users");
    }
}

