package p04_Telephony;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {

    Smartphone() { }

    @Override
    public void browseInWeb(String url) {
        Pattern regex = Pattern.compile("^(\\D*)$");
        Matcher matcher = regex.matcher(url);

        if (matcher.find()) {
            System.out.printf("Browsing: %s!%n", matcher.group(0));
        } else {
            System.out.println("Invalid URL!");
        }
    }

    @Override
    public void callPhones(String number) {
        Pattern regex = Pattern.compile("^\\d*$");
        Matcher matcher = regex.matcher(number);

        if (matcher.find()) {
            System.out.printf("Calling... %s%n", matcher.group(0));
        } else {
            System.out.println("Invalid number!");
        }
    }
}
