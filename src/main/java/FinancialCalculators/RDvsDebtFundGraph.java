package FinancialCalculators;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RDvsDebtFundGraph {

    public static void main(String[] args) throws IOException {

        // Initialize variables
        int numMonths = 30 * 12;
        double rdAmount = 0;
        double debtFundAmount = 0;
        double rdInterestRate = 0.06;
        double debtFundDailyInterestRate = 0.0001; // 0.01% per day
        double monthlyInvestment = 5000;

        // Create dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Calculate and add data to the dataset for each month
        for (int i = 1; i <= numMonths; i++) {

            // Calculate RD amount
            rdAmount = (rdAmount + monthlyInvestment) * (1 + rdInterestRate / 4);
            if (i % 3 == 0) {
                rdAmount += rdAmount * rdInterestRate / 4;
            }

            // Calculate debt fund amount
            debtFundAmount = (debtFundAmount + monthlyInvestment) * (1 + debtFundDailyInterestRate * 30);

            // Add data to the dataset
            dataset.addValue(rdAmount, "RD", Integer.toString(i));
            dataset.addValue(debtFundAmount, "Debt Fund", Integer.toString(i));
        }

        // Create chart
        JFreeChart chart = ChartFactory.createLineChart("RD vs Debt Fund", "Months", "Amount", dataset, PlotOrientation.VERTICAL, true, true, false);

        // Set plot colors
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new GradientPaint(new Point(0, 0), Color.WHITE, new Point(0, 800), Color.LIGHT_GRAY));
        plot.setRangeGridlinePaint(Color.DARK_GRAY);

        // Set axes
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setAutoRangeIncludesZero(false);

        // Set line colors
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesPaint(1, Color.RED);

        // Create chart panel and save as image
        ChartPanel chartPanel = new ChartPanel(chart) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(800, 600);
            }
        };
        BufferedImage img = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = img.createGraphics();
        chartPanel.paint(g2);
        g2.dispose();
        ImageIO.write(img, "png", new File("C:/Users/gautham sambath/Desktop/RDvsDebtFundGraph.png"));
    }

}
