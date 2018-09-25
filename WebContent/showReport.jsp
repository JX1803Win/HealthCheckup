<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script> 
function openmydoc(path) { 
	var doc=new ActiveXObject("Word.Application"); 
	doc.visible=true; 
	doc.Documents.Open(path); 
} 
</script>
</head >
<a href="E:\\培训\\项目\\健康体检散检系统项目\\我的文档\\体检报告1537719968853.doc" onclick="openmydoc('E:\\培训\\项目\\健康体检散检系统项目\\我的文档\\体检报告1537719968853.doc');" 
type="activxobject(word.application)">博客文章 </a>
</html>