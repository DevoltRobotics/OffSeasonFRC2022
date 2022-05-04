package frc.robot.subsystem;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
    
  MotorControllerGroup left = new MotorControllerGroup(new PWMSparkMax(0), new PWMSparkMax(1));
  MotorControllerGroup right = new MotorControllerGroup(new PWMSparkMax(2), new PWMSparkMax(3));

  DifferentialDrive drive = new DifferentialDrive(left, right);

  public void driveArcade(double y, double rotation) {
      drive.arcadeDrive(y, rotation);
  }
  
}
