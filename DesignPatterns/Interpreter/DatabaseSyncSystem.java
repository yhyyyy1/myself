package Interpreter;

import java.util.HashMap;
import java.util.Map;

// 数据库类
class Database {
    private Map<String, String> data;

    public Database() {
        data = new HashMap<>();
    }

    public void copyView(Database fromDB, Database toDB) {
        toDB.getData().putAll(fromDB.getData());
    }

    public void moveTable(String tableName, Database fromDB, Database toDB) {
        if (fromDB.getData().containsKey(tableName)) {
            toDB.getData().put(tableName, fromDB.getData().get(tableName));
            fromDB.getData().remove(tableName);
        }
    }

    public Map<String, String> getData() {
        return data;
    }
}

// 抽象表达式类
interface AbstractExpression {
    void interpret(Context context);
}

// 终端表达式类
class TerminalExpression implements AbstractExpression {
    private String instruction;

    public TerminalExpression(String instruction) {
        this.instruction = instruction;
    }

    @Override
    public void interpret(Context context) {
        String[] tokens = instruction.split(" ");
        if (tokens.length >= 4) {
            String command = tokens[0];
            String target = tokens[1];
            String fromDB = tokens[3];
            String toDB = tokens[5];

            if ("COPY".equalsIgnoreCase(command)) {
                context.copyView(target, fromDB, toDB);
            } else if ("MOVETABLE".equalsIgnoreCase(command)) {
                context.moveTable(target, fromDB, toDB);
            }
        }
    }
}

// 上下文类
class Context {
    private Database sourceDatabase;
    private Database destinationDatabase;

    public Context(Database sourceDatabase, Database destinationDatabase) {
        this.sourceDatabase = sourceDatabase;
        this.destinationDatabase = destinationDatabase;
    }

    public void execute(String instruction) {
        AbstractExpression expression = new TerminalExpression(instruction);
        expression.interpret(this);
    }

    public void copyView(String target, String fromDB, String toDB) {
        sourceDatabase.copyView(sourceDatabase, destinationDatabase);
    }

    public void moveTable(String tableName, String fromDB, String toDB) {
        sourceDatabase.moveTable(tableName, sourceDatabase, destinationDatabase);
    }
}

public class DatabaseSyncSystem {
    public static void main(String[] args) {
        Database sourceDB = new Database();
        sourceDB.getData().put("View1", "View1Data");
        sourceDB.getData().put("View2", "View2Data");

        Database destinationDB = new Database();

        Context context = new Context(sourceDB, destinationDB);

        String instruction1 = "COPY View1 FROM sourceDB TO destinationDB";
        String instruction2 = "MOVETABLE Student FROM sourceDB TO destinationDB";

        context.execute(instruction1);
        context.execute(instruction2);

        System.out.println("Destination Database Data:");
        System.out.println(destinationDB.getData());
    }
}
