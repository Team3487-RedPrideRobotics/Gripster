package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.TeleopCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ManipulatorSubsystem;

public class RobotContainer {


  private static RobotContainer m_robotContainer = new RobotContainer();

  private static DriveSubsystem m_DriveSubsystem = new DriveSubsystem();
  private static ManipulatorSubsystem m_ManipulatorSubsystem = new ManipulatorSubsystem();
  
  private TeleopCommand m_teleopCommand = new TeleopCommand(m_DriveSubsystem, m_ManipulatorSubsystem );

  // Controllers
  private final CommandXboxController driveController = new CommandXboxController(0);
  private final CommandXboxController operatorController = new CommandXboxController(1);

  private RobotContainer() {
    configureButtonBindings();
    NTManager.initialize();
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }


  private void configureButtonBindings() {
    
  }

  
  public CommandXboxController getDriverController() {
      return driveController;
      //quincy in spirit
  }
  public CommandXboxController getOperatorController() {
    return operatorController;
  }



  public Command getAutonomousCommand() {
    return null;
  }

  public Command getTeleopCommand() {
    return m_teleopCommand;
  }


  

}

