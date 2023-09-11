package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.NTManager;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ManipulatorSubsystem;




public class TeleopCommand extends CommandBase {

    private DriveSubsystem m_drive;
    private ManipulatorSubsystem m_manipulator;

    public TeleopCommand(DriveSubsystem drive, ManipulatorSubsystem manipulator) {
        m_drive = drive;
        addRequirements(m_drive);

        m_manipulator = manipulator;
        addRequirements(m_manipulator);

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

        CommandXboxController operator_controller = RobotContainer.getInstance().getOperatorController();

        //shouldar speed
        m_manipulator.setShouldarSpeed(operator_controller.getRightY() * NTManager.shouldarSpeedSub.get());

        //manipulator
        m_manipulator.setManipulatorOnOrOff(operator_controller.getRightTriggerAxis() >= 0.5);
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
