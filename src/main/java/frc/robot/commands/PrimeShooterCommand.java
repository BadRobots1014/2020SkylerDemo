package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;

public class PrimeShooterCommand extends CommandBase {

    private final ShooterSubsystem m_shooter;
    
    Timer m_timer = new Timer();

    public PrimeShooterCommand(ShooterSubsystem subsystem) {
        m_shooter = subsystem;
        m_timer.reset();

        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        m_timer.start();
    }

    @Override
    public void execute() {
        m_shooter.startShooter();
    }

    @Override
    public boolean isFinished()
     {
        if (m_timer.get() < 1.0) {
            return false;
        } else {
            return true;
        }
    }

}
