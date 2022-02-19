import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class App{

    public static void main(String[] args) throws InterruptedException {
        
        System.setProperty("webdriver.chrome.driver", "D:/seleniumJavaVSC/seleniumTable/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost/seleTable/");
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement trxIdShowed = driver.findElement(By.xpath("//td[contains(text(),'01023A9AC')]"));
        String trxIdReceipt = trxIdShowed.getText();

        WebElement sellerShowed = driver.findElement(By.xpath("//p[contains(text(),'Furhan')]"));
        String sellerReceipt = sellerShowed.getText();

        WebElement delivServiceShowed = driver.findElement(By.xpath("//p[contains(text(),'TIKI')]"));
        String delivServiceReceipt = delivServiceShowed.getText();

        WebElement dateShowed = driver.findElement(By.xpath("//p[contains(text(),'21/08/2016')]"));
        String dateReceipt = dateShowed.getText();

        WebElement addressShowed = driver.findElement(By.xpath("//p[contains(text(),'KAMPUNG DATOK KERAMAT')]"));
        String addressReceipt = addressShowed.getText();

        WebElement table= driver.findElement(By.xpath("//body/table[1]"));
        List<WebElement> row_table = table.findElements(By.tagName("tr"));
        String row_xpath = "//tbody/tr[";
        String trxIdDataTable_xpath = "]/td[1]";

        int row_number = row_table.size();

        for (int rowStart = 2; rowStart <= row_number; rowStart++) {
            String n = driver.findElement(By.xpath(row_xpath + rowStart + trxIdDataTable_xpath)).getText();
            if(trxIdReceipt.contains(n)){
                String addressDb=driver.findElement(By.xpath("//tbody/tr["+rowStart+"]/td[2]")).getText();
                String dateDb=driver.findElement(By.xpath("//tbody/tr["+rowStart+"]/td[3]")).getText();
                String sellerDb=driver.findElement(By.xpath("//tbody/tr["+rowStart+"]/td[4]")).getText();
                String delivServiceDb=driver.findElement(By.xpath("//tbody/tr["+rowStart+"]/td[5]")).getText();

                if(addressReceipt.toLowerCase().contains(addressDb.toLowerCase())){
                    System.out.println("address is match! real address: " + addressDb + " , " + addressReceipt);
                } else {
                    System.out.println("address not match :( real address: " + addressDb + " , " + addressReceipt);
                }   

                if(dateReceipt.contains(dateDb)){
                    System.out.println("date is match! real date order: " + dateDb + " , " + dateReceipt);
                } else {
                    System.out.println("date not match :( real date order: " + dateDb + " , " + dateReceipt);
                }  

                if(sellerReceipt.toLowerCase().contains(sellerDb.toLowerCase())){
                    System.out.println("seller is match! real seller: " + sellerDb + " , " + sellerReceipt);
                } else {
                    System.out.println("seller not match :( real seller: " + sellerDb + " , " + sellerReceipt);
                } 

                if(delivServiceReceipt.toLowerCase().contains(delivServiceDb.toLowerCase())){
                    System.out.println("delivery service is match! real delivery service: " + delivServiceDb + " , " + delivServiceReceipt);
                } else {
                    System.out.println("delivery service not match :( real delivery service: " + delivServiceDb + " , " + delivServiceReceipt);
                } 
               
            }
        }

        driver.quit();     

    }


}