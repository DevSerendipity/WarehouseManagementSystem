package wms.javafx;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import wms.javafx.event.CompanyEvent;
import wms.javafx.event.ProductsEvent;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

public class Barcode {

    public static void createBarcode( String image_name, String myString ) {
        try {
            Code128Bean code128 = new Code128Bean();
            final int barcodeHeight = 10;
            final double moduleWidth = 0.3;
            final int quietZoneWidth = 10;
            code128.setHeight( barcodeHeight );
            code128.setModuleWidth( moduleWidth );
            code128.setQuietZone( quietZoneWidth );
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
        return ( CompanyEvent.getCompanyCode() + "" + CompanyEvent.getFirstAsciLetterOfCompany( 0 ) + ""
                + ProductsEvent.getProductCode() + "" + CompanyEvent.getSecondAsciLetterOfCompany( 0 ) );
    }
}
