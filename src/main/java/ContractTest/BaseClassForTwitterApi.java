package ContractTest;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClassForTwitterApi {

    String ConsumerKey="KyjxKL5Zl8yDH1SgyxHuTSzNq";
    String ConsumerSecret="wWlSVCm1VSg4ekhPMxFesdnTOVc4xxvRI6UnyMzbTtmlEUZqik";
    String Token="2395903569-qYqZWuGIU019IcjtCE3To0U5lDUOcoWxFhPiwJ1";
    String TokenSecret="NaEp2kU1R3uOeBFL3Lj9QOZ6rzphn2aJZDCMvPcswwq9V";
    String id;
    Properties properties = new Properties();

    @BeforeTest
    public String getBaseUri() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/monilj/Downloads/Devlopment/TescoRepos/ContractTestOld/src/main/resources/env.properties");
        properties.load(fileInputStream);
        String baseUri =properties.getProperty("twitterApiHost");
        return baseUri;
    }

}
