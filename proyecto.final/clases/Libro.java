package clases;


import java.util.Date;


public class Libro {
	
	private int codigo;
	private String nombre;
	private String autor;
	private int anioPublicacion;
	private String Editorial;
	private int cantidadPaginas; 
	private float precio;
	private long CedulaReserva;
	private String estado;
	private Date fechaEntrega;
	private String tipo;
	private String CodigoAutorizacion;
	private int tiempoLectura;
	
	
	public long getCedulaReserva() {
		return CedulaReserva;
	}
	public void setCedulaReserva(long cedulaReserva) {
		CedulaReserva = cedulaReserva;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public Libro() {
    }
	public Libro(int codigo, String nombre, String autor, int anioPublicacion, String editorial, int cantidadPaginas,
			float precio,long CedulaReserva,String estado,Date fechaEntrega, String tipo,String CodigoAutorizacion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.autor = autor;
		this.anioPublicacion = anioPublicacion;
		this.Editorial = editorial;
		this.cantidadPaginas = cantidadPaginas;
		this.precio = precio;
		this.CedulaReserva=CedulaReserva;
		this.estado=estado;
		this.fechaEntrega=fechaEntrega;
		this.tipo = tipo;
		this.CodigoAutorizacion=CodigoAutorizacion;
	}
	public Libro(int codigo, String nombre, String autor, int anioPublicacion, String editorial, int cantidadPaginas,
			float precio,long CedulaReserva,String estado,Date fechaEntrega, String tipo,int tiempoLectura) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.autor = autor;
		this.anioPublicacion = anioPublicacion;
		this.Editorial = editorial;
		this.cantidadPaginas = cantidadPaginas;
		this.precio = precio;
		this.CedulaReserva=CedulaReserva;
		this.estado=estado;
		this.fechaEntrega=fechaEntrega;
		this.tipo = tipo;
		this.tiempoLectura=tiempoLectura;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnioPublicacion() {
		return anioPublicacion;
	}

	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}

	public String getEditorial() {
		return Editorial;
	}

	public void setEditorial(String editorial) {
		Editorial = editorial;
	}

	public int getCantidadPaginas() {
		return cantidadPaginas;
	}

	public void setCantidadPaginas(int cantidadPaginas) {
		this.cantidadPaginas = cantidadPaginas;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCodigoAutorizacion() {
		return CodigoAutorizacion;
	}
	public void setCodigoAutorizacion(String codigoAutorizacion) {
		CodigoAutorizacion = codigoAutorizacion;
	}
	public int getTiempoLectura() {
		return tiempoLectura;
	}
	public void setTiempoLectura(int tiempoLectura) {
		this.tiempoLectura = tiempoLectura;
	}
	
		
}



