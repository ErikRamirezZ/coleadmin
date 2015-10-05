package org.apache.jsp.WEB_002dINF.views.contactoes;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class show_jspx extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/WEB-INF/tags/form/show.tagx");
    _jspx_dependants.add("/WEB-INF/tags/util/panel.tagx");
    _jspx_dependants.add("/WEB-INF/tags/form/fields/display.tagx");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<div version=\"2.0\">");
      if (_jspx_meth_page_show_0(_jspx_page_context))
        return;
      out.write("</div>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_page_show_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  page:show
    org.apache.jsp.tag.web.form.show_tagx _jspx_th_page_show_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.form.show_tagx.class) : new org.apache.jsp.tag.web.form.show_tagx();
    _jspx_th_page_show_0.setJspContext(_jspx_page_context);
    _jspx_th_page_show_0.setZ("jySftth673TXrGLN49O5wamSSWA=");
    _jspx_th_page_show_0.setPath("/contactoes");
    _jspx_th_page_show_0.setObject((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contacto}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_page_show_0.setId("ps_com_raze_coleadmin_catalog_Contacto");
    _jspx_th_page_show_0.setJspBody(new show_jspxHelper( 0, _jspx_page_context, _jspx_th_page_show_0, null));
    _jspx_th_page_show_0.doTag();
    return false;
  }

  private boolean _jspx_meth_field_display_0(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  field:display
    org.apache.jsp.tag.web.form.fields.display_tagx _jspx_th_field_display_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.form.fields.display_tagx.class) : new org.apache.jsp.tag.web.form.fields.display_tagx();
    _jspx_th_field_display_0.setJspContext(_jspx_page_context);
    _jspx_th_field_display_0.setParent(_jspx_parent);
    _jspx_th_field_display_0.setZ("6nTiGvfFCayEIm09z7t0+opCjWM=");
    _jspx_th_field_display_0.setObject((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contacto}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_field_display_0.setId("s_com_raze_coleadmin_catalog_Contacto_tipoContacto");
    _jspx_th_field_display_0.setField("tipoContacto");
    _jspx_th_field_display_0.doTag();
    return false;
  }

  private boolean _jspx_meth_field_display_1(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  field:display
    org.apache.jsp.tag.web.form.fields.display_tagx _jspx_th_field_display_1 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.form.fields.display_tagx.class) : new org.apache.jsp.tag.web.form.fields.display_tagx();
    _jspx_th_field_display_1.setJspContext(_jspx_page_context);
    _jspx_th_field_display_1.setParent(_jspx_parent);
    _jspx_th_field_display_1.setZ("LrkwU26CIqXOpnzQEjaTN5xgN/M=");
    _jspx_th_field_display_1.setObject((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contacto}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_field_display_1.setId("s_com_raze_coleadmin_catalog_Contacto_valor");
    _jspx_th_field_display_1.setField("valor");
    _jspx_th_field_display_1.doTag();
    return false;
  }

  private boolean _jspx_meth_field_display_2(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  field:display
    org.apache.jsp.tag.web.form.fields.display_tagx _jspx_th_field_display_2 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.form.fields.display_tagx.class) : new org.apache.jsp.tag.web.form.fields.display_tagx();
    _jspx_th_field_display_2.setJspContext(_jspx_page_context);
    _jspx_th_field_display_2.setParent(_jspx_parent);
    _jspx_th_field_display_2.setZ("ehKnf3CnXDCJmkimO/bT4PDbiqU=");
    _jspx_th_field_display_2.setObject((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contacto}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_field_display_2.setId("s_com_raze_coleadmin_catalog_Contacto_usuarioCrea");
    _jspx_th_field_display_2.setField("usuarioCrea");
    _jspx_th_field_display_2.doTag();
    return false;
  }

  private boolean _jspx_meth_field_display_3(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  field:display
    org.apache.jsp.tag.web.form.fields.display_tagx _jspx_th_field_display_3 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.form.fields.display_tagx.class) : new org.apache.jsp.tag.web.form.fields.display_tagx();
    _jspx_th_field_display_3.setJspContext(_jspx_page_context);
    _jspx_th_field_display_3.setParent(_jspx_parent);
    _jspx_th_field_display_3.setZ("xVXordf5PL+kQPVdFdzlxoir7UM=");
    _jspx_th_field_display_3.setObject((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contacto}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_field_display_3.setId("s_com_raze_coleadmin_catalog_Contacto_usuarioModifica");
    _jspx_th_field_display_3.setField("usuarioModifica");
    _jspx_th_field_display_3.doTag();
    return false;
  }

  private boolean _jspx_meth_field_display_4(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  field:display
    org.apache.jsp.tag.web.form.fields.display_tagx _jspx_th_field_display_4 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.form.fields.display_tagx.class) : new org.apache.jsp.tag.web.form.fields.display_tagx();
    _jspx_th_field_display_4.setJspContext(_jspx_page_context);
    _jspx_th_field_display_4.setParent(_jspx_parent);
    _jspx_th_field_display_4.setZ("ioDLlZiB5bD7b0hOA9dItvv7F+g=");
    _jspx_th_field_display_4.setObject((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contacto}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_field_display_4.setId("s_com_raze_coleadmin_catalog_Contacto_fechaCreacion");
    _jspx_th_field_display_4.setField("fechaCreacion");
    _jspx_th_field_display_4.setDateTimePattern((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contacto_fechacreacion_date_format}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_field_display_4.setDate(new Boolean(true));
    _jspx_th_field_display_4.doTag();
    return false;
  }

  private boolean _jspx_meth_field_display_5(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  field:display
    org.apache.jsp.tag.web.form.fields.display_tagx _jspx_th_field_display_5 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.form.fields.display_tagx.class) : new org.apache.jsp.tag.web.form.fields.display_tagx();
    _jspx_th_field_display_5.setJspContext(_jspx_page_context);
    _jspx_th_field_display_5.setParent(_jspx_parent);
    _jspx_th_field_display_5.setZ("9jElclBqv5+jKzPQq5Cu8TV54MQ=");
    _jspx_th_field_display_5.setObject((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contacto}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_field_display_5.setId("s_com_raze_coleadmin_catalog_Contacto_fechaModificacion");
    _jspx_th_field_display_5.setField("fechaModificacion");
    _jspx_th_field_display_5.setDateTimePattern((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contacto_fechamodificacion_date_format}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_field_display_5.setDate(new Boolean(true));
    _jspx_th_field_display_5.doTag();
    return false;
  }

  private boolean _jspx_meth_field_display_6(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  field:display
    org.apache.jsp.tag.web.form.fields.display_tagx _jspx_th_field_display_6 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.form.fields.display_tagx.class) : new org.apache.jsp.tag.web.form.fields.display_tagx();
    _jspx_th_field_display_6.setJspContext(_jspx_page_context);
    _jspx_th_field_display_6.setParent(_jspx_parent);
    _jspx_th_field_display_6.setZ("NFZVhZgAbLGtS72cLTx9WJYfkPc=");
    _jspx_th_field_display_6.setObject((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contacto}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_field_display_6.setId("s_com_raze_coleadmin_catalog_Contacto_activo");
    _jspx_th_field_display_6.setField("activo");
    _jspx_th_field_display_6.doTag();
    return false;
  }

  private class show_jspxHelper
      extends org.apache.jasper.runtime.JspFragmentHelper
  {
    private javax.servlet.jsp.tagext.JspTag _jspx_parent;
    private int[] _jspx_push_body_count;

    public show_jspxHelper( int discriminator, JspContext jspContext, javax.servlet.jsp.tagext.JspTag _jspx_parent, int[] _jspx_push_body_count ) {
      super( discriminator, jspContext, _jspx_parent );
      this._jspx_parent = _jspx_parent;
      this._jspx_push_body_count = _jspx_push_body_count;
    }
    public boolean invoke0( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_field_display_0((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_field_display_1((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_field_display_2((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_field_display_3((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_field_display_4((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_field_display_5((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_field_display_6((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public void invoke( java.io.Writer writer )
      throws JspException
    {
      JspWriter out = null;
      if( writer != null ) {
        out = this.jspContext.pushBody(writer);
      } else {
        out = this.jspContext.getOut();
      }
      try {
        switch( this.discriminator ) {
          case 0:
            invoke0( out );
            break;
        }
      }
      catch( Throwable e ) {
        if (e instanceof SkipPageException)
            throw (SkipPageException) e;
        throw new JspException( e );
      }
      finally {
        if( writer != null ) {
          this.jspContext.popBody();
        }
      }
    }
  }
}
