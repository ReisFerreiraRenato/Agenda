<%@page import="model.JavaBeans"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ page import = "model.JavaBeans" %>
 <%@ page import = "java.util.ArrayList" %>
 <%
  ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
 //Teste de recebimento
 /**for (int i = 0; i< lista.size(); i++){
	 out.println(lista.get(i).getIdcon());
	 out.println(lista.get(i).getNome());
	 out.println(lista.get(i).getFone());
	 out.println(lista.get(i).getEmail());
 }**/
 %>
<!DOCTYPE html>
<html lang = "pt-br">
<head>
<meta charset="utf-8">
<title>Agenda de contatos</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body> 
	<h1>Agenda de Contatos</h1>
	<a href="novo.html" class="Botao1">Novo Contato</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>	
				<th>Nome</th>
				<th>Fone</th>
				<th>E-mail</th>
			</tr>
		</thead>
		<tbody>
			<% for (int i = 0; i < lista.size(); i++) { %>
				<tr>
					<td><%=lista.get(i).getIdcon()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td><%=lista.get(i).getFone()%></td>
					<td><%=lista.get(i).getEmail()%></td>
				</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>