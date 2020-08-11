
import java.util.ArrayList;
import java.util.List;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.core.Point;
import org.opencv.core.Core;
import org.opencv.core.Mat;
//import org.opencv.highgui.Highgui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;


public class DiffImg {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME );

        Mat img1 = Imgcodecs.imread("C:\\Users\\yanding.li\\Desktop\\test\\img\\image01-0.png");
        Mat img2 = Imgcodecs.imread("C:\\Users\\yanding.li\\Desktop\\test\\img\\image01-0.png");

        Mat img = new Mat();
        Mat erodeImg = new Mat();
        Mat dilateImg = new Mat();
        Mat threshImg = new Mat();
        List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
        Mat hierarchy = new Mat();
        //像素做差
        Core.absdiff(img1, img2, img);
        Mat kernel = Imgproc.getStructuringElement(1,new Size(4,6));
        Mat kernel1 = Imgproc.getStructuringElement(1,new Size(2,3));
        //腐蚀
        Imgproc.erode(img, erodeImg, kernel,new Point(-1,-1),1);
        //膨胀
        Imgproc.dilate(erodeImg, dilateImg, kernel1);

        //检测边缘
        Imgproc.threshold(dilateImg, threshImg, 20, 255, Imgproc.THRESH_BINARY);
        //转化成灰度
        Imgproc.cvtColor(threshImg, threshImg, Imgproc.COLOR_RGB2GRAY);
        //找到轮廓(3：CV_RETR_TREE，2：CV_CHAIN_APPROX_SIMPLE)
        Imgproc.findContours(threshImg, contours, hierarchy, Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE, new Point(0,0));
        List<Rect> boundRect = new ArrayList<Rect>(contours.size());
        for(int i=0;i<contours.size();i++){
//        	Mat conMat = (Mat)contours.get(i);
//        	Imgproc.approxPolyDP((MatOfPoint2f)conMat,contours_poly.get(i),3,true);

            //根据轮廓生成外包络矩形
            Rect rect = Imgproc.boundingRect(contours.get(i));
            boundRect.add(rect);
        }

        for(int i=0;i<contours.size();i++){
            Scalar color = new Scalar(0,255,0);
            //绘制轮廓
        	Imgproc.drawContours(img1, contours, i, color, 1, 8, hierarchy, 0, new Point());
            //绘制矩形
//            rectangle(img1, boundRect.get(i).tl(), boundRect.get(i).br(), color, 2, 8); //绘制第i个外接矩形
//            Core.rectangle(img1, boundRect.get(i).tl(), boundRect.get(i).br(), color, 2, 8, 0);
//            rectangle(imgC, loc1, loc2, 255, 2)
        }

        Imgcodecs.imwrite("C:\\Users\\yanding.li\\Desktop\\test\\img\\diffTest.jpg", img1);
    }


}
