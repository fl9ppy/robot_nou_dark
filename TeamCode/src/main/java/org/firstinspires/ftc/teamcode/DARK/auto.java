package org.firstinspires.ftc.teamcode.DARK;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@Autonomous(name="auto", group="Linear Opmode")
@Config

public class auto extends LinearOpMode {
    private RobotUtils robot;
    private SampleMecanumDrive drive;

    @Override
    public void runOpMode() throws InterruptedException {

        robot = new RobotUtils(hardwareMap);

        drive = new SampleMecanumDrive(hardwareMap);
        drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);



        Pose2d startPose = new Pose2d(12,-60,Math.toRadians(90));
        drive.setPoseEstimate(startPose);

        TrajectorySequence aruncareabilei1 = drive.trajectorySequenceBuilder(startPose)
                .lineToLinearHeading(new Pose2d(12, -60, Math.toRadians(90)))
                .turn(Math.toRadians(-90))
                .waitSeconds(0.500)
                .build();

        TrajectorySequence bilenoi1 = drive.trajectorySequenceBuilder(aruncareabilei1.end())
                .turn(Math.toRadians(180))
                .lineToLinearHeading(new Pose2d(-47, -59, Math.toRadians(180)))
                .waitSeconds(0.250)
                .turn(Math.toRadians(-180))
                .build();

        TrajectorySequence aruncareabilei2 = drive.trajectorySequenceBuilder(bilenoi1.end())
                .lineToLinearHeading(new Pose2d(12,-60, Math.toRadians(0)))
                .waitSeconds(0.500)
                .build();


        TrajectorySequence bilenoi2 = drive.trajectorySequenceBuilder(aruncareabilei1.end())
                .turn(Math.toRadians(180))
                .lineToLinearHeading(new Pose2d(-47, -59, Math.toRadians(180)))
                .waitSeconds(0.250)
                .turn(Math.toRadians(-180))
                .build();

        TrajectorySequence aruncareabilei3 = drive.trajectorySequenceBuilder(bilenoi1.end())
                .lineToLinearHeading(new Pose2d(12,-60, Math.toRadians(0)))
                .waitSeconds(0.500)
                .build();



        if (isStopRequested()) return;
    }
}