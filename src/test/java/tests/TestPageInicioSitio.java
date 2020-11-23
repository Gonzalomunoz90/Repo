package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.PageInicioSiteBCI;

public class TestPageInicioSitio {
	private WebDriver driver;
	PageInicioSiteBCI pageInicioSitioBCI;

	@BeforeTest
	public void before() {
		pageInicioSitioBCI = new PageInicioSiteBCI(driver);
		driver = pageInicioSitioBCI.ConexionChromeDriver();
		pageInicioSitioBCI.visitarSitio("https://www.bci.cl/personas");
	}

	@Test
	public void validarCtaBloqueda() {
		pageInicioSitioBCI.Login();
		Assert.assertEquals(pageInicioSitioBCI.obtenerMensajeCtaBloqueada(),"Clave de Internet bloqueada");
	}
}
