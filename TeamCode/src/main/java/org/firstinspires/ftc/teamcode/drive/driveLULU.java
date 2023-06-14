package org.firstinspires.ftc.teamcode.drive;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@TeleOp
@Config
public class driveLULU extends LinearOpMode {

    enum Mode {
        TURBO,
        PRECISION,
        DRIVER_CONTROL
    }

    Mode currentMode = Mode.DRIVER_CONTROL;
    public void runOpMode() throws InterruptedException {

        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

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

            telemetry.addData("Mod sasiu: ", currentMode.toString());
            telemetry.update();
        }
    }
}

