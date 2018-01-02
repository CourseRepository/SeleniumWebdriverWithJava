package testcase;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestYoutubeLinux {
	
	private static Random index = new Random();
	private static Random delay = new Random();

	public static void main(String[] args) throws InterruptedException {
				
		String []link = {"https://www.youtube.com/watch?v=Vuwpq2haaaQ",
				"https://www.youtube.com/watch?v=L7rxTiWNEHM",
				"https://www.youtube.com/watch?v=wb_n9AOixsQ",
				"https://www.youtube.com/watch?v=37A-vHYkr38",
				"https://www.youtube.com/watch?v=cmvhOzgVTOk",
				"https://www.youtube.com/watch?v=WwlLNFTDwes",
				"https://www.youtube.com/watch?v=MXYKQNSco4o",
				"https://www.youtube.com/watch?v=kKxAEJmBbs0",
				"https://www.youtube.com/watch?v=ClRyaaG4C14",
				"https://www.youtube.com/watch?v=9T9d7MiLTtA",
				"https://www.youtube.com/watch?v=6MkE5uPoqBE",
				"https://www.youtube.com/watch?v=hvHL0XWEIUQ",
				"https://www.youtube.com/watch?v=55FrzcuV6wE",
				"https://www.youtube.com/watch?v=7XBd6psCV9g",
				"https://www.youtube.com/watch?v=SvhdY9hwSMs",
				"https://www.youtube.com/watch?v=AdQc_rqhk9w",
				"https://www.youtube.com/watch?v=Lc6x-rzoB_E",
				"https://www.youtube.com/watch?v=v2PZnAqBtec",
				"https://www.youtube.com/watch?v=cXGuhXEEJYU",
				"https://www.youtube.com/watch?v=8fM7SoWPaCU",
				"https://www.youtube.com/watch?v=SkDh-rgxc2U",
				"https://www.youtube.com/watch?v=psQjN5K_NOo"
		};
		
		int count = 1;
		
		for(int i = 0; i < link.length; i++){
			while(count < 250 ){
				WebDriver driver = new FirefoxDriver();
				Thread.sleep(3000);
				String lik = link[index.nextInt(22)];
				System.out.println("Link Generated : " + lik);
				driver.get(lik);
				Thread.sleep(3000);
				driver.findElement(By.id("watch-like")).click();
				int del = delay.nextInt(30000);
				System.out.println("Deleay Generated : " + del);
				Thread.sleep(del);
				driver.quit();
				Thread.sleep(2000);
				System.out.println("Count : " + count++);
			
			}
			count = 0;

		}
		
	}
}
