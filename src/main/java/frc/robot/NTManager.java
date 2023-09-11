package frc.robot;

import edu.wpi.first.networktables.DoublePublisher;
import edu.wpi.first.networktables.DoubleSubscriber;
import edu.wpi.first.networktables.NetworkTableInstance;

public class NTManager{

    public static DoublePublisher shouldarSpeedPub;
    public static DoubleSubscriber shouldarSpeedSub;



public static void initialize() {
    var networkTable = NetworkTableInstance.getDefault();
    var gripsterTable = networkTable.getTable("Gripster Table");
    
    //Shouldar Speed
    var driveSpeedTopic = gripsterTable.getDoubleTopic("Some Speed");
    shouldarSpeedPub = driveSpeedTopic.publish();
    shouldarSpeedPub.setDefault(Constants.shouldarSpeed);
    shouldarSpeedSub = driveSpeedTopic.subscribe(Constants.shouldarSpeed);

}
}