package org.firstinspires.ftc.teamcode.Autonomous;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "BLUE FOUNDATION", group = "ftcPio")
public class BlueFoundation extends Auto {
    @Override
    public void runOpMode() {
        boolean endOnWall = true;
        boolean aButton1Check = false;
        startRobot();

        //this while statement is so that you can use a controller to tell the robot where to park
        while (!opModeIsActive()) {
            if (gamepad1.x) {
                break;
            }
            if (gamepad1.a && !aButton1Check) {
                endOnWall = !endOnWall;
            }
            aButton1Check = gamepad1.a;

            telemetry.addData("End on wall ", endOnWall);
            telemetry.addData("Press X to EXIT", "");
            telemetry.update();
        }

        waitForStart();
        sleep(1000);
        //ready gripper to grab foundation
        robot.releaseFoundation();
        //go forward 70 cm
        robot.driveByDistance(0, 0.5, 90);
        //go left 75 cm
        robot.driveByDistance(-75, 0.5, 70);
        //go forward 25 cm to correct
        robot.driveByDistance(5, 0.5, 30);
        //grip foundation
        robot.gripFoundation();
        //delay
        sleep(2000);
        //pull it backwards
        robot.driveByDistance(180, 0.5, 145);
        //push it more into the wall to straighten it out
        robot.driveByDistance(165, 0.25, 5);
        //go a tad forward to push gripper off foundation
        robot.driveByDistance(0, 0.25, 5);
        //release servos
        robot.releaseFoundation();
        if (endOnWall) {
            //go under bridge
            robot.driveByDistance(100, 0.5, 240);
            //pull into the wall, to make sure you're there
            robot.driveByDistance(180, 0.5, 25);
            //go right a little more, to center robot
            robot.driveByDistance(100, 0.5, 20);
        } else {
            //more past the foundation but not quite to the bridge
            robot.driveByDistance(100, 0.5, 130);
            //go forward to be closer to the bridge
            robot.driveByDistance(0, 0.5, 90);
            //go the rest of the way under the bridge
            robot.driveByDistance(90, 0.5, 80);
            //tap the bridge to try and line up more
            robot.driveByDistance(0, 0.25, 10);
        }
        //if you wanna be under the bridge, go forward
        StopMovement();
        StopRobot();
    }
}