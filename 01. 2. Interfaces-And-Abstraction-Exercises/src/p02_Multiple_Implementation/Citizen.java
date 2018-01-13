package p02_Multiple_Implementation;

public class Citizen implements Person, Birthable, Identifiable {

    private String name;
    private int age;
    private String id;
    private String birthdate;
    private String birthday;

    Citizen(String name, int age, String id, String birthdate) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
        this.setBirthday(birthdate);
    }

    // @Override
    private void setName(String name) {
        this.name = name;
    }

    // @Override
    private void setAge(int age) {
        this.age = age;
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String getBirthdate() {
        return this.birthdate;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
