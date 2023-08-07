import ij.IJ
import ij.ImagePlus
import ij.plugin.ChannelSplitter
import inra.ijpb.measure.ResultsBuilder
import inra.ijpb.plugins.AnalyzeRegions
import inra.ijpb.plugins.AnalyzeRegions3D
import inra.ijpb.measure.IntensityMeasures

import java.io.File


// INPUT UI
//
#@File(label = "Input File Directory Morphology", style = "directory") inputFilesMorpho
#@File(label = "Output directory", style = "directory") outputDir


//def inputFilesDir = new File("C:/Users/acayuela/Desktop/users/msole/images/Morula - Blasto/original")
//def outputDir = new File("C:/Users/acayuela/Desktop/users/msole/images/Morula - Blasto/output")
// IDE
//
//
//def headless = true;
//new ij.ImageJ().setVisible(false);
//def inputFilesDir = new File("./output")
//def outputDir = new File("./output/csv")

IJ.log("-Parameters selected: ")
IJ.log("    -inputFileDir: " + inputFilesMorpho)
IJ.log("    -outputDir: " + outputDir)
IJ.log("                                                           ");

/** Get 3D label (images) from input directory to evaluate morphology */
def listOfFilesMorpho = inputFilesMorpho.listFiles();

for (def i = 0.intValue(); i < listOfFilesMorpho.length; i++) {

    if (!listOfFilesMorpho[i].getName().contains("DS")) {
        def label = new ImagePlus(listOfFilesMorpho[i].getAbsolutePath())

        /** Measure morphology on 3D labels, get ResultsTable */
        def rtMorpho = new AnalyzeRegions().process(label)
        rtMorpho.saveAs(outputDir.getAbsolutePath()+File.separator+label.getShortTitle().replaceAll("_chO_label","")+"_morphology.csv")
        /** Measure intensity on 3D labels, ch0 get ResultsTable */

        def ch0 = new ImagePlus(listOfFilesMorpho[i].getAbsolutePath().replaceAll("label","split"))
        def im0 = new IntensityMeasures( ch0, label);
        def rbCh0 = new ResultsBuilder();
        rbCh0.addResult(im0.getMean())
        rbCh0.addResult( im0.getStdDev());
        rbCh0.addResult( im0.getMax());
        rbCh0.addResult( im0.getMin() );
        rbCh0.addResult( im0.getMode() );
        rbCh0.addResult( im0.getSkewness() );
        rbCh0.addResult( im0.getKurtosis() );
        rbCh0.addResult( im0.getNumberOfVoxels() );
        rbCh0.addResult( im0.getVolume() );
        rbCh0.addResult( im0.getNeighborsMean() );
        rbCh0.addResult( im0.getNeighborsStdDev() );
        rbCh0.addResult( im0.getNeighborsMax() );
        rbCh0.addResult( im0.getNeighborsMin() );
        rbCh0.addResult( im0.getNeighborsMedian() );
        rbCh0.addResult( im0.getNeighborsMode() );
        rbCh0.addResult( im0.getNeighborsSkewness() );
        rbCh0.addResult( im0.getNeighborsKurtosis() );
        rbCh0.getResultsTable().saveAs(outputDir.getAbsolutePath()+File.separator+label.getShortTitle().replaceAll("_chO_label","")+"_intensity_ch0.csv")
        /** Measure intensity on 3D labels, ch1 get ResultsTable */
        def ch1 = new ImagePlus(listOfFilesMorpho[i].getAbsolutePath().replaceAll("label","split"))
        def im1 = new IntensityMeasures( ch1, label);
        def rbCh1 = new ResultsBuilder();
        rbCh1.addResult(im1.getMean())
        rbCh1.addResult( im1.getStdDev());
        rbCh1.addResult( im1.getMax());
        rbCh1.addResult( im1.getMin() );
        rbCh1.addResult( im1.getMode() );
        rbCh1.addResult( im1.getSkewness() );
        rbCh1.addResult( im1.getKurtosis() );
        rbCh1.addResult( im1.getNumberOfVoxels() );
        rbCh1.addResult( im1.getVolume() );
        rbCh1.addResult( im1.getNeighborsMean() );
        rbCh1.addResult( im1.getNeighborsStdDev() );
        rbCh1.addResult( im1.getNeighborsMax() );
        rbCh1.addResult( im1.getNeighborsMin() );
        rbCh1.addResult( im1.getNeighborsMedian() );
        rbCh1.addResult( im1.getNeighborsMode() );
        rbCh1.addResult( im1.getNeighborsSkewness() );
        rbCh1.addResult( im1.getNeighborsKurtosis() );
        rbCh1.getResultsTable().saveAs(outputDir.getAbsolutePath()+File.separator+label.getShortTitle().replaceAll("_ch2_label","")+"_intensity_ch1.csv")
        /** Measure intensity on 3D labels, ch2 get ResultsTable */
        def ch2 = new ImagePlus(listOfFilesMorpho[i].getAbsolutePath().replaceAll("label","split"))
        def im2 = new IntensityMeasures( ch2, label);
        def rbCh2 = new ResultsBuilder();
        rbCh2.addResult(im1.getMean())
        rbCh2.addResult( im1.getStdDev());
        rbCh2.addResult( im1.getMax());
        rbCh2.addResult( im1.getMin() );
        rbCh2.addResult( im1.getMode() );
        rbCh2.addResult( im1.getSkewness() );
        rbCh2.addResult( im1.getKurtosis() );
        rbCh2.addResult( im1.getNumberOfVoxels() );
        rbCh2.addResult( im1.getVolume() );
        rbCh2.addResult( im1.getNeighborsMean() );
        rbCh2.addResult( im1.getNeighborsStdDev() );
        rbCh2.addResult( im1.getNeighborsMax() );
        rbCh2.addResult( im1.getNeighborsMin() );
        rbCh2.addResult( im1.getNeighborsMedian() );
        rbCh2.addResult( im1.getNeighborsMode() );
        rbCh2.addResult( im1.getNeighborsSkewness() );
        rbCh2.addResult( im1.getNeighborsKurtosis() );
        rbCh2.getResultsTable().saveAs(outputDir.getAbsolutePath()+File.separator+label.getShortTitle().replaceAll("_ch2_label","")+"_intensity_ch2.csv")
        /** Measure intensity on 3D labels, ch3 get ResultsTable */
        def ch3 = new ImagePlus(listOfFilesMorpho[i].getAbsolutePath().replaceAll("label","split"))
        def im3 = new IntensityMeasures( ch3, label);
        def rbCh3 = new ResultsBuilder();
        rbCh3.addResult(im1.getMean())
        rbCh3.addResult( im1.getStdDev());
        rbCh3.addResult( im1.getMax());
        rbCh3.addResult( im1.getMin() );
        rbCh3.addResult( im1.getMode() );
        rbCh3.addResult( im1.getSkewness() );
        rbCh3.addResult( im1.getKurtosis() );
        rbCh3.addResult( im1.getNumberOfVoxels() );
        rbCh3.addResult( im1.getVolume() );
        rbCh3.addResult( im1.getNeighborsMean() );
        rbCh3.addResult( im1.getNeighborsStdDev() );
        rbCh3.addResult( im1.getNeighborsMax() );
        rbCh3.addResult( im1.getNeighborsMin() );
        rbCh3.addResult( im1.getNeighborsMedian() );
        rbCh3.addResult( im1.getNeighborsMode() );
        rbCh3.addResult( im1.getNeighborsSkewness() );
        rbCh3.addResult( im1.getNeighborsKurtosis() );
        rbCh3.getResultsTable().saveAs(outputDir.getAbsolutePath()+File.separator+label.getShortTitle().replaceAll("_ch3_label","")+"_intensity_ch3.csv")
    }
}


IJ.log("Done!!!")


