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

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class RobotUtils {
    public DcMotor slider1;
    public DcMotor slider2;
    public Servo intake;
    public Servo brat1;
    public Servo brat2;
    public Servo pivot;
    public RevColorSensorV3 sensor;
    public int slider1_high = 0;
    public int slider2_high = 0;
    public int slider1_mid = 0;
    public int slider2_mid = 0;
    public int slider1_down = 0;
    public int slider2_down = 0;
    public int intake_open = 0;
    public int intake_close = 0;
    public int brat1_up = 0;
    public int brat1_low = 0;
    public int brat2_up = 0;
    public int brat2_low = 0;
    public int brat1_return = 0;
    public int brat2_return = 0;
    public int pivot_turn = 0;
    public int pivot_return = 0;

    public RobotUtils(HardwareMap hardwareMap)
    {
        slider1 = hardwareMap.get(DcMotor.class, "slider1");
        slider2 = hardwareMap.get(DcMotor.class, "slider2");
        intake = hardwareMap.get(Servo.class, "intake");
        brat1 = hardwareMap.get(Servo.class, "brat1");
        brat2 = hardwareMap.get(Servo.class, "brat1");
        pivot = hardwareMap.get(Servo.class, "pivot");
        sensor = hardwareMap.get(RevColorSensorV3.class, "sensor");
    }

    public void goHigh(){
        slider1.setTargetPosition(slider1_high);
        slider2.setTargetPosition(slider2_high);
        slider1.setPower(0.5);
        slider2.setPower(-0.5);
        slider1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slider2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void goMid(){
        slider1.setTargetPosition(slider1_mid);
        slider2.setTargetPosition(slider2_mid);
        slider1.setPower(0.5);
        slider2.setPower(-0.5);
        slider1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slider2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void goLow(){
        brat1.setPosition(brat1_low);
        brat2.setPosition(brat2_low);
    }

    public void goDown(){
        slider1.setTargetPosition(slider1_down);
        slider2.setTargetPosition(slider2_down);
    }

    public void flip(){
        brat1.setPosition(brat1_up);
        brat2.setPosition(brat2_up);
    }

    public void brat_return(){
        brat1.setPosition(brat1_return);
        brat2.setPosition(brat2_return);
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

    public boolean lifed(){
        if(slider1.getCurrentPosition() > 300 && slider2.getCurrentPosition() > 300)
            return true;
        else return false;
    }

    public boolean hasDetected(){
        if(sensor.red() >= 400 || sensor.blue() >= 400 && lifed())
            return true;
        else return false;
    }
}