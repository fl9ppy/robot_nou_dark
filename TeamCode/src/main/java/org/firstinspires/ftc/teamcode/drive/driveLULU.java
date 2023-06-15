package org.firstinspires.ftc.teamcode.drive;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.util.RobotUtils;

@TeleOp
@Config
public class driveLULU extends LinearOpMode {

    private RobotUtils robot;


    enum Mode {
        TURBO,
        PRECISION,
        DRIVER_CONTROL
    }

    Mode currentMode = Mode.DRIVER_CONTROL;
    public void runOpMode() throws InterruptedException {

        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.pendul.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.pendul.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive() && !isStopRequested()) {

            switch (currentMode) {

                case DRIVER_CONTROL:
                    drive.setWeightedDrivePower(
                            new Pose2d(
                                    -gamepad1.left_stick_y/2.5,
                                    -gamepad1.left_stick_x/2.5,
                                    -gamepad1.right_stick_x/2.5
                            )
                    );

                    if (gamepad1.right_trigger!=0) currentMode = Mode.TURBO;
                    if (gamepad1.left_trigger!=0) currentMode = Mode.PRECISION;

                    break;

                case TURBO:
                    drive.setWeightedDrivePower(
                            new Pose2d(
                                    -gamepad1.left_stick_y,
                                    -gamepad1.left_stick_x,
                                    -gamepad1.right_stick_x
                            )
                    );

                    if (gamepad1.right_trigger==0) currentMode = Mode.DRIVER_CONTROL;

                    break;

                case PRECISION:
                    drive.setWeightedDrivePower(
                            new Pose2d(
                                    -gamepad1.left_stick_y/4,
                                    -gamepad1.left_stick_x/4,
                                    -gamepad1.right_stick_x/4
                            )
                    );

                    if(gamepad1.left_trigger==0) currentMode = Mode.DRIVER_CONTROL;

                    break;
            }

            drive.update();

            if(robot.hasDetected()){
                robot.cleste.setPosition(robot.cleste_inchis);
                sleep(500);
                robot.intake_to_outake();
                sleep(500);
                robot.cleste_outake.setPosition(robot.cleste_outake_inchis);
                sleep(500);
                robot.outake();
                sleep(500);
                robot.outake_reset();
            }
            if(gamepad1.square){
                //TODO: Sa se extinda extendo-ul inainte de a se deschide gheara
                robot.cleste.setPosition(robot.cleste_deschis);
            }

            //TODO: Un if care verifica daca senzorul de distanta vede pole-ul, daca da, apeleaza functia outake_servo_jos

            telemetry.addData("Mod sasiu: ", currentMode.toString());
            telemetry.update();
        }
    }
}

