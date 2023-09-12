// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
//import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

//SPARK MAX



public class DriveTrainSubsystem extends SubsystemBase {

//Assigns all your motors
  
  Spark leftMotor1 = new Spark(0);
  Spark leftMotor2 = new Spark(0);
  Spark rightMotor1 = new Spark(0);
  Spark rightMotor2= new Spark(0);
/* IF YOU USE CANSPARKMAX YOU WANT THESE!!!!
  CANSparkMax leftMotor1 = new CANSparkMax(Constants.DriveTrainConstants.leftMotor1ID, MotorType.kBrushless);
  CANSparkMax leftMotor2 = new CANSparkMax(Constants.DriveTrainConstants.leftMotor2ID, MotorType.kBrushless);

  CANSparkMax rightMotor1 = new CANSparkMax(Constants.DriveTrainConstants.rightMotor1ID, MotorType.kBrushless);
  CANSparkMax rightMotor2 = new CANSparkMax(Constants.DriveTrainConstants.rightMotor2ID, MotorType.kBrushless);

  RelativeEncoder leftEncoder = leftMotor1.getEncoder();
  RelativeEncoder rightEncoder = rightMotor1.getEncoder();
*/

  MotorControllerGroup leftControllerGroup = new MotorControllerGroup(leftMotor1, leftMotor2);
  MotorControllerGroup rightControllerGroup = new MotorControllerGroup(rightMotor1, rightMotor2);

  DifferentialDrive differentialDrive = new DifferentialDrive(leftControllerGroup, rightControllerGroup);



  public DriveTrainSubsystem(){ 
/* IF YOU USE CANSPARKMAX YOU WANT THESE!!!
    leftMotor1.restoreFactoryDefaults();
    leftMotor2.restoreFactoryDefaults();

    rightMotor1.restoreFactoryDefaults();
    rightMotor2.restoreFactoryDefaults();
*/

    leftMotor1.setVoltage(Constants.DriveTrainConstants.maxVoltage);
    rightMotor1.setVoltage(Constants.DriveTrainConstants.maxVoltage);



   // leftEncoder.setPosition(0);
   // rightEncoder.setPosition(0);

   //You run the .follow function to make child motors follow their parents
    //leftMotor2.follow(leftMotor1);
    //rightMotor2.follow(rightMotor1);

    
    rightControllerGroup.setInverted(true);
    leftControllerGroup.setInverted(false);
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {

    return runOnce(
        () -> {

        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //System.out.print(leftMotor1.getBusVoltage());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
  public void arcadeDrive(double fwd, double rot) {
    differentialDrive.arcadeDrive(fwd, rot);
  }
  // Assuming this method is part of a drivetrain subsystem that provides the necessary methods
}
