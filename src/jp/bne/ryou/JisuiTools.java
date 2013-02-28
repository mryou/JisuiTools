/**
 *
 */
package jp.bne.ryou;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author Mizuki Ryou
 *
 */
public class JisuiTools {

    /**
     * @param args
     */
    public static void main(String[] args) {

        PdfStamper pdfStamper = null;
        File org = new File(args[0]);
        String distName = org.getAbsolutePath().substring(0, org.getAbsolutePath().lastIndexOf('.')) + "_ptr.pdf";
        try {
            pdfStamper = new PdfStamper(new PdfReader(org.getAbsolutePath()), new FileOutputStream(distName));
            // 右綴じ
            pdfStamper.addViewerPreference(PdfName.DIRECTION, PdfName.R2L);
            // 見開き（表紙）
            pdfStamper.getWriter().setViewerPreferences(PdfWriter.PageLayoutTwoPageRight);

            pdfStamper.close();
        } catch (FileNotFoundException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (DocumentException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (IOException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }

    }

}
