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



    enum Mode3{
        IDLE,
        HIGH,
        MID,
        LOW,
        DOWN,
        MANUAL
    }
    enum Mode2 {
        RETRACT,
        IDLE,
        EXTEND,
        MANUAL
    }
    enum Mode {
        TURBO,
        PRECISION,
        DRIVER_CONTROL
    }

    Mode currentMode = Mode.DRIVER_CONTROL;
    Mode2 extendoMode = Mode2.IDLE;
    Mode3 sliderMode = Mode3.IDLE;
    public void runOpMode() throws InterruptedException {

        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.extendo.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.extendo.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.slider1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.slider2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

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

            switch (extendoMode){
                case EXTEND:
                    robot.extend();

                    if (gamepad1.triangle) extendoMode = Mode2.IDLE;
                    if (gamepad1.circle) extendoMode = Mode2.RETRACT;

                    break;

                case RETRACT:
                    robot.retract();

                    if (gamepad1.triangle) extendoMode = Mode2.IDLE;
                    if (gamepad1.cross) extendoMode = Mode2.EXTEND;

                    break;

                case IDLE:
                    robot.extendo.setPower(0);
                    robot.extendo.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                    if(gamepad1.square) extendoMode = Mode2.MANUAL;
                    if(gamepad1.circle) extendoMode = Mode2.RETRACT;
                    if(gamepad1.cross) extendoMode = Mode2.EXTEND;

                    break;

                case MANUAL:
                    robot.extendo.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                    robot.extendo.setPower(gamepad2.right_stick_x);

                    if(gamepad2.triangle) extendoMode = Mode2.IDLE;

                    break;
            }

            switch (sliderMode){
                case HIGH:
                    robot.go_high();

                    if(gamepad1.dpad_left) sliderMode = Mode3.LOW;
                    if(gamepad1.dpad_right) sliderMode = Mode3.MID;
                    if(gamepad1.dpad_down) sliderMode = Mode3.DOWN;
                    if(gamepad1.right_stick_button) sliderMode = Mode3.MANUAL;
                    if(gamepad1.left_stick_button) sliderMode = Mode3.IDLE;

                case LOW:
                    robot.go_low();

                    if(gamepad1.dpad_up) sliderMode = Mode3.HIGH;
                    if(gamepad1.dpad_right) sliderMode = Mode3.MID;
                    if(gamepad1.dpad_down) sliderMode = Mode3.DOWN;
                    if(gamepad1.right_stick_button) sliderMode = Mode3.MANUAL;
                    if(gamepad1.left_stick_button) sliderMode = Mode3.IDLE;

                case MID:
                    robot.go_mid();

                if(gamepad1.dpad_left) sliderMode = Mode3.LOW;
                if(gamepad1.dpad_down) sliderMode = Mode3.DOWN;
                if(gamepad1.dpad_up) sliderMode = Mode3.HIGH;
                if(gamepad1.right_stick_button) sliderMode = Mode3.MANUAL;
                if(gamepad1.left_stick_button) sliderMode = Mode3.IDLE;

                case DOWN:
                    robot.go_down();

                if(gamepad1.dpad_left) sliderMode = Mode3.LOW;
                if(gamepad1.dpad_right) sliderMode = Mode3.MID;
                if(gamepad1.dpad_up) sliderMode = Mode3.HIGH;
                if(gamepad1.right_stick_button) sliderMode = Mode3.MANUAL;
                if(gamepad1.left_stick_button) sliderMode = Mode3.IDLE;

                case IDLE:
                    robot.slider1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    robot.slider2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                if(gamepad1.dpad_left) sliderMode = Mode3.LOW;
                if (gamepad1.dpad_down) sliderMode = Mode3.DOWN;
                if(gamepad1.dpad_up) sliderMode = Mode3.HIGH;
                if(gamepad1.right_stick_button) sliderMode = Mode3.MANUAL;
                if(gamepad1.dpad_right) sliderMode = Mode3.MID;

                case MANUAL:
                    robot.slider1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                    robot.slider1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

                    if(gamepad1.right_trigger != 0){
                        robot.slider1.setPower(0.6);
                        robot.slider2.setPower(-0.6);
                    }
                    else if(gamepad1.left_trigger != 0){
                        robot.slider1.setPower(-0.6);
                        robot.slider2.setPower(0.6);
                    }
                    else{
                        robot.slider1.setPower(0);
                        robot.slider2.setPower(0);
                    }

                    if(gamepad1.left_stick_button) sliderMode = Mode3.IDLE;


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

            if(gamepad2.b) robot.pendul.setPosition(0.5);

            //TODO: Un if care verifica daca senzorul de distanta vede pole-ul, daca da, apeleaza functia outake_servo_jos

            telemetry.addData("Mod sasiu: ", currentMode.toString());
            telemetry.update();
        }
    }
}

