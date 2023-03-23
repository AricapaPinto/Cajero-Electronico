
public class TarjetaDebito{

	// Atributos
	private String nombre_propietario;
	private String numero_tarjeta;
	private String nombre_banco;
	private int cantidad_dinero_tarjeta;
	private int cant_retirar;
	private String ultima_transaccion[];
	private byte cant_intentos;
	private int tipo_tarjeta;
	private int clave;
	// private int retiros_mensual_permitido;
	// private int cantidad_retiros_actuales;
	private String estado;
	// esto es retirar retirar los retiros mensuales
	// creamos un metodo contructor 
	private int retiros_mensuales;
	 private int retirosRealizadosEsteMes;
	public TarjetaDebito(String nombre_propietario,String numero_tarjeta,String nombre_banco,int cantidad_dinero,int tipo_tarjeta,int clave,String estado,int mensual_p,int este_mes){
		this.nombre_propietario=nombre_propietario;
		this.numero_tarjeta=numero_tarjeta;
		this.nombre_banco=nombre_banco;
		this.cantidad_dinero_tarjeta=cantidad_dinero;
		this.tipo_tarjeta=tipo_tarjeta;
		this.clave=clave;
		this.estado=estado;
		this.retiros_mensuales=mensual_p;
		this.retirosRealizadosEsteMes =este_mes; // Inicialmente, el usuario no ha realizado ningún retiro este mes
	}
	public boolean validarTarjeta(String nombre_propi,int clave_usuario){
		if(this.nombre_propietario.equals(nombre_propi) && this.clave==clave_usuario){
			return true;
		}
		this.cant_intentos+=1;
		if(this.cant_intentos>=5){
			System.out.println("LA CUENTA A SIDO BLOQUEADA POR CANTIDAD DE INTENTOS FALLIDOS");
			this.estado="BLOQUEADA";
		}
		return false;
	}

	public boolean estadoCuenta(){
		if(this.estado.equals("BLOQUEADA")){
			return true;
		}
		return false;
	}
	// validar contraseña para haacer cambios
	public boolean validarPassword(int clave_ingresada){
		if(this.clave==clave_ingresada){
			return true;
		}
		return false;
	}
	// metodo para cambio de contraseña
	public void getcambioPassword(int nueva_password){
		this.clave=nueva_password;
		System.out.println("PASSWORD CAMBIADA CON EXITO");
	}
	// Cambio de nombre
	public void getcambioNombre(String nombre_nuevo){
		this.nombre_propietario=nombre_nuevo;
		System.out.println("NOMBRE CAMBIADO CON EXITO");

	}
	public void getaumentarSaldo(int cantidad_dinero){
		this.cantidad_dinero_tarjeta+=cantidad_dinero;
	}
	// Creao el metodo de retirar dinero
	public void getretirarDineroTarjeta(int cant_retirar){
		
		if(cant_retirar>this.cantidad_dinero_tarjeta){
			System.out.println("==>CANTIDAD DE DINERO SUPERA LOS LIMITES DE SU TARJETA");
		}else{
			if(retirosRealizadosEsteMes<retiros_mensuales){
				this.cantidad_dinero_tarjeta-=cant_retirar;
				System.out.println("CANTIDAD DE DINERO RETIRADO CON EXITO");
				retirosRealizadosEsteMes++;
			}else{
				System.out.println("YA HAZ REALIZADO LOS RETIROS MENSUALES PERMITIDOS GRATIS DURANTE ESTE MES");
			}
		}

		
	}
	// creamos el metodo para actualizar los retiros permitidos
	public void actualizarRetirosMensuales(int nuevosRetirosMensuales) {
		retiros_mensuales = nuevosRetirosMensuales;
		retirosRealizadosEsteMes = 0;
    }
	

	// Metodo cambio de nombre 
	// creamos un metodo para mostrarle su estado actual de su tarjeta 
	public void datosActualTarjeta(){
		System.out.println("|--------------------------------------------------|");
		System.out.println("|NOMBRE:"+this.nombre_propietario+"                ");
		System.out.println("|CANTIDAD DE DINERO:"+this.cantidad_dinero_tarjeta);
		System.out.println("|TIPO DE TARJETA:"+this.tipo_tarjeta+"             ");
		System.out.println("|ESTADO DE SU TARJETA:"+this.estado);
		System.out.println("|--------------------------------------------------|");
	}
	// Metodos:

	// 	disminuirSaldo
	// 	aumentarSaldo
	// 	getters
	// 	setters

}