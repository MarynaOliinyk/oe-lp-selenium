package com.openenglish.util;

import java.awt.*;
import java.awt.image.PixelGrabber;
import java.lang.invoke.MethodHandles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CompareUtil {
    private static final Logger LOG = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    public static Result CompareImage(String baseFile, String actualFile) {
        Result compareResult = Result.PixelMismatch;
        Image baseImage = Toolkit.getDefaultToolkit().getImage(baseFile);
        Image actualImage = Toolkit.getDefaultToolkit().
                getImage(actualFile);
        try {
            PixelGrabber baseImageGrab = new PixelGrabber(baseImage, 0, 0, -1, -1, false);
            PixelGrabber actualImageGrab = new PixelGrabber(actualImage, 0, 0, -1, -1, false);
            int[] baseImageData = null;
            int[] actualImageData = null;
            if (baseImageGrab.grabPixels()) {
                baseImageData = (int[]) baseImageGrab.getPixels();
            }
            if (actualImageGrab.grabPixels()) {
                actualImageData = (int[]) actualImageGrab.getPixels();
            }
            LOG.info(baseImageGrab.getHeight() + "<>" +
                    actualImageGrab.getHeight());
            LOG.info(baseImageGrab.getWidth() + "<>" +
                    actualImageGrab.getWidth());
            if ((baseImageGrab.getHeight() != actualImageGrab.getHeight()) || (baseImageGrab.getWidth() != actualImageGrab.getWidth())) {
                compareResult = Result.SizeMismatch;
            } else if (java.util.Arrays.equals(baseImageData, actualImageData)) {
                compareResult = Result.Matched;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return compareResult;
    }
}
