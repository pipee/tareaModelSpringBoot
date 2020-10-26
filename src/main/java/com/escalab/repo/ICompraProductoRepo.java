package com.escalab.repo;

import com.escalab.model.CompraProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICompraProductoRepo extends JpaRepository<CompraProducto, Long> {

    @Query("from CompraProducto cp where cp.venta.idVenta =:idVenta")
    List<CompraProducto> listarProductosPorCompra(@Param("idVenta") Long idVenta);

    @Modifying
    @Query(value = "INSERT INTO compra_producto(id_venta, id_producto) VALUES (:idVenta, :idProducto)", nativeQuery = true)
    Long registrar(@Param("idVenta") Long idVenta, @Param("idProducto") Long idProducto);
}
