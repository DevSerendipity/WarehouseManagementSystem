package LMS.JavaFx;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

import static LMS.JavaFx.event.CompanyEvent.*;
import static LMS.JavaFx.event.ProductsEvent.getProductCode;

public class Barcode extends RetrieveSKU{

    public static void createBarcode(String image_name, String myString) {
        try {
            Code128Bean code128 = new Code128Bean();
            code128.setHeight(10f);
            code128.setModuleWidth(0.3);
            code128.setQuietZone(10);
            code128.doQuietZone(true);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(baos, "image/x-png", 300, BufferedImage.TYPE_BYTE_BINARY, false, 0);
            code128.generateBarcode(canvas, myString);
            canvas.finish();
            //write to png file and later on get the compnay and product name on the barcode name
            FileOutputStream fos = new FileOutputStream("src/main/resources/Output/" + image_name);
            fos.write(baos.toByteArray());
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    public  String getSKU() {
        return (getCompanyCode() + "" + getFirstAsciLetterOfCompany(0) + "" + getProductCode() + "" + getSecondAsciLetterOfCompany(0));}
}
