// file: Productos

package TiendaVirtual.Productos.entity;

import java.math.BigInteger;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Productos")
public class Productos { // class start
    // program start
    
    @Id
    private BigInteger codigo_producto;
    @Field("iva_compra")
    private Double iva_compra;
    @Field("nit_proveedor")
    private BigInteger nit_proveedor;
    @Field("nombre_producto")
    private String nombre_producto;
    @Field("precio_compra")
    private Double precio_compra;
    @Field("precio_venta")
    private Double precio_venta;

    
    
    public Productos(BigInteger codigo_producto, Double iva_compra, BigInteger nit_proveedor, String nombre_producto, Double precio_compra, Double precio_venta) {
        this.codigo_producto = codigo_producto;
        this.iva_compra = iva_compra;
        this.nit_proveedor = nit_proveedor;
        this.nombre_producto = nombre_producto;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
    }
    /*
    @Override
    public String toString() {
        return "Productos{" + "codigo_producto=" + codigo_producto + ", iva_compra=" + iva_compra + ", nit_proveedor=" + nit_proveedor + ", nombre_producto=" + nombre_producto + ", precio_compra=" + precio_compra + ", precio_venta=" + precio_venta + '}';
    }
    
    */
    
    
} // End of class 
