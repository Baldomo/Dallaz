package Utilities;

import java.awt.*;

/**
 * Created by Leonardo Baldin on 28/04/17.
 */

public class ImageResizer {

    public static Image resizeImage(Image image, int width, int height, boolean max) {
        if (width < 0 && height > 0) {
            return resizeImageBy(image, height, false);
        } else if (width > 0 && height < 0) {
            return resizeImageBy(image, width, true);
        } else if (width < 0 && height < 0) {
            return image;
        }
        int currentHeight = image.getHeight(null);
        int currentWidth = image.getWidth(null);
        int expectedWidth = (height * currentWidth) / currentHeight;

        //Size will be set to the height
        //unless the expectedWidth is greater than the width and the constraint is maximum
        //or the expectedWidth is less than the width and the constraint is minimum
        int size = height;
        if (max && expectedWidth > width) {
            size = width;
        } else if (!max && expectedWidth < width) {
            size = width;
        }
        return resizeImageBy(image, size, (size == width));
    }

    public static Image resizeImageBy(Image image, int size, boolean setWidth) {
        if (setWidth) {
            return image.getScaledInstance(size, -1, Image.SCALE_SMOOTH);
        } else {
            return image.getScaledInstance(-1, size, Image.SCALE_SMOOTH);
        }
    }

}
