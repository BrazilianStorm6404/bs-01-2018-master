package utils;

import org.usfirst.frc.team6404.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public interface Tracao {
	public static Spark frontalDireito = RobotMap.Motores.Tracao.Frontal.Direito;
	public static Spark frontalEsquerda = RobotMap.Motores.Tracao.Frontal.Esquerdo;
	public static Spark traseiroDireito = RobotMap.Motores.Tracao.Traseiro.Direito;
	public static Spark traseiroEsquerdo = RobotMap.Motores.Tracao.Traseiro.Esquerdo;
	public static SpeedControllerGroup frontais = new SpeedControllerGroup(RobotMap.Motores.Tracao.Frontal.Direito, RobotMap.Motores.Tracao.Frontal.Esquerdo);
	public static SpeedControllerGroup traseiros = new SpeedControllerGroup(RobotMap.Motores.Tracao.Traseiro.Direito, RobotMap.Motores.Tracao.Traseiro.Esquerdo);
}
