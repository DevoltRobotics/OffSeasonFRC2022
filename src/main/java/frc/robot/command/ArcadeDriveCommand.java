package frc.robot.command;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystem.DrivetrainSubsystem;

public class ArcadeDriveCommand extends CommandBase {
    
    DrivetrainSubsystem subsystem;
    Joystick joystick;

    boolean speedControl;
    double minSpeed;
    
    public ArcadeDriveCommand(DrivetrainSubsystem subsystem, Joystick joystick) {
        this.subsystem = subsystem;
        this.joystick = joystick;

        addRequirements(subsystem);
    }

    public ArcadeDriveCommand(DrivetrainSubsystem subsystem, Joystick joystick, double minSpeed) {
        this(subsystem, joystick);

        this.speedControl = true;
        this.minSpeed = minSpeed;
    }

    @Override
    public void execute() {
        double turbo = 1.0;

        if(speedControl) {
            turbo = 1.0 - joystick.getRawAxis(4) * 0.7;
        }

        subsystem.driveArcade(-joystick.getY() * turbo, -joystick.getX() * turbo);
    }

}