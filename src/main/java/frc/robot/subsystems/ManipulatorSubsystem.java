package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.NTManager;
import frc.robot.Constants;

public class ManipulatorSubsystem extends SubsystemBase {

    private CANSparkMax shouldar;
    private CANSparkMax manipulator;



    public ManipulatorSubsystem() {
        shouldar = new CANSparkMax(Constants.shouldarMotorPort, MotorType.kBrushless);

        manipulator = new CANSparkMax(Constants.manipulatorMotorPort, MotorType.kBrushless);

        

    }


@Override
public void simulationPeriodic() {

}

public void setShouldarSpeed(double speed) {
    shouldar.set(speed);
}

public void setManipulatorOnOrOff(Boolean trueIfOn) {
    if(trueIfOn) {
        manipulator.set(1);
    } else {
        manipulator.set(-1);
    }
}

}