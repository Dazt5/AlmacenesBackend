package com.market.app.sales_reports.dto;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.market.app.sales_reports.entity.DetalleVentas;
import com.market.app.sales_reports.entity.Sale;

public class SaleRequestDTO {

    @PositiveOrZero(message = "La cedula del cliente tiene que ser mayour o igual a 0")
    @JsonProperty("cedula_cliente")
    private BigInteger cedula_cliente;

    @PositiveOrZero(message = "El iva a aplicar tiene que ser mayor o igual a 0")
    @JsonProperty("ivaventa")
    private Double ivaventa;

    @PositiveOrZero(message = "El valor de la venta tiene que ser mayor o igual a 0")
    @JsonProperty("valor_venta")
    private Double valor_venta;

    @PositiveOrZero(message = "El valor total de venta tiene que ser mayor o igual a 0")
    @JsonProperty("total_venta")
    private Double total_venta;

    @NotEmpty(message = "el array del detalle de las ventas se encuentra vacio")
    @JsonProperty("detalleVenta")
    private List<DetalleVentas> detalleVenta;

    // instancia de la entidad
    @JsonIgnore
    Sale sale = new Sale();

    public SaleRequestDTO() {

    }

    public SaleRequestDTO(BigInteger codigo_venta,
                          @PositiveOrZero(message = "La cedula del cliente tiene que ser mayour o igual a 0") BigInteger cedula_cliente,
                          @PositiveOrZero(message = "El detalle de la venta tiene que ser mayour o igual a 0") BigInteger detalle_venta,
                          @PositiveOrZero(message = "El iva a aplicar tiene que ser mayor o igual a 0") Double ivaventa,
                          @PositiveOrZero(message = "El valor de la venta tiene que ser mayor o igual a 0") Double valor_venta,
                          @PositiveOrZero(message = "El valor total de venta tiene que ser mayor o igual a 0") Double total_venta,
                          @NotEmpty(message = "el array del detalle de las ventas se encuentra vacio") List<DetalleVentas> detalleVenta) {
        super();
        this.cedula_cliente = cedula_cliente;
        this.ivaventa = ivaventa;
        this.valor_venta = valor_venta;
        this.total_venta = total_venta;
        this.detalleVenta = detalleVenta;
    }

    public BigInteger getCedula_cliente() {
        return cedula_cliente;
    }

    public void setCedula_cliente(BigInteger cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }


    public Double getIvaventa() {
        return ivaventa;
    }

    public void setIvaventa(Double ivaventa) {
        this.ivaventa = ivaventa;
    }

    public Double getValor_venta() {
        return valor_venta;
    }

    public void setValor_venta(Double valor_venta) {
        this.valor_venta = valor_venta;
    }

    public Double getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(Double total_venta) {
        this.total_venta = total_venta;
    }

    public List<DetalleVentas> getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(List<DetalleVentas> detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    public Sale toEntity() {
        sale.setCedula_cliente(this.getCedula_cliente());
        sale.setIvaventa(this.getIvaventa());
        sale.setValor_venta(this.getValor_venta());
        sale.setTotal_venta(this.getTotal_venta());

        List<DetalleVentas> detalle_venta = new ArrayList<>(this.detalleVenta);

        this.sale.setDetalleVenta(detalle_venta);
        return sale;
    }

    @Override
    public String toString() {
        return "SaleRequestDTO [" +
                ", cedula_cliente=" + cedula_cliente +
                ", ivaventa=" + ivaventa +
                ", valor_venta=" + valor_venta +
                ", total_venta=" + total_venta +
                ", detalleVenta=" + detalleVenta + "]";
    }

}
