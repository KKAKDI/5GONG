/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.40
 * Generated at: 2019-05-17 01:55:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.mv_005fboard;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import cuh.mv.board.BoardDTO;

public final class board_005fupdate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("cuh.mv.board.BoardDTO");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      cuh.mv.board.BoardDAO addDAO = null;
      synchronized (application) {
        addDAO = (cuh.mv.board.BoardDAO) _jspx_page_context.getAttribute("addDAO", javax.servlet.jsp.PageContext.APPLICATION_SCOPE);
        if (addDAO == null){
          addDAO = new cuh.mv.board.BoardDAO();
          _jspx_page_context.setAttribute("addDAO", addDAO, javax.servlet.jsp.PageContext.APPLICATION_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      cuh.db.ConnectionPoolBean pool = null;
      synchronized (application) {
        pool = (cuh.db.ConnectionPoolBean) _jspx_page_context.getAttribute("pool", javax.servlet.jsp.PageContext.APPLICATION_SCOPE);
        if (pool == null){
          pool = new cuh.db.ConnectionPoolBean();
          _jspx_page_context.setAttribute("pool", pool, javax.servlet.jsp.PageContext.APPLICATION_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      cuh.mv.board.BoardDTO dto = null;
      dto = (cuh.mv.board.BoardDTO) _jspx_page_context.getAttribute("dto", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (dto == null){
        dto = new cuh.mv.board.BoardDTO();
        _jspx_page_context.setAttribute("dto", dto, javax.servlet.jsp.PageContext.PAGE_SCOPE);
        out.write('\r');
        out.write('\n');
        out.write('	');
        org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("dto"), request);
        out.write('\r');
        out.write('\n');
      }
      out.write("\r\n");
      out.write("\r\n");

	addDAO.setPool(pool);
	BoardDTO dto1 = addDAO.updateForm(dto);
	String method = request.getMethod();
	if (method.equals("GET")) {

      out.write("\r\n");
      out.write("<meta charset=utf-8>\r\n");
      out.write("<center>\r\n");
      out.write("\t<hr width='600' size='2' noshade>\r\n");
      out.write("\t<h2>게시판 with MV</h2>\r\n");
      out.write("\t&nbsp;&nbsp;&nbsp; <a href='board_list.jsp'>글목록</a>\r\n");
      out.write("\t<hr width='600' size='2' noshade>\r\n");
      out.write("\t<form name='f' method='post' action='board_update.jsp'>\r\n");
      out.write("\t\t<input type='hidden' name='seq' value='");
      out.print(dto1.getSeq());
      out.write("'> <input\r\n");
      out.write("\t\t\ttype='hidden' name='writer' value='");
      out.print(dto1.getWriter());
      out.write("'>\r\n");
      out.write("\t\t<table border='1' width='600' align='center' cellpadding='3'\r\n");
      out.write("\t\t\tcellspacing='1'>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width='30%' align='center'>글쓴이</td>\r\n");
      out.write("\t\t\t\t<td align='center'><input type='text' name='aa' size='60'\r\n");
      out.write("\t\t\t\t\tvalue='");
      out.print(dto1.getWriter());
      out.write("' disabled></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width='30%' align='center'>이메일</td>\r\n");
      out.write("\t\t\t\t<td align='center'><input type='text' name='email' size='60'\r\n");
      out.write("\t\t\t\t\tvalue='");
      out.print(dto1.getEmail());
      out.write("'></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width='30%' align='center'>글제목</td>\r\n");
      out.write("\t\t\t\t<td align='center'><input type='text' name='subject' size='60'\r\n");
      out.write("\t\t\t\t\tvalue='");
      out.print(dto1.getSubject());
      out.write("'></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width='30%' align='center'>글내용</td>\r\n");
      out.write("\t\t\t\t<td align='center'><textarea name='content' rows='5' cols='53'>");
      out.print(dto1.getContent());
      out.write("</textarea></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan='2' align='center'><input type='submit' value='수정'>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<hr width='600' size='2' noshade>\r\n");
      out.write("\t<b> <a href='board_update.jsp?seq=");
      out.print(dto1.getSeq());
      out.write("'>수정</a> <a\r\n");
      out.write("\t\thref='board_delete.jsp?seq=");
      out.print(dto1.getSeq());
      out.write("'>삭제</a> <a\r\n");
      out.write("\t\thref='board_list.jsp'>목록</a>\r\n");
      out.write("\t</b>\r\n");
      out.write("\t<hr width='600' size='2' noshade>\r\n");
      out.write("</center>\r\n");

	} else if (method.equals("POST")) {
		addDAO.update(dto);
		response.sendRedirect("board_list.jsp");
	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
