package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ShooterSubsystem;

public class ShootCommandGroup extends SequentialCommandGroup {
    
    public ShootCommandGroup(ShooterSubsystem shooterSubsystem) {
        addCommands(
            new PrimeShooterCommand(shooterSubsystem),
            new ShootCommand(shooterSubsystem),
            new ResetActuatorCommand(shooterSubsystem)
        );
    }

}