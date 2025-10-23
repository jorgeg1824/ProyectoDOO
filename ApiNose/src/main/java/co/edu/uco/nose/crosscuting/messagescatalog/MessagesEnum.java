package co.edu.uco.nose.crosscuting.messagescatalog;

import co.edu.uco.nose.crosscuting.helper.TextHelper;

public enum MessagesEnum {
	
	USER_ERROR_SQLCONNECTION_IS_EMPTY("Conexión contra la fuente de información deseada vacía", 
			"La conexión requerida para llevar a cabo la operación contra la fuente de información deseada está vacía."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_SQLCONNECTION_IS_EMPTY("Conexión contra la fuente de información deseada nula", 
			"La conexión requerida para llevar a cabo la operación contra la base de datos llegó nula."),
	
	USER_ERROR_SQLCONNECTION_IS_CLOSED("Conexión contra la fuente de información deseada cerrada", 
			"La conexión requerida para llevar a cabo la operación contra la fuente de información deseada está cerrada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_SQLCONNECTION_IS_CLOSED("Conexión contra la fuente de información deseada cerrada", 
			"La conexión requerida para llevar a cabo la operación contra la base de datos está cerrada."),
	
	USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Problema inesperado validando el estado de la conexión contra la fuente de datos deseada", 
			"Se ha presentado un problema inesperado tratando de validar el estado de la conexión requerida para llevar a cabo la la operación contra la fuente de información deseada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Error inesperado validando si la conexión contra la base de datos estaba abierta", 
			"Se presentó un error de tipo SQLException al validar si la conexión contra la base de datos estaba o no abierta."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	TECHINAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Error inesperado validando si la conexión contra la base de datos estaba abierta", 
			"Se presentó un error no controlado de tipo Exception al validar si la conexión contra la base de datos estaba o no abierta."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_TRANSACTION_IS_NOT_STARTED("Transacción contra la fuente de información deseada no iniciada", 
			"La transacción contra la fuente de información deseada no ha sido iniciada."
			+ "Por favor inicie una transacción e intente de nuevo. Si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_TRANSACTION_IS_NOT_STARTED("Transacción contra la fuente de información deseada no iniciada",
			"Se esperaba que la transacción contra la fuente de información deseada estuviera iniciada (autoCommit en false) pero se encontró que no es así (autoCommit en true)."),
	
	USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_STARTED("Problema inesperado validando si la transacción contra la fuente de información deseada estaba iniciada", 
			"Se ha presentado un problema inesperado tratando de validar si la transacción contra la fuente de información deseada estaba iniciada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_STARTED("Error inespereado validando si la transacción contra la fuente de información deseada estaba iniciada", 
			"Se presentó un error de tipo SQLException al validar si la transacción contra la fuente de información deseada estaba iniciada."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_NOT_STARTED("Problema inesperado validando si la transacción contra la fuente de información deseada no estaba iniciada", 
			"Se ha presentado un problema inesperado tratando de validar si la transacción contra la fuente de información deseada no estaba iniciada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_NOT_STARTED("Error inespereado validando si la transacción contra la fuente de información deseada no estaba iniciada",
			"Se presentó un error de tipo SQLException al validar si la transacción contra la fuente de información deseada no estaba iniciada."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_TRANSACTION_IS_STARTED("Transacción contra la fuente de información deseada ya iniciada", 
			"La transacción contra la fuente de información deseada ya ha sido iniciada."
			+ "Por favor valide si ya existe una transacción iniciada antes de iniciar una nueva e intente de nuevo. Si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_TRANSACTION_IS_STARTED("Transacción contra la fuente de información deseada ya iniciada",
			"Se esperaba que la transacción contra la fuente de información deseada no estuviera iniciada (autoCommit en true) pero se encontró que ya estaba iniciada (autoCommit en false)."
			+ "Esto puede suceder si se intenta iniciar una transacción cuando ya existe una iniciada."),
	
	USER_ERROR_INITIALIZING_TRANSACTION("Problema inicializando la transacción contra la fuente de información deseada", 
			"Se ha presentado un problema inesperado tratando de iniciar la transacción contra la fuente de información deseada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_INITIALIZING_TRANSACTION("Error inespereado inicializando la transacción contra la fuente de información deseada",
			"Se presentó un error de tipo SQLException al intentar iniciar la transacción contra la fuente de información deseada."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_INITIALIZING_TRANSACTION("Problema inesperado inicializando la transacción contra la fuente de información deseada", 
			"Se ha presentado un problema inesperado tratando de iniciar la transacción contra la fuente de información deseada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_INITIALIZING_TRANSACTION("Error inespereado inicializando la transacción contra la fuente de información deseada",
			"Se presentó un error no controlado de tipo Exception al intentar iniciar la transacción contra la fuente de información deseada."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_COMMITING_TRANSACTION("Problema inesperado haciendo commit a la transacción contra la fuente de información deseada", 
			"Se ha presentado un problema inesperado tratando de hacer commit a la transacción contra la fuente de información deseada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_COMMITING_TRANSACTION("Error inespereado haciendo commit a la transacción contra la fuente de información deseada",
			"Se presentó un error de tipo SQLException al intentar hacer commit a la transacción contra la fuente de información deseada."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_COMMITING_TRANSACTION("Problema inesperado haciendo commit a la transacción contra la fuente de información deseada", 
			"Se ha presentado un problema inesperado tratando de hacer commit a la transacción contra la fuente de información deseada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_COMMITING_TRANSACTION("Error inespereado haciendo commit a la transacción contra la fuente de información deseada",
			"Se presentó un error no controlado de tipo Exception al intentar hacer commit a la transacción contra la fuente de información deseada."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_ROLLING_BACK_TRANSACTION("Problema inesperado haciendo rollback a la transacción contra la fuente de información deseada", 
			"Se ha presentado un problema inesperado tratando de hacer rollback a la transacción contra la fuente de información deseada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_ROLLING_BACK_TRANSACTION("Error inespereado haciendo rollback a la transacción contra la fuente de información deseada",
			"Se presentó un error de tipo SQLException al intentar hacer rollback a la transacción contra la fuente de información deseada."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_ROLLING_BACK_TRANSACTION("Problema inesperado haciendo rollback a la transacción contra la fuente de información deseada",
			"Se ha presentado un problema inesperado tratando de hacer rollback a la transacción contra la fuente de información deseada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_ROLLING_BACK_TRANSACTION("Error inespereado haciendo rollback a la transacción contra la fuente de información deseada",
			"Se presentó un error no controlado de tipo Exception al intentar hacer rollback a la transacción contra la fuente de información deseada."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_CLOSING_CONNECTION("Problema inesperado cerrando la conexión contra la fuente de información deseada", 
			"Se ha presentado un problema inesperado tratando de cerrar la conexión contra la fuente de información deseada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_CLOSING_CONNECTION("Error inespereado cerrando la conexión contra la fuente de información deseada",
			"Se presentó un error de tipo SQLException al intentar cerrar la conexión contra la fuente de información deseada."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_CLOSING_CONNECTION("Problema inesperado cerrando la conexión contra la fuente de información deseada",
			"Se ha presentado un problema inesperado tratando de cerrar la conexión contra la fuente de información deseada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_CLOSING_CONNECTION("Error inespereado cerrando la conexión contra la fuente de información deseada",
			"Se presentó un error no controlado de tipo Exception al intentar cerrar la conexión contra la fuente de información deseada."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_OPENING_CONNECTION("Problema inesperado abriendo la conexión contra la fuente de información deseada", 
			"Se ha presentado un problema inesperado tratando de abrir la conexión contra la fuente de información deseada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_OPENING_CONNECTION("Error inespereado abriendo la conexión contra la fuente de información deseada",
			"Se presentó un error de tipo SQLException al intentar abrir la conexión contra la fuente de información deseada."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_OPENING_CONNECTION("Problema inesperado abriendo la conexión contra la fuente de información deseada",
			"Se ha presentado un problema inesperado tratando de abrir la conexión contra la fuente de información deseada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_OPENING_CONNECTION("Error inespereado abriendo la conexión contra la fuente de información deseada",
			"Se presentó un error no controlado de tipo Exception al intentar abrir la conexión contra la fuente de información deseada."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_DAOFACTORY_NO_VALID_FACTORY("Problema inesperado inicializando la factoría", 
			"La fuente de información sobre la cual se va a realizar la transacción seleccionada no está disponible dentro del sistema."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAOFACTORY_NO_VALID_FACTORY("Error inicializando el DAOFactory",
			"La factoría seleccionada para la fuente de información no ha sido implementada o no está disponible en este momento."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_DAO_CREATING_USER("Problema creando el usuario", 
			"Se ha presentado un problema tratando de registrar la información del nuevo usuario."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_CREATING_USER("Error creando el usuario",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de creación de un nuevo usuario."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_DAO_UNEXPECTED_ERROR_CREATING_USER("Error inesperado creando el usuario",
			"Se presentó un problema inesperado tratando de registrar la información del nuevo usuario."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación"),
	
	TECHNICAL_ERROR_DAO_UNEXPECTED_ERROR_CREATING_USER("Error inesperado creando el usuario",
			"Se presentó un error no controlado de tipo Exception al tratar de ejecutar el proceso de creación de un nuevo usuario en la base de datos."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado"),
	
	USER_ERROR_DAO_UPDATING_USER("Problema actualizando el usuario",
	        "Se ha presentado un problema tratando de actualizar la información del usuario."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	TECHNICAL_ERROR_DAO_UPDATING_USER("Error actualizando el usuario",
	        "Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de actualización de la información del usuario."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),

	USER_ERROR_DAO_UNEXPECTED_ERROR_UPDATING_USER("Error inesperado actualizando el usuario",
	        "Se presentó un problema inesperado tratando de actualizar la información del usuario."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	TECHNICAL_ERROR_DAO_UNEXPECTED_ERROR_UPDATING_USER("Error inesperado actualizando el usuario",
	        "Se presentó un error no controlado de tipo Exception al tratar de ejecutar el proceso de actualización de la información del usuario en la base de datos."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_DAO_DELETING_USER("Problema eliminando el usuario",
	        "Se ha presentado un problema tratando de eliminar la información del usuario."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	TECHNICAL_ERROR_DAO_DELETING_USER("Error eliminando el usuario",
	        "Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de eliminación de la información del usuario."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),

	USER_ERROR_DAO_UNEXPECTED_ERROR_DELETING_USER("Error inesperado eliminando el usuario",
	        "Se presentó un problema inesperado tratando de eliminar la información del usuario."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	TECHNICAL_ERROR_DAO_UNEXPECTED_ERROR_DELETING_USER("Error inesperado eliminando el usuario",
	        "Se presentó un error no controlado de tipo Exception al tratar de ejecutar el proceso de eliminación de la información del usuario en la base de datos."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado"),
	
	USER_ERROR_DAO_FINDING_USER_BY_ID("Problema consultando el usuario por su identificador",
	        "Se ha presentado un problema tratando de consultar la información del usuario por su identificador."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	TECHNICAL_ERROR_DAO_FINDING_USER_BY_ID("Error consultando el usuario por su identificador",
	        "Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de un usuario por su identificador."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),

	USER_ERROR_DAO_UNEXPECTED_ERROR_FINDING_USER_BY_ID("Error inesperado consultando el usuario por su identificador",
	        "Se presentó un problema inesperado tratando de consultar la información del usuario por su identificador."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	TECHNICAL_ERROR_DAO_UNEXPECTED_ERROR_FINDING_USER_BY_ID("Error inesperado consultando el usuario por su identificador",
	        "Se presentó un error no controlado de tipo Exception al tratar de ejecutar el proceso de consulta de un usuario por su identificador en la base de datos."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado"),
	
	USER_ERROR_DAO_FINDING_ALL_USERS("Problema consultando los usuarios",
	        "Se ha presentado un problema tratando de consultar la información de los usuarios. "
	        + "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	TECHNICAL_ERROR_DAO_FINDING_ALL_USERS("Error consultando los usuarios",
	        "Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de usuarios. "
	        + "Por favor valide la consola de errores para revisar con detalle el problema presentado."),

	USER_ERROR_DAO_UNEXPECTED_ERROR_FINDING_ALL_USERS("Error inesperado consultando los usuarios",
	        "Se presentó un problema inesperado tratando de consultar la información de los usuarios. "
	        + "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	TECHNICAL_ERROR_DAO_UNEXPECTED_ERROR_FINDING_ALL_USERS("Error inesperado consultando los usuarios",
	        "Se presentó un error no controlado de tipo Exception al tratar de ejecutar el proceso de consulta de usuarios. "
	        + "Por favor valide la consola de errores para revisar con detalle el problema presentado"),
	
	USER_ERROR_DAO_FINDING_USER_BY_FILTER("Problema consultando los usuarios por filtro",
	        "Se ha presentado un problema tratando de consultar la información de los usuarios según los criterios indicados. "
	        + "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	TECHNICAL_ERROR_DAO_FINDING_USER_BY_FILTER("Error consultando los usuarios por filtro",
	        "Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de usuarios filtrados. "
	        + "Por favor valide la consola de errores para revisar con detalle el problema presentado."),

	USER_ERROR_DAO_UNEXPECTED_ERROR_FINDING_USER_BY_FILTER("Error inesperado consultando los usuarios por filtro",
	        "Se presentó un problema inesperado tratando de consultar la información de los usuarios según los criterios indicados. "
	        + "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	TECHNICAL_ERROR_DAO_UNEXPECTED_ERROR_FINDING_USER_BY_FILTER("Error inesperado consultando los usuarios por filtro",
	        "Se presentó un error no controlado de tipo Exception al tratar de ejecutar el proceso de consulta de usuarios filtrados. "
	        + "Por favor valide la consola de errores para revisar con detalle el problema presentado"),
	
	USER_ERROR_FACADE_REGISTERING_USER("Problema inesperado registrando la información del nuevo usuario",
			"Se ha presentado un problema inesperado registrando la información del nuevo usuario. "
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_FACADE_REGISTERING_USER("Error inesperado registrando la información del nuevo usuario",
			"Se presentó un error no controlado de tipo Exception tratando de registrar la información del nuevo usuario en la capa facade."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado.");
	
	private String title;
	private String content;
	
	private MessagesEnum(final String title, final String content) {
		setTitle(title);
		setContent(content);
	}

	public String getTitle() {
		return title;
	}

	private void setTitle(final String title) {
		this.title = TextHelper.getDefaultWithTrim(title);
	}

	public String getContent() {
		return content;
	}

	private void setContent(final String content) {
		this.content = TextHelper.getDefaultWithTrim(content);
	}
	
}
