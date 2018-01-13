package p10_MooD_3;

public abstract class BaseGameObject implements GameObjectInt {
    private String username;
    private String hashedPassword;
    private int level;


    protected BaseGameObject(String username, int level) {
        this.username = username;
        this.level = level;
        this.hashedPassword = this.getHashPassword();
    }

    protected int getLevel() {
        return this.level;
    }

    protected String getUsername() {
        return this.username;
    }

    protected abstract String getHashPassword();

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("\"%s\" | \"%s\" -> %s", this.username,
                this.getHashPassword(), this.getClass().getSimpleName()))
                .append(System.lineSeparator());
        return sb.toString();
    }
}
