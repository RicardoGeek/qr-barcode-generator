package com.ricardogeek.generator;

import net.glxn.qrgen.javase.QRCode;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class QrCodeGenerator {

    public BufferedImage generateQrCode(final String qrCodeText, final int width, final int height) throws Exception {
        final ByteArrayOutputStream stream = QRCode
                .from(qrCodeText)
                .withSize(width, height)
                .stream();

        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(stream.toByteArray());

        return ImageIO.read(byteArrayInputStream);
    }
}
