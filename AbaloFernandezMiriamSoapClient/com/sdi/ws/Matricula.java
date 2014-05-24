
package com.sdi.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for matricula complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="matricula">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="alumno" type="{http://business.sdi.impl/}usuario" minOccurs="0"/>
 *         &lt;element name="asignatura" type="{http://business.sdi.impl/}asignatura" minOccurs="0"/>
 *         &lt;element name="calificacion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "matricula", propOrder = {
    "alumno",
    "asignatura",
    "calificacion"
})
public class Matricula {

    protected Usuario alumno;
    protected Asignatura asignatura;
    protected int calificacion;

    /**
     * Gets the value of the alumno property.
     * 
     * @return
     *     possible object is
     *     {@link Usuario }
     *     
     */
    public Usuario getAlumno() {
        return alumno;
    }

    /**
     * Sets the value of the alumno property.
     * 
     * @param value
     *     allowed object is
     *     {@link Usuario }
     *     
     */
    public void setAlumno(Usuario value) {
        this.alumno = value;
    }

    /**
     * Gets the value of the asignatura property.
     * 
     * @return
     *     possible object is
     *     {@link Asignatura }
     *     
     */
    public Asignatura getAsignatura() {
        return asignatura;
    }

    /**
     * Sets the value of the asignatura property.
     * 
     * @param value
     *     allowed object is
     *     {@link Asignatura }
     *     
     */
    public void setAsignatura(Asignatura value) {
        this.asignatura = value;
    }

    /**
     * Gets the value of the calificacion property.
     * 
     */
    public int getCalificacion() {
        return calificacion;
    }

    /**
     * Sets the value of the calificacion property.
     * 
     */
    public void setCalificacion(int value) {
        this.calificacion = value;
    }

}
