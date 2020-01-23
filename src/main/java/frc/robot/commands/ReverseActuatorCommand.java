package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ActuatorSubsystem;
import edu.wpi.first.wpilibj.Timer;

public class ReverseActuatorCommand extends CommandBase {
    private final ActuatorSubsystem m_actuator;

    Timer m_timer = new Timer();

    public ReverseActuatorCommand(ActuatorSubsystem actuatorSubsystem)
    {
        m_actuator = actuatorSubsystem;
        m_timer.reset();

        addRequirements(actuatorSubsystem);
    }
    
    @Override
    public void initialize()
    {
        m_timer.start();
    }
    
    @Override
    public void execute()
    {
        m_actuator.setActuatorReverse();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if (m_actuator.getActuatorSwitch() == true && m_timer.get() < 0.8) {
            return false;
        } else {
            m_actuator.stopActuator();
            return true;
        }
    }
    
}
