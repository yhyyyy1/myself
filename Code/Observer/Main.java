package Observer;

import java.util.*;

// 主题接口
interface TextEditorSubject {
    void registerObserver(TextEditorObserver observer);

    void removeObserver(TextEditorObserver observer);

    void notifyObservers();

    void setText(String text);

    String getText();
}

// 观察者接口
interface TextEditorObserver {
    void update();
}

// 文本编辑器类，充当主题
class TextEditor implements TextEditorSubject {
    private String text = "";
    private List<TextEditorObserver> observers = new ArrayList<>();

    public void registerObserver(TextEditorObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(TextEditorObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (TextEditorObserver observer : observers) {
            observer.update();
        }
    }

    public void setText(String text) {
        this.text = text;
        notifyObservers();
    }

    public String getText() {
        return text;
    }
}

// 文本信息统计区类，充当观察者
class TextInfoDisplay implements TextEditorObserver {
    private TextEditor editor;
    private int infoType;
    private String info = "";

    public TextInfoDisplay(TextEditor editor, int infoType) {
        this.editor = editor;
        this.infoType = infoType;
        editor.registerObserver(this);
    }

    public void update() {
        if (infoType == 1) {
            // 统计单词总数量和字符总数量
            String[] words = editor.getText().split("\\s+");
            int numWords = words.length;
            int numChars = editor.getText().length();
            info = "Total Words: " + numWords + ", Total Characters: " + numChars;
        } else if (infoType == 2) {
            // 统计去重后按照字典序排序的单词
            String[] words = editor.getText().split("\\s+");
            Set<String> uniqueWords = new TreeSet<>(Arrays.asList(words));
            info = "Unique Words: " + String.join(", ", uniqueWords);
        } else if (infoType == 3) {
            // 统计单词出现频次
            String[] words = editor.getText().split("\\s+");
            Map<String, Integer> wordCount = new HashMap<>();
            for (String word : words) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
            List<Map.Entry<String, Integer>> sortedWordCount = new ArrayList<>(wordCount.entrySet());
            sortedWordCount.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
            info = sortedWordCount.stream()
                    .map(entry -> entry.getKey() + " :" + entry.getValue())
                    .reduce("", (s1, s2) -> s1 + "\n" + s2);
        }
    }

    public String getInfo() {
        return info;
    }
}

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        TextInfoDisplay infoDisplay1 = new TextInfoDisplay(editor, 1);
        TextInfoDisplay infoDisplay2 = new TextInfoDisplay(editor, 2);
        TextInfoDisplay infoDisplay3 = new TextInfoDisplay(editor, 3);

        editor.setText("Hello world, hello there! Hello world!");

        System.out.println("Text Information 1:");
        System.out.println(infoDisplay1.getInfo());

        System.out.println("\nText Information 2:");
        System.out.println(infoDisplay2.getInfo());

        System.out.println("\nText Information 3:");
        System.out.println(infoDisplay3.getInfo());
    }
}