package com.escalab.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class CompraProductoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_venta", nullable = false)
    private Venta venta;
    
    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CompraProductoPK that = (CompraProductoPK) o;

		if (venta != null ? !venta.equals(that.venta) : that.venta != null) return false;
		return producto != null ? producto.equals(that.producto) : that.producto == null;
	}

	@Override
	public int hashCode() {
		int result = venta != null ? venta.hashCode() : 0;
		result = 31 * result + (producto != null ? producto.hashCode() : 0);
		return result;
	}
}
