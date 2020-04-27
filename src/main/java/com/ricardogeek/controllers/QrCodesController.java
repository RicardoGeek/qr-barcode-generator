package com.ricardogeek.controllers;

import com.ricardogeek.generator.QrCodeGenerator;
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
public class QrCodesController {

    @GetMapping(value = "/qrcodes/{text}/{width}/{height}", produces = IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> generate(@PathVariable final String text,
                                                  @PathVariable final int width,
                                                  @PathVariable final int height,
                                                  @Autowired final QrCodeGenerator qrCodeGenerator) {

        try {
            return ok(qrCodeGenerator.generateQrCode(text, width, height));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }

    private ResponseEntity<BufferedImage> ok(final BufferedImage bufferedImage) {
        return new ResponseEntity<>(bufferedImage, OK);
    }
}
