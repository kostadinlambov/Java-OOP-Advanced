package p06_Birthday_Celebrations;

public class Citizen implements Birthday {
    private String birthday;

    Citizen(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean checkYearOfBirth(String yearToCompare) {
        if (this.birthday.endsWith(yearToCompare)) {
            return true;
        }
        return false;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }
}
