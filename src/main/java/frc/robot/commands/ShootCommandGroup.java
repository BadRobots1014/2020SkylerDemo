package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ActuatorSubsystem;

public class ShootCommandGroup extends SequentialCommandGroup {
    
    public ShootCommandGroup(ActuatorSubsystem actuatorSubsystem) {
        addCommands(
            new ForwardActuatorCommand(actuatorSubsystem),
            new ReverseActuatorCommand(actuatorSubsystem)
        );
    }
}
