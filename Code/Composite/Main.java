package Composite;

public class Main {
    public static void main(String[] args) {
        Group mainGroup = new Group("Main Group");
        Member user1 = new Member("User 1");
        Member user2 = new Member("User 2");
        SubGroup subGroup = new SubGroup("Sub Group");
        Member user3 = new Member("User 3");

        mainGroup.add(user1);
        mainGroup.add(user2);
        mainGroup.add(subGroup);
        subGroup.add(user3);

        mainGroup.shareInformation("Important update for the main group members.");
    }
}
