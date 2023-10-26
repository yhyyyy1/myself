package Prototype;

public class ResumeTemplate implements Cloneable {
    private String photo;

    private Resume resume;

    public ResumeTemplate(String photo, Resume resume) {
        this.photo = photo;
        this.resume = resume;
    }

    protected Object cloneShallow() throws CloneNotSupportedException {
        ResumeTemplate rt = (ResumeTemplate) super.clone();
        return rt;
    }

    protected Object cloneDeep() throws CloneNotSupportedException {
        ResumeTemplate rt = (ResumeTemplate) super.clone();
        rt.resume = (Resume) rt.resume.clone();
        return rt;
    }

    @Override
    public String toString() {
        return "简历：照片" + photo + "名字" + resume.getName();
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setName(String name) {
        this.resume.setName(name);
    }
}
