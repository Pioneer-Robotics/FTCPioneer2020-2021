package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.AnalogInput;

import org.firstinspires.ftc.teamcode.Helpers.bDataManager;

public class Potentiometer {

    //Exposed for telemetry data
    public double regSlope = 2.2376;
    public double regIntercept = -0.056668;

    public final int dataResolution = 10;
    public double[] voltages = new double[dataResolution-2];
    public double[] angles = new double[dataResolution-2];
    public int arrayPos = 0;

    public double xSum=0; //angles
    public double ySum=0; //voltage
    public double x2Sum=0; //x squared sum
    public double xySum=0;

    public AnalogInput analogInput;


    //DISABLED
    public Potentiometer(OpMode opMode, String inputName ) {
        analogInput = opMode.hardwareMap.get(AnalogInput.class, inputName);
    }


    public double getAngle() {
        return analogInput.getVoltage() * regSlope + regIntercept;
    }

    public double getVoltage() {
        return analogInput.getVoltage();
    }

    public void addData(double angle) {
            voltages[arrayPos] = getVoltage();
            angles[arrayPos] = angle;
            arrayPos++;
    }


    public void calcRegression() {
        xSum = 0; //angles
        ySum = 0; //voltage
        x2Sum = 0; //x squared sum
        xySum = 0;



        for (int i = 0; i < angles.length; i++ ) {
            xSum += Double.isNaN(angles[i]) ? 0 : angles[i];
            ySum += Double.isNaN( voltages[i]) ? 0: voltages[i];
            x2Sum += Double.isNaN(angles[i] * angles[i]) ? 0: angles[i] * angles[i];
            xySum += Double.isNaN(angles[i] * voltages[i]) ? 0: angles[i] * voltages[i];
        }

        regSlope = (arrayPos*xySum - xSum*ySum) / (arrayPos*x2Sum - xSum*xSum);
        regIntercept = (ySum*x2Sum - xSum*xySum) / (arrayPos*x2Sum - x2Sum);
    }

    public void saveCalibrationData(bDataManager dataManager) {
        //dataManager.writeData("pot_reg_slope", regSlope);
        //dataManager.writeData("pot_reg_intercept", regIntercept);
    }
}

