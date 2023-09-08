package frc.robot;

import edu.wpi.first.networktables.DoublePublisher;
import edu.wpi.first.networktables.DoubleSubscriber;
import edu.wpi.first.networktables.NetworkTableInstance;

public class NTManager{

    public static DoublePublisher someSpeedPub;
    public static DoubleSubscriber someSpeedSub;



public static void initialize() {
    var networkTable = NetworkTableInstance.getDefault();
    var gripsterTable = networkTable.getTable("Gripster Table");
    
    //drive speed
    var driveSpeedTopic = gripsterTable.getDoubleTopic("Some Speed");
    someSpeedPub = driveSpeedTopic.publish();
    someSpeedPub.setDefault(Constants.someSpeed);
    someSpeedSub = driveSpeedTopic.subscribe(Constants.someSpeed);

}
}