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
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Config
public class RobotUtils {
    public DcMotor slider1;
    public DcMotor slider2;
    public Servo intake;
    public DcMotor brat;
    public Servo pivot;
//    public RevColorSensorV3 sensor;
    public static int slider1_high = 4000;
    public static int slider2_high = -4000;
    public static int slider1_mid = 2800;
    public static int slider2_mid = -2800;
    public static int slider1_down = 35;
    public static int slider2_down = -35;
    public static int slider1_low = 1600;
    public static int slider2_low = -1600;
    public static double intake_open = 0;
    public static double intake_close = 0.5;
    public static int brat_up = 0;
    public static int brat_return = 0;
    public static double pivot_turn = 0;
    public static double pivot_return = 0;

    public RobotUtils(HardwareMap hardwareMap)
    {
        slider1 = hardwareMap.get(DcMotor.class, "slider1");
        slider2 = hardwareMap.get(DcMotor.class, "slider2");
        intake = hardwareMap.get(Servo.class, "intake");
        brat = hardwareMap.get(DcMotor.class, "brat");
        pivot = hardwareMap.get(Servo.class, "pivot");
//        sensor = hardwareMap.get(RevColorSensorV3.class, "sensor");
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

    public void flip(){
        brat.setTargetPosition(brat_up);
        brat.setPower(0.6);
        brat.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void brat_return(){
        brat.setTargetPosition(brat_return);
        brat.setPower(-0.6);
        brat.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void flip_cone(){
        pivot.setPosition(pivot_turn);
    }

    public void return_cone(){pivot.setPosition(pivot_return);}

    public void open_intake(){
        intake.setPosition(intake_open);
    }

    public void close_intake(){
        intake.setPosition(intake_close);
    }

//    public boolean lifed(){
//        if(slider1.getCurrentPosition() > 300 && slider2.getCurrentPosition() > 300)
//            return true;
//        else return false;
//    }
//    public boolean hasDetected(){
//        if(sensor.red() >= 400 || sensor.blue() >= 400 && lifed())
//            return true;
//        else return false;
//    }
}