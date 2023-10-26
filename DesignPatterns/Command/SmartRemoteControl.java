package Command;

// 命令接口
interface Command {
    void execute();
}

// 具体命令类
class ConcreteCommand implements Command {
    private Light light;

    public ConcreteCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.toggle();
    }
}

// 接收者类
class Light {
    private String room;

    public Light(String room) {
        this.room = room;
    }

    public void on() {
        System.out.println(room + " light is on.");
    }

    public void off() {
        System.out.println(room + " light is off.");
    }

    public void toggle() {
        if (isOn()) {
            off();
        } else {
            on();
        }
    }

    public boolean isOn() {
        // 假设灯具状态由属性记录
        return true;
    }
}

// 遥控器类
class RemoteControl {
    private Command[] commands;

    public RemoteControl(int slots) {
        commands = new Command[slots];
    }

    public void setCommand(int slot, Command command) {
        commands[slot] = command;
    }

    public void pressButton(int slot) {
        if (slot >= 0 && slot < commands.length && commands[slot] != null) {
            commands[slot].execute();
        }
    }
}

public class SmartRemoteControl {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl(5);

        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");

        Command livingRoomLightOn = new ConcreteCommand(livingRoomLight);
        Command kitchenLightOn = new ConcreteCommand(kitchenLight);

        remoteControl.setCommand(0, livingRoomLightOn);
        remoteControl.setCommand(1, kitchenLightOn);

        System.out.println("Pressing button 0:");
        remoteControl.pressButton(0);

        System.out.println("Pressing button 1:");
        remoteControl.pressButton(1);
    }
}