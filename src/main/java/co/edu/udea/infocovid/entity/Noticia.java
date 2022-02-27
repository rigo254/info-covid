package co.edu.udea.infocovid.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "estado")
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fk_tipo_noticia", nullable = false)
    private Long fkTipoNoticia;

    @Column(name = "fk_ciudad_noticia")
    private Long fkCiudad_noticia;

    @Column(name = "fecha_noticia", length = 5)
    private LocalDate fechaNoticia;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_ciudad_noticia", insertable = false, updatable = false)
    private Ciudad ciudad;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_tipo_noticia", insertable = false, updatable = false)
    private TipoNoticia tipoNoticia;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFkTipoNoticia() {
        return fkTipoNoticia;
    }

    public void setFkTipoNoticia(Long fkTipoNoticia) {
        this.fkTipoNoticia = fkTipoNoticia;
    }

    public Long getFkCiudad_noticia() {
        return fkCiudad_noticia;
    }

    public void setFkCiudad_noticia(Long fkCiudad_noticia) {
        this.fkCiudad_noticia = fkCiudad_noticia;
    }

    public LocalDate getFechaNoticia() {
        return fechaNoticia;
    }

    public void setFechaNoticia(LocalDate fechaNoticia) {
        this.fechaNoticia = fechaNoticia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public TipoNoticia getTipoNoticia() {
        return tipoNoticia;
    }

    public void setTipoNoticia(TipoNoticia tipoNoticia) {
        this.tipoNoticia = tipoNoticia;
    }
}
