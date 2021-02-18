package com.mitocode.model;

public class DetalleVenta {
	
	private Integer idDetalleVenta;
	private Venta v;
	private Producto p;
	private Integer cantidad;
	
	//---------------------------Getters and Setters--------------------------
	public Integer getIdDetalleVenta() {
		return idDetalleVenta;
	}
	public void setIdDetalleVenta(Integer idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}
	public Venta getV() {
		return v;
	}
	public void setV(Venta v) {
		this.v = v;
	}
	public Producto getP() {
		return p;
	}
	public void setP(Producto p) {
		this.p = p;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
