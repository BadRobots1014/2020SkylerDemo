package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;

public class ResetActuatorCommand extends CommandBase {

    private final ShooterSubsystem m_shooter;

    public ResetActuatorCommand(ShooterSubsystem subsystem)
    {
        m_shooter = subsystem;

        addRequirements(subsystem);
    }
    
    @Override
    public void initialize()
    {
        
    }
    
    @Override
    public void execute()
    {
        m_shooter.resetActuator();
    }
    
    @Override
    public void end(boolean interrupted) {
        
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
