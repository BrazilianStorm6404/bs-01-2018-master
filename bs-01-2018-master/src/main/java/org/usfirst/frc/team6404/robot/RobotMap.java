/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6404.robot;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.SPI;
import utils.ImprovedMotor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */

public class RobotMap {
	//Secao de declaracao de motores
	private static final int motorFrontalDireito = 0;
	private static final int motorFrontalEsquerdo = 1;
	private static final int motorTraseiroDireito = 2;
	private static final int motorTraseiroEsquerdo = 3;
	public static class Motores {
		public static class Tracao {
			public static class Frontal {
				public static final Spark Direito = new ImprovedMotor(motorFrontalDireito);
				public static final Spark Esquerdo = new ImprovedMotor(motorFrontalEsquerdo);
			}
			public static class Traseiro {
				public static final Spark Direito = new ImprovedMotor(motorTraseiroDireito);
				public static final Spark Esquerdo = new ImprovedMotor(motorTraseiroEsquerdo);
			}
			static {
				Frontal.Direito.setInverted(true);
				Traseiro.Direito.setInverted(true);
			}
		}
		public static final VictorSP Door = new VictorSP(6);
		
	}
	public static class Sensores {
		public static AHRS navX = new AHRS(SPI.Port.kMXP);
		public static DigitalInput limiteSuperior = new DigitalInput(1);
		public static DigitalInput limiteInferior = new DigitalInput(0){
			public boolean get() {
				return !super.get();
			}
		};
		
	
	}
}
