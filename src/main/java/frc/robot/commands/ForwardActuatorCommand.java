package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ActuatorSubsystem;
import edu.wpi.first.wpilibj.Timer;


public class ForwardActuatorCommand extends CommandBase 
{
    private final ActuatorSubsystem m_actuator;
    // private DoubleSupplier m_shooterDoubleSupplier = () -> 0.0;

    Timer m_timer = new Timer();
    
    public ForwardActuatorCommand(ActuatorSubsystem actuatorSubsystem)
    {
        m_actuator = actuatorSubsystem;

        m_timer.reset();

        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(actuatorSubsystem);
    }
    
    /*
    public void setControllerSupplier( DoubleSupplier shooterDoubleSupplier)
    {
        m_shooterDoubleSupplier = shooterDoubleSupplier;
    }
    */

    @Override
    public void initialize()
    {
        m_timer.start();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute()
    {
        m_actuator.setActuatorForward();
    }
    
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if (m_timer.get() < 0.75) {
            return false;
        } else {
            m_actuator.stopActuator();
            return true;
        }
    }
}
