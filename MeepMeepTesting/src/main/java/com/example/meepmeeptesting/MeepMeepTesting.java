package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

import java.nio.file.attribute.PosixFileAttributes;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(600);

        DefaultBotBuilder defaultBotBuilder = new DefaultBotBuilder(meepMeep);
        defaultBotBuilder.setConstraints(65, 65, Math.toRadians(180), Math.toRadians(180), 15);// Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
        RoadRunnerBotEntity myBot = defaultBotBuilder
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-36, -66, Math.toRadians(90)))
                                .splineToSplineHeading(new Pose2d(-24,-35, Math.toRadians(0)), Math.toRadians(0))
                                .splineToSplineHeading(new Pose2d(-8,-23, Math.toRadians(0)), Math.toRadians(85))
                                .waitSeconds(0.250)
                                .turn(Math.toRadians(90))
                                .splineToSplineHeading(new Pose2d(-24,-11, Math.toRadians(0)), Math.toRadians(180))
                                .splineToConstantHeading(new Vector2d(-58,-12) ,Math.toRadians(180))
                                .waitSeconds(Math.toRadians(0.250))

                                .splineToLinearHeading(new Pose2d(-30,-17, Math.toRadians(-45)), Math.toRadians(-80))
                                .waitSeconds(Math.toRadians(0.250))
                                .lineToSplineHeading(new Pose2d(-58,-12, Math.toRadians(0)))

                                .splineToLinearHeading(new Pose2d(-30,-17, Math.toRadians(-45)), Math.toRadians(-80))
                                .waitSeconds(Math.toRadians(0.250))
                                .lineToSplineHeading(new Pose2d(-58,-12, Math.toRadians(0)))

                                .splineToLinearHeading(new Pose2d(-30,-17, Math.toRadians(-45)), Math.toRadians(-80))
                                .waitSeconds(Math.toRadians(0.250))
                                .lineToSplineHeading(new Pose2d(-58,-12, Math.toRadians(0)))

                                .splineToLinearHeading(new Pose2d(-30,-17, Math.toRadians(-45)), Math.toRadians(-80))
                                .waitSeconds(Math.toRadians(0.250))
                                .lineToSplineHeading(new Pose2d(-58,-12, Math.toRadians(0)))

                                .splineToLinearHeading(new Pose2d(-30,-17, Math.toRadians(-45)), Math.toRadians(-80))
                                .waitSeconds(Math.toRadians(0.250))
                                .lineToSplineHeading(new Pose2d(-58,-12, Math.toRadians(0)))

                                .build()
                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_KAI_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}