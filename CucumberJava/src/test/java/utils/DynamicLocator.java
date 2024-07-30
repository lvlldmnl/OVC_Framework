package utils;

public class DynamicLocator {
    // Method to generate dynamic locator
    public static String generateLocator(String locatorTemplate, String parameter) {
        // Replace placeholder in locator template with parameter
        return String.format(locatorTemplate, parameter);
    }

    // Method to generate dynamic locator with dynamic text value
    public static String generateLocatorWithDynamicText(String locatorTemplate, String dynamicText) {
        // Replace placeholder with dynamic text value
        return String.format(locatorTemplate, dynamicText);
    }
}