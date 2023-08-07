import ij.IJ
import ij.ImagePlus
import ij.plugin.ChannelSplitter
import java.io.File


// INPUT UI
//
#@File(label = "Input File Directory", style = "directory") inputFiles
#@File(label = "Output directory", style = "directory") outputDir


//def inputFilesDir = new File("./output")
//def outputDir = new File("./output/csv")
// IDE
//
//
//def headless = true;
//new ij.ImageJ().setVisible(false);

IJ.log("-Parameters selected: ")
IJ.log("    -inputFileDir: " + inputFiles)
IJ.log("    -outputDir: " + outputDir)
IJ.log("                                                           ");

/** Get files (images) from input directory */
def listOfFiles = inputFiles.listFiles();

for (def i = 0.intValue(); i < listOfFiles.length; i++) {

    if (!listOfFiles[i].getName().contains(".DS")) {
        def imp = new ImagePlus(listOfFiles[i].getAbsolutePath())
        /** Get channels from each image */
        def channels = ChannelSplitter.split(imp)
        for (def j = 0.intValue(); j < channels.length; j++) {
            /** Save each channel as tiff image */
            IJ.saveAs(channels[j], "Tiff", outputDir.getAbsolutePath() +File.separator+ imp.getShortTitle() + "_ch" + j.toString())

        }


    }
}

    IJ.log("Done!!!")


