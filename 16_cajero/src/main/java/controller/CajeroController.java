package controller;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import dto.MovimientoDto;
import service.CajeroService;

@CrossOrigin("*")
@Controller
public class CajeroController {
	
	@Autowired
	CajeroService service;
	
	@PostMapping(value="Login",produces=MediaType.APPLICATION_JSON_VALUE)
	public String login(@RequestParam("numeroCuenta") int numeroCuenta) {
		if(service.validarCuenta(numeroCuenta)) {
			return "index";
		} else {
			return "error";
		}
		
			
	}

	@PostMapping(value="Ingreso",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void ingreso(@RequestParam("cantidad") double cantidad, @RequestParam("numeroCuenta") int numeroCuenta) {
		
		service.ingreso(cantidad,numeroCuenta);
	}
	
	@PostMapping(value="Extraccion",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void extraccion(@RequestParam("cantidad") double cantidad, @RequestParam("numeroCuenta") int numeroCuenta) {
		
		service.extraccion(cantidad,numeroCuenta);
	}
	
	@PostMapping(value="Transferencia",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void transferencia(@RequestParam("cantidad") double cantidad, @RequestParam("numeroCuentaRemitente") int numeroCuentaRemitente, @RequestParam("numeroCuentaDestinatario") int numeroCuentaDestinatario) {
		
		
		service.transferencia(cantidad,numeroCuentaRemitente,numeroCuentaDestinatario);
		
	}
	
	
	
	@GetMapping(value="Movimientos",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<MovimientoDto> movimientos(@RequestParam("fechaInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
			@RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin,
			@RequestParam("numeroCuenta") int numeroCuenta) {
		return service.movimientos(fechaInicio, fechaFin, numeroCuenta);
	}
	
	
	
	@GetMapping(value="SaldoCuenta",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody double saldoCuenta(@RequestParam("numeroCuenta") int numeroCuenta) {
		return service.saldoCuenta(numeroCuenta);
	}
	
	

}


