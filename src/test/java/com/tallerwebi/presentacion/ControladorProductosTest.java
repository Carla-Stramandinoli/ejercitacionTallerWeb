package com.tallerwebi.presentacion;

import com.tallerwebi.presentacion.entrenamiento2ej2.ProductoController;
import com.tallerwebi.presentacion.entrenamiento2ej2.ProductoDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ControladorProductosTest {

    public ProductoController productoController;

    @BeforeEach
    public void init() {
        productoController = new ProductoController();
    }

    @Test
    public void dadoQueExisteUnProductoControllerDeberiaPoderListarTodosLosProductos(){
        ModelAndView modelAndView =  productoController.listarProductos();

        String vistaEsperada = "productos";

        List<ProductoDto> productosEsperados = new ArrayList<>();
        productosEsperados.add(new ProductoDto(1L, "Producto 1", 10.3));
        productosEsperados.add(new ProductoDto(2L, "Producto 2", 30.3));
        productosEsperados.add(new ProductoDto(3L, "Producto 3", 40.3));

        List<ProductoDto> productosObtenidos = productoController.getProductos();

        assertThat(modelAndView.getViewName(), equalTo(vistaEsperada));
        assertThat(productosEsperados, equalTo(productosObtenidos));

    }

    @Test
    public void dadoQueExisteUnProductoControllerCuandoOprimoVerDetalleDeberiaMostrarmeElDetalleDelProducto(){
        Long id = 1L;
        ModelAndView modelAndView =  productoController.verDetalle(id);



        String vistaEsperada = "detalle";

        assertThat(modelAndView.getViewName(), equalTo(vistaEsperada));
        assertThat(modelAndView.getModelMap().get("producto"), equalTo(id));

    }
}


