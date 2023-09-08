package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.NTManager;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;




public class TeleopCommand extends CommandBase {

    private DriveSubsystem m_drive;

    public TeleopCommand(DriveSubsystem drive) {
        m_drive = drive;
        addRequirements(m_drive);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        
          
        CommandXboxController drive_controller = RobotContainer.getInstance().getDriverController();
        
        if(drive_controller.getRightTriggerAxis() >= 0.1){
            m_drive.tankDrive(drive_controller.getLeftY(), drive_controller.getRightY());
        }else{
            m_drive.tankDrive(drive_controller.getLeftY(), drive_controller.getRightY());
        }
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
