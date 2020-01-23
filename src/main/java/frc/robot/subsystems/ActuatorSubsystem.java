//This is where the shooter code goes on Skylar.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import frc.robot.Constants.ActuatorConstants;

public class ActuatorSubsystem extends SubsystemBase
{
    private final PWMTalonSRX m_actuatorMotor = new PWMTalonSRX(ActuatorConstants.kActuatorMotorPort);

    private final DigitalInput m_actuatorSwitch = new DigitalInput(ActuatorConstants.kActuatorSwitchPort);

    public ActuatorSubsystem()
    {
        
    }

    public void setActuatorForward()
    {
        m_actuatorMotor.set(0.5);
    }

    public void setActuatorReverse()
    {
        m_actuatorMotor.set(-0.5);
    }

    public void stopActuator()
    {
        m_actuatorMotor.stopMotor();
    }

    public boolean getActuatorSwitch()
    {
        return m_actuatorSwitch.get();
    }
    
}
