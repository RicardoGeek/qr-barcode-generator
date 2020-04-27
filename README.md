# qr-barcode-generator
RESTFul service to generate barcodes and qr codes writen in Java with Spring Boot Framework.

# Endpoints

## [GET] /barcodes/{type}/{barcodeText}

Generates a barcode taking the following parameters into consideration:

**Type** is one of the following standards:
* EAN13
* EAN128
* UPC
* CODE128
* CODE39
* USPS
* SCC14
* GTIN
* PDF417

**barcodeText** is any text you'd like

*Example:* http://localhost:8080/barcodes/PDF417/313131

## [GET] /qrcodes/{qrCodeText}/{width}/{height}

Generates a QRCode taking the following parameters into consideration:

**qrCodeText** is the text you'd like to encode in the text

**width** the resulting image width

**height** the resulting inage height

*Example:* http://localhost:8080/qrcodes/www.googe.com/350/350