<html>
	   <head> 
	           <title>FER-Dashboard</title>
	           <script>
	           function submitForm(nextpath){
	        	   
	        	   var form=document.Dashboardform;
	        	   
	        	   form.action=nextpath;
	        	  
	        	   form.submit();
	           }
	           
	           
	           </script>
	   </head>
	           <body>
	           <form action='' name='Dashboardform' method='post'>
	             <table align='center' border='1' height='600px' width='800px'>
	             <tr height='100px'>
	               <td colspan='2' align='center'>
	               Family Expense Report
	               &nbsp;&nbsp;&nbsp;
	               User: ${username}
	               
	</td>
	             </tr>
	              <tr>
	               <td width='150px'> <br><br>
	                 <a href="AddExpense.jsp">AddExpense</a> <br><br>
	                 <a href="EditExpenseOptions.jsp">EditExpense</a> <br><br>
	                 <a href="DeleteExpense.jsp">DeleteExpense</a> <br><br>
	                 <a href="ExpenseReport.jsp">ExpenseReport</a> <br><br>
	                 <a href="ResetPassword.jsp">ResetPassword</a> <br><br>
	                 <a href="NameInfo.jsp">UpdatePersonal</a> <br><br>
	               </td>
	               <td>