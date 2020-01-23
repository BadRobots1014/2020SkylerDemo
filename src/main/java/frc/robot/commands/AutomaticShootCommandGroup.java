package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ActuatorSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.commands.ActivateShooterCommand;

public class AutomaticShootCommandGroup extends SequentialCommandGroup {

    public AutomaticShootCommandGroup(ShooterSubsystem shooterSubsystem, ActuatorSubsystem actuatorSubsystem) {
        addCommands(
            new ParallelRaceGroup(
                new WaitCommand(2),
                new ActivateShooterCommand(shooterSubsystem)
            ),
            new ParallelRaceGroup(
                new ActivateShooterCommand(shooterSubsystem),
                new ShootCommandGroup(actuatorSubsystem)
            )
        );
    }
}
