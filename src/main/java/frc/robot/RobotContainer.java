// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.DriveWithJoystickCommand;
import frc.robot.commands.auto_DriveWithJoystickCommand;
//import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.DriveTrainSubsystem;
//import edu.wpi.first.wpilibj.GenericHID.RumbleType;
//import frc.robot.subsystems.IntakeSubsystem;
//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;


public class RobotContainer {



  public static CommandXboxController m_driverController = new CommandXboxController(0); //Sets up controller

//////////
//////////THIS CODE SETS UP SUBSYSTEMS THEN COMMANDS!!!
//////////

  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  public final static DriveTrainSubsystem driveTrainSubsystem = new DriveTrainSubsystem();


  private final DriveWithJoystickCommand DriveWithJoystickCommand = new DriveWithJoystickCommand(driveTrainSubsystem);

  public double autonTime = 0;


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    driveTrainSubsystem.setDefaultCommand(DriveWithJoystickCommand); //Sets default command to the driving command (duh)


  }


  private void configureBindings() {
    //If we had any actual button bindings they will be thrown here
  }

    



   public static double deadband(double value, double deadband) { //A command I have to try and get controller deadband, I stole this.
    if (Math.abs(value) > deadband) {
      if (value > 0.0) {
        return (value - deadband) / (1.0 - deadband);
      } else {
        return (value + deadband) / (1.0 - deadband);
      }
    } else {
      return 0.0;
    }
  }

  public static boolean between(double valueLeast, double valueMost, double value) { //A cool between function that I forgot if I stole or wrote myself
    if ((value > valueLeast) && (value < valueMost))
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  public Command getAutonomousCommand() { //This is a very basic rought auton, this can help you get the basic understanding of how autons work.
    //return DriveWithJoystickCommand;
    System.out.println("Starting auto stuff");
    
    autonTime += 0.1;
    return new SequentialCommandGroup(
      new auto_DriveWithJoystickCommand(driveTrainSubsystem,0.5,7.5, 0.0) //drives the bot back 
    );
    
  }
}


