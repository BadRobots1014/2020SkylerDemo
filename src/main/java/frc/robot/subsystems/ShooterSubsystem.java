//This is where the shooter code goes on Skylar.



package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.Constants.ShooterConstants;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class ShooterSubsystem extends SubsystemBase
{
    private final PWMTalonSRX shooterMotor1 = new PWMTalonSRX(ShooterConstants.kMotor1Port);
    private final PWMTalonSRX shooterMotor2 = new PWMTalonSRX(ShooterConstants.kMotor2Port);

    private final PWMTalonSRX actuatorMotor = new PWMTalonSRX(ShooterConstants.kActuatorMotorPort);

    private final SpeedControllerGroup m_shooterMotors;

    public ShooterSubsystem()
    {
        m_shooterMotors = new SpeedControllerGroup(shooterMotor1, shooterMotor2, actuatorMotor);
    }

    public void resetActuator()
    {
        actuatorMotor.set(0.9);
    }
    
    public void setMaxOutput()
    {
        m_shooterMotors.set(0.9);
    }
    
    public void stop()
    {
        m_shooterMotors.stopMotor();
    }
    
}