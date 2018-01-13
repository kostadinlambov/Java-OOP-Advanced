package p06_Birthday_Celebrations;


public class Pet implements Birthday {

    private String birthday;

    Pet(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean checkYearOfBirth(String yearToCompare) {
        if (birthday.endsWith(yearToCompare)) {
            return true;
        }
        return false;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }
}
