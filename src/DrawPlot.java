import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DrawPlot extends ApplicationFrame {

    public DrawPlot( String applicationTitle, String chartTitle ) throws IOException{
        super(applicationTitle);
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                chartTitle ,
                "Steps" ,
                "Fitness" ,
                createDataset1() ,
                PlotOrientation.VERTICAL ,
                true , true , false);

        ChartPanel chartPanel = new ChartPanel( xylineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        final XYPlot plot = xylineChart.getXYPlot( );

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        renderer.setSeriesPaint( 0 , Color.RED );
        renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
        plot.setRenderer( renderer );
        setContentPane( chartPanel );
    }

    public static XYDataset createDataset1() throws IOException {
        final XYSeries mutation = new XYSeries( "RLS" );
        BufferedReader reader = Files.newBufferedReader(Paths.get("text.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] nums = line.split(" ");
            mutation.add(Double.parseDouble(nums[0]), Double.parseDouble(nums[1]));
        }
        final XYSeriesCollection dataset = new XYSeriesCollection( );
        dataset.addSeries( mutation );
        return dataset;
    }

    public static XYDataset createDataset2() throws IOException {
        final XYSeries mutation = new XYSeries( "RLS" );
        BufferedReader reader = Files.newBufferedReader(Paths.get("solve1.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] nums = line.split(" ");
            mutation.add(Integer.parseInt(nums[0]), Double.parseDouble(nums[1]));
        }
        final XYSeriesCollection dataset = new XYSeriesCollection( );
        dataset.addSeries( mutation );
        return dataset;
    }

    public static XYDataset createDataset3() throws IOException {
        final XYSeries mutation = new XYSeries( "RLS" );
        BufferedReader reader = Files.newBufferedReader(Paths.get("solve2.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] nums = line.split(" ");
            mutation.add(Integer.parseInt(nums[0]), Double.parseDouble(nums[1]));
        }
        final XYSeriesCollection dataset = new XYSeriesCollection( );
        dataset.addSeries( mutation );
        return dataset;
    }

    public static XYDataset createDataset4() throws IOException {
        final XYSeries mutation = new XYSeries( "RLS" );
        BufferedReader reader = Files.newBufferedReader(Paths.get("solve3.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] nums = line.split(" ");
            mutation.add(Integer.parseInt(nums[0]), Double.parseDouble(nums[1]));
        }
        final XYSeriesCollection dataset = new XYSeriesCollection( );
        dataset.addSeries( mutation );
        return dataset;
    }

    public static XYDataset createDataset5() throws IOException {
        final XYSeries mutation = new XYSeries( "first" );
        final XYSeries crossover = new XYSeries("second");
        BufferedReader reader = Files.newBufferedReader(Paths.get("solve4.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] nums = line.split(" ");
            mutation.add(Double.parseDouble(nums[0]), Double.parseDouble(nums[1]));
            crossover.add(Double.parseDouble(nums[0]), Double.parseDouble(nums[2]));
        }
        final XYSeriesCollection dataset = new XYSeriesCollection( );
        dataset.addSeries( mutation );
        dataset.addSeries(crossover);
        return dataset;
    }

    public static void main( String[ ] args ) {
//        try {
//            JFreeChart xylineChart = ChartFactory.createXYLineChart(
//                    "Iterations",
//                    "r",
//                    "x",
//                    DrawPlot.createDataset1(),
//                    PlotOrientation.VERTICAL,
//                    true, true, false);
//
//            int width = 1000;   /* Width of the image */
//            int height = 800;  /* Height of the image */
//            File XYChart = new File( "Iterations.jpeg" );
//            ChartUtilities.saveChartAsJPEG( XYChart, xylineChart, width, height);
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        try {
//            JFreeChart xylineChart = ChartFactory.createXYLineChart(
//                    "Iterations",
//                    "r",
//                    "x",
//                    DrawPlot.createDataset2(),
//                    PlotOrientation.VERTICAL,
//                    true, true, false);
//
//            int width = 1000;   /* Width of the image */
//            int height = 800;  /* Height of the image */
//            File XYChart = new File( "Iteration0.jpeg" );
//            ChartUtilities.saveChartAsJPEG( XYChart, xylineChart, width, height);
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        try {
//            JFreeChart xylineChart = ChartFactory.createXYLineChart(
//                    "Iterations",
//                    "r",
//                    "x",
//                    DrawPlot.createDataset3(),
//                    PlotOrientation.VERTICAL,
//                    true, true, false);
//
//            int width = 1000;   /* Width of the image */
//            int height = 800;  /* Height of the image */
//            File XYChart = new File( "IterationsMono.jpeg" );
//            ChartUtilities.saveChartAsJPEG( XYChart, xylineChart, width, height);
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
        try {
            JFreeChart xylineChart = ChartFactory.createXYLineChart(
                    "Iterations",
                    "r",
                    "x",
                    DrawPlot.createDataset5(),
                    PlotOrientation.VERTICAL,
                    true, true, false);

            int width = 1000;   /* Width of the image */
            int height = 800;  /* Height of the image */
            File XYChart = new File( "Bifurcation.jpeg" );
            ChartUtilities.saveChartAsJPEG( XYChart, xylineChart, width, height);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
//        try {
//            JFreeChart xylineChart = ChartFactory.createXYLineChart(
//                    "Iterations",
//                    "r",
//                    "x",
//                    DrawPlot.createDataset4(),
//                    PlotOrientation.VERTICAL,
//                    true, true, false);
//
//            int width = 1000;   /* Width of the image */
//            int height = 800;  /* Height of the image */
//            File XYChart = new File( "IterationsCol.jpeg" );
//            ChartUtilities.saveChartAsJPEG( XYChart, xylineChart, width, height);
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
    }
}
