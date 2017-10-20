import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class ForceAwakens {

	public static void main(String[] args) {
		try {

			BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

			int opcion = 0;
			int maxEnergiaResistencia = 0;
			int maxEnergiaImperio = 0;
			int vivosResistencia = 0;
			int vivosImperio = 0;
			int maxDefensaResistencia = 0;
			int maxDefensaImperio = 0;
			int aTopeResistencia = 0;
			int aTopeImperio = 0;
			int energiaResistenciaPoint = 0;
			int energiaImperioPoint = 0;
			int vivosResistenciaPoint = 0;
			int vivosImperioPoint = 0;
			int DefensaResistenciaPoint = 0;
			int DefensaImperioPoint = 0;
			int aTopeResistenciaPoint = 0;
			int aTopeImperioPoint = 0;
			int TotalPointResistencia = 0;
			int TotalPointImperio = 0;
			
			String contadorEnergia = "";
			String contadorSupervivientes = "";
			String contadorDefensa = "";
			String contadorSoldadosTope = "";
			
			ArrayList<Integer> defensaResistencia = new ArrayList<Integer>();
			ArrayList<Integer> energiaResistencia = new ArrayList<Integer>();
			ArrayList<Integer> defensaImperio = new ArrayList<Integer>();
			ArrayList<Integer> energiaImperio = new ArrayList<Integer>();
			
			for (int i = 0; i < 10; i++){						
				defensaResistencia.add(i, 0);
				energiaResistencia.add(i, 0);
				defensaImperio.add(i, 0);
				energiaImperio.add(i, 0);
			}

			while (opcion != 4) {

				System.out.println("-----R2D2-MENU-----");
				System.out.println("                 ");
				System.out.println("1-Asignar Valores");
				System.out.println("2-Iniciar Batalla");
				System.out.println("3-Analisis de la Batalla");
				System.out.println("4-Salir");
				System.out.println(" ");

				System.out.println("Selecciona opcion");
				opcion = Integer.parseInt(buffer.readLine());

				switch (opcion) {

				case 1:

					for (int i = 0; i < 10; i++){						
						defensaResistencia.set(i, (int)(Math.random()*(4-0+1) + 0));
						energiaResistencia.set(i,(int)(Math.random()*(10-0+1) + 0));
						defensaImperio.set(i, (int)(Math.random()*(4-0+1) + 0));
						energiaImperio.set(i, (int)(Math.random()*(10-0+1) + 0));
					}
					System.out.println("Nivel de defensa de LA RESISTENCIA: "+defensaResistencia);
					System.out.println("Nivel de energía actual de LA RESISTENCIA: "+energiaResistencia);
					System.out.println("Nivel de ataque del IMPERIO: "+defensaImperio);
					System.out.println("Nivel de energía actual del IMPERIO: "+energiaImperio);					
					System.out.println(" ");
					
					break;

				case 2:
					//Quien atacara primero?
					int ataca = (int)(Math.random()*(1-0+1) + 0);
					
					//Batalla
					for(int i = 0; i<10 ;i++){
						
						if(ataca==1){
							
							if(energiaResistencia.get(i)>0){
								if(energiaResistencia.get(i)>defensaImperio.get(i)){
									energiaImperio.set(i, energiaImperio.get(i)-(energiaResistencia.get(i)-defensaImperio.get(i)));
									if(energiaImperio.get(i)<=0) energiaImperio.set(i, 0);
								}
							}
							
						}else if(ataca==0){
							
							if(energiaImperio.get(i)>0){
								if(energiaImperio.get(i)>defensaResistencia.get(i)){
									energiaResistencia.set(i, energiaResistencia.get(i)-(energiaImperio.get(i)-defensaResistencia.get(i)));
									if(energiaResistencia.get(i)<=0) energiaResistencia.set(i, 0);
								}
							}
						}
						
						if(ataca==1)ataca=0;
						else if(ataca==0)ataca=1;
					}
					
					System.out.println("Nivel de energía actual de LA RESISTENCIA: "+energiaResistencia);
					System.out.println("Nivel de energía actual del IMPERIO:       "+energiaImperio);	
					
					break;

				case 3:
					
					maxEnergiaResistencia = 0;
					maxEnergiaImperio = 0;
					vivosResistencia = 0;
					vivosImperio = 0;
					maxDefensaResistencia = 0;
					maxDefensaImperio = 0;
					aTopeResistencia = 0;
					aTopeImperio = 0;
					energiaResistenciaPoint = 0;
					energiaImperioPoint = 0;
					vivosResistenciaPoint = 0;
					vivosImperioPoint = 0;
					DefensaResistenciaPoint = 0;
					DefensaImperioPoint = 0;
					aTopeResistenciaPoint = 0;
					aTopeImperioPoint = 0;
					TotalPointResistencia = 0;
					TotalPointImperio = 0;
					
					//Maxima energia
					System.out.println("------------------");
					System.out.println("--Maxima Energia--");
					System.out.println("------------------");
					for(int i = 0; i<10 ;i++){
						maxEnergiaResistencia = maxEnergiaResistencia + energiaResistencia.get(i);
						maxEnergiaImperio = maxEnergiaImperio + energiaImperio.get(i);
					}
					
					if(maxEnergiaResistencia>maxEnergiaImperio){
						energiaResistenciaPoint++;
						contadorEnergia = "La Resistencia"; 
						System.out.println("La Resistencia GANA!!!");
					}
					else if (maxEnergiaResistencia<maxEnergiaImperio){
						energiaImperioPoint++;
						contadorEnergia = "El Imperio";
						System.out.println("El Imperio GANA!!!");
					}
					else{
						System.out.println("Increible han Empatado, imposible esto ser, arreglarlo debo. YODA");
						contadorEnergia = "El impero y La resistencia";
						energiaResistenciaPoint++;
						energiaImperioPoint++;
					}
					System.out.println(" ");
					System.out.println("Datos: Energia");
					System.out.println("------------------");
					System.out.println("Energia Resistencia: " + maxEnergiaResistencia);
					System.out.println("Energia Imperio: " + maxEnergiaImperio);
					System.out.println(" ");
					
					//Supervivientes
					System.out.println("------------------");
					System.out.println("--Supervivientes--");
					System.out.println("------------------");
					for(int i = 0; i<10 ;i++){
						if(energiaResistencia.get(i)>0) vivosResistencia++;
						if(energiaImperio.get(i)>0) vivosImperio++;
					}
					
					if(vivosResistencia>vivosImperio){
						vivosResistenciaPoint++;
						contadorSupervivientes = "La Resistencia";
						System.out.println("La Resistencia GANA!!!");
					}
					else if(vivosResistencia<vivosImperio){
						vivosImperioPoint++;
						contadorSupervivientes = "El Imperio";
						System.out.println("El Imperio GANA!!!");
					}
					else{
						vivosResistenciaPoint++;
						vivosImperioPoint++;
						contadorSupervivientes = "El impero y La resistencia";
						System.out.println("Increible han Empatado, imposible esto ser, arreglarlo debo. YODA");
					}
					System.out.println(" ");
					System.out.println("Datos: Supervivientes");
					System.out.println("------------------");
					System.out.println("Supervivientes Resistencia: " + vivosResistencia);
					System.out.println("Supervivientes Imperio: " + vivosImperio);
					System.out.println(" ");
					
					//Mas defensa
					System.out.println("------------------");
					System.out.println("--Maxima Defensa--");
					System.out.println("------------------");
					for(int i = 0; i<10 ;i++){
						maxDefensaResistencia = maxDefensaResistencia + defensaResistencia.get(i);
						maxDefensaImperio = maxDefensaImperio + defensaImperio.get(i);
					}
					
					if(maxDefensaResistencia>maxDefensaImperio){
						DefensaResistenciaPoint++;
						contadorDefensa = "La Resistencia"; 
						System.out.println("La Resistencia GANA!!!");
					}
					else if (maxDefensaResistencia<maxDefensaImperio){
						DefensaImperioPoint++;
						contadorDefensa = "El Imperio";
						System.out.println("El Imperio GANA!!!");
					}
					else{
						System.out.println("Increible han Empatado, imposible esto ser, arreglarlo debo. YODA");
						contadorDefensa = "El impero y La resistencia";
						DefensaResistenciaPoint++;
						DefensaImperioPoint++;
					}
					
					System.out.println(" ");
					System.out.println("Datos: Defensa");
					System.out.println("------------------");
					System.out.println("Defensa Resistencia: " + maxDefensaResistencia);
					System.out.println("Defensa Imperio: " + maxDefensaImperio);
					System.out.println(" ");
					
					//Soldados a tope sirope
					System.out.println("-------------------");
					System.out.println("--Soldados a Tope--");
					System.out.println("-------------------");
					for(int i = 0; i<10 ;i++){
						if(energiaResistencia.get(i)>=7) aTopeResistencia++;
						if(energiaImperio.get(i)>=7) aTopeImperio++;
					}
					
					System.out.println(" ");
					System.out.println("Datos: Soldados a Tope");
					System.out.println("------------------");
					System.out.println("Soldados a Tope Resistencia: " + aTopeResistencia);
					System.out.println("Soldados a Tope Imperio: " + aTopeImperio);
					System.out.println(" ");
					
					if(aTopeResistencia>aTopeImperio){
						aTopeResistenciaPoint++;
						contadorSoldadosTope="La Resistencia";
					}else if(aTopeResistencia<aTopeImperio){
						aTopeImperioPoint++;
						contadorSoldadosTope="El imperio";
					}else{
						aTopeResistenciaPoint++;
						aTopeImperioPoint++;
						contadorSoldadosTope="El impero y La resistencia" ;
					}
					
					//Valoracion final
					
					System.out.println("--------------------");
					System.out.println("--Valoracion Final--");
					System.out.println("--------------------");
					System.out.println("1-Maxima energia:");
					System.out.println("La Resistencia: "+energiaResistenciaPoint+", El Imperio: "+energiaImperioPoint+"");
					System.out.println("Gana: "+contadorEnergia);
					System.out.println("--------------------");
					System.out.println("2-Mas Supervivientes:");
					System.out.println("La Resistencia: "+vivosResistenciaPoint+", El Imperio: "+vivosImperioPoint+"");
					System.out.println("Gana: "+contadorSupervivientes);
					System.out.println("--------------------");
					System.out.println("3-Mas Defensa:");
					System.out.println("La Resistencia: "+DefensaResistenciaPoint+", El Imperio: "+DefensaImperioPoint+"");
					System.out.println("Gana: "+contadorDefensa);
					System.out.println("--------------------");
					System.out.println("4-Soldados a tope:");
					System.out.println("La Resistencia: "+aTopeResistenciaPoint+", El Imperio: "+aTopeImperioPoint+"");
					System.out.println("Gana: "+contadorSoldadosTope);
					System.out.println("--------------------");
					
					TotalPointResistencia = energiaResistenciaPoint + vivosResistenciaPoint + DefensaResistenciaPoint + aTopeResistenciaPoint;
					TotalPointImperio = energiaImperioPoint + vivosImperioPoint + DefensaImperioPoint + aTopeImperioPoint;
					
					if(TotalPointResistencia>TotalPointImperio){
						System.out.println("La Batalla la gana La Resistencia");
					}else if(TotalPointResistencia<TotalPointImperio) {
						System.out.println("La Batalla la gana El Imperio");
					}else System.out.println("La Batalla va empatada");
					
					break;

				case 4:
					
					System.out.println("La resistencia nunca debe rendirse. Que La Fuerza te acompañe...");
					
					break;
					
				default:
					System.out.println("Opcion no valida");
					System.out.println(" ");
					break;

				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
