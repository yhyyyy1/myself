package Prototype;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Resume rt = new Resume("test");
        ResumeTemplate template = new ResumeTemplate("photo", rt);
        System.out.println(template.toString());

        //浅克隆
        ResumeTemplate cloneTemplate = (ResumeTemplate) template.cloneShallow();
        cloneTemplate.setPhoto("new");
        cloneTemplate.setName("new");

        Resume rt2 = new Resume("test2");
        ResumeTemplate template2 = new ResumeTemplate("photo2", rt2);
        //深克隆
        ResumeTemplate cloneTemplate2 = (ResumeTemplate) template2.cloneDeep();
        cloneTemplate2.setPhoto("new2");
        cloneTemplate2.setName("new2");
        System.out.println("是");
        System.out.println("原" + template.toString());
        System.out.println(cloneTemplate.toString());

        System.out.println("否");
        System.out.println("原" + template2.toString());
        System.out.println(cloneTemplate2.toString());
    }
}
