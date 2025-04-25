package com.tallerwebi.presentacion.entrenamiento2ej2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductoController {

private List<ProductoDto> productos;

public ProductoController() {
    this.productos = new ArrayList<ProductoDto>();

    productos.add(new ProductoDto(1L, "Producto 1", 10.3));
    productos.add(new ProductoDto(2L, "Producto 2", 30.3));
    productos.add(new ProductoDto(3L, "Producto 3", 40.3));
}

@GetMapping("/productos")
public ModelAndView listarProductos(){
    ModelMap model = new ModelMap();

    model.put("productos", this.productos);
    return new ModelAndView("productos", model);
}

    public List<ProductoDto> getProductos() {
        return productos;
    }


    @GetMapping("/productos")
    public ModelAndView verDetalle(Long id) {
    ModelMap model = new ModelMap();

    Long productoBuscado = buscarPorId(id);
    if(productoBuscado != null) {
        model.put("producto", productoBuscado);
    } else {
        model.put("mensaje", "No se encontro el producto");
    }
        return new ModelAndView("detalleProducto", model);
    }

    private Long buscarPorId(Long id) {
        for (ProductoDto productoDto : this.productos) {
            if (productoDto.getId().equals(id)) {
                return productoDto.getId();
            }
        }
        return null;
    }
}


