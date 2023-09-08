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
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PwmControl;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImplEx;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Config
public class RobotUtils {
    public DcMotor slider;
    public DcMotor intake;
    public DcMotor launcher;
    public ServoImplEx flip;
    public Servo catcher;
    public RevColorSensorV3 sensor;
    int flip_pos = 0;
    int return_pos = 0;
    int close_pos = 0;
    int open_pos = 0;
    int start_pos= 0;

    public RobotUtils(HardwareMap hardwareMap){
        slider = hardwareMap.get(DcMotorEx.class, "slider");
        intake = hardwareMap.get(DcMotorEx.class, "intake");
        launcher = hardwareMap.get(DcMotorEx.class, "launcher");
        flip = hardwareMap.get(ServoImplEx.class, "flip");
        catcher = hardwareMap.get(Servo.class, "catcher");
        sensor = hardwareMap.get(RevColorSensorV3.class, "sensor");

        intake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        launcher.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        slider.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slider.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        flip.setPwmEnable();
        flip.setPwmRange(new PwmControl.PwmRange(505, 2495));
    }

    public boolean hasDetected(){
        if(sensor.getDistance(DistanceUnit.CM) < 3) return true;
        else return false;
    }

    public void goSliderToPosition(int position, double power) {
        // Ensure that power is positive.
        double absPower = Math.abs(power);

        // Get the current position of the slider.
        int currentPos = slider.getCurrentPosition();

        // Set the target position of both slider motors.
        slider.setTargetPosition(position);

        // Set the run mode of both slider motors to RUN_TO_POSITION.
        slider.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        if (currentPos > position) {
            // If the current position is higher than the target position, move the sliders down.
            slider.setPower(-absPower);
        }
        else if (currentPos < position) {
            // If the current position is lower than the target position, move the sliders up.
            slider.setPower(absPower);
        }
        // If the current position is already at the target position, the sliders do not need to move.
    }

    public void flip_start_pos(){
        flip.setPosition(start_pos);
    }

    public void close_catcher(){
        catcher.setPosition(close_pos);
    }

    public void open_catcher(){
        catcher.setPosition(open_pos);
    }

    public void flip_ball(){
        flip.setPosition(flip_pos);
    }

    public void return_ball(){
        flip.setPosition(return_pos);
        open_catcher();
    }
}