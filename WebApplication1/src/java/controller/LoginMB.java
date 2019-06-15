/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import model.Rol;
import model.Usuario;
import model.UsuarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Usuario
 */
@ManagedBean
@SessionScoped
public class LoginMB {

    private Usuario usuario;
    private Usuario autenticado;

    private UsuarioDAO usuarioDAO;

    FacesContext context;

    HttpServletRequest origRequest;

    public LoginMB() {
        usuario = new Usuario();
        usuarioDAO = new UsuarioDAO();
        context = FacesContext.getCurrentInstance();
        origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
    }

    public String login() throws SQLException {
        this.autenticado = usuarioDAO.login(usuario.getUser(), usuario.getPassword());

        if (autenticado != null) {
            if(autenticado.getRol().equalsIgnoreCase(Rol.ADMINISTRADOR))
            return "admin/home.xhtml?faces-redirect=true";
            if(autenticado.getRol().equalsIgnoreCase(Rol.TECNICO))
            return "usuario/home.xhtml?faces-redirect=true";
            if(autenticado.getRol().equalsIgnoreCase(Rol.CLIENTE))
            return "cliente/home.xhtml?faces-redirect=true";
        }

        return "";
    }

    public void verificar() {
        if (autenticado == null || autenticado.getUser().equals("")) {
          
            String contextPath = origRequest.getContextPath();
            try {
                FacesContext.getCurrentInstance().getExternalContext()
                        .redirect(contextPath + "/faces/Login.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public String logout(){
    
      this.autenticado = null;
      
      return "/Login.xhtml";
        
    }
    
    

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the autenticado
     */
    public Usuario getAutenticado() {
        return autenticado;
    }

    /**
     * @param autenticado the autenticado to set
     */
    public void setAutenticado(Usuario autenticado) {
        this.autenticado = autenticado;
    }

}
