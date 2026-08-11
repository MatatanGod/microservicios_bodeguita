package com.bodeguita.ms_venta.model.dto;

public class VentaResponse {

    private Long id_venta;
    private String fecha;
    private String codigo_unico;
    private double sub_total;
    private double igb;
    private double total;
    private String metodo_pago;

    public VentaResponse() {
    }

    public VentaResponse(Long id_venta, String fecha, String codigo_unico, double sub_total, double igb, double total, String metodo_pago) {
        this.id_venta = id_venta;
        this.fecha = fecha;
        this.codigo_unico = codigo_unico;
        this.sub_total = sub_total;
        this.igb = igb;
        this.total = total;
        this.metodo_pago = metodo_pago;
    }

    public Long getId_venta() {
        return id_venta;
    }

    public void setId_venta(Long id_venta) {
        this.id_venta = id_venta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCodigo_unico() {
        return codigo_unico;
    }

    public void setCodigo_unico(String codigo_unico) {
        this.codigo_unico = codigo_unico;
    }

    public double getSub_total() {
        return sub_total;
    }

    public void setSub_total(double sub_total) {
        this.sub_total = sub_total;
    }

    public double getIgb() {
        return igb;
    }

    public void setIgb(double igb) {
        this.igb = igb;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }
}
