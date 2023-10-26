package Builder;

public interface CarBuilder {
    public abstract void buildBody();

    public abstract void buildEngine();

    public abstract void buildTires();

    public abstract void buildTransmission();

    public abstract Car getResult();
}
