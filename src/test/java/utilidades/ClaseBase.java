package utilidades;

import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClaseBase {
	private WebDriver driver;

	public ClaseBase(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public WebDriver ConexionChromeDriver(){
		String path = Paths.get(System.getProperty("user.dir"),"src/test/resources/Drivers/chromedriver.exe").toString();
		System.setProperty("webdriver.chrome.driver", path);
		
		driver =new ChromeDriver();
		return driver;
	}
	
	public WebElement buscarElementoWeb(By localizador){
		
		return driver.findElement(localizador);
	}
	
	public List<WebElement> buscarElementosWeb(By localizador){
		return driver.findElements(localizador);
	}
	
	public void cerrarBrowser(){
		try {
			driver.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public String obtenerTexto(By localizador){
		return driver.findElement(localizador).getText();
	}
	
	public void agregarTexto(String input,By localizador){
		try {
			driver.findElement(localizador).sendKeys(input);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void clic(By localizador){
		try {
			driver.findElement(localizador).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public boolean estaDesplegado(By localizador){
		try {
			return driver.findElement(localizador).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
			// TODO: handle exception
		}
	}
	
	public void visitarSitio(String url){
		try {
			driver.get(url);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void esperar3seg(){
		//Implicit wait desde el driver
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
