package cresla;

public class SingleIdObject {

    private int id;


    private static SingleIdObject idInstance = new SingleIdObject();

    public static SingleIdObject getInstance() {
        return idInstance;
    }

    private SingleIdObject() {
        this.id = 0;
    }

    public int getId(){
       return  ++this.id;
    }
}
