package org.firstinspires.ftc.teamcode.Troubleshooting.TestingOps;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Autonomous.Auto;
import org.firstinspires.ftc.teamcode.Autonomous.VuforiaBitmapSkystoneDetector;
import org.firstinspires.ftc.teamcode.Helpers.bTelemetry;

@Autonomous(name = "TestingOpMode", group = "Trouble Shooting")
public class TestingOpMode extends Auto {

    public VuforiaBitmapSkystoneDetector t = new VuforiaBitmapSkystoneDetector();

    @Override
    public void runOpMode() {

        t.Start(this);

        waitForStart();

        while (opModeIsActive()) {
            t.Update(this);
//            telemetry.addData("yoink", "");
//            telemetry.update();
        }
    }

}
