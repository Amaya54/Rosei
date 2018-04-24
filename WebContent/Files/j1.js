 var flag=0;
 function drop(id1){
	if(flag==0||flag<0)
	{
		var x=document.createElement('div');
		x.id='newDiv';
		id1.appendChild(x);
		var y="<p>Account Settings</p>"  +"<p>Sign Out</p>";
		x.innerHTML=y;
		flag=2;
	}
	else if(flag==1||flag==2)
	{
	var x=document.getElementById('newDiv');
	id1.removeChild(x);
	flag=0;
	}
 }
  function crop(){
  flag=flag-1;
  if(flag==0)
  {
	var y=document.getElementById('arrow');
	var x=document.getElementById('newDiv');
	y.removeChild(x);
	flag=0;
	}
  }
 function cash(y){
 var x=document.getElementById('bal');
 var z="Rosei Cash"+"<br>"+y;
 x.innerHTML=z;
 }