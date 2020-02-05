package frc.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    CANSparkMax leftA, leftB, leftC;
    SpeedControllerGroup leftDrive;
    CANSparkMax rightA, rightB, rightC;
    SpeedControllerGroup rightDrive;

    DifferentialDrive differentialDrive;

    public Drivetrain() {
        leftA = new CANSparkMax(11, CANSparkMaxLowLevel.MotorType.kBrushless);
        leftB = new CANSparkMax(6, CANSparkMaxLowLevel.MotorType.kBrushless);
        leftC = new CANSparkMax(8, CANSparkMaxLowLevel.MotorType.kBrushless);
        leftDrive = new SpeedControllerGroup(leftA, leftB, leftC);

        rightA = new CANSparkMax(9, CANSparkMaxLowLevel.MotorType.kBrushless);
        rightB = new CANSparkMax(10, CANSparkMaxLowLevel.MotorType.kBrushless);
        rightC = new CANSparkMax(12, CANSparkMaxLowLevel.MotorType.kBrushless);
        rightDrive = new SpeedControllerGroup(rightA, rightB, rightC);

        differentialDrive = new DifferentialDrive(leftDrive, rightDrive);
    }

    public void drive(double throttle, double rotation, boolean isQuickTurn) {
        differentialDrive.curvatureDrive(throttle, rotation, isQuickTurn);
    }

    //This might be useful for autos; I don't know
    public void tankDrive(double leftPower, double rightPower) {
        differentialDrive.tankDrive(leftPower, rightPower);
    }
}