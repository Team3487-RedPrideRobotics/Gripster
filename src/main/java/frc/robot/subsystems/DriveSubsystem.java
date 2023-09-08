package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

    private Spark leftDrive;
    private Spark rightDrive;

    private DifferentialDrive differentialDrive;


    public DriveSubsystem() {

        leftDrive = new Spark(Constants.leftDriveMotorPort);
        leftDrive.setInverted(Constants.leftMotorInverse);

        rightDrive = new Spark(Constants.rightDriveMotorPort);
        rightDrive.setInverted(Constants.rightMotorInverse);


        differentialDrive = new DifferentialDrive(leftDrive, rightDrive);

        differentialDrive.setSafetyEnabled(true);
        differentialDrive.setExpiration(0.1);
        differentialDrive.setMaxOutput(1.0);

    }


@Override
public void simulationPeriodic() {

}

public void tankDrive(double leftSpeed, double rightSpeed) {
    differentialDrive.tankDrive(leftSpeed, rightSpeed);

    
}

}
