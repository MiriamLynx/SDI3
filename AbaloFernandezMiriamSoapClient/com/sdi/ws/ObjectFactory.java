
package com.sdi.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sdi.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetProfesoresResponse_QNAME = new QName("http://business.sdi.impl/", "getProfesoresResponse");
    private final static QName _VerUsuariosDesactivados_QNAME = new QName("http://business.sdi.impl/", "verUsuariosDesactivados");
    private final static QName _VerUsuariosActivados_QNAME = new QName("http://business.sdi.impl/", "verUsuariosActivados");
    private final static QName _BuscarProfesores_QNAME = new QName("http://business.sdi.impl/", "buscarProfesores");
    private final static QName _BuscarUsuariosDesactivadosResponse_QNAME = new QName("http://business.sdi.impl/", "buscarUsuariosDesactivadosResponse");
    private final static QName _GetProfesores_QNAME = new QName("http://business.sdi.impl/", "getProfesores");
    private final static QName _InsertarUsuarioResponse_QNAME = new QName("http://business.sdi.impl/", "insertarUsuarioResponse");
    private final static QName _ActualizarNotaResponse_QNAME = new QName("http://business.sdi.impl/", "actualizarNotaResponse");
    private final static QName _VerUsuariosDesactivadosResponse_QNAME = new QName("http://business.sdi.impl/", "verUsuariosDesactivadosResponse");
    private final static QName _ActualizarPasswordResponse_QNAME = new QName("http://business.sdi.impl/", "actualizarPasswordResponse");
    private final static QName _BusinessException_QNAME = new QName("http://business.sdi.impl/", "BusinessException");
    private final static QName _ActualizarPerfil_QNAME = new QName("http://business.sdi.impl/", "actualizarPerfil");
    private final static QName _BuscarProfesoresResponse_QNAME = new QName("http://business.sdi.impl/", "buscarProfesoresResponse");
    private final static QName _BuscarUsuariosActivadosResponse_QNAME = new QName("http://business.sdi.impl/", "buscarUsuariosActivadosResponse");
    private final static QName _BuscarUsuariosDesactivados_QNAME = new QName("http://business.sdi.impl/", "buscarUsuariosDesactivados");
    private final static QName _ActualizarPerfilResponse_QNAME = new QName("http://business.sdi.impl/", "actualizarPerfilResponse");
    private final static QName _ActivarUsuarioResponse_QNAME = new QName("http://business.sdi.impl/", "activarUsuarioResponse");
    private final static QName _ActualizarPassword_QNAME = new QName("http://business.sdi.impl/", "actualizarPassword");
    private final static QName _ActivarUsuario_QNAME = new QName("http://business.sdi.impl/", "activarUsuario");
    private final static QName _VerExpediente_QNAME = new QName("http://business.sdi.impl/", "verExpediente");
    private final static QName _InsertarUsuario_QNAME = new QName("http://business.sdi.impl/", "insertarUsuario");
    private final static QName _DesactivarUsuario_QNAME = new QName("http://business.sdi.impl/", "desactivarUsuario");
    private final static QName _VerExpedienteResponse_QNAME = new QName("http://business.sdi.impl/", "verExpedienteResponse");
    private final static QName _DesactivarUsuarioResponse_QNAME = new QName("http://business.sdi.impl/", "desactivarUsuarioResponse");
    private final static QName _BuscarUsuariosActivados_QNAME = new QName("http://business.sdi.impl/", "buscarUsuariosActivados");
    private final static QName _VerUsuariosActivadosResponse_QNAME = new QName("http://business.sdi.impl/", "verUsuariosActivadosResponse");
    private final static QName _ActualizarNota_QNAME = new QName("http://business.sdi.impl/", "actualizarNota");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sdi.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ActualizarPassword }
     * 
     */
    public ActualizarPassword createActualizarPassword() {
        return new ActualizarPassword();
    }

    /**
     * Create an instance of {@link ActivarUsuarioResponse }
     * 
     */
    public ActivarUsuarioResponse createActivarUsuarioResponse() {
        return new ActivarUsuarioResponse();
    }

    /**
     * Create an instance of {@link ActualizarPerfilResponse }
     * 
     */
    public ActualizarPerfilResponse createActualizarPerfilResponse() {
        return new ActualizarPerfilResponse();
    }

    /**
     * Create an instance of {@link BuscarUsuariosDesactivados }
     * 
     */
    public BuscarUsuariosDesactivados createBuscarUsuariosDesactivados() {
        return new BuscarUsuariosDesactivados();
    }

    /**
     * Create an instance of {@link BuscarUsuariosActivadosResponse }
     * 
     */
    public BuscarUsuariosActivadosResponse createBuscarUsuariosActivadosResponse() {
        return new BuscarUsuariosActivadosResponse();
    }

    /**
     * Create an instance of {@link BuscarProfesoresResponse }
     * 
     */
    public BuscarProfesoresResponse createBuscarProfesoresResponse() {
        return new BuscarProfesoresResponse();
    }

    /**
     * Create an instance of {@link ActualizarPerfil }
     * 
     */
    public ActualizarPerfil createActualizarPerfil() {
        return new ActualizarPerfil();
    }

    /**
     * Create an instance of {@link ActualizarNota }
     * 
     */
    public ActualizarNota createActualizarNota() {
        return new ActualizarNota();
    }

    /**
     * Create an instance of {@link VerUsuariosActivadosResponse }
     * 
     */
    public VerUsuariosActivadosResponse createVerUsuariosActivadosResponse() {
        return new VerUsuariosActivadosResponse();
    }

    /**
     * Create an instance of {@link BuscarUsuariosActivados }
     * 
     */
    public BuscarUsuariosActivados createBuscarUsuariosActivados() {
        return new BuscarUsuariosActivados();
    }

    /**
     * Create an instance of {@link DesactivarUsuarioResponse }
     * 
     */
    public DesactivarUsuarioResponse createDesactivarUsuarioResponse() {
        return new DesactivarUsuarioResponse();
    }

    /**
     * Create an instance of {@link VerExpedienteResponse }
     * 
     */
    public VerExpedienteResponse createVerExpedienteResponse() {
        return new VerExpedienteResponse();
    }

    /**
     * Create an instance of {@link DesactivarUsuario }
     * 
     */
    public DesactivarUsuario createDesactivarUsuario() {
        return new DesactivarUsuario();
    }

    /**
     * Create an instance of {@link InsertarUsuario }
     * 
     */
    public InsertarUsuario createInsertarUsuario() {
        return new InsertarUsuario();
    }

    /**
     * Create an instance of {@link ActivarUsuario }
     * 
     */
    public ActivarUsuario createActivarUsuario() {
        return new ActivarUsuario();
    }

    /**
     * Create an instance of {@link VerExpediente }
     * 
     */
    public VerExpediente createVerExpediente() {
        return new VerExpediente();
    }

    /**
     * Create an instance of {@link VerUsuariosDesactivadosResponse }
     * 
     */
    public VerUsuariosDesactivadosResponse createVerUsuariosDesactivadosResponse() {
        return new VerUsuariosDesactivadosResponse();
    }

    /**
     * Create an instance of {@link ActualizarNotaResponse }
     * 
     */
    public ActualizarNotaResponse createActualizarNotaResponse() {
        return new ActualizarNotaResponse();
    }

    /**
     * Create an instance of {@link InsertarUsuarioResponse }
     * 
     */
    public InsertarUsuarioResponse createInsertarUsuarioResponse() {
        return new InsertarUsuarioResponse();
    }

    /**
     * Create an instance of {@link BuscarUsuariosDesactivadosResponse }
     * 
     */
    public BuscarUsuariosDesactivadosResponse createBuscarUsuariosDesactivadosResponse() {
        return new BuscarUsuariosDesactivadosResponse();
    }

    /**
     * Create an instance of {@link GetProfesores }
     * 
     */
    public GetProfesores createGetProfesores() {
        return new GetProfesores();
    }

    /**
     * Create an instance of {@link BuscarProfesores }
     * 
     */
    public BuscarProfesores createBuscarProfesores() {
        return new BuscarProfesores();
    }

    /**
     * Create an instance of {@link VerUsuariosDesactivados }
     * 
     */
    public VerUsuariosDesactivados createVerUsuariosDesactivados() {
        return new VerUsuariosDesactivados();
    }

    /**
     * Create an instance of {@link VerUsuariosActivados }
     * 
     */
    public VerUsuariosActivados createVerUsuariosActivados() {
        return new VerUsuariosActivados();
    }

    /**
     * Create an instance of {@link GetProfesoresResponse }
     * 
     */
    public GetProfesoresResponse createGetProfesoresResponse() {
        return new GetProfesoresResponse();
    }

    /**
     * Create an instance of {@link BusinessException }
     * 
     */
    public BusinessException createBusinessException() {
        return new BusinessException();
    }

    /**
     * Create an instance of {@link ActualizarPasswordResponse }
     * 
     */
    public ActualizarPasswordResponse createActualizarPasswordResponse() {
        return new ActualizarPasswordResponse();
    }

    /**
     * Create an instance of {@link Usuario }
     * 
     */
    public Usuario createUsuario() {
        return new Usuario();
    }

    /**
     * Create an instance of {@link Asignatura }
     * 
     */
    public Asignatura createAsignatura() {
        return new Asignatura();
    }

    /**
     * Create an instance of {@link Matricula }
     * 
     */
    public Matricula createMatricula() {
        return new Matricula();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProfesoresResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.sdi.impl/", name = "getProfesoresResponse")
    public JAXBElement<GetProfesoresResponse> createGetProfesoresResponse(GetProfesoresResponse value) {
        return new JAXBElement<GetProfesoresResponse>(_GetProfesoresResponse_QNAME, GetProfesoresResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerUsuariosDesactivados }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.sdi.impl/", name = "verUsuariosDesactivados")
    public JAXBElement<VerUsuariosDesactivados> createVerUsuariosDesactivados(VerUsuariosDesactivados value) {
        return new JAXBElement<VerUsuariosDesactivados>(_VerUsuariosDesactivados_QNAME, VerUsuariosDesactivados.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerUsuariosActivados }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.sdi.impl/", name = "verUsuariosActivados")
    public JAXBElement<VerUsuariosActivados> createVerUsuariosActivados(VerUsuariosActivados value) {
        return new JAXBElement<VerUsuariosActivados>(_VerUsuariosActivados_QNAME, VerUsuariosActivados.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarProfesores }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.sdi.impl/", name = "buscarProfesores")
    public JAXBElement<BuscarProfesores> createBuscarProfesores(BuscarProfesores value) {
        return new JAXBElement<BuscarProfesores>(_BuscarProfesores_QNAME, BuscarProfesores.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarUsuariosDesactivadosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.sdi.impl/", name = "buscarUsuariosDesactivadosResponse")
    public JAXBElement<BuscarUsuariosDesactivadosResponse> createBuscarUsuariosDesactivadosResponse(BuscarUsuariosDesactivadosResponse value) {
        return new JAXBElement<BuscarUsuariosDesactivadosResponse>(_BuscarUsuariosDesactivadosResponse_QNAME, BuscarUsuariosDesactivadosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProfesores }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.sdi.impl/", name = "getProfesores")
    public JAXBElement<GetProfesores> createGetProfesores(GetProfesores value) {
        return new JAXBElement<GetProfesores>(_GetProfesores_QNAME, GetProfesores.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.sdi.impl/", name = "insertarUsuarioResponse")
    public JAXBElement<InsertarUsuarioResponse> createInsertarUsuarioResponse(InsertarUsuarioResponse value) {
        return new JAXBElement<InsertarUsuarioResponse>(_InsertarUsuarioResponse_QNAME, InsertarUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarNotaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.sdi.impl/", name = "actualizarNotaResponse")
    public JAXBElement<ActualizarNotaResponse> createActualizarNotaResponse(ActualizarNotaResponse value) {
        return new JAXBElement<ActualizarNotaResponse>(_ActualizarNotaResponse_QNAME, ActualizarNotaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerUsuariosDesactivadosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.sdi.impl/", name = "verUsuariosDesactivadosResponse")
    public JAXBElement<VerUsuariosDesactivadosResponse> createVerUsuariosDesactivadosResponse(VerUsuariosDesactivadosResponse value) {
        return new JAXBElement<VerUsuariosDesactivadosResponse>(_VerUsuariosDesactivadosResponse_QNAME, VerUsuariosDesactivadosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarPasswordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.sdi.impl/", name = "actualizarPasswordResponse")
    public JAXBElement<ActualizarPasswordResponse> createActualizarPasswordResponse(ActualizarPasswordResponse value) {
        return new JAXBElement<ActualizarPasswordResponse>(_ActualizarPasswordResponse_QNAME, ActualizarPasswordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BusinessException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.sdi.impl/", name = "BusinessException")
    public JAXBElement<BusinessException> createBusinessException(BusinessException value) {
        return new JAXBElement<BusinessException>(_BusinessException_QNAME, BusinessException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarPerfil }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.sdi.impl/", name = "actualizarPerfil")
    public JAXBElement<ActualizarPerfil> createActualizarPerfil(ActualizarPerfil value) {
        return new JAXBElement<ActualizarPerfil>(_ActualizarPerfil_QNAME, ActualizarPerfil.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarProfesoresResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.sdi.impl/", name = "buscarProfesoresResponse")
    public JAXBElement<BuscarProfesoresResponse> createBuscarProfesoresResponse(BuscarProfesoresResponse value) {
        return new JAXBElement<BuscarProfesoresResponse>(_BuscarProfesoresResponse_QNAME, BuscarProfesoresResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarUsuariosActivadosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.sdi.impl/", name = "buscarUsuariosActivadosResponse")
    public JAXBElement<BuscarUsuariosActivadosResponse> createBuscarUsuariosActivadosResponse(BuscarUsuariosActivadosResponse value) {
        return new JAXBElement<BuscarUsuariosActivadosResponse>(_BuscarUsuariosActivadosResponse_QNAME, BuscarUsuariosActivadosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarUsuariosDesactivados }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.sdi.impl/", name = "buscarUsuariosDesactivados")
    public JAXBElement<BuscarUsuariosDesactivados> createBuscarUsuariosDesactivados(BuscarUsuariosDesactivados value) {
        return new JAXBElement<BuscarUsuariosDesactivados>(_BuscarUsuariosDesactivados_QNAME, BuscarUsuariosDesactivados.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarPerfilResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.sdi.impl/", name = "actualizarPerfilResponse")
    public JAXBElement<ActualizarPerfilResponse> createActualizarPerfilResponse(ActualizarPerfilResponse value) {
        return new JAXBElement<ActualizarPerfilResponse>(_ActualizarPerfilResponse_QNAME, ActualizarPerfilResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivarUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.sdi.impl/", name = "activarUsuarioResponse")
    public JAXBElement<ActivarUsuarioResponse> createActivarUsuarioResponse(ActivarUsuarioResponse value) {
        return new JAXBElement<ActivarUsuarioResponse>(_ActivarUsuarioResponse_QNAME, ActivarUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarPassword }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.sdi.impl/", name = "actualizarPassword")
    public JAXBElement<ActualizarPassword> createActualizarPassword(ActualizarPassword value) {
        return new JAXBElement<ActualizarPassword>(_ActualizarPassword_QNAME, ActualizarPassword.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivarUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.sdi.impl/", name = "activarUsuario")
    public JAXBElement<ActivarUsuario> createActivarUsuario(ActivarUsuario value) {
        return new JAXBElement<ActivarUsuario>(_ActivarUsuario_QNAME, ActivarUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerExpediente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.sdi.impl/", name = "verExpediente")
    public JAXBElement<VerExpediente> createVerExpediente(VerExpediente value) {
        return new JAXBElement<VerExpediente>(_VerExpediente_QNAME, VerExpediente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.sdi.impl/", name = "insertarUsuario")
    public JAXBElement<InsertarUsuario> createInsertarUsuario(InsertarUsuario value) {
        return new JAXBElement<InsertarUsuario>(_InsertarUsuario_QNAME, InsertarUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DesactivarUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.sdi.impl/", name = "desactivarUsuario")
    public JAXBElement<DesactivarUsuario> createDesactivarUsuario(DesactivarUsuario value) {
        return new JAXBElement<DesactivarUsuario>(_DesactivarUsuario_QNAME, DesactivarUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerExpedienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.sdi.impl/", name = "verExpedienteResponse")
    public JAXBElement<VerExpedienteResponse> createVerExpedienteResponse(VerExpedienteResponse value) {
        return new JAXBElement<VerExpedienteResponse>(_VerExpedienteResponse_QNAME, VerExpedienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DesactivarUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.sdi.impl/", name = "desactivarUsuarioResponse")
    public JAXBElement<DesactivarUsuarioResponse> createDesactivarUsuarioResponse(DesactivarUsuarioResponse value) {
        return new JAXBElement<DesactivarUsuarioResponse>(_DesactivarUsuarioResponse_QNAME, DesactivarUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarUsuariosActivados }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.sdi.impl/", name = "buscarUsuariosActivados")
    public JAXBElement<BuscarUsuariosActivados> createBuscarUsuariosActivados(BuscarUsuariosActivados value) {
        return new JAXBElement<BuscarUsuariosActivados>(_BuscarUsuariosActivados_QNAME, BuscarUsuariosActivados.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerUsuariosActivadosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.sdi.impl/", name = "verUsuariosActivadosResponse")
    public JAXBElement<VerUsuariosActivadosResponse> createVerUsuariosActivadosResponse(VerUsuariosActivadosResponse value) {
        return new JAXBElement<VerUsuariosActivadosResponse>(_VerUsuariosActivadosResponse_QNAME, VerUsuariosActivadosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarNota }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.sdi.impl/", name = "actualizarNota")
    public JAXBElement<ActualizarNota> createActualizarNota(ActualizarNota value) {
        return new JAXBElement<ActualizarNota>(_ActualizarNota_QNAME, ActualizarNota.class, null, value);
    }

}
