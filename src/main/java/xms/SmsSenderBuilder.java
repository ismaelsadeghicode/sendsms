package xms;

public class SmsSenderBuilder {

    public static SmsSender build(String username, String password) {
        SmsSender sms = new SmsSender(username, password);
        return sms;
    }
}