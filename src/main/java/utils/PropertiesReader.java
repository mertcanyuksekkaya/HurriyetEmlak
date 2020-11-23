package utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

public class PropertiesReader {
    private static Properties properties;

    public PropertiesReader() {

    }

    static {
        properties = new Properties();
        try {
            InputStream propertiesStream = DriverManager.class.getClassLoader().getResourceAsStream("configuration.properties");
            properties.load(new InputStreamReader(propertiesStream, Charset.forName("UTF-8")));
            propertiesStream.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static String getReportConfigPath(){
        String reportConfigPath = properties.getProperty("reportConfigPath");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }

    public static String getBrowser() {
        if(System.getProperty("Browser") != null){
            return System.getProperty("Browser");
        }else{
            return properties.getProperty("Browser");
        }
    }


    public static String getDevice() {
        if(System.getProperty("Device") != null){
            return System.getProperty("Device");
        }else{
            return properties.getProperty("Device");
        }
    }

    public static String getParallelMethod() { return properties.getProperty("ParallelMethod");    }

    public static String getGridLink() { return properties.getProperty("GridLink");    }

    public static String getEnvironment() { return properties.getProperty("Environment");    }

    public static String getHeadless() {
        if(System.getProperty("Headless") != null){
            return System.getProperty("Headless");
        }else{
            return properties.getProperty("Headless");
        }
    }

    public static String getUrl() {
        if (System.getProperty("Environment") != null) {
            //System.out.println(System.getProperty("Environment") + ".url");
            return properties.getProperty(System.getProperty("Environment") + ".url");
        } else {
            return properties.getProperty(getEnvironment() + ".url");
        }
    }
    
    public static String getUser() { return properties.getProperty("user"); }
    
    public static String getPassword() { return properties.getProperty("password"); }

    public static String getLocation() { return properties.getProperty("location"); }

    public static String getCultureLocation() { return properties.getProperty("cultureLocation"); }

    public static String getAbroadLocation() { return properties.getProperty("abroadLocation"); }

    public static String getAirport() { return properties.getProperty("airport"); }

    public static String getAdultCount() { return properties.getProperty("adultCount"); }

    public static int getNextday() { return Integer.parseInt(properties.getProperty("nextDay")); }

    public static int gethowManyDay() { return Integer.parseInt(properties.getProperty("howManyDay")); }

    public static String getGuestPhone() { return properties.getProperty("guestPhone"); }

    public static String getGuestMail() { return properties.getProperty("guestMail"); }

    public static String getGuestCity() { return properties.getProperty("guestCity"); }

    public static String getGuestAddress() { return properties.getProperty("guestAddress"); }

    public static String getGuest1Name() { return properties.getProperty("guest1name"); }

    public static String getGuest1SurName() { return properties.getProperty("guest1surname"); }

    public static String getGuest1birthDate() { return properties.getProperty("guest1birthdate"); }

    public static String getGuest1Tc() { return properties.getProperty("guest1tc"); }

    public static String getGuest1Gender() { return properties.getProperty("guest1gender"); }

    public static String getGuest1passport() { return properties.getProperty("guest1Passport"); }

    public static String getGuest1passportDate() { return properties.getProperty("guest1PassportDate"); }

    public static String getGuest2Name() { return properties.getProperty("guest2name"); }

    public static String getGuest2SurName() { return properties.getProperty("guest2surname"); }

    public static String getGuest2birthDate() { return properties.getProperty("guest2birthdate"); }

    public static String getGuest2Tc() { return properties.getProperty("guest2tc"); }

    public static String getGuest2Gender() { return properties.getProperty("guest2gender"); }

    public static String getGuest2passport() { return properties.getProperty("guest2Passport"); }

    public static String getGuest2passportDate() { return properties.getProperty("guest2PassportDate"); }

    public static String getcreditCardNumber() { return properties.getProperty("creditcardnumber"); }

    public static String getcreditCardNumber2() { return properties.getProperty("creditcardnumber2"); }

    public static String getcreditCardUsername() { return properties.getProperty("creditcardusername"); }

    public static String getcreditCardCvv() { return properties.getProperty("creditcardcvv"); }

    public static String getDeviceInformation(){return  properties.getProperty("device");}
}
