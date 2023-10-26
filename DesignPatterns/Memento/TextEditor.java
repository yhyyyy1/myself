package Memento;

import java.util.Stack;

// 备忘录类，用于存储状态
class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// 原发器类，用于创建备忘录和还原状态
class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento() {
        return new Memento(state);
    }

    public void restoreMemento(Memento memento) {
        state = memento.getState();
    }

    public String getState() {
        return state;
    }
}

// 管理备忘录的类，用于支持撤销和重做
class Caretaker {
    private Stack<Memento> mementos = new Stack<>();
    private Stack<Memento> redoMementos = new Stack<>();

    public void saveMemento(Memento memento) {
        mementos.push(memento);
        redoMementos.clear(); // 清空重做栈
    }

    public void undo() {
        if (!mementos.isEmpty()) {
            Memento memento = mementos.pop();
            redoMementos.push(memento);
        }
    }

    public void redo() {
        if (!redoMementos.isEmpty()) {
            Memento memento = redoMementos.pop();
            mementos.push(memento);
        }
    }
}

public class TextEditor {
    public static void main(String[] args) {
        Originator textDocument = new Originator();
        Caretaker caretaker = new Caretaker();

        // 编辑文本
        textDocument.setState("第一步内容");
        caretaker.saveMemento(textDocument.createMemento());

        textDocument.setState("第二步内容");
        caretaker.saveMemento(textDocument.createMemento());

        // 撤销一步
        caretaker.undo();
        System.out.println("撤销后的文本内容: " + textDocument.getState());

        // 重做一步
        caretaker.redo();
        System.out.println("重做后的文本内容: " + textDocument.getState());
    }
}
