import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner numeros = new Scanner(System.in);
		Scanner texto = new Scanner(System.in);
		// estas son las contraseñas del cajero autoatico sin es el caso ue el que este
		// ingresando esqe que va a sumistrar el cajero
		CajeroElectronico cj_01 = new CajeroElectronico(3, 3000000, 1500000, 50, 50, 0, 0, "BancoSena", "alberth",
				"12345");
		System.out.println("CAJERO ELECTRONICO 2023");
		boolean ingreso = true;
		do {
			System.out.println("|-------------------------");
			System.out.println("| 1.Administrador         ");
			System.out.println("| 2.Usuario               ");
			System.out.println("| 3.Cancelar solicitud    ");
			System.out.println("| Ingrese una opcion      ");
			int opcion = numeros.nextInt();
			if (opcion == 1) {
				System.out.println("Ingrese nombre usuario");
				String usuario = texto.nextLine();
				System.out.println("Ingrese contraseña");
				String contrasena = texto.nextLine();
				if (cj_01.validarDatos(usuario, contrasena)) {
					System.out.println("BIENVENIDO");
					boolean seleccion = true;
					System.out.println("Ingrese que tipo de accion desea realizar");
					do {
						System.out.println("1.MIRAR ESTADO ACTUAL DEL CAJERO");
						System.out.println("2.ACTULIZAR DINERO DEL CAJERO");
						System.out.println("3.VOLVER ATRAS");
						int opcion_cajero = numeros.nextInt();
						if (opcion_cajero == 1) {
							cj_01.imprimirDatosCajero();
						} else if (opcion_cajero == 2) {
							// aqui imprimimos la opcion de actulizar el dinero del cajero
							// creamos un ciclo para que ingrese los la canitdad quedesea registrar
							boolean valido = true;
							do {
								System.out.println("INGRESE LA CANTIDAD DE DINERO QUE DESEA REGISTRAR");
								int cantidad_ingresada = numeros.nextInt();
								// billetes de 10 mil
								System.out.println("CANT_BILLETES 10MIL");
								int diez = numeros.nextInt();
								// billetes de 20 mil
								System.out.println("CANT_BILLETES 20MIL");
								int veinte = numeros.nextInt();
								// billetes de 50 mil
								System.out.println("CANT_BILLETES 50MIL");
								int cincuenta = numeros.nextInt();
								// billetes de 100 mil
								System.out.println("CANT_BILLETES 100MIL");
								int cienmil = numeros.nextInt();
								cj_01.actualizarTotalCajero(cantidad_ingresada, diez, veinte, cincuenta, cienmil);
								// imprimimos la tabla de valores
								cj_01.imprimirDatosActualizados();
								// cj_01.imprimirDatosCajero();
								System.out.println("1.registrar");
								System.out.println("2.Salir");
								int salida = numeros.nextInt();
								if (salida == 1) {
									valido = true;
								} else if (salida == 2) {
									valido = false;
								} else {
									valido = true;
								}
							} while (valido);

						} else if (opcion_cajero == 3) {
							// la opcion 3 es para modificar los datos del cajero nombre etc
							System.out.println("==>SALIENDO");
							seleccion=false;
						} else {
							seleccion = true;
						}
						// estas son las opcionnes del asministrador
					} while (seleccion);

				} else {
					System.out.println("Usuario o contrasena incorrectos");
				}

			} else if (opcion == 2) {
				// aqui es la opcion del usario donde ingresara sus datos de su tarjeta
				System.out.println("|----BIENVENIDO USUARIO-----|");
				System.out.println("|--INGRESE QUE ACCION DESEA REALZAR");
				// hacemos instancia de la clase tarjeta
				TarjetaDebito persona1 = new TarjetaDebito("carlos", "1090332", "senapobre", 1000000, 2, 12345,
						"ACTIVA",2,0);
				// el boolean es para entrar al menu de opciones
				boolean usuario = true;
				if(persona1.estadoCuenta()){
					System.out.println("LA TARJETA ESTA BLOQUEADA PORFAVOR COMUNIQUESE CON NUESTROS ACESORES");
				}else{
					System.out.println("TIENES QUE RESOLVER ESTE PROBLEMA DESARROLLADOR");
				}
				do {
					System.out.println("|-----------------------------------|");
					System.out.println("|-- 1.INGRESAR DINERO AL BANCO      |");
					System.out.println("|-- 2.RETIRAR DINERO DE SU TARJETA  |");
					System.out.println("|-- 3.ACTUALIZAR DATOS DE SU TARJETA|");
					System.out.println("|-- 4.REALIZAR TRANSACCION          |");
					System.out.println("|-- 5.VER INFORMACION DE SU TARJETA |");
					System.out.println("|-- 6.VOLVER ATRAS                  |");

					System.out.println("|---------------------------------  |");
					int opcion_persona = numeros.nextInt();
					if (opcion_persona == 1) {
						System.out.println("=> INGRESE SU NOMBRE DE CUENTA");
						String nombre_usuario = texto.nextLine();
						System.out.println("=> INGRESE CLAVE TARJETA");
						int clave_usuario = numeros.nextInt();
						// Aqui validamos si la tarejeta ngresa es valida con la que tenemos registrada
						// xd
						// ahora validamos que la tarjeta que el ingreso se encuentre activa o bloqueada 
						if (persona1.validarTarjeta(nombre_usuario, clave_usuario)){
								// validamos que el estado de la cuenta se encuentre activa de resto se le dara un menaje que esta bloqueda
								if(persona1.estadoCuenta()){
									System.out.println("EL ESTADO DE LA CUENTA SE ENCUENTRA INACTIVA");
									break;
								}else{
									System.out.println("BIENVENIDO DE NUEVO");
									System.out.println();
									System.out.println("INGRESE CANTIDAD DINERO A GUARDAR");
									int cantidad_usuario = numeros.nextInt();
									// validamos que la antidad del uusario no sea negativa o igual a cero
									if (cantidad_usuario <= 0) {
										System.out.println("La cantidad ingresada no puede ser negativa");
									} else {
										// aqui aumentamos el saldo de su tarjeta
										persona1.getaumentarSaldo(cantidad_usuario);
										System.out.println("==>CANTIDAD DE DINERO INGRESAD CON EXITO");
										persona1.datosActualTarjeta();
									}
								}

							} else {
								System.out.println("EL USUARIO O PASSWORD SON INCORECTOS INTENTA NUEVAMENTE");
							}
						// ahora vamos hacer lo mismo con este 
					} else if (opcion_persona == 2) {
						// validamos el la contraseña y el usuario para poder hacer cambioss
						System.out.println("=> INGRESE SU NOMBRE DE CUENTA");
						String nombre_usuario = texto.nextLine();
						System.out.println("=> INGRESE CLAVE TARJETA");
						int clave_usuario = numeros.nextInt();
						// primero validamos que la contraseña se encuentre escrita corecctamente
						if (persona1.validarTarjeta(nombre_usuario, clave_usuario)) {
							// despues analizamos que el estado de la tarejta se encuentre activa
							if(persona1.estadoCuenta()){
								System.out.println("EL ESTADO DE LA TARJETA SE ENCUENTRA BLOQUEADA");
								break;
							}else{
								System.out.println("INGRESE LA CANTIDAD QUE DESE RETIRAR");
								int cantidad_retirar = numeros.nextInt();
								
								// validamos que la cantidad ingresa no sea negativa o igual a cero
								if (cantidad_retirar <= 0) {
									System.out.println("==>LA CANTIDAD INGRESA NO PUEDE SER MENOR O IGUAL A CERO");
								} else {
									persona1.getretirarDineroTarjeta(cantidad_retirar);
									// aqui actulizamos los retiros mensuales de la tarjeta
								}
								// como hacer para que se renueve cada mes
								
								// persona1.actualizarRetirosMensuales(3);
							}
						} else {
							System.out.println("==> EL USUARIO O PASSWORD SON INCORECTOS INTENTA NUEVAMENTE");
						}
						// datos a actulizar de su tarjeta
					} else if (opcion_persona == 3) {
						System.out.println("=> INGRESE SU NOMBRE DE CUENTA");
						String nombre_usuario = texto.nextLine();
						System.out.println("=> INGRESE CLAVE TARJETA");
						int clave_usuario = numeros.nextInt();
						// validamos que la contrseña y nombre de usuario sean correctos para hacer los
						// cambios
						if (persona1.validarTarjeta(nombre_usuario, clave_usuario)) {
							// validamos que el estado de la cuenta se encuenre activa
							if(persona1.estadoCuenta()){
								System.out.println("EL ESTADO DE LA CUENTA SE ENCUENTRA INACTIVA");
							}else{
								System.out.println("INGRESE EL DATO QUE QUIERE ACTUALIZAR DE SU TARJETA");
								boolean cambio_datos = true;
								do {
									System.out.println("|---------------------------|");
									System.out.println("|--1.CAMBIO DE NOMBRE       |");
									System.out.println("|--2.CAMBIO DE PASSWORD     |");
									System.out.println("|--3-VOLVER ATRAS           |");
									System.out.println("|-.INGRESE OPCION           |");
									System.out.println("|---------------------------|");
									int opcion_cambio = numeros.nextInt();
									if (opcion_cambio == 1) {
										System.out.println("INGRESE NOMBRE NUEVO");
										String nombre_nuevo = texto.nextLine();
										persona1.getcambioNombre(nombre_nuevo);

									} else if (opcion_cambio == 2) {
										System.out.println(
												"PARA HACER EL CAMBIO DE CONTRASEÑA PORFAVOR INGRESE LA CONTRASEÑA ANTIGUA");
										int clave_validacion = numeros.nextInt();
										if (persona1.validarPassword(clave_validacion)) {
											System.out.println("INGRESE CONTRASEÑA NUEVA");
											int nueva_contra = numeros.nextInt();
											persona1.getcambioPassword(nueva_contra);
										} else {
											System.out.println("LA CONTRASEÑA INGRESADA ES INCORRECTA");
										}
									}else if(opcion_cambio==3){
										cambio_datos=false;
									}else{
										System.out.println("INGRESE UNA OPCION CORRECTA");
										cambio_datos=true;
									}

								} while (cambio_datos);
							}
							// este es para validar la contraseña
						} else {
							// el caso contrariose le da un mensaje de que los datos son incorrectos
							System.out.println("LOS DATOS INGRESADOS SON INCORRECTOS");
						}
						// aqui enpieza la opcion de transaccion de dinero

						// aqui deje el trabajo seguri trabajando en esto hoy
					}else if(opcion_persona==4){

						System.out.println("Estamos en mantenimiento XD");
					}else if(opcion_persona==5){
						
						persona1.datosActualTarjeta();
					}
				} while (usuario);

			} else if (opcion == 3) {
				ingreso = false;
			} else {
				ingreso = true;
			}
		} while (ingreso);

	}
}