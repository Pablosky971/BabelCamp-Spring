package controller;


import java.util.Calendar;
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

import dto.CuentaDto;
import dto.MovimientoDto;
import service.CajeroService;

@CrossOrigin("*")
@Controller
public class CajeroController {
	
	@Autowired
	CajeroService service;
	
	@PostMapping(value="Login",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CuentaDto login(@RequestParam("numeroCuenta") int numeroCuenta) {
		return service.validarCuenta(numeroCuenta);
	}

	@PostMapping(value="Ingreso",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void ingreso(@RequestParam("numeroCuenta") int numeroCuenta, @RequestParam("cantidad") double cantidad) {
		MovimientoDto m = new MovimientoDto();
		m.setCantidad(cantidad);
		Calendar fecha = Calendar.getInstance();
		m.setFecha(Date.from(fecha.toInstant()));
		m.setCuenta(service.validarCuenta(numeroCuenta));
		service.ingreso(m);
	}
	
	@PostMapping(value="Extraccion",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void extraccion(@RequestParam("numeroCuenta") int numeroCuenta, @RequestParam("cantidad") double cantidad) {
		MovimientoDto m = new MovimientoDto();
		m.setCantidad(cantidad);
		Calendar fecha = Calendar.getInstance();
		m.setFecha(Date.from(fecha.toInstant()));
		m.setCuenta(service.validarCuenta(numeroCuenta));
		service.extraccion(m);
	}
	
	@PostMapping(value="Transferencia",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void transferencia(@RequestParam("numeroCuentaRemitente") int numeroCuentaRemitente, @RequestParam("numeroCuentaDestinatario") int numeroCuentaDestinatario, @RequestParam("cantidad") double cantidad) {
		MovimientoDto ingreso = new MovimientoDto();
		ingreso.setCantidad(cantidad);
		Calendar fecha = Calendar.getInstance();
		ingreso.setFecha(Date.from(fecha.toInstant()));
		ingreso.setCuenta(service.validarCuenta(numeroCuentaRemitente));
		
		MovimientoDto extraccion = new MovimientoDto();
		extraccion.setCantidad(cantidad);
		ingreso.setFecha(Date.from(fecha.toInstant()));
		extraccion.setCuenta(service.validarCuenta(numeroCuentaDestinatario));
		
		service.transferencia(ingreso,extraccion);
		
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


