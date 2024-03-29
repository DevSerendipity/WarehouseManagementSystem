package com.devserendipity.warehousemanagementsystem.javafx;

import com.devserendipity.warehousemanagementsystem.javafx.event.CompanyEvent;
import com.devserendipity.warehousemanagementsystem.javafx.event.ProductsEvent;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

public class Barcode {

    static final int BARCODE_HEIGHT = 10;
    static final double MODULE_WIDTH = 0.3;
    static final int QUIET_ZONE_WIDTH = 10;

    public static void createBarcode(String image_name, String myString) {
        try {
            Code128Bean code128 = new Code128Bean();
            code128.setHeight(BARCODE_HEIGHT);
            code128.setModuleWidth(MODULE_WIDTH);
            code128.setQuietZone(QUIET_ZONE_WIDTH);
            code128.doQuietZone(true);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(baos, "image/x-png", 300,
                                                                   BufferedImage.TYPE_BYTE_BINARY, false, 0);
            code128.generateBarcode(canvas, myString);
            canvas.finish();
            FileOutputStream fos = new FileOutputStream("src/main/resources/Images/BarcodeImages/" + image_name);
            fos.write(baos.toByteArray());
            fos.flush();
            fos.close();
        } catch ( Exception e ) {
            e.getStackTrace();
        }
    }

    public String getSKU() {
        return (CompanyEvent.getCompanyCode() + "" + CompanyEvent.getFirstLetterOfCompanyName() + ""
                + ProductsEvent.getProductCode() + "" + CompanyEvent.getLastLetterOfCompanyName());
    }
}
