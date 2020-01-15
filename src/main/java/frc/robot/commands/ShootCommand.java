package frc.robot.commands;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;


public class ShootCommand extends CommandBase 
{
    private final ShooterSubsystem m_shooter;  
    // private DoubleSupplier m_shooterDoubleSupplier = () -> 0.0;

    
    public ShootCommand(ShooterSubsystem subsystem)
    {
        m_shooter = subsystem;

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
        
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute()
    {
        m_shooter.setMaxOutput();
    }

    @Override
    public void end(boolean interrupted) {
        m_shooter.stop();
    }
    
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

}
