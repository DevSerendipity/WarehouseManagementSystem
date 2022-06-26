package wms.javafx;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

import static wms.javafx.event.CompanyEvent.*;
import static wms.javafx.event.ProductsEvent.getProductCode;

public class Barcode {

    public static void createBarcode( String image_name, String myString ) {
        try {
            Code128Bean code128 = new Code128Bean();
            code128.setHeight( 10f );
            code128.setModuleWidth( 0.3 );
            code128.setQuietZone( 10 );
            code128.doQuietZone( true );
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            BitmapCanvasProvider canvas = new BitmapCanvasProvider( baos, "image/x-png", 300,
                                                                    BufferedImage.TYPE_BYTE_BINARY, false, 0 );
            code128.generateBarcode( canvas, myString );
            canvas.finish();
            FileOutputStream fos = new FileOutputStream( "src/main/resources/Output/" + image_name );
            fos.write( baos.toByteArray() );
            fos.flush();
            fos.close();
        } catch ( Exception e ) {
            e.getStackTrace();
        }
    }

    public String getSKU() {
        return ( getCompanyCode() + "" + getFirstAsciLetterOfCompany(
                0 ) + "" + getProductCode() + "" + getSecondAsciLetterOfCompany( 0 ) );
    }
}
