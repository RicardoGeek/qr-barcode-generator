package com.ricardogeek.generator;

import java.awt.Font;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import java.awt.image.BufferedImage;

public class BarcodeGenerator {

    public BufferedImage generateEAN13BarcodeImage(final String barcodeText) throws Exception {
        final Barcode barcode = BarcodeFactory.createEAN13(barcodeText);
        barcode.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));

        return BarcodeImageHandler.getImage(barcode);
    }

    public BufferedImage generateUPCBarcodeImage(final String barcodeText) throws Exception {
        final Barcode barcode = BarcodeFactory.createUPCA(barcodeText);
        barcode.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));

        return BarcodeImageHandler.getImage(barcode);
    }

    public BufferedImage generateEAN128BarCodeImage(final String barcodeText) throws Exception {
        final Barcode barcode = BarcodeFactory.createEAN128(barcodeText);
        barcode.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));

        return BarcodeImageHandler.getImage(barcode);
    }

    public BufferedImage generateCode128BarCodeImage(final String barcodeText) throws Exception {
        final Barcode barcode = BarcodeFactory.createCode128(barcodeText);
        barcode.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));

        return BarcodeImageHandler.getImage(barcode);
    }

    public BufferedImage generateUSPSBarcodeImage(final String barcodeText) throws Exception {
        final Barcode barcode = BarcodeFactory.createUSPS(barcodeText);
        barcode.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));

        return BarcodeImageHandler.getImage(barcode);
    }

    public BufferedImage generateSCC14ShippingCodeBarcodeImage(final String barcodeText) throws Exception {
        final Barcode barcode = BarcodeFactory.createSCC14ShippingCode(barcodeText);
        barcode.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));

        return BarcodeImageHandler.getImage(barcode);
    }

    public BufferedImage generateCode39BarcodeImage(final String barcodeText) throws Exception {
        final Barcode barcode = BarcodeFactory.createCode39(barcodeText, true);
        barcode.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));

        return BarcodeImageHandler.getImage(barcode);
    }

    public BufferedImage generateGlobalTradeItemNumberBarcodeImage(final String barcodeText) throws Exception {
        final Barcode barcode = BarcodeFactory.createGlobalTradeItemNumber(barcodeText);
        barcode.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));

        return BarcodeImageHandler.getImage(barcode);
    }

    public BufferedImage generatePDF417BarcodeImage(final String barcodeText) throws Exception {
        final Barcode barcode = BarcodeFactory.createPDF417(barcodeText);
        barcode.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));

        return BarcodeImageHandler.getImage(barcode);
    }
}
