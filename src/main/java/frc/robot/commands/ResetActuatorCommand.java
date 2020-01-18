package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.Timer;

public class ResetActuatorCommand extends CommandBase {

    private final ShooterSubsystem m_shooter;

    Timer m_timer = new Timer();

    public ResetActuatorCommand(ShooterSubsystem subsystem)
    {
        m_shooter = subsystem;
        m_timer.reset();

        addRequirements(subsystem);
    }
    
    @Override
    public void initialize()
    {
        m_timer.start();
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
        if (m_shooter.getActuatorSwitch() == true && m_timer.get() < 0.8) {
            return false;
        } else {
            m_shooter.stopActuator();
            return true;
        }
    }
}
