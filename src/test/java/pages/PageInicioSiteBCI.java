package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilidades.ClaseBase;

public class PageInicioSiteBCI extends ClaseBase {
	// Crear los localizadores del sitio (By)

	// Localizador botón banco en linea
	By localorBtnBcoEnLinea = By.partialLinkText("Banco en Lín");

	// localizador textbox rut
	By locatorInputRut = By.id("rut_aux");

	// localizador textbox rut
	By locatorInputClave = By.id("clave");

	// localizador botón ingresar
	By locatorBtnIngresar = By.xpath("//input[@class='submit btn btn-primary btn-block']");
	
	By locatorMensajeCtaBloqueada = By.cssSelector("body.context-layouts.context-layouts-show.context-layouts-show-clave_bloqueada:nth-child(2) div.main-full div.main-inner div.widget.widget-text.widget-full div.container.container-error:nth-child(3) div.row div.col-xs-12 div.card-error.bci-card > h6.headline.grey-text:nth-child(2)");

	public PageInicioSiteBCI(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void Login(){
		clic(localorBtnBcoEnLinea);
		esperar3seg();
		agregarTexto("178152513", locatorInputRut);
		esperar3seg();
		agregarTexto("12345678", locatorInputClave);
		esperar3seg();
		clic(locatorBtnIngresar);
		esperar3seg();
	}

	public String obtenerMensajeCtaBloqueada(){
		return obtenerTexto(locatorMensajeCtaBloqueada);
	}
	
}
