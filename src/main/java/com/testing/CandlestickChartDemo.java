package com.testing;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.DefaultHighLowDataset;
import org.jfree.data.xy.OHLCDataItem;

import java.util.Calendar;
import java.util.Date;

public class CandlestickChartDemo {

    public static void main(String[] args) {

        // Generate random stock prices for the day
        double price = 430.0;
        OHLCDataItem[] dataItems = new OHLCDataItem[24];
        for (int i = 0; i < 24; i++) {
            double open = price + Math.random() * 10 - 5;
            double high = open + Math.random() * 10;
            double low = open - Math.random() * 10;
            double close = open + Math.random() * 10 - 5;
            Date date = getDate(i);
            OHLCDataItem item = new OHLCDataItem(date, open, high, low, close, 1);
            dataItems[i] = item;
            price = close;
        }

        // Create a new candlestick dataset using the data items
        DefaultHighLowDataset dataset = new DefaultHighLowDataset("XYZ Stock", getDateArray(dataItems), getOpenArray(dataItems), getHighArray(dataItems), getLowArray(dataItems), getCloseArray(dataItems), getVolumeArray(dataItems));

        // Create a new candlestick chart with the dataset
        JFreeChart chart = ChartFactory.createCandlestickChart("XYZ Stock Price", "Time", "Price", dataset, false);

        // Create a new chart frame and add the chart to it
        ChartFrame frame = new ChartFrame("XYZ Stock Price", chart);
        frame.pack();
        frame.setVisible(true);
    }

    private static Date getDate(int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        return calendar.getTime();
    }

    private static Date[] getDateArray(OHLCDataItem[] dataItems) {
        Date[] dates = new Date[dataItems.length];
        for (int i = 0; i < dataItems.length; i++) {
            dates[i] = dataItems[i].getDate();
        }
        return dates;
    }

    private static double[] getOpenArray(OHLCDataItem[] dataItems) {
        double[] opens = new double[dataItems.length];
        for (int i = 0; i < dataItems.length; i++) {
            opens[i] = (double) dataItems[i].getOpen();
        }
        return opens;
    }

    private static double[] getHighArray(OHLCDataItem[] dataItems) {
        double[] highs = new double[dataItems.length];
        for (int i = 0; i < dataItems.length; i++) {
            highs[i] = (double) dataItems[i].getHigh();
        }
        return highs;
    }

    private static double[] getLowArray(OHLCDataItem[] dataItems) {
        double[] lows = new double[dataItems.length];
        for (int i = 0; i < dataItems.length; i++) {
            lows[i] = (double) dataItems[i].getLow();
        }
        return lows;
    }

    private static double[] getCloseArray(OHLCDataItem[] dataItems) {
        double[] closes = new double[dataItems.length];
        for (int i = 0; i < dataItems.length; i++) {
            closes[i] = (double) dataItems[i].getClose();
        }
        return closes;
    }

    private static double[] getVolumeArray(OHLCDataItem[] dataItems) {
        double[] volumes = new double[dataItems.length];
        for (int i = 0; i < dataItems.length; i++) {
            volumes[i] = (double) dataItems[i].getVolume();
        }
        return volumes;
    }

}




