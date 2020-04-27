package com.ricardogeek.controllers;

import com.ricardogeek.generator.BarcodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.awt.image.BufferedImage;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@RestController
public class BarCodesController {

    @GetMapping(value = "/barcodes/{type}/{barcode}", produces = IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> generate(@PathVariable("type") final String type,
                                                  @PathVariable("barcode") final String barcodeText,
                                                  @Autowired BarcodeGenerator barcodeGenerator) {

        try {
            switch (type) {
                case "EAN13":
                    // 978020137962
                    return ok(barcodeGenerator.generateEAN13BarcodeImage(barcodeText));
                case "UPC":
                    // 12345678901
                    return ok(barcodeGenerator.generateUPCBarcodeImage(barcodeText));
                case "EAN128":
                    // 0101234567890128TEC
                    return ok(barcodeGenerator.generateEAN128BarCodeImage(barcodeText));
                case "CODE128":
                    // any-string
                    return ok(barcodeGenerator.generateCode128BarCodeImage(barcodeText));
                case "USPS":
                    // 123456789
                    return ok(barcodeGenerator.generateUSPSBarcodeImage(barcodeText));
                case "SCC14":
                    return ok(barcodeGenerator.generateSCC14ShippingCodeBarcodeImage(barcodeText));
                case "CODE39":
                    return ok(barcodeGenerator.generateCode39BarcodeImage(barcodeText));
                case "GTIN":
                    return ok(barcodeGenerator.generateGlobalTradeItemNumberBarcodeImage(barcodeText));
                default:
                    return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }

    private ResponseEntity<BufferedImage> ok(final BufferedImage bufferedImage) {
        return new ResponseEntity<>(bufferedImage, OK);
    }
}
