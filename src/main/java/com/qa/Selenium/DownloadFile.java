/*
 * package com.qa.Selenium;
 * 
 * import java.util.HashMap;
 * 
 * import org.openqa.selenium.chrome.ChromeOptions; import
 * org.openqa.selenium.remote.DesiredCapabilities;
 * 
 * public class DownloadFile {
 * 
 * public static void main(String[] args) {
 * 
 * String downloadFilepath = “c:\\download”; HashMap<String, Object> chromePrefs
 * = new HashMap<String, Object>();
 * chromePrefs.put(“profile.default_content_settings.popups”, 0);
 * chromePrefs.put(“download.default_directory”, downloadFilepath);
 * ChromeOptions options = new ChromeOptions(); HashMap<String, Object>
 * chromeOptionsMap = new HashMap<String, Object>();
 * options.setExperimentalOption(“prefs”, chromePrefs);
 * options.addArguments(“–test-type”);
 * options.addArguments(“–disable-extensions”); //to disable browser extension
 * popup DesiredCapabilities cap = DesiredCapabilities.chrome();
 * cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
 * cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
 * cap.setCapability(ChromeOptions.CAPABILITY, options); driver = new
 * ChromeDriver(cap); driver.get(“http://www.seleniumhq.org/download/”); }
 * 
 * }
 */