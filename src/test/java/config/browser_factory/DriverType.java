package config.browser_factory;


public class DriverType {
    // Define the default browser as Chrome
    public static Browsers browser = Browsers.CHROME;

    // Enum to define the available browsers
    public enum Browsers{
        CHROME,
        FIREFOX
    }
}
