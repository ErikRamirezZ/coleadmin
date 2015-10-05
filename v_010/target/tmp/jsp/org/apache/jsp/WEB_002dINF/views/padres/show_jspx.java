package org.apache.jsp.WEB_002dINF.views.padres;

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
    _jspx_th_page_show_0.setZ("r8tSR/CHAoLQeTK1hN0RdpmoomQ=");
    _jspx_th_page_show_0.setPath("/padres");
    _jspx_th_page_show_0.setObject((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${padre}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_page_show_0.setId("ps_com_raze_coleadmin_domain_Padre");
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
    _jspx_th_field_display_0.setZ("5h5FIdWsvATaCdcyesuUEw/59Uk=");
    _jspx_th_field_display_0.setObject((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${padre}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_field_display_0.setId("s_com_raze_coleadmin_domain_Padre_correoE");
    _jspx_th_field_display_0.setField("correoE");
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
    _jspx_th_field_display_1.setZ("uDcz417W7hENRRE+L++0bqwA0ts=");
    _jspx_th_field_display_1.setObject((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${padre}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_field_display_1.setId("s_com_raze_coleadmin_domain_Padre_password");
    _jspx_th_field_display_1.setField("password");
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
    _jspx_th_field_display_2.setZ("J4bKufpagJWduO5Y/21a0kdrgIo=");
    _jspx_th_field_display_2.setObject((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${padre}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_field_display_2.setId("s_com_raze_coleadmin_domain_Padre_nombre");
    _jspx_th_field_display_2.setField("nombre");
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
    _jspx_th_field_display_3.setZ("0NSViCEUhRvmsSiayNgyzP6bzDo=");
    _jspx_th_field_display_3.setObject((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${padre}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_field_display_3.setId("s_com_raze_coleadmin_domain_Padre_primerApellido");
    _jspx_th_field_display_3.setField("primerApellido");
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
    _jspx_th_field_display_4.setZ("FLh3jqe0O0OamCa4qZWg0VxphJc=");
    _jspx_th_field_display_4.setObject((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${padre}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_field_display_4.setId("s_com_raze_coleadmin_domain_Padre_segundoApellido");
    _jspx_th_field_display_4.setField("segundoApellido");
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
    _jspx_th_field_display_5.setZ("zwe1VyBw7cMv3BCfk21HrNE0RLA=");
    _jspx_th_field_display_5.setObject((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${padre}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_field_display_5.setId("s_com_raze_coleadmin_domain_Padre_fechaNacimiento");
    _jspx_th_field_display_5.setField("fechaNacimiento");
    _jspx_th_field_display_5.setDateTimePattern((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${padre_fechanacimiento_date_format}", java.lang.String.class, (PageContext)_jspx_page_context, null));
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
    _jspx_th_field_display_6.setZ("WsqhZ+nrfqsA51k0xuPEC0i0SRo=");
    _jspx_th_field_display_6.setObject((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${padre}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_field_display_6.setId("s_com_raze_coleadmin_domain_Padre_foto");
    _jspx_th_field_display_6.setField("foto");
    _jspx_th_field_display_6.doTag();
    return false;
  }

  private boolean _jspx_meth_field_display_7(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  field:display
    org.apache.jsp.tag.web.form.fields.display_tagx _jspx_th_field_display_7 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.form.fields.display_tagx.class) : new org.apache.jsp.tag.web.form.fields.display_tagx();
    _jspx_th_field_display_7.setJspContext(_jspx_page_context);
    _jspx_th_field_display_7.setParent(_jspx_parent);
    _jspx_th_field_display_7.setZ("eKDvQbbQntaEioHLSn9y+F/W5yI=");
    _jspx_th_field_display_7.setObject((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${padre}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_field_display_7.setId("s_com_raze_coleadmin_domain_Padre_observaciones");
    _jspx_th_field_display_7.setField("observaciones");
    _jspx_th_field_display_7.doTag();
    return false;
  }

  private boolean _jspx_meth_field_display_8(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  field:display
    org.apache.jsp.tag.web.form.fields.display_tagx _jspx_th_field_display_8 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.form.fields.display_tagx.class) : new org.apache.jsp.tag.web.form.fields.display_tagx();
    _jspx_th_field_display_8.setJspContext(_jspx_page_context);
    _jspx_th_field_display_8.setParent(_jspx_parent);
    _jspx_th_field_display_8.setZ("c1dt0O0A4YJXB1si+W6XKYcLLOM=");
    _jspx_th_field_display_8.setObject((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${padre}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_field_display_8.setId("s_com_raze_coleadmin_domain_Padre_usuarioCrea");
    _jspx_th_field_display_8.setField("usuarioCrea");
    _jspx_th_field_display_8.doTag();
    return false;
  }

  private boolean _jspx_meth_field_display_9(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  field:display
    org.apache.jsp.tag.web.form.fields.display_tagx _jspx_th_field_display_9 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.form.fields.display_tagx.class) : new org.apache.jsp.tag.web.form.fields.display_tagx();
    _jspx_th_field_display_9.setJspContext(_jspx_page_context);
    _jspx_th_field_display_9.setParent(_jspx_parent);
    _jspx_th_field_display_9.setZ("FnIWvZn1fvgsdE5CFfdmZc+LRx8=");
    _jspx_th_field_display_9.setObject((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${padre}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_field_display_9.setId("s_com_raze_coleadmin_domain_Padre_usuarioModifica");
    _jspx_th_field_display_9.setField("usuarioModifica");
    _jspx_th_field_display_9.doTag();
    return false;
  }

  private boolean _jspx_meth_field_display_10(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  field:display
    org.apache.jsp.tag.web.form.fields.display_tagx _jspx_th_field_display_10 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.form.fields.display_tagx.class) : new org.apache.jsp.tag.web.form.fields.display_tagx();
    _jspx_th_field_display_10.setJspContext(_jspx_page_context);
    _jspx_th_field_display_10.setParent(_jspx_parent);
    _jspx_th_field_display_10.setZ("hzkq/3BqBZoeUuL7QuWTe4Civew=");
    _jspx_th_field_display_10.setObject((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${padre}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_field_display_10.setId("s_com_raze_coleadmin_domain_Padre_fechaCreacion");
    _jspx_th_field_display_10.setField("fechaCreacion");
    _jspx_th_field_display_10.setDateTimePattern((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${padre_fechacreacion_date_format}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_field_display_10.setDate(new Boolean(true));
    _jspx_th_field_display_10.doTag();
    return false;
  }

  private boolean _jspx_meth_field_display_11(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  field:display
    org.apache.jsp.tag.web.form.fields.display_tagx _jspx_th_field_display_11 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.form.fields.display_tagx.class) : new org.apache.jsp.tag.web.form.fields.display_tagx();
    _jspx_th_field_display_11.setJspContext(_jspx_page_context);
    _jspx_th_field_display_11.setParent(_jspx_parent);
    _jspx_th_field_display_11.setZ("aq3qGRZdpamOiJ617iEy9whGuHk=");
    _jspx_th_field_display_11.setObject((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${padre}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_field_display_11.setId("s_com_raze_coleadmin_domain_Padre_fechaModificacion");
    _jspx_th_field_display_11.setField("fechaModificacion");
    _jspx_th_field_display_11.setDateTimePattern((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${padre_fechamodificacion_date_format}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_field_display_11.setDate(new Boolean(true));
    _jspx_th_field_display_11.doTag();
    return false;
  }

  private boolean _jspx_meth_field_display_12(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  field:display
    org.apache.jsp.tag.web.form.fields.display_tagx _jspx_th_field_display_12 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.form.fields.display_tagx.class) : new org.apache.jsp.tag.web.form.fields.display_tagx();
    _jspx_th_field_display_12.setJspContext(_jspx_page_context);
    _jspx_th_field_display_12.setParent(_jspx_parent);
    _jspx_th_field_display_12.setZ("WrSq8oG80eMwMOxgK7QxLw7gh3M=");
    _jspx_th_field_display_12.setObject((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${padre}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_field_display_12.setId("s_com_raze_coleadmin_domain_Padre_activo");
    _jspx_th_field_display_12.setField("activo");
    _jspx_th_field_display_12.doTag();
    return false;
  }

  private boolean _jspx_meth_field_display_13(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  field:display
    org.apache.jsp.tag.web.form.fields.display_tagx _jspx_th_field_display_13 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.form.fields.display_tagx.class) : new org.apache.jsp.tag.web.form.fields.display_tagx();
    _jspx_th_field_display_13.setJspContext(_jspx_page_context);
    _jspx_th_field_display_13.setParent(_jspx_parent);
    _jspx_th_field_display_13.setZ("bUtEsOk/asHvY2UndFsx+cxuJuY=");
    _jspx_th_field_display_13.setObject((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${padre}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_field_display_13.setId("s_com_raze_coleadmin_domain_Padre_escuela");
    _jspx_th_field_display_13.setField("escuela");
    _jspx_th_field_display_13.doTag();
    return false;
  }

  private boolean _jspx_meth_field_display_14(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  field:display
    org.apache.jsp.tag.web.form.fields.display_tagx _jspx_th_field_display_14 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.form.fields.display_tagx.class) : new org.apache.jsp.tag.web.form.fields.display_tagx();
    _jspx_th_field_display_14.setJspContext(_jspx_page_context);
    _jspx_th_field_display_14.setParent(_jspx_parent);
    _jspx_th_field_display_14.setZ("WzOhIa8wx6fkY+Qw5qiV38Q8AjE=");
    _jspx_th_field_display_14.setObject((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${padre}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_field_display_14.setId("s_com_raze_coleadmin_domain_Padre_domicilio");
    _jspx_th_field_display_14.setField("domicilio");
    _jspx_th_field_display_14.doTag();
    return false;
  }

  private boolean _jspx_meth_field_display_15(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  field:display
    org.apache.jsp.tag.web.form.fields.display_tagx _jspx_th_field_display_15 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.form.fields.display_tagx.class) : new org.apache.jsp.tag.web.form.fields.display_tagx();
    _jspx_th_field_display_15.setJspContext(_jspx_page_context);
    _jspx_th_field_display_15.setParent(_jspx_parent);
    _jspx_th_field_display_15.setZ("XzotjBLBBDrodp2UrnLUdKn2gmc=");
    _jspx_th_field_display_15.setObject((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${padre}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_field_display_15.setId("s_com_raze_coleadmin_domain_Padre_contactos");
    _jspx_th_field_display_15.setField("contactos");
    _jspx_th_field_display_15.doTag();
    return false;
  }

  private boolean _jspx_meth_field_display_16(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  field:display
    org.apache.jsp.tag.web.form.fields.display_tagx _jspx_th_field_display_16 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.form.fields.display_tagx.class) : new org.apache.jsp.tag.web.form.fields.display_tagx();
    _jspx_th_field_display_16.setJspContext(_jspx_page_context);
    _jspx_th_field_display_16.setParent(_jspx_parent);
    _jspx_th_field_display_16.setZ("vGwF6INGbN4ixwnyV3M05vaXHeY=");
    _jspx_th_field_display_16.setObject((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${padre}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_field_display_16.setId("s_com_raze_coleadmin_domain_Padre_roles");
    _jspx_th_field_display_16.setField("roles");
    _jspx_th_field_display_16.doTag();
    return false;
  }

  private boolean _jspx_meth_field_display_17(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  field:display
    org.apache.jsp.tag.web.form.fields.display_tagx _jspx_th_field_display_17 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.form.fields.display_tagx.class) : new org.apache.jsp.tag.web.form.fields.display_tagx();
    _jspx_th_field_display_17.setJspContext(_jspx_page_context);
    _jspx_th_field_display_17.setParent(_jspx_parent);
    _jspx_th_field_display_17.setZ("zF7pqe9YsETO3RNZRp9HhIjaHbs=");
    _jspx_th_field_display_17.setObject((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${padre}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_field_display_17.setId("s_com_raze_coleadmin_domain_Padre_permisos");
    _jspx_th_field_display_17.setField("permisos");
    _jspx_th_field_display_17.doTag();
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
      if (_jspx_meth_field_display_7((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_field_display_8((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_field_display_9((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_field_display_10((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_field_display_11((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_field_display_12((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_field_display_13((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_field_display_14((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_field_display_15((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_field_display_16((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_field_display_17((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
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
