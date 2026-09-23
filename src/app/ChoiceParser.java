package app;

public class ChoiceParser {
    public static DeliveryMode parseDeliveryMode(String input) throws InvalidChoiceException {
        switch (input.toUpperCase()) {
            case "ROAD": return DeliveryMode.ROAD;
            case "SEA": return DeliveryMode.SEA;
            default: throw new InvalidChoiceException("Invalid delivery mode: " + input);
        }
    }

    public static UiPlatform parseUiPlatform(String input) throws InvalidChoiceException {
        switch (input.toUpperCase()) {
            case "WINDOWS": return UiPlatform.WINDOWS;
            case "MACOS": return UiPlatform.MACOS;
            default: throw new InvalidChoiceException("Invalid UI platform: " + input);
        }
    }
}
