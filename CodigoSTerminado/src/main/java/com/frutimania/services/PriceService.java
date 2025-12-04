
package com.frutimania.services;

/**
 *
 * @author José Castillo
 */
public class PriceService {

    /**
     * Calcula un precio recomendado basado en:
     * - Costo de compra
     * - Margen de ganancia deseado (%)
     * - Precio promedio del mercado
     */
    public double calculateSuggestedPrice(double cost, double marginPercent, double marketPrice) {
        double priceWithMargin = cost + (cost * (marginPercent / 100));

        // Ajuste según mercado
        double suggested = (priceWithMargin + marketPrice) / 2;

        return Math.round(suggested * 100.0) / 100.0;
    }
}
