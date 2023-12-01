<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통계 테스트</title>

 <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
        	
         ['아이디', '지출액'],
         ['2023',442],
         ['2024', 33],
         ['2025', 446]
        	
        	
        	
        	
        	/*  ['아이디', '지출액'],
          ['2013',  1000],
          ['2014',  1170],
          ['2015',  660],
          ['2016',  1030] */
         
        ]);

        var options = {
          title: 'Company Performance',
          hAxis: {title: '지출왕',  titleTextStyle: {color: '#333'}},
          vAxis: {minValue: 0}
        };

        var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
</head>
<body>
	<a href="${pageContext.servletContext.contextPath }/log">뒤로</a>

	<div style="text-align: center;">
		<table border="1" style="margin: 0 auto; width: 1600px; ">
			<tr>
				<th>아이디</th>
				<th>지출액</th>
			</tr>
	
		<c:forEach var="one" items="${maxAmt}">
	
			<tr>
				<td>${one.userId}</td>
				<td>${one.maxA}</td>
			
			</tr>
		</c:forEach>
		</table>
	</div>
	
	
	 <div id="chart_div" style="width: 100%; height: 500px;"></div>
	
	
			
							
			
			
		
		

</body>
</html>