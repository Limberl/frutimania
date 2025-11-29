package com.frutimania.controllers;

/**
 *
 * @author José Castillo
 */
import com.frutimania.models.Producto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportesController {

    public void exportarReporteProductosTxt(List<Producto> productos, String rutaArchivo) throws IOException {

        String rutaReal = new File(".").getCanonicalPath() + File.separator + rutaArchivo;
        
        try (FileWriter fw = new FileWriter(rutaReal)) {
            fw.write("Reporte de productos\n");
            fw.write("====================\n\n");
            for (Producto p : productos) {
                fw.write(p.toString() + "\n");
            }
        }
    }
}
