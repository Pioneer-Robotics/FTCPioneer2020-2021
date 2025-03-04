package org.firstinspires.ftc.teamcode.Troubleshooting.TestingOps;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Robot.Robot;
import org.firstinspires.ftc.teamcode.Robot.RobotWallTrack;

@Autonomous(name = "TestingOpMode4", group = "Trouble Shooting")
public class TestingOpMode4 extends LinearOpMode {

    private Robot robot = new Robot();
    private ElapsedTime deltaTime = new ElapsedTime();


    private int last_bl;

    private int last_br;


    @Override
    public void runOpMode() {
        robot.init(this, true);

        waitForStart();

        while (opModeIsActive()) {
            telemetry.addData("Group 90: ", robot.wallTrack.sensorIDGroupPairs.get(RobotWallTrack.groupID.Group90).getDistanceAverage(DistanceUnit.CM));
            telemetry.addData("Group 90 Angle: ", robot.wallTrack.sensorIDGroupPairs.get(RobotWallTrack.groupID.Group90).getWallAngle());

            telemetry.addData("Group 180: ", robot.wallTrack.sensorIDGroupPairs.get(RobotWallTrack.groupID.Group180).getDistanceAverage(DistanceUnit.CM));
            telemetry.addData("Group 180 Angle: ", robot.wallTrack.sensorIDGroupPairs.get(RobotWallTrack.groupID.Group180).getWallAngle());

            telemetry.addData("Group 270: ", robot.wallTrack.sensorIDGroupPairs.get(RobotWallTrack.groupID.Group270).getDistanceAverage(DistanceUnit.CM));
            telemetry.addData("Group 270 Angle: ", robot.wallTrack.sensorIDGroupPairs.get(RobotWallTrack.groupID.Group270).getWallAngle());

            telemetry.update();
        }


        robot.shutdown();

    }
}