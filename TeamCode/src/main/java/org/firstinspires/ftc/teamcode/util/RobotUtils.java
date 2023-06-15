package org.firstinspires.ftc.teamcode.util;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class RobotUtils {

    public DcMotor pendul;
    public DcMotor outake;
    public Servo intake;
    public Servo cleste;
    public Servo cleste_outake;
    public Servo servo_outake;
    public RevColorSensorV3 sensor_intake;

    public int gheara_sus_pos = 0;
    public int gheara_jos_pos = 0;
    public int gheara_neutru_pos = 0;
    public int intake_to_outake = 0;
    public int pendul_sus_pos = 0;
    public int pendul_jos_pos = 0;
    public int pendul_neutru_pos = 0;
    public int pendul_intake_to_outake = 0;
    public int pendul_power = 1;
    public int pendul_power_down =-1;
    public int cleste_deschis = 0;
    public int cleste_inchis = 0;
    public int cleste_outake_deschis = 0;
    public int cleste_outake_inchis = 0;
    public int outake_pos = 0;
    public int outake_reset_pos = 0;
    public int outake_servo_pos = 0;
    public int outake_servo_reset_pos = 0;
    public int outake_power = 1;
    public int outake_power_down = -1;
    public boolean flipped = false;

    public RobotUtils(HardwareMap hardwareMap){
        pendul = hardwareMap.get(DcMotor.class, "pendul");
        intake = hardwareMap.get(Servo.class, "intake");
        sensor_intake = hardwareMap.get(RevColorSensorV3.class, "sensorintake");
        cleste = hardwareMap.get(Servo.class, "cleste");
        outake = hardwareMap.get(DcMotor.class, "outake");
        servo_outake = hardwareMap.get(Servo.class, "servo_outake");
    }

    public void gheara_sus(){
        intake.setPosition(gheara_sus_pos);
        pendul.setTargetPosition(pendul_sus_pos);
        pendul.setPower(pendul_power);
        pendul.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void gheara_jos(){
        intake.setPosition(gheara_jos_pos);
        pendul.setTargetPosition(pendul_jos_pos);
        pendul.setPower(pendul_power_down);
        pendul.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public void gheara_neutru(){
        intake.setPosition(gheara_neutru_pos);
        pendul.setTargetPosition(pendul_neutru_pos);
        if(pendul.getCurrentPosition()>0)
            pendul.setPower(pendul_power_down);
        else
            pendul.setPower(pendul_power);
        pendul.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void intake_to_outake(){
        //TODO: Retragere extendo daca e extins
        intake.setPosition(intake_to_outake);
        pendul.setTargetPosition(pendul_intake_to_outake);
        pendul.setPower(pendul_power);
        pendul.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        if(intake.getPosition()==intake_to_outake){
            flipped = true;
            cleste.setPosition(cleste_deschis);
        }
        intake.setPosition(gheara_neutru_pos);
        pendul.setTargetPosition(pendul_neutru_pos);
        pendul.setPower(pendul_power_down);
        pendul.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        flipped = false;
    }

    public void outake(){
        //TODO: Sa se ridice slidere-le inainte de a da flip la gheara
        outake.setTargetPosition(outake_pos);
        outake.setPower(outake_power);
        outake.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        if(outake.getCurrentPosition()==outake_pos)
            cleste_outake.setPosition(cleste_outake_deschis);
    }

    public void outake_reset(){
        outake.setTargetPosition(outake_reset_pos);
        outake.setPower(outake_power_down);
        outake.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //TODO: Sa coboare slidere-le dupa ce gheara a dat flip
    }

    public void outake_servo_jos(){
        servo_outake.setPosition(outake_servo_pos);
    }

    public void outake_servo_reset(){
        servo_outake.setPosition(outake_servo_reset_pos);
    }

    public boolean hasDetected(){
        if(sensor_intake.blue()>200 || sensor_intake.red()>200 && !flipped)
            return true;
        else
            return false;
    }

    //TODO: Functie pentru detectia pole-u-lui
}
