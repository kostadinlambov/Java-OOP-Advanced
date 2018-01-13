package p05_security_system;

public class KeyCardCheck extends SecurityCheck implements KeyCardUI{

    private PinCodeUI securityUI;

    public KeyCardCheck(PinCodeUI securityUI) {
        this.securityUI = securityUI;
    }

    private boolean isValid(String code) {
        return true;
    }

    @Override
    public String requestKeyCard() {
        return "slide your key card";
    }
}
