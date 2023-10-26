package facade;

// 外观模式中的外观类，提供一键备份功能的接口
public class BackupFacade {
    private ContactsManager contactsManager;
    private SmsManager smsManager;
    private PhotoManager photoManager;
    private MusicManager musicManager;

    public BackupFacade() {
        contactsManager = new ContactsManager();
        smsManager = new SmsManager();
        photoManager = new PhotoManager();
        musicManager = new MusicManager();
    }

    public void backupAllData() {
        System.out.println("Starting backup...");
        contactsManager.backupContacts();
        smsManager.backupSms();
        photoManager.backupPhotos();
        musicManager.backupMusic();
        System.out.println("Backup completed.");
    }
}

// 已有的通讯录管理类
class ContactsManager {
    public void backupContacts() {
        System.out.println("Backing up contacts...");
        // 实际备份逻辑
    }
    // ...
}

// 已有的短信管理类
class SmsManager {
    public void backupSms() {
        System.out.println("Backing up SMS messages...");
        // 实际备份逻辑
    }
    // ...
}

// 已有的照片管理类
class PhotoManager {
    public void backupPhotos() {
        System.out.println("Backing up photos...");
        // 实际备份逻辑
    }
    // ...
}

// 已有的音乐管理类
class MusicManager {
    public void backupMusic() {
        System.out.println("Backing up music...");
        // 实际备份逻辑
    }
    // ...
}

