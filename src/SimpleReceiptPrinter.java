import java.awt.*;
import java.awt.print.*;

public class SimpleReceiptPrinter implements Printable {

    public static void main(String[] args) {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new SimpleReceiptPrinter());

        // Set custom paper size for a 58mm thermal printer
        PageFormat pf = job.defaultPage();
        Paper paper = new Paper();
        double paperWidth = 162; // 58mm = 162 points (1 inch = 72 points)
        double paperHeight = 500; // Adjust height based on content
        double margin = 5;

        paper.setSize(paperWidth, paperHeight);
        paper.setImageableArea(margin, margin, paperWidth - (2 * margin), paperHeight - (2 * margin));
        pf.setPaper(paper);

        job.setPrintable(new SimpleReceiptPrinter(), pf);

        if (job.printDialog()) {
            try {
                job.print();
            } catch (PrinterException e) {
                e.printStackTrace();
                System.out.println("Print failed: " + e.getMessage());
            }
        }
    }

    @Override
    public int print(Graphics g, PageFormat pf, int pageIndex) {
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        g2d.setFont(new Font("Monospaced", Font.PLAIN, 10));

        // Sample receipt content
        String[] receiptData = {
            "Cafe 25th Milk Tea POS",
            "------------------------",
            "Item 1      x2    ₱120",
            "Item 2      x1    ₱60",
            "------------------------",
            "Total:           ₱180",
            "Cash Given:      ₱200",
            "Change:           ₱20",
            "------------------------",
            "Thank you! Please come again!"
        };

        int y = 20;
        for (String line : receiptData) {
            g2d.drawString(line, 10, y);
            y += 15;
        }
        return Printable.PAGE_EXISTS;
    }
}
