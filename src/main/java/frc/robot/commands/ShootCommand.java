package frc.robot.commands;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.Timer;


public class ShootCommand extends CommandBase 
{
    private final ShooterSubsystem m_shooter;  
    // private DoubleSupplier m_shooterDoubleSupplier = () -> 0.0;

    Timer m_timer = new Timer();
    
    public ShootCommand(ShooterSubsystem subsystem)
    {
        m_shooter = subsystem;
        m_timer.reset();

        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
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
        m_shooter.startShooter();
        if (m_timer.get() < 1.0) {
            m_shooter.startActuator();
        } else {
            m_shooter.stopActuator();
        }
    }

    @Override
    public void end(boolean interrupted) {
        m_shooter.stopShooter();
        m_shooter.stopActuator();
    }
    
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

}
