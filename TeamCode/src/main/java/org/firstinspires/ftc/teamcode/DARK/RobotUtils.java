/*** ⣤⣤⣄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣾⡿⣿⣇⠀⠀⠀⠀
 ⣿⢏⣹⣳⣯⣗⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⡿⠃⠒⣜⣮⢧⡀⠀⠀
 ⣿⡞⠁⡉⠙⠻⣷⣿⢦⣤⣤⣶⣶⣶⣶⣶⣶⣾⣿⡿⠋⠀⠌⡐⠈⢿⣿⣣⠀⠀
 ⣿⠀⢂⠐⡁⢂⣬⣿⣿⢫⠉⠀⠀⠀⠀⠀⠀⠜⡹⢿⣿⣿⣶⣶⣤⣈⣿⣷⣗⠀
 ⡇⢀⣦⣼⣾⣿⣿⣿⡭⡃⠌⠀⠀⠀⠀⠀⠀⠀⠑⡹⣚⢿⣿⣿⣿⣿⣿⣿⣼⠀
 ⣿⣿⣿⣿⣿⣿⣟⢧⢃⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠉⢎⠳⢯⡟⣿⣻⢿⣯⡷
 ⣿⣿⡿⣟⡿⡓⢎⠂⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⣰⣬⣧⡝⢊⠙⣷
 ⠟⢧⠛⠥⠃⢉⠀⣴⣾⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⣿⠀⠀⢸
 ⠈⠄⡈⠤⣁⠢⡀⢿⣿⣿⣿⠃⠀⠀⠀⠀⢠⡄⠀⣴⠀⠀⡀⢙⢛⡛⠭⢠⠃⢆
 ⠐⡠⢑⡒⡄⠓⡌⣌⢩⣩⠷⠶⣤⠀⠀⠀⠀⠳⠾⠃⢀⢸⡼⠋⠋⠛⢦⡃⠞⡠
 ⢀⠱⡈⢖⡈⢣⠜⣠⠟⠀⠀⠀⠀⢳⡄⠀⠀⠀⠀⠀⠐⣾⠁⠀⠀⠀⠈⢧⢣⢸
 ⣆⠠⢑⠢⣉⠆⢼⡟⠀⠀⠀⠀⠀⠈⣷⠀⠀⠀⠀⠀⢸⡇⠀⠀⠀⠀⠀⠈⣷⢯
 ⡏⠀⠀⢁⠂⢌⡟⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠈⣗⠀⠀⠀⠀⠀⠀⠈⢯
 ⠀⠀⠀⠀⠀⠋⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⢿⡀⠀⠀⠀⠀⠀⠀⠀
 ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⡇⠀⠀⠀⠀⠀⠀⠘⣷⠀⠀⠀⠀⠀⠀⠀
***/



package org.firstinspires.ftc.teamcode.DARK;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Config
public class RobotUtils {
    public DcMotor slider1;
    public DcMotor slider2;
    public Servo intake;

    public static int slider1_high = 4000;//3500
    public static int slider2_high = -4000;
    public static int slider1_mid = 2850;
    public static int slider2_mid = -2850;
    public static int slider1_down = 35;
    public static int slider2_down = -35;
    public static int slider1_low = 1600;
    public static int slider2_low = -1600;
    public static double intake_open = 0;
    public static double intake_close = 0.35;
    public static double  brat_up = 1;
    public static double brat_return = 0;
    public static double pivot_return = 0;
    public static double pivot_turn = 0.66;

    public RobotUtils(HardwareMap hardwareMap)
    {
        slider1 = hardwareMap.get(DcMotor.class, "slider1");
        slider2 = hardwareMap.get(DcMotor.class, "slider2");
        intake = hardwareMap.get(Servo.class, "intake");


        slider1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slider1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        slider2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slider2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        slider1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slider2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void goHigh(){
        slider1.setTargetPosition(slider1_high);
        slider2.setTargetPosition(slider2_high);
        slider1.setPower(0.9);
        slider2.setPower(-0.9);
        slider1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slider2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void goMid(){
        slider1.setTargetPosition(slider1_mid);
        slider2.setTargetPosition(slider2_mid);
        slider1.setPower(0.9);
        slider2.setPower(-0.9);
        slider1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slider2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void goLow(){
        slider1.setTargetPosition(slider1_low);
        slider2.setTargetPosition(slider2_low);
        slider1.setPower(0.9);
        slider2.setPower(-0.9);
        slider1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slider2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void goDown(){
        slider1.setTargetPosition(slider1_down);
        slider2.setTargetPosition(slider2_down);
        slider1.setPower(-0.9);
        slider2.setPower(0.9);
        slider1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slider2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    /*public void flip(){
        brat1.setPosition(brat_up);
        brat2.setPosition(brat_up);
    }

    public void brat_return(){
        brat1.setPosition(brat_return);
        brat2.setPosition(brat_return);
    }

    public void flip_cone(){
        pivot.setPosition(pivot_turn);
    }

    public void return_cone(){pivot.setPosition(pivot_return);}
*/
    public void open_intake(){
        intake.setPosition(intake_open);
    }

    public void close_intake(){
        intake.setPosition(intake_close);
    }

    public boolean lifted(){
        if(slider1.getCurrentPosition() >= 500 && slider2.getCurrentPosition() <= -500)
            return true;
        else return false;
    }
 /*   public boolean hasDetected(){
        if(sensor.getDistance(DistanceUnit.MM) <= 15)
            return true;
        else return false;
    }*/
}